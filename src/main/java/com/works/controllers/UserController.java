package com.works.controllers;

import com.works.entities.User;
import com.works.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    final UserRepository uRepo;
    public UserController(UserRepository uRepo) {
        this.uRepo = uRepo;
    }


    @GetMapping("")
    public String user(Model model) {
        model.addAttribute("list", uRepo.findAll());
        return "user";
    }


    @PostMapping("/save")
    public String save(User user) {
        uRepo.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            uRepo.deleteById(cid);
        }catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/";
    }


}
