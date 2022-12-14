package com.example.assigmnet4;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Controller {
ArrayList<Eployees> employees = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Eployees> getEmployees(){
           return employees;
    }
    @PostMapping("/add")
    public ResponseEntity addEmployees(@RequestBody @Valid Eployees employee, Errors errors){
        if(errors.hasErrors()){
          String message = errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        employees.add(employee);
        return ResponseEntity.status(201).body(new ApiResponse("Employee added"));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployess(@PathVariable int index, @RequestBody @Valid Eployees employee, Errors errors) {
        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse((massege)));
        }
        employees.set(index,employee);
        return ResponseEntity.status(201).body(new ApiResponse("Employee updated"));
    }
    @DeleteMapping("/delet/{index}")
    public ResponseEntity deletEmployees(@PathVariable @Valid int index, Errors errors){

        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse((massege)));
        }
        employees.remove(index);
        return ResponseEntity.status(201).body(new ApiResponse("Employee deleted!"));
    }
}
