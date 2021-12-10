package com.example.mockypractica;

import org.json.*;
import org.json.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import org.h2.tools.Server;
import java.sql.SQLException;


@SpringBootApplication
@EnableAutoConfiguration
public class MockyPracticaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockyPracticaApplication.class, args);

        /*final String uri = "https://api.myrestservice.com/users";
        RestTemplate restTemplate = new RestTemplate();
        Users result = restTemplate.getForObject(uri, Users.class);
        System.out.println(result);*/

        /*final String uri = "https://run.mocky.io/v3/8505f50b-e094-4077-9c4e-83fd3ec3e94f";//"https://searchEmployee...";

        JSONObject jsonResponse = null;

        RestTemplate restTemplate = new RestTemplate();

        String reqBody = "{"+"id"+": "+"1002"+"}";
        String result = restTemplate.postForObject(uri, reqBody, String.class);

        // convert your result into json

        try {
            jsonResponse = new JSONObject(result);
            System.out.println("\n"+result);
            System.out.println("\nJSON: "+jsonResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //extract a value "name" from your json data:
        try{
            String value = jsonResponse.getString("name");
            System.out.println("\nName: "+value);
        }catch(JSONException e) {
            e.printStackTrace();
        }*/
    }



    /*@ResponseBody
    @RequestMapping(value = "/testclient")
    public String testclient()
    {
        return "{\"hello\":\"world\"}";
    }*/

    /**
     * Para subir H2 modo servidor en Spring Boot.
     @return
     @throws SQLException
     */

}
