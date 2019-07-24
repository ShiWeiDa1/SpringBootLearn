package com.swd.springboot.repository;

import com.swd.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author swd
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
