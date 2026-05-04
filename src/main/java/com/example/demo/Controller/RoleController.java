package com.example.demo.Controller;


import com.example.demo.Model.Role;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
//    ResponseEntity <List<Role>> getList(){
//        return ResponseEntity.ok(roleService.List());
//    }

    ResponseEntity <Map> getList(){
        Map res = new HashMap();
        res.put("Total",2);
        res.put("Success",true);
        res.put("Message","Success");
        res.put("list",roleService.List());
        return ResponseEntity.ok(res);

    }

}
