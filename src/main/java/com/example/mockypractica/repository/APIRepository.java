package com.example.mockypractica.repository;

import com.example.mockypractica.model.API;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface APIRepository extends JpaRepository<API, Long> {

    List<API> findByName(String name);

}
