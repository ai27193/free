/**
 * 
 */
package com.Freerun.ServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Freerun.Dao.IUserDao;
import com.Freerun.Entity.PageBean;
import com.Freerun.Entity.User;
import com.Freerun.Service.IUserService;

/**
 * @author wuzhiyong
 * @creation 2018年7月19日
 * @QuotationService.java
 */
@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserDao quoUserDao;
	/**
	 * 分页查询
	 */
	public PageBean<User> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		return quoUserDao.findByPage(pageCode,pageSize,criteria);
	}	
	@Override
	public void save(User t) {
		// TODO Auto-generated method stub
		quoUserDao.save(t);
	}

	/* (non-Javadoc)
	 * @see com.Donghe.Service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		quoUserDao.update(t);
	}

	/* (non-Javadoc)
	 * @see com.Donghe.Service.IBaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		quoUserDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.Donghe.Service.IBaseService#findById(java.io.Serializable)
	 */
	@Override
	public User findById(Serializable id) {
		// TODO Auto-generated method stub
		return quoUserDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.Donghe.Service.IBaseService#getAll()
	 */
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return quoUserDao.getAll();
	}
	@Override
	public List<User> login(User t) {
		// TODO Auto-generated method stub
		String hql="from User where phone=? and password=?";
		return quoUserDao.getByCondition(hql,t.getPhone(),t.getPassword());
	}
	@Override
	public List<User> getUser(String tellphone) {
		// TODO Auto-generated method stub
		String hql="from User where tellphone=? ";
		return quoUserDao.getByCondition(hql,tellphone);
	}
}
