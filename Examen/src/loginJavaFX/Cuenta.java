/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginJavaFX;

public class Cuenta {

    private String usuario;
    private String contrasena;
    private double dinero;
    private double ultimoIngreso;
    private double ultimaRetirada;

    public double getUltimoIngreso() {
        return ultimoIngreso;
    }

    public double getUltimaRetirada() {
        return ultimaRetirada;
    }

    public void setUltimoIngreso(double ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }

    public void setUltimaRetirada(double ultimaRetirada) {
        this.ultimaRetirada = ultimaRetirada;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasenas) {
        this.contrasena = contrasenas;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "usuario=" + usuario + ", contrasena=" + contrasena + ", dinero=" + dinero + ", ultimoIngreso=" + ultimoIngreso + ", ultimaRetirada=" + ultimaRetirada + '}';
    }

}
