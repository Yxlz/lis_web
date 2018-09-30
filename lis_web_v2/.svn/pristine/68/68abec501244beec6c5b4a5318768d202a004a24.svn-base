-- Create table
create table LIS_WEB_BCRULE_ITEM
(
  id        VARCHAR2(32) not null,
  item_code VARCHAR2(32),
  manage_id VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table LIS_WEB_BCRULE_ITEM
  is '检验项目管理';
-- Add comments to the columns 
comment on column LIS_WEB_BCRULE_ITEM.id
  is '主键id';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LIS_WEB_BCRULE_ITEM
  add constraint PK_LIS_WEB_BCRULE_ITEM primary key (ID)
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
alter table LIS_WEB_BCRULE_ITEM
  add constraint FK1E2REWEW foreign key (ITEM_CODE)
  references LIS_REQUESTION_ITEM (REQUESTION_CODE);
alter table LIS_WEB_BCRULE_ITEM
  add constraint FKER4TRTET foreign key (MANAGE_ID)
  references LIS_WEB_BARCODE_RULE (ID);
