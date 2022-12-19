package com.example.assigment7.Service;

import com.example.assigment7.Model.UsersSoftware;
import com.example.assigment7.Reopstory.UserSoftwareRepostry;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class UserSoftwareService {
      private final UserSoftwareRepostry userSoftwareRepostry;


public List<UsersSoftware> getUserSoftwarer(){
      return userSoftwareRepostry.findAll();
}

public void AddUserSoftware(UsersSoftware usersSoftware){
      userSoftwareRepostry.save(usersSoftware);
}
public Boolean updatUserSoftware(Integer id, UsersSoftware usersSoftware){
    UsersSoftware oldUserSoftware=userSoftwareRepostry.getById(id);
    if (oldUserSoftware==null){
        return false;
    }
    oldUserSoftware.setID(usersSoftware.getID());
    oldUserSoftware.setName((usersSoftware.getName()));
    oldUserSoftware.setUsername(usersSoftware.getUsername());
    oldUserSoftware.setPassword(usersSoftware.getPassword());
    oldUserSoftware.setEmail(usersSoftware.getEmail());
    oldUserSoftware.setRole(usersSoftware.getRole());
    oldUserSoftware.setAge(usersSoftware.getAge());
    userSoftwareRepostry.save(oldUserSoftware); //save the data on the database
    return true;

}
    public Boolean deletUsersoftware(Integer id ){
        UsersSoftware usersSoftware=userSoftwareRepostry.getById(id);
        if(usersSoftware==null){
            return false;
        }
        userSoftwareRepostry.delete(usersSoftware);
        return true;
    }

}
