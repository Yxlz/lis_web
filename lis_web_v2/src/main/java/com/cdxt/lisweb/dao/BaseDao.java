package com.cdxt.lisweb.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.cdxt.lisweb.model.core.Page;

/**
 * 基础Dao封装
 * 
 * @author lixying
 * @date 2017年4月20日 上午9:59:48
 * @since 1.0.0
 */
public interface BaseDao<T> {

  public void save(T t);
  
  /**
  * @Title: saveAll 
  * @Description: 批量保存
  * @最后修改人：hezheng
  * @最后修改时间：2017-4-24 上午11:46:48
  * @param t 对方法的参数进行描述
  * @return void 返回类型
  * @throws
   */
  public void saveAll(List<T> list);
  
  /**
   * @discription 保存或者更新全部
   * @author hezheng       
   * @created 2017-5-16 下午5:02:54
   * @param @param list
   * @return void
   */
  public void saveOrUpdateAll(List<T> list);
  
  /**
   * @discription 保存或者更新全部
   * @author hezheng       
   * @created 2017-5-16 下午5:02:54
   * @param @param list
   * @return void
   */
  public void mergeAll(List<T> list);

  public void delete(T t);

  public T queryById(Serializable id);
  /**
   * 分页查询
   * @param start
   * @param limit
   * @param query 查询条件 e.g. name : 李
   * @return
   */
  public Map<String, Object> queryAllByPage(int start, int limit,Map<String,Object> query,String... orderBy);
  /**
   * 分页查询  模糊查询
   * @param start
   * @param limit
   * @param query 查询条件 e.g. name : 李
   * @return
   */
  public Map<String,Object> queryAllByPageMh(int start, int limit,Map<String,Object> query,String... orderBy);
  /**
   * 分页查询(模糊查询并排序)
   * 用法：
   * 模糊查询： expressions.add(Restrictions.like("属性名", "%xxx%"));
   * 等值查询：expressions.add(Restrictions.eq("属性名", "xxx"));
   * 降序：orders.add(Order.desc("属性名"));
   * 升序：orders.add(Order.asc("属性名"));
   * 
   * @param start 起始索引位置
   * @param limit  查询条数
   * @param expressions 查询条件
   * @param orders 排序信息
   * @return
   */
  public Page<T> queryForPage(int start, int limit, List<Criterion> expressions, List<Order> orders);
  
  /**
   * 分页查询(模糊查询)
   * @param start
   * @param limit
   * @param expressions 查询条件
   * @return
   */
  public Page<T> queryForPage(int start, int limit, List<Criterion> expressions);
  
  /**
   * 
   * @param orderBy
   * @return
   */
  public List<T> queryAll(String... orderBy);

  public void update(T t);
  
  public void merge(T t);
  
  public void saveOrUpdate(T t);
  
  public Session getSession();
  
  public Session openSession();

}
