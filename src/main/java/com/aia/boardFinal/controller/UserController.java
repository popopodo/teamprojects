package com.aia.boardFinal.controller;

import com.aia.boardFinal.model.UserDTO;
import com.aia.boardFinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/auth")
    public Map<String, Object> auth(HttpSession session, @RequestBody UserDTO userDTO) {
        UserDTO logIn = userService.auth(userDTO);

        Map<String, Object> resultMap = new HashMap<>();
        if (logIn != null) {
            session.setAttribute("logIn", logIn);
            resultMap.put("message", "success");
        } else {
            resultMap.put("message", "fail");
        }

        return resultMap;
    }

    @ResponseBody
    @PostMapping("validate")
    public Map<String, Object> validateUsername(@RequestBody UserDTO userDTO) {
        Map<String, Object> resultMap = new HashMap<>();

        if (userService.validateUsername(userDTO) == null) {
            resultMap.put("message", "success");
        } else {
            resultMap.put("message", "fail");
        }

        return resultMap;
    }

    @ResponseBody
    @PostMapping("register")
    public Map<String, Object> register(@RequestBody UserDTO userDTO) {
        Map<String, Object> resultMap = new HashMap<>();

        userService.register(userDTO);

        resultMap.put("message", "success");

        return resultMap;
    }
}
