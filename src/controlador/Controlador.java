package controlador;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import modelo.Metrica;
import vista.Vista;

public class Controlador implements ActionListener, MouseListener {

	private Vista vista = new Vista();
	private ArrayNode creadoresNode = new ArrayNode(null) ;
	private ObjectMapper mapper = new ObjectMapper();
	private List<Metrica>metricas = new ArrayList <>();
	private ArrayList <String> nombres = new ArrayList<>();
	private DefaultListModel<String> modeloListas = new DefaultListModel<String>();

	
	public Controlador(Vista vista) {
		this.vista = vista;
		this.vista.btnGenerarInformes.addActionListener(this);
		this.modeloListas = new DefaultListModel<String>();
		this.nombres = new ArrayList<String>();
		this.vista.listCreadores.addMouseListener(this);
		
		
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
	
	public ArrayNode crearJson(ObjectMapper mapper) throws IOException, JsonProcessingException {
        File jsonFile = new File("files/creadores.json");
        JsonNode rootNode = mapper.readTree(jsonFile);
        ArrayNode creadoresNode = (ArrayNode) rootNode.get("creadores");
        
        return creadoresNode;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
	    if(e.getSource() == vista.btnGenerarInformes) {
	    	try {
				creadoresNode = crearJson(mapper);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (JsonNode creador : creadoresNode) {
				for (int i=0; i<=creadoresNode.size(); i++) {
					String id = String.valueOf(i);
					if (creador.get("id").asText().equals(id)) {
						modeloListas.addElement(creador.get("nombre").asText());
					}

				}

			}

	    	metricas = abrirCSV("C:\\Users\\Admin\\Desktop\\acceso a datos\\Proyecto Transversal\\files\\metricas_contenido.csv");

	    	vista.panelGeneracion.setVisible(true);
	    	vista.panelPrincipal.setVisible(false);
	    	modeloListas.addElement(metricas.get(1).getPlataforma());
	    	vista.listCreadores.setModel(modeloListas);
	    	
	    	
	    	
	    }

		
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
	
	
	
		
}		