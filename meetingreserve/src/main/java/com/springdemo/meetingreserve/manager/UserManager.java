package com.springdemo.meetingreserve.manager;

import com.springdemo.meetingreserve.config.interceptor.ThreadUtil;
import com.springdemo.meetingreserve.jpa.dao.BoardroomDAO;
import com.springdemo.meetingreserve.jpa.dao.ReserveRecordDAO;
import com.springdemo.meetingreserve.jpa.dao.UserDAO;
import com.springdemo.meetingreserve.jpa.entity.BoardroomDO;
import com.springdemo.meetingreserve.jpa.entity.ReserveRecordDO;
import com.springdemo.meetingreserve.jpa.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserManager {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BoardroomDAO boardroomDAO;
    @Autowired
    private ReserveRecordDAO reserveRecordDAO;

    /**
     * 用户登录
     * @param mobile
     * @param password
     * @return
     */
    public Boolean login(String mobile,String password){
//        System.out.println(mobile);
        UserDO userDO = userDAO.findByMobile(mobile);
        if(null == userDO){
            System.out.println("用户不存在");
            return false;
        }
        if(!userDO.getPassword().equals(password)){
            System.out.println(userDO.getPassword()+"密码不对"+password);
            return false;
        }

        //登陆成功 保存到本地线程栈
        ThreadUtil.set(userDO);
        System.out.println(ThreadUtil.get().getId());
        return true;
    }

    /**
     * 查找会议室(分页)
     * @param name
     * @return
     */
    public List<BoardroomDO> getBoardroomList(String name){
        List<BoardroomDO> boardroomDOList;
        Pageable pageable = PageRequest.of(1,1);
        if(null == name){
            boardroomDOList = boardroomDAO.findAll(pageable).getContent();
            return boardroomDOList;
        }
        boardroomDOList = boardroomDAO.findByName(name,pageable).getContent();
        return boardroomDOList;
    }

    /**
     * 查看预定详情
     * @return
     */
    public List<ReserveRecordDO> getReservationList(Long boardroomId, Date date){

        List<ReserveRecordDO> reserveRecordDOList = reserveRecordDAO.findByBoardroomIdAndReserveDate(boardroomId,date);
        return reserveRecordDOList;
    }
}
