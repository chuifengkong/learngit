package com.springdemo.meetingreserve.manager;

import com.springdemo.meetingreserve.jpa.dao.ReserveRecordDAO;
import com.springdemo.meetingreserve.jpa.entity.BoardroomDO;
import com.springdemo.meetingreserve.jpa.entity.ReserveRecordDO;
import com.springdemo.meetingreserve.web.vo.ReserveRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecordManager {
    @Autowired
    private ReserveRecordDAO reserveRecordDAO;

    public List<ReserveRecordVO> getRecordList(String status){
        List<ReserveRecordVO> reserveRecordVOList = null;
        Date date = new Date();
        System.out.println(date);
        if("unStart".equals(status)){
            reserveRecordVOList = reserveRecordDAO.fingByDateSameTimeGreater(date,date);
            reserveRecordVOList.addAll(reserveRecordDAO.fingByDateGreater(date));
        }
        if("inPrograss".equals(status)){
            reserveRecordVOList = reserveRecordDAO.fingByInprogress(date,date);
        }
        if("over".equals(status)){
            reserveRecordVOList = reserveRecordDAO.fingByDateSameTimeGreater(date,date);
            reserveRecordVOList.addAll(reserveRecordDAO.fingByDateGreater(date));
        }

        return reserveRecordVOList;
    }
}
