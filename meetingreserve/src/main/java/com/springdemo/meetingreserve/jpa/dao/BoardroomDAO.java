package com.springdemo.meetingreserve.jpa.dao;

import com.springdemo.meetingreserve.jpa.entity.BoardroomDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardroomDAO extends JpaRepository<BoardroomDO,Long> {

    Page<BoardroomDO> findByName(String name, Pageable pageable);

}
