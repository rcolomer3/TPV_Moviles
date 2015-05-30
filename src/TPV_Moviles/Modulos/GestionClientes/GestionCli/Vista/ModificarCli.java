/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista;

/**
 *
 * @author Raul
 */
public class ModificarCli extends javax.swing.JFrame {

    /**
     * Creates new form RegistroClie
     */
    public ModificarCli() {
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

        jPanel2 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        iconoalta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        etiNombre = new javax.swing.JLabel();
        etiApellidos = new javax.swing.JLabel();
        etiTelefono = new javax.swing.JLabel();
        etiFNacimiento = new javax.swing.JLabel();
        etiUsuario = new javax.swing.JLabel();
        etiEmail = new javax.swing.JLabel();
        etiTipoUser = new javax.swing.JLabel();
        etiEdad = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        dcFnac = new com.toedter.calendar.JDateChooser();
        txtAntiguedad = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cmbTipoUser = new javax.swing.JComboBox();
        btnModificar = new javax.swing.JButton();
        btnVolverMenu = new javax.swing.JButton();
        NoNombre = new javax.swing.JLabel();
        labelAvatar = new javax.swing.JLabel();
        btnCambiarAvatar = new javax.swing.JButton();
        etiFAlta = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        etiPassword = new javax.swing.JLabel();
        dcFalta = new com.toedter.calendar.JDateChooser();
        etiAntiguedad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        NoApellidos = new javax.swing.JLabel();
        NoTelefono = new javax.swing.JLabel();
        NOFNAC = new javax.swing.JLabel();
        NOFALTA = new javax.swing.JLabel();
        NoEmail = new javax.swing.JLabel();
        NoUsuario = new javax.swing.JLabel();
        NoPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelFotoUsuario = new javax.swing.JLabel();
        etiNomUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iconoalta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cliente.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiNombre.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiNombre.setForeground(java.awt.Color.orange);
        etiNombre.setText("Nombre:");
        jPanel1.add(etiNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 33, -1, -1));

        etiApellidos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiApellidos.setForeground(java.awt.Color.orange);
        etiApellidos.setText("Apellidos:");
        jPanel1.add(etiApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 75, -1, -1));

        etiTelefono.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiTelefono.setForeground(java.awt.Color.orange);
        etiTelefono.setText("Telefono:");
        jPanel1.add(etiTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 128, -1, -1));

        etiFNacimiento.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiFNacimiento.setForeground(java.awt.Color.orange);
        etiFNacimiento.setText("Fecha Nacimiento:");
        jPanel1.add(etiFNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 174, -1, -1));

        etiUsuario.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiUsuario.setForeground(java.awt.Color.orange);
        etiUsuario.setText("Usuario:");
        jPanel1.add(etiUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 302, -1, -1));

        etiEmail.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiEmail.setForeground(java.awt.Color.orange);
        etiEmail.setText("Email:");
        jPanel1.add(etiEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 314, -1, -1));

        etiTipoUser.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiTipoUser.setForeground(java.awt.Color.orange);
        etiTipoUser.setText("Tipo Usuario:");
        jPanel1.add(etiTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 364, -1, -1));

        etiEdad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiEdad.setForeground(java.awt.Color.orange);
        etiEdad.setText("Edad:");
        jPanel1.add(etiEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 264, -1, -1));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 124, 161, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 31, 161, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 73, 161, -1));

        dcFnac.setDateFormatString("dd-MM-yyyy");
        jPanel1.add(dcFnac, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 174, 161, -1));

        txtAntiguedad.setEditable(false);
        jPanel1.add(txtAntiguedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 264, 42, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 314, 161, -1));

        cmbTipoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente", "Administrador" }));
        jPanel1.add(cmbTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 364, 123, -1));

        btnModificar.setText("Actualizar Datos");
        btnModificar.setOpaque(false);
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        btnVolverMenu.setText("Ir al Menu ");
        btnVolverMenu.setOpaque(false);
        jPanel1.add(btnVolverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, -1, -1));

        NoNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png"))); // NOI18N
        jPanel1.add(NoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 31, -1, 20));

        labelAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelAvatar.setOpaque(true);
        jPanel1.add(labelAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 31, 100, 112));

        btnCambiarAvatar.setText("Cambiar");
        btnCambiarAvatar.setOpaque(false);
        jPanel1.add(btnCambiarAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 90, -1));

        etiFAlta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiFAlta.setForeground(java.awt.Color.orange);
        etiFAlta.setText("Fecha Alta:");
        jPanel1.add(etiFAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 224, -1, -1));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 301, 106, -1));

        etiPassword.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiPassword.setForeground(java.awt.Color.orange);
        etiPassword.setText("Password:");
        jPanel1.add(etiPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        dcFalta.setDateFormatString("dd-MM-yyyy");
        jPanel1.add(dcFalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 224, 161, -1));

        etiAntiguedad.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        etiAntiguedad.setForeground(java.awt.Color.orange);
        etiAntiguedad.setText("Antig:");
        jPanel1.add(etiAntiguedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 264, -1, -1));

        txtEdad.setEditable(false);
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 264, 42, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.setOpaque(false);
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        NoApellidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png"))); // NOI18N
        jPanel1.add(NoApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 73, -1, 20));

        NoTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png"))); // NOI18N
        jPanel1.add(NoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 124, -1, 20));

        NOFNAC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png"))); // NOI18N
        jPanel1.add(NOFNAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 174, -1, 20));

        NOFALTA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png"))); // NOI18N
        jPanel1.add(NOFALTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 224, -1, 20));

        NoEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png"))); // NOI18N
        jPanel1.add(NoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 314, -1, 20));

        NoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png"))); // NOI18N
        jPanel1.add(NoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 301, -1, 20));

        NoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TPV_Moviles/Img/cancel.png"))); // NOI18N
        jPanel1.add(NoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 364, -1, 20));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 100, -1));

        btnVolver.setText("Ir Pager");
        btnVolver.setOpaque(false);
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.green);
        jLabel1.setText("Modificar Empleado Fijo");

        labelFotoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelFotoUsuario.setOpaque(true);

        etiNomUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        etiNomUsuario.setForeground(java.awt.Color.blue);
        etiNomUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(etiNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconoalta, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addComponent(iconoalta, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jLayeredPane2.setLayer(iconoalta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(labelFotoUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(etiNomUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel NOFALTA;
    public static javax.swing.JLabel NOFNAC;
    public static javax.swing.JLabel NoApellidos;
    public static javax.swing.JLabel NoEmail;
    public static javax.swing.JLabel NoNombre;
    public static javax.swing.JLabel NoPassword;
    public static javax.swing.JLabel NoTelefono;
    public static javax.swing.JLabel NoUsuario;
    public static javax.swing.JButton btnCambiarAvatar;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnModificar;
    public static javax.swing.JButton btnVolver;
    public static javax.swing.JButton btnVolverMenu;
    public static javax.swing.JComboBox cmbTipoUser;
    public static com.toedter.calendar.JDateChooser dcFalta;
    public static com.toedter.calendar.JDateChooser dcFnac;
    private javax.swing.JLabel etiAntiguedad;
    private javax.swing.JLabel etiApellidos;
    private javax.swing.JLabel etiEdad;
    private javax.swing.JLabel etiEmail;
    private javax.swing.JLabel etiFAlta;
    private javax.swing.JLabel etiFNacimiento;
    public static javax.swing.JLabel etiNomUsuario;
    private javax.swing.JLabel etiNombre;
    private javax.swing.JLabel etiPassword;
    private javax.swing.JLabel etiTelefono;
    public static javax.swing.JLabel etiTipoUser;
    private javax.swing.JLabel etiUsuario;
    private javax.swing.JLabel iconoalta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel labelAvatar;
    public static javax.swing.JLabel labelFotoUsuario;
    public static javax.swing.JTextField txtAntiguedad;
    public static javax.swing.JTextField txtApellidos;
    public static javax.swing.JTextField txtEdad;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JPasswordField txtPassword;
    public static javax.swing.JTextField txtTelefono;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
