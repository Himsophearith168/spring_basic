package com.example.demo.Service;


import com.example.demo.Model.Role;
import com.example.demo.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public List<Role> List(){
        return roleRepository.findAll();
    }
}
