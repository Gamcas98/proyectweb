/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Models.Perfil;
import Models.Usuario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gamcas
 */
public class RegistroUsuario {

    public Usuario login(String usuario, String contra) {

        Usuario user = new Usuario();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Usuario, Contrasena, Tipo FROM USUARIO WHERE Usuario= ? AND Contrasena=?";

        try {
            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, contra);
            rs = ps.executeQuery();

            while (rs.next()) {

                user.setUsuario(rs.getString(1));
                user.setPass(rs.getString(2));
                user.setTipo(rs.getInt(3));
                return user;

            }
            return user;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Perfil datosPerfil(String usuario) {

        Perfil perfil = new Perfil();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM PERFIL WHERE Usuario= ?";

        try {
            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, usuario);
          
            rs = ps.executeQuery();

            while (rs.next()) {

                perfil.setApellido(rs.getString("Apellido"));
                perfil.setNombre(rs.getString("Nombre"));
                perfil.setDescripcion(rs.getString("Descripcion"));
                perfil.setHobbies(rs.getNString("Hobbies"));
                perfil.setUsuario(rs.getString("usuario"));
                perfil.setGustos(rs.getString("Gustos"));
                
                return perfil;

            }
            return null;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean crearUsuario(Usuario usuario) {
        PreparedStatement ps = null;

        String query = "INSERT INTO USUARIO (Usuario,Contrasena,Tipo) VALUES(?,?,?)";

        try {
            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPass());
            ps.setInt(3, usuario.getTipo());
            ps.execute();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("error");
            return false;
        }
    }

    public static boolean crearPerfil(Perfil perfil) {
        PreparedStatement ps = null;

        String query = "INSERT INTO Perfil (Nombre,Apellido,Descripcion,Gustos,Hobbies,Usuario,Foto) VALUES(?,?,?,?,?,?,?)";

        try {
            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, perfil.getNombre());
            ps.setString(2, perfil.getApellido());
            ps.setString(3, perfil.getDescripcion());
            ps.setString(4, perfil.getGustos());
            ps.setString(5, perfil.getHobbies());
            ps.setString(6, perfil.getUsuario());
            ps.setBlob(7, perfil.getFoto());
            ps.execute();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("error");
            return false;

        }
    }

    public void verImagen(String usuario, HttpServletResponse httpServletResponse) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM PERFIL WHERE Usuario= ?";
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        httpServletResponse.setContentType("image/*");

        try {
            outputStream = httpServletResponse.getOutputStream();
            ps = Conexion.getConection().prepareStatement(query);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                inputStream = rs.getBinaryStream("Foto");

            }

            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int i = 0;

            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {

        }

    }

}
