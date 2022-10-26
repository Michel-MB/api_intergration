package com.exampleIntregration.demoInt.controller;

import com.exampleIntregration.demoInt.entriesRepo;
import com.exampleIntregration.demoInt.model.Apis;
import com.exampleIntregration.demoInt.model.Entries;
import com.exampleIntregration.demoInt.repo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    public repo rep;
    @Autowired
    public entriesRepo er;
    @GetMapping("/getFact")
    public List<Entries>  getFact(){
        try {
            Apis entries = new Apis();
            Entries et=new Entries();
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.publicapis.org/entries"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        entries=gson.fromJson(response.body(),Entries.class);
//        System.out.println(entries.getApi());
//            ObjectMapper mapper = new ObjectMapper();
//            entries = mapper.readValue(response.body(), Apis.class);
//            JSONObject obj1 = new JSONObject(response.body());
//            JSONArray arr = obj1.getJSONArray("entries");
//            for (int i = 0; i < arr.length(); i++){
//                String api=arr.getJSONObject(i).getString("API");
//                String desc=arr.getJSONObject(i).getString("Description");
//                String auth=arr.getJSONObject(i).getString("Auth");
//                String http=arr.getJSONObject(i).getString("HTTPS");
//                String cors=arr.getJSONObject(i).getString("Cors");
//                String link=arr.getJSONObject(i).getString("Link");
//                String cat=arr.getJSONObject(i).getString("Category");
//                er.save(new Entries(api,desc,auth,http,cors,link,cat));
//
//            }
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
                er.save(new Entries(api,desc,auth,http,cors,link,cat));
                System.out.println(api);
            }
            List<Entries> ent=er.findAll();
            return ent;
        }
        catch (Exception E){

        }
        return null;
    }
}
