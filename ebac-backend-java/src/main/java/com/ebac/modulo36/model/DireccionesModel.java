package com.ebac.modulo36.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Objects;
import java.util.Optional;

public class DireccionesModel {

    private final MongoCollection<Document> collection;

    public DireccionesModel(MongoDatabase database) {
        collection = database.getCollection("direcciones");
    }


    public void guardar(Document document){
        collection.insertOne(document);

    }

    public void obtener(){
        FindIterable<Document>usuarios = collection.find();

        System.out.println(usuarios);
    }

    public Optional<Document> obtenerPorId(Document document){
        Document usuario = collection.find(document).first();

        if (!Objects.isNull(usuario)){

            System.out.println(usuario);
            return Optional.of(usuario);
        }
        return Optional.empty();

    }

    public void actualizar(Document documentoactual, Document documentoNuevo){
        UpdateResult updateResult = collection.updateOne(documentoactual,documentoNuevo);
        if(updateResult.getModifiedCount() > 0){
            System.out.println("Direccion actualizada con exito");

        }else {
            System.out.println("la direccion no fue encontrada");
        }
    }

    public void eliminar(Document document){
        DeleteResult deleteResult = collection.deleteOne(document);
        if(deleteResult.getDeletedCount() > 0){
            System.out.println("Direccion eliminada con exito");
        }else{
            System.out.println("Direccion No encontrada");
        }
    }



}
