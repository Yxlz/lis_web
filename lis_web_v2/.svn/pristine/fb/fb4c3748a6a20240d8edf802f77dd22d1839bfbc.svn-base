-- Create table
create table LIS_WEB_MDROS_SUGGESTION
(
  id              VARCHAR2(32) not null,
  mdro_name       VARCHAR2(50) not null,
  mdro_code       VARCHAR2(20) not null,
  mdro_suggestion CLOB not null
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
-- Add comments to the columns 
comment on column LIS_WEB_MDROS_SUGGESTION.id
  is 'ID主键';
comment on column LIS_WEB_MDROS_SUGGESTION.mdro_name
  is '耐药菌名称';
comment on column LIS_WEB_MDROS_SUGGESTION.mdro_code
  is '菌种码';
comment on column LIS_WEB_MDROS_SUGGESTION.mdro_suggestion
  is '临床治疗指导意见';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LIS_WEB_MDROS_SUGGESTION
  add constraint MDROS_PK primary key (ID)
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
alter table LIS_WEB_MDROS_SUGGESTION
  add constraint MDROS_UK unique (MDRO_CODE)
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
