package ui;

import controller.LibroDAO;
import controller.PeriodicoDAO;

import abstracciones.Login;
import abstracciones.Libro;
import abstracciones.Periodico;
import abstracciones.Ubicacion;
import abstracciones.Articulo;
import abstracciones.ArticuloCientifico;
import abstracciones.Revista;
import abstracciones.Usuario;
import abstracciones.VideoCientifico;
import controller.RevistaDAO;
import controller.ArticuloIDAO;
import controller.PrestamoDAO;
import controller.RegistroUsuarioDAO;
import controller.VideoDAO;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import utils.Conexion;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author alejandro ameneyro
 */
public class Dashboard extends javax.swing.JFrame {
    
    Login logg = new Login();
    
    private ArrayList<Articulo> art = new ArrayList<>();
    
    DefaultTableModel modeloLibro;
    DefaultTableModel modeloPeriodico;
    DefaultTableModel modeloRevista;
    DefaultTableModel modeloArtIn;
    DefaultTableModel modeloVideo;
    DefaultTableModel modeloUsuario;
    DefaultTableModel modeloPrestamo;
    
    public Dashboard(Login lg) {
        initComponents();
        System.out.println(lg.getPerfil());
        if(!lg.getPerfil().equals("admin")){
            jTabbedPane1.setEnabledAt(5, false);
            jTabbedPane1.setEnabledAt(6, false);
            jTabbedPane1.setEnabledAt(7, false);
            jTabbedPane1.setEnabledAt(8, false);
            jTabbedPane1.setEnabledAt(9, false);
            jTabbedPane1.setEnabledAt(10, false);
            jTabbedPane1.setEnabledAt(11, false);
            
            txtPre.setVisible(false);
            btnPrestamo.setVisible(false);
            txtPre1.setVisible(false);
            btnPrestamo1.setVisible(false);
            txtPre2.setVisible(false);
            btnPrestamo2.setVisible(false);
            txtPre3.setVisible(false);
            btnPrestamo3.setVisible(false);
            txtPre4.setVisible(false);
            btnPrestamo4.setVisible(false);
            
            jLabel52.setVisible(false);
            jLabel70.setVisible(false);
            jLabel73.setVisible(false);
            jLabel75.setVisible(false);
            jLabel77.setVisible(false);
            //jTabbedPane1.setEnabledAt(6, false);
        }
        
        LibroDAO l = new LibroDAO();
        PeriodicoDAO p = new PeriodicoDAO();
        RevistaDAO r = new RevistaDAO();
        ArticuloIDAO ai = new ArticuloIDAO();
        VideoDAO vi = new VideoDAO();
        RegistroUsuarioDAO reu= new RegistroUsuarioDAO();
        PrestamoDAO pr = new PrestamoDAO();
        
        String[] tituloLibro = {"titulo","editorial","pasta","volumen","tipoLibro","autores","fecha de lanzamiento","idioma","cantidad","cantidadTotal","pasillo","repisa","anaquel","seccion","idE","idT","idU"};        String[] tituloPeriodico = {"nombre","distribuidor","empresa","tipo de revista","fecha de lanzamiento","idioma","cantidad","cantidadTotal","pasillo","repisa","anaquel","seccion","idE","idT","idU"};
        String[] tituloRevista = {"nombre","distribuidor","empresa","tipo de revista","fecha de lanzamiento","idioma","cantidad","cantidadTotal","pasillo","repisa","anaquel","seccion","idE","idT","idU"};
        String[] tituloArtIn = {"nombre del art","area de especialidad","fecha escritura","instituto de proveniencia","autores","fecha de lanzamiento","idioma","cantidad","cantidadTotal","pasillo","repisa","anaquel","seccion","idE","idT","idU"};
        String[] tituloVideo = {"nombre","duracion","autores","fecha de lanzamiento","idioma","cantidad","cantidadTotal","pasillo","repisa","anaquel","seccion","idE","idT","idU"};
        String[] tituloUsuario = {"id","nombreusuario","nombre","a.Paterno","a.materno","perfil","direccion","teléfono"};
        String[] tituloPrestamos = {"nombreusuario","fechaPrestamo","fechaEntrega","estadoEntrega","EstadoUsuario","idP","idE","idUs"};

        
        modeloLibro = new DefaultTableModel(null,tituloLibro);
        modeloPeriodico = new DefaultTableModel(null,tituloPeriodico);
        modeloRevista = new DefaultTableModel(null,tituloRevista);
        modeloArtIn = new DefaultTableModel(null,tituloArtIn);
        modeloVideo = new DefaultTableModel(null,tituloVideo);
        modeloUsuario = new DefaultTableModel(null, tituloUsuario);
        modeloPrestamo = new DefaultTableModel(null,tituloPrestamos);
        
        tblLibros.setModel(modeloLibro);
        tblPeriodico.setModel(modeloPeriodico);
        tblRevista.setModel(modeloRevista);
        tblArtInves.setModel(modeloArtIn);
        tblVideo.setModel(modeloVideo);
        tblPrestamo1.setModel(modeloPrestamo);
        logg.setId_biblioteca(lg.getId_biblioteca());
        
        l.cargarDatos(modeloLibro, tblLibros, tblLibros1, logg.getId_biblioteca());
        p.cargarDatos(modeloPeriodico, tblPeriodico, tblLibros2,logg.getId_biblioteca());
        r.cargarDatos(modeloRevista, tblRevista, tblLibros4,logg.getId_biblioteca());
        ai.cargarDatos(modeloArtIn, tblArtInves, tblLibros3,logg.getId_biblioteca());
        vi.cargarDatos(modeloVideo, tblVideo, tblLibros5, logg.getId_biblioteca());
        reu.listarUsuarios(logg.getId_biblioteca(), modeloUsuario, jtableUs);
        pr.listarPrestamos(logg.getId_biblioteca(), modeloPrestamo);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        otro = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        txtEPr = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtPre = new javax.swing.JTextField();
        btnPrestamo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        otro1 = new javax.swing.JScrollPane();
        tblPeriodico = new javax.swing.JTable();
        jLabel70 = new javax.swing.JLabel();
        txtPre1 = new javax.swing.JTextField();
        btnPrestamo1 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        txtEPr1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        otro2 = new javax.swing.JScrollPane();
        tblRevista = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        txtEPr2 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtPre2 = new javax.swing.JTextField();
        btnPrestamo2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        otro3 = new javax.swing.JScrollPane();
        tblArtInves = new javax.swing.JTable();
        jLabel74 = new javax.swing.JLabel();
        txtEPr3 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        txtPre3 = new javax.swing.JTextField();
        btnPrestamo3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        otro4 = new javax.swing.JScrollPane();
        tblVideo = new javax.swing.JTable();
        btnPrestamo4 = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        txtEPr4 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtPre4 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtDireccion = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        txtNUsuario = new javax.swing.JTextField();
        txtNusu = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        txtAp = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        txtAm = new javax.swing.JTextField();
        cPerfil = new javax.swing.JComboBox<>();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableUs = new javax.swing.JTable();
        btnActUs = new javax.swing.JButton();
        txtidUs = new javax.swing.JTextField();
        btnActUs1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        otro5 = new javax.swing.JScrollPane();
        tblLibros1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPasta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVol = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFLanz = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPasillo = new javax.swing.JTextField();
        txtRepisa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAnaquel = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSeccion = new javax.swing.JTextField();
        btnRegLi = new javax.swing.JButton();
        spCantidad = new javax.swing.JSpinner();
        txtAutor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtidU = new javax.swing.JTextField();
        txtidE = new javax.swing.JTextField();
        txtidT = new javax.swing.JTextField();
        btnUp = new javax.swing.JButton();
        btnEl = new javax.swing.JButton();
        btnLimL = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        spCaR4 = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtTitulo1 = new javax.swing.JTextField();
        txtidE1 = new javax.swing.JTextField();
        txtidT1 = new javax.swing.JTextField();
        txtidU1 = new javax.swing.JTextField();
        txtAutor1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPasta1 = new javax.swing.JTextField();
        txtVol1 = new javax.swing.JTextField();
        txtEditorial1 = new javax.swing.JTextField();
        txtTiart = new javax.swing.JTextField();
        txtAuart = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFLanz1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtIdioma1 = new javax.swing.JTextField();
        txtRepisa1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtSeccion1 = new javax.swing.JTextField();
        btnRegLi1 = new javax.swing.JButton();
        btnUp1 = new javax.swing.JButton();
        btnEl1 = new javax.swing.JButton();
        otro6 = new javax.swing.JScrollPane();
        tblLibros2 = new javax.swing.JTable();
        txtAnaquel1 = new javax.swing.JTextField();
        txtPasillo1 = new javax.swing.JTextField();
        spCantidad1 = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtFPu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        btnLimL1 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        spCaR3 = new javax.swing.JSpinner();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtTitulo3 = new javax.swing.JTextField();
        txtidE3 = new javax.swing.JTextField();
        txtidT3 = new javax.swing.JTextField();
        txtidU3 = new javax.swing.JTextField();
        txtAutor3 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtPasta3 = new javax.swing.JTextField();
        txtVol3 = new javax.swing.JTextField();
        txtEditorial3 = new javax.swing.JTextField();
        txtTiart2 = new javax.swing.JTextField();
        txtAuart2 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtFLanz2 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtIdioma2 = new javax.swing.JTextField();
        txtRepisa2 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtSeccion2 = new javax.swing.JTextField();
        btnRegLi2 = new javax.swing.JButton();
        btnUp2 = new javax.swing.JButton();
        btnEl2 = new javax.swing.JButton();
        txtAnaquel2 = new javax.swing.JTextField();
        txtPasillo2 = new javax.swing.JTextField();
        spCantidad2 = new javax.swing.JSpinner();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtFPu2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        btnLimL2 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        spCaR2 = new javax.swing.JSpinner();
        otro8 = new javax.swing.JScrollPane();
        tblLibros4 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        otro7 = new javax.swing.JScrollPane();
        tblLibros3 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txtTitulo2 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtEditorial2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtPasta2 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtFLanz3 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtIdioma3 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtPasillo3 = new javax.swing.JTextField();
        txtRepisa3 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtAnaquel3 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        txtSeccion3 = new javax.swing.JTextField();
        btnRegLi3 = new javax.swing.JButton();
        spCantidad3 = new javax.swing.JSpinner();
        txtAutor2 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtidU2 = new javax.swing.JTextField();
        txtidE2 = new javax.swing.JTextField();
        txtidT2 = new javax.swing.JTextField();
        btnLimL3 = new javax.swing.JButton();
        btnEl3 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        txtFLanz5 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        spCaR1 = new javax.swing.JSpinner();
        btnUp3 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtTitulo4 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txtFLanz4 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtIdioma4 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtPasillo4 = new javax.swing.JTextField();
        txtRepisa4 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtAnaquel4 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txtSeccion4 = new javax.swing.JTextField();
        btnRegLi4 = new javax.swing.JButton();
        spCantidad4 = new javax.swing.JSpinner();
        txtAutor4 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtidU4 = new javax.swing.JTextField();
        txtidE4 = new javax.swing.JTextField();
        txtidT4 = new javax.swing.JTextField();
        btnUp4 = new javax.swing.JButton();
        btnLimL4 = new javax.swing.JButton();
        txtMin = new javax.swing.JTextField();
        otro9 = new javax.swing.JScrollPane();
        tblLibros5 = new javax.swing.JTable();
        btnEl4 = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        spCaR = new javax.swing.JSpinner();
        jPanel15 = new javax.swing.JPanel();
        tblPrestamo = new javax.swing.JScrollPane();
        tblPrestamo1 = new javax.swing.JTable();
        txtidEP = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        txtidPre = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        txtidUsupr = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(java.awt.Color.gray);
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N

        jPanel1.setBackground(java.awt.Color.lightGray);

        tblLibros.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibrosMouseClicked(evt);
            }
        });
        otro.setViewportView(tblLibros);

        jLabel51.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel51.setText("Id del ejemplar");

        txtEPr.setEditable(false);

        jLabel52.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel52.setText("Nombre de usuario a quien se le prestará el ejemplar");

        btnPrestamo.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/prestamo.png"))); // NOI18N
        btnPrestamo.setText("Registrar prestamo");
        btnPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtEPr, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtPre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnPrestamo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otro, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(otro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEPr, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnPrestamo)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Libros", jPanel1);

        jPanel2.setBackground(java.awt.Color.lightGray);

        tblPeriodico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPeriodico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeriodicoMouseClicked(evt);
            }
        });
        otro1.setViewportView(tblPeriodico);

        jLabel70.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel70.setText("Nombre de usuario a quien se le prestará el ejemplar");

        btnPrestamo1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnPrestamo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/per.png"))); // NOI18N
        btnPrestamo1.setText("Registrar prestamo");
        btnPrestamo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamo1ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel71.setText("Id del ejemplar");

        txtEPr1.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txtEPr1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txtPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnPrestamo1)))
                .addGap(18, 18, 18)
                .addComponent(otro1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(otro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEPr1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnPrestamo1)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Periódicos", jPanel2);

        jPanel3.setBackground(java.awt.Color.lightGray);

        tblRevista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRevista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRevistaMouseClicked(evt);
            }
        });
        otro2.setViewportView(tblRevista);

        jLabel72.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel72.setText("Id del ejemplar");

        txtEPr2.setEditable(false);

        jLabel73.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel73.setText("Nombre de usuario a quien se le prestará el ejemplar");

        btnPrestamo2.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnPrestamo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/revista.png"))); // NOI18N
        btnPrestamo2.setText("Registrar prestamo");
        btnPrestamo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEPr2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPre2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnPrestamo2)))
                .addGap(18, 18, 18)
                .addComponent(otro2, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEPr2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPre2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrestamo2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(otro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Revistas", jPanel3);

        jPanel4.setBackground(java.awt.Color.lightGray);

        tblArtInves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblArtInves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArtInvesMouseClicked(evt);
            }
        });
        otro3.setViewportView(tblArtInves);

        jLabel74.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel74.setText("Id del ejemplar");

        txtEPr3.setEditable(false);

        jLabel75.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel75.setText("Nombre de usuario a quien se le prestará el ejemplar");

        btnPrestamo3.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnPrestamo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/investigacion.png"))); // NOI18N
        btnPrestamo3.setText("Registrar prestamo");
        btnPrestamo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamo3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEPr3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPre3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnPrestamo3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(otro3, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(otro3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEPr3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPre3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrestamo3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Artículos de investigación", jPanel4);

        jPanel5.setBackground(java.awt.Color.lightGray);

        tblVideo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVideoMouseClicked(evt);
            }
        });
        otro4.setViewportView(tblVideo);

        btnPrestamo4.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnPrestamo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/video.png"))); // NOI18N
        btnPrestamo4.setText("Registrar prestamo");
        btnPrestamo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamo4ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel76.setText("Id del ejemplar");

        txtEPr4.setEditable(false);

        jLabel77.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel77.setText("Nombre de usuario a quien se le prestará el ejemplar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEPr4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPre4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnPrestamo4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otro4, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(379, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(otro4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEPr4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPre4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrestamo4)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Videos científicos", jPanel5);

        jPanel6.setBackground(java.awt.Color.lightGray);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel83.setText("Ingrese su dirección");

        jLabel84.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel84.setText("Ingrese su número telefónico");

        jLabel85.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel85.setText("Ingrese su nombre de usuario");

        jLabel86.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel86.setText("Ingrese su nombre");

        jLabel87.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel87.setText("Ingrese su apellido paterno");

        jLabel89.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel89.setText("Ingrese su apellido materno");

        cPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "visitante" }));
        cPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPerfilActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel88.setText("Tipo de usuario");

        jtableUs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtableUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableUsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableUs);

        btnActUs.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnActUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ac2.png"))); // NOI18N
        btnActUs.setText("Actualizar usuario");
        btnActUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActUsActionPerformed(evt);
            }
        });

        txtidUs.setEditable(false);

        btnActUs1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnActUs1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ac1.png"))); // NOI18N
        btnActUs1.setText("Eliminar usuario");
        btnActUs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActUs1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNusu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAp, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAm, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(31, 31, 31)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel84)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(cPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel88)))
                        .addComponent(txtidUs, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnActUs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActUs1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel86)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNusu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel87)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtAp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel89)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(jLabel84))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85)
                            .addComponent(jLabel88))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cPerfil)
                            .addComponent(txtNUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(txtidUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActUs1)
                            .addComponent(btnActUs)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", jPanel6);

        jPanel7.setBackground(java.awt.Color.lightGray);

        tblLibros1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLibros1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibros1MouseClicked(evt);
            }
        });
        otro5.setViewportView(tblLibros1);

        jLabel1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel1.setText("Nombre del libro");

        jLabel2.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel2.setText("Editorial");

        jLabel3.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel3.setText("Tipo de pasta");

        jLabel4.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel4.setText("Volumen");

        jLabel5.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel5.setText("Tema");

        jLabel6.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel6.setText("Página");

        jLabel7.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel7.setText("Tipo de libro");

        jLabel8.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel8.setText("Fecha de lanzamiento");

        txtFLanz.setText("2024-12-20");

        jLabel9.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel9.setText("Cantidad de ejemplares");

        jLabel10.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel10.setText("Idioma");

        jLabel11.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel11.setText("Pasillo");

        jLabel12.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel12.setText("Repisa");

        jLabel13.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel13.setText("Anaquel");

        jLabel14.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel14.setText("Sección");

        btnRegLi.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnRegLi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/lib.png"))); // NOI18N
        btnRegLi.setText("Registrar Libro");
        btnRegLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLiActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel15.setText("Autor");

        txtidU.setEditable(false);

        txtidE.setEditable(false);

        txtidT.setEditable(false);

        btnUp.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ac2.png"))); // NOI18N
        btnUp.setText(" Actualizar Libro");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnEl.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnEl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/borrar-archivo.png"))); // NOI18N
        btnEl.setText("Eliminar Libro");
        btnEl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElActionPerformed(evt);
            }
        });

        btnLimL.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnLimL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/brush.png"))); // NOI18N
        btnLimL.setText("Limpiar");
        btnLimL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimLActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel82.setText("Cantidad de eje reales");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidU, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidE, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(txtAnaquel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(119, 119, 119)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(txtPasillo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(txtRepisa, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spCaR4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel82)
                                            .addGap(21, 21, 21))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(txtFLanz, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(169, 169, 169)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtVol, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 541, Short.MAX_VALUE)))
                .addComponent(otro5, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnRegLi, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(btnEl, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btnLimL, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(452, 452, 452))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtidE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(40, 40, 40))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(40, 40, 40)))
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFLanz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spCaR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel82)
                                .addGap(28, 28, 28))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPasillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRepisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnaquel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(otro5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimL)
                    .addComponent(btnUp)
                    .addComponent(btnRegLi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEl, btnLimL, btnRegLi, btnUp});

        jTabbedPane1.addTab("RegLibro", jPanel7);

        jPanel8.setBackground(java.awt.Color.lightGray);

        jLabel16.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel16.setText("Nombre del periódico");

        txtidE1.setEditable(false);

        txtidT1.setEditable(false);

        txtidU1.setEditable(false);

        txtAutor1.setEditable(false);
        txtAutor1.setText("Sin autor único");

        jLabel17.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel17.setText("Autor");

        jLabel19.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel19.setText("Titulo art");

        jLabel20.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel20.setText("Fecha de lanzamiento");

        txtFLanz1.setText("2024-12-20");

        jLabel21.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel21.setText("Idioma");

        txtIdioma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdioma1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel22.setText("Sección");

        jLabel23.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel23.setText("Repisa");

        btnRegLi1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnRegLi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/per.png"))); // NOI18N
        btnRegLi1.setText("Registrar Periodico");
        btnRegLi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLi1ActionPerformed(evt);
            }
        });

        btnUp1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnUp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ac2.png"))); // NOI18N
        btnUp1.setText(" Actualizar Periodico");
        btnUp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUp1ActionPerformed(evt);
            }
        });

        btnEl1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnEl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/borrar-archivo.png"))); // NOI18N
        btnEl1.setText("Eliminar Periodico");
        btnEl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEl1ActionPerformed(evt);
            }
        });

        tblLibros2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLibros2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibros2MouseClicked(evt);
            }
        });
        otro6.setViewportView(tblLibros2);

        jLabel24.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel24.setText("Cantidad de ejemplares");

        jLabel26.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel26.setText("Empresa");

        jLabel27.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel27.setText("Tipo de periodico");

        jLabel28.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel28.setText("Distribuidor");

        jLabel29.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel29.setText("Pasillo");

        jLabel30.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel30.setText("Anaquel");

        jLabel25.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel25.setText("Fecha de publicación");

        txtFPu.setText("2024-12-20");

        jButton1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jButton1.setText("Registrar articulo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel31.setText("Autor(es)");

        btnLimL1.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnLimL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/brush.png"))); // NOI18N
        btnLimL1.setText("Limpiar");
        btnLimL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimL1ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel81.setText("Cantidad de eje reales");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTiart, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAuart, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel31))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(txtFPu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel26))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(txtIdioma1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFLanz1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel24)
                                            .addComponent(spCantidad1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAnaquel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addComponent(txtSeccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(txtPasillo1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(txtRepisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel81)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(spCaR3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnRegLi1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnUp1)
                        .addGap(40, 40, 40)
                        .addComponent(btnEl1)
                        .addGap(40, 40, 40)
                        .addComponent(btnLimL1)))
                .addContainerGap(529, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEditorial1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtidT1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtidU1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtidE1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPasta1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtVol1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(txtAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)))
                    .addComponent(otro6, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEl1, btnLimL1, btnRegLi1, btnUp1});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel28)
                .addGap(33, 33, 33)
                .addComponent(jLabel27)
                .addGap(33, 33, 33)
                .addComponent(jLabel26)
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAuart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFPu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTiart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel31)
                            .addComponent(jLabel25))
                        .addGap(34, 34, 34)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdioma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFLanz1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spCantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel81)
                            .addGap(28, 28, 28))
                        .addComponent(spCaR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPasillo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRepisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnaquel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSeccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimL1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEl1)
                    .addComponent(btnUp1)
                    .addComponent(btnRegLi1))
                .addContainerGap())
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(txtEditorial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(txtidE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtidT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtidU1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(7, 7, 7)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(txtPasta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(txtVol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(otro6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(167, Short.MAX_VALUE)))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEl1, btnLimL1, btnRegLi1, btnUp1});

        jTabbedPane1.addTab("RegPeriódico", jPanel8);

        jPanel10.setBackground(java.awt.Color.lightGray);

        jPanel11.setBackground(java.awt.Color.lightGray);

        jLabel35.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel35.setText("Nombre de la revista");

        txtidE3.setEditable(false);

        txtidT3.setEditable(false);

        txtidU3.setEditable(false);

        txtAutor3.setEditable(false);
        txtAutor3.setText("Sin autor único");

        jLabel36.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel36.setText("Autor");

        jLabel37.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel37.setText("Titulo art");

        jLabel38.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel38.setText("Fecha de lanzamiento");

        txtFLanz2.setText("2024-12-20");

        jLabel39.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel39.setText("Idioma");

        txtIdioma2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdioma2ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel40.setText("Sección");

        jLabel41.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel41.setText("Repisa");

        btnRegLi2.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnRegLi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/revista.png"))); // NOI18N
        btnRegLi2.setText("Registrar Revista");
        btnRegLi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLi2ActionPerformed(evt);
            }
        });

        btnUp2.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnUp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ac2.png"))); // NOI18N
        btnUp2.setText(" Actualizar Revista");
        btnUp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUp2ActionPerformed(evt);
            }
        });

        btnEl2.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnEl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/borrar-archivo.png"))); // NOI18N
        btnEl2.setText("Eliminar Revista");
        btnEl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEl2ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel42.setText("Cantidad de ejemplares");

        jLabel43.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel43.setText("Empresa");

        jLabel44.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel44.setText("Tipo de revista");

        jLabel45.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel45.setText("Distribuidor");

        jLabel46.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel46.setText("Pasillo");

        jLabel47.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel47.setText("Anaquel");

        jLabel48.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel48.setText("Fecha de publicación");

        txtFPu2.setText("2024-12-20");

        jButton3.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/art.png"))); // NOI18N
        jButton3.setText("Registrar articulo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel49.setText("Autor(es)");

        btnLimL2.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnLimL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/brush.png"))); // NOI18N
        btnLimL2.setText("Limpiar");
        btnLimL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimL2ActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel80.setText("Cantidad de eje reales");

        tblLibros4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLibros4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibros4MouseClicked(evt);
            }
        });
        otro8.setViewportView(tblLibros4);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel43)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jLabel44)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTiart2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(txtAuart2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasillo2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)
                            .addComponent(txtAnaquel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFLanz2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)
                            .addComponent(txtRepisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80)
                            .addComponent(spCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spCaR2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnLimL2)
                        .addGap(24, 24, 24)
                        .addComponent(btnUp2)
                        .addGap(24, 24, 24)
                        .addComponent(btnEl2))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel39)
                                    .addComponent(txtIdioma2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel40)
                                            .addComponent(txtSeccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(txtFPu2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otro8, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnRegLi2)))
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEditorial3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtidT3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtidU3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtidE3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(816, 816, 816))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPasta3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtVol3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(txtAutor3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEl2, btnLimL2, btnRegLi2, btnUp2});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel45)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel44)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel43))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTiart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAuart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFPu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdioma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSeccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel38)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPasillo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFLanz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel41)
                            .addComponent(jLabel80))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRepisa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnaquel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spCaR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(otro8, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegLi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(txtTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(txtEditorial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(txtidE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtidT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtidU3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(7, 7, 7)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(txtPasta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(txtVol3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtAutor3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(425, Short.MAX_VALUE)))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEl2, btnLimL2, btnRegLi2, btnUp2});

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RegRevista", jPanel10);

        jPanel9.setBackground(java.awt.Color.lightGray);

        jPanel12.setBackground(java.awt.Color.lightGray);

        tblLibros3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLibros3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibros3MouseClicked(evt);
            }
        });
        otro7.setViewportView(tblLibros3);

        jLabel18.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel18.setText("Titulo del artículo");

        jLabel32.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel32.setText("Instituto de proveniencia");

        jLabel33.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel33.setText("Área de especialidad");

        jLabel53.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel53.setText("Fecha de lanzamiento");

        txtFLanz3.setText("2024-12-20");

        jLabel54.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel54.setText("Cantidad de ejemplares");

        jLabel55.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel55.setText("Idioma");

        jLabel56.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel56.setText("Pasillo");

        jLabel57.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel57.setText("Repisa");

        jLabel58.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel58.setText("Anaquel");

        jLabel59.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel59.setText("Sección");

        btnRegLi3.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnRegLi3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/art.png"))); // NOI18N
        btnRegLi3.setText("Registrar Artículo");
        btnRegLi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLi3ActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel60.setText("Autor");

        txtidU2.setEditable(false);

        txtidE2.setEditable(false);

        txtidT2.setEditable(false);

        btnLimL3.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnLimL3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/brush.png"))); // NOI18N
        btnLimL3.setText("Limpiar");
        btnLimL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimL3ActionPerformed(evt);
            }
        });

        btnEl3.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnEl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/borrar-archivo.png"))); // NOI18N
        btnEl3.setText("Eliminar Articulo");
        btnEl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEl3ActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel69.setText("Fecha de escritura");

        txtFLanz5.setText("2024-12-20");

        jLabel79.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel79.setText("Cantidad de eje reales");

        btnUp3.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnUp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ac2.png"))); // NOI18N
        btnUp3.setText(" Actualizar Artículo");
        btnUp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUp3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnRegLi3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnUp3)
                        .addGap(20, 20, 20)
                        .addComponent(btnEl3)
                        .addGap(21, 21, 21)
                        .addComponent(btnLimL3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEditorial2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(txtTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidT2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidU2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidE2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(spCantidad3))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel79)
                                            .addGroup(jPanel12Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(spCaR1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel53)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel69)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55)
                                    .addComponent(txtIdioma3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel58)
                                            .addComponent(txtAnaquel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel59)
                                            .addComponent(txtSeccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel18)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel56)
                                            .addComponent(txtPasillo3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel57)
                                            .addComponent(txtRepisa3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtPasta2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAutor2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel60)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(txtFLanz3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(txtFLanz5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(273, 273, 273)))
                        .addComponent(otro7, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                        .addGap(14, 14, 14))))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEl3, btnLimL3, btnRegLi3, btnUp3});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEditorial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtidE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidU2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPasta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAutor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel69))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFLanz3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFLanz5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel79))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spCantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdioma3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spCaR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPasillo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRepisa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnaquel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSeccion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(otro7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimL3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegLi3)
                        .addComponent(btnUp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEl3, btnLimL3, btnRegLi3, btnUp3});

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 102, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RegArticuloInvest", jPanel9);

        jPanel13.setBackground(java.awt.Color.lightGray);

        jPanel14.setBackground(java.awt.Color.lightGray);

        jLabel34.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel34.setText("Nombre del video");

        jLabel50.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel50.setText("Duración en minutos");

        jLabel61.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel61.setText("Fecha de lanzamiento");

        txtFLanz4.setText("2024-12-20");

        jLabel62.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel62.setText("Cantidad de ejemplares");

        jLabel63.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel63.setText("Idioma");

        jLabel64.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel64.setText("Pasillo");

        jLabel65.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel65.setText("Repisa");

        jLabel66.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel66.setText("Anaquel");

        jLabel67.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel67.setText("Sección");

        btnRegLi4.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnRegLi4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/video.png"))); // NOI18N
        btnRegLi4.setText("Registrar Video");
        btnRegLi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLi4ActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel68.setText("Autor");

        txtidU4.setEditable(false);

        txtidE4.setEditable(false);

        txtidT4.setEditable(false);

        btnUp4.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnUp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/ac2.png"))); // NOI18N
        btnUp4.setText(" Actualizar Video");
        btnUp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUp4ActionPerformed(evt);
            }
        });

        btnLimL4.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnLimL4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/brush.png"))); // NOI18N
        btnLimL4.setText("Limpiar");
        btnLimL4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimL4ActionPerformed(evt);
            }
        });

        tblLibros5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLibros5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibros5MouseClicked(evt);
            }
        });
        otro9.setViewportView(tblLibros5);

        btnEl4.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnEl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/borrar-archivo.png"))); // NOI18N
        btnEl4.setText("Eliminar Video");
        btnEl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEl4ActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel78.setText("Cantidad de eje reales");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel66)
                                    .addComponent(txtAnaquel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67)
                                    .addComponent(txtSeccion4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel34)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel64)
                                    .addComponent(txtPasillo4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel65)
                                    .addComponent(txtRepisa4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtAutor4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68)
                            .addComponent(jLabel61)
                            .addComponent(txtFLanz4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidT4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidU4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidE4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spCantidad4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(spCaR, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(txtIdioma4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)))
                .addComponent(otro9, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnRegLi4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnUp4)
                .addGap(21, 21, 21)
                .addComponent(btnEl4)
                .addGap(21, 21, 21)
                .addComponent(btnLimL4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEl4, btnLimL4, btnRegLi4, btnUp4});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel50)
                                .addGap(8, 8, 8)
                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtidE4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidU4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAutor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFLanz4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel62)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spCantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel63)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdioma4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel64)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPasillo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel65)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRepisa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel66)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAnaquel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel67)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSeccion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spCaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(otro9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegLi4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimL4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEl4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEl4, btnLimL4, btnRegLi4, btnUp4});

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RegVideo", jPanel13);

        jPanel15.setBackground(java.awt.Color.lightGray);

        tblPrestamo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPrestamo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrestamo1MouseClicked(evt);
            }
        });
        tblPrestamo.setViewportView(tblPrestamo1);

        txtidEP.setEditable(false);

        jLabel90.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel90.setText("IdEjemplar");

        txtidPre.setEditable(false);

        jLabel91.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel91.setText("Id Prestamo");

        txtidUsupr.setEditable(false);

        jLabel92.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        jLabel92.setText("Id Usuario");

        btnRegresar.setFont(new java.awt.Font("Calisto MT", 3, 12)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/reg2.png"))); // NOI18N
        btnRegresar.setText("Marcar como devuelto");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnRegresar)))
                        .addGap(311, 311, 311))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtidPre, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidUsupr, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidEP, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(376, 376, 376)))
                .addComponent(tblPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(tblPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtidEP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidPre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtidUsupr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prestamos", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimL1ActionPerformed
        // TODO add your handling code here:
        limpiarPeriodico();
    }//GEN-LAST:event_btnLimL1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Articulo ar = new Articulo();
        ar.setAutoresArt(txtAuart.getText());
        ar.setTituloArt(txtTiart.getText());
        ar.setFechaPublicacion(txtFPu.getText());
        this.art.add(ar);
        txtAuart.setText("");
        txtTiart.setText("");
        txtFPu.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblLibros2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibros2MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();

            txtTitulo1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString()); // "nombre"
            txtEditorial1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString()); // "distribuidor"
            txtVol1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString()); // "empresa"
            txtPasta1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString()); // "tipo de revista"

            txtFLanz1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString()); // "fecha de lanzamiento"
            txtIdioma1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString()); // "idioma"
            spCantidad1.setValue(Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString())); // "cantidad"
            spCaR3.setValue(Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString()));

            
            txtPasillo1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString()); // "pasillo"
            txtRepisa1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 9).toString()); // "repisa"
            txtAnaquel1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 10).toString()); // "anaquel"
            txtSeccion1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 11).toString()); // "seccion"

            txtidE1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString()); // "idE"
            txtidT1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 13).toString()); // "idT"
            txtidU1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 14).toString()); // "idU"

        }
    }//GEN-LAST:event_tblLibros2MouseClicked

    private void btnEl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEl1ActionPerformed
        // TODO add your handling code here:
        PeriodicoDAO lbc = new PeriodicoDAO();
        lbc.eliminarProducto(txtidT1.getText(),txtidE1.getText(),txtidU1.getText(), tblPeriodico, tblLibros2,logg.getId_biblioteca());
    }//GEN-LAST:event_btnEl1ActionPerformed

    private void btnUp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUp1ActionPerformed
        // TODO add your handling code here:
        Periodico per = new Periodico();
        Articulo art = new Articulo();
        Ubicacion ub = new Ubicacion();
        PeriodicoDAO lbc = new PeriodicoDAO();

        per.setId(txtidE1.getText());
        per.setAutores(txtAutor1.getText());
        per.setFechaLanz(txtFLanz1.getText());
        per.setIdioma(txtIdioma1.getText());
        per.setCantidad((int) spCantidad1.getValue());
        per.setCantidadReal((int) spCaR3.getValue());

        ub.setId(txtidU1.getText());
        ub.setAnaquel(txtAnaquel1.getText());
        ub.setPasillo(txtPasillo1.getText());
        ub.setRepisa(txtRepisa1.getText());
        ub.setSeccion(txtSeccion1.getText());

        per.setIdPerio(txtidT1.getText());
        per.setNombre(txtTitulo1.getText());
        per.setDistribuidor(txtEditorial1.getText());
        per.setEmpresa(txtVol1.getText());
        per.setTiporevista(txtPasta1.getText());

        lbc.actualizarProducto(ub, per, logg.getId_biblioteca(), tblPeriodico, tblLibros2);
        limpiarPeriodico();
    }//GEN-LAST:event_btnUp1ActionPerformed

    private void btnRegLi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegLi1ActionPerformed
        // TODO add your handling code here:
        Periodico per = new Periodico();
        Articulo art = new Articulo();
        Ubicacion ub = new Ubicacion();
        PeriodicoDAO lbc = new PeriodicoDAO();

        per.setAutores(txtAutor1.getText());
        per.setFechaLanz(txtFLanz1.getText());
        per.setIdioma(txtIdioma1.getText());
        per.setCantidad((int) spCantidad1.getValue());
        per.setCantidadReal((int) spCaR3.getValue());

        
        ub.setAnaquel(txtAnaquel1.getText());
        ub.setPasillo(txtPasillo1.getText());
        ub.setRepisa(txtRepisa1.getText());
        ub.setSeccion(txtSeccion1.getText());

        per.setNombre(txtTitulo1.getText());
        per.setDistribuidor(txtEditorial1.getText());
        per.setEmpresa(txtVol1.getText());
        per.setTiporevista(txtPasta1.getText());

        Object[] res = lbc.registrarProducto(ub, per, this.art, logg.getId_biblioteca());
        if (res != null) {
            modeloPeriodico.addRow(res);
            limpiarPeriodico();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el libro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegLi1ActionPerformed

    private void txtIdioma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdioma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdioma1ActionPerformed

    private void btnLimLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimLActionPerformed
        // TODO add your handling code here:
        //txtTitulo.setText("");
       limpiarLibro();
    }//GEN-LAST:event_btnLimLActionPerformed

    private void btnElActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElActionPerformed
        // TODO add your handling code here:
        LibroDAO lbc = new LibroDAO();
        lbc.eliminarProducto(txtidT.getText(),txtidE.getText(),txtidU.getText(), tblLibros, tblLibros1,logg.getId_biblioteca());
    }//GEN-LAST:event_btnElActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        // TODO add your handling code here:
        Libro lb = new Libro();
        Ubicacion ub = new Ubicacion();
        LibroDAO lbc = new LibroDAO();

        lb.setId(txtidE.getText());
        lb.setAutores(txtAutor.getText());
        lb.setFechaLanz(txtFLanz.getText());
        lb.setIdioma(txtIdioma.getText());
        lb.setCantidad((int) spCantidad.getValue());
        lb.setCantidadReal((int) spCaR4.getValue());

        ub.setId(txtidU.getText());
        ub.setAnaquel(txtAnaquel.getText());
        ub.setPasillo(txtPasillo.getText());
        ub.setRepisa(txtRepisa.getText());
        ub.setSeccion(txtSeccion.getText());

        lb.setLibroid(txtidT.getText());
        lb.setTitulo(txtTitulo.getText());
        lb.setEditorial(txtEditorial.getText());
        lb.setPasta(txtPasta.getText());
        lb.setVolumen(txtVol.getText());
        lb.setTipoLibro(txtTipo.getText());

        lbc.actualizarProducto(ub, lb, logg.getId_biblioteca(),tblLibros, tblLibros1);
        limpiarLibro();
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnRegLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegLiActionPerformed
        // TODO add your handling code here:
        Libro lb = new Libro();
        Ubicacion ub = new Ubicacion();
        LibroDAO lbc = new LibroDAO();

        lb.setAutores(txtAutor.getText());
        lb.setFechaLanz(txtFLanz.getText());
        lb.setIdioma(txtIdioma.getText());
        lb.setCantidad((int) spCantidad.getValue());
        lb.setCantidadReal((int) spCaR4.getValue());

        ub.setAnaquel(txtAnaquel.getText());
        ub.setPasillo(txtPasillo.getText());
        ub.setRepisa(txtRepisa.getText());
        ub.setSeccion(txtSeccion.getText());

        lb.setTitulo(txtTitulo.getText());
        lb.setEditorial(txtEditorial.getText());
        lb.setPasta(txtPasta.getText());
        lb.setVolumen(txtVol.getText());
        lb.setTipoLibro(txtTipo.getText());

        Object[] res = lbc.registrarProducto(ub, lb, logg.getId_biblioteca());
        if (res != null) {
            modeloLibro.addRow(res);
            limpiarLibro();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el libro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegLiActionPerformed

    private void tblLibros1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibros1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();

            txtAutor.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());
            txtFLanz.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString());
            txtIdioma.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
            spCantidad.setValue(Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString()));
            spCaR4.setValue(Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 9).toString()));

            txtPasillo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 10).toString());
            txtRepisa.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 11).toString());
            txtAnaquel.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString());
            txtSeccion.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 13).toString());

            txtTitulo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtEditorial.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtPasta.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            txtVol.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            txtTipo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());

            txtidE.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 14).toString());
            txtidT.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 15).toString());
            txtidU.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 16).toString());
        }
    }//GEN-LAST:event_tblLibros1MouseClicked

    private void txtIdioma2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdioma2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdioma2ActionPerformed

    private void btnRegLi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegLi2ActionPerformed
        // TODO add your handling code here:
        Revista per = new Revista();
        Articulo art = new Articulo();
        Ubicacion ub = new Ubicacion();
        RevistaDAO lbc = new RevistaDAO();

        per.setAutores(txtAutor3.getText());
        per.setFechaLanz(txtFLanz2.getText());
        per.setIdioma(txtIdioma2.getText());
        per.setCantidad((int) spCantidad2.getValue());
        per.setCantidad((int) spCaR2.getValue());

        ub.setAnaquel(txtAnaquel2.getText());
        ub.setPasillo(txtPasillo2.getText());
        ub.setRepisa(txtRepisa2.getText());
        ub.setSeccion(txtSeccion2.getText());

        per.setNombre(txtTitulo3.getText());
        per.setDistribuidor(txtEditorial3.getText());
        per.setEmpresa(txtVol3.getText());
        per.setTipoRevista(txtPasta3.getText());

        Object[] res = lbc.registrarProducto(ub, per, this.art, logg.getId_biblioteca());
        if (res != null) {
            modeloRevista.addRow(res);
            limpiarPeriodico();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el libro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegLi2ActionPerformed

    private void btnUp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUp2ActionPerformed
        // TODO add your handling code here:
        //lbc.actualizarProducto(ub, per, logg.getId_biblioteca(), tblPeriodico, tblLibros2);
        Revista per = new Revista();
        Articulo art = new Articulo();
        Ubicacion ub = new Ubicacion();
        RevistaDAO lbc = new RevistaDAO();
        
        per.setId(txtidE3.getText());
        per.setAutores(txtAutor3.getText());
        per.setFechaLanz(txtFLanz2.getText());
        per.setIdioma(txtIdioma2.getText());
        per.setCantidad((int) spCantidad2.getValue());
        per.setCantidadReal((int) spCaR2.getValue());


        ub.setId(txtidU3.getText());
        ub.setAnaquel(txtAnaquel2.getText());
        ub.setPasillo(txtPasillo2.getText());
        ub.setRepisa(txtRepisa2.getText());
        ub.setSeccion(txtSeccion2.getText());
        
        per.setIdRevista(txtidT3.getText());
        per.setNombre(txtTitulo3.getText());
        per.setDistribuidor(txtEditorial3.getText());
        per.setEmpresa(txtVol3.getText());
        per.setTipoRevista(txtPasta3.getText());
        lbc.actualizarProducto(ub, per, logg.getId_biblioteca(), tblRevista, tblLibros1);
    }//GEN-LAST:event_btnUp2ActionPerformed

    private void btnEl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEl2ActionPerformed
        // TODO add your handling code here:
        RevistaDAO rev = new RevistaDAO();
        rev.eliminarProducto(txtidT3.getText(), txtidE3.getText(),txtidU3.getText(),tblRevista, tblLibros4,logg.getId_biblioteca());
    }//GEN-LAST:event_btnEl2ActionPerformed

    private void tblLibros4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibros4MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();
            
            txtTitulo3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString()); // "nombre"
            txtEditorial3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString()); // "distribuidor"
            txtVol3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString()); // "empresa"
            txtPasta3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString()); // "tipo de revista"
            
            txtFLanz2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString()); // "fecha de lanzamiento"
            txtIdioma2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString()); // "idioma"
            spCantidad2.setValue(Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString())); // "cantidad"
            spCaR2.setValue(Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString()));
            
            txtPasillo2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString()); // "pasillo"
            txtRepisa2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 9).toString()); // "repisa"
            txtAnaquel2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 10).toString()); // "anaquel"
            txtSeccion2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 11).toString()); // "seccion"
            
            txtidE3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString()); // "idE"
            txtidT3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 13).toString()); // "idT"
            txtidU3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 14).toString()); // "idU"
            
        }
    }//GEN-LAST:event_tblLibros4MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Articulo ar = new Articulo();
        ar.setAutoresArt(txtAuart2.getText());
        ar.setTituloArt(txtTiart2.getText());
        ar.setFechaPublicacion(txtFPu2.getText());
        this.art.add(ar);
        txtAuart2.setText("");
        txtTiart2.setText("");
        txtFPu2.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnLimL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimL2ActionPerformed
        // TODO add your handling code here:
        limpiarRevista();
        
    }//GEN-LAST:event_btnLimL2ActionPerformed

    private void tblLibros3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibros3MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();

            txtAutor2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString()); // "autores"
            txtFLanz3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString()); // "fecha de lanzamiento"
            txtFLanz5.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString()); // "fecha de lanzamiento"
            
            txtIdioma3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString()); // "idioma"
            spCantidad3.setValue(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7)); // "cantidad"
            spCaR1.setValue(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8));
            
            txtPasillo3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 9).toString()); // "pasillo"
            txtRepisa3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 10).toString()); // "repisa"
            txtAnaquel3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 11).toString()); // "anaquel"
            txtSeccion3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString()); // "seccion"

            txtTitulo2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString()); // "nombre del art"
            txtEditorial2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString()); // "area de especialidad"
            txtPasta2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString()); // "fecha escritura"

            txtidE2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 13).toString()); // "idE"
            txtidT2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 14).toString()); // "idT"
            txtidU2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 15).toString()); // "idU"
        }
    }//GEN-LAST:event_tblLibros3MouseClicked

    private void btnRegLi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegLi3ActionPerformed
        // TODO add your handling code here:
        ArticuloCientifico per = new ArticuloCientifico();
        Ubicacion ub = new Ubicacion();
        ArticuloIDAO lbc = new ArticuloIDAO();
        
        per.setAutores(txtAutor2.getText());
        per.setFechaLanz(txtFLanz3.getText());
        per.setIdioma(txtIdioma3.getText());
        per.setCantidad((int) spCantidad3.getValue());
        per.setCantidadReal((int) spCaR1.getValue());
        
        ub.setAnaquel(txtAnaquel3.getText());
        ub.setPasillo(txtPasillo3.getText());
        ub.setRepisa(txtRepisa3.getText());
        ub.setSeccion(txtSeccion3.getText());
        
        per.setNombreArt(txtTitulo2.getText());
        per.setInsitutoProvinencia(txtEditorial2.getText());
        per.setAreaespecialidad(txtPasta2.getText());
        per.setFechaescr(txtFLanz5.getText());
        
        Object[] res = lbc.registrarProducto(ub, per,logg.getId_biblioteca());
        if (res != null) {
            modeloArtIn.addRow(res);
            limpiarPeriodico();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el libro", "Error", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_btnRegLi3ActionPerformed

    private void btnUp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUp3ActionPerformed
        // TODO add your handling code here:
        ArticuloCientifico per = new ArticuloCientifico();
        Ubicacion ub = new Ubicacion();
        ArticuloIDAO lbc = new ArticuloIDAO();
        
        per.setAutores(txtAutor2.getText());
        per.setFechaLanz(txtFLanz3.getText());
        per.setIdioma(txtIdioma3.getText());
        per.setCantidad((int) spCantidad3.getValue());
        per.setCantidadReal((int) spCaR1.getValue());
        per.setId(txtidE2.getText());
        
        ub.setAnaquel(txtAnaquel3.getText());
        ub.setPasillo(txtPasillo3.getText());
        ub.setRepisa(txtRepisa3.getText());
        ub.setSeccion(txtSeccion3.getText());
        ub.setId(txtidU2.getText());
        
        per.setNombreArt(txtTitulo2.getText());
        per.setInsitutoProvinencia(txtEditorial2.getText());
        per.setAreaespecialidad(txtPasta2.getText());
        per.setFechaescr(txtFLanz5.getText());
        per.setArticulocientifico_id(txtidT2.getText());
        
        lbc.actualizarProducto(ub, per, logg.getId_biblioteca(), tblArtInves, tblLibros3);
    }//GEN-LAST:event_btnUp3ActionPerformed

    private void btnLimL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimL3ActionPerformed
        // TODO add your handling code here:
        limpiarArt();
    }//GEN-LAST:event_btnLimL3ActionPerformed

    private void tblLibros5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibros5MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();
            
            txtAutor4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            txtFLanz4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            txtIdioma4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
            spCantidad4.setValue(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5));
            spCaR.setValue(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6));

            txtPasillo4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
            txtRepisa4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString());
            txtAnaquel4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 9).toString());
            txtSeccion4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 10).toString());

            txtTitulo4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtMin.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            
            txtidE4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 11).toString());
            txtidT4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString());
            txtidU4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 13).toString());
        }
    }//GEN-LAST:event_tblLibros5MouseClicked

    private void btnEl3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEl3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEl3ActionPerformed

    private void btnEl4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEl4ActionPerformed
        // TODO add your handling code here:
        VideoCientifico vid = new VideoCientifico();
        VideoDAO vd = new VideoDAO();
        Ubicacion ub = new Ubicacion();
        
        vd.eliminarProducto(txtidT4.getText(),txtidE4.getText(),txtidU4.getText(), tblVideo, tblLibros5, logg.getId_biblioteca());
    }//GEN-LAST:event_btnEl4ActionPerformed

    private void btnLimL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimL4ActionPerformed
        // TODO add your handling code here:
        limpiarVideo();
    }//GEN-LAST:event_btnLimL4ActionPerformed

    private void btnUp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUp4ActionPerformed
        // TODO add your handling code here:

        VideoCientifico vid = new VideoCientifico();
        VideoDAO vd = new VideoDAO();
        Ubicacion ub = new Ubicacion();

        vid.setId(txtidE4.getText());
        vid.setAutores(txtAutor4.getText());
        vid.setFechaLanz(txtFLanz4.getText());
        vid.setIdioma(txtIdioma4.getText());
        vid.setCantidad((int) spCantidad4.getValue());
        vid.setCantidadReal((int) spCaR.getValue());
        
        ub.setId(txtidU4.getText());
        ub.setAnaquel(txtAnaquel4.getText());
        ub.setPasillo(txtPasillo4.getText());
        ub.setRepisa(txtRepisa4.getText());
        ub.setSeccion(txtSeccion4.getText());

        vid.setIdVideo(txtidT4.getText());
        vid.setDuracion(txtMin.getText());
        vid.setNombre(txtTitulo4.getText());

        vd.actualizarProducto(ub, vid, logg.getId_biblioteca(), tblVideo, tblLibros5);
    }//GEN-LAST:event_btnUp4ActionPerformed

    private void btnRegLi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegLi4ActionPerformed
        // TODO add your handling code here:
        VideoCientifico vid = new VideoCientifico();
        VideoDAO vd = new VideoDAO();
        Ubicacion ub = new Ubicacion();

        vid.setAutores(txtAutor4.getText());
        vid.setFechaLanz(txtFLanz4.getText());
        vid.setIdioma(txtIdioma4.getText());
        vid.setCantidad((int) spCantidad4.getValue());
        vid.setCantidadReal((int) spCaR.getValue());
        

        ub.setAnaquel(txtAnaquel4.getText());
        ub.setPasillo(txtPasillo4.getText());
        ub.setRepisa(txtRepisa4.getText());
        ub.setSeccion(txtSeccion4.getText());

        vid.setDuracion(String.valueOf(txtMin.getText()));
        vid.setNombre(txtTitulo4.getText());

        Object[] res = vd.registrarProducto(ub, vid, logg.getId_biblioteca());
        if (res != null) {
            modeloVideo.addRow(res);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el video", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegLi4ActionPerformed

    private void tblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibrosMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();
            txtEPr.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 14).toString());
        }
    }//GEN-LAST:event_tblLibrosMouseClicked

    private void btnPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamoActionPerformed
        // TODO add your handling code here:
        PrestamoDAO pr = new PrestamoDAO();
        LibroDAO lb = new LibroDAO();
        Object[] nuevaFila = pr.registrarPrestamo(txtEPr.getText(), txtPre.getText());
        if (nuevaFila != null) {
            lb.actualizarCantidadReal(tblLibros, txtEPr.getText(), (int) nuevaFila[8]);
            lb.actualizarCantidadReal(tblLibros1, txtEPr.getText(), (int) nuevaFila[8]);
            modeloPrestamo.addRow(nuevaFila);
        }
    }//GEN-LAST:event_btnPrestamoActionPerformed

    private void btnPrestamo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamo1ActionPerformed
        // TODO add your handling code here:
        
        PrestamoDAO pr = new PrestamoDAO();
        PeriodicoDAO lb = new PeriodicoDAO();
        Object[] nuevaFila = pr.registrarPrestamo(txtEPr1.getText(), txtPre1.getText());
        if (nuevaFila != null) {
            lb.actualizarCantidadReal(tblPeriodico, txtEPr1.getText(), (int) nuevaFila[8]);
            lb.actualizarCantidadReal(tblLibros2, txtEPr1.getText(), (int) nuevaFila[8]);
            modeloPrestamo.addRow(nuevaFila);
        }
    }//GEN-LAST:event_btnPrestamo1ActionPerformed

    private void tblPeriodicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeriodicoMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();
            txtEPr1.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString());
        }
    }//GEN-LAST:event_tblPeriodicoMouseClicked

    private void btnPrestamo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamo2ActionPerformed
        // TODO add your handling code here:
        PrestamoDAO pr = new PrestamoDAO();
        RevistaDAO lb = new RevistaDAO();
        Object[] nuevaFila = pr.registrarPrestamo(txtEPr2.getText(), txtPre2.getText());
        if (nuevaFila != null) {
            lb.actualizarCantidadReal(tblRevista, txtEPr2.getText(), (int) nuevaFila[8]);
            lb.actualizarCantidadReal(tblLibros3, txtEPr2.getText(), (int) nuevaFila[8]);
            modeloPrestamo.addRow(nuevaFila);
        }
    }//GEN-LAST:event_btnPrestamo2ActionPerformed

    private void tblRevistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRevistaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();
            txtEPr2.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString());
        }
    }//GEN-LAST:event_tblRevistaMouseClicked

    private void btnPrestamo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamo3ActionPerformed
        // TODO add your handling code here:
        PrestamoDAO pr = new PrestamoDAO();
        ArticuloIDAO lb = new ArticuloIDAO();
        Object[] nuevaFila = pr.registrarPrestamo(txtEPr3.getText(), txtPre3.getText());
        if (nuevaFila != null) {
            lb.actualizarCantidadReal(tblArtInves, txtEPr3.getText(), (int) nuevaFila[8]);
            lb.actualizarCantidadReal(tblLibros3, txtEPr3.getText(), (int) nuevaFila[8]);
            modeloPrestamo.addRow(nuevaFila);
        }
    }//GEN-LAST:event_btnPrestamo3ActionPerformed

    private void tblArtInvesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArtInvesMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();
            txtEPr3.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 13).toString());
        }
    }//GEN-LAST:event_tblArtInvesMouseClicked

    private void btnPrestamo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamo4ActionPerformed
        // TODO add your handling code here:
        PrestamoDAO pr = new PrestamoDAO();
        VideoDAO lb = new VideoDAO();
        Object[] nuevaFila = pr.registrarPrestamo(txtEPr4.getText(), txtPre4.getText());
        if (nuevaFila != null) {
            lb.actualizarCantidadReal(tblVideo, txtEPr4.getText(), (int) nuevaFila[8]);
            lb.actualizarCantidadReal(tblLibros5, txtEPr4.getText(), (int) nuevaFila[8]);
            modeloPrestamo.addRow(nuevaFila);
        }
    }//GEN-LAST:event_btnPrestamo4ActionPerformed

    private void tblVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVideoMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();
            txtEPr4.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 11).toString());
        }
    }//GEN-LAST:event_tblVideoMouseClicked

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void cPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPerfilActionPerformed

    private void btnActUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActUsActionPerformed
        // TODO add your handling code here:
        RegistroUsuarioDAO regu = new RegistroUsuarioDAO();
        Usuario usu = new Usuario();
        usu.setId(txtidUs.getText());
        usu.setNomnreUsuario(txtNUsuario.getText());
        usu.setNombre(txtNusu.getText());
        usu.setApellidop(txtAp.getText());
        usu.setApellidom(txtAm.getText());
        usu.setPerfil(cPerfil.getModel().getSelectedItem().toString());
        usu.setDireccion(txtDireccion.getText());
        usu.setTelefono(txtTelefono.getText());
        regu.actualizarUs(usu.getId(), usu,jtableUs);
    }//GEN-LAST:event_btnActUsActionPerformed

    private void jtableUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableUsMouseClicked
        // TODO add your handling code here:
         if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();

            txtidUs.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString()); 
            txtNUsuario.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtNusu.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString()); 
            txtAp.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            txtAm.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
            for (int i = 0; i < cPerfil.getModel().getSize(); i++) {
                if (cPerfil.getModel().getElementAt(i).equals(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5))) {
                    cPerfil.setSelectedItem(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5));
                    break;
                }
            }
            txtDireccion.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString());
            txtTelefono.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
        }
    }//GEN-LAST:event_jtableUsMouseClicked

    private void btnActUs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActUs1ActionPerformed
        // TODO add your handling code here:
        RegistroUsuarioDAO regu = new RegistroUsuarioDAO();
        Usuario usu = new Usuario();
        regu.eliminarUsu(txtidU.getText(), jtableUs);
    }//GEN-LAST:event_btnActUs1ActionPerformed

    private void tblPrestamo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrestamo1MouseClicked
        // TODO add your handling code here:
         if(evt.getClickCount()==1){
            JTable receptor = (JTable) evt.getSource();
            
            txtidEP.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString());
            txtidPre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());
            txtidUsupr.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
        }
    }//GEN-LAST:event_tblPrestamo1MouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        PrestamoDAO pr = new PrestamoDAO();
        LibroDAO lb = new LibroDAO();
        PeriodicoDAO p = new PeriodicoDAO();
        RevistaDAO r = new RevistaDAO();
        ArticuloIDAO ai = new ArticuloIDAO();
        VideoDAO v = new VideoDAO();
        int res = pr.regresarPrestamo(txtidEP.getText(), txtidPre.getText(), txtidUsupr.getText(),tblPrestamo1);
        lb.actualizarCantidadReal(tblLibros, txtEPr.getText(), res);
        lb.actualizarCantidadReal(tblLibros1, txtEPr.getText(), res);
        p.actualizarCantidadReal(tblPeriodico, txtEPr.getText(), res);
        p.actualizarCantidadReal(tblLibros2, txtEPr.getText(), res);
        r.actualizarCantidadReal(tblRevista, txtEPr.getText(), res);
        r.actualizarCantidadReal(tblLibros3, txtEPr.getText(), res);
        ai.actualizarCantidadReal(tblArtInves, txtEPr.getText(), res);
        ai.actualizarCantidadReal(tblLibros4, txtEPr.getText(), res);
        v.actualizarCantidadReal(tblVideo, txtEPr.getText(), res);
        v.actualizarCantidadReal(tblLibros5, txtEPr.getText(), res);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void limpiarPeriodico(){
        txtTitulo1.setText(""); // "nombre"
        txtEditorial1.setText(""); // "distribuidor"
        txtVol1.setText(""); // "empresa"
        txtPasta1.setText(""); // "tipo de revista"

        txtFLanz1.setText(""); // "fecha de lanzamiento"
        txtIdioma1.setText(""); // "idioma"
        spCantidad1.setValue(0); // "cantidad"

        txtPasillo1.setText(""); // "pasillo"
        txtRepisa1.setText(""); // "repisa"
        txtAnaquel1.setText(""); // "anaquel"
        txtSeccion1.setText(""); // "seccion"

        txtidE1.setText(""); // "idE"
        txtidT1.setText(""); // "idT"
        txtidU1.setText("");
    }

    private void limpiarLibro(){
        txtAutor.setText("");
        txtFLanz.setText("");
        txtIdioma.setText("");
        spCantidad.setValue(0);

        txtPasillo.setText("");
        txtRepisa.setText("");
        txtAnaquel.setText("");
        txtSeccion.setText("");

        txtTitulo.setText("");
        txtEditorial.setText("");
        txtPasta.setText("");
        txtVol.setText("");
        txtTipo.setText("");

        txtidE.setText("");
        txtidT.setText("");
        txtidU.setText("");
    }
    private void limpiarRevista(){
        txtTitulo3.setText("");
        txtEditorial3.setText("");
        txtPasta3.setText("");
        txtVol3.setText("");
        
        txtidE3.setText("");
        txtidT3.setText("");
        txtidU3.setText("");
        txtTiart2.setText("");
        txtAuart2.setText("");
        
        txtIdioma2.setText("");
        txtSeccion2.setText("");
        txtPasillo2.setText("");
        spCantidad2.setValue(0);
        txtAnaquel2.setText("");
        txtRepisa2.setText("");
        spCaR2.setValue(0);
    }
    private void limpiarArt(){
        txtTitulo2.setText("");
        txtEditorial2.setText("");
        txtPasta2.setText("");
        txtAutor2.setText("");
        
        txtIdioma3.setText("");
        txtPasillo3.setText("");
        txtRepisa3.setText("");
        txtAnaquel3.setText("");
        txtSeccion3.setText("");
        
        spCantidad3.setValue(0);
        spCaR1.setValue(0);
    }
    private void limpiarVideo(){
        txtTitulo4.setText("");
        txtMin.setText("");
        txtAutor4.setText("");
        txtIdioma4.setText("");
        
        txtPasillo4.setText("");
        txtRepisa4.setText("");
        txtAnaquel4.setText("");
        txtSeccion4.setText("");
        
        spCaR.setValue(0);
        spCantidad4.setValue(0);
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActUs;
    private javax.swing.JButton btnActUs1;
    private javax.swing.JButton btnEl;
    private javax.swing.JButton btnEl1;
    private javax.swing.JButton btnEl2;
    private javax.swing.JButton btnEl3;
    private javax.swing.JButton btnEl4;
    private javax.swing.JButton btnLimL;
    private javax.swing.JButton btnLimL1;
    private javax.swing.JButton btnLimL2;
    private javax.swing.JButton btnLimL3;
    private javax.swing.JButton btnLimL4;
    private javax.swing.JButton btnPrestamo;
    private javax.swing.JButton btnPrestamo1;
    private javax.swing.JButton btnPrestamo2;
    private javax.swing.JButton btnPrestamo3;
    private javax.swing.JButton btnPrestamo4;
    private javax.swing.JButton btnRegLi;
    private javax.swing.JButton btnRegLi1;
    private javax.swing.JButton btnRegLi2;
    private javax.swing.JButton btnRegLi3;
    private javax.swing.JButton btnRegLi4;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton btnUp1;
    private javax.swing.JButton btnUp2;
    private javax.swing.JButton btnUp3;
    private javax.swing.JButton btnUp4;
    private javax.swing.JComboBox<String> cPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtableUs;
    private javax.swing.JScrollPane otro;
    private javax.swing.JScrollPane otro1;
    private javax.swing.JScrollPane otro2;
    private javax.swing.JScrollPane otro3;
    private javax.swing.JScrollPane otro4;
    private javax.swing.JScrollPane otro5;
    private javax.swing.JScrollPane otro6;
    private javax.swing.JScrollPane otro7;
    private javax.swing.JScrollPane otro8;
    private javax.swing.JScrollPane otro9;
    private javax.swing.JSpinner spCaR;
    private javax.swing.JSpinner spCaR1;
    private javax.swing.JSpinner spCaR2;
    private javax.swing.JSpinner spCaR3;
    private javax.swing.JSpinner spCaR4;
    private javax.swing.JSpinner spCantidad;
    private javax.swing.JSpinner spCantidad1;
    private javax.swing.JSpinner spCantidad2;
    private javax.swing.JSpinner spCantidad3;
    private javax.swing.JSpinner spCantidad4;
    private javax.swing.JTable tblArtInves;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTable tblLibros1;
    private javax.swing.JTable tblLibros2;
    private javax.swing.JTable tblLibros3;
    private javax.swing.JTable tblLibros4;
    private javax.swing.JTable tblLibros5;
    private javax.swing.JTable tblPeriodico;
    private javax.swing.JScrollPane tblPrestamo;
    private javax.swing.JTable tblPrestamo1;
    private javax.swing.JTable tblRevista;
    private javax.swing.JTable tblVideo;
    private javax.swing.JTextField txtAm;
    private javax.swing.JTextField txtAnaquel;
    private javax.swing.JTextField txtAnaquel1;
    private javax.swing.JTextField txtAnaquel2;
    private javax.swing.JTextField txtAnaquel3;
    private javax.swing.JTextField txtAnaquel4;
    private javax.swing.JTextField txtAp;
    private javax.swing.JTextField txtAuart;
    private javax.swing.JTextField txtAuart2;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtAutor1;
    private javax.swing.JTextField txtAutor2;
    private javax.swing.JTextField txtAutor3;
    private javax.swing.JTextField txtAutor4;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEPr;
    private javax.swing.JTextField txtEPr1;
    private javax.swing.JTextField txtEPr2;
    private javax.swing.JTextField txtEPr3;
    private javax.swing.JTextField txtEPr4;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtEditorial1;
    private javax.swing.JTextField txtEditorial2;
    private javax.swing.JTextField txtEditorial3;
    private javax.swing.JTextField txtFLanz;
    private javax.swing.JTextField txtFLanz1;
    private javax.swing.JTextField txtFLanz2;
    private javax.swing.JTextField txtFLanz3;
    private javax.swing.JTextField txtFLanz4;
    private javax.swing.JTextField txtFLanz5;
    private javax.swing.JTextField txtFPu;
    private javax.swing.JTextField txtFPu2;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtIdioma1;
    private javax.swing.JTextField txtIdioma2;
    private javax.swing.JTextField txtIdioma3;
    private javax.swing.JTextField txtIdioma4;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtNUsuario;
    private javax.swing.JTextField txtNusu;
    private javax.swing.JTextField txtPasillo;
    private javax.swing.JTextField txtPasillo1;
    private javax.swing.JTextField txtPasillo2;
    private javax.swing.JTextField txtPasillo3;
    private javax.swing.JTextField txtPasillo4;
    private javax.swing.JTextField txtPasta;
    private javax.swing.JTextField txtPasta1;
    private javax.swing.JTextField txtPasta2;
    private javax.swing.JTextField txtPasta3;
    private javax.swing.JTextField txtPre;
    private javax.swing.JTextField txtPre1;
    private javax.swing.JTextField txtPre2;
    private javax.swing.JTextField txtPre3;
    private javax.swing.JTextField txtPre4;
    private javax.swing.JTextField txtRepisa;
    private javax.swing.JTextField txtRepisa1;
    private javax.swing.JTextField txtRepisa2;
    private javax.swing.JTextField txtRepisa3;
    private javax.swing.JTextField txtRepisa4;
    private javax.swing.JTextField txtSeccion;
    private javax.swing.JTextField txtSeccion1;
    private javax.swing.JTextField txtSeccion2;
    private javax.swing.JTextField txtSeccion3;
    private javax.swing.JTextField txtSeccion4;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTiart;
    private javax.swing.JTextField txtTiart2;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtTitulo1;
    private javax.swing.JTextField txtTitulo2;
    private javax.swing.JTextField txtTitulo3;
    private javax.swing.JTextField txtTitulo4;
    private javax.swing.JTextField txtVol;
    private javax.swing.JTextField txtVol1;
    private javax.swing.JTextField txtVol3;
    private javax.swing.JTextField txtidE;
    private javax.swing.JTextField txtidE1;
    private javax.swing.JTextField txtidE2;
    private javax.swing.JTextField txtidE3;
    private javax.swing.JTextField txtidE4;
    private javax.swing.JTextField txtidEP;
    private javax.swing.JTextField txtidPre;
    private javax.swing.JTextField txtidT;
    private javax.swing.JTextField txtidT1;
    private javax.swing.JTextField txtidT2;
    private javax.swing.JTextField txtidT3;
    private javax.swing.JTextField txtidT4;
    private javax.swing.JTextField txtidU;
    private javax.swing.JTextField txtidU1;
    private javax.swing.JTextField txtidU2;
    private javax.swing.JTextField txtidU3;
    private javax.swing.JTextField txtidU4;
    private javax.swing.JTextField txtidUs;
    private javax.swing.JTextField txtidUsupr;
    // End of variables declaration//GEN-END:variables
}
