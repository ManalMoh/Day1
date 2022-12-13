package com.example.bank;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class Controller {
ArrayList<Custmer> custmers = new ArrayList<>();
@GetMapping("/custmer")
    public ArrayList<Custmer> getCustmers(){
    return custmers;
}
@PostMapping("/add")
    public ApiResponse AddCustmer(@RequestBody Custmer custmer){
    custmers.add(custmer);
    return new ApiResponse("Custmer added");
}
    @PutMapping("/update/{index}")
    public ApiResponse updateCustmer(@PathVariable int index, @RequestBody Custmer custmer){
        custmers.set(index, custmer);
        return new ApiResponse("Custmer updated");
    }

    @DeleteMapping("/delet/{index}")
    public ApiResponse deletCustmer(@PathVariable int index){
        custmers.remove(index);
        return new ApiResponse("User deleted");
    }
    @PutMapping("/deposit/{amount}/{ID}")
    public ApiResponse depositMony(@PathVariable int amount ,@PathVariable int ID){
        custmers.get(ID).setBalance( custmers.get(ID).getBalance() + amount);
        return new ApiResponse("Deposited");
    }
    @PutMapping("/witdraw/{amount}/{ID}")
    public ApiResponse witdrawMony(@PathVariable int amount ,@PathVariable int ID){
        custmers.get(ID).setBalance( custmers.get(ID).getBalance() - amount);
        return new ApiResponse("witdrawed");
    }



}
