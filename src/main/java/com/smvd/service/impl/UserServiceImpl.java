package com.smvd.service.impl;  
  
import java.util.List;

import javax.annotation.Resource;  
  
import org.springframework.stereotype.Service;

import com.smvd.dao.BaseDao;
import com.smvd.pojo.User;
import com.smvd.service.IUserService;
  
@Service
public class UserServiceImpl implements IUserService {
	private BaseDao baseDao;
	
	@Resource(name="baseDaoMybatisImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
    
    public List<User> getUser(User user) {  
        return this.baseDao.findAll(user, "findAll");
    }
}