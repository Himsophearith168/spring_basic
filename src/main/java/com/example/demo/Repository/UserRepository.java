package com.example.demo.Repository;

import com.example.demo.Model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<user,Long> {
}
