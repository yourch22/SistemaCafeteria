package modelo;
    //Clase Empleado
    public class Empleado {
    //ATRIBUTOS
    private String id_empleado;
    private String nombre;
    private String apellido;
    private int dni;
    private String direccion;
    private String pais;
    private String puesto;
    private String usuario;
    private String clave;

    public Empleado() {
    }
    
    
    //CONSTRUCTOR PARAMETRIZADO
    public Empleado(String id_empleado, String nombre, String apellido, int dni, String direccion, String pais, String puesto,String usuario, String clave) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.pais = pais;
        this.puesto = puesto;
        this.usuario = usuario;
        this.clave = clave;
    }
    //GETS AND SETS
    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    //METODO INFO EMPLEADO
    public String Info(){
        String mensaje="";
        mensaje = "INFORMACION DEL EMPLEADO\n"+
            "\nID: " + id_empleado +
            "\nNombre: " + nombre +
            "\napellido: " + apellido +
            "\nDNI: " + dni +
            "\nDireccion: " + direccion +
            "\nPuesto de Trabajo: " + puesto+
            "\nUsuario de Trabajo: " + usuario+
            "\nContraseña de Trabajo: " + clave;
        return mensaje;
    }
}
