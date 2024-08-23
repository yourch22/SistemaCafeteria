package modelo;

    //Clase abstracta Producto que implementa Promocionable
    public abstract class Producto implements Promocionable {
    //Atributos
    public String id_producto;
    public String nombre;
    public int Stock;
    public String tipo;

    // Método abstracto para obtener el precio del producto
    public abstract double getPrecio();
    // Método abstracto para aplicar un descuento
    public abstract void aplicarDescuento(double porcentajeDescuento);
    //COnstructor parametrizado
    public Producto(String id_producto, String nombre,int Stock, String tipo) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.Stock = Stock;
        this.tipo = tipo;
    }
    // Getters and setters
        public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    //metodo vender
    public String vender(){
        return "El producto se esta vendiendo...";
    }
    //Metodo para mostrar informacion en Producto
    public String mostrarInformacion() {
    StringBuilder info = new StringBuilder();
    info.append("ID: ").append(id_producto).append("\n");
    info.append("Nombre: ").append(nombre).append("\n");
    info.append("Tipo: ").append(tipo).append("\n");
    return info.toString();
}
     
}
