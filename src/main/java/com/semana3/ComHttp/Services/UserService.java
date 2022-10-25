package com.semana3.ComHttp.Services;

import com.semana3.ComHttp.Entities.Users;
import com.semana3.ComHttp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private UserRepository repository;

    public UserService (UserRepository repository){
        this.repository=repository;
    }

    public Users getorCreateUser (Map<String, Object> userData){
        String email= (String) userData.get("email");

        Users usuario = getUser(email);
        if (usuario == null){
            String image= (String) userData.get("picture");
            String name= (String) userData.get("nickname");
            String Auth0Id= (String) userData.get("sub");

            Users newUser = new Users(email, image, Auth0Id, name);

            return createUser(newUser);
        } else {
            return  usuario;
        }

    }

    public Users createUser(Users newUser){
        return this.repository.save(newUser);
    }

    public Users getUser (String email){
        return this.repository.findByEmail(email);
    }
}
