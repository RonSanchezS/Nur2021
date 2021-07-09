/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;


public class TestArbolAritmetico {
	public static void main(String[] args) {
		/*ArbolAritmetico a = new ArbolAritmetico();
		
		Operador suma1 = new Operador("+"); 
		a.addHijo(suma1, null);
		a.addHijo(new Numero(5.0), suma1.getId());
		
		Operador suma2 = new Operador("+");
		a.addHijo(suma2, suma1.getId());
		a.addHijo(new Numero(4.0), suma2.getId());
		a.addHijo(new Numero(7.0), suma2.getId());
		
		System.out.println(a);*/
		
		try {
			ArbolAritmetico b1 = new ArbolAritmetico("3+4");
			
			System.out.println(b1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}