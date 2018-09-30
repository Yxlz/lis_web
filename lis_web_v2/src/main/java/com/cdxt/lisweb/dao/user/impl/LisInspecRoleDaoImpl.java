package com.cdxt.lisweb.dao.user.impl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.user.LisInspecRoleDao;
import com.cdxt.lisweb.entity.user.LisInspecRole;
import com.cdxt.lisweb.entity.user.Right;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年1月3日 上午9:39:36
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisInspecRoleDaoImpl extends BaseDaoImpl<LisInspecRole> implements
		LisInspecRoleDao {

	@Override
	public Class<LisInspecRole> getEntityType() {
		return LisInspecRole.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Right> queryRoleRights(String rId,String parentCode) {
		Query query = getSession()
				.createSQLQuery(
						"select * from (SELECT T.S_QXID id,T.S_QXMC rightName,T.S_NOWID rightCode,T.S_PARID parentCode FROM LIS_WEB_INFO_QX_T T WHERE T.S_QXID IN (SELECT S_QXID FROM LIS_WEB_WORK_JSQX_T WHERE S_JSID = :rId)) info where info.parentCode = :parentCode")
				.addScalar("id").addScalar("rightName").addScalar("rightCode")
				.addScalar("parentCode")
				.setResultTransformer(Transformers.aliasToBean(Right.class))
				.setParameter("parentCode", parentCode)
				.setParameter("rId", rId);
		return query.list();
	}

	@Override
	public void deleteRoleRights(String roleId) {
		Query query = getSession().createSQLQuery(
				"delete from LIS_WEB_WORK_JSQX_T where S_JSID=:rId")
				.setParameter("rId", roleId);
		query.executeUpdate();
	}

	@Override
	public void saveRoleRight(String roleId, String rightId) {
		Query query = getSession()
				.createSQLQuery(
						"insert into LIS_WEB_WORK_JSQX_T values(:roleId,:rightId)")
				.setParameter("roleId", roleId)
				.setParameter("rightId", rightId);
		query.executeUpdate();
	}

	@Override
	public void deleteRoleRights(String roleId, String rightId) {
		Query query = getSession()
				.createSQLQuery(
						"DELETE FROM LIS_WEB_WORK_JSQX_T T WHERE T.S_JSID =:roleId  AND T.S_QXID =:rightId ")
				.setParameter("roleId", roleId)
				.setParameter("rightId", rightId);
		query.executeUpdate();
	}

	@Override
	public BigDecimal checkJSQXIfExist(String roleId, String rightId) {
		Query query = getSession().createSQLQuery("select count(*) from LIS_WEB_WORK_JSQX_T t where t.s_jsid=:roleId and t.s_qxid=:rightId");
		query.setParameter("roleId", roleId);
		query.setParameter("rightId", rightId);
		BigDecimal i =  (BigDecimal) query.uniqueResult();
		return i;
	}

}
