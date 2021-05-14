/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Comparadores;

import java.util.Comparator;
import javaapplication2.Ventanas.Persona;

/**
 *
 * @author Ronal
 */

public class ComparatorNombreDescendente implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		if (o2.getNombre().equals(o1.getNombre())) {
			if (o2.getEdad() == o1.getEdad())
				return 0;
			
			if (o2.getEdad() < o1.getEdad())
				return -1;
			
			if (o2.getEdad() > o1.getEdad())
				return 1;
		} 

		return o2.getNombre().compareTo(o1.getNombre());
	}

}