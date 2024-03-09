package com.dev.clibank.infra.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FileJsonManager {
    
    private final static Gson gson = new Gson();

    private final static String PATH_DB = "db/";

    protected  static <T> void updatedFileJson(String nameFileJson, T objectEntities, Class<T> classEntitie) {
       List<T> listObjects = getFileListJson(nameFileJson, classEntitie);
       listObjects.add(objectEntities);
       saveFileJson(listObjects, nameFileJson);
    }

    protected static <T> void saveFileJson(List<T> listObjects, String nameFileJson) {

        try {
            
            String stringJson = gson.toJson(listObjects);
            String concatPath = PATH_DB + nameFileJson;
            FileWriter fileWriter = new FileWriter(concatPath);
            fileWriter.write(stringJson);
            fileWriter.close();
            System.out.println("Success saved file!");
        } catch (IOException e) {
            System.out.println("Error saved file" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    public static <T> T getFileJson(BufferedReader fileJson, Class<T> classEntitie) {
        try {
            return gson.fromJson(fileJson, classEntitie);
        } catch (Exception e) {
            System.out.println("Error saved file" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
    }

    public static <T> List<T> getFileListJson(String nameFileJson, Class<T> classEntitie) {
        try {
            String concatPath = PATH_DB + nameFileJson;
            BufferedReader fileJson = new BufferedReader(new FileReader(concatPath));
            Type jsonLisType = TypeToken.getParameterized(ArrayList.class,classEntitie).getType();
            List<T> listJson = gson.fromJson(fileJson, jsonLisType);
            return listJson;
        } catch (Exception e) {
            System.out.println("Error saved file" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
