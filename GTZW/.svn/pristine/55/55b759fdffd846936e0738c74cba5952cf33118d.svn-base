package com.ztesoft.rail.service;

import com.ztesoft.rail.domain.User;
import com.ztesoft.rail.utils.ResultMsg;

public interface UserService {

    boolean checkLoginNoExist(String loginNo);

    boolean selelctByAdmin(String loginNo,String pwd);

    ResultMsg getUserByUserName(String userName,String password);

    User selectUserBy4AToken(String appAcctId,String token);

    int deleteByUserId(String userId);

    int insert(User user);

    int updateByUserId(User user);

    int updateByStatus(User user);

    int updatePasswordByUserId(User user);
}
