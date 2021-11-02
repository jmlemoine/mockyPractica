package Mock;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/*@Controller
@RequestMapping("/demo")*/
@RestController
public class MockCRUD {

    RestTemplate restTemplate = new RestTemplate();

    /*@ResponseBody
    @RequestMapping(method = GET, produces = "application/json")*/
    @GetMapping("/demo")
    public String demo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.mocky.io/v2/5185415ba171ea3a00704eed", HttpMethod.GET, entity, String.class).getBody();
        //return "{\"hello\":\"world\"}";
    }


}
