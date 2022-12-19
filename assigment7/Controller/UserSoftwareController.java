package com.example.assigment7.Controller;

import com.example.assigment7.Dto.ApiResponse;
import com.example.assigment7.Model.UsersSoftware;
import com.example.assigment7.Service.UserSoftwareService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController

public class UserSoftwareController {
       private final UserSoftwareService userSoftwareService;


    @GetMapping("/get")
    public ResponseEntity getUsersoftware() {
        List<UsersSoftware> usersSoftwares = userSoftwareService.getUserSoftwarer();
        return ResponseEntity.status(200).body(usersSoftwares);
    }

    @PostMapping("/add")
    public ResponseEntity addUsersoftware(@RequestBody @Valid UsersSoftware usersSoftware, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        userSoftwareService.AddUserSoftware(usersSoftware);
        return ResponseEntity.status(200).body(new ApiResponse("User software added!"));
    }



    @PutMapping("/update/{index}")
    public ResponseEntity updateUsersoftware(@PathVariable Integer id, @RequestBody @Valid UsersSoftware usersoftware, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        userSoftwareService.updatUserSoftware(id, usersoftware);
        return ResponseEntity.status(200).body(new ApiResponse("Useersoftware updated!"));
    }


    @DeleteMapping("/delete/{index}")
    public String deleteUsersoftware(@PathVariable Integer id) {
        userSoftwareService.deletUsersoftware(id);
        return "Usersoftware deleted";
    }
}
