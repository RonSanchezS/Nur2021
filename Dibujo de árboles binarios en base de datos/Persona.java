/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

public class Persona implements Identificable{

	private String ci;
	private String nombre;
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Persona(String ci, String nombre) {
		this.ci = ci;
		this.nombre = nombre;
	}
	@Override
	public String getId() {
		return ci;
	}
}