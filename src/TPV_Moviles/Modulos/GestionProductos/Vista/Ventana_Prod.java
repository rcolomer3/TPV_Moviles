/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Vista;

/**
 *
 * @author Raul
 */
public class Ventana_Prod extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Prod
     */
    public Ventana_Prod() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        primero = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        CAJA = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        ultimo = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combobox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabelFotoProd = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCompra = new javax.swing.JButton();
        txtRef = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnVerPedi = new javax.swing.JButton();
        etiModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        buscadorP = new javax.swing.JTextField();
        contFiltrar = new javax.swing.JLabel();
        btnAnyadir = new javax.swing.JButton();
        btnModif = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnPrecioBarato_Caro = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnPrecioMedio = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        fotoUsu = new javax.swing.JLabel();
        labNombre = new javax.swing.JLabel();
        txtcese = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelProd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaProductos);

        panelProd.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, 332, 372));

        primero.setBackground(java.awt.Color.white);
        primero.setText("<<");
        primero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelProd.add(primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 405, 85, 25));

        anterior.setBackground(java.awt.Color.white);
        anterior.setText("<");
        anterior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelProd.add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 436, 85, 25));

        CAJA.setEditable(false);
        CAJA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CAJA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelProd.add(CAJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 436, 150, 25));

        jPanel3.setToolTipText("CENTER");
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panelProd.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 405, -1, -1));

        ultimo.setBackground(java.awt.Color.white);
        ultimo.setText(">>");
        ultimo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelProd.add(ultimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 405, 85, 25));

        siguiente.setBackground(java.awt.Color.white);
        siguiente.setText(">");
        siguiente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelProd.add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 436, 85, 25));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setForeground(java.awt.Color.orange);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mostrar");
        panelProd.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 75, -1));

        combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "50", "100" }));
        panelProd.add(combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 75, -1));

        jLabel4.setForeground(java.awt.Color.orange);
        jLabel4.setText("SELECCIONE UN PRODUCTO DE LA LISTA DE LA IZQUIERDA:");
        panelProd.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 383, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.orange));
        jPanel4.setOpaque(false);

        txtMarca.setEditable(false);
        txtMarca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDescripcion.setEditable(false);
        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelFotoProd.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.orange));
        jLabelFotoProd.setOpaque(true);

        txtPrecio.setEditable(false);
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCompra.setText("Realizar Compra");
        btnCompra.setOpaque(false);

        txtRef.setEditable(false);
        txtRef.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRef.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setForeground(java.awt.Color.orange);
        jLabel10.setText("Referencia:");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(java.awt.Color.orange);
        jLabel1.setText("Precio:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(java.awt.Color.orange);
        jLabel3.setText("Marca:");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setForeground(java.awt.Color.orange);
        jLabel12.setText("Descripcion:");

        btnVerPedi.setText("Ver Pager Pedidos");
        btnVerPedi.setOpaque(false);

        etiModelo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiModelo.setForeground(java.awt.Color.orange);
        etiModelo.setText("Modelo:");

        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerPedi)
                .addGap(18, 18, 18)
                .addComponent(btnCompra)
                .addGap(20, 20, 20))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addComponent(jLabel6))
                                            .addComponent(jLabel8)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabelFotoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(97, 97, 97)
                                            .addComponent(jLabel1))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(104, 104, 104)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiModelo)
                                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .addComponent(txtRef))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel7)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel9)
                                .addGap(83, 83, 83))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(etiModelo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(txtModelo))
                                .addGap(40, 40, 40))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelFotoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompra)
                    .addComponent(btnVerPedi))
                .addGap(26, 26, 26))
        );

        panelProd.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 560, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel13.setForeground(java.awt.Color.orange);
        jLabel13.setText("Filtra por Marca:");
        panelProd.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, -1, -1));
        panelProd.add(buscadorP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 438, 100, -1));

        contFiltrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        contFiltrar.setForeground(java.awt.Color.orange);
        contFiltrar.setText("Filtrar");
        panelProd.add(contFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, -1, -1));

        btnAnyadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/edit_add_NS.png"))); // NOI18N
        btnAnyadir.setOpaque(false);
        panelProd.add(btnAnyadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 39, 35));

        btnModif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/color_line_NS.png"))); // NOI18N
        btnModif.setOpaque(false);
        panelProd.add(btnModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 39, 32));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel_NS.png"))); // NOI18N
        btnEliminar.setOpaque(false);
        panelProd.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 39, 32));

        btnPrecioBarato_Caro.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btnPrecioBarato_Caro.setText("PrecioBarato/Caro");
        btnPrecioBarato_Caro.setOpaque(false);
        panelProd.add(btnPrecioBarato_Caro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 130, 32));

        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/info_NS.png"))); // NOI18N
        btnInfo.setOpaque(false);
        panelProd.add(btnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 39, 32));

        btnPrecioMedio.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btnPrecioMedio.setText("Precio Medio");
        btnPrecioMedio.setOpaque(false);
        panelProd.add(btnPrecioMedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 120, 32));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/volver_NS.png"))); // NOI18N
        btnVolver.setOpaque(false);
        panelProd.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 470, -1, -1));

        fotoUsu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fotoUsu.setOpaque(true);
        panelProd.add(fotoUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, 50, 40));

        labNombre.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        labNombre.setForeground(java.awt.Color.orange);
        panelProd.add(labNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 50, 20));

        txtcese.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtcese.setForeground(java.awt.Color.orange);
        panelProd.add(txtcese, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 110, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/fondo7.jpg"))); // NOI18N
        panelProd.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField CAJA;
    public static javax.swing.JTable TablaProductos;
    public static javax.swing.JButton anterior;
    public static javax.swing.JButton btnAnyadir;
    public static javax.swing.JButton btnCompra;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnInfo;
    public static javax.swing.JButton btnModif;
    public static javax.swing.JButton btnPrecioBarato_Caro;
    public static javax.swing.JButton btnPrecioMedio;
    public static javax.swing.JButton btnVerPedi;
    public static javax.swing.JButton btnVolver;
    public static javax.swing.JTextField buscadorP;
    public static javax.swing.JComboBox combobox;
    public static javax.swing.JLabel contFiltrar;
    public static javax.swing.JLabel etiModelo;
    public static javax.swing.JLabel fotoUsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelFotoProd;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel labNombre;
    public static javax.swing.JPanel panelProd;
    public static javax.swing.JButton primero;
    public static javax.swing.JButton siguiente;
    public static javax.swing.JTextField txtDescripcion;
    public static javax.swing.JTextField txtMarca;
    public static javax.swing.JTextField txtModelo;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtRef;
    public static javax.swing.JLabel txtcese;
    public static javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables
}
