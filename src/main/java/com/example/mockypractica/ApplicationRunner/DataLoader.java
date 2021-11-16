package com.example.mockypractica.ApplicationRunner;

/*import com.example.mockypractica.model.Employee;
import com.example.mockypractica.model.API;
import com.example.mockypractica.repository.APIRepository;*/
import com.example.mockypractica.model.Usuario;
import com.example.mockypractica.repository.UsuarioRepository;
import org.json.*;
/*import com.example.mockypractica.model.Student;
import com.example.mockypractica.model.Usuario;
import com.example.mockypractica.repository.StudentRepository;
import com.example.mockypractica.repository.UsuarioRepository;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataLoader implements ApplicationRunner {

    //private final StudentRepository studentRepository;
    private final UsuarioRepository usuarioRepository;
    //private final APIRepository apiRepository;



    /*public DataLoader(StudentRepository studentRepository, UsuarioRepository usuarioRepository, APIRepository apiRepository) {
        this.studentRepository = studentRepository;
        this.usuarioRepository = usuarioRepository;
        this.apiRepository = apiRepository;
    }*/

    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /*@Autowired
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

        usuarioRepository.save(new Usuario("Jean Lemoine", "jeanmelvinlp27@gmail.com", "admin"));
        usuarioRepository.save(new Usuario("Roselin Sosa", "moxy04@gmail.com", "user"));

    }

}
