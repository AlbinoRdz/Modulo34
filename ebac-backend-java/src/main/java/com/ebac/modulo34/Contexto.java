package com.ebac.modulo34;

import com.ebac.modulo33.MysqlConnection;
import com.ebac.modulo34.dto.Direccion;
import com.ebac.modulo34.dto.Telefono;
import com.ebac.modulo34.dto.Usuario;
import com.ebac.modulo34.model.DireccionModel;
import com.ebac.modulo34.model.TelefonoModel;
import com.ebac.modulo34.model.UsuarioModel;

import java.sql.Connection;
import java.sql.SQLException;

public class Contexto {

    static Connection connection;


    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/modulo30";
        String user = "root";
        String password = "root";

        MysqlConnection mysqlConnection = new MysqlConnection();
        connection = mysqlConnection.getConnection(url, user, password);

        //operacionConUsuarios();
       // operacionConTelefonos();
        operacionConDirecciones();

        connection.close();
    }

    public static void operacionConUsuarios() throws SQLException {
        System.out.println("------- OPERACION CON USUARIOS -------");
        Usuario usuarioMaria = crearUsuario("Maria", 25);
        Usuario usuarioJulian = crearUsuario("Julian", 23);

        UsuarioModel usuarioModel = new UsuarioModel(connection);
        Usuario maria = usuarioModel.guardar(usuarioMaria);
        Usuario julian = usuarioModel.guardar(usuarioJulian);

        System.out.println(maria);
        System.out.println(julian);
        System.out.println("-----------------------------------");

        Usuario usuario1EnDB = usuarioModel.obtenerPorId(1);
        System.out.println(usuario1EnDB);
        Usuario usuario2EnDB = usuarioModel.obtenerPorId(2);
        System.out.println(usuario2EnDB);
        System.out.println("-----------------------------------");

        Usuario usuarioInexistente = usuarioModel.obtenerPorId(3);
        System.out.println(usuarioInexistente);
        System.out.println("-----------------------------------");

        usuarioModel.eliminarPorId(2);
        Usuario usuario2Eliminado = usuarioModel.obtenerPorId(2);
        System.out.println(usuario2Eliminado);
    }


    public static void operacionConTelefonos() throws SQLException {
        System.out.println("------- OPERACION CON TELEFONOS -------");
        Telefono telefono = crearTelefono(1, "55-11111-22222", "Casa");

        TelefonoModel telefonoModel = new TelefonoModel(connection);
        telefonoModel.guardar(telefono);
        Telefono telefonoEnDB = telefonoModel.obtenerPorId(1);

        System.out.println(telefonoEnDB);
    }

    public static void operacionConDirecciones() throws SQLException {
        // TODO Implementar algunas operaciones
        System.out.println("------- OPERACION CON DIRECCION -------");

        Direccion direccionjuan = crearDireccion(1,"miguel hidalgo",123,"Nuevo leon");
        Direccion direccionmaria = crearDireccion(2,"Ninos Heroes",321,"Nuevo leon");

        DireccionModel direccionModel = new DireccionModel(connection);

        Direccion juan = direccionModel.guardar(direccionjuan);
        Direccion maria = direccionModel.guardar(direccionmaria);

        System.out.println(juan);
        System.out.println(maria);
        System.out.println("-------------------------------------------------");

        Direccion juanUpdate = crearDireccion(1,"EBAC",432,"Mexico");
        juanUpdate.setIdDireccion(1);

        Direccion newJuan = direccionModel.actualizarPorId(juanUpdate);
        System.out.println(newJuan);
        System.out.println("---------------------------------------------------");

        Direccion direccion1 = direccionModel.obtenerPorId(1);
        System.out.println(direccion1);
        Direccion direccion2 = direccionModel.obtenerPorId(2);
        System.out.println(direccion2);
        Direccion direccionNull = direccionModel.obtenerPorId(3);
        System.out.println("------------------------------------------------------");

        direccionModel.eliminarPorId(2);
        Direccion direccion2Null = direccionModel.obtenerPorId(2);
        System.out.println(direccion2Null);
        System.out.println("-------------------------------------------------------");




    }

    private static Usuario crearUsuario(String nombre, int edad) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEdad(edad);

        return usuario;
    }

    private static Telefono crearTelefono(int idUsuario, String numero, String tipo) {
        Telefono telefono = new Telefono();
        telefono.setIdUsuario(idUsuario);
        telefono.setNumero(numero);
        telefono.setTipo(tipo);

        return telefono;
    }

    private static Direccion crearDireccion( int idUsuario, String calle, int numero, String estado){
        Direccion direccion = new Direccion();

        direccion.setIdUsuario(idUsuario);
        direccion.setCalle(calle);
        direccion.setNumero(numero);
        direccion.setEstado(estado);

        return direccion;

    }
}
