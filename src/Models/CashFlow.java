package Models;

public class CashFlow{

    private int id;
    private String fecha;
    private String descripcion;
    private Double monto;
    private String categoria;

    public CashFlow(int id, String fecha, String descripcion, double monto, String categoria) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.categoria = categoria;
    }

    public CashFlow(String fecha, String descripcion, double monto, String categoria) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.categoria = categoria;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.valueOf(getId()) + " " + getFecha() + " " + getDescripcion() + " " + getMonto() + " "+ getCategoria(); 
    }
    
    


}