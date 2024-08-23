package modelo;

/**
 *
 * @author Jorge Flores
 */
public class Pedidos {
    private int id_pedido;
    private String producto;
    private int cantidad;
    private double precio;
    private double importe;
    private String id_producto;
    private String id_empleado;
    private String id_cliente;


    public Pedidos() {
    }

    public Pedidos(int id_pedido, int cantidad, double precio, double importe, String id_producto, String id_empleado, String id_cliente) {
        this.id_pedido = id_pedido;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
        this.id_producto = id_producto;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    
}
