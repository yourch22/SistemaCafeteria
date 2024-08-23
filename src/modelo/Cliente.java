package modelo;
    //Clase Cliente
    public class Cliente {
    private String id_cliente;
    private String nombre;
    private String apellido;
    private int DNI;
    private String genero;
    private int numeroCelular;
    private String id_empleado;

    //CONTRUCTOR PARAMETRIZADO
    public Cliente(String id_cliente,String nombre, String apellido, int DNI, String genero, int numeroCelular, String id_empleado) {
        this.id_cliente=id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.genero = genero;
        this.numeroCelular = numeroCelular;
        this.id_empleado = id_empleado;
    }

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //GETS AND SETS
        public String getId_cliente() {
        return id_cliente;
    }

    //ATRIBUTOS
    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }
    //METODO INFO CLIENTE
    public String Info(){
        String mensaje="";
        mensaje = "INFORMACION DEL CLIENTE\n"+
                "\nID: " + id_empleado +
                "\nNombre: " + nombre +
                "\napellido: " + apellido +
                "\nDNI:" + DNI+
                "\nGenero: " + genero+
                "\nNumero: " + numeroCelular;
        return mensaje;
    }
    public String nombreApellidos() {
        return nombre + " " + apellido;
    }
}
