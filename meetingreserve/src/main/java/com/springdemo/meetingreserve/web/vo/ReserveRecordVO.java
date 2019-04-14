package com.springdemo.meetingreserve.web.vo;

import java.util.Date;

public class ReserveRecordVO {
    private Long id;
    private String userName;
    private String boardroomName;
    private Date reserveDate;
    private Date startTime;
    private Date endTime;
    private Date actualEndtime;
    private Date delayTime;

    public ReserveRecordVO(Long id, String userName, String boardroomName, Date reserveDate, Date startTime, Date endTime, Date actualEndtime, Date delayTime) {
        this.id = id;
        this.userName = userName;
        this.boardroomName = boardroomName;
        this.reserveDate = reserveDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.actualEndtime = actualEndtime;
        this.delayTime = delayTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
