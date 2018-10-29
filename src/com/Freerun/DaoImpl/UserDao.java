package com.Freerun.DaoImpl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;

import com.Freerun.Dao.IUserDao;
import com.Freerun.Entity.PageBean;
import com.Freerun.Entity.User;
//行情中的趋势
@Component
public class UserDao extends BaseDao<User> implements IUserDao{
	
	/**
	 * 分页查询
	 */
	public PageBean<User> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		// 创建分页的对象
		PageBean<User> page = new PageBean<User>();
		// 一个一个设置
		page.setPageCode(pageCode);
		page.setPageSize(pageSize);
		
		// 设置查询聚合函数：SQL已经变成了 select count(*) from 
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			int totalCount = list.get(0).intValue();
			// 总记录数
			page.setTotalCount(totalCount);
		}
		
		// 清除SQL select * from xxx
		criteria.setProjection(null);
		
		List<User> beanList = (List<User>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		// 每页显示的数据
		page.setBeanList(beanList);
		return page;
	}
}
