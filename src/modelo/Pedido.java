package modelo;

import java.util.ArrayList;// Importamos ArrayList
import java.util.List;// Importamos List
    //Clase Pedido
    public class Pedido {
    private String id_pedido;
    private String id_producto;
      private String id_empleado;
    private double Precio;
    private double importe;
    
    private Cliente cliente;
    private List<Producto> productos;
    //CONTRUCTOR PARAMETRIZADO
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }
    //GETS AND SETS
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    //METODOS
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double getTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
    //METODO INFO PEDIDO
    public String Info(){
        String mensaje="";
        mensaje = "PEDIDO\n"+
                "\nCliente: " + cliente +
                "\nAdcnl: " + productos;
        return mensaje;
    }
}
