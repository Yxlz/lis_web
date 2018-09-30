package com.cdxt.lisweb.common;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.druid.util.StringUtils;

/**
 * 将数据库密码解密后再设置到连接池，setting中保存的是密文
 * 
 * @author lixying
 * @date 2017年1月9日 下午4:56:10
 * @since 1.0.0
 */
public class DruidDataSourceOverPass extends DruidDataSource {

  private final static Log LOG = LogFactory.getLog(DruidDataSourceOverPass.class);

  /**
   * 
   */
  private static final long serialVersionUID = -3007790962228626397L;


  private static final String _3DES_KEY = "cdxtkey";

  /**
   * 将数据库密码解密后再设置到连接池，setting中保存的是密文
   */
  @Override
  public void setPassword(String password) {
    DesEncrypt desEncrypt = new DesEncrypt();
    desEncrypt.setKey(_3DES_KEY);
    password = desEncrypt.getDesString(password);

    if (StringUtils.equals(this.password, password)) {
      return;
    }

    if (inited) {
      LOG.info("password changed");
    }

    this.password = password;

  }



}
