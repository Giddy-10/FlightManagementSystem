package fms.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonPersistenceService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    public static <T> void save(List<T> items, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            GSON.toJson(items, writer);
            System.out.println("Data saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data to " + fileName + ": " + e.getMessage());
        }
    }
    
    public static <T> List<T> load(String fileName, Type typeToken) {
        File datafile = new File(fileName);
        if (!datafile.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(fileName)) {
            List<T> items = GSON.fromJson(reader, typeToken);
            System.out.println("Data loaded from: " + fileName);
            return (items != null) ? items : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Data loaded from: " + fileName + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
