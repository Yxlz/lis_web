-- Create table
create table LIS_WEB_BCRULE_CONTAINER
(
  id              VARCHAR2(32) not null,
  barcode_rule_id VARCHAR2(32),
  container_code  VARCHAR2(32),
  use_number      VARCHAR2(32),
  enable          INTEGER
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
comment on table LIS_WEB_BCRULE_CONTAINER
  is '标本容器';
-- Add comments to the columns 
comment on column LIS_WEB_BCRULE_CONTAINER.barcode_rule_id
  is '检验类别编码';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LIS_WEB_BCRULE_CONTAINER
  add constraint PK_LIS_WEB_BCRULE_CONTAINER primary key (ID)
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
alter table LIS_WEB_BCRULE_CONTAINER
  add constraint FK_LIS_BARC_REFERENCE_LIS_INSP foreign key (BARCODE_RULE_ID)
  references LIS_WEB_BARCODE_RULE (ID);
alter table LIS_WEB_BCRULE_CONTAINER
  add constraint FK_LIS_BARC_REFERENCE_LIS_SPEC foreign key (CONTAINER_CODE)
  references LIS_INSPEC_CONTAINER (ID);

