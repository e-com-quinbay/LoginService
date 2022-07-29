package com.example.CartiqueMySQL.repository;

import com.example.CartiqueMySQL.entity.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface ClientRepository extends CrudRepository<Client,String> {
    public List<Client> findByEmail(String email);
}
