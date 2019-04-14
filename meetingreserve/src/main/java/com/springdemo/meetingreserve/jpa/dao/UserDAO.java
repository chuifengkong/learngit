package com.springdemo.meetingreserve.jpa.dao;

import com.springdemo.meetingreserve.jpa.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserDO, Long> {
    UserDO findByMobile(String mobile);
}
