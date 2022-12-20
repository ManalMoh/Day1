package com.example.assigment7.Reopstory;

import com.example.assigment7.Model.UsersSoftware;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSoftwareRepostry extends JpaRepository<UsersSoftware,Integer> {
       UsersSoftware findUsersSoftwareByUsernameAndPassword(String Username, String Password);
       UsersSoftware findUserByEmail(String email);
       List <UsersSoftware> findUsersSoftwareByRole(String role);
       List<UsersSoftware> findUsersSoftwareByAge(int age);

}
