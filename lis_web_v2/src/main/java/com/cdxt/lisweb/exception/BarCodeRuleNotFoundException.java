package com.cdxt.lisweb.exception;

/**
 * 检验项目条码规则未找到
 * 
 * @author lixying
 * @date 2017年5月16日 下午5:55:45
 * @since 1.0.0
 */
public class BarCodeRuleNotFoundException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 5698478804250688256L;

  public BarCodeRuleNotFoundException(String items) {
    super(items);
  }

}
