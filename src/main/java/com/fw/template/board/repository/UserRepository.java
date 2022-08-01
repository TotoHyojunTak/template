package com.fw.template.board.repository;

import com.fw.template.board.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
