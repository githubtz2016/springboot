package com.ztesoft.rail.dao;

import com.ztesoft.rail.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {

    Map selelctByAdmin(@Param("adminLoginNo") String adminLoginNo, @Param("adminPwd") String adminPwd);

    User getUserByloginNo(@Param("loginNo") String loginNo);

    User selectByUserCode(@Param("appacctId") String appacctId);

	int deleteByUserId(@Param("userId") String id);
	 
    int insert(User user);
 
    int updateByUserId(User user);
 
    int updateByStatus(User user);

    int updatePasswordByUserId(User user);
    
}
