/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginJavaFX;

import java.util.Vector;

public class ListaUsuaros {

    public static Vector<Cuenta> datos = new Vector<Cuenta>();

    public static void agregar(Cuenta obj) {
        datos.addElement(obj);
    }

    public static void eliminar(int pos) {
        datos.removeElementAt(pos);
    }

    public static Vector mostrar() {
        return datos;
    }

    public static Cuenta getUsuario(String cuenta) {
        Cuenta obj;
        for (int i = 0; i < datos.size(); i++) {
            obj = (Cuenta) datos.elementAt(i);
            if (obj.getUsuario().equalsIgnoreCase(cuenta)) {
                return obj;
            }
        }
        return null;
    }

    public static Cuenta VerificarLogueo(String cuentas, String contrasena) {
        Cuenta obj;
        for (int i = 0; i < datos.size(); i++) {
            obj = (Cuenta) datos.elementAt(i);
            if (obj.getUsuario().equalsIgnoreCase(cuentas) && obj.getContrasena().equalsIgnoreCase(contrasena)) {
                return obj;
            }
        }
        return null;
    }

}
