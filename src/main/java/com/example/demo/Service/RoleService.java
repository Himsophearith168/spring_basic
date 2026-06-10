package com.example.demo.Service;

import com.example.demo.DTO.RoleRequest;
import com.example.demo.DTO.RoleResponse;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Mapper.RoleMapper;
import com.example.demo.Model.Role;
import com.example.demo.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public List<RoleResponse> findAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toResponse)
                .collect(Collectors.toList());
    }

    public RoleResponse findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
        return roleMapper.toResponse(role);
    }

    public RoleResponse createRole(RoleRequest request) {
        Role role = roleMapper.toEntity(request);
        Role savedRole = roleRepository.save(role);
        return roleMapper.toResponse(savedRole);
    }

    public RoleResponse updateRole(Long id, RoleRequest request) {
        Role roleExist = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));

        roleExist.setName(request.name());
        roleExist.setDescription(request.description());

        Role updatedRole = roleRepository.save(roleExist);
        return roleMapper.toResponse(updatedRole);
    }

    public void deleteRole(Long id) {
        Role roleExist = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
        roleRepository.delete(roleExist);
    }
}
