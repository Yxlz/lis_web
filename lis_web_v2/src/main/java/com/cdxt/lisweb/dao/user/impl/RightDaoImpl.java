package com.cdxt.lisweb.dao.user.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.user.RightDao;
import com.cdxt.lisweb.entity.user.Right;

/**
 * @author wutianfa
 * @date 2017/5/3 14:23
 * @since 1.0.0
 */
@Repository
@SuppressWarnings("unchecked")
public class RightDaoImpl extends BaseDaoImpl<Right> implements RightDao {
	
	/**
	* @Title: getRightList
	* @Description: 根据parentId获取对应的下一级子节点信息，不会一次性读取全部的数据
	* @最后修改人：hezheng
	* @最后修改时间：2017-5-3 下午6:36:33
	* @see com.cdxt.regionlis.dao.user.RightDao#getRightList(java.lang.String)
	* @param parentId
	* @return 对方法的参数进行描述
	* @throws
	*/
	@Override
	public List<Right> getRightList(String parentId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT *");
		sql.append(" FROM (SELECT T.S_QXID as id,T.S_QXMC as rightName, T.S_QXMC as text,"); 
		sql.append("      T.S_QXPY as pinyin,T.S_QXBZ as remark,"); 
		sql.append("      T.S_NOWID as rightCode,T.S_PARID as parentCode,"); 
		sql.append("      T.S_LEAF as isLeaf,decode(T.S_LEAF,1,'true','false')");
		sql.append(" as leaf,T.S_SONMAXID as leafNum,"); 
		sql.append("      T.S_URL as url,T.S_IOC as icon,T.S_PX as sortNo,REPORT_URL as reporturl"); 
		sql.append("  FROM LIS_WEB_INFO_QX_T T"); 
		sql.append("   START WITH T.S_PARID =:parentId"); 
		sql.append(" CONNECT BY PRIOR T.S_NOWID = T.S_PARID)"); 
		sql.append("WHERE parentCode =:parentId");
		Query query = ((SQLQuery) this.getSession().createSQLQuery(sql.toString())
				.setParameter("parentId", parentId)
				.setParameter("parentId", parentId)).addScalar("id").addScalar("rightName")
				.addScalar("text").addScalar("pinyin").addScalar("remark")
				.addScalar("rightCode").addScalar("parentCode").addScalar("isLeaf").addScalar("leaf")
				.addScalar("leafNum").addScalar("url").addScalar("icon")
				.addScalar("sortNo").addScalar("reporturl").setResultTransformer(Transformers.aliasToBean(Right.class));
		return (List<Right>) query.list();
	}
	
	@Override
	public List<Right> findAllParentNode() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *");
		sql.append(" FROM (SELECT T.S_QXID as id,T.S_QXMC as rightName,");
		sql.append("      T.S_QXPY as pinyin,T.S_QXBZ as remark,");
		sql.append("      T.S_NOWID as rightCode,T.S_PARID as parentCode,");
		sql.append("      T.S_LEAF as isLeaf,T.S_SONMAXID as leafNum,");
		sql.append("      T.S_URL as url,T.S_IOC as icon,T.S_PX as sortNo");
		sql.append("  FROM LIS_WEB_INFO_QX_T T");
		sql.append(" where T.S_LEAF =:isLeaf)");

		Query query = ((SQLQuery) this.getSession().createSQLQuery(sql.toString())
				.setParameter("isLeaf", "2")).addScalar("id")
				.addScalar("rightName").addScalar("pinyin").addScalar("remark")
				.addScalar("rightCode").addScalar("parentCode").addScalar("isLeaf")
				.addScalar("leafNum").addScalar("url").addScalar("icon")
				.addScalar("sortNo").setResultTransformer(Transformers.aliasToBean(Right.class));
		return (List<Right>) query.list();
	}

	@Override
	public int findMaxRightId(String parentCode) {
		String sql = "select max(S_NOWID) as rightCode from LIS_WEB_INFO_QX_T where S_PARID =:parentCode";
		Query query = this.getSession().createSQLQuery(sql.toString()).setParameter("parentCode", parentCode);
		if(query.uniqueResult() !=null)
			return Integer.valueOf((String)query.uniqueResult());
		else {
			String rightCode = parentCode + "0";
			return Integer.valueOf(rightCode);
		}
	}

	@Override
	public List<Right> getRightByCode(String rightCode) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *");
		sql.append(" FROM (SELECT T.S_QXID as id,T.S_QXMC as rightName,");
		sql.append("      T.S_QXPY as pinyin,T.S_QXBZ as remark,");
		sql.append("      T.S_NOWID as rightCode,T.S_PARID as parentCode,");
		sql.append("      T.S_LEAF as isLeaf,T.S_SONMAXID as leafNum,");
		sql.append("      T.S_URL as url,T.S_IOC as icon,T.S_PX as sortNo,T.REPORT_URL as reporturl");
		sql.append("  FROM LIS_WEB_INFO_QX_T T");
		sql.append(" where T.S_NOWID =:rightCode)");

		Query query = ((SQLQuery) this.getSession().createSQLQuery(sql.toString())
				.setParameter("rightCode", rightCode)).addScalar("id")
				.addScalar("rightName").addScalar("pinyin").addScalar("remark")
				.addScalar("rightCode").addScalar("parentCode").addScalar("isLeaf")
				.addScalar("leafNum").addScalar("url").addScalar("icon")
				.addScalar("sortNo").addScalar("reporturl").setResultTransformer(Transformers.aliasToBean(Right.class));
		return (List<Right>) query.list();
	}

	@Override
	public List<Right> getRightList(String user, String parentId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select *");
		sql.append("  from (select *");
		sql.append("      from (SELECT a.S_QXID as id,");
		sql.append("             a.S_QXMC as rightName,");
		sql.append("             a.S_QXMC as text,");
		sql.append("             a.S_QXPY as pinyin,");
		sql.append("             a.S_QXBZ as remark,");
		sql.append("             a.S_NOWID as rightCode,");
		sql.append("             a.S_PARID as parentCode,");
		sql.append("             a.S_LEAF as isLeaf,");
		sql.append("             decode(a.S_LEAF, 1, 'true', 'false') as leaf,");
		sql.append("             a.S_SONMAXID as leafNum,");
		sql.append("             a.S_URL as url,");
		sql.append("             a.S_IOC as icon,");
		sql.append("             a.S_PX as sortNo,");
		sql.append("             a.REPORT_URL as reporturl");
		sql.append("        FROM LIS_WEB_INFO_QX_T a");
		sql.append("       inner join LIS_WEB_WORK_JSQX_T b");
		sql.append("          on a.s_qxid = b.s_qxid");
		sql.append("       inner join LIS_INSPEC_ROLE c");
		sql.append("          on c.id = b.s_jsid");
		sql.append("       inner join LIS_INSPEC_USERS d");
		sql.append("          on c.id = d.role");
		sql.append("       where d.username=:user) t");
		sql.append("     START WITH T.parentCode=:parentId");
		sql.append("    CONNECT BY PRIOR T.rightCode = T.parentCode)");

		sql.append(" WHERE parentCode=:parentId");//修改后一次性加载所有菜单
		Query query = ((SQLQuery) this.getSession().createSQLQuery(sql.toString())
				.setParameter("user", user).setParameter("parentId", parentId)
				.setParameter("parentId", parentId)).addScalar("id")
				.addScalar("rightName").addScalar("text").addScalar("pinyin")
				.addScalar("remark").addScalar("rightCode")
				.addScalar("parentCode").addScalar("isLeaf").addScalar("leaf")
				.addScalar("leafNum").addScalar("url").addScalar("icon")
				.addScalar("sortNo").addScalar("reporturl")
				.setResultTransformer(Transformers.aliasToBean(Right.class));
		return (List<Right>) query.list();
	}
	
	@Override
	public List<Right> getRightsByAccount(String account) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.S_QXID as id,");
		sql.append("         e.s_jspy as rolePinyin,"); 
		sql.append("         a.S_QXMC as rightName,"); 
		sql.append("         a.S_QXMC as text,"); 
		sql.append("         a.S_QXPY as pinyin,"); 
		sql.append("         a.S_QXBZ as remark,"); 
		sql.append("         a.S_NOWID as rightCode,"); 
		sql.append("         a.S_PARID as parentCode,"); 
		sql.append("         a.S_LEAF as isLeaf,"); 
		sql.append("         decode(a.S_LEAF, 1, 'true', 'false') as leaf,"); 
		sql.append("         a.S_SONMAXID as leafNum,"); 
		sql.append("         a.S_URL as url,"); 
		sql.append("         a.S_IOC as icon,"); 
		sql.append("         a.S_PX as sortNo"); 
		sql.append("    FROM LIS_WEB_INFO_QX_T a"); 
		sql.append("   inner join LIS_WEB_WORK_JSQX_T b"); 
		sql.append("      on a.s_qxid = b.s_qxid"); 
		sql.append("   inner join LIS_INSPEC_ROLE c"); 
		sql.append("          on c.id = b.s_jsid"); 
		sql.append("   inner join LIS_INSPEC_USERS d"); 
		sql.append("          on c.id = d.role"); 
//		sql.append("   inner join LIS_WEB_INFO_JSXX_T e"); 
//		sql.append("      on c.s_jsdm = e.s_jsid"); 
		sql.append("   where d.username =:account");
		Query query = ((SQLQuery) this.getSession().createSQLQuery(sql.toString())
				.setParameter("account", account)).addScalar("id").addScalar("rolePinyin").addScalar("rightName")
				.addScalar("text").addScalar("pinyin").addScalar("remark")
				.addScalar("rightCode").addScalar("parentCode").addScalar("isLeaf").addScalar("leaf")
				.addScalar("leafNum").addScalar("url").addScalar("icon")
				.addScalar("sortNo").setResultTransformer(Transformers.aliasToBean(Right.class));
		return (List<Right>) query.list();
	}

	@Override
	public void deleteByParentId(String rightId) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from LIS_WEB_INFO_QX_T where S_NOWID in ")
				.append("(SELECT T.S_NOWID FROM LIS_WEB_INFO_QX_T T")
				.append(" start with T.S_NOWID =:rightId connect by prior T.S_NOWID = T.S_PARID)");
		Query query = this.getSession().createSQLQuery(sql.toString()).setParameter("rightId", rightId);
		query.executeUpdate();
	}

	@Override
	public Class<Right> getEntityType() {
		return Right.class;
	}

	@Override
	public List<Right> findLeafNodeByRoleid(String roleid) {
		StringBuffer sb = new StringBuffer();
		sb.append("select a.s_qxid as id from lis_web_info_qx_t a,  lis_web_work_jsqx_t b ");
		sb.append("where a.s_qxid = b.s_qxid ");
		sb.append(" and b.s_jsid = :roleid and a.s_leaf = '0'");
		Query q = this.getSession().createSQLQuery(sb.toString()).addScalar("id")
				.setParameter("roleid", roleid)
				.setResultTransformer(Transformers.aliasToBean(Right.class));
		List<Right> l = q.list();
		return l;
	}
}
