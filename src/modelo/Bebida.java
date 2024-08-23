package modelo;

public class Bebida extends Producto {

    private double precio;
    private double volumen;
    private boolean alcoholica;

    // Constructor, getters y setters
    public Bebida(String idProducto, String nombre, int stock, String tipo, double precio, double volumen, boolean alcoholica) {
        super(idProducto, nombre, stock, tipo);
        this.precio = precio;
        this.volumen = volumen;
        this.alcoholica = alcoholica;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public boolean isAlcoholica() {
        return alcoholica;
    }

    public void setAlcoholica(boolean alcoholica) {
        this.alcoholica = alcoholica;
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
