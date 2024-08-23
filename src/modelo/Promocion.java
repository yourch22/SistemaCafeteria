/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

//Clase Promocion que implementa Promocionable
public class Promocion implements Promocionable {

    private int id_promocion;
    private String descripcion;
    private double porcentajeDescuento;
    private List<Producto> productosAplicables;

    //Constructor parametrizado
  /*  public Promocion(String descripcion, double porcentajeDescuento, List<Producto> productosAplicables) {
        this.descripcion = descripcion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.productosAplicables = productosAplicables;
    }*/
    public Promocion() {}

    public Promocion(String descripcion, double porcentajeDescuento) {
        this.descripcion = descripcion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    //Gets and Sets
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public List<Producto> getProductosAplicables() {
        return productosAplicables;
    }

    public void setProductosAplicables(List<Producto> productosAplicables) {
        this.productosAplicables = productosAplicables;
    }

    //Override, traido de promocionable
    @Override
    public double getPrecio() {
        double total = 0;
        for (Producto producto : productosAplicables) {
            total += producto.getPrecio();
        }
        return total - total * (porcentajeDescuento / 100);
    }

    //Override, traido de promocionable
    @Override
    public void aplicarPromocion(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
        for (Producto producto : productosAplicables) {
            producto.aplicarPromocion(porcentajeDescuento);
        }
    }

    //Metodo para mostrar informacion de la clase Promocion
    public String getInformacion() {
        StringBuilder info = new StringBuilder();
        info.append("Descripción: ").append(descripcion).append("\n");
        info.append("Porcentaje de descuento: ").append(porcentajeDescuento).append("%\n");
        info.append("Productos aplicables:\n");
        for (Producto producto : productosAplicables) {
            info.append(producto.getNombre()).append(": ").append(producto.getPrecio()).append("\n");
        }
        return info.toString();
    }

}
