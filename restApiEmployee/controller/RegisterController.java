package com.example.restApiEmployee.controller;

import com.example.restApiEmployee.entity.Authority;
import com.example.restApiEmployee.entity.Employee;
import com.example.restApiEmployee.entity.EmployeeList;
import com.example.restApiEmployee.entity.User;
import com.example.restApiEmployee.repository.AuthorityRepository;
import com.example.restApiEmployee.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class RegisterController {
    UserRepository userRepo;
    AuthorityRepository authorityRepo;
    private final RestTemplate restTemplate;

    public RegisterController(UserRepository userRepo,AuthorityRepository authorityRepo,RestTemplate restTemplate){
        this.userRepo = userRepo;
        this.authorityRepo = authorityRepo;
        this.restTemplate = restTemplate;
    }
    @GetMapping("/register")
    public String registerForm(Model theModel){
        User newUser = new User();
        theModel.addAttribute("user",newUser);
        List<Authority> authorities = authorityRepo.findAll();
        theModel.addAttribute("authorities",authorities);
        return "registerForm";
    }

    @GetMapping("/getEmployeeFromApi")
    public String getDataFromApi(Model theModel){
        ResponseEntity<EmployeeList> reponse = restTemplate.getForEntity("http://localhost:8080/employees",EmployeeList.class);
        System.out.print("Respuesta de employees");
        System.out.println(reponse);
        EmployeeList foundEmployee = reponse.getBody();
        theModel.addAttribute("employees",foundEmployee);
        return "showEmployee";
    }


    @PostMapping("/register")
    public String processForm(@ModelAttribute("user") User theUser){
        userRepo.save(theUser);
        return "userList";
    }
}
