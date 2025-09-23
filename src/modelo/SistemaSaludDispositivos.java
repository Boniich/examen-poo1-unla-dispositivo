package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaSaludDispositivos {

	private List<Empresa> listaEmpresas;
	private List<Dispositivo> listaDispositivos;
	
	public SistemaSaludDispositivos() {
		this.listaEmpresas = new ArrayList<Empresa>();
		this.listaDispositivos = new ArrayList<Dispositivo>();
	}
	
	
	//Caso de uso: traerEmpresa
	
	public Empresa traerEmpresa(String nombre) {
		Empresa empresaBuscada = null;
		int index = 0;
		boolean encontrado = false;
		while(index < listaEmpresas.size() && !encontrado) {
			if(listaEmpresas.get(index).getNombre().equalsIgnoreCase(nombre)) {
				empresaBuscada = listaEmpresas.get(index);
				encontrado = true;
			}
			index++;
		}
		
		return empresaBuscada;
	}
	
	//Caso de uso: traerDispositivo
	public Dispositivo traerDispositivo(String codigo) {
		Dispositivo dispositivoBuscado = null;
		int index = 0;
		boolean encontrado = false;
		while(index < listaDispositivos.size() && !encontrado) {
			if(listaDispositivos.get(index).getCodigo().equals(codigo)) {
				dispositivoBuscado = listaDispositivos.get(index);
				encontrado = true;
			}
			index++;
		}
		
		return dispositivoBuscado;
	}
	
	
	//caso de uso: agregar empresa
	public boolean agregarEmpresa(String nombre) throws Exception {
		if(traerEmpresa(nombre) != null) throw new Exception("Error: La empresa ya existe");
		
		int id = 1;
		if(!listaEmpresas.isEmpty()) id = listaEmpresas.get(listaEmpresas.size()-1).getId()+1;
		return listaEmpresas.add(new Empresa(id,nombre));
		
	}
	
	//Caso deuso: agregar dispositivo
	public boolean agregarDispositivo(String nombre, String codigo, Empresa empresa) throws Exception {
		if(codigo.length() != 5) throw new Exception("Error: La longitud del codigo es incorrecta!");
		int digitosCodigo = Integer.parseInt(codigo.substring(1, 5));
		int total = 0;
		
		while(digitosCodigo!=0) {
			int digito = digitosCodigo%10;
			total = total +digito;
			digitosCodigo = digitosCodigo/10;
		}
		
		if((total%2 == 0 && codigo.charAt(0) != 'A')
			|| (total%2 != 0 && codigo.charAt(0) != 'B')) throw new Exception("Error: el codigo es incorrecto");
		
		int id = 1;
		if(!listaDispositivos.isEmpty()) id = listaDispositivos.get(listaDispositivos.size()-1).getId()+1;
		return listaDispositivos.add(new Dispositivo(id, nombre, codigo, empresa));
	}
	
	
	public List<Metrica> traerMetricas(Dispositivo dispositivo, LocalDate desde, LocalDate hasta,
			int menorAValor){
		List<Metrica> metricas = new ArrayList<Metrica>();
		
		metricas = dispositivo.traerMetricas(desde, hasta);
		
		for(Metrica m : metricas) {
			if(m.getValor() > menorAValor) {
				metricas.remove(m);
			}
		}
		
		return metricas;
	}
	
	public List<Metrica> traerMetricas2(Dispositivo dispositivo, LocalDate desde, LocalDate hasta,
			int menorAValor){
		List<Metrica> metricas = new ArrayList<Metrica>();

		for(Metrica m: dispositivo.getListaMetricas()) {
			if((m.getFecha().equals(desde) || m.getFecha().equals(hasta)
					|| (m.getFecha().isAfter(desde) && m.getFecha().isBefore(hasta)) && 
					m.getValor() < menorAValor)
			) {
				metricas.add(m);
			}
		}
		
		return metricas;
	}
	

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public List<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}
	
	
}
