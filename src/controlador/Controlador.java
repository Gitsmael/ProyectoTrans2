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
	private ArrayList <String> idNombres;
	private DefaultComboBoxModel<String> modelocombo;
	private String id;


	
	public Controlador(Vista frame) throws JsonProcessingException, IOException {
		
		this.vista = frame;
		this.idNombres = new ArrayList<String>();
		this.metricas = abrirCSV("files\\metricas_contenido.csv");
		this.mapper = new ObjectMapper();
		crearJson();
		crearArrayComboBox();
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
		
		cargarComboBox(vista.comboBox, idNombres);

		
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
	
	public class ComboBoxController {
	    public void handleSelection(String selectedItem) {
	        System.out.println("Seleccionaste: " + selectedItem);
	        // Agrega aquí la lógica necesaria para manejar la selección.
	    }
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
        vista.comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado
                String seleccion = (String) vista.comboBox.getSelectedItem();
                
                sacarID(seleccion);
                recorrerDatos(creadoresNode, id);
                
                // Actualizar la etiqueta con la selección
                //vista.lblNombreMostrar.setText(seleccion);
                System.out.println(id);
                // Aquí puedes añadir la acción que desees realizar
            }
        });

		
      //-----------------------BOTONES MENU GENERAL
      		if(e.getSource()==vista.btnDatos) {
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
      		}
      		
      		//------------------------------------BOTON YOUTUBE-----------------------------------------------
      		if(e.getSource()==vista.btnYouTube) {
      			vista.lblDatosPlataforma.setText("DATOS DE YOUTUBE");
      		}
      		//------------------------------------BOTON TWITCH------------------------------------------------
      		if(e.getSource()==vista.btnTwitch) {
      			vista.lblDatosPlataforma.setText("DATOS DE TWITCH");
      		}
      		//------------------------------------BOTON INSTAGRAM---------------------------------------------
      		if(e.getSource()==vista.btnInstagram) {
      			vista.lblDatosPlataforma.setText("DATOS DE INSTAGRAM");
      		}
      		//------------------------------------BOTON TIKTOK------------------------------------------------
      		if(e.getSource()==vista.btnTikTok) {
      			vista.lblDatosPlataforma.setText("DATOS DE TIKTOK");
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
      		}
      		if(e.getSource()==vista.btnReporteColab) {
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
      		}
      		if(e.getSource()==vista.btnAniadirPubli) {
      			vista.panelInsertarPubli.setVisible(true);
      			vista.panelBotonesPublis.setVisible(false);
      			vista.btnVolverPubli.setVisible(true);
      			
      		}
      		if(e.getSource()==vista.btnInsertarPubli) {
      			if(vista.tfPubliFechaInsert.getText().equals("")||vista.tfPubliIdCreadorInsert.getText().equals("")||vista.tfPubliVistasInsert.getText().equals("")||vista.tfPubliGustasInsert.getText().equals("")||vista.tfPubliComentariosInsert.getText().equals("")||vista.tfPubliComentariosInsert.getText().equals("")) {
      				vista.lblMsgCorrecto.setText("UNO O VARIOS CAMPOS SON INCORRECTOS");
      				vista.lblMsgCorrecto.setForeground(new Color(255,0,0));
      				temporizador();
      			}else{
      				vista.tfPubliFechaInsert.setText("");
      				vista.tfPubliIdCreadorInsert.setText("");
      				vista.lblMsgCorrecto.setForeground(new Color(0,255,0));
      				vista.lblMsgCorrecto.setText("PUBLICACION CREADA CORRECTAMENTE");
      				temporizador();
      			}
      		}
      		if(e.getSource()==vista.btnBorrarDatosPubli) {
      			vista.tfPubliFechaInsert.setText("");
      			vista.tfPubliIdCreadorInsert.setText("");
      		}
      		
      		if(e.getSource()==vista.btnModificarPubli) {
      			vista.panelModificarPubli.setVisible(true);
      			vista.panelBotonesPublis.setVisible(false);
      			vista.btnVolverPubli.setVisible(true);
      		}
      		if(e.getSource()==vista.btnEliminarPubli) {
      			vista.panelEliminarPubli.setVisible(true);
      			vista.panelBotonesPublis.setVisible(false);
      			vista.btnVolverPubli.setVisible(true);
      		}
	}




		
		//aplicacion.colaboradorestoJson(mapper, creadoresNode); //repasar
		//aplicacion.resumenRendimientoJson(mapper, metricas); //por hacer
		//aplicacion.generarJson(creadoresNode, mapper); //hecho
		//aplicacion.contenidoStrong(metricas); //hecho 2b
		//aplicacion.calculoMedias(metricas); //hecho 2a y 9
		//aplicacion.recorrerDatos(creadoresNode); //hecho 1
		//aplicacion.reporteColaboraciontoCSV(creadoresNode); //hecho
		//aplicacion.insercion(creadoresNode, metricas, mapper); //faltan cosas
		//aplicacion.colaboracionestoCSV(creadoresNode); //hecho 4
		//aplicacion.modMetricas(metricas); // hecho
		//aplicacion.addMetricas(metricas, creadoresNode);
		//idNombres = aplicacion.crearArrayComboBox(creadoresNode, idNombres);
		//System.out.println(aplicacion.sacarID(idNombres));

	
	
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
		}
		System.out.println(idNombres);
		
		
		
		
	}
	
	
	
	
	public void colaboradorestoJson (ObjectMapper mapper, ArrayNode creadoresNode) throws JsonGenerationException, JsonMappingException, IOException {
		ArrayNode colaboradores = mapper.createArrayNode();
		ArrayNode datos_colaboraciones = mapper.createArrayNode();
		
		for (JsonNode creador : creadoresNode) {
			ObjectNode colaborador = mapper.createObjectNode();
			System.out.println(creador.get("id").asInt());
			colaborador.put("id", creador.get("id").asInt());
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

	public void reporteColaboraciontoCSV (ArrayNode creadoresNode) {
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
	
	public void generarJson (ArrayNode creadoresNode, ObjectMapper mapper) throws JsonGenerationException, JsonMappingException, IOException {
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
	
	
	public void contenidoStrong (List<Metrica> metricas) {
		String id="5";
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
			System.out.println("El video tiene mas rendimiento que la imagen");
		}else {
			System.out.println("La imagen tiene mas rendimiento que el video");
		}
		
	}
	
	
	
	
	
	public void calculoMedias(List<Metrica> metricas) {
		String id = "5";
		Double mediaIG=0.0, vistasIG=0.0, megustaIG=0.0;
		Double mediaYT=0.0, vistasYT=0.0, megustaYT=0.0;
		Double mediaTK=0.0, vistasTK=0.0, megustaTK=0.0;
		Double mediaTW=0.0, vistasTW=0.0, megustaTW=0.0;
		for (int i=0; i<metricas.size();i++) {
			if (String.valueOf(metricas.get(i).getCreador_id()).equalsIgnoreCase(id)) {
				if (metricas.get(i).getPlataforma().equalsIgnoreCase("Instagram")) {
					
					vistasIG = vistasIG+metricas.get(i).getVistas();
					megustaIG= megustaIG+metricas.get(i).getMe_gusta();
					mediaIG++;
					
				}else if (metricas.get(i).getPlataforma().equalsIgnoreCase("Youtube")){
					
					vistasYT = vistasYT+metricas.get(i).getVistas();
					megustaYT= megustaYT+metricas.get(i).getMe_gusta();
					mediaYT++;
					
				}else if (metricas.get(i).getPlataforma().equalsIgnoreCase("Tiktok")) {
					
					vistasTK = vistasTK+metricas.get(i).getVistas();
					megustaTK= megustaTK+metricas.get(i).getMe_gusta();
					mediaTK++;
					
				}else {
					
					vistasTW = vistasTW+metricas.get(i).getVistas();
					megustaTW= megustaTW+metricas.get(i).getMe_gusta();
					mediaTW++;
				}
			}
		}
		Double mediaVIG = vistasIG/mediaIG;
		Double mediaMIG = megustaIG/mediaIG;
		
		Double mediaVYT = vistasYT/mediaYT;
		Double mediaMYT = megustaYT/mediaYT;
		
		Double mediaVTK = vistasTK/mediaTK;
		Double mediaMTK = megustaTK/mediaTK;
		
		Double mediaVTW = vistasTW/mediaTW;
		Double mediaMTW = megustaTW/mediaTW;
		
		
	}
	
	
	public void recorrerDatos (ArrayNode creadoresNode, String id) {

		for (JsonNode creador : creadoresNode) {
				if (creador.get("id").asText().equals(id)) {
					System.out.println(creador.get("nombre").asText());
					this.vista.lblNombreMostrar.setText(creador.get("nombre").asText());;
					System.out.println(creador.get("pais").asText());
					this.vista.lblPaisMostrar.setText(creador.get("pais").asText());
					System.out.println(creador.get("tematica").asText());
					this.vista.lblTematicaMostrar.setText(creador.get("tematica").asText());
					System.out.println(creador.get("seguidores_totales").asText());
					this.vista.lblSeguidoresTotalesMostrar.setText(creador.get("seguidores_totales").asText());
					JsonNode estadisticas = creador.get("estadisticas");
					System.out.println(estadisticas.get("interacciones_totales").asText());
					this.vista.lblInteraccionesTotalesMostrar.setText(estadisticas.get("interacciones_totales").asText());
					System.out.println(estadisticas.get("promedio_vistas_mensuales").asText());
					this.vista.lblPromedioVistasMensualesMostrar.setText(estadisticas.get("promedio_vistas_mensuales").asText());
					System.out.println(estadisticas.get("tasa_crecimiento_seguidores").asText());
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
	
	
	
	
	
	public void insercion (ArrayNode creadoresNode, List<Metrica> metricas, ObjectMapper mapper) {
		String id = "2";
		String id2 = "6";
		ObjectNode colaboracionNueva = mapper.createObjectNode();

		for (JsonNode creador : creadoresNode) {
			if (creador.get("id").asText().equalsIgnoreCase(id)) {
					colaboracionNueva.put("colaborador", "juanjo");
					colaboracionNueva.put("tematica", "Tecnologia");
					colaboracionNueva.put("fecha_incio", "2024-07-01");
					colaboracionNueva.put("fecha_final", "2023-03-30");
					colaboracionNueva.put("tipo", "Patrocinio");
					colaboracionNueva.put("estado", "Activa");
					ArrayNode colaboracion = (ArrayNode) creador.get("colavoraciones");
					colaboracion.add(colaboracionNueva);	
			}
		}
		for (JsonNode creador : creadoresNode) {
			if (creador.get("id").asText().equalsIgnoreCase(id2)) {
					colaboracionNueva.put("colaborador", "juanjo");
					colaboracionNueva.put("tematica", "Tecnologia");
					colaboracionNueva.put("fecha_incio", "2024-07-01");
					colaboracionNueva.put("fecha_final", "2023-03-30");
					colaboracionNueva.put("tipo", "Patrocinio");
					colaboracionNueva.put("estado", "Activa");
					ArrayNode colaboracion = (ArrayNode) creador.get("colavoraciones");
					colaboracion.add(colaboracionNueva);	
			}
		}
		
	}
	
	public void colaboracionestoCSV (ArrayNode creadoresNode) {
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
	
	public void modMetricas (List<Metrica> metricas) {
		for (Metrica metrica : metricas) {
			int actualizar =0;
			String idmetrica = "1";
			if (String.valueOf(metrica.getCreador_id()).equalsIgnoreCase(idmetrica)) {
				metrica.setComentarios(metrica.getComentarios()+actualizar);
				metrica.setMe_gusta(metrica.getMe_gusta()+actualizar);
			}
			
		}
		crearCSVMetricas(metricas, "files\\metricas_contenido.csv");

	}
	public void delMetricas (List<Metrica> metricas) {
		for (Metrica metrica : metricas) {
			int minimo =0;
			String idmetrica = "1";
			
				if (String.valueOf(metrica.getContenido()).equalsIgnoreCase(idmetrica) && metrica.getVistas()<minimo) {
					metricas.remove(metrica);
				}


		}

	}
	
	public void addMetricas (List<Metrica> metricas, ArrayNode creadoresNode) {
		int newId = metricas.size()+1;
		Metrica metrica = new Metrica();
		metrica.setCreador_id(5);
		metrica.setComentarios(24);
		metrica.setCompartidos(34);
		metrica.setContenido("Contenido "+newId);
		metrica.setFecha("2024-09-14");
		metrica.setMe_gusta(2454);
		metrica.setPlataforma("twitch");
		metrica.setTipo("video");
		metrica.setVistas(500);
		
		metricas.add(metrica);
		
		

		//crearCSVMetricas(metricas, "files\\metricas_contenido.csv");

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
	
	public void crearCSVMetricas(List<Metrica> metricas, String rutaCSV) {
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



}



	
	
	
	