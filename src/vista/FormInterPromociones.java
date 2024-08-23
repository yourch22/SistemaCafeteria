package vista;

import conexion.Conexion;
import controlador.PromocionController;
import modelo.Producto;
import modelo.PromocionProduct;
import modelo.Pedidos;
import java.awt.Dimension;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author Jorge Flores
 */
public class FormInterPromociones extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormInterPedidos
     */
    ArrayList<Pedidos> listPedidos = new ArrayList<Pedidos>();
    private JList<String> productList;
    private DefaultListModel<String> productModel;
    private JButton submitButton;
    private List<String> id_producto;
    private List<Integer> id_promocion;
    private JTable table;
    private DefaultTableModel model;
    private PromocionController dao;

    public FormInterPromociones() {
        initComponents();
        this.setSize(new Dimension(776, 835));
        this.setTitle("Nuevos Pedidos");
        dao = new PromocionController();
        id_producto = new ArrayList<>();
        id_promocion = new ArrayList<>();
        lbltiproducto.setVisible(false);
        productModel = new DefaultListModel<>();
        productList = new JList<>(productModel);

        limpiarJtablePromociones();
        loadProductosConPromocion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpcantPromo = new javax.swing.JSpinner();
        btnquitarpromocion = new javax.swing.JButton();
        btnagregarpromocion = new javax.swing.JButton();
        lbltiproducto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtDescripPromocion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListproductos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableproductosenpromocion = new javax.swing.JTable();
        jComboBoxTipoProductPromos = new javax.swing.JComboBox<>();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Promocion:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Promocion %:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jSpcantPromo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jSpcantPromo.setModel(new javax.swing.SpinnerNumberModel(10, 10, 100, 10));
        jSpcantPromo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpcantPromoStateChanged(evt);
            }
        });
        getContentPane().add(jSpcantPromo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 90, 30));

        btnquitarpromocion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnquitarpromocion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminarx32.png"))); // NOI18N
        btnquitarpromocion.setText("Eliminar");
        btnquitarpromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarpromocionActionPerformed(evt);
            }
        });
        getContentPane().add(btnquitarpromocion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 160, 50));

        btnagregarpromocion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnagregarpromocion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregarx32.png"))); // NOI18N
        btnagregarpromocion.setText("Agregar");
        btnagregarpromocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarpromocionActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregarpromocion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 160, 50));

        lbltiproducto.setText("...");
        getContentPane().add(lbltiproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 80, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("REGISTRAR PROMOCIONES");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 740, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Listado Productos en Promocion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Tipo Producto:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 150, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 750, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Registrar Nueva Promocion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 740, 10));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Datos del Producto");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Producto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jTxtDescripPromocion.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        getContentPane().add(jTxtDescripPromocion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 590, -1));

        jListproductos.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jScrollPane2.setViewportView(jListproductos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 470, 160));

        jTableproductosenpromocion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTableproductosenpromocion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Tipo", "Descripción", "Porcentaje Descuento", "Precio Normal", "Precio con Descuento"
            }
        ));
        jTableproductosenpromocion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableproductosenpromocionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableproductosenpromocion);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 750, 340));

        jComboBoxTipoProductPromos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jComboBoxTipoProductPromos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Bebida", "Comida" }));
        jComboBoxTipoProductPromos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoProductPromosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxTipoProductPromos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jSpcantPromoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpcantPromoStateChanged

    }//GEN-LAST:event_jSpcantPromoStateChanged

    private void btnagregarpromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarpromocionActionPerformed

        addPromotion();
    }//GEN-LAST:event_btnagregarpromocionActionPerformed
    private void addPromotion() {
        String description = jTxtDescripPromocion.getText();
        double discount = 0.0;
        try {
            discount = Double.parseDouble(jSpcantPromo.getValue().toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El descuento debe ser un número válido.");
            return;
        }
        int[] selectedIndices = jListproductos.getSelectedIndices();
        List<String> selectedProductIds = new ArrayList<>();
        for (int index : selectedIndices) {
            selectedProductIds.add(id_producto.get(index));
        }

        PromocionProduct promotion = new PromocionProduct(description, discount);
        PromocionController promotionDAO = new PromocionController();
        int promotionId = promotionDAO.addPromotion(promotion);

        if (promotionId != -1) {
            promotionDAO.addPromotionToProducts(promotionId, selectedProductIds);
            JOptionPane.showMessageDialog(null, "Promoción agregada con éxito.");
            // Limpia los campos después de agregar la promoción
            limpiarJtablePromociones();
            loadProductosConPromocion();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar la promoción.");
        }
    }

    private void limpiarCampos() {
        jTxtDescripPromocion.setText("");
        jSpcantPromo.setValue(10); // Valor por defecto o el que desees establecer
        productModel.clear(); // Limpiar el modelo de la lista de productos
        id_producto.clear(); // Limpiar la lista de IDs de productos seleccionados
        productList.clearSelection(); // Desseleccionar todos los productos en la lista
        jComboBoxTipoProductPromos.setSelectedIndex(0); // Deseleccionar el ítem seleccionado en jComboBoxTipoProduct
    }


    private void btnquitarpromocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarpromocionActionPerformed
        int fila = jTableproductosenpromocion.getSelectedRow();
        String id_promocion;
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Promocion no seleccionado");
        } else {
            id_promocion = (String) jTableproductosenpromocion.getValueAt(fila, 0);
            Producto objEliminarPromocion = new Producto(id_promocion, null, 0, null) {
                @Override
                public double getPrecio() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void aplicarDescuento(double porcentajeDescuento) {

                }

                @Override
                public void aplicarPromocion(double porcentajeDescuento) {

                }
            };
            if (id_promocion != null) {
                objEliminarPromocion.setId_producto(id_promocion);
                if (!dao.EliminarPromocion(objEliminarPromocion)) {
                    JOptionPane.showMessageDialog(this, "Error al Eliminar empleado.");

                } else {
                    JOptionPane.showMessageDialog(this, "Promocion Eliminado...");
                    limpiarJtablePromociones();
                    loadProductosConPromocion();
                }
            }
        }
    }//GEN-LAST:event_btnquitarpromocionActionPerformed

    private void jComboBoxTipoProductPromosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoProductPromosActionPerformed
        Conexion conect = new Conexion();
        id_producto = new ArrayList<>();
        productModel = new DefaultListModel<>();
        jListproductos.setModel(productModel);
        String query = "{CALL SP_ListarPromocionProductos(?)}";
        Connection condb = conect.conectar();
        String tipoproduct = jComboBoxTipoProductPromos.getSelectedItem().toString();
        try (CallableStatement stmt = condb.prepareCall(query)) {
            stmt.setString(1, tipoproduct);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                id_producto.add(result.getString("Codigo"));
                productModel.addElement(result.getString("Producto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxTipoProductPromosActionPerformed

    private void jTableproductosenpromocionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableproductosenpromocionMouseClicked

    }//GEN-LAST:event_jTableproductosenpromocionMouseClicked

    public boolean buscarPedido(Pedidos nuevopedido) {
        for (Pedidos listPedido : listPedidos) {
            if (listPedido.getId_pedido() == nuevopedido.getId_pedido()) {
                int nuevacantidad = listPedido.getCantidad() + nuevopedido.getCantidad();
                listPedido.setCantidad(nuevacantidad);
                listPedido.setImporte(listPedido.getPrecio() * nuevacantidad);

                return true;
            }

        }
        return false;
    }

    private void loadProductosConPromocion() {
        // Obtener el modelo de la tabla con los resultados del procedimiento almacenado
        DefaultTableModel tablaPromociones = dao.obtenerProductosConPromocion();

        if (tablaPromociones != null) {
            // Limpiar la tabla existente antes de asignar el nuevo modelo
            limpiarJtablePromociones();

            // Asignar el modelo a la tabla existente
            jTableproductosenpromocion.setModel(tablaPromociones);

            // Imprimir el contenido de la tabla para depuración (opcional)
            for (int i = 0; i < tablaPromociones.getRowCount(); i++) {
                for (int j = 0; j < tablaPromociones.getColumnCount(); j++) {
                    System.out.print(tablaPromociones.getValueAt(i, j) + " ");
                }
                System.out.println();
            }
        }
    }

    private void limpiarJtablePromociones() {

        DefaultTableModel listapedidos = (DefaultTableModel) jTableproductosenpromocion.getModel();
        listapedidos.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarpromocion;
    private javax.swing.JButton btnquitarpromocion;
    private javax.swing.JComboBox<String> jComboBoxTipoProductPromos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jListproductos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpcantPromo;
    private javax.swing.JTable jTableproductosenpromocion;
    private javax.swing.JTextField jTxtDescripPromocion;
    private javax.swing.JLabel lbltiproducto;
    // End of variables declaration//GEN-END:variables
}
