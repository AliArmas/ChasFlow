package Services;

import Models.User;
import java.sql.*;

public class Conexionbd {
    
    //Connection Example
    
    private String url = "jdbc:mysql://localhost:3306/cashflow?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    private String user = "programacion.react";
    private final String pass = ")pfKHHw3Tn*?$S$T";
    
    private Connection conn;
    
    public void testConnection() {
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (Exception e) {
                System.out.println("Driver error");
            }
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cashFlow?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC", "root", "LgFcdrcdr9685.");
            boolean valid = conn.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");   
        } catch (java.sql.SQLException sqle) {
            System.out.println("Conection error " +sqle);
        }
    }
    
    public void createUser(User newUser){
        
        String query = "INSERT INTO users " + "  (nombres, apellidos, rol, fecha_de_nacimiento, email, password) VALUES " +  " (?, ?, ?, ?, ?, ?);";
        
        try {
            conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement request = conn.prepareStatement(query);
            request.setString(1, newUser.getNombres());
            request.setString(2, newUser.getApellidos());
            request.setString(3, newUser.getRol());
            request.setString(4, newUser.getFecha_de_nacimiento());
            request.setString(5, newUser.getEmail());
            request.setString(6, newUser.getPassword());
            request.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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
