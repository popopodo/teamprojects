package com.aia.boardFinal.model;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String role;
}
