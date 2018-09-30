package com.cdxt.lisweb.dao.mdro.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.cdxt.lisweb.dao.BaseDaoImpl;
import com.cdxt.lisweb.dao.mdro.LisWebMdrosSuggestionDao;
import com.cdxt.lisweb.entity.mdro.LisWebMdrosSuggestion;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年9月11日 下午1:36:58
 * @version 1.0
 * @company :成都信通网易医疗科技发展有限公司
 * @description: //TODO
 */
@Repository
public class LisWebMdrosSuggestionDaoImpl extends
		BaseDaoImpl<LisWebMdrosSuggestion> implements LisWebMdrosSuggestionDao {

	@Override
	public Class<LisWebMdrosSuggestion> getEntityType() {
		return LisWebMdrosSuggestion.class;
	}

	@Override
	public LisWebMdrosSuggestion getLisWebMdrosSuggestionByMdroCode(
			String mdroCode) {
		String hql = "from LisWebMdrosSuggestion t where t.mdroCode=:mdroCode ";
		LisWebMdrosSuggestion mdro = null;
		Session session = openSession();
		Query query = session.createQuery(hql).setParameter("mdroCode",
				mdroCode);
		mdro = (LisWebMdrosSuggestion) query.uniqueResult();
		session.close();
		return mdro;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void saveClob(LisWebMdrosSuggestion t) {
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		try {
			con = SessionFactoryUtils.getDataSource(super.getSessionFactory()).getConnection();
			con.setAutoCommit(true);
			String INSERT = "INSERT INTO LIS_WEB_MDROS_SUGGESTION (id,MDRO_NAME,MDRO_CODE,MDRO_SUGGESTION) VALUES (?,?,?,EMPTY_CLOB())";
			ps = con.prepareStatement(INSERT);
			ps.setString(1, t.getId());
			ps.setString(2, t.getMdroName());
			ps.setString(3, t.getMdroCode());
			ps.executeUpdate();
			con.commit();
			
			String GET_COND_SQL_ORACLE = "SELECT MDRO_SUGGESTION FROM LIS_WEB_MDROS_SUGGESTION WHERE id = ? FOR UPDATE";
			ps1 = con.prepareStatement(GET_COND_SQL_ORACLE);
			ps1.setString(1, t.getId());
			rs = ps1.executeQuery();
			rs.next();
			/* 取出此CLOB对象 */  
	        oracle.sql.CLOB clob = null;  
	        clob = (oracle.sql.CLOB) rs.getClob(1);  
	        /* 向CLOB对象中写入数据 */  
	        BufferedWriter out = new BufferedWriter(clob  
	                .getCharacterOutputStream());  
	        try {   
	            out.write(t.getMdroSuggestion());  
	            out.flush();  
	            out.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();   
	            throw new SQLException(e);  
	        }  
			String UPDATE_COND_SQL_ORACLE = "update LIS_WEB_MDROS_SUGGESTION SET MDRO_SUGGESTION=?  WHERE id= ? ";
			con.setAutoCommit(true);
			ps2 = con.prepareStatement(UPDATE_COND_SQL_ORACLE);
			ps2.setClob(1, clob);
			ps2.setString(2, t.getId());
			ps2.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
			if(ps2!=null){
				try {
					ps2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps1!=null){
				try {
					ps1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateClob(LisWebMdrosSuggestion t) {
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		try {
			con = SessionFactoryUtils.getDataSource(super.getSessionFactory()).getConnection();
			con.setAutoCommit(true);
			
			String GET_COND_SQL_ORACLE = "SELECT MDRO_SUGGESTION FROM LIS_WEB_MDROS_SUGGESTION WHERE id = ? FOR UPDATE";
			ps1 = con.prepareStatement(GET_COND_SQL_ORACLE);
			ps1.setString(1, t.getId());
			rs = ps1.executeQuery();
			rs.next();
			/* 取出此CLOB对象 */  
	        oracle.sql.CLOB clob = null;  
	        clob = (oracle.sql.CLOB) rs.getClob(1);  
	        /* 向CLOB对象中写入数据 */  
	        BufferedWriter out = new BufferedWriter(clob  
	                .getCharacterOutputStream());  
	        try {   
	            out.write(t.getMdroSuggestion());  
	            out.flush();  
	            out.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();   
	            throw new SQLException(e);  
	        }  
			String UPDATE_COND_SQL_ORACLE = "update LIS_WEB_MDROS_SUGGESTION SET MDRO_SUGGESTION=? ,MDRO_NAME=?,MDRO_CODE=? WHERE id= ? ";
			con.setAutoCommit(true);
			ps2 = con.prepareStatement(UPDATE_COND_SQL_ORACLE);
			ps2.setClob(1, clob);
			ps2.setString(2, t.getMdroName());
			ps2.setString(3, t.getMdroCode());
			ps2.setString(4, t.getId());
			ps2.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
			if(ps2!=null){
				try {
					ps2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps1!=null){
				try {
					ps1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void closeAll(Connection con, PreparedStatement ps, ResultSet rs) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
