package com.example.assigment7.Exption;

import lombok.experimental.SuperBuilder;

public class ApiExption extends RuntimeException{
       public ApiExption(String message){
              super(message);
       }


}
