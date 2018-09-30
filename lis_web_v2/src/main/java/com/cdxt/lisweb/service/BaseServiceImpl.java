package com.cdxt.lisweb.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cdxt.lisweb.dao.BaseDao;

/**
 * 基础Service，封装简单的增删查改
 * 
 * @author lixying
 * @date 2017年4月20日 下午2:21:57
 * @since 1.0.0
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public abstract BaseDao<T> getDao();

  @Override
  @Transactional
  public void save(T t) {
    getDao().save(t);
  }


  @Override
  @Transactional
  public void saveAll(List<T> list) {
    getDao().saveAll(list);
  }

  @Override
  @Transactional
  public void delete(T t) {
    logger.debug("删除对象" + t);
    getDao().delete(t);

  }

  @Override
  @Transactional
  public void deleteAll(List<T> list) {
    for (T t : list) {
      delete(t);
    }

  }

  @Override
  @Transactional(readOnly = true)
  public T queryById(Serializable id) {
    return getDao().queryById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public Map<String, Object> queryAllByPage(int start, int limit, Map<String, Object> query,
      String... orderBy) {
    if (query == null) {
      query = new HashMap<String, Object>();
    }
    return getDao().queryAllByPage(start, limit, query, orderBy);
  }
  
  @Override
  @Transactional(readOnly = true)
  public Map<String, Object> queryAllByPageMh(int start, int limit, Map<String, Object> query,
	String... orderBy) {
		if (query == null) {
			query = new HashMap<String, Object>();
		}
		return getDao().queryAllByPageMh(start, limit, query, orderBy);
	};
  
  @Override
  @Transactional(readOnly = true)
  public List<T> queryAll(String... orderBy) {
    return getDao().queryAll(orderBy);
  }

  @Override
  @Transactional
  public void update(T t) {
    getDao().update(t);
  }
  

  @Override
  @Transactional
  public void saveOrUpdate(T t) {
    getDao().saveOrUpdate(t);
  }
  
  @Override
  @Transactional
  public void merge(T t) {
    getDao().merge(t);
  }
  
  /**
   * 将对个参数转成sql总in查询的参数
   * 
   * @param params
   * @return String
   */
  protected String getBatchParams(String[] params){
	if(params==null||params.length==0){
		return "";
	}
	StringBuffer buffer = new StringBuffer();
    for (String param : params) {
    	buffer.append(param).append("','");
    }
    return buffer.substring(0, buffer.length()-3);
  }
}
