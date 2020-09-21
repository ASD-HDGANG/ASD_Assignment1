/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.smartcard.controller;

import com.asd.smartcard.dto.UserDto;
import com.asd.smartcard.model.ConfirmationToken;
import com.asd.smartcard.model.User;
import com.asd.smartcard.repository.IConfirmationTokenRepository;
import com.asd.smartcard.repository.IUserRepository;
import com.asd.smartcard.service.EmailSenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.asd.smartcard.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registration")
public class UserRegisterController {

    private IUserService userService;

    public UserRegisterController(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private EmailSenderService emailSenderService;

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
//    @PostMapping
//    public String registerUser(@ModelAttribute("user") UserDto registration) {
//
//        userService.save(registration);
//        return "redirect:/registration?success"; // thymeleaf success parameter
//        
//        // send a notification
//
//    }
    @PostMapping
    public ModelAndView registerUser(ModelAndView modelAndView, UserDto userDto) {

        User existingUser = userRepository.findByEmail(userDto.getEmail());

        if (existingUser != null) {
            modelAndView.addObject("message", "already exists!");
            modelAndView.setViewName("erro");
        } else {
            userService.save(userDto);

            ConfirmationToken confirmationToken = new ConfirmationToken(userDto);
            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userDto.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("hdgangganggang@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            modelAndView.addObject("email", userDto.getEmail());

            modelAndView.setViewName("register_success");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAcct(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {

        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = userRepository.findByEmail(token.getUserDto().getEmail());
            user.setIsEnabled(true);
            userRepository.save(user);
            //modelAndView.setViewName("userVerified");
            modelAndView.setViewName("confirm");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }

}

