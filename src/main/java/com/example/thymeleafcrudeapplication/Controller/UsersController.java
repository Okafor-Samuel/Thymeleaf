package com.example.thymeleafcrudeapplication.Controller;

import com.example.thymeleafcrudeapplication.Entity.Users;
import com.example.thymeleafcrudeapplication.Exception.UserNotFoundException;
import com.example.thymeleafcrudeapplication.Service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user", new Users());
        model.addAttribute("pageTitle", "Add New User");
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(Users users, RedirectAttributes ra){
        usersService.save(users);
        ra.addFlashAttribute("message","The user has been saved successfully!");
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
          var user =  usersService.get(id);
          model.addAttribute("user", user);
          model.addAttribute("pageTitle", "Edit User (ID: " +id +")");
          return "user_form";
        } catch (UserNotFoundException e) {
            //  e.printStackTrace();
        }
            ra.addFlashAttribute("message","User updated successfully!");
            return "redirect:/users";

    }
}
