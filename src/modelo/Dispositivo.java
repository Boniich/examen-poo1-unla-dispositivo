package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dispositivo {

	private int id;
	private String nombre;
	private String codigo;
	private List<Metrica> listaMetricas;
	private Empresa empresa;
	public Dispositivo(int id, String nombre, String codigo, Empresa empresa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.listaMetricas = new ArrayList<Metrica>();
		this.empresa = empresa;
	}
	
	//caso de uso 5
	public boolean agregarMetrica(int valor, LocalDate fecha, LocalTime hora) {
		return listaMetricas.add(new Metrica(valor,fecha,hora));
	}
	
	//Caso de uso 6
	public Metrica traerMetrica(LocalDate fecha, LocalTime hora) {
		Metrica metricaBuscada = null;
		int index = 0;
		boolean encontrado = false;
		while(index < listaMetricas.size() && !encontrado) {
			if(listaMetricas.get(index).getFecha().equals(fecha) && 
					listaMetricas.get(index).getHora().equals(hora)) {
				metricaBuscada = listaMetricas.get(index);
				encontrado = true;
			}
			index++;
		}
		
		return metricaBuscada;
	}
	
	public List<Metrica> traerMetricas(LocalDate desde, LocalDate hasta){
		List<Metrica> metricas = new ArrayList<Metrica>();
		
		for(Metrica m: listaMetricas) {
			if(m.getFecha().equals(desde) || m.getFecha().equals(hasta)
					|| (m.getFecha().isAfter(desde) && m.getFecha().isBefore(hasta))) {
				metricas.add(m);
			}
		}
		
		return metricas;
	}
	

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<Metrica> getListaMetricas() {
		return listaMetricas;
	}
	public void setListaMetricas(List<Metrica> listaMetricas) {
		this.listaMetricas = listaMetricas;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dispositivo other = (Dispositivo) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(empresa, other.empresa) && id == other.id
				&& Objects.equals(listaMetricas, other.listaMetricas) && Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", listaMetricas="
				+ listaMetricas + ", empresa=" + empresa + "]";
	}
	
	
	
	
	
}
