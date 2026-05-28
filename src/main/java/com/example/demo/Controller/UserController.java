package com.example.demo.Controller;


import com.example.demo.DTO.UserResonse;
import com.example.demo.Model.user;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    ResponseEntity<Map> getAllUser(){
        var user = userService.findAll();
        Map data = new HashMap();
        data.put("Message","Success");
        data.put("List",user.size());
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResonse> getUserById(@RequestParam long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    ResponseEntity<UserResonse> addUser(@RequestBody user user){
        var data = userService.createUser(user);
        Map res = new HashMap();
        res.put("Message","Success");
        res.put("User",user);
        return ResponseEntity.status(201).body(data);
    }

    @PutMapping("/{id}")
    ResponseEntity<UserResonse> updateUser(@PathVariable Long id, @RequestBody user user){
        var data = userService.updateUser(id,user);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping
    public ResponseEntity<Map<String,Object>> deleteUser(@RequestParam long id){
        var user = userService.deleteUser(id);
        Map<String,Object> res = new HashMap();
        res.put("Message","Success");
        res.put("Data",null);
        res.put("Status",200);
        return ResponseEntity.ok(res);
    }

}
