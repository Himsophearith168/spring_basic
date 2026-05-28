package com.example.demo.Service;

import com.example.demo.DTO.UserResonse;
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

    public List<UserResonse> findAll(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::touserResponse)
                .collect(Collectors.toList());
    }
    public UserResonse findById(Long id){
        user user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.touserResponse(user);
    }

    public UserResonse createUser(user user){
        user data = userRepository.save(user);
        return userMapper.touserResponse(data);
    }

    public UserResonse updateUser(Long id,user user){
        user userExist = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setAddress(user.getAddress());
        user data = userRepository.save(user);
        return userMapper.touserResponse(data);
    }

    public UserResonse deleteUser(Long id){
        user userExist = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(userExist);
        return userMapper.touserResponse(userExist);
    }

}
