import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class PrincipallApp {

	public static void main(String[] args) throws IOException {
		PrincipallApp aplicacion = new PrincipallApp();
		ObjectMapper mapper = new ObjectMapper();

		
		List<Metrica>metricas;
		metricas = aplicacion.abrirCSV("C:\\Users\\Admin\\Desktop\\acceso a datos\\Proyecto Transversal\\files\\metricas_contenido.csv");
		ArrayNode creadoresNode = aplicacion.crearJson(mapper);
		
		//aplicacion.insercion(metricasNode, metricas, mapper);
		aplicacion.colaboracionestoCSV(creadoresNode, metricas, mapper);
		//aplicacion.moddelMetricas(metricas);

	}
	
	
	
	
	
	public void insercion (ArrayNode creadoresNode, List<Metrica> metricas, ObjectMapper mapper) {
		String id = "2";
		String id2 = "6";
		for (JsonNode creador : creadoresNode) {
			if (creador.get("id").asText().equalsIgnoreCase(id)) {
				for (JsonNode colaboracion : creador.get("colaboraciones")) {
					System.out.println(colaboracion);
					ObjectNode colaboracionNueva = mapper.createObjectNode();
					colaboracionNueva.put("colaborador", "juanjo");
					colaboracionNueva.put("tematica", "Tecnologia");
					colaboracionNueva.put("fecha_incio", "2024-07-01");
					colaboracionNueva.put("fecha_final", "2023-03-30");
					colaboracionNueva.put("tipo", "Patrocinio");
					colaboracionNueva.put("estado", "Activa");
				}
			}
		}
		
	}
	
	public void colaboracionestoCSV (ArrayNode creadoresNode, List<Metrica> metricas, ObjectMapper mapper) {
		String nombre, seguidores;
		for (JsonNode creador : creadoresNode) {
			for (int i=0; i<=creadoresNode.size(); i++) {
				String id = String.valueOf(i);
				if (creador.get("id").asText().equals(id)) {
					System.out.println(creador.get("nombre").asText());
					System.out.println(creador.get("seguidores_totales").asText());
					for (JsonNode impacto : creador.get("estadisticas")) {
						System.out.println(impacto.asText());
					}
					
					for (JsonNode colaboracion : creador.get("colaboraciones")){
						System.out.println(colaboracion.get("colaborador").asText());
						System.out.println(colaboracion.get("fecha_inicio").asText());
						System.out.println(colaboracion.get("fecha_fin").asText());
					}
					System.out.println("-----------------");
				}
			}
		}
	}
	
	public void modMetricas (List<Metrica> metricas) {
		for (Metrica metrica : metricas) {
			int idmetrica = 1;
			
		}
	}
	
	
	

	public ArrayNode crearJson(ObjectMapper mapper) throws IOException, JsonProcessingException {
        File jsonFile = new File("files/creadores.json");
        JsonNode rootNode = mapper.readTree(jsonFile);
        ArrayNode metricasNode = (ArrayNode) rootNode.get("creadores");
        
        return metricasNode;
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

}

