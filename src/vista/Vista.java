package vista;

import java.awt.EventQueue;
import java.awt.Image;
import controlador.Controlador;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JTextField;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnDatos;
	public JButton btnColaboraciones;
	public JButton btnPUBLICACIONES;
	public JComboBox comboBox;
	public JButton btnMetricas;
	public JButton btnYouTube;
	public JButton btnTwitch;
	public JButton btnTikTok;
	public JButton btnInstagram;
	public JLabel lblPlataformas;
	public JLabel lblCreadores;
	public JPanel panelDatosGenerales;
	public JLabel lblDatosGenerales;
	public JLabel lblNombreCreador;
	public JLabel lblPais;
	public JLabel lblTematica;
	public JLabel lblSeguidoresTotales;
	public JLabel lblInteraccionesTotales;
	public JLabel lblPromedioVistasMensuales;
	public JLabel lblTasaCrecimientoSeguidores;
	public JLabel lblPaisMostrar;
	public JLabel lblTematicaMostrar;
	public JLabel lblSeguidoresTotalesMostrar;
	public JLabel lblInteraccionesTotalesMostrar;
	public JLabel lblPromedioVistasMensualesMostrar;
	public JLabel lblTasaCrecimientoSeguidoresMostrar;
	public JLabel lblNombreMostrar;
	public JLabel lblColaboraciones;
	public JLabel lblNombreColaborador;
	public JLabel lblTematicaColab;
	public JLabel lblTipoColab;
	public JLabel lblEstadoColab;
	public JLabel lblDatosPlataforma;
	public JComboBox CBColaboraciones;
	public JLabel lblUsuario;
	public JLabel lblSeguidores;
	public JLabel lblFcreacion;
	public JButton btnExportarDatosGenerales;
	public JLabel lblLinea;
	public JLabel Fondo;
	public JPanel panelColaboraciones;
	public JPanel panelPublicaciones;
	public JPanel panelMetricas;
	public JLabel lblpanelColaboraciones;
	public JLabel lblpanelPublicaciones;
	public JLabel lblpanelMetricas;
	public JButton btnInsertarColab;
	public JButton btnReporteColab;
	public JButton btnJSONColab;
	public JPanel panelBotonesColabs;
	public JLabel lblMsgCorrecto;
	public JPanel panelInsertarColab;
	public JLabel lblCreadorAnfitrion;
	public JLabel lblCreadorInvitado;
	public JComboBox cbAnfitrion;
	public JComboBox cbInvitado;
	public JLabel lblInsertarTematica;
	public JLabel lblInsertarFecha;
	public JLabel lblInsertarTipo;
	public JTextField tfTematica;
	public JTextField tfFechaInicio;
	public JTextField tfTipo;
	public JButton btnInsertar;
	public JButton btnBorrar;
	public JButton btnVolverColab;
	public JPanel panelBotonesPublis;
	public JButton btnEliminarPubli;
	public JButton btnAniadirPubli;
	public JButton btnModificarPubli;
	public JButton btnVolverPubli;
	public JPanel panelInsertarPubli;
	public JPanel panelModificarPubli;
	public JPanel panelEliminarPubli;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Controlador controlador = new Controlador(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//--------------------------------------------PANEL DATOS GENERALES---------------------------------
		panelDatosGenerales = new JPanel();
		panelDatosGenerales.setBackground(SystemColor.menu);
		panelDatosGenerales.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDatosGenerales.setBounds(10, 98, 659, 585);
		contentPane.add(panelDatosGenerales);
		panelDatosGenerales.setLayout(null);
		
		lblDatosGenerales = new JLabel("DATOS GENERALES");
		lblDatosGenerales.setBounds(0, 0, 659, 40);
		lblDatosGenerales.setBackground(new Color(255, 204, 102));
		lblDatosGenerales.setOpaque(true);
		lblDatosGenerales.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDatosGenerales.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblDatosGenerales.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatosGenerales.add(lblDatosGenerales);
		
		lblNombreCreador = new JLabel("Nombre:");
		lblNombreCreador.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreCreador.setBounds(new Rectangle(9, 0, 0, 0));
		lblNombreCreador.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNombreCreador.setBackground(new Color(255, 255, 255));
		lblNombreCreador.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblNombreCreador.setBounds(17, 60, 87, 49);
		panelDatosGenerales.add(lblNombreCreador);
		
		lblPais = new JLabel("Pais:");
		lblPais.setHorizontalAlignment(SwingConstants.LEFT);
		lblPais.setBackground(new Color(255, 255, 255));
		lblPais.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblPais.setBounds(17, 119, 94, 49);
		panelDatosGenerales.add(lblPais);
		
		lblTematica = new JLabel("Tematica:");
		lblTematica.setBackground(new Color(255, 255, 255));
		lblTematica.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTematica.setBounds(17, 178, 94, 49);
		panelDatosGenerales.add(lblTematica);
		
		lblSeguidoresTotales = new JLabel("Seguidores Totales:");
		lblSeguidoresTotales.setBackground(new Color(255, 255, 255));
		lblSeguidoresTotales.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblSeguidoresTotales.setBounds(303, 60, 186, 49);
		panelDatosGenerales.add(lblSeguidoresTotales);
		
		lblInteraccionesTotales = new JLabel("Interacciones Totales:");
		lblInteraccionesTotales.setBackground(new Color(255, 255, 255));
		lblInteraccionesTotales.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblInteraccionesTotales.setBounds(303, 119, 196, 49);
		panelDatosGenerales.add(lblInteraccionesTotales);
		
		lblPromedioVistasMensuales = new JLabel("Promedio V/M:");
		lblPromedioVistasMensuales.setBackground(new Color(255, 255, 255));
		lblPromedioVistasMensuales.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblPromedioVistasMensuales.setBounds(303, 178, 142, 49);
		panelDatosGenerales.add(lblPromedioVistasMensuales);
		
		lblTasaCrecimientoSeguidores = new JLabel("TCS:");
		lblTasaCrecimientoSeguidores.setBackground(new Color(255, 255, 255));
		lblTasaCrecimientoSeguidores.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTasaCrecimientoSeguidores.setBounds(17, 237, 87, 49);
		panelDatosGenerales.add(lblTasaCrecimientoSeguidores);
		
		lblNombreMostrar = new JLabel("");
		lblNombreMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreMostrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblNombreMostrar.setBackground(Color.WHITE);
		lblNombreMostrar.setBounds(114, 60, 163, 49);
		panelDatosGenerales.add(lblNombreMostrar);
		
		lblPaisMostrar = new JLabel("");
		lblPaisMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaisMostrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblPaisMostrar.setBackground(Color.WHITE);
		lblPaisMostrar.setBounds(114, 119, 163, 49);
		panelDatosGenerales.add(lblPaisMostrar);
		
		lblTematicaMostrar = new JLabel("");
		lblTematicaMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTematicaMostrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTematicaMostrar.setBackground(Color.WHITE);
		lblTematicaMostrar.setBounds(114, 178, 163, 49);
		panelDatosGenerales.add(lblTematicaMostrar);
		
		lblSeguidoresTotalesMostrar = new JLabel("");
		lblSeguidoresTotalesMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeguidoresTotalesMostrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblSeguidoresTotalesMostrar.setBackground(Color.WHITE);
		lblSeguidoresTotalesMostrar.setBounds(496, 60, 153, 49);
		panelDatosGenerales.add(lblSeguidoresTotalesMostrar);
		
		lblInteraccionesTotalesMostrar = new JLabel("");
		lblInteraccionesTotalesMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblInteraccionesTotalesMostrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblInteraccionesTotalesMostrar.setBackground(Color.WHITE);
		lblInteraccionesTotalesMostrar.setBounds(496, 119, 153, 49);
		panelDatosGenerales.add(lblInteraccionesTotalesMostrar);
		
		lblPromedioVistasMensualesMostrar = new JLabel("");
		lblPromedioVistasMensualesMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromedioVistasMensualesMostrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblPromedioVistasMensualesMostrar.setBackground(Color.WHITE);
		lblPromedioVistasMensualesMostrar.setBounds(496, 178, 153, 49);
		panelDatosGenerales.add(lblPromedioVistasMensualesMostrar);
		
		lblTasaCrecimientoSeguidoresMostrar = new JLabel("");
		lblTasaCrecimientoSeguidoresMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTasaCrecimientoSeguidoresMostrar.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTasaCrecimientoSeguidoresMostrar.setBackground(Color.WHITE);
		lblTasaCrecimientoSeguidoresMostrar.setBounds(114, 237, 163, 49);
		panelDatosGenerales.add(lblTasaCrecimientoSeguidoresMostrar);
		
		lblColaboraciones = new JLabel("COLABORACIONES");
		lblColaboraciones.setOpaque(true);
		lblColaboraciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblColaboraciones.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblColaboraciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblColaboraciones.setBackground(new Color(255, 204, 102));
		lblColaboraciones.setBounds(0, 296, 330, 40);
		panelDatosGenerales.add(lblColaboraciones);
		
		lblNombreColaborador = new JLabel("Colaborador:");
		lblNombreColaborador.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblNombreColaborador.setBackground(Color.WHITE);
		lblNombreColaborador.setBounds(17, 367, 108, 49);
		panelDatosGenerales.add(lblNombreColaborador);
		
		lblTematicaColab = new JLabel("Tematica:");
		lblTematicaColab.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTematicaColab.setBackground(Color.WHITE);
		lblTematicaColab.setBounds(17, 415, 87, 49);
		panelDatosGenerales.add(lblTematicaColab);
		
		lblTipoColab = new JLabel("Tipo:");
		lblTipoColab.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTipoColab.setBackground(Color.WHITE);
		lblTipoColab.setBounds(17, 467, 87, 49);
		panelDatosGenerales.add(lblTipoColab);
		
		lblEstadoColab = new JLabel("Estado:");
		lblEstadoColab.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblEstadoColab.setBackground(Color.WHITE);
		lblEstadoColab.setBounds(17, 515, 87, 49);
		panelDatosGenerales.add(lblEstadoColab);
		
		lblDatosPlataforma = new JLabel("DATOS PLATAFORMA");
		lblDatosPlataforma.setOpaque(true);
		lblDatosPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPlataforma.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblDatosPlataforma.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDatosPlataforma.setBackground(new Color(255, 204, 102));
		lblDatosPlataforma.setBounds(329, 296, 330, 40);
		panelDatosGenerales.add(lblDatosPlataforma);
		
		CBColaboraciones = new JComboBox();
		CBColaboraciones.setBounds(178, 342, 141, 21);
		panelDatosGenerales.add(CBColaboraciones);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(347, 367, 108, 49);
		panelDatosGenerales.add(lblUsuario);
		
		lblSeguidores = new JLabel("Seguidores:");
		lblSeguidores.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblSeguidores.setBackground(Color.WHITE);
		lblSeguidores.setBounds(347, 415, 108, 49);
		panelDatosGenerales.add(lblSeguidores);
		
		lblFcreacion = new JLabel("F.Creacion:");
		lblFcreacion.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblFcreacion.setBackground(Color.WHITE);
		lblFcreacion.setBounds(347, 467, 108, 49);
		panelDatosGenerales.add(lblFcreacion);
		
		btnExportarDatosGenerales = new JButton("Exportar Datos");
		btnExportarDatosGenerales.setBackground(new Color(255, 255, 255));
		btnExportarDatosGenerales.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnExportarDatosGenerales.setBounds(506, 237, 142, 55);
		panelDatosGenerales.add(btnExportarDatosGenerales);
		btnExportarDatosGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMsgCorrecto.setText("DATOS EXPORTADOS CORRECTAMENTE");
				lblMsgCorrecto.setVisible(true);

                // Crear un temporizador para ocultarlo después de 3 segundos
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // Ocultar el JLabel
                    	lblMsgCorrecto.setVisible(false);
                    }
                }, 3000); // 3000 milisegundos = 3 segundos
			}
		});
		
		lblLinea = new JLabel("");
		lblLinea.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLinea.setBounds(329, 335, 330, 250);
		panelDatosGenerales.add(lblLinea);

		
		lblMsgCorrecto = new JLabel("");
		lblMsgCorrecto.setBounds(103, 130, 457, 62);
		contentPane.add(lblMsgCorrecto);
		lblMsgCorrecto.setFocusable(false);
		lblMsgCorrecto.setVisible(false);
		lblMsgCorrecto.setForeground(new Color(0, 255, 51));
		lblMsgCorrecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgCorrecto.setFont(new Font("Agency FB", Font.BOLD, 29));
		

		
		
		//-------------------------------------------------PANEL PLATAFORMA---------------------------------------------------------
		
		btnDatos = new JButton("DATOS");
		btnDatos.setBackground(new Color(255, 255, 255));
		btnDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDatosGenerales.setVisible(true);
				panelDatosGenerales.enable(true);
				panelColaboraciones.setVisible(false);
				panelColaboraciones.enable(false);
				panelPublicaciones.setVisible(false);
				panelPublicaciones.enable(false);
				panelMetricas.setVisible(false);
				panelMetricas.enable(false);
			}
		});
		btnDatos.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnDatos.setBounds(30, 9, 135, 74);
		contentPane.add(btnDatos);
		
		btnColaboraciones = new JButton("COLABORACIONES");
		btnColaboraciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDatosGenerales.setVisible(false);
				panelDatosGenerales.enable(false);
				panelColaboraciones.setVisible(true);
				panelColaboraciones.enable(true);
				panelBotonesColabs.setVisible(true);
				panelInsertarColab.setVisible(false);
				panelPublicaciones.setVisible(false);
				panelPublicaciones.enable(false);
				panelMetricas.setVisible(false);
				panelMetricas.enable(false);
				
				
			}
		});
		btnColaboraciones.setBackground(new Color(255, 255, 255));
		btnColaboraciones.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnColaboraciones.setBounds(181, 10, 135, 74);
		contentPane.add(btnColaboraciones);
		
		btnPUBLICACIONES = new JButton("PUBLICACIONES");
		btnPUBLICACIONES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDatosGenerales.setVisible(false);
				panelDatosGenerales.enable(false);
				panelColaboraciones.setVisible(false);
				panelColaboraciones.enable(false);
				panelPublicaciones.setVisible(true);
				panelPublicaciones.enable(true);
				panelMetricas.setVisible(false);
				panelMetricas.enable(false);
			}
		});
		btnPUBLICACIONES.setBackground(new Color(255, 255, 255));
		btnPUBLICACIONES.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnPUBLICACIONES.setBounds(337, 10, 135, 74);
		contentPane.add(btnPUBLICACIONES);
		
		comboBox = new JComboBox();
		comboBox.setBounds(678, 66, 196, 334);
		contentPane.add(comboBox);
		
		btnMetricas = new JButton("METRICAS");
		btnMetricas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDatosGenerales.setVisible(false);
				panelDatosGenerales.enable(false);
				panelColaboraciones.setVisible(false);
				panelColaboraciones.enable(false);
				panelPublicaciones.setVisible(false);
				panelPublicaciones.enable(false);
				panelMetricas.setVisible(true);
				panelMetricas.enable(true);
			}
		});
		btnMetricas.setBackground(new Color(255, 255, 255));
		btnMetricas.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnMetricas.setBounds(493, 9, 135, 74);
		contentPane.add(btnMetricas);
		
		
		//-----------------------------------------------------------BOTONES PLATAFORMAS-------------------------------------

		
		btnYouTube = new JButton();
		btnYouTube.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnYouTube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDatosPlataforma.setText("DATOS DE YOUTUBE");
			}
		});
		btnYouTube.setBounds(691, 473, 77, 77);
		contentPane.add(btnYouTube);
		ImageIcon icoYT = new ImageIcon(getClass().getResource("../img/youtube.jpg"));
		ImageIcon imgYT = new ImageIcon(icoYT.getImage().getScaledInstance(btnYouTube.getWidth(),btnYouTube.getHeight(),Image.SCALE_SMOOTH));
		btnYouTube.setIcon(imgYT);
		
		
		btnTwitch = new JButton();
		btnTwitch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnTwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDatosPlataforma.setText("DATOS DE TWITCH");
			}
		});
		btnTwitch.setBackground(new Color(255, 255, 255));
		btnTwitch.setBounds(691, 573, 77, 77);
		contentPane.add(btnTwitch);
		ImageIcon icoTW = new ImageIcon(getClass().getResource("../img/twitch.png"));
		ImageIcon imgTW = new ImageIcon(icoTW.getImage().getScaledInstance(btnTwitch.getWidth(),btnTwitch.getHeight(),Image.SCALE_SMOOTH));
		btnTwitch.setIcon(imgTW);
		
		btnTikTok = new JButton();
		btnTikTok.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnTikTok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDatosPlataforma.setText("DATOS DE TIKTOK");
			}
		});
		btnTikTok.setBounds(786, 473, 77, 77);
		contentPane.add(btnTikTok);
		ImageIcon icoTK = new ImageIcon(getClass().getResource("../img/tiktok.png"));
		ImageIcon imgTK = new ImageIcon(icoTK.getImage().getScaledInstance(btnTikTok.getWidth(),btnTikTok.getHeight(),Image.SCALE_SMOOTH));
		btnTikTok.setIcon(imgTK);
		
		btnInstagram = new JButton();
		btnInstagram.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnInstagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDatosPlataforma.setText("DATOS DE INSTAGRAM");
			}
		});
		btnInstagram.setBackground(new Color(255, 255, 255));
		btnInstagram.setBounds(786, 573, 77, 77);
		contentPane.add(btnInstagram);
		ImageIcon icoIG = new ImageIcon(getClass().getResource("../img/instagram.png"));
		ImageIcon imgIG = new ImageIcon(icoIG.getImage().getScaledInstance(btnInstagram.getWidth(),btnInstagram.getHeight(),Image.SCALE_SMOOTH));
		btnInstagram.setIcon(imgIG);
		
		lblPlataformas = new JLabel("PLATAFORMAS");
		lblPlataformas.setVerticalAlignment(SwingConstants.TOP);
		lblPlataformas.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPlataformas.setOpaque(true);
		lblPlataformas.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblPlataformas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlataformas.setBackground(new Color(255, 255, 255));
		lblPlataformas.setBounds(678, 410, 196, 273);
		contentPane.add(lblPlataformas);
		
		lblCreadores = new JLabel("CREADORES");
		lblCreadores.setOpaque(true);
		lblCreadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreadores.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblCreadores.setBackground(Color.WHITE);
		lblCreadores.setBounds(678, 19, 196, 47);
		contentPane.add(lblCreadores);
		
		//-------------------PANEL PUBLICACIONES------------------------------------------
		panelPublicaciones = new JPanel();
		panelPublicaciones.setBounds(10, 98, 659, 585);
		contentPane.add(panelPublicaciones);
		panelPublicaciones.setLayout(null);
		
		lblpanelPublicaciones = new JLabel("PUBLICACIONES");
		lblpanelPublicaciones.setBounds(0, 0, 659, 40);
		lblpanelPublicaciones.setBackground(new Color(255, 204, 102));
		lblpanelPublicaciones.setOpaque(true);
		lblpanelPublicaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblpanelPublicaciones.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblpanelPublicaciones.setHorizontalAlignment(SwingConstants.CENTER);
		panelPublicaciones.add(lblpanelPublicaciones);
		
		panelBotonesPublis = new JPanel();
		panelBotonesPublis.setLayout(null);
		panelBotonesPublis.setBounds(102, 129, 457, 352);
		panelPublicaciones.add(panelBotonesPublis);
		
		btnEliminarPubli = new JButton("ELIMINAR PUBLICACION");
		btnEliminarPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnEliminarPubli.setBackground(Color.WHITE);
		btnEliminarPubli.setBounds(125, 197, 220, 155);
		panelBotonesPublis.add(btnEliminarPubli);
		
		btnAniadirPubli = new JButton("INSERTAR PUBLICACION");
		btnAniadirPubli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInsertarPubli.setVisible(true);
				panelBotonesPublis.setVisible(false);
				btnVolverPubli.setVisible(true);
			}
		});
		btnAniadirPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnAniadirPubli.setBackground(Color.WHITE);
		btnAniadirPubli.setBounds(0, 0, 200, 155);
		panelBotonesPublis.add(btnAniadirPubli);
		
		btnModificarPubli = new JButton("MODIFICAR PUBLICACION");
		btnModificarPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnModificarPubli.setBackground(Color.WHITE);
		btnModificarPubli.setBounds(257, 0, 200, 155);
		panelBotonesPublis.add(btnModificarPubli);
		//a
		btnVolverPubli = new JButton("Volver");
		btnVolverPubli.setVisible(false);
		btnVolverPubli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBotonesPublis.setVisible(true);
			}
		});
		btnVolverPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnVolverPubli.setBackground(Color.WHITE);
		btnVolverPubli.setBounds(559, 51, 90, 49);
		panelPublicaciones.add(btnVolverPubli);
		
		panelInsertarPubli = new JPanel();
		panelInsertarPubli.setBounds(0, 41, 659, 544);
		panelPublicaciones.add(panelInsertarPubli);
		
		panelModificarPubli = new JPanel();
		panelModificarPubli.setBounds(0, 41, 659, 544);
		panelPublicaciones.add(panelModificarPubli);
		
		panelEliminarPubli = new JPanel();
		panelEliminarPubli.setBounds(0, 41, 659, 544);
		panelPublicaciones.add(panelEliminarPubli);
		

		
		
		//--------------------------PANEL COLABORACIONES----------------------------------
		panelColaboraciones = new JPanel();
		panelColaboraciones.setBounds(10, 98, 659, 585);
		contentPane.add(panelColaboraciones);
		panelColaboraciones.setLayout(null);
		
		lblpanelColaboraciones = new JLabel("COLABORACIONES");
		lblpanelColaboraciones.setBounds(0, 0, 659, 40);
		lblpanelColaboraciones.setBackground(new Color(255, 204, 102));
		lblpanelColaboraciones.setOpaque(true);
		lblpanelColaboraciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblpanelColaboraciones.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblpanelColaboraciones.setHorizontalAlignment(SwingConstants.CENTER);
		panelColaboraciones.add(lblpanelColaboraciones);
		
		panelBotonesColabs = new JPanel();
		panelBotonesColabs.setBounds(102, 129, 457, 352);
		panelColaboraciones.add(panelBotonesColabs);
		panelBotonesColabs.setLayout(null);
		
		btnJSONColab = new JButton("EXPORTAR COLABORACIONES JSON");
		btnJSONColab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMsgCorrecto.setText("EXPORTACION REALIZADA CORRECTAMENTE");
				lblMsgCorrecto.setVisible(true);

                // Crear un temporizador para ocultarlo después de 5 segundos
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // Ocultar el JLabel
                    	lblMsgCorrecto.setVisible(false);
                    }
                }, 3000); // 3000 milisegundos = 3 segundos
			}
		});
		btnJSONColab.setBounds(125, 197, 220, 155);
		panelBotonesColabs.add(btnJSONColab);
		btnJSONColab.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnJSONColab.setBackground(Color.WHITE);
		
		btnInsertarColab = new JButton("INSERTAR COLABORACION");
		btnInsertarColab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBotonesColabs.setVisible(false);
				panelInsertarColab.setVisible(true);
			}
		});
		btnInsertarColab.setBounds(0, 0, 200, 155);
		panelBotonesColabs.add(btnInsertarColab);
		btnInsertarColab.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnInsertarColab.setBackground(Color.WHITE);
		
		btnReporteColab = new JButton("CREAR REPORTE CSV");
		btnReporteColab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMsgCorrecto.setText("REPORTE CREADO CORRECTAMENTE");
				lblMsgCorrecto.setVisible(true);

                // Crear un temporizador para ocultarlo después de 5 segundos
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // Ocultar el JLabel
                    	lblMsgCorrecto.setVisible(false);
                    }
                }, 3000); // 3000 milisegundos = 3 segundos
			}
		});
		btnReporteColab.setBounds(257, 0, 200, 155);
		panelBotonesColabs.add(btnReporteColab);
		btnReporteColab.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnReporteColab.setBackground(Color.WHITE);
		
		panelInsertarColab = new JPanel();
		panelInsertarColab.setEnabled(false);
		panelInsertarColab.setVisible(false);
		panelInsertarColab.setBounds(0, 40, 659, 545);
		panelColaboraciones.add(panelInsertarColab);
		panelInsertarColab.setLayout(null);

		
		lblCreadorAnfitrion = new JLabel("Creador Anfitrión");
		lblCreadorAnfitrion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreadorAnfitrion.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblCreadorAnfitrion.setBounds(new Rectangle(9, 0, 0, 0));
		lblCreadorAnfitrion.setBackground(Color.WHITE);
		lblCreadorAnfitrion.setAlignmentY(0.0f);
		lblCreadorAnfitrion.setBounds(123, 36, 172, 49);
		panelInsertarColab.add(lblCreadorAnfitrion);
		
		lblCreadorInvitado = new JLabel("Creador Invitado");
		lblCreadorInvitado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreadorInvitado.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblCreadorInvitado.setBounds(new Rectangle(9, 0, 0, 0));
		lblCreadorInvitado.setBackground(Color.WHITE);
		lblCreadorInvitado.setAlignmentY(0.0f);
		lblCreadorInvitado.setBounds(344, 36, 172, 49);
		panelInsertarColab.add(lblCreadorInvitado);
		
		cbAnfitrion = new JComboBox();
		cbAnfitrion.setBounds(133, 95, 162, 21);
		panelInsertarColab.add(cbAnfitrion);
		
		cbInvitado = new JComboBox();
		cbInvitado.setBounds(354, 95, 162, 21);
		panelInsertarColab.add(cbInvitado);
		
		lblInsertarTematica = new JLabel("Temática:");
		lblInsertarTematica.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarTematica.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblInsertarTematica.setBounds(new Rectangle(9, 0, 0, 0));
		lblInsertarTematica.setBackground(Color.WHITE);
		lblInsertarTematica.setAlignmentY(0.0f);
		lblInsertarTematica.setBounds(240, 139, 172, 49);
		panelInsertarColab.add(lblInsertarTematica);
		
		lblInsertarFecha = new JLabel("Fecha Inicio:");
		lblInsertarFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarFecha.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblInsertarFecha.setBounds(new Rectangle(9, 0, 0, 0));
		lblInsertarFecha.setBackground(Color.WHITE);
		lblInsertarFecha.setAlignmentY(0.0f);
		lblInsertarFecha.setBounds(240, 239, 172, 49);
		panelInsertarColab.add(lblInsertarFecha);
		
		lblInsertarTipo = new JLabel("Tipo:");
		lblInsertarTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertarTipo.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblInsertarTipo.setBounds(new Rectangle(9, 0, 0, 0));
		lblInsertarTipo.setBackground(Color.WHITE);
		lblInsertarTipo.setAlignmentY(0.0f);
		lblInsertarTipo.setBounds(240, 335, 172, 49);
		panelInsertarColab.add(lblInsertarTipo);
		
		tfTematica = new JTextField();
		tfTematica.setBounds(240, 198, 172, 27);
		panelInsertarColab.add(tfTematica);
		tfTematica.setColumns(10);
		
		tfFechaInicio = new JTextField();
		tfFechaInicio.setColumns(10);
		tfFechaInicio.setBounds(240, 298, 172, 27);
		panelInsertarColab.add(tfFechaInicio);
		
		tfTipo = new JTextField();
		tfTipo.setColumns(10);
		tfTipo.setBounds(240, 394, 172, 27);
		panelInsertarColab.add(tfTipo);
		
		btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTipo.setText("");
				tfTematica.setText("");
				tfFechaInicio.setText("");
				lblMsgCorrecto.setText("COLABORACION CREADA CORRECTAMENTE");
				lblMsgCorrecto.setVisible(true);

                // Crear un temporizador para ocultarlo después de 5 segundos
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // Ocultar el JLabel
                    	lblMsgCorrecto.setVisible(false);
                    }
                }, 3000); // 3000 milisegundos = 3 segundos
			}
		});
		btnInsertar.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnInsertar.setBackground(Color.WHITE);
		btnInsertar.setBounds(158, 448, 135, 74);
		panelInsertarColab.add(btnInsertar);
		
		btnBorrar = new JButton("BORRAR DATOS");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTipo.setText("");
				tfTematica.setText("");
				tfFechaInicio.setText("");
			}
		});
		btnBorrar.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setBounds(350, 448, 135, 74);
		panelInsertarColab.add(btnBorrar);
		
		btnVolverColab = new JButton("Volver");
		btnVolverColab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBotonesColabs.setVisible(true);
				panelInsertarColab.setVisible(false);
			}
		});
		btnVolverColab.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnVolverColab.setBackground(Color.WHITE);
		btnVolverColab.setBounds(559, 10, 90, 49);
		panelInsertarColab.add(btnVolverColab);
		
		//-------------------PANEL METRICAS------------------------------------------------------
		
		panelMetricas = new JPanel();
		panelMetricas.setBounds(10, 98, 659, 585);
		contentPane.add(panelMetricas);
		panelMetricas.setLayout(null);
		
		lblpanelMetricas = new JLabel("METRICAS");
		lblpanelMetricas.setBounds(0, 0, 659, 40);
		lblpanelMetricas.setBackground(new Color(255, 204, 102));
		lblpanelMetricas.setOpaque(true);
		lblpanelMetricas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblpanelMetricas.setFont(new Font("Agency FB", Font.BOLD, 26));
		lblpanelMetricas.setHorizontalAlignment(SwingConstants.CENTER);
		panelMetricas.add(lblpanelMetricas);
		
		Fondo = new JLabel("");
		Fondo.setBounds(0, 0, 884, 693);
		contentPane.add(Fondo);
		ImageIcon icoFondo = new ImageIcon(getClass().getResource("../img/fondo.jpg"));
		ImageIcon imgFondo = new ImageIcon(icoFondo.getImage().getScaledInstance(Fondo.getWidth(),Fondo.getHeight(),Image.SCALE_SMOOTH));
		Fondo.setIcon(imgFondo);
		
	}
}
