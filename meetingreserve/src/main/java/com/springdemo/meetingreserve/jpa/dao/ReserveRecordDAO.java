package com.springdemo.meetingreserve.jpa.dao;

import com.springdemo.meetingreserve.jpa.entity.ReserveRecordDO;
import com.springdemo.meetingreserve.web.vo.ReserveRecordVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReserveRecordDAO extends JpaRepository<ReserveRecordDO,Long> {
        List<ReserveRecordDO> findByBoardroomIdAndReserveDate(Long boardroomId,Date reserveDate);

        @Query(value = "SELECT new com.springdemo.meetingreserve.web.vo.ReserveRecordVO(" +
                "r.id,r.userName,r.boardroomName,r.reserveDate,r.startTime,r.endTime," +
                "r.actualEndtime,r.delayTime) FROM ReserveRecordDO r WHERE r.status = 'unremove' AND " +
                "r.reserveDate > ?1")
        List<ReserveRecordVO> fingByDateGreater(Date reserveDate);

        @Query(value = "SELECT new com.springdemo.meetingreserve.web.vo.ReserveRecordVO(" +
                "r.id,r.userName,r.boardroomName,r.reserveDate,r.startTime,r.endTime," +
                "r.actualEndtime,r.delayTime) FROM ReserveRecordDO r WHERE r.status = 'unremove' AND " +
                "r.reserveDate = ?1 AND r.startTime > ?2")
        List<ReserveRecordVO> fingByDateSameTimeGreater(Date reserveDate,Date startTime);

        @Query(value = "SELECT new com.springdemo.meetingreserve.web.vo.ReserveRecordVO(" +
                "r.id,r.userName,r.boardroomName,r.reserveDate,r.startTime,r.endTime," +
                "r.actualEndtime,r.delayTime) FROM ReserveRecordDO r WHERE r.status = 'unremove' AND " +
                "r.reserveDate = ?1 AND r.startTime <= ?2 AND r.endTime >= ?2")
        List<ReserveRecordVO> fingByInprogress(Date reserveDate,Date startTime);


}
