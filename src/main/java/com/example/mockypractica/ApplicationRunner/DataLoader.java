package com.example.mockypractica.ApplicationRunner;

//import com.example.mockypractica.model.Employee;
import com.example.mockypractica.model.API;
import com.example.mockypractica.repository.APIRepository;
import org.json.*;
import com.example.mockypractica.model.Student;
import com.example.mockypractica.model.Usuario;
import com.example.mockypractica.repository.StudentRepository;
import com.example.mockypractica.repository.UsuarioRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataLoader implements ApplicationRunner {

    private final StudentRepository studentRepository;
    private final UsuarioRepository usuarioRepository;
    private final APIRepository apiRepository;



    public DataLoader(StudentRepository studentRepository, UsuarioRepository usuarioRepository, APIRepository apiRepository) {
        this.studentRepository = studentRepository;
        this.usuarioRepository = usuarioRepository;
        this.apiRepository = apiRepository;
    }

    /*@Autowired
    public DataLoader(StudentRepository studentRepository, UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.studentRepository = studentRepository;
    }

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.studentRepository = ;
    }

    @Autowired
    public DataLoader(StudentRepository studentRepository, UsuarioRepository usuarioRepository, EmployeeRepository employeeRepository) {
        this.studentRepository = studentRepository;
        this.usuarioRepository = usuarioRepository;
        this.employeeRepository = employeeRepository;
    }*/

    @Override
    public void run(ApplicationArguments args) {

        final String uri = "https://run.mocky.io/v3/8505f50b-e094-4077-9c4e-83fd3ec3e94f";//"https://searchEmployee...";

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
        long valueId = 0;
        String valueName = "";
        String valueAddress = "";
        try{
            valueId = jsonResponse.getLong("id");
            valueName = jsonResponse.getString("name");
            valueAddress = jsonResponse.getString("address");
            System.out.println("\nName: "+valueName);
        }catch(JSONException e) {
            e.printStackTrace();
        }

        studentRepository.save(new Student("Jean Melvin Lemoine", "jeanmelvinlp27@gmail.com", Long.parseLong("8298179117")));
        usuarioRepository.save(new Usuario("Jean Lemoine", "jeanmelvinlp27@gmail.com", "admin"));
        usuarioRepository.save(new Usuario("Roselin Sosa", "moxy04@gmail.com", "user"));
        apiRepository.save(new API(valueId, valueName, valueAddress));
        //employeeRepository.save(new Employee(61206L, "Jean Lemoine", 25000, "TI"));

    }

}
