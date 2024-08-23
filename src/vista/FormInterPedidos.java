package vista;
import conexion.Conexion;
import controlador.clienteController;
import controlador.productoController;
import modelo.Bebida;
import modelo.Cliente;
import modelo.Pedidos;
import java.awt.Dimension;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge Flores
 */
public class FormInterPedidos extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormInterPedidos
     */
    private String tipo;
    DefaultTableModel modelopedido = new DefaultTableModel();
    ArrayList<Pedidos> listPedidos = new ArrayList<Pedidos>();
    private clienteController controladorCliente;
    int cantidad;
    double precio;

    public FormInterPedidos() {
        initComponents();
        controladorCliente = new clienteController();
        this.setSize(new Dimension(780, 680));
        this.setTitle("Nuevos Pedidos");
        modelopedido.addColumn("Codigo");
        modelopedido.addColumn("Producto");
        modelopedido.addColumn("Precio U.");
        modelopedido.addColumn("Cantidad");
        modelopedido.addColumn("Importe");
        actualizarTablaPedidos();
        cargarComboClientes();
        lbltiproducto.setVisible(false);
    }

    public void TipoProduto(String tipoproducto) {
        this.tipo = tipoproducto;
        llenarComboProductos();
        //jComboBoxProductos.addItem(tipoproducto);
    }

    public void calcularprecio() {

    }

    private void llenarComboProductos() {
        List<Bebida> bebidas = productoController.ListarPorductosBebida(tipo);
        DefaultComboBoxModel comboProductos = (DefaultComboBoxModel) jComboBoxProductos.getModel();
        for (Bebida prodctBebida : bebidas) {
            String item = prodctBebida.getNombre();
            comboProductos.addElement(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jSpcantidad = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        lblprecio = new javax.swing.JLabel();
        lblimporte = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblsubtotal = new javax.swing.JLabel();
        lbligv = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        btnquitar = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        lbltiproducto = new javax.swing.JLabel();
        btncancelarpedido = new javax.swing.JButton();
        btnguardarpedido = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBoxClientes = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Producto:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jComboBoxProductos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Producto" }));
        jComboBoxProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 220, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jSpcantidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jSpcantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        jSpcantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpcantidadStateChanged(evt);
            }
        });
        getContentPane().add(jSpcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 220, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Importe:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        lblprecio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblprecio.setText("S/.0.00");
        getContentPane().add(lblprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 80, 30));

        lblimporte.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblimporte.setText("S/.0.00");
        getContentPane().add(lblimporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 80, 30));

        jTablePedidos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Precio", "Cantidad", "Importe"
            }
        ));
        jScrollPane1.setViewportView(jTablePedidos);
        if (jTablePedidos.getColumnModel().getColumnCount() > 0) {
            jTablePedidos.getColumnModel().getColumn(1).setPreferredWidth(220);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 740, 220));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Subtotal");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("IGV");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 590, -1, -1));

        lblsubtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblsubtotal.setText("S/.0.00");
        getContentPane().add(lblsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, -1, -1));

        lbligv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbligv.setText("S/.0.00");
        getContentPane().add(lbligv, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 590, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Total");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 620, -1, -1));

        lbltotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbltotal.setText("S/.0.00");
        getContentPane().add(lbltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 620, -1, -1));

        btnquitar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnquitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comercio-electronico.png"))); // NOI18N
        btnquitar.setText("Eliminar");
        btnquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnquitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 140, 40));

        btnagregar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comercio-electronico.png"))); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 140, 40));

        lbltiproducto.setText("...");
        getContentPane().add(lbltiproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 80, 20));

        btncancelarpedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btncancelarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarpedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btncancelarpedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 80, 70));

        btnguardarpedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compra.png"))); // NOI18N
        btnguardarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarpedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnguardarpedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 80, 70));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("REGISTRAR PEDIDOS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Precio:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 740, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Listado Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 270, -1));

        jComboBoxClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBoxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Cliente" }));
        jComboBoxClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 220, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Cliente:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 105, 130, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 750, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Datos del Cliente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 740, 10));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Datos del Producto");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductosActionPerformed
        Conexion conect = new Conexion();
        String query = "{CALL SP_ListarProductosdetalle(?)}";
        Connection condb = conect.conectar();
        double importe = 0.00;
        try (CallableStatement stmt = condb.prepareCall(query)) {
            stmt.setString(1, jComboBoxProductos.getSelectedItem().toString());
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                if ("Bebida".equals(result.getString("tipo"))) {
                    lblprecio.setText(result.getString("Precio Bebida"));
                    lblimporte.setText(result.getString("Precio Bebida"));
                } else {
                    lblprecio.setText(result.getString("Precio Comida"));
                    lblimporte.setText(result.getString("Precio Comida"));
                }
                lbltiproducto.setText(result.getString("Codigo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxProductosActionPerformed

    private void jSpcantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpcantidadStateChanged
        double importe, precio, cantidad;
        precio = Double.parseDouble(lblprecio.getText());
        cantidad = Double.parseDouble(jSpcantidad.getValue().toString());
        importe = cantidad * precio;
        lblimporte.setText(String.format("%.2f", importe));
    }//GEN-LAST:event_jSpcantidadStateChanged

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        Pedidos pedidos = new Pedidos();
        pedidos.setId_pedido(jComboBoxProductos.getSelectedIndex());
        pedidos.setProducto((String) jComboBoxProductos.getSelectedItem());
        pedidos.setId_producto(lbltiproducto.getText());
        pedidos.setPrecio(Double.parseDouble(lblprecio.getText()));
        pedidos.setCantidad(Integer.parseInt(jSpcantidad.getValue().toString()));
        pedidos.setImporte(Double.parseDouble(lblimporte.getText()));
        if (!buscarPedido(pedidos)) {
            listPedidos.add(pedidos);
        }
        actualizarTablaPedidos();
        limpiarPedidos();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarActionPerformed
        int selectedRow = jTablePedidos.getSelectedRow();
        if (selectedRow != -1) { // Verificar que se ha seleccionado una fila
            modelopedido.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
        }
    }//GEN-LAST:event_btnquitarActionPerformed

    private void btncancelarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarpedidoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarpedidoActionPerformed

    private void btnguardarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarpedidoActionPerformed
        // Suponiendo que tienes una tabla llamada ventasTable
        DefaultTableModel model = (DefaultTableModel) jTablePedidos.getModel();

        Conexion conectdb = new Conexion();
        Connection condb = (Connection) conectdb.conectar();

        try {
            // Establecer la conexión
            CallableStatement cs = condb.prepareCall("{call sP_InsertarPedido(?,?,?,?,?,?)}");

            // Iterar sobre las filas de la tabla y guardar cada registro
            for (int i = 0; i < model.getRowCount(); i++) {
                String cliente = jComboBoxClientes.getSelectedItem().toString();
                double precio = Double.parseDouble(model.getValueAt(i, 2).toString().replace("S/.", ""));
                int cantidad = Integer.parseInt(model.getValueAt(i, 3).toString());
                double importe = Double.parseDouble(model.getValueAt(i, 4).toString().replace("S/.", ""));
                String id_producto = model.getValueAt(i, 0).toString().trim();
                String id_empleado = "E001";
                String id_cliente = cliente.substring(0, Math.min(cliente.length(), 4));

                cs.setInt(1, cantidad);
                cs.setDouble(2, precio);
                cs.setDouble(3, importe);
                cs.setString(4, id_producto);
                cs.setString(5, id_empleado);
                cs.setString(6, id_cliente);

                // Ejecutar la consulta
                cs.addBatch();
            }

            // Ejecutar el batch de consultas
            cs.executeBatch();
            JOptionPane.showMessageDialog(null, "Pedido guardados exitosamente.");
            limpiarJtableCliente();
            jComboBoxClientes.setSelectedIndex(0);
            lblsubtotal.setText("S/.0.00");
            lbligv.setText("S/.0.00");
            lbltotal.setText("S/.0.00");
            lblprecio.setText("S/.0.00");
            lblimporte.setText("S/.0.00");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnguardarpedidoActionPerformed
    private void limpiarJtableCliente() {
        DefaultTableModel tablapedidos = (DefaultTableModel) jTablePedidos.getModel();
        tablapedidos.setRowCount(0);
    }

    private void cargarComboClientes() {
        List<Cliente> clientes = controladorCliente.ListarClientes();
        DefaultComboBoxModel comboClientes = (DefaultComboBoxModel) jComboBoxClientes.getModel();
        for (Cliente cliente : clientes) {
            String item = cliente.getId_cliente() + " " + cliente.nombreApellidos();
            comboClientes.addElement(item);
        }
    }
    private void jComboBoxClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxClientesActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    public String moneda(double precio) {
        return " S/." + Math.round(precio * 100.0) / 100.0;
    }

    public void actualizarTablaPedidos() {
        while (modelopedido.getRowCount() > 0) {
            modelopedido.removeRow(0);
        }
        double subtotal = 0;
        for (Pedidos listPedido : listPedidos) {
            Object x[] = new Object[5];
            x[0] = listPedido.getId_producto();
            x[1] = listPedido.getProducto();
            x[2] = moneda(listPedido.getPrecio());
            x[3] = listPedido.getCantidad();
            x[4] = moneda(listPedido.getImporte());
            subtotal += listPedido.getImporte();
            modelopedido.addRow(x);

        }
        double igv = subtotal * 0.18;
        double total = subtotal + igv;
        lblsubtotal.setText(moneda(subtotal));
        lbligv.setText(moneda(igv));
        lbltotal.setText(moneda(total));
        jTablePedidos.setModel(modelopedido);
        
    }

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

    public void limpiarPedidos() {
        lblimporte.setText(lblprecio.getText());
        jComboBoxProductos.setSelectedIndex(0);
        jSpcantidad.setValue(1);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncancelarpedido;
    private javax.swing.JButton btnguardarpedido;
    private javax.swing.JButton btnquitar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxClientes;
    private javax.swing.JComboBox<String> jComboBoxProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpcantidad;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbligv;
    private javax.swing.JLabel lblimporte;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lblsubtotal;
    private javax.swing.JLabel lbltiproducto;
    private javax.swing.JLabel lbltotal;
    // End of variables declaration//GEN-END:variables
}
