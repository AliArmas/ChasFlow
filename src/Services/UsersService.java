package Services;

import Models.User;
import static Services.Conexionbd.printSQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersService {

    private String url = "jdbc:postgresql://localhost:5432/cashflow";
    private String user = "postgres";
    private String pass = "7132";
    private Connection conn;

    public UsersService() {

    }

    public UsersService(String url, String user, String pass, Connection conn) {
        this.url = getUrl();
        this.user = user;
        this.pass = pass;
        this.conn = conn;
    }

    public ArrayList<User> getUsers() {
        String query = "SELECT * FROM users;";
        ArrayList<User> usuarios = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            PreparedStatement request = conn.prepareStatement(query);
            ResultSet response = request.executeQuery();
            while (response.next()) {
                int id = response.getInt("id");
                String names = response.getString("nombres");
                String last_names = response.getString("apellidos");
                String rol = response.getString("rol");
                String birth_date = response.getString("fecha_de_nacimiento");
                String email = response.getString("email");
                String pass = response.getString("password");
                User user = new User(id, names, last_names, rol, birth_date, email, pass);
                usuarios.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return usuarios;
    }

    public void createUser(User newUser) {

        User created = new User();
        String query = "INSERT INTO users " + "  (nombres, apellidos, rol, fecha_de_nacimiento, email, password) VALUES " + " (?, ?, ?, ?, ?, ?);";

        try {
            
            //Create user
            conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement request = conn.prepareStatement(query);
            request.setString(1, newUser.getNombres());
            request.setString(2, newUser.getApellidos());
            request.setString(3, newUser.getRol());
            request.setString(4, newUser.getFecha_de_nacimiento());
            request.setString(5, newUser.getEmail());
            request.setString(6, newUser.getPassword());
            request.executeUpdate();
            
            //GetUser
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User validateLogin(String email, String pass) {

        String query = "Select * From users WHERE email ='" + email + "' AND password='" + pass + "';";
        User current = new User();
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            PreparedStatement request = conn.prepareStatement(query);
            ResultSet response = request.executeQuery();
            while (response.next()) {
                int id = response.getInt("id");
                String names = response.getString("nombres");
                String last_names = response.getString("apellidos");
                String rol = response.getString("rol");
                String birth_date = response.getString("fecha_de_nacimiento");
                String uemail = response.getString("email");
                String upass = response.getString("password");
                current = new User(id, names, last_names, rol, birth_date, email, pass);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return current;
    }

    public boolean validateRegister(String email) {
        String query = "Select * From users WHERE email ='" + email + "';";
        User current = new User();
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            PreparedStatement request = conn.prepareStatement(query);
            ResultSet response = request.executeQuery();
            if (response.next()) {
                return false;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
       return true;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
