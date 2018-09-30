-- Create table
create table LIS_WEB_WORK_JSQX_T
(
  S_JSID VARCHAR2(32) not null,
  S_QXID VARCHAR2(32) not null
)
tablespace LIS
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
comment on table LIS_WEB_WORK_JSQX_T
  is '角色权限表';
-- Add comments to the columns 
comment on column LIS_WEB_WORK_JSQX_T.S_JSID
  is 'juese';
comment on column LIS_WEB_WORK_JSQX_T.S_QXID
  is 'quanxian';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LIS_WEB_WORK_JSQX_T
  add constraint WEB_WORK_JSQX_T_PK1 primary key (S_JSID, S_QXID)
  using index 
  tablespace LIS
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
alter table LIS_WEB_WORK_JSQX_T
  add constraint FK_LIS_K000_REFERENCE_LIS_K1 foreign key (S_QXID)
  references LIS_WEB_INFO_QX_T (S_QXID);
alter table LIS_WEB_WORK_JSQX_T
  add constraint FK_LIS_K000_REF_LIS_JSQX_T foreign key (S_JSID)
  references LIS_INSPEC_ROLE (ID);