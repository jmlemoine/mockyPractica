package com.example.mockypractica.API;

import com.example.mockypractica.model.Usuario;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@RestController
public class APIREST {

    //@Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody Usuario usuario) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Usuario> entity = new HttpEntity<Usuario>(usuario,headers);

        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
    }

    /*@Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/postdata",method = RequestMethod.POST)
    public String PostData(){

        return "{\n" +
                "   \"value\":\"4\",\n" +
                "   \"name\":\"David\"\n" +
                "}";
    }

    @RequestMapping(value = "/post")
    public String getPostResponse(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/postdata", HttpMethod.POST,entity,String.class).getBody();
    }*/

    /*@GetMapping(value = "/download/file/pdf/", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> downloadFilePdf() throws IOException {
        String url = "http://www.orimi.com/pdf-test.pdf";

        RestTemplate restTemplate = new RestTemplate();
        byte[] byteContent = restTemplate.getForObject(url, String.class).getBytes(StandardCharsets.ISO_8859_1);
        InputStream resourceInputStream = new ByteArrayInputStream(byteContent);

        return ResponseEntity.ok()
                .header("Content-disposition", "attachment; filename=" + "pdf-with-my-API_pdf-test.pdf")
                .contentType(MediaType.parseMediaType("application/pdf;"))
                .contentLength(byteContent.length)
                .body(new InputStreamResource(resourceInputStream));
    }*/



}
