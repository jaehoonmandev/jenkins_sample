package org.jaehoonman.jenkins_sample.controller;

import org.jaehoonman.jenkins_sample.entity.Users;
import org.jaehoonman.jenkins_sample.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class home {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String home(Model model){

        List<Users> users = usersService.findAllUsers();

        model.addAttribute("users", users);

        return "home";
    }
}
