package com.example.demo.Service;


import com.example.demo.Model.Role;
import com.example.demo.Repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    public List<Role> List(){
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Long id){
        return roleRepository.findById(id);
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRole(Long id,Role role){

        Role isChecked =  roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role not found"));
        isChecked.setName(role.getName());
        isChecked.setDescription(role.getDescription());
        return roleRepository.save(isChecked);
    }

    public void deleteRole(Long id){
        Role ischecked =  roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role not found"));
        roleRepository.delete(ischecked);
    }
}
