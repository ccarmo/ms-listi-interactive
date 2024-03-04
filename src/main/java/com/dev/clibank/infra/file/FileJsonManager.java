package com.dev.clibank.infra.file;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class FileJsonManager {
    
    private final static Gson gson = new Gson();
    protected static void saveFileJson(String fileName, Object object) {

        try {
            
            String stringJson = gson.toJson(object);
            FileWriter fileWriter = new FileWriter(fileName);
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
    
    
}
