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
	public JLabel lblPubliMGModif;
	public JLabel lblPubliComentariosModif;
	public JLabel lblPubliContenidoModif;
	public JComboBox cbContenidoModif;
	public JTextField tfMGModif;
	public JTextField tfComentariosModif;
	public JLabel lblIDCreador;
	public JButton btnInsertarModif;
	public JButton btnBorrarDatosModif;
	public JLabel lblCreadorID;
	public JLabel lblPubliPlataforma;
	public JLabel lblPubliFecha;
	public JLabel lblPubliContenido;
	public JComboBox cbPubliPlataformasInsert;
	public String[] plataformas = {"YouTube","Twitch","Instagram","TikTok"};
	public JComboBox cbPubliContenidoInsert;
	public String[]contenido= {"imagen","video"};
	public JTextField tfPubliFechaInsert;
	public JTextField tfPubliIdCreadorInsert;
	public JButton btnInsertarPubli;
	public JButton btnBorrarDatosPubli;
	public JLabel lblPubliVistas;
	public JTextField tfPubliVistasInsert;
	public JLabel lblPubliGustas;
	public JLabel lblNComentarios;
	public JTextField tfPubliComentariosInsert;
	public JLabel lblNContenido;
	public JTextField tfPubliCompartidosInsert;
	public JTextField tfPubliGustasInsert;
	public JLabel lblColaboradorMostrar;
	public JLabel lblTematicaColabMostrar;
	public JLabel lblTipoMostrar;
	public JLabel lblEstadoMostrar;
	public JLabel lblUsuarioMostrar;
	public JLabel lblSeguidoresMostrar;
	public JLabel lblFCreacionMostrar;
	public JLabel lblMGVistas;
	public JButton btnBorrarPublicacion;
	public JComboBox cbPubliBorrar;
	public JPanel panelBotonesMetricas;
	public JButton btnMetricasRendimientoMetrica;
	public JButton btnCrearInformeMetrica;
	public JButton btnResumenRendimientoMetrica;
	public JButton btnVolverMetrica;
	public JPanel panelAnalisisMetricas;
	public JLabel lblContenidoMayorRendimientoMetrica;
	public JLabel lblTasaCrecimientoMetrica;
	public JLabel lblPlataformaMostrar;
	public JLabel lblContenidoMayorRendimientoMostrar;
	public JLabel lblTasaCrecimientoMostrar;
	public JLabel lblPlataformaMetricas;
	public JLabel lblMetricaPromedioVistas;
	public JLabel lblMetricaPromedioVistasMostrar;
	public JLabel lblCreadorMetricas;
	public JLabel lblPlataformaMetricas_2;
	public JLabel lblContenidoMayorRendimientoMostrar_1;
	public JLabel lblCreadorMostrar;
	public JLabel lblContenidoMayorRendimientoMostrar_3;
	public JLabel lblApartirde;
	public JTextField textField;
	public String[]VistasMg= {"Vistas","Me gusta"}; 

	
	
	

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
								
								//-------------------PANEL METRICAS------------------------------------------------------
								
								panelMetricas = new JPanel();
								panelMetricas.setBounds(10, 98, 659, 585);
								contentPane.add(panelMetricas);
								panelMetricas.setLayout(null);
								
								
								panelAnalisisMetricas = new JPanel();
								panelAnalisisMetricas.setEnabled(false);
								panelAnalisisMetricas.setVisible(false);
								
								btnVolverMetrica = new JButton("Volver");
								btnVolverMetrica.setFont(new Font("Agency FB", Font.BOLD, 16));
								btnVolverMetrica.setBackground(Color.WHITE);
								btnVolverMetrica.setBounds(559, 51, 90, 49);
								btnVolverMetrica.setVisible(false);
								panelMetricas.add(btnVolverMetrica);
								panelAnalisisMetricas.setBounds(0, 40, 659, 545);
								panelMetricas.add(panelAnalisisMetricas);
								panelAnalisisMetricas.setLayout(null);
								
								lblContenidoMayorRendimientoMetrica = new JLabel("Contenido mayor rendimiento:");
								lblContenidoMayorRendimientoMetrica.setHorizontalAlignment(SwingConstants.LEFT);
								lblContenidoMayorRendimientoMetrica.setFont(new Font("Agency FB", Font.BOLD, 22));
								lblContenidoMayorRendimientoMetrica.setBounds(new Rectangle(9, 0, 0, 0));
								lblContenidoMayorRendimientoMetrica.setBackground(Color.WHITE);
								lblContenidoMayorRendimientoMetrica.setAlignmentY(0.0f);
								lblContenidoMayorRendimientoMetrica.setBounds(273, 164, 227, 49);
								panelAnalisisMetricas.add(lblContenidoMayorRendimientoMetrica);
								
								lblTasaCrecimientoMetrica = new JLabel("T.Crecimiento 2023:");
								lblTasaCrecimientoMetrica.setHorizontalAlignment(SwingConstants.LEFT);
								lblTasaCrecimientoMetrica.setFont(new Font("Agency FB", Font.BOLD, 22));
								lblTasaCrecimientoMetrica.setBounds(new Rectangle(9, 0, 0, 0));
								lblTasaCrecimientoMetrica.setBackground(Color.WHITE);
								lblTasaCrecimientoMetrica.setAlignmentY(0.0f);
								lblTasaCrecimientoMetrica.setBounds(10, 282, 156, 49);
								panelAnalisisMetricas.add(lblTasaCrecimientoMetrica);
								
								lblPlataformaMostrar = new JLabel("");
								lblPlataformaMostrar.setHorizontalAlignment(SwingConstants.LEFT);
								lblPlataformaMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
								lblPlataformaMostrar.setBounds(new Rectangle(9, 0, 0, 0));
								lblPlataformaMostrar.setBackground(Color.WHITE);
								lblPlataformaMostrar.setAlignmentY(0.0f);
								lblPlataformaMostrar.setBounds(247, 44, 203, 49);
								panelAnalisisMetricas.add(lblPlataformaMostrar);
								
								lblContenidoMayorRendimientoMostrar = new JLabel("");
								lblContenidoMayorRendimientoMostrar.setHorizontalAlignment(SwingConstants.LEFT);
								lblContenidoMayorRendimientoMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
								lblContenidoMayorRendimientoMostrar.setBounds(new Rectangle(9, 0, 0, 0));
								lblContenidoMayorRendimientoMostrar.setBackground(Color.WHITE);
								lblContenidoMayorRendimientoMostrar.setAlignmentY(0.0f);
								lblContenidoMayorRendimientoMostrar.setBounds(493, 164, 134, 49);
								panelAnalisisMetricas.add(lblContenidoMayorRendimientoMostrar);
								
								lblTasaCrecimientoMostrar = new JLabel("");
								lblTasaCrecimientoMostrar.setHorizontalAlignment(SwingConstants.LEFT);
								lblTasaCrecimientoMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
								lblTasaCrecimientoMostrar.setBounds(new Rectangle(9, 0, 0, 0));
								lblTasaCrecimientoMostrar.setBackground(Color.WHITE);
								lblTasaCrecimientoMostrar.setAlignmentY(0.0f);
								lblTasaCrecimientoMostrar.setBounds(493, 223, 134, 49);
								panelAnalisisMetricas.add(lblTasaCrecimientoMostrar);
								
								lblPlataformaMetricas = new JLabel("Plataforma:");
								lblPlataformaMetricas.setHorizontalAlignment(SwingConstants.LEFT);
								lblPlataformaMetricas.setFont(new Font("Agency FB", Font.BOLD, 22));
								lblPlataformaMetricas.setBounds(new Rectangle(9, 0, 0, 0));
								lblPlataformaMetricas.setBackground(Color.WHITE);
								lblPlataformaMetricas.setAlignmentY(0.0f);
								lblPlataformaMetricas.setBounds(10, 164, 89, 49);
								panelAnalisisMetricas.add(lblPlataformaMetricas);
								
								lblMetricaPromedioVistas = new JLabel("Promedio vistas:");
								lblMetricaPromedioVistas.setHorizontalAlignment(SwingConstants.LEFT);
								lblMetricaPromedioVistas.setFont(new Font("Agency FB", Font.BOLD, 22));
								lblMetricaPromedioVistas.setBounds(new Rectangle(9, 0, 0, 0));
								lblMetricaPromedioVistas.setBackground(Color.WHITE);
								lblMetricaPromedioVistas.setAlignmentY(0.0f);
								lblMetricaPromedioVistas.setBounds(273, 282, 203, 49);
								panelAnalisisMetricas.add(lblMetricaPromedioVistas);
								
								lblMetricaPromedioVistasMostrar = new JLabel("");
								lblMetricaPromedioVistasMostrar.setHorizontalAlignment(SwingConstants.LEFT);
								lblMetricaPromedioVistasMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
								lblMetricaPromedioVistasMostrar.setBounds(new Rectangle(9, 0, 0, 0));
								lblMetricaPromedioVistasMostrar.setBackground(Color.WHITE);
								lblMetricaPromedioVistasMostrar.setAlignmentY(0.0f);
								lblMetricaPromedioVistasMostrar.setBounds(493, 282, 134, 49);
								panelAnalisisMetricas.add(lblMetricaPromedioVistasMostrar);
								
								lblCreadorMetricas = new JLabel("Creador:");
								lblCreadorMetricas.setHorizontalAlignment(SwingConstants.LEFT);
								lblCreadorMetricas.setFont(new Font("Agency FB", Font.BOLD, 22));
								lblCreadorMetricas.setBounds(new Rectangle(9, 0, 0, 0));
								lblCreadorMetricas.setBackground(Color.WHITE);
								lblCreadorMetricas.setAlignmentY(0.0f);
								lblCreadorMetricas.setBounds(10, 223, 89, 49);
								panelAnalisisMetricas.add(lblCreadorMetricas);
								
								lblPlataformaMetricas_2 = new JLabel("Promedio Me gusta:");
								lblPlataformaMetricas_2.setHorizontalAlignment(SwingConstants.LEFT);
								lblPlataformaMetricas_2.setFont(new Font("Agency FB", Font.BOLD, 22));
								lblPlataformaMetricas_2.setBounds(new Rectangle(9, 0, 0, 0));
								lblPlataformaMetricas_2.setBackground(Color.WHITE);
								lblPlataformaMetricas_2.setAlignmentY(0.0f);
								lblPlataformaMetricas_2.setBounds(273, 223, 156, 49);
								panelAnalisisMetricas.add(lblPlataformaMetricas_2);
								
								lblContenidoMayorRendimientoMostrar_1 = new JLabel("");
								lblContenidoMayorRendimientoMostrar_1.setHorizontalAlignment(SwingConstants.LEFT);
								lblContenidoMayorRendimientoMostrar_1.setFont(new Font("Agency FB", Font.PLAIN, 22));
								lblContenidoMayorRendimientoMostrar_1.setBounds(new Rectangle(9, 0, 0, 0));
								lblContenidoMayorRendimientoMostrar_1.setBackground(Color.WHITE);
								lblContenidoMayorRendimientoMostrar_1.setAlignmentY(0.0f);
								lblContenidoMayorRendimientoMostrar_1.setBounds(103, 164, 134, 49);
								panelAnalisisMetricas.add(lblContenidoMayorRendimientoMostrar_1);
								
								lblCreadorMostrar = new JLabel("");
								lblCreadorMostrar.setHorizontalAlignment(SwingConstants.LEFT);
								lblCreadorMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
								lblCreadorMostrar.setBounds(new Rectangle(9, 0, 0, 0));
								lblCreadorMostrar.setBackground(Color.WHITE);
								lblCreadorMostrar.setAlignmentY(0.0f);
								lblCreadorMostrar.setBounds(103, 223, 134, 49);
								panelAnalisisMetricas.add(lblCreadorMostrar);
								
								lblContenidoMayorRendimientoMostrar_3 = new JLabel("");
								lblContenidoMayorRendimientoMostrar_3.setHorizontalAlignment(SwingConstants.LEFT);
								lblContenidoMayorRendimientoMostrar_3.setFont(new Font("Agency FB", Font.PLAIN, 22));
								lblContenidoMayorRendimientoMostrar_3.setBounds(new Rectangle(9, 0, 0, 0));
								lblContenidoMayorRendimientoMostrar_3.setBackground(Color.WHITE);
								lblContenidoMayorRendimientoMostrar_3.setAlignmentY(0.0f);
								lblContenidoMayorRendimientoMostrar_3.setBounds(176, 282, 87, 49);
								panelAnalisisMetricas.add(lblContenidoMayorRendimientoMostrar_3);
								
								panelBotonesMetricas = new JPanel();
								panelBotonesMetricas.setLayout(null);
								panelBotonesMetricas.setBounds(84, 129, 501, 352);
								panelMetricas.add(panelBotonesMetricas);
								
								btnMetricasRendimientoMetrica = new JButton("METRICAS DE RENDIMIENTO");
								btnMetricasRendimientoMetrica.setFont(new Font("Agency FB", Font.BOLD, 16));
								btnMetricasRendimientoMetrica.setBackground(Color.WHITE);
								btnMetricasRendimientoMetrica.setBounds(0, 0, 243, 155);
								panelBotonesMetricas.add(btnMetricasRendimientoMetrica);
								
								btnCrearInformeMetrica = new JButton("CREAR INFORME JSON");
								btnCrearInformeMetrica.setFont(new Font("Agency FB", Font.BOLD, 16));
								btnCrearInformeMetrica.setBackground(Color.WHITE);
								btnCrearInformeMetrica.setBounds(258, 0, 243, 155);
								panelBotonesMetricas.add(btnCrearInformeMetrica);
								
								btnResumenRendimientoMetrica = new JButton("CREAR RESUMEN DE RENDIMIENTO");
								btnResumenRendimientoMetrica.setFont(new Font("Agency FB", Font.BOLD, 16));
								btnResumenRendimientoMetrica.setBackground(Color.WHITE);
								btnResumenRendimientoMetrica.setBounds(130, 197, 243, 155);
								panelBotonesMetricas.add(btnResumenRendimientoMetrica);
								
								lblpanelMetricas = new JLabel("METRICAS");
								lblpanelMetricas.setBounds(0, 0, 659, 40);
								lblpanelMetricas.setBackground(new Color(255, 204, 102));
								lblpanelMetricas.setOpaque(true);
								lblpanelMetricas.setBorder(new LineBorder(new Color(0, 0, 0)));
								lblpanelMetricas.setFont(new Font("Agency FB", Font.BOLD, 26));
								lblpanelMetricas.setHorizontalAlignment(SwingConstants.CENTER);
								panelMetricas.add(lblpanelMetricas);
						
								
								lblMsgCorrecto = new JLabel("");
								lblMsgCorrecto.setBounds(103, 130, 457, 62);
								contentPane.add(lblMsgCorrecto);
								lblMsgCorrecto.setFocusable(false);
								lblMsgCorrecto.setVisible(false);
								lblMsgCorrecto.setForeground(new Color(0, 255, 51));
								lblMsgCorrecto.setHorizontalAlignment(SwingConstants.CENTER);
								lblMsgCorrecto.setFont(new Font("Agency FB", Font.BOLD, 29));
						
						//-------------------PANEL PUBLICACIONES------------------------------------------
						panelPublicaciones = new JPanel();
						panelPublicaciones.setBounds(10, 98, 659, 585);
						contentPane.add(panelPublicaciones);
						panelPublicaciones.setLayout(null);
						
						panelModificarPubli = new JPanel();
						panelModificarPubli.setVisible(false);
						
						panelEliminarPubli = new JPanel();
						panelEliminarPubli.setVisible(false);
						
						//a
						btnVolverPubli = new JButton("Volver");
						btnVolverPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
						btnVolverPubli.setBackground(Color.WHITE);
						btnVolverPubli.setBounds(559, 51, 90, 49);
						btnVolverPubli.setVisible(false);
						
						panelPublicaciones.add(btnVolverPubli);
						panelEliminarPubli.setBounds(0, 41, 659, 544);
						panelPublicaciones.add(panelEliminarPubli);
						panelEliminarPubli.setLayout(null);
						
						lblMGVistas = new JLabel("ME GUSTA O VISTAS");
						lblMGVistas.setHorizontalAlignment(SwingConstants.CENTER);
						lblMGVistas.setFont(new Font("Agency FB", Font.BOLD, 22));
						lblMGVistas.setBounds(new Rectangle(9, 0, 0, 0));
						lblMGVistas.setBackground(Color.WHITE);
						lblMGVistas.setAlignmentY(0.0f);
						lblMGVistas.setBounds(158, 25, 323, 49);
						panelEliminarPubli.add(lblMGVistas);
						
						btnBorrarPublicacion = new JButton("BORRAR PUBLICACION");
						btnBorrarPublicacion.setFont(new Font("Agency FB", Font.BOLD, 16));
						btnBorrarPublicacion.setBackground(Color.WHITE);
						btnBorrarPublicacion.setBounds(250, 329, 161, 74);
						panelEliminarPubli.add(btnBorrarPublicacion);
						cbPubliBorrar = new JComboBox(VistasMg);
						
							cbPubliBorrar.setFont(new Font("Agency FB", Font.BOLD, 17));
							cbPubliBorrar.setBackground(new Color(255, 255, 255));
							cbPubliBorrar.setBounds(250, 84, 161, 21);
							panelEliminarPubli.add(cbPubliBorrar);
							
							lblApartirde = new JLabel("A PARTIR DE:");
							lblApartirde.setHorizontalAlignment(SwingConstants.CENTER);
							lblApartirde.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblApartirde.setBounds(new Rectangle(9, 0, 0, 0));
							lblApartirde.setBackground(Color.WHITE);
							lblApartirde.setAlignmentY(0.0f);
							lblApartirde.setBounds(158, 131, 323, 49);
							panelEliminarPubli.add(lblApartirde);
							
							textField = new JTextField();
							textField.setBounds(250, 190, 161, 21);
							panelEliminarPubli.add(textField);
							textField.setColumns(10);
							panelModificarPubli.setBounds(0, 41, 659, 544);
							panelPublicaciones.add(panelModificarPubli);
							panelModificarPubli.setLayout(null);
							
							lblPubliMGModif = new JLabel("Nº Me gustas:");
							lblPubliMGModif.setHorizontalAlignment(SwingConstants.CENTER);
							lblPubliMGModif.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblPubliMGModif.setBounds(new Rectangle(9, 0, 0, 0));
							lblPubliMGModif.setBackground(Color.WHITE);
							lblPubliMGModif.setAlignmentY(0.0f);
							lblPubliMGModif.setBounds(231, 166, 172, 49);
							panelModificarPubli.add(lblPubliMGModif);
							
							lblPubliComentariosModif = new JLabel("Nº Comentarios");
							lblPubliComentariosModif.setHorizontalAlignment(SwingConstants.CENTER);
							lblPubliComentariosModif.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblPubliComentariosModif.setBounds(new Rectangle(9, 0, 0, 0));
							lblPubliComentariosModif.setBackground(Color.WHITE);
							lblPubliComentariosModif.setAlignmentY(0.0f);
							lblPubliComentariosModif.setBounds(231, 261, 172, 49);
							panelModificarPubli.add(lblPubliComentariosModif);
							
							lblPubliContenidoModif = new JLabel("Contenido");
							lblPubliContenidoModif.setHorizontalAlignment(SwingConstants.CENTER);
							lblPubliContenidoModif.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblPubliContenidoModif.setBounds(new Rectangle(9, 0, 0, 0));
							lblPubliContenidoModif.setBackground(Color.WHITE);
							lblPubliContenidoModif.setAlignmentY(0.0f);
							lblPubliContenidoModif.setBounds(231, 56, 172, 49);
							panelModificarPubli.add(lblPubliContenidoModif);
							
							cbContenidoModif = new JComboBox();
							cbContenidoModif.setFont(new Font("Agency FB", Font.BOLD, 17));
							cbContenidoModif.setBackground(new Color(255, 255, 255));
							cbContenidoModif.setBounds(231, 122, 172, 21);
							panelModificarPubli.add(cbContenidoModif);
							
							tfMGModif = new JTextField();
							tfMGModif.setBounds(231, 225, 172, 21);
							panelModificarPubli.add(tfMGModif);
							tfMGModif.setColumns(10);
							
							tfComentariosModif = new JTextField();
							tfComentariosModif.setColumns(10);
							tfComentariosModif.setBounds(231, 320, 172, 21);
							panelModificarPubli.add(tfComentariosModif);
							
							btnInsertarModif = new JButton("CONFIRMAR");
							btnInsertarModif.setFont(new Font("Agency FB", Font.BOLD, 16));
							btnInsertarModif.setBackground(Color.WHITE);
							btnInsertarModif.setBounds(151, 364, 135, 74);
							panelModificarPubli.add(btnInsertarModif);
							
							btnBorrarDatosModif = new JButton("BORRAR DATOS");
							btnBorrarDatosModif.setFont(new Font("Agency FB", Font.BOLD, 16));
							btnBorrarDatosModif.setBackground(Color.WHITE);
							btnBorrarDatosModif.setBounds(348, 364, 135, 74);
							panelModificarPubli.add(btnBorrarDatosModif);
							
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
							btnAniadirPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
							btnAniadirPubli.setBackground(Color.WHITE);
							btnAniadirPubli.setBounds(0, 0, 200, 155);
							panelBotonesPublis.add(btnAniadirPubli);
							
							btnModificarPubli = new JButton("MODIFICAR PUBLICACION");
							btnModificarPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
							btnModificarPubli.setBackground(Color.WHITE);
							btnModificarPubli.setBounds(257, 0, 200, 155);
							panelBotonesPublis.add(btnModificarPubli);
							
							lblpanelPublicaciones = new JLabel("PUBLICACIONES");
							lblpanelPublicaciones.setBounds(0, 0, 659, 40);
							lblpanelPublicaciones.setBackground(new Color(255, 204, 102));
							lblpanelPublicaciones.setOpaque(true);
							lblpanelPublicaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
							lblpanelPublicaciones.setFont(new Font("Agency FB", Font.BOLD, 26));
							lblpanelPublicaciones.setHorizontalAlignment(SwingConstants.CENTER);
							panelPublicaciones.add(lblpanelPublicaciones);
							
							panelInsertarPubli = new JPanel();
							panelInsertarPubli.setVisible(false);
							panelInsertarPubli.setBounds(0, 41, 659, 544);
							panelPublicaciones.add(panelInsertarPubli);
							panelInsertarPubli.setLayout(null);
							
							lblCreadorID = new JLabel("ID Creador:");
							lblCreadorID.setHorizontalAlignment(SwingConstants.CENTER);
							lblCreadorID.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblCreadorID.setBounds(new Rectangle(9, 0, 0, 0));
							lblCreadorID.setBackground(Color.WHITE);
							lblCreadorID.setAlignmentY(0.0f);
							lblCreadorID.setBounds(85, 43, 172, 49);
							panelInsertarPubli.add(lblCreadorID);
							
							lblPubliPlataforma = new JLabel("Plataforma:");
							lblPubliPlataforma.setHorizontalAlignment(SwingConstants.CENTER);
							lblPubliPlataforma.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblPubliPlataforma.setBounds(new Rectangle(9, 0, 0, 0));
							lblPubliPlataforma.setBackground(Color.WHITE);
							lblPubliPlataforma.setAlignmentY(0.0f);
							lblPubliPlataforma.setBounds(85, 133, 172, 49);
							panelInsertarPubli.add(lblPubliPlataforma);
							
							lblPubliFecha = new JLabel("Fecha:");
							lblPubliFecha.setHorizontalAlignment(SwingConstants.CENTER);
							lblPubliFecha.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblPubliFecha.setBounds(new Rectangle(9, 0, 0, 0));
							lblPubliFecha.setBackground(Color.WHITE);
							lblPubliFecha.setAlignmentY(0.0f);
							lblPubliFecha.setBounds(85, 223, 172, 49);
							panelInsertarPubli.add(lblPubliFecha);
							
							lblPubliContenido = new JLabel("Contenido:");
							lblPubliContenido.setHorizontalAlignment(SwingConstants.CENTER);
							lblPubliContenido.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblPubliContenido.setBounds(new Rectangle(9, 0, 0, 0));
							lblPubliContenido.setBackground(Color.WHITE);
							lblPubliContenido.setAlignmentY(0.0f);
							lblPubliContenido.setBounds(85, 311, 172, 49);
							panelInsertarPubli.add(lblPubliContenido);
							
							cbPubliPlataformasInsert = new JComboBox(plataformas);
							cbPubliPlataformasInsert.setFont(new Font("Agency FB", Font.BOLD, 17));
							cbPubliPlataformasInsert.setBackground(Color.WHITE);
							cbPubliPlataformasInsert.setBounds(85, 192, 172, 21);
							panelInsertarPubli.add(cbPubliPlataformasInsert);
							
							cbPubliContenidoInsert = new JComboBox(contenido);
							cbPubliContenidoInsert.setFont(new Font("Agency FB", Font.BOLD, 17));
							cbPubliContenidoInsert.setBackground(Color.WHITE);
							cbPubliContenidoInsert.setBounds(85, 370, 172, 21);
							panelInsertarPubli.add(cbPubliContenidoInsert);
							
							tfPubliFechaInsert = new JTextField();
							tfPubliFechaInsert.setBounds(85, 282, 172, 19);
							panelInsertarPubli.add(tfPubliFechaInsert);
							tfPubliFechaInsert.setColumns(10);
							
							tfPubliIdCreadorInsert = new JTextField();
							tfPubliIdCreadorInsert.setBounds(85, 102, 172, 21);
							panelInsertarPubli.add(tfPubliIdCreadorInsert);
							tfPubliIdCreadorInsert.setColumns(10);
							
							btnInsertarPubli = new JButton("INSERTAR");
							btnInsertarPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
							btnInsertarPubli.setBackground(Color.WHITE);
							btnInsertarPubli.setBounds(158, 447, 135, 74);
							panelInsertarPubli.add(btnInsertarPubli);
							
							btnBorrarDatosPubli = new JButton("BORRAR DATOS");
							btnBorrarDatosPubli.setFont(new Font("Agency FB", Font.BOLD, 16));
							btnBorrarDatosPubli.setBackground(Color.WHITE);
							btnBorrarDatosPubli.setBounds(350, 447, 135, 74);
							panelInsertarPubli.add(btnBorrarDatosPubli);
							
							lblPubliVistas = new JLabel("Nº Vistas:");
							lblPubliVistas.setHorizontalAlignment(SwingConstants.CENTER);
							lblPubliVistas.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblPubliVistas.setBounds(new Rectangle(9, 0, 0, 0));
							lblPubliVistas.setBackground(Color.WHITE);
							lblPubliVistas.setAlignmentY(0.0f);
							lblPubliVistas.setBounds(350, 43, 172, 49);
							panelInsertarPubli.add(lblPubliVistas);
							
							tfPubliVistasInsert = new JTextField();
							tfPubliVistasInsert.setColumns(10);
							tfPubliVistasInsert.setBounds(350, 102, 172, 21);
							panelInsertarPubli.add(tfPubliVistasInsert);
							
							lblPubliGustas = new JLabel("Nº Me gustas:");
							lblPubliGustas.setHorizontalAlignment(SwingConstants.CENTER);
							lblPubliGustas.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblPubliGustas.setBounds(new Rectangle(9, 0, 0, 0));
							lblPubliGustas.setBackground(Color.WHITE);
							lblPubliGustas.setAlignmentY(0.0f);
							lblPubliGustas.setBounds(350, 133, 172, 49);
							panelInsertarPubli.add(lblPubliGustas);
							
							lblNComentarios = new JLabel("Nº Comentarios");
							lblNComentarios.setHorizontalAlignment(SwingConstants.CENTER);
							lblNComentarios.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblNComentarios.setBounds(new Rectangle(9, 0, 0, 0));
							lblNComentarios.setBackground(Color.WHITE);
							lblNComentarios.setAlignmentY(0.0f);
							lblNComentarios.setBounds(350, 223, 172, 49);
							panelInsertarPubli.add(lblNComentarios);
							
							tfPubliComentariosInsert = new JTextField();
							tfPubliComentariosInsert.setColumns(10);
							tfPubliComentariosInsert.setBounds(350, 282, 172, 19);
							panelInsertarPubli.add(tfPubliComentariosInsert);
							
							lblNContenido = new JLabel("Nº Compartidos");
							lblNContenido.setHorizontalAlignment(SwingConstants.CENTER);
							lblNContenido.setFont(new Font("Agency FB", Font.BOLD, 22));
							lblNContenido.setBounds(new Rectangle(9, 0, 0, 0));
							lblNContenido.setBackground(Color.WHITE);
							lblNContenido.setAlignmentY(0.0f);
							lblNContenido.setBounds(350, 311, 172, 49);
							panelInsertarPubli.add(lblNContenido);
							
							tfPubliCompartidosInsert = new JTextField();
							tfPubliCompartidosInsert.setColumns(10);
							tfPubliCompartidosInsert.setBounds(350, 371, 172, 19);
							panelInsertarPubli.add(tfPubliCompartidosInsert);
							
							tfPubliGustasInsert = new JTextField();
							tfPubliGustasInsert.setColumns(10);
							tfPubliGustasInsert.setBounds(350, 193, 172, 19);
							panelInsertarPubli.add(tfPubliGustasInsert);
				
				
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
				lblNombreMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblNombreMostrar.setBackground(Color.WHITE);
				lblNombreMostrar.setBounds(114, 60, 163, 49);
				panelDatosGenerales.add(lblNombreMostrar);
				
				lblPaisMostrar = new JLabel("");
				lblPaisMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblPaisMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblPaisMostrar.setBackground(Color.WHITE);
				lblPaisMostrar.setBounds(114, 119, 163, 49);
				panelDatosGenerales.add(lblPaisMostrar);
				
				lblTematicaMostrar = new JLabel("");
				lblTematicaMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblTematicaMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblTematicaMostrar.setBackground(Color.WHITE);
				lblTematicaMostrar.setBounds(114, 178, 163, 49);
				panelDatosGenerales.add(lblTematicaMostrar);
				
				lblSeguidoresTotalesMostrar = new JLabel("");
				lblSeguidoresTotalesMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblSeguidoresTotalesMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblSeguidoresTotalesMostrar.setBackground(Color.WHITE);
				lblSeguidoresTotalesMostrar.setBounds(496, 60, 153, 49);
				panelDatosGenerales.add(lblSeguidoresTotalesMostrar);
				
				lblInteraccionesTotalesMostrar = new JLabel("");
				lblInteraccionesTotalesMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblInteraccionesTotalesMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblInteraccionesTotalesMostrar.setBackground(Color.WHITE);
				lblInteraccionesTotalesMostrar.setBounds(496, 119, 153, 49);
				panelDatosGenerales.add(lblInteraccionesTotalesMostrar);
				
				lblPromedioVistasMensualesMostrar = new JLabel("");
				lblPromedioVistasMensualesMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblPromedioVistasMensualesMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblPromedioVistasMensualesMostrar.setBackground(Color.WHITE);
				lblPromedioVistasMensualesMostrar.setBounds(496, 178, 153, 49);
				panelDatosGenerales.add(lblPromedioVistasMensualesMostrar);
				
				lblTasaCrecimientoSeguidoresMostrar = new JLabel("");
				lblTasaCrecimientoSeguidoresMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblTasaCrecimientoSeguidoresMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
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
				CBColaboraciones.setBackground(Color.WHITE);
				CBColaboraciones.setFont(new Font("Agency FB", Font.BOLD, 17));
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
				lblSeguidores.setBounds(347, 428, 108, 49);
				panelDatosGenerales.add(lblSeguidores);
				
				lblFcreacion = new JLabel("F.Creacion:");
				lblFcreacion.setFont(new Font("Agency FB", Font.BOLD, 22));
				lblFcreacion.setBackground(Color.WHITE);
				lblFcreacion.setBounds(347, 487, 108, 49);
				panelDatosGenerales.add(lblFcreacion);
				
				lblLinea = new JLabel("");
				lblLinea.setBorder(new LineBorder(new Color(0, 0, 0)));
				lblLinea.setBounds(329, 335, 330, 250);
				panelDatosGenerales.add(lblLinea);
				
				lblColaboradorMostrar = new JLabel("");
				lblColaboradorMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblColaboradorMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblColaboradorMostrar.setBackground(Color.WHITE);
				lblColaboradorMostrar.setBounds(114, 367, 163, 49);
				panelDatosGenerales.add(lblColaboradorMostrar);
				
				lblTematicaColabMostrar = new JLabel("");
				lblTematicaColabMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblTematicaColabMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblTematicaColabMostrar.setBackground(Color.WHITE);
				lblTematicaColabMostrar.setBounds(114, 415, 163, 49);
				panelDatosGenerales.add(lblTematicaColabMostrar);
				
				lblTipoMostrar = new JLabel("");
				lblTipoMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblTipoMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblTipoMostrar.setBackground(Color.WHITE);
				lblTipoMostrar.setBounds(114, 467, 163, 49);
				panelDatosGenerales.add(lblTipoMostrar);
				
				lblEstadoMostrar = new JLabel("");
				lblEstadoMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblEstadoMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblEstadoMostrar.setBackground(Color.WHITE);
				lblEstadoMostrar.setBounds(114, 515, 163, 49);
				panelDatosGenerales.add(lblEstadoMostrar);
				
				lblUsuarioMostrar = new JLabel("");
				lblUsuarioMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblUsuarioMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblUsuarioMostrar.setBackground(Color.WHITE);
				lblUsuarioMostrar.setBounds(465, 367, 163, 49);
				panelDatosGenerales.add(lblUsuarioMostrar);
				
				lblSeguidoresMostrar = new JLabel("");
				lblSeguidoresMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblSeguidoresMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblSeguidoresMostrar.setBackground(Color.WHITE);
				lblSeguidoresMostrar.setBounds(465, 428, 163, 49);
				panelDatosGenerales.add(lblSeguidoresMostrar);
				
				lblFCreacionMostrar = new JLabel("");
				lblFCreacionMostrar.setHorizontalAlignment(SwingConstants.CENTER);
				lblFCreacionMostrar.setFont(new Font("Agency FB", Font.PLAIN, 22));
				lblFCreacionMostrar.setBackground(Color.WHITE);
				lblFCreacionMostrar.setBounds(465, 487, 163, 49);
				panelDatosGenerales.add(lblFCreacionMostrar);
				
				String[]VistasMg= {"Vistas","Me gusta"}; 
		
		
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
		btnJSONColab.setBounds(125, 197, 220, 155);
		panelBotonesColabs.add(btnJSONColab);
		btnJSONColab.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnJSONColab.setBackground(Color.WHITE);
		
		btnInsertarColab = new JButton("INSERTAR COLABORACION");
		btnInsertarColab.setBounds(0, 0, 200, 155);
		panelBotonesColabs.add(btnInsertarColab);
		btnInsertarColab.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnInsertarColab.setBackground(Color.WHITE);
		
		btnReporteColab = new JButton("CREAR REPORTE CSV");
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
				cbAnfitrion.setFont(new Font("Agency FB", Font.BOLD, 15));
				cbAnfitrion.setBackground(Color.WHITE);
				cbAnfitrion.setBounds(133, 95, 162, 21);
				panelInsertarColab.add(cbAnfitrion);
				
				cbInvitado = new JComboBox();
				cbInvitado.setFont(new Font("Agency FB", Font.BOLD, 15));
				cbInvitado.setBackground(Color.WHITE);
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
				btnInsertar.setFont(new Font("Agency FB", Font.BOLD, 16));
				btnInsertar.setBackground(Color.WHITE);
				btnInsertar.setBounds(158, 448, 135, 74);
				panelInsertarColab.add(btnInsertar);
				
				btnBorrar = new JButton("BORRAR DATOS");
				btnBorrar.setFont(new Font("Agency FB", Font.BOLD, 16));
				btnBorrar.setBackground(Color.WHITE);
				btnBorrar.setBounds(350, 448, 135, 74);
				panelInsertarColab.add(btnBorrar);
				
				btnVolverColab = new JButton("Volver");
				btnVolverColab.setFont(new Font("Agency FB", Font.BOLD, 16));
				btnVolverColab.setBackground(Color.WHITE);
				btnVolverColab.setBounds(559, 10, 90, 49);
				panelInsertarColab.add(btnVolverColab);
		ImageIcon icoYT = new ImageIcon(getClass().getResource("../img/youtube.jpg"));
		ImageIcon icoTW = new ImageIcon(getClass().getResource("../img/twitch.png"));
		ImageIcon icoTK = new ImageIcon(getClass().getResource("../img/tiktok.png"));
		ImageIcon icoIG = new ImageIcon(getClass().getResource("../img/instagram.png"));
		ImageIcon icoFondo = new ImageIcon(getClass().getResource("../img/fondo.jpg"));
		
		btnColaboraciones = new JButton("COLABORACIONES");
		btnColaboraciones.setBackground(new Color(255, 255, 255));
		btnColaboraciones.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnColaboraciones.setBounds(181, 10, 135, 74);
		contentPane.add(btnColaboraciones);
		
		btnMetricas = new JButton("METRICAS");
		btnMetricas.setBackground(new Color(255, 255, 255));
		btnMetricas.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnMetricas.setBounds(493, 9, 135, 74);
		contentPane.add(btnMetricas);
		

		
		
		//-------------------------------------------------PANEL PLATAFORMA---------------------------------------------------------
		
		btnDatos = new JButton("DATOS");
		btnDatos.setBackground(new Color(255, 255, 255));
		btnDatos.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnDatos.setBounds(30, 9, 135, 74);
		contentPane.add(btnDatos);
		
		btnInstagram = new JButton();
		btnInstagram.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnInstagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDatosPlataforma.setText("DATOS DE INSTAGRAM");
			}
		});
		btnInstagram.setBackground(new Color(255, 255, 255));
		btnInstagram.setBounds(787, 499, 77, 77);
		contentPane.add(btnInstagram);
		ImageIcon imgIG = new ImageIcon(icoIG.getImage().getScaledInstance(btnInstagram.getWidth(),btnInstagram.getHeight(),Image.SCALE_SMOOTH));
		btnInstagram.setIcon(imgIG);
		
		btnTikTok = new JButton();
		btnTikTok.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnTikTok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDatosPlataforma.setText("DATOS DE TIKTOK");
			}
		});
		btnTikTok.setBounds(787, 399, 77, 77);
		contentPane.add(btnTikTok);
		ImageIcon imgTK = new ImageIcon(icoTK.getImage().getScaledInstance(btnTikTok.getWidth(),btnTikTok.getHeight(),Image.SCALE_SMOOTH));
		btnTikTok.setIcon(imgTK);
		
		
		//-----------------------------------------------------------BOTONES PLATAFORMAS-------------------------------------

		
		btnYouTube = new JButton();
		btnYouTube.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnYouTube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDatosPlataforma.setText("DATOS DE YOUTUBE");
			}
		});
		btnYouTube.setBounds(692, 399, 77, 77);
		contentPane.add(btnYouTube);
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
		btnTwitch.setBounds(692, 499, 77, 77);
		contentPane.add(btnTwitch);
		ImageIcon imgTW = new ImageIcon(icoTW.getImage().getScaledInstance(btnTwitch.getWidth(),btnTwitch.getHeight(),Image.SCALE_SMOOTH));
		btnTwitch.setIcon(imgTW);
		
		lblPlataformas = new JLabel("PLATAFORMAS");
		lblPlataformas.setVerticalAlignment(SwingConstants.TOP);
		lblPlataformas.setHorizontalTextPosition(SwingConstants.LEFT);
		lblPlataformas.setOpaque(true);
		lblPlataformas.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblPlataformas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlataformas.setBackground(new Color(255, 255, 255));
		lblPlataformas.setBounds(679, 336, 196, 273);
		contentPane.add(lblPlataformas);
		
		btnPUBLICACIONES = new JButton("PUBLICACIONES");
		btnPUBLICACIONES.setBackground(new Color(255, 255, 255));
		btnPUBLICACIONES.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnPUBLICACIONES.setBounds(337, 10, 135, 74);
		contentPane.add(btnPUBLICACIONES);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Agency FB", Font.BOLD, 17));
		comboBox.setBounds(679, 144, 196, 62);
		contentPane.add(comboBox);
				
				lblCreadores = new JLabel("CREADORES");
				lblCreadores.setOpaque(true);
				lblCreadores.setHorizontalAlignment(SwingConstants.CENTER);
				lblCreadores.setFont(new Font("Agency FB", Font.BOLD, 24));
				lblCreadores.setBackground(Color.WHITE);
				lblCreadores.setBounds(679, 98, 196, 47);
				contentPane.add(lblCreadores);
				
				
				
				Fondo = new JLabel("");
				Fondo.setBounds(0, 0, 884, 693);
				contentPane.add(Fondo);
				ImageIcon imgFondo = new ImageIcon(icoFondo.getImage().getScaledInstance(Fondo.getWidth(),Fondo.getHeight(),Image.SCALE_SMOOTH));
				Fondo.setIcon(imgFondo);
		
	
				

				
		
	}
}
