package com.ebac.modulo36;

import com.ebac.modulo36.model.UsuarioModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Optional;

public class Contexto {

    public static void main(String[] args) {
        String connectionString = "mongodb://root:toor@localhost:27017";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("modulo36");

        UsuarioModel usuarioModel = new UsuarioModel(database);

        // Crear un usuario
        /*Document document = new Document("nombre", "Isaac")
                .append("edad", 31)
                .append("profesion", "Programador Java");
        usuarioModel.guardar(document);*/

        // Listar usuarios
        // usuarioModel.obtener();

        // Listar usuairo por id
        ObjectId objectId = new ObjectId("64b9d18405148c2056cf6f2b");
        Document documentoABuscar = new Document("_id", objectId);
        Optional<Document> usuarioEncontrado = usuarioModel.obtenerPorId(documentoABuscar);

        // Actualizar usuario
        /*usuarioEncontrado.ifPresent(usuarioActual -> {
            Document document = new Document("nombre", "PedroActualizado").append("edad", 20);
            Document usuarioActualizado = new Document("$set", document);

            usuarioModel.actualizar(usuarioActual, usuarioActualizado);
        });
        usuarioModel.obtener();*/

        // Eliminar usuario
        usuarioModel.obtener();
        usuarioEncontrado.ifPresent(usuarioModel::eliminar);
        usuarioModel.obtener();
    }
}
