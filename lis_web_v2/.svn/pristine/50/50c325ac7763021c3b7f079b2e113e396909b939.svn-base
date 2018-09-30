-- Create table
create table LIS_WEB_BCRULE_SINGLEITEM
(
  id            VARCHAR2(32) not null,
  specimen_code VARCHAR2(32) not null,
  item_code     VARCHAR2(32),
  use_number    INTEGER,
  enable        INTEGER
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
comment on table LIS_WEB_BCRULE_SINGLEITEM
  is '标本容器';
-- Add comments to the columns 
comment on column LIS_WEB_BCRULE_SINGLEITEM.specimen_code
  is '检验类别编码';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LIS_WEB_BCRULE_SINGLEITEM
  add constraint AK_KEY_1_LIS_ITEM primary key (ID)
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
alter table LIS_WEB_BCRULE_SINGLEITEM
  add constraint FK_LIS_ITEM_REFERENCE_LIS_INSP foreign key (ITEM_CODE)
  references LIS_REQUESTION_ITEM (REQUESTION_CODE);
alter table LIS_WEB_BCRULE_SINGLEITEM
  add constraint FK_LIS_ITEM_REFERENCE_LIS_SPEC foreign key (SPECIMEN_CODE)
  references LIS_INSPEC_CONTAINER (ID);
