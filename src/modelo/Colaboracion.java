package modelo;

public class Colaboracion {
	
	private String nombre, seguidores,colaborador, fecha_inicio, fecha_fin;
	private int id, promedio_visitas_mensuales;
	private long interacciones_totales;
	private Double tasa_crecimiento_seguidores;
	
	public Colaboracion(String nombre, String seguidores,int id, int promedio_visitas_mensuales, long interacciones_totales, 
			Double tasa_crecimiento_seguidores, String colaborador, String fecha_inicio, String fecha_fin) {
		this.nombre = nombre;
		this.seguidores = seguidores;
		this.id = id;
		this.promedio_visitas_mensuales = promedio_visitas_mensuales;
		this.interacciones_totales = interacciones_totales;
		this.tasa_crecimiento_seguidores = tasa_crecimiento_seguidores;
		this.colaborador = colaborador;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	
	

	public Colaboracion(String colaborador, String fecha_inicio, String fecha_fin, int id) {
		this.colaborador = colaborador;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.id = id;
	}




	public String getColaborador() {
		return colaborador;
	}


	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}


	public String getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public String getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(String seguidores) {
		this.seguidores = seguidores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPromedio_visitas_mensuales() {
		return promedio_visitas_mensuales;
	}

	public void setPromedio_visitas_mensuales(int promedio_visitas_mensuales) {
		this.promedio_visitas_mensuales = promedio_visitas_mensuales;
	}

	public long getInteracciones_totales() {
		return interacciones_totales;
	}

	public void setInteracciones_totales(long interacciones_totales) {
		this.interacciones_totales = interacciones_totales;
	}

	public Double getTasa_crecimiento_seguidores() {
		return tasa_crecimiento_seguidores;
	}

	public void setTasa_crecimiento_seguidores(Double tasa_crecimiento_seguidores) {
		this.tasa_crecimiento_seguidores = tasa_crecimiento_seguidores;
	}



	@Override
	public String toString() {
		return "Colaboracion [nombre=" + nombre + ", seguidores=" + seguidores + ", id=" + id
				+ ", promedio_visitas_mensuales=" + promedio_visitas_mensuales + ", interacciones_totales="
				+ interacciones_totales + ", tasa_crecimiento_seguidores=" + tasa_crecimiento_seguidores + "]";
	}
	
	
	

}
