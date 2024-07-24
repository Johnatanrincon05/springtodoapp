package com.api.crud.services;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel saveUser(UserModel userModel){
        return userRepository.save(userModel);
    }
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }
    public UserModel updateById(UserModel userReq,Long id){
        UserModel user = userRepository.findById(id).get();
        user.setFirstname(userReq.getFirstname());
        user.setLastname(userReq.getLastname());
        user.setEmail(userReq.getEmail());
        return user;
    }

    public Boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
