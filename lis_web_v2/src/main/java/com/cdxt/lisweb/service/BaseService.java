package com.cdxt.lisweb.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础Service，封装简单的增删查改
 * 
 * @author lixying
 * @date 2017年4月20日 下午2:20:58
 * @since 1.0.0
 */
public interface BaseService<T> {

  public void save(T t);

  /**
   * @Title: saveAll @Description: 批量保存 @最后修改人：hezheng @最后修改时间：2017-4-24 上午11:46:48 @param t
   *         对方法的参数进行描述 @return void 返回类型 @throws
   */
  public void saveAll(List<T> list);

  public void delete(T t);

  public void deleteAll(List<T> list);

  public T queryById(Serializable id);

  /**
   * 分页查询
   * 
   * @param start
   * @param limit
   * @param query 查询条件 e.g. name : 李
   * @return {rows : [],total : 100}
   */
  public Map<String, Object> queryAllByPage(int start, int limit, Map<String, Object> query,
      String... orderBy);

  /**
   * 分页 模糊 查询
   * 
   * @param start
   * @param limit
   * @param query 查询条件 e.g. name : 李
   * @return {rows : [],total : 100}
   */
  public Map<String, Object> queryAllByPageMh(int start, int limit, Map<String, Object> query,
      String... orderBy);
  
  /**
   * 
   * @param orderBy
   * @return
   */
  public List<T> queryAll(String... orderBy);

  public void update(T t);
  
  public void merge(T t);
  
  public void saveOrUpdate(T t);

}
