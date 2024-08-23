package modelo;

/**
 *
 * @author Jorge Flores
 */

public class ModelProductos {
    private String idProducto;
    private String nombre;
    private int stock;
    private String tipo;

    public ModelProductos(String idProducto, String nombre, int stock, String tipo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.tipo = tipo;
    }

    // Getters y setters
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
