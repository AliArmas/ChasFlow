package Models;

public class Category{

    private int iD;
    private String clasificacion;
    private String categoria;
    private String sub_categoria;

    public Category(int iD, String clasificacion, String categoria, String sub_categoria) {
        this.iD = iD;
        this.clasificacion = clasificacion;
        this.categoria = categoria;
        this.sub_categoria = sub_categoria;
    }

    public Category(String clasificacion, String categoria, String sub_categoria) {
        this.clasificacion = clasificacion;
        this.categoria = categoria;
        this.sub_categoria = sub_categoria;
    }

    public Category() {
    }

    

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSub_categoria() {
        return sub_categoria;
    }

    public void setSub_categoria(String sub_categoria) {
        this.sub_categoria = sub_categoria;
    }

    @Override
    public String toString() {
        return String.valueOf(getiD()) + " " + getClasificacion() + " " + getCategoria() + " " + getSub_categoria();
    }
    
    
    

}
