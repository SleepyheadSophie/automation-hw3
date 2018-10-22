package com.sleepyheadsophie.model;

import com.google.gson.reflect.TypeToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import com.google.gson.JsonParser;

public class HttpClient {


    public String getData (String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine=reader.readLine())!=null){
            response.append(inputLine);
        }

        reader.close();
        //print result
        //System.out.println(response.toString());
        httpClient.close();
        return response.toString();
    }

    public String getAttribute (String jsonData, String attribute){
        JsonElement root = new JsonParser().parse(jsonData);
        //Get the content of the first map
        java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(root, mapType );
        return (map.get(attribute).toString());
    }


}
