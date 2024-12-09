package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import modelo.Colaboracion;
import modelo.Metrica;
import vista.Vista;

public class Controlador implements ActionListener, MouseListener {

	public Vista vista;
	private JsonNode rootNode;
	private ArrayNode creadoresNode ;
	private ObjectMapper mapper ;
	private List<Metrica>metricas ;
	private ArrayList <String> nombres ;
	private ArrayList <String> contenidos;
	private ArrayList <String> idNombres;
	private ArrayList <String> colabs;
	private ArrayList <String> filtros;
	private DefaultComboBoxModel<String> modelocombo;
	private String id, plataformanombre;
	private Double mediaVIG, mediaMIG, mediaVYT, mediaMYT, mediaVTK, mediaMTK, mediaVTW, mediaMTW;


	
	public Controlador(Vista frame) throws JsonProcessingException, IOException {
		
		this.vista = frame;
		this.idNombres = new ArrayList<String>();
		this.nombres = new ArrayList<String> ();
		this.contenidos = new ArrayList<String> ();
		this.colabs = new ArrayList<String>();
		this.filtros = new ArrayList<String>();

		this.metricas = abrirCSV("files\\metricas_contenido.csv");
		this.mapper = new ObjectMapper();
		
		crearJson();
		crearArrayComboBox();
		cargarContenido();
		//BOTONES GENERALES
		this.vista.btnDatos.addActionListener(this);
		this.vista.btnColaboraciones.addActionListener(this);
		this.vista.btnPUBLICACIONES.addActionListener(this);
		this.vista.btnMetricas.addActionListener(this);
		
		//BOTONES PLATAFORMAS
		this.vista.btnYouTube.addActionListener(this);
		this.vista.btnTwitch.addActionListener(this);
		this.vista.btnInstagram.addActionListener(this);
		this.vista.btnTikTok.addActionListener(this);
		
		
		//PANEL COLABORACIONES
		this.vista.btnInsertarColab.addActionListener(this);
		this.vista.btnJSONColab.addActionListener(this);
		this.vista.btnReporteColab.addActionListener(this);
		this.vista.btnInsertar.addActionListener(this);
		this.vista.btnBorrar.addActionListener(this);
		this.vista.btnVolverColab.addActionListener(this);
		
		//PANEL PUBLICACIONES
		this.vista.btnVolverPubli.addActionListener(this);
		this.vista.btnAniadirPubli.addActionListener(this);
		this.vista.btnModificarPubli.addActionListener(this);
		this.vista.btnEliminarPubli.addActionListener(this);
		this.vista.btnInsertarPubli.addActionListener(this);
		this.vista.btnBorrarDatosPubli.addActionListener(this);
		this.vista.btnInsertarModif.addActionListener(this);
		this.vista.btnBorrarDatosModif.addActionListener(this);
				
		//PANEL METRICAS
		this.vista.btnMetricasRendimientoMetrica.addActionListener(this);
		this.vista.btnCrearInformeMetrica.addActionListener(this);
		this.vista.btnResumenRendimientoMetrica.addActionListener(this);
		this.vista.btnVolverMetrica.addActionListener(this);
				
		//ESCONDER PANELES		
		this.vista.panelColaboraciones.setVisible(false);
		this.vista.panelPublicaciones.setVisible(false);
		this.vista.panelMetricas.setVisible(false);
		
		cargarComboBox(vista.comboBox, idNombres);
		cargarComboBox(vista.CBColaboraciones, nombres);
		cargarComboBox(vista.cbAnfitrion, idNombres);
		cargarComboBox(vista.cbInvitado, idNombres);
		cargarComboBox(vista.cbContenidoModif, contenidos);
		cargarComboBox(vista.cbPubliBorrar, colabs);
		

		
	}
	
	public void temporizador() {
		vista.lblMsgCorrecto.setVisible(true);

        // Crear un temporizador para ocultarlo después de 5 segundos
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Ocultar el JLabel
            	vista.lblMsgCorrecto.setVisible(false);
            	vista.lblMsgCorrecto.setBounds(103,130,457,62);
            }
        }, 3000); // 3000 milisegundos = 3 segundos
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
        vista.comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	colabs.clear();
                String seleccion = (String) vista.comboBox.getSelectedItem();
                
                sacarID(seleccion);
                recorrerDatos();
            	rellenarcolab();
      			contenidoStrong();
      			promedios_MGV();
      			mejorPlataforma ();
      			vista.lblColaboradorMostrar.setText("");
      			vista.lblTematicaColabMostrar.setText("");
      			vista.lblTipoMostrar.setText("");
      			vista.lblUsuarioMostrar.setText("");
      			vista.lblUsuarioMostrar.setText("");
      			vista.lblEstadoMostrar.setText("");
      			vista.lblSeguidoresMostrar.setText("");
      			vista.lblFCreacionMostrar.setText("");
      			try {
					resumenRendimiento();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

                cargarComboBox(vista.CBColaboraciones, colabs);
                
                // Actualizar la etiqueta con la selección
                System.out.println(id);
            }
        });
        
        vista.CBColaboraciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                String seleccion = (String) vista.CBColaboraciones.getSelectedItem();
                rellenarcamposcolab(seleccion);

            	
                
                
                System.out.println(id);
            }
        });

		
      //-----------------------BOTONES MENU GENERAL
      		if(e.getSource()==vista.btnDatos) {
    			cargarComboBox(vista.comboBox, idNombres);

      			vista.panelDatosGenerales.setVisible(true);
      			vista.panelDatosGenerales.enable(true);
      			vista.panelColaboraciones.setVisible(false);
      			vista.panelColaboraciones.enable(false);
      			vista.panelPublicaciones.setVisible(false);
      			vista.panelPublicaciones.enable(false);
      			vista.panelMetricas.setVisible(false);
      			vista.panelMetricas.enable(false);
      			
      		}
      		if(e.getSource()==vista.btnColaboraciones) {
      			vista.panelDatosGenerales.setVisible(false);
      			vista.panelDatosGenerales.enable(false);
      			vista.panelColaboraciones.setVisible(true);
      			vista.panelColaboraciones.enable(true);
      			vista.panelBotonesColabs.setVisible(true);
      			vista.panelInsertarColab.setVisible(false);
      			vista.panelPublicaciones.setVisible(false);
      			vista.panelPublicaciones.enable(false);
      			vista.panelMetricas.setVisible(false);
      			vista.panelMetricas.enable(false);
      			vista.panelBotonesColabs.setVisible(true);
      			vista.panelInsertarColab.setVisible(false);
      		}
      		if(e.getSource()==vista.btnPUBLICACIONES) {
      			vista.panelDatosGenerales.setVisible(false);
      			vista.panelDatosGenerales.enable(false);
      			vista.panelColaboraciones.setVisible(false);
      			vista.panelColaboraciones.enable(false);
      			vista.panelPublicaciones.setVisible(true);
      			vista.panelPublicaciones.enable(true);
      			vista.panelMetricas.setVisible(false);
      			vista.panelMetricas.enable(false);
      			vista.panelBotonesPublis.setVisible(true);
      			vista.panelEliminarPubli.setVisible(false);
      			vista.panelInsertarPubli.setVisible(false);
      			vista.panelModificarPubli.setVisible(false);
      			vista.btnVolverPubli.setVisible(false);
      		}
      		if(e.getSource()==vista.btnMetricas) {
      			vista.panelDatosGenerales.setVisible(false);
      			vista.panelDatosGenerales.enable(false);
      			vista.panelColaboraciones.setVisible(false);
      			vista.panelColaboraciones.enable(false);
      			vista.panelPublicaciones.setVisible(false);
      			vista.panelPublicaciones.enable(false);
      			vista.panelMetricas.setVisible(true);
      			vista.panelMetricas.enable(true);
      			vista.panelBotonesMetricas.setVisible(true);
      			vista.panelAnalisisMetricas.setVisible(false);
      			vista.btnVolverMetrica.setVisible(false);
      			
      		}
      		
      		
      		//------------------------------------BOTON YOUTUBE-----------------------------------------------
      		if(e.getSource()==vista.btnYouTube) {
      			vista.lblDatosPlataforma.setText("DATOS DE YOUTUBE");
      			plataformanombre = "YouTube";
      			
      			rellenarCamposPlataforma();
      			contenidoStrong();
      			

      		}
      		//------------------------------------BOTON TWITCH------------------------------------------------
      		if(e.getSource()==vista.btnTwitch) {
      			vista.lblDatosPlataforma.setText("DATOS DE TWITCH");
      			plataformanombre = "Twitch";
      			rellenarCamposPlataforma();
      			contenidoStrong();
      		}
      		//------------------------------------BOTON INSTAGRAM---------------------------------------------
      		if(e.getSource()==vista.btnInstagram) {
      			vista.lblDatosPlataforma.setText("DATOS DE INSTAGRAM");
      			plataformanombre = "Instagram";
      			rellenarCamposPlataforma();
      			contenidoStrong();
      		}
      		//------------------------------------BOTON TIKTOK------------------------------------------------
      		if(e.getSource()==vista.btnTikTok) {
      			vista.lblDatosPlataforma.setText("DATOS DE TIKTOK");
      			plataformanombre = "TikTok";
      			rellenarCamposPlataforma();
      			contenidoStrong();
      		}
      		
      		//-------------------------- DATOS GENERALES----------------------------
      		
      		//-------------------------------COLABORACIONES -------------------------
      		if(e.getSource()==vista.btnInsertarColab) {
      			vista.panelBotonesColabs.setVisible(false);
      			vista.panelInsertarColab.setVisible(true);
      		}
      		
      		if(e.getSource()==vista.btnInsertar) {
      			if(vista.tfTipo.getText().equals("")||vista.tfTematica.getText().equals("")||vista.tfFechaInicio.getText().equals("")) {
      				vista.lblMsgCorrecto.setText("UNO O VARIOS CAMPOS SON INCORRECTOS");
      				vista.lblMsgCorrecto.setForeground(new Color(255,0,0));
      				temporizador();
      				
      				
      			}else{
      				vista.tfTipo.setText("");
      				vista.tfTematica.setText("");
      				vista.tfFechaInicio.setText("");
      				vista.lblMsgCorrecto.setForeground(new Color(0,255,0));
      				vista.lblMsgCorrecto.setText("COLABORACION CREADA CORRECTAMENTE");
      				temporizador();
      				insercion();

      			}
      			
      		}
      		
      		if(e.getSource()==vista.btnBorrar) {
      			vista.tfTipo.setText("");
      			vista.tfTematica.setText("");
      			vista.tfFechaInicio.setText("");
      			
      		}
      		if(e.getSource()==vista.btnVolverColab) {
      			vista.panelBotonesColabs.setVisible(true);
      			vista.panelInsertarColab.setVisible(false);
      		}
      		if(e.getSource()==vista.btnJSONColab) {
      			vista.lblMsgCorrecto.setText("EXPORTACION REALIZADA CORRECTAMENTE");
      			vista.lblMsgCorrecto.setVisible(true);
      			vista.lblMsgCorrecto.setForeground(new Color(0,255,0));
      			temporizador();
      			try {
					colaboradorestoJson();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
      		}
      		if(e.getSource()==vista.btnReporteColab) {
      			
      			colaboracionestoCSV();
      			reporteColaboraciontoCSV();
      			vista.lblMsgCorrecto.setText("REPORTE REALIZADO CORRECTAMENTE");
      			vista.lblMsgCorrecto.setVisible(true);
      			vista.lblMsgCorrecto.setForeground(new Color(0,255,0));
      			temporizador();
      		}
      		
      		
      		//-----------------------PUBLICACIONES-------------------------------------------
      		//-------------------------- PANEL AÑADIR PUBLICACIONES-----------------
      		if(e.getSource()==vista.btnVolverPubli) {
      			vista.panelBotonesPublis.setVisible(true);
      			vista.panelInsertarPubli.setVisible(false);
      			vista.panelModificarPubli.setVisible(false);
      			vista.panelEliminarPubli.setVisible(false);
      			vista.btnVolverPubli.setVisible(false);
      			vista.tfPubliComentariosInsert.setText("");
      			vista.tfPubliCompartidosInsert.setText("");
      			vista.tfPubliFechaInsert.setText("");
      			vista.tfPubliGustasInsert.setText("");
      			vista.tfPubliIdCreadorInsert.setText("");
      			vista.tfPubliVistasInsert.setText("");
      			vista.tfComentariosModif.setText("");
      			vista.tfMGModif.setText("");
      		}
      		if(e.getSource()==vista.btnAniadirPubli) {
      			vista.panelInsertarPubli.setVisible(true);
      			vista.panelBotonesPublis.setVisible(false);
      			vista.btnVolverPubli.setVisible(true);
      			
      		}
      		if(e.getSource()==vista.btnInsertarPubli) {
      			if(vista.tfPubliFechaInsert.getText().equals("")||vista.tfPubliIdCreadorInsert.getText().equals("")||vista.tfPubliVistasInsert.getText().equals("")||vista.tfPubliGustasInsert.getText().equals("")
      					||vista.tfPubliComentariosInsert.getText().equals("")){
      				vista.lblMsgCorrecto.setText("UNO O VARIOS CAMPOS SON INCORRECTOS");
      				vista.lblMsgCorrecto.setForeground(new Color(255,0,0));
      				temporizador();
      			}else{
      				vista.tfPubliFechaInsert.setText("");
          			vista.tfPubliIdCreadorInsert.setText("");
          			vista.tfPubliComentariosInsert.setText("");
          			vista.tfPubliCompartidosInsert.setText("");
          			vista.tfPubliFechaInsert.setText("");
          			vista.tfPubliGustasInsert.setText("");
          			vista.tfPubliIdCreadorInsert.setText("");
          			vista.tfPubliVistasInsert.setText("");
      				vista.lblMsgCorrecto.setForeground(new Color(0,255,0));
      				addMetricas();
      				vista.lblMsgCorrecto.setText("PUBLICACION CREADA CORRECTAMENTE");
      				temporizador();
      			}
      		}
      		
      		if(e.getSource()==vista.btnBorrarDatosPubli) {
      			vista.tfPubliFechaInsert.setText("");
      			vista.tfPubliIdCreadorInsert.setText("");
      			vista.tfPubliComentariosInsert.setText("");
      			vista.tfPubliCompartidosInsert.setText("");
      			vista.tfPubliFechaInsert.setText("");
      			vista.tfPubliGustasInsert.setText("");
      			vista.tfPubliIdCreadorInsert.setText("");
      			vista.tfPubliVistasInsert.setText("");
      		}
      		
      		//BOTONES MODIFICAR PUBLI
      		if(e.getSource()==vista.btnModificarPubli) {
      			
      			vista.panelModificarPubli.setVisible(true);
      			vista.panelBotonesPublis.setVisible(false);
      			vista.btnVolverPubli.setVisible(true);
      		}
      		if (e.getSource()==vista.btnInsertarModif) {
      			if ((vista.tfMGModif.getText().equals("")) || vista.tfComentariosModif.getText().equals("")){
      				vista.lblMsgCorrecto.setText("UNO O VARIOS CAMPOS SON INCORRECTOS");
      				vista.lblMsgCorrecto.setForeground(new Color(255,0,0));
      				temporizador();
      			}else {
      				
      				String tfComent = vista.tfComentariosModif.getText();
      				int numTfComent = Integer.parseInt(tfComent);
      				vista.lblMsgCorrecto.setForeground(new Color(0,255,0));
      				modMetricas();
      				vista.lblMsgCorrecto.setText("PUBLICACION MODIFICADA CORRECTAMENTE");
      				temporizador();
      				vista.tfComentariosModif.setText("");
      				vista.tfMGModif.setText("");
      			}
      		}
      		
      		if (e.getSource()==vista.btnBorrarDatosModif) {
      			vista.tfComentariosModif.setText("");
      			vista.tfMGModif.setText("");
      		}

      		
      		//BOTONES ELIMINAR PUBLI
      		if(e.getSource()==vista.btnEliminarPubli) {
      			rellenarFiltros ();
      			cargarComboBox(vista.cbPubliBorrar, filtros);
      			vista.panelEliminarPubli.setVisible(true);
      			vista.panelBotonesPublis.setVisible(false);
      			vista.btnVolverPubli.setVisible(true);
      		}
      		if (e.getSource()== vista.btnBorrarPublicacion) {
      			delMetricas ();
      		}

      		//-------------METRICAS-------------
      		//BOTONES PANEL BOTONES
      		if(e.getSource()==vista.btnVolverMetrica) {
      			vista.btnVolverMetrica.setVisible(false);
      			vista.panelBotonesMetricas.setVisible(true);
      			vista.panelAnalisisMetricas.setVisible(false);
      		}
      		if(e.getSource()==vista.btnMetricasRendimientoMetrica) {
      			vista.panelBotonesMetricas.setVisible(false);
      			vista.btnVolverMetrica.setVisible(true);
      			vista.panelAnalisisMetricas.setVisible(true);
      		}
      		if (e.getSource()==vista.btnCrearInformeMetrica) {
      			vista.lblMsgCorrecto.setForeground(new Color(0,255,0));
  				vista.lblMsgCorrecto.setText("INFORME CREADO CORRECTAMENTE");
  				temporizador();
      			try {
					generarJson();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
      		}
      		if(e.getSource()== vista.btnResumenRendimientoMetrica) {
      			try {
					resumenRendimiento();
					vista.lblMsgCorrecto.setForeground(new Color(0,255,0));
	  				vista.lblMsgCorrecto.setText("RESUMEN CREADO CORRECTAMENTE");
	  				temporizador();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
      		}
	
	}
	
	
	
	public void rellenarCamposPlataforma () {
		for (JsonNode creador : creadoresNode) {
			if (creador.get("id").asText().equals(id)) {
				for (JsonNode plataforma : creador.get("plataformas")) {
					if (plataforma.get("nombre").asText().equalsIgnoreCase(plataformanombre)) {
						this.vista.lblUsuarioMostrar.setText(plataforma.get("usuario").asText());
						this.vista.lblSeguidoresMostrar.setText(plataforma.get("seguidores").asText());
						this.vista.lblFCreacionMostrar.setText(plataforma.get("fecha_creacion").asText().toString());
					}
				}
			}
		}

	}

	public void rellenarcamposcolab(String eleccion) {

		String texto = eleccion;
		String[] partes = texto.split("-");
		
		String nombre = partes[0].trim(); 
		String tematica = partes[1].trim(); 
		

		for (JsonNode creador : creadoresNode) {
				if (creador.get("id").asText().equals(id)) {
					for (JsonNode colaboracion : creador.get("colaboraciones")){
						if (colaboracion.get("colaborador").asText().equalsIgnoreCase(nombre) &&colaboracion.get("tematica").asText().equalsIgnoreCase(tematica));
						this.vista.lblColaboradorMostrar.setText((colaboracion.get("colaborador").asText()));
						this.vista.lblTematicaColabMostrar.setText(colaboracion.get("tematica").asText());
						this.vista.lblTipoMostrar.setText(colaboracion.get("tipo").asText());
						this.vista.lblEstadoMostrar.setText(colaboracion.get("estado").asText());
						
						System.out.println();
						System.out.println(colaboracion.get("tipo").asText());
						System.out.println(colaboracion.get("estado"));
					}
					System.out.println("-----------------");
				}
		}
		
	}
	
	
	
	public void resumenRendimiento () throws JsonGenerationException, JsonMappingException, IOException {
		ArrayNode colaboradores = mapper.createArrayNode();
		int sumavistasYt=0, interaccionesYt=0, sumavistasTw=0, sumavistasIg=0, sumavistasTk=0, interaccionesIg=0, interaccionesTk=0, interaccionesTw=0;
		double promedioYt=0.0, promedioTk=0.0, promedioIg=0.0, promedioTw=0.0;
		for (JsonNode creador : creadoresNode) {
			ObjectNode colaborador = mapper.createObjectNode();
			System.out.println(creador.get("id").asInt());
			colaborador.put("id", creador.get("id").asInt());
			for(int i=0; i<metricas.size();i++) {
				if (creador.get("id").asInt() == metricas.get(i).getCreador_id()){
					if (metricas.get(i).getPlataforma().equalsIgnoreCase("Youtube") && (metricas.get(i).getFecha().split("-")[0].equalsIgnoreCase("2023"))) {
						sumavistasYt = sumavistasYt + metricas.get(i).getVistas();
						interaccionesYt = (metricas.get(i).getComentarios()+metricas.get(i).getCompartidos()+metricas.get(i).getMe_gusta()+metricas.get(i).getVistas());
						promedioYt++;
					}else if (metricas.get(i).getPlataforma().equalsIgnoreCase("Instagram") && (metricas.get(i).getFecha().split("-")[0].equalsIgnoreCase("2023"))) {
						sumavistasIg = sumavistasIg + metricas.get(i).getVistas();
						interaccionesIg = (metricas.get(i).getComentarios()+metricas.get(i).getCompartidos()+metricas.get(i).getMe_gusta()+metricas.get(i).getVistas());
						promedioIg++;
					}else if(metricas.get(i).getPlataforma().equalsIgnoreCase("TikTok") && (metricas.get(i).getFecha().split("-")[0].equalsIgnoreCase("2023"))) {
						sumavistasTk = sumavistasYt + metricas.get(i).getVistas();
						interaccionesTk = (metricas.get(i).getComentarios()+metricas.get(i).getCompartidos()+metricas.get(i).getMe_gusta()+metricas.get(i).getVistas());
						promedioTk++;
					}else {
						sumavistasTw = sumavistasTw + metricas.get(i).getVistas();
						interaccionesTw = (metricas.get(i).getComentarios()+metricas.get(i).getCompartidos()+metricas.get(i).getMe_gusta()+metricas.get(i).getVistas());
						promedioTw++;
					}
					
					if (sumavistasIg>sumavistasTk && sumavistasIg>sumavistasYt && sumavistasIg>sumavistasTw) {
						colaborador.put("Plataforma_mas_vista_2023", "Instagram");
					}else if (sumavistasTk>sumavistasIg && sumavistasTk>sumavistasYt && sumavistasTk>sumavistasTw) {
						colaborador.put("Plataforma_mas_vista_2023", "TikTok");
					}else if (sumavistasTw>sumavistasTk && sumavistasTw>sumavistasYt && sumavistasTw>sumavistasIg) {
						colaborador.put("Plataforma_mas_vista_2023", "Twitch");
					}else {
						colaborador.put("Plataforma_mas_vista_2023", "Youtube");
					}
					
					if((interaccionesIg/promedioIg)>(interaccionesTk/promedioTk) && (interaccionesIg/promedioIg)>(interaccionesTk/promedioTk)&& (interaccionesIg/promedioIg)>(interaccionesTk/promedioTk)) {
						colaborador.put("Plataforma_mas_interacciones_2023", "Instagram");
					}else if ((interaccionesTk/promedioTk)>(interaccionesIg/promedioIg) && (interaccionesTk/promedioTk)>(interaccionesYt/promedioYt)&& (interaccionesTk/promedioTk)>(interaccionesTw/promedioTw)) {
						colaborador.put("Plataforma_mas_interacciones_2023", "Youtube");
					}else if((interaccionesTw/promedioTw)>(interaccionesTk/promedioTk) && (interaccionesTw/promedioTw)>(interaccionesYt/promedioYt)&& (interaccionesTw/promedioTw)>(interaccionesIg/promedioIg)) {
						colaborador.put("Plataforma_mas_interacciones_2023", "Youtube");
					}else {
						colaborador.put("Plataforma_mas_interacciones_2023", "Youtube");
					}
					
					double tasa_crecimiento2023 = ((interaccionesIg/promedioIg)+(interaccionesTk/promedioTk)+(interaccionesTw/promedioTw)+(interaccionesYt/promedioYt))/4;
					this.vista.lblContenidoMayorRendimientoMostrar_3.setText(String.valueOf(tasa_crecimiento2023));
				}

			}
			colaboradores.add(colaborador);
		}
		
		mapper.writeValue(new File ("files/resumen_rendimientos.json"), colaboradores);


	}
	
	
	
	
	
	
	public void sacarID (String seleccion) {
		String hola = seleccion;
		
		id = hola.split(" ")[0];

	
		
	}
	public void crearArrayComboBox () {
		for (JsonNode creador : creadoresNode) {
			String id = creador.get("id").asText();
			String nombre = creador.get("nombre").asText();
			System.out.println(creador.get("id")+"a");
			String idNombre = (id+" "+nombre);
			idNombres.add(idNombre);
			for (JsonNode colaboracion : creador.get("colaboraciones")){
					String nombresCombo = colaboracion.get("colaborador").asText()+" - "+colaboracion.get("tematica").asText();
					nombres.add(nombresCombo);
				

			}
		}

	}
	
	public void cargarContenido() {
		for (int i=0; i<metricas.size();i++) {
			String contenido = metricas.get(i).getContenido();
			contenidos.add(contenido);
		}
	}
	
	
	
	
	public void colaboradorestoJson () throws JsonGenerationException, JsonMappingException, IOException {
		ArrayNode colaboradores = mapper.createArrayNode();
		
		for (JsonNode creador : creadoresNode) {
			ObjectNode colaborador = mapper.createObjectNode();
			System.out.println(creador.get("id").asInt());
			colaborador.put("id", creador.get("id").asInt());
			ArrayNode datos_colaboraciones = mapper.createArrayNode();
			for (JsonNode colaboracion : creador.get("colaboraciones")) {
				ObjectNode datos_colaboracion = mapper.createObjectNode();
				datos_colaboracion.put("colaborador", colaboracion.get("colaborador").asText());
				datos_colaboracion.put("tematica",colaboracion.get("tematica").asText());
				datos_colaboracion.put("fecha_inicio", colaboracion.get("fecha_inicio").asText());
				datos_colaboracion.put("fecha_fin", colaboracion.get("fecha_fin").asText());
				datos_colaboracion.put("tipo", colaboracion.get("tipo").asText());
				datos_colaboracion.put("estado", colaboracion.get("estado").asText());
				datos_colaboraciones.add(datos_colaboracion);
			}
			colaborador.set("datos_colaboracion", datos_colaboraciones);
			colaboradores.add(colaborador);
		}

		mapper.writeValue(new File ("files/colaboraciones.json"), colaboradores);
	}
	
	public void resumenRendimientoJson (ObjectMapper mapper, List<Metrica>metricas) {
		ArrayNode rendimientos = mapper.createArrayNode();
		ObjectNode rendimiento = mapper.createObjectNode();
		int a =0;
		for (int i=1; i<metricas.size(); i++) {
			for(int j=1; j<metricas.size();j++) {
				if (metricas.get(i).getCreador_id() == metricas.get(j).getCreador_id()) {
					System.out.println(a);
					a++;
					for(JsonNode existeRendimiento : rendimientos) {
						if (existeRendimiento.get("id").asText().equalsIgnoreCase(String.valueOf(i))) {
							rendimiento.put("id", j);
						}
					}
				}
			}
			System.out.println("-----------------");
			
		}
		
	}

	public void reporteColaboraciontoCSV () {
		String colaborador = null, fecha_inicio = null, fecha_fin = null;
		int id = 0;
		List<Colaboracion> colaboraciones = new ArrayList<>();
		
		for (JsonNode creador : creadoresNode) {
			for (int i=1; i<=creadoresNode.size(); i++) {
				String idCreador = String.valueOf(i);
				if (creador.get("id").asText().equals(idCreador)) {
					id = i;
					for (JsonNode colaboracion : creador.get("colaboraciones")){
						colaborador = colaboracion.get("colaborador").asText();
						fecha_inicio = colaboracion.get("fecha_inicio").asText();
						fecha_fin = colaboracion.get("fecha_fin").asText();
					}
					System.out.println("-----------------");
				}
			}
			Colaboracion colaboracion = new Colaboracion(colaborador, fecha_inicio, fecha_fin, id);
			colaboraciones.add(colaboracion);
		}
		crearCSVColaboracion(colaboraciones, "files\\reporte_colaboraciones.csv");
	}
	
	public void generarJson () throws JsonGenerationException, JsonMappingException, IOException {
		int interaccionesYT=0, interaccionesIG=0, interaccionesTW=0, interaccionesTK=0;
		double mediaYT=0.0, mediaTK=0.0, mediaIG=0.0, mediaTW=0.0;
		ArrayNode reportes = mapper.createArrayNode();
		for (JsonNode creador : creadoresNode) {
			ObjectNode reporte = mapper.createObjectNode();
			reporte.put("id", creador.get("id").asText());
			reporte.put("nombre", creador.get("nombre").asText());
			reporte.put("seguidores", creador.get("seguidores_totales").asText());
			for (JsonNode plataforma : creador.get("plataformas")) {
				if (plataforma.get("nombre").asText().equalsIgnoreCase("YouTube")) {
					for(JsonNode historial : plataforma.get("historico")) {
						interaccionesYT = interaccionesYT + historial.get("interacciones").asInt();
						mediaYT++;
						}
					}
				if (plataforma.get("nombre").asText().equalsIgnoreCase("TikTok")) {
					for(JsonNode historial : plataforma.get("historico")) {
						interaccionesTK = interaccionesTK + historial.get("interacciones").asInt();
						mediaTK++;
						}
					}
				if (plataforma.get("nombre").asText().equalsIgnoreCase("Instagram")) {
					for(JsonNode historial : plataforma.get("historico")) {
						interaccionesIG = interaccionesIG + historial.get("interacciones").asInt();
						mediaIG++;
						}
					}
				if (plataforma.get("nombre").asText().equalsIgnoreCase("Twitch")) {
					for(JsonNode historial : plataforma.get("historico")) {
						interaccionesTW = interaccionesTW + historial.get("interacciones").asInt();
						mediaTW++;
						}
					}
				}
			if (interaccionesYT>interaccionesIG && interaccionesYT>interaccionesTK && interaccionesYT>interaccionesTW) {
				reporte.put("media_interacciones_YouTube", interaccionesYT/mediaYT);
			}else if (interaccionesIG>interaccionesYT && interaccionesIG>interaccionesTK && interaccionesIG>interaccionesTW) {
				reporte.put("media_interacciones_Instagram", interaccionesIG/mediaIG);
			}else if(interaccionesTK>interaccionesIG && interaccionesTK>interaccionesYT && interaccionesTK>interaccionesTW) {
				reporte.put("media_interacciones_TikTok", interaccionesTK/mediaTK);
			}else {
				reporte.put("media_interacciones_Twitch", interaccionesTW/mediaTW);
			}
			reportes.add(reporte);
			}
		mapper.writeValue(new File("files/reporte_creadores.json"), reportes);
			
		}
	
	
	public void contenidoStrong () {
		int videoStrong=0, imagenStrong=0;
		for (int i=0; i<metricas.size();i++) {
			if (String.valueOf(metricas.get(i).getCreador_id()).equalsIgnoreCase(id)) {
				if (metricas.get(i).getPlataforma().equalsIgnoreCase("video")) {
					
					videoStrong = videoStrong+metricas.get(i).getVistas();
					videoStrong = videoStrong+metricas.get(i).getMe_gusta();
					videoStrong = videoStrong+metricas.get(i).getComentarios();
					videoStrong = videoStrong+metricas.get(i).getCompartidos();

				}else {
					
					imagenStrong = imagenStrong+metricas.get(i).getVistas();
					imagenStrong = imagenStrong+metricas.get(i).getMe_gusta();
					imagenStrong = imagenStrong+metricas.get(i).getComentarios();
					imagenStrong = imagenStrong+metricas.get(i).getCompartidos();

					
				}
			}
		}
		if (videoStrong > imagenStrong) {
			this.vista.lblContenidoMayorRendimientoMostrar.setText("Video");
		}else {
			this.vista.lblContenidoMayorRendimientoMostrar.setText("Imagen");

		}
		
	}
	
	
	
	
	
	public void promedios_MGV () {
		Double mediaIG=0.0, vistasIG=0.0, megustaIG=0.0;
		Double mediaYT=0.0, vistasYT=0.0, megustaYT=0.0;
		Double mediaTK=0.0, vistasTK=0.0, megustaTK=0.0;
		Double mediaTW=0.0, vistasTW=0.0, megustaTW=0.0;
		for (int i=0; i<metricas.size();i++) {
			if (String.valueOf(metricas.get(i).getCreador_id()).equalsIgnoreCase(id)) {
					
					vistasIG = vistasIG+metricas.get(i).getVistas();
					megustaIG= megustaIG+metricas.get(i).getMe_gusta();
					mediaIG++;
					
					
					vistasYT = vistasYT+metricas.get(i).getVistas();
					megustaYT= megustaYT+metricas.get(i).getMe_gusta();
					mediaYT++;
					
					
					vistasTK = vistasTK+metricas.get(i).getVistas();
					megustaTK= megustaTK+metricas.get(i).getMe_gusta();
					mediaTK++;
					
			
					
					vistasTW = vistasTW+metricas.get(i).getVistas();
					megustaTW= megustaTW+metricas.get(i).getMe_gusta();
					mediaTW++;
				
			}
		}
		 mediaVYT = vistasYT/mediaYT;
		 mediaMYT = megustaYT/mediaYT;
		 mediaVTK = vistasTK/mediaTK;
		 mediaMTK = megustaTK/mediaTK;
		 mediaVIG = vistasIG/mediaIG;
		 mediaMIG = megustaIG/mediaIG++;
		 mediaVTW = vistasTW/mediaTW;
		 mediaMTW = megustaTW/mediaTW;
		 
		 double promedio_mg = (mediaMYT +mediaMTK +mediaMIG+ mediaMTW)/4;
		 double promedio_v = (mediaVYT +mediaVTK +mediaVIG+ mediaVTW)/4;

		 this.vista.lblTasaCrecimientoMostrar.setText(String.valueOf(mediaMYT));
		 this.vista.lblMetricaPromedioVistasMostrar.setText(String.valueOf(mediaVYT));
		 
			 

		
		
	}
	
	
	public void recorrerDatos () {

		for (JsonNode creador : creadoresNode) {
				if (creador.get("id").asText().equals(id)) {
					this.vista.lblNombreMostrar.setText(creador.get("nombre").asText());
					this.vista.lblCreadorMostrar.setText(creador.get("nombre").asText());
					this.vista.lblPaisMostrar.setText(creador.get("pais").asText());
					this.vista.lblTematicaMostrar.setText(creador.get("tematica").asText());
					this.vista.lblSeguidoresTotalesMostrar.setText(creador.get("seguidores_totales").asText());
					JsonNode estadisticas = creador.get("estadisticas");
					this.vista.lblInteraccionesTotalesMostrar.setText(estadisticas.get("interacciones_totales").asText());
					this.vista.lblPromedioVistasMensualesMostrar.setText(estadisticas.get("promedio_vistas_mensuales").asText());
					this.vista.lblTasaCrecimientoSeguidoresMostrar.setText(estadisticas.get("tasa_crecimiento_seguidores").asText());
					for (JsonNode plataforma : creador.get("plataformas")) {
						System.out.println(plataforma.get("nombre").asText());
						System.out.println(plataforma.get("usuario").asText());
						System.out.println(plataforma.get("seguidores").asText());
						System.out.println(plataforma.get("fecha_creacion").asText());
						for (JsonNode historial : plataforma.get("historico")) {
							System.out.println(historial.get("fecha").asText());
							System.out.println(historial.get("nuevos_seguidores").asText());
							System.out.println(historial.get("interacciones").asText());
						}
					}
					for (JsonNode colaboracion : creador.get("colaboraciones")){
						System.out.println(colaboracion.get("colaborador").asText()+" - "+colaboracion.get("tematica").asText());
						System.out.println();
						System.out.println(colaboracion.get("fecha_fin").asText());
					}
					System.out.println("-----------------");
				}
		}
		
	}
	
	
	
	
	
	public void insercion () {
		String id = this.vista.cbAnfitrion.getSelectedItem().toString().split(" ")[0];
		String id2 = this.vista.cbInvitado.getSelectedItem().toString().split(" ")[0];
		ObjectNode colaboracionNueva = mapper.createObjectNode();
		

		for (JsonNode creador : creadoresNode) {
			if (creador.get("id").asText().equalsIgnoreCase(id)) {
					colaboracionNueva.put("colaborador", this.vista.cbAnfitrion.getSelectedItem().toString().split(" ",2)[1]);
					colaboracionNueva.put("tematica", this.vista.tfTematica.getText().toString());
					colaboracionNueva.put("fecha_incio", this.vista.tfFechaInicio.getText().toString());
					colaboracionNueva.put("tipo", this.vista.tfTipo.getText().toString());
					ArrayNode colaboracion = (ArrayNode) creador.get("colaboraciones");
					colaboracion.add(colaboracionNueva);	
			}
		}
		for (JsonNode creador : creadoresNode) {
			if (creador.get("id").asText().equalsIgnoreCase(id2)) {
					colaboracionNueva.put("colaborador", this.vista.cbInvitado.getSelectedItem().toString().split(" ",2)[1]);
					colaboracionNueva.put("tematica", this.vista.tfTematica.getText().toString());
					colaboracionNueva.put("fecha_incio", this.vista.tfFechaInicio.getText().toString());
					colaboracionNueva.put("tipo", this.vista.tfTipo.getText().toString());
					ArrayNode colaboracion = (ArrayNode) creador.get("colaboraciones");
					colaboracion.add(colaboracionNueva);	
			}
		}
		
		System.out.println(creadoresNode);
		
	}
	
	public void colaboracionestoCSV () {
		String nombre = null, seguidores = null, colaborador = null, fecha_inicio = null, fecha_fin = null;
		int id = 0, promedio_visitas_mensuales= 0; 
		long interacciones_totales = 0;
		Double tasa_crecimiento_seguidores = 0.0;
		List<Colaboracion> colaboraciones = new ArrayList<>();
		
		for (JsonNode creador : creadoresNode) {
			for (int i=1; i<=creadoresNode.size(); i++) {
				String idCreador = String.valueOf(i);
				if (creador.get("id").asText().equals(idCreador)) {
					id = i;
					nombre = creador.get("nombre").asText();
					seguidores = creador.get("seguidores_totales").asText();
					JsonNode estadisticas = creador.get("estadisticas");
					interacciones_totales = estadisticas.get("interacciones_totales").asLong();
					promedio_visitas_mensuales = estadisticas.get("promedio_vistas_mensuales").asInt();
					tasa_crecimiento_seguidores = estadisticas.get("tasa_crecimiento_seguidores").asDouble();
					for (JsonNode colaboracion : creador.get("colaboraciones")){
						colaborador = colaboracion.get("colaborador").asText();
						fecha_inicio = colaboracion.get("fecha_inicio").asText();
						fecha_fin = colaboracion.get("fecha_fin").asText();
					}
					System.out.println("-----------------");
				}
			}
			Colaboracion colaboracion = new Colaboracion(nombre, seguidores, id, promedio_visitas_mensuales, interacciones_totales, tasa_crecimiento_seguidores, colaborador, fecha_inicio, fecha_fin);
			colaboraciones.add(colaboracion);
		}
		crearCSVColaboracion(colaboraciones, "files\\colaboraciones.csv");
	}
	
	public void modMetricas () {
		for (Metrica metrica : metricas) {
			String idmetrica = (String) vista.cbContenidoModif.getSelectedItem();
			if (String.valueOf(metrica.getContenido()).equalsIgnoreCase(idmetrica)) {
				metrica.setComentarios(Integer.parseInt(this.vista.tfComentariosModif.getText().toString()));
				metrica.setMe_gusta(Integer.parseInt(this.vista.tfMGModif.getText().toString()));
			}
			
		}
		crearCSVMetricas("files\\metricas_contenido.csv");

	}
	public void delMetricas () {
		int cantidad = Integer.parseInt(vista.textField.toString()) ;
		String opcion = vista.cbPubliBorrar.getSelectedItem().toString();
		for (Metrica metrica : metricas) {
			switch (opcion) {
			case "Vistas":
				if (metrica.getVistas()< cantidad) {
					metricas.remove(metrica);
				}
				break;
			case "Me gusta":
				if (metrica.getMe_gusta()< cantidad) {
					metricas.remove(metrica);
				}
				break;
			case "Compartidos":
				if (metrica.getCompartidos()< cantidad) {
					metricas.remove(metrica);
				}
				break;
			case "Comentarios":
				if (metrica.getComentarios()< cantidad) {
					metricas.remove(metrica);
				}
				break;
			}


		}
		crearCSVMetricas("files\\metricas_contenido.csv");


	}
	
	public void addMetricas () {
		
		int newId = metricas.size()+1;
		Metrica metrica = new Metrica();
		metrica.setCreador_id(Integer.parseInt(this.vista.tfPubliIdCreadorInsert.getText()));
		metrica.setComentarios(Integer.parseInt(this.vista.tfPubliComentariosInsert.getText().toString()));
		metrica.setCompartidos(Integer.parseInt(this.vista.tfPubliCompartidosInsert.getText().toString()));
		metrica.setContenido("Contenido "+newId);
		metrica.setFecha(this.vista.tfPubliFechaInsert.getText().toString());
		metrica.setMe_gusta(Integer.parseInt(this.vista.tfPubliGustasInsert.getText().toString()));
		String seleccion = (String) vista.cbPubliPlataformasInsert.getSelectedItem();
		metrica.setPlataforma( seleccion);
		seleccion = (String) vista.cbPubliContenidoInsert.getSelectedItem();
		metrica.setTipo(seleccion);
		metrica.setVistas(Integer.parseInt(this.vista.tfPubliVistasInsert.getText().toString()));
		
		metricas.add(metrica);
		
		

		crearCSVMetricas("files\\metricas_contenido.csv");

	}
	

	public void crearJson() throws IOException, JsonProcessingException {
        File jsonFile = new File("files/creadores.json");
        rootNode = mapper.readTree(jsonFile);
        creadoresNode = (ArrayNode) rootNode.get("creadores");
        
        
	}
	
	public List<Metrica> abrirCSV(String rutaCSV){
		List<Metrica> metricas = null;
		try  {
			FileReader reader = new FileReader(rutaCSV);
			
			CsvToBeanBuilder<Metrica> csvBuilder = new CsvToBeanBuilder<Metrica>(reader);
			CsvToBean<Metrica> csv = csvBuilder.withType(Metrica.class).withIgnoreLeadingWhiteSpace(true).build();

            metricas = csv.parse();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return metricas;
	}
	

	public void crearCSVColaboracion(List<Colaboracion> colaboraciones, String rutaCSV) {
		try {
            FileWriter fw = new FileWriter(rutaCSV);
            StatefulBeanToCsv<Colaboracion> beanToCsv = new StatefulBeanToCsvBuilder<Colaboracion>(fw).build();
            beanToCsv.write(colaboraciones); 
            fw.flush();
		}catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
	}
	
	public void crearCSVMetricas( String rutaCSV) {
		try {
            FileWriter fw = new FileWriter(rutaCSV);
            StatefulBeanToCsv<Metrica> beanToCsv = new StatefulBeanToCsvBuilder<Metrica>(fw).build();
            beanToCsv.write(metricas); 
            fw.flush();
		}catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
	}
	public  void cargarComboBox(JComboBox<String> box ,ArrayList <String> list){
		
		DefaultComboBoxModel<String> modelo=new DefaultComboBoxModel<String>();
		
		for(int i=0; i<list.size();i++) {
			modelo.addElement(list.get(i));
		}
		box.setModel(modelo);
		
	}
	public void rellenarcolab () {
		for (JsonNode creador : creadoresNode) {
			if (creador.get("id").asText().equalsIgnoreCase(id)) {
				for(JsonNode colaboracion : creador.get("colaboraciones")) {
					String colab = colaboracion.get("colaborador").asText()+" - "+colaboracion.get("tematica").asText();
					colabs.add(colab);
				}
			}
		}
	
	}
	
	
	public void mejorPlataforma () {
		int potenciaIG = 0, potenciaTK = 0, potenciaTW = 0, potenciaYT = 0;
		for (JsonNode creador : creadoresNode) {
			if (creador.get("id").asText().equals(id)) {
				for (JsonNode plataforma : creador.get("plataformas")) {
					if (plataforma.get("nombre").asText().equalsIgnoreCase("YouTube")) {
						potenciaYT = plataforma.get("seguidores").asInt();
						for (JsonNode historial : plataforma.get("historico")) {
							potenciaYT= potenciaYT + historial.get("nuevos_seguidores").asInt();
							potenciaYT= potenciaYT + historial.get("interacciones").asInt();
						}
					}else if (plataforma.get("nombre").asText().equalsIgnoreCase("TikTok")){
						potenciaTK = plataforma.get("seguidores").asInt();
						for (JsonNode historial : plataforma.get("historico")) {
							potenciaTK= potenciaTK + historial.get("nuevos_seguidores").asInt();
							potenciaTK= potenciaTK + historial.get("interacciones").asInt();
						}
					}else if (plataforma.get("nombre").asText().equalsIgnoreCase("Twitch")){
						potenciaTW = plataforma.get("seguidores").asInt();
						for (JsonNode historial : plataforma.get("historico")) {
							potenciaTW= potenciaTW + historial.get("nuevos_seguidores").asInt();
							potenciaTW= potenciaTW + historial.get("interacciones").asInt();
						}
					}else {
						potenciaIG = plataforma.get("seguidores").asInt();
						for (JsonNode historial : plataforma.get("historico")) {
							potenciaIG= potenciaIG + historial.get("nuevos_seguidores").asInt();
							potenciaIG= potenciaIG + historial.get("interacciones").asInt();
						}
					}
				}
				
			}
				
		}
		
		if (potenciaIG> potenciaTK && potenciaIG > potenciaYT && potenciaIG> potenciaTW) {
			this.vista.lblContenidoMayorRendimientoMostrar_1.setText("Instagram");
		}else if (potenciaYT> potenciaTK && potenciaYT > potenciaIG && potenciaYT> potenciaTW) {
			this.vista.lblContenidoMayorRendimientoMostrar_1.setText("YouTube");

		}else if (potenciaTW> potenciaTK && potenciaTW > potenciaYT && potenciaTW> potenciaIG) {
			this.vista.lblContenidoMayorRendimientoMostrar_1.setText("Twitch");

		}else {
			this.vista.lblContenidoMayorRendimientoMostrar_1.setText("TikTok");

		}
		
	}
	
	public void rellenarFiltros () {
		filtros.add("Vistas");
		filtros.add("Me gusta");
		filtros.add("Comentarios");
		filtros.add("Compartidos");
	}




}



	
	
	
	