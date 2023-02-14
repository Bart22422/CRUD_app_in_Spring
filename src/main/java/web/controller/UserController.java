package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @GetMapping("/")
    public String index (ModelMap map) {

        List <User> users = userServiceImpl.getUsers();
        map.addAttribute("users", users);

     return"index";
    }
    @PostMapping("/form")
    public String postUser (@RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "date") String date) throws ParseException {
        System.out.println(name );
        System.out.println(lastName);
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse(date);

        User user = new User();
        user.setName(name);
        user.setAge(date1);
        user.setLastName(lastName);
        userServiceImpl.addUser(user);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String postUser (@RequestParam(value = "id") long id)  {
       userServiceImpl.deleteUser(id);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String updateUser (@RequestParam(value = "id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "date") String date) throws ParseException {
       User user = new User();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse(date);
        user.setName(name);
        user.setAge(date1);
        user.setLastName(lastName);
        userServiceImpl.updateUser(id,user);
        return "redirect:/";
    }
    @PostMapping("/clean")
    public String cleanTable(){
        userServiceImpl.cleanTable();
        return "redirect:/";
    }
}
