package com.example.mockypractica.repository;

import com.example.mockypractica.model.Mock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockRepository extends JpaRepository<Mock, Long> {

    List<Mock> findByName(String name);

}
