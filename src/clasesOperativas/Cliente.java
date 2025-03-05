package clasesOperativas;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    //Variables de la clase
    private String cveCte;
    private String nombre;
    private String direccion;
    private String rFC;
    private String folio;
    private String Fecha;
    private ArrayList<Producto> productos;
    //Constructor
    public Cliente(String cveCte, String nombre, String direccion, String rFC, String folio, String fecha, ArrayList<Producto> productos) {
        this.cveCte = cveCte;
        this.nombre = nombre;
        this.direccion = direccion;
        this.rFC = rFC;
        this.folio = folio;
        this.Fecha = fecha;
        this.productos = productos;
    }
    //GetSet
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getCveCte() {
        return cveCte;
    }

    public void setCveCte(String cveCte) {
        this.cveCte = cveCte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getrFC() {
        return rFC;
    }

    public void setrFC(String rFC) {
        this.rFC = rFC;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}
