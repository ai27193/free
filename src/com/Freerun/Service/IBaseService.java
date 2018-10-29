package com.Freerun.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务层公用的业务方法
 * @author AdminTH
 *
 * @param <T>
 */
public interface IBaseService<T> {
	// 保存
	void save(T t);
	// 更新
	void update(T t);
	// 删除
	void delete(Serializable id);
	// 主键查询
	T findById(Serializable id);
	// 查询全部
	List<T> getAll();
}
