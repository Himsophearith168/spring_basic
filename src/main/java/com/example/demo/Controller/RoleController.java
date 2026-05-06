package com.example.demo.Controller;


import com.example.demo.Model.Role;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        var roles = roleService.List();
        res.put("Total",roles.size());
        res.put("Success",true);
        res.put("Message","Success");
        res.put("list",roleService.List());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Role>> getById(@PathVariable Long id){
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping
    ResponseEntity<Role> createRole(@RequestBody Role role){
        return ResponseEntity.status(201).body(roleService.createRole(role));
    }

    @PutMapping("/{id}")
    ResponseEntity<Role> updateRole(@PathVariable Long id,@RequestBody Role role){
        return ResponseEntity.status(201).body(roleService.updateRole(id,role));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Role> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
