package modelo;

public class Comida extends Producto {

    private double precio;
    private int calorias;
    private String ingredientes;
    private String alergenos;

    // Constructor, getters y setters
    public Comida(String idProducto, String nombre, int stock, String tipo, double precio, int calorias, String ingredientes, String alergenos) {
        super(idProducto, nombre, stock, tipo);
        this.precio = precio;
        this.calorias = calorias;
        this.ingredientes = ingredientes;
        this.alergenos = alergenos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String alergenos) {
        this.alergenos = alergenos;
    }

    @Override
    public void aplicarDescuento(double porcentajeDescuento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aplicarPromocion(double porcentajeDescuento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
