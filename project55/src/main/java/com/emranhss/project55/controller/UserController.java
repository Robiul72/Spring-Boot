package com.emranhss.project55.controller;

import com.emranhss.project55.model.Role;
import com.emranhss.project55.model.User;
import com.emranhss.project55.repository.IRoleRepo;
import com.emranhss.project55.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserRepo userRepo;
    @Autowired
    IRoleRepo roleRepo;



    @GetMapping("/admin/all")
    public String allUser(Model m){
        List<User> userList=userRepo.findAll();
        m.addAttribute("userList", userList);
        return "alluser";

    }

    @RequestMapping("/public/saveform")
    public String userSaveForm(Model m){
        m.addAttribute("user", new User());
        return  "saveuserform";
    }

    @PostMapping("/publc/save")
    public String save(@ModelAttribute User user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole=new Role(1);
        user.addRole(userRole);
        userRepo.save(user);
        return "redirect:/";
    }


}
