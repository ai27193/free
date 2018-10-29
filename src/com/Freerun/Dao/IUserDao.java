package com.Freerun.Dao;

import org.hibernate.criterion.DetachedCriteria;

import com.Freerun.Entity.PageBean;
import com.Freerun.Entity.User;

public interface IUserDao extends IBaseDao<User> {
	public PageBean<User> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);
}
