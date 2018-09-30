package com.cdxt.lisweb.constants;

/**
 * 接口消息结果编码
 * 
 * @author lixying
 * @date 2017年4月25日 下午2:07:39
 * @since 1.0.0
 */
public enum ApiCode {

  SUCCESS(0, "操作成功"),
  
  SUCCESSXH(1, "操作成功"),

  ILLEGAL_ARGUMENT_EXCEPTION(1, "参数异常"),

  COMP_AUTH_FAILURE(2, "公司认证失败"),

  INVALID_USER(3, "账号或者密码错误"),

  SYSTEM_EXCEPTION(4, "系统异常"),

  DATA_ACCESS_EXCEPTION(5, "数据存储异常"),

  SIGN_ERROR(6, "签名错误"),

  JSON_ANALYSIS_EXCEPTION(7, "Json解析异常"),
  
  REFUND_ITEMS_ERROR(9,"此检验项已完成，不能申请退费"),

  DATA_ANALYSIS_EXCEPTION(20, "数据解析异常");


  private ApiCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int code;
  public String desc;

  public int getCode() {
    return code;
  }


  public String getDesc() {
    return desc;
  }

  
  public String getCodeStr(){
    return String.valueOf(code);
  }



}
