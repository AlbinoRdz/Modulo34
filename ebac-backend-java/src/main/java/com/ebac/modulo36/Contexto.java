package com.ebac.modulo36;

import com.ebac.modulo36.model.DireccionesModel;
import com.ebac.modulo36.model.UsuarioModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Optional;

public class Contexto {

    public static void main(String[] args) {
        String connectionString = "mongodb://root:root@localhost:27017";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("modulo32");

        UsuarioModel usuarioModel = new UsuarioModel(database);
        DireccionesModel direccionesModel = new DireccionesModel(database);

        // Crear un usuario
        /*Document document = new Document("nombre", "Isaac")
                .append("edad", 31)
                .append("profesion", "Programador Java");
        usuarioModel.guardar(document);*/

        // Listar usuarios
        // usuarioModel.obtener();

        // Listar usuairo por id
//        ObjectId objectId = new ObjectId("64b9d18405148c2056cf6f2b");
//        Document documentoABuscar = new Document("_id", objectId);
//        Optional<Document> usuarioEncontrado = usuarioModel.obtenerPorId(documentoABuscar);

        // Actualizar usuario
        /*usuarioEncontrado.ifPresent(usuarioActual -> {
            Document document = new Document("nombre", "PedroActualizado").append("edad", 20);
            Document usuarioActualizado = new Document("$set", document);

            usuarioModel.actualizar(usuarioActual, usuarioActualizado);
        });
        usuarioModel.obtener();*/

        // Eliminar usuario
//        usuarioModel.obtener();
//        usuarioEncontrado.ifPresent(usuarioModel::eliminar);
//        usuarioModel.obtener();

        /////////////////////DIRECCIONES/////////////////////////////////////

        //Crear usuario

        Document usuarioDireccion1 = new Document("direccion","calle rio bravo").append("ciudad","rio bravo");
        direccionesModel.guardar(usuarioDireccion1);

        //listar direcciones
        direccionesModel.obtener();
        System.out.println("-----------------------------------");

        // listar por id
        ObjectId objectId= new ObjectId("6744eb540a07471f810836ff");
        Document documentonuevo = new Document("_id", objectId);
        Optional<Document> DireccionEncontrado = direccionesModel.obtenerPorId(documentonuevo);
        System.out.println("-----------------------------------");

        //Actualizar direccion
        DireccionEncontrado.ifPresent(direccionActual -> {
            Document document = new Document("direccion", "Univrsidad actualizado").append("ciudad","Camargo");
            Document direccionActualizado = new Document("$set", document);
            direccionesModel.actualizar(direccionActual,direccionActualizado);
        });

        direccionesModel.obtener();
        System.out.println("-----------------------------------");

        //eliminar direccion
        ObjectId objectId2 = new ObjectId("673d6c78ad533e28da70d721");
        Document direccionParaEliminar = new Document("_id",objectId2).append("direccion", "p, sheerman calle 24");

        direccionesModel.eliminar(direccionParaEliminar);


    }
}
