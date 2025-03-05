package clasesOperativas;

import java.io.Serializable;

public class Producto implements Serializable {
    private String Descripcion;
    private int cantidad;
    private double precioUnitario;
    //Constructor
    public Producto(String descripcion, int cantidad, double precioUnitario) {
        Descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    //Get / Set
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    //Metodos de la clase
    public double calcularImporte(){
        return this.getCantidad() * this.getPrecioUnitario();
    }

}
