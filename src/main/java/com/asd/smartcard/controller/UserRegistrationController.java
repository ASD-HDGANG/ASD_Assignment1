/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.controller;

import com.asd.smartcard.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.asd.smartcard.service.IUserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private IUserService userService;

    public UserRegistrationController(IUserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user") // using with userRegistrationDto model class to interact with the html form.
    public UserDto registration() {
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

//        // alternate method from above can be like this.
//    @GetMapping
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new UserRegistrationDto());
//        return "sign-up";
//    }
    @PostMapping
    public String registerUser(@ModelAttribute("user") UserDto registration) {

        userService.save(registration);
        return "redirect:/registration?success"; // thymeleaf success parameter
        
        // send a notification

    }

}

