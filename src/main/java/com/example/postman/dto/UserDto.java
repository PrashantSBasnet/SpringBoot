package com.example.postman.dto;

import com.example.postman.entity.Customer;
import com.example.postman.entity.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String userName;
    @NotNull(message = "Address cannot be null")
    @NotBlank(message = "Address cannot be empty")
    private String password;

    private Boolean active;

    private String roles;


    public UserDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.active = user.isActive();

    }
}
