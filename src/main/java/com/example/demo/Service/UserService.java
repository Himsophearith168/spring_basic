package com.example.demo.Service;

import com.example.demo.DTO.UserRequest;
import com.example.demo.DTO.UserResponse;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Model.user;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    public UserResponse findById(Long id) {
        user user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toResponse(user);
    }

    public UserResponse createUser(UserRequest request) {
        user user = userMapper.toEntity(request);
        user savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public UserResponse updateUser(Long id, UserRequest request) {
        user userExist = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        
        userExist.setUsername(request.username());
        userExist.setPassword(request.password());
        userExist.setEmail(request.email());
        userExist.setAddress(request.address());
        
        user updatedUser = userRepository.save(userExist);
        return userMapper.toResponse(updatedUser);
    }

    public void deleteUser(Long id) {
        user userExist = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(userExist);
    }
}
