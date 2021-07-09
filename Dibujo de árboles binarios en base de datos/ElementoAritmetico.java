/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

public abstract class ElementoAritmetico implements Identificable {

    @Override
    public String getId() {
        return String.valueOf(this.hashCode());
    }

    public abstract String getDatos();

}
