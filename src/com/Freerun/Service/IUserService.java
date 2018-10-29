package com.Freerun.Service;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.Freerun.Entity.PageBean;
import com.Freerun.Entity.User;
public interface IUserService extends IBaseService<User>{
	List<User> getUser(String tellphone);
	PageBean<User> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
	List<User> login(User t);
}
