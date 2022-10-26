package com.exampleIntregration.demoInt;

import com.exampleIntregration.demoInt.model.Apis;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class arayInt {
    public static void main(String[] args) throws Exception{
        Apis entries = new Apis();

        Gson gson = new Gson();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.publicapis.org/entries"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        entries=gson.fromJson(response.body(),Entries.class);
//        System.out.println(entries.getApi());
//        ObjectMapper mapper = new ObjectMapper();
//        entries = mapper.readValue(response.body(), Apis.class);
        JSONObject obj1 = new JSONObject(response.body());
        JSONArray arr = obj1.getJSONArray("entries");
        for (int i = 0; i < arr.length(); i++){
            String api=arr.getJSONObject(i).getString("API");
            String desc=arr.getJSONObject(i).getString("Description");
                String auth=arr.getJSONObject(i).getString("Auth");
                Boolean http=arr.getJSONObject(i).getBoolean("HTTPS");
                String cors=arr.getJSONObject(i).getString("Cors");
                String link=arr.getJSONObject(i).getString("Link");
                String cat=arr.getJSONObject(i).getString("Category");
            System.out.println("{"+api+auth+http+cors+link+cat+"}");
        }
    }
}
