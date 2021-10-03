package com.example.mockypractica.ApplicationRunner;

import com.example.mockypractica.model.Student;
import com.example.mockypractica.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public DataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        studentRepository.save(new Student("Jean Melvin Lemoine", "jeanmelvinlp27@gmail.com", Long.parseLong("8298179117")));
    }

}
