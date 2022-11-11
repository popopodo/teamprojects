package com.aia.boardFinal.controller;

import com.aia.boardFinal.model.UserDTO;
import com.aia.boardFinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/auth")
    public Map<String, Object> auth(@RequestParam Map<String, Object> data) {
        System.out.println(data);

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("message", "success");

        return resultMap;
    }
}
