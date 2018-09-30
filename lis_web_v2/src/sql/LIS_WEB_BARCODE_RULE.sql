-- Create table
create table LIS_WEB_BARCODE_RULE
(
  id                  VARCHAR2(32) not null,
  barcode_num         INTEGER,
  priority            INTEGER not null,
  para                VARCHAR2(100),
  insepction_category VARCHAR2(100),
  prin_num            INTEGER,
  condition           VARCHAR2(100),
  rule_name           VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table LIS_WEB_BARCODE_RULE
  is '解决多项目之间的合并打印条码问题
';
-- Add comments to the columns 
comment on column LIS_WEB_BARCODE_RULE.id
  is '主键id';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LIS_WEB_BARCODE_RULE
  add constraint PK_LIS_WEB_BARCODE_RULE primary key (ID)
  using index 
  tablespace USERS
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
