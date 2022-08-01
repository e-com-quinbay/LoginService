package com.example.CartiqueMySQL.service;


import com.example.CartiqueMySQL.entity.Client;
import com.example.CartiqueMySQL.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService {


    @Autowired
    ClientRepository clientRepository;


    public Client login( String email, String password)
    {
        if(email.length() == 0 || password.length()==0)
            return null;

        List<Client> getUser = clientRepository.findByEmail(email);

        if (getUser.size() > 0) {
            Client user = getUser.get(0);
            String storedPassword = user.getPassword();

            String hashedPassword = password; //hash the password field
            if (storedPassword.compareTo(hashedPassword) == 0)
                return user;
        }
            return null;

    }


    public Client signup(Client client)
    {
        if (!isValid(client))
            return null;

        List<Client> checkRegister=clientRepository.findByEmail(client.getEmail());
        if(checkRegister.size()==0) {
            String password = client.getPassword();
            String hashPassword = password; //hash password

            client.setPassword(hashPassword);

            Client newClient = clientRepository.save(client);

            return newClient;
        }
        else {
            return null;
        }
    }

    public boolean isValid(Client client)
    {
        if (client.getMobile()<=999999999 || client.getEmail().length()==0 || client.getGender().length()==0 ||
                client.getPassword().length()<8 || client.getName().length()==0 )
            return false;

        String email = client.getEmail();
        String password = client.getPassword();

        if(email.length()==0 || !email.contains("@") || !email.contains("."))
            return false;


        return true;

    }

}
