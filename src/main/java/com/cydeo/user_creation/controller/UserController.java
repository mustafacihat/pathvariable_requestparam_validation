package com.cydeo.user_creation.controller;



import com.cydeo.user_creation.enums.State;
import com.cydeo.user_creation.model.User;
import com.cydeo.user_creation.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerUser(Model model) {

        model.addAttribute("users", userService.getUsers());

        return "/user/register-page";
    }

    @GetMapping("/create-page")
    public String getFormPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("states", State.values());
        return "/user/create-page";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute  User user) {
        userService.save(user);

        return "redirect:/user/register";
    }

    @GetMapping("/update/{email}")
    public String updateUser(@PathVariable String email, Model model) {

        model.addAttribute("user", userService.findByEmail(email));
        model.addAttribute("states", State.values());


        return "/user/update-page";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.update(user);

        return "redirect:/user/register";

    }

}
