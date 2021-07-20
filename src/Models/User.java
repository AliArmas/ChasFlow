package Models;

public class User{

    private int iD;
    private String nombres;
    private String apellidos;
    private String rol;
    private String fecha_de_nacimiento;
    private String email;
    private String password;

    public User(int iD, String nombres, String apellidos, String rol, String fecha_de_nacimiento, String email, String password) {
        this.iD = iD;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.email = email;
        this.password = password;
    }

    public User() {
    }
    
    

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        String output;
        output = String.valueOf(getiD()) + " " + getNombres() + " " 
                + getApellidos() + " " + getRol() + " " + getFecha_de_nacimiento() + " " + getEmail() + " " + getPassword().hashCode();
        return output;
    }
    
    
    



}