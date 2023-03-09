package com.Gopal.ChatApplicationProject.dao;

import com.Gopal.ChatApplicationProject.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}
