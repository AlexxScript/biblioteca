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
        
        String[] tituloLibro = {"titulo","editorial","pasta","volumen","tema","pagina","tipoLibro","autores","fecha de lanzamiento","idioma","cantidad","cantidadTotal","pasillo","repisa","anaquel","seccion","idE","idT","idU"};
        String[] tituloPeriodico = {"nombre","distribuidor","empresa","tipo de revista","fecha de lanzamiento","idioma","cantidad","cantidadTotal","pasillo","repisa","anaquel","seccion","idE","idT","idU"};
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
        txtTema = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPagina = new javax.swing.JTextField();
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
        otro8 = new javax.swing.JScrollPane();
        tblLibros4 = new javax.swing.JTable();
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
        btnUp3 = new javax.swing.JButton();
        btnLimL3 = new javax.swing.JButton();
        btnEl3 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        txtFLanz5 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        spCaR1 = new javax.swing.JSpinner();
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

        jLabel51.setText("Id del ejemplar");

        txtEPr.setEditable(false);

        jLabel52.setText("Nombre de usuario a quien se le prestará el ejemplar");

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
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEPr, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(otro, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Libros", jPanel1);

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

        jLabel70.setText("Nombre de usuario a quien se le prestará el ejemplar");

        btnPrestamo1.setText("Registrar prestamo");
        btnPrestamo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamo1ActionPerformed(evt);
            }
        });

        jLabel71.setText("Id del ejemplar");

        txtEPr1.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEPr1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnPrestamo1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(otro1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrestamo1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Periódicos", jPanel2);

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

        jLabel72.setText("Id del ejemplar");

        txtEPr2.setEditable(false);

        jLabel73.setText("Nombre de usuario a quien se le prestará el ejemplar");

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
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEPr2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPre2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnPrestamo2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addComponent(otro2, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEPr2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPre2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrestamo2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(otro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Revistas", jPanel3);

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

        jLabel74.setText("Id del ejemplar");

        txtEPr3.setEditable(false);

        jLabel75.setText("Nombre de usuario a quien se le prestará el ejemplar");

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
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEPr3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPre3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnPrestamo3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(otro3, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addComponent(btnPrestamo3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Artículos de investigación", jPanel4);

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

        btnPrestamo4.setText("Registrar prestamo");
        btnPrestamo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamo4ActionPerformed(evt);
            }
        });

        jLabel76.setText("Id del ejemplar");

        txtEPr4.setEditable(false);

        jLabel77.setText("Nombre de usuario a quien se le prestará el ejemplar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEPr4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPre4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnPrestamo4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(otro4, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addComponent(btnPrestamo4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Videos científicos", jPanel5);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel83.setText("Ingrese su dirección");

        jLabel84.setText("Ingrese su número telefónico");

        jLabel85.setText("Ingrese su nombre de usuario");

        jLabel86.setText("Ingrese su nombre");

        jLabel87.setText("Ingrese su apellido paterno");

        jLabel89.setText("Ingrese su apellido materno");

        cPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "visitante" }));
        cPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPerfilActionPerformed(evt);
            }
        });

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

        btnActUs.setText("Actualizar usuario");
        btnActUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActUsActionPerformed(evt);
            }
        });

        txtidUs.setEditable(false);

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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnActUs1)
                                .addComponent(btnActUs))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtidUs, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActUs, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnActUs1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", jPanel6);

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

        jLabel1.setText("Nombre del libro");

        jLabel2.setText("Editorial");

        jLabel3.setText("Tipo de pasta");

        jLabel4.setText("Volumen");

        jLabel5.setText("Tema");

        jLabel6.setText("Página");

        jLabel7.setText("Tipo de libro");

        jLabel8.setText("Fecha de lanzamiento");

        txtFLanz.setText("2024-12-20");

        jLabel9.setText("Cantidad de ejemplares");

        jLabel10.setText("Idioma");

        jLabel11.setText("Pasillo");

        jLabel12.setText("Repisa");

        jLabel13.setText("Anaquel");

        jLabel14.setText("Sección");

        btnRegLi.setText("Registrar Libro");
        btnRegLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLiActionPerformed(evt);
            }
        });

        jLabel15.setText("Autor");

        txtidU.setEditable(false);

        txtidE.setEditable(false);

        txtidT.setEditable(false);

        btnUp.setText(" Actualizar Libro");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnEl.setText("Eliminar Libro");
        btnEl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElActionPerformed(evt);
            }
        });

        btnLimL.setText("Limpiar");
        btnLimL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimLActionPerformed(evt);
            }
        });

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
                            .addComponent(jLabel13)
                            .addComponent(txtAnaquel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
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
                                .addGap(25, 25, 25))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(txtPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(txtPasillo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(txtRepisa, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(txtVol, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel82)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(spCaR4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(txtFLanz, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spCantidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)))
                        .addComponent(otro5, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnRegLi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnUp)
                .addGap(37, 37, 37)
                .addComponent(btnEl)
                .addGap(28, 28, 28)
                .addComponent(btnLimL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFLanz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel82)
                                    .addGap(28, 28, 28))
                                .addComponent(spCaR4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(otro5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegLi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("RegLibro", jPanel7);

        jLabel16.setText("Nombre del periódico");

        txtidE1.setEditable(false);

        txtidT1.setEditable(false);

        txtidU1.setEditable(false);

        txtAutor1.setEditable(false);
        txtAutor1.setText("Sin autor único");

        jLabel17.setText("Autor");

        jLabel19.setText("Titulo art");

        jLabel20.setText("Fecha de lanzamiento");

        txtFLanz1.setText("2024-12-20");

        jLabel21.setText("Idioma");

        txtIdioma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdioma1ActionPerformed(evt);
            }
        });

        jLabel22.setText("Sección");

        jLabel23.setText("Repisa");

        btnRegLi1.setText("Registrar Periodico");
        btnRegLi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLi1ActionPerformed(evt);
            }
        });

        btnUp1.setText(" Actualizar Periodico");
        btnUp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUp1ActionPerformed(evt);
            }
        });

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

        jLabel24.setText("Cantidad de ejemplares");

        jLabel26.setText("Empresa");

        jLabel27.setText("Tipo de periodico");

        jLabel28.setText("Distribuidor");

        jLabel29.setText("Pasillo");

        jLabel30.setText("Anaquel");

        jLabel25.setText("Fecha de publicación");

        txtFPu.setText("2024-12-20");

        jButton1.setText("Registrar articulo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel31.setText("Autor(es)");

        btnLimL1.setText("Limpiar");
        btnLimL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimL1ActionPerformed(evt);
            }
        });

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
                            .addComponent(jLabel19))
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
                                .addComponent(jLabel26)
                                .addComponent(jLabel30))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdioma1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFLanz1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel81)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(spCaR3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addGap(39, 39, 39)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel24)
                                                .addComponent(spCantidad1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(595, 595, 595)
                        .addComponent(btnLimL1)))
                .addContainerGap(632, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(btnRegLi1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(39, 39, 39)
                            .addComponent(btnUp1)
                            .addGap(37, 37, 37)
                            .addComponent(btnEl1)
                            .addGap(699, 699, 699))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(txtAnaquel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addComponent(txtSeccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 916, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
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
                                                    .addComponent(txtPasillo1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel23)
                                                        .addComponent(txtRepisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel8Layout.createSequentialGroup()
                                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtPasta1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtVol1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel17)
                                                        .addComponent(txtAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(otro6, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(10, 10, 10)))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel28)
                .addGap(33, 33, 33)
                .addComponent(jLabel27)
                .addGap(33, 33, 33)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
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
                        .addComponent(spCaR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addGap(43, 43, 43)
                .addComponent(btnLimL1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(txtAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPasillo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRepisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAnaquel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSeccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(otro6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRegLi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEl1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(btnUp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("RegPeriódico", jPanel8);

        jLabel35.setText("Nombre de la revista");

        txtidE3.setEditable(false);

        txtidT3.setEditable(false);

        txtidU3.setEditable(false);

        txtAutor3.setEditable(false);
        txtAutor3.setText("Sin autor único");

        jLabel36.setText("Autor");

        jLabel37.setText("Titulo art");

        jLabel38.setText("Fecha de lanzamiento");

        txtFLanz2.setText("2024-12-20");

        jLabel39.setText("Idioma");

        txtIdioma2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdioma2ActionPerformed(evt);
            }
        });

        jLabel40.setText("Sección");

        jLabel41.setText("Repisa");

        btnRegLi2.setText("Registrar Revista");
        btnRegLi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLi2ActionPerformed(evt);
            }
        });

        btnUp2.setText(" Actualizar Revista");
        btnUp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUp2ActionPerformed(evt);
            }
        });

        btnEl2.setText("Eliminar Revista");
        btnEl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEl2ActionPerformed(evt);
            }
        });

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

        jLabel42.setText("Cantidad de ejemplares");

        jLabel43.setText("Empresa");

        jLabel44.setText("Tipo de revista");

        jLabel45.setText("Distribuidor");

        jLabel46.setText("Pasillo");

        jLabel47.setText("Anaquel");

        jLabel48.setText("Fecha de publicación");

        txtFPu2.setText("2024-12-20");

        jButton3.setText("Registrar articulo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel49.setText("Autor(es)");

        btnLimL2.setText("Limpiar");
        btnLimL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimL2ActionPerformed(evt);
            }
        });

        jLabel80.setText("Cantidad de eje reales");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel44)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdioma2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFLanz2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel80)
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(spCaR2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel38)
                                            .addGap(39, 39, 39)
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel42)
                                                .addComponent(spCantidad2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTiart2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAuart2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel49))
                                    .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48)
                                    .addComponent(txtFPu2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel43)
                            .addComponent(jLabel47))
                        .addGap(292, 292, 292)
                        .addComponent(btnRegLi2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUp2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimL2)
                        .addGap(448, 448, 448))))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(txtAnaquel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel40)
                                .addComponent(txtSeccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 916, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEditorial3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtidT3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtidU3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtidE3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(25, 25, 25))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel35)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(txtPasillo2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel41)
                                                .addComponent(txtRepisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPasta3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtVol3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel36)
                                                .addComponent(txtAutor3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(otro8, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel45)
                .addGap(33, 33, 33)
                .addComponent(jLabel44)
                .addGap(33, 33, 33)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFPu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAuart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTiart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38))
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdioma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFLanz2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnLimL2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEl2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                .addComponent(btnUp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegLi2)))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addGap(28, 28, 28))
                            .addComponent(spCaR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(txtEditorial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
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
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPasillo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel41)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRepisa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAnaquel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel40)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSeccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(otro8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1299, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addGap(0, 34, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("RegRevista", jPanel10);

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

        jLabel18.setText("Titulo del artículo");

        jLabel32.setText("Instituto de proveniencia");

        jLabel33.setText("Área de especialidad");

        jLabel53.setText("Fecha de lanzamiento");

        txtFLanz3.setText("2024-12-20");

        jLabel54.setText("Cantidad de ejemplares");

        jLabel55.setText("Idioma");

        jLabel56.setText("Pasillo");

        jLabel57.setText("Repisa");

        jLabel58.setText("Anaquel");

        jLabel59.setText("Sección");

        btnRegLi3.setText("Registrar Artículo");
        btnRegLi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLi3ActionPerformed(evt);
            }
        });

        jLabel60.setText("Autor");

        txtidU2.setEditable(false);

        txtidE2.setEditable(false);

        txtidT2.setEditable(false);

        btnUp3.setText(" Actualizar Artículo");
        btnUp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUp3ActionPerformed(evt);
            }
        });

        btnLimL3.setText("Limpiar");
        btnLimL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimL3ActionPerformed(evt);
            }
        });

        btnEl3.setText("Eliminar Articulo");
        btnEl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEl3ActionPerformed(evt);
            }
        });

        jLabel69.setText("Fecha de escritura");

        txtFLanz5.setText("2024-12-20");

        jLabel79.setText("Cantidad de eje reales");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(txtAnaquel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(txtSeccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(25, 25, 25))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE))
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
                                .addGap(51, 51, 51)))
                        .addComponent(otro7, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnRegLi3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnUp3)
                .addGap(35, 35, 35)
                .addComponent(btnEl3)
                .addGap(30, 30, 30)
                .addComponent(btnLimL3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
                .addGap(31, 31, 31)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegLi3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimL3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEl3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addComponent(btnUp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1299, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("RegArticuloInvest", jPanel9);

        jLabel34.setText("Nombre del video");

        jLabel50.setText("Duración en minutos");

        jLabel61.setText("Fecha de lanzamiento");

        txtFLanz4.setText("2024-12-20");

        jLabel62.setText("Cantidad de ejemplares");

        jLabel63.setText("Idioma");

        jLabel64.setText("Pasillo");

        jLabel65.setText("Repisa");

        jLabel66.setText("Anaquel");

        jLabel67.setText("Sección");

        btnRegLi4.setText("Registrar Artículo");
        btnRegLi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLi4ActionPerformed(evt);
            }
        });

        jLabel68.setText("Autor");

        txtidU4.setEditable(false);

        txtidE4.setEditable(false);

        txtidT4.setEditable(false);

        btnUp4.setText(" Actualizar Artículo");
        btnUp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUp4ActionPerformed(evt);
            }
        });

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

        btnEl4.setText("Eliminar Articulo");
        btnEl4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEl4ActionPerformed(evt);
            }
        });

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
                .addGap(91, 91, 91)
                .addComponent(btnRegLi4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnUp4)
                .addGap(33, 33, 33)
                .addComponent(btnEl4)
                .addGap(50, 50, 50)
                .addComponent(btnLimL4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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

        jLabel90.setText("IdEjemplar");

        txtidPre.setEditable(false);

        jLabel91.setText("Id Prestamo");

        txtidUsupr.setEditable(false);

        jLabel92.setText("Id Usuario");

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
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(txtidEP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtidPre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel91, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtidUsupr, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel92, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
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
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidUsupr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel91)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtidPre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel90)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtidEP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prestamos", jPanel15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1299, Short.MAX_VALUE)
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
        lbc.eliminarProducto(txtidT1.getText(), tblPeriodico, tblLibros2,logg.getId_biblioteca());
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
        limpiarLibro();
    }//GEN-LAST:event_btnLimLActionPerformed

    private void btnElActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElActionPerformed
        // TODO add your handling code here:
        LibroDAO lbc = new LibroDAO();
        lbc.eliminarProducto(txtidT.getText(), tblLibros, tblLibros1,logg.getId_biblioteca());
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

            txtAutor.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
            txtFLanz.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString());
            txtIdioma.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 9).toString());
            spCantidad.setValue(receptor.getModel().getValueAt(receptor.getSelectedRow(), 10));
            spCaR4.setValue(receptor.getModel().getValueAt(receptor.getSelectedRow(), 11));

            txtPasillo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString());
            txtRepisa.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 13).toString());
            txtAnaquel.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 14).toString());
            txtSeccion.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 15).toString());

            txtTitulo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            txtEditorial.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txtPasta.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            txtVol.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            txtTipo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString());

            txtidE.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 16).toString());
            txtidT.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 17).toString());
            txtidU.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 18).toString());
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
        rev.eliminarProducto(txtidT3.getText(), tblRevista, tblLibros4,logg.getId_biblioteca());
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
        
        vd.eliminarProducto(txtidT4.getText(), tblVideo, tblLibros5, logg.getId_biblioteca());
    }//GEN-LAST:event_btnEl4ActionPerformed

    private void btnLimL4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimL4ActionPerformed
        // TODO add your handling code here:
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
            txtEPr.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 16).toString());
        }
    }//GEN-LAST:event_tblLibrosMouseClicked

    private void btnPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamoActionPerformed
        // TODO add your handling code here:
        PrestamoDAO pr = new PrestamoDAO();
        String res = pr.registrarPrestamo(txtEPr.getText(), txtPre.getText());
        System.out.println(res);
    }//GEN-LAST:event_btnPrestamoActionPerformed

    private void btnPrestamo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamo1ActionPerformed
        // TODO add your handling code here:
        PrestamoDAO pr = new PrestamoDAO();
        pr.registrarPrestamo(txtEPr1.getText(), txtPre1.getText());
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
        pr.registrarPrestamo(txtEPr2.getText(), txtPre2.getText());
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
        pr.registrarPrestamo(txtEPr3.getText(), txtPre3.getText());
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
        pr.registrarPrestamo(txtEPr4.getText(), txtPre4.getText());
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
        PrestamoDAO pre = new PrestamoDAO();
        pre.regresarPrestamo(txtidEP.getText(), txtidPre.getText(), txtidUsupr.getText(),tblPrestamo1);
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
    private javax.swing.JTextField txtPagina;
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
    private javax.swing.JTextField txtTema;
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
