-- Create table
drop table LIS_WEB_REPORT_SETTING;
create table LIS_WEB_REPORT_SETTING
(
  ID         VARCHAR2(32) not null,
  REPORT_NAME     VARCHAR2(50) not null,
  REPORT_FILE_NAME   VARCHAR2(100) not null,
  SERVER_ADDRESS   VARCHAR2(100) ,
  REPORT_URL     VARCHAR2(200)
)
tablespace CDXTLIS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table LIS_WEB_REPORT_SETTING
  is '报表设置表';

-- Create/Recreate primary, unique and foreign key constraints 
alter table LIS_WEB_REPORT_SETTING
  add constraint WEB_REPORT_SETTING_PK1 primary key (ID)
  using index 
  tablespace CDXTLIS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );