/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gamcas
 */
public class ObtenerDatos {

    
    //metodo que nos regresa la conrasena de un usuario
    public static String obtenerPorcentajeActual(String usuario) {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT Contrasena FROM USUARIO WHERE Usuario=?";

            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                String contra = rs.getString(1);//varibale para almacenar el dato que nos trae rs
                return contra;//y retornamos el valor para manejarlo afuera
            }

            return null;
        } catch (SQLException | ClassNotFoundException ex) {
            return null;
        }

    }

    //metodo que nos regresa la ultima tarifa de operacion ingresada
    public static String obtenerUltimoPagoUsuario() {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT tarifa_operacion FROM cuotas_punto_control ORDER BY id_cuota DESC LIMIT 1";

            ps = Conexion.getConection().prepareStatement(query);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                String tarifa = rs.getString(1);//varibale para almacenar el dato que nos trae rs
                return tarifa;//y retornamos el valor para manejarlo afuera
            }

            return null;
        } catch (SQLException | ClassNotFoundException ex) {
            return null;
        }

    }

    public static String obtenerLikes() {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT precio_libra FROM cuotas_paquetes ORDER BY id_cuota DESC LIMIT 1";

            ps = Conexion.getConection().prepareStatement(query);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                String tarifa = rs.getString(1);//varibale para almacenar el dato que nos trae rs
                return tarifa;//y retornamos el valor para manejarlo afuera
            }

            return null;
        } catch (SQLException | ClassNotFoundException ex) {
            return null;
        }

    }

    public static String obtenerCuotaSuscripcion() {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT tarifa_prioridad FROM cuotas_paquetes ORDER BY id_cuota DESC LIMIT 1";

            ps = Conexion.getConection().prepareStatement(query);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                String tarifa = rs.getString(1);//varibale para almacenar el dato que nos trae rs
                return tarifa;//y retornamos el valor para manejarlo afuera
            }

            return null;
        } catch (SQLException | ClassNotFoundException ex) {
            return null;
        }

    }

    //metodo que nos devuelve el total de puntos de control que tiene asignado un usuario
    public static int ObtenerCostoGlobal(String nombre) {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT COUNT(usuario) FROM punto_de_control WHERE usuario=?";

            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                int numero = rs.getInt(1);//varibale para almacenar el dato que nos trae rs
                return numero;//y retornamos el valor para manejarlo afuera
            }

            return 0;
        } catch (SQLException | ClassNotFoundException ex) {
            return 0;
        }

    }

    //metodo que nos regresa el total de paquetes que estan en cola de un punto de control
    
    
    //nos sirve para ver si nos devuelve 0 
    //si nos devuelve 0 quiere decir que tendremos que almscer en cotos diarios el costo que este por dia
    //osea guardaremos el metodo de arriba en la tabla costos
    public static int obtenerCostoRevista(String nombre, int id) {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT cola FROM punto_de_control WHERE Ruta=? AND id_punto_control=?";

            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, nombre);
            ps.setInt(2, id);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                int numero = rs.getInt(1);//varibale para almacenar el dato que nos trae rs
                return numero;//y retornamos el valor para manejarlo afuera
            }

            return 0;
        } catch (SQLException | ClassNotFoundException ex) {
            return 0;
        }

    }
    
    
    //metodo que nos regresa el total de paquetes que admite un punto de control
    public static int obtenerPaquetesPermitidos(String nombre, int id) {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT cantidad_paquetes FROM punto_de_control WHERE Ruta=? AND id_punto_control=?";

            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, nombre);
            ps.setInt(2, id);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                int numero = rs.getInt(1);//varibale para almacenar el dato que nos trae rs
                return numero;//y retornamos el valor para manejarlo afuera
            }

            return 0;
        } catch (SQLException | ClassNotFoundException ex) {
            return 0;
        }

    }
    
    
    //metodo que nos regrea el total de paquetes en una ruta
        
    public static int obtenerPaquetesEnRuta(String nombre) {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT count(id_paquete) FROM PAQUETE WHERE Ruta=? AND Estado='Ruta'";

            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                int numero = rs.getInt(1);//varibale para almacenar el dato que nos trae rs
                return numero;//y retornamos el valor para manejarlo afuera
            }

            return 0;
        } catch (SQLException | ClassNotFoundException ex) {
            return 0;
        }

    }

    //metodo para obtener el total de paquetes que ya fueron entregados
    public static int obtenerPaquetesEntregados(String nombre) {

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT count(id_paquete) FROM PAQUETE WHERE Ruta=? AND Estado='Destino' OR Estado='Entregado'";

            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
//si rs nos trae datos
            if (rs.next()) {
                int numero = rs.getInt(1);//varibale para almacenar el dato que nos trae rs
                return numero;//y retornamos el valor para manejarlo afuera
            }

            return 0;
        } catch (SQLException | ClassNotFoundException ex) {
            return 0;
        }

    }
    
    
    
    
    
}
