package com.hit.utils;

import com.hit.dm.CartObject;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonHandler {

    // Where we stores our parsed json.
    static ArrayList<CartObject> CartArray = new ArrayList<>();


    public static JSONObject WriteJSON(CartObject CartArray) {
        /// TO DO : A function that converts a CartObject to an JsonObject.
        return null;
    }

    // Helps to read json file from resources.
    private static String readFileFromResources(String filename) throws URISyntaxException, IOException {
        URL resource = JsonHandler.class.getClassLoader().getResource(filename);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(bytes);
    }
}
