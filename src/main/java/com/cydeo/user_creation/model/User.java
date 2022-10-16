package com.cydeo.user_creation.model;


import com.cydeo.user_creation.enums.Gender;
import com.cydeo.user_creation.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Gender gender;
    private String address;
    private State state;
    private boolean married;

}
