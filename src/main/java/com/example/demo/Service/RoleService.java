package com.example.demo.Service;

import com.example.demo.DTO.RoleResponse;
import com.example.demo.Mapper.ProductMapper;
import com.example.demo.Mapper.RoleMapper;
import com.example.demo.Model.Role;
import com.example.demo.Repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    public List<Role> List(){
        return roleRepository.findAll().stream()
                .map(roleMapper::toRoleResponse)
                .collect(Collectors.toList()).reversed();
    }

    public Optional<Role> findById(Long id){
        Role role = roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role not found"));
        return Optional.ofNullable(roleMapper.toRoleResponse(role));
    }

    public Role createRole(Role role){
        Role newRole = roleRepository.save(role);
        return roleMapper.toRoleResponse(newRole);
    }

    public Role updateRole(Long id,Role role){

        Role isChecked =  roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role not found"));
        isChecked.setName(role.getName());
        isChecked.setDescription(role.getDescription());
        Role updatedRole = roleRepository.save(isChecked);
        return roleMapper.toRoleResponse(updatedRole);
    }

    public void deleteRole(Long id){
        Role ischecked =  roleRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Role not found"));
        roleRepository.delete(ischecked);
    }
}
