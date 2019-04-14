package com.springdemo.meetingreserve.jpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserve_record")
public class ReserveRecordDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long boardroomId;
    private String userName;
    private String boardroomName;
    @Temporal(TemporalType.DATE)
    private Date reserveDate;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Temporal(TemporalType.TIME)
    private Date actualEndtime;
    @Temporal(TemporalType.TIME)
    private Date delayTime;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBoardroomId() {
        return boardroomId;
    }

    public void setBoardroomId(Long boardroomId) {
        this.boardroomId = boardroomId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBoardroomName() {
        return boardroomName;
    }

    public void setBoardroomName(String boardroomName) {
        this.boardroomName = boardroomName;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getActualEndtime() {
        return actualEndtime;
    }

    public void setActualEndtime(Date actualEndtime) {
        this.actualEndtime = actualEndtime;
    }

    public Date getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Date delayTime) {
        this.delayTime = delayTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
