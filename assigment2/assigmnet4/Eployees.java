package com.example.assigmnet4;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data @AllArgsConstructor
public class Eployees {
    @NotEmpty(message = "ID can't be Empty")
    @Size(min = 2 , max = 10, message = "ID most be more than 2")
    private String ID;
    @NotEmpty(message = "Name must be filled!")
    @Size(min = 2,max = 10,message = "Name must be more than 2!")
    private String name;
    @NotNull(message="Age must be filled!")
    @Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Age must be number!")
    @Min(value = 25, message = "Age must be more than 25")
    private int age;
    @AssertFalse
    private boolean onLeave;
    @NotNull(message = "Year must be filled!")
    @Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Year must be number!")
    @Min(value = 1990,message = "Year should be more then 1990")
    @Max(value = 2022, message = "Year must be less than 2022")
    private int employmentYear;
    @NotNull(message = "AnnualLeave must be filled!")
    @Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "AnnualLeave must be number!")
    private int annualLeave;
}
