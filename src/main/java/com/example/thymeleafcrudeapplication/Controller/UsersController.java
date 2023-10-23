package com.example.thymeleafcrudeapplication.Controller;

import com.example.thymeleafcrudeapplication.Entity.Users;
import com.example.thymeleafcrudeapplication.Service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<Users> listUsers = usersService.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }
}
