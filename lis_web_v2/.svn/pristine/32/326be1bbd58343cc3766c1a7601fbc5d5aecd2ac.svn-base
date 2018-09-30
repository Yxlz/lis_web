-- Create table
create table LIS_WEB_INFO_QX_T
(
  S_QXID     VARCHAR2(32) not null,
  S_QXMC     VARCHAR2(50),
  S_QXPY     VARCHAR2(50),
  S_QXBZ     VARCHAR2(50),
  S_NOWID    VARCHAR2(25),
  S_PARID    VARCHAR2(25),
  S_LEAF     VARCHAR2(2),
  S_SONMAXID VARCHAR2(5),
  S_URL      VARCHAR2(100),
  S_IOC      VARCHAR2(50),
  S_PX       VARCHAR2(20),
  REPORT_URL VARCHAR2(150)
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
comment on table LIS_WEB_INFO_QX_T
  is '权限表  1';
-- Add comments to the columns 
comment on column LIS_WEB_INFO_QX_T.S_QXID
  is 'quanxianid';
comment on column LIS_WEB_INFO_QX_T.S_QXMC
  is '权限名称';
comment on column LIS_WEB_INFO_QX_T.S_QXPY
  is '拼音';
comment on column LIS_WEB_INFO_QX_T.S_QXBZ
  is '权限备注';
comment on column LIS_WEB_INFO_QX_T.S_NOWID
  is '当前权限代码';
comment on column LIS_WEB_INFO_QX_T.S_PARID
  is '父权限代码';
comment on column LIS_WEB_INFO_QX_T.S_LEAF
  is '是否是叶子节点';
comment on column LIS_WEB_INFO_QX_T.S_SONMAXID
  is '最大子节点个数';
comment on column LIS_WEB_INFO_QX_T.S_IOC
  is '图标';
comment on column LIS_WEB_INFO_QX_T.S_PX
  is '排序';
-- Create/Recreate primary, unique and foreign key constraints 
alter table LIS_WEB_INFO_QX_T
  add primary key (S_QXID)
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
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee0161073e91270002', '质控项目变异系数不合格率', 'ZhiKongXiangMuBianYiXiShuBuHeGeLv', null, '215', '21', null, null, 'modules/statistics/Unqualified_rate_of_variation_coefficient_of_quality_control_project.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee0161074a25ff0004', '室内质控项目开展率', 'ShiNaZhiKongXiangMuKaiZhanLv', null, '217', '21', null, null, 'modules/statistics/Statistics_of_quality_control_project_development_rate.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee01610731c7c80001', '送检时间中位数统计', 'SongJianShiJianZhongWeiShuTongJi', null, '214', '21', null, null, 'modules/statistics/Statistics_of_inspection_time_median.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee01610755f8a10005', '检验时间中位数统计', 'JianYanShiJianZhongWeiShuTongJi', null, '218', '21', null, null, 'modules/statistics/Statistics_of_test_time_median.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee0161075980780006', '失控及纠正次数统计', 'ShiKongJiJiuZhengCiShuTongJi', null, '219', '21', null, null, 'modules/statistics/Statistics_of_out_of_control_and_rectified_times.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a5bb801626a6334710005', '检验科药敏统计', 'JianYanKeYaoMinTongJi', null, '411', '41', null, null, 'modules/naiyaojun/wardYaoMin.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=wardYaoMin.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a5bb801626a6452fe0006', '泛耐鲍曼不动药敏结果', 'FanNaiBaoManBuDongYaoMinJieGuo', null, '412', '41', null, null, 'modules/naiyaojun/baumaniiInspecResult.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=baumaniiInspecResult.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40288c8d5bcd735e015bcd74209f0000', '角色权限管理', 'ROLE_MRG', '角色管理', '11', '1', '2', null, 'modules/Role.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40288c8d5bcd735e015bcd74db060001', '用户管理', 'USER_MRG', '用户管理', '12', '1', '2', null, 'modules/User.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40288c8d5bcd735e015bcd760f390002', '菜单管理', 'MENU_MRG', '菜单管理', '13', '1', '2', null, 'modules/Right.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a5bb801626a65af1f0007', '病原排序及构成比', 'BingYuanPaiXuJiGouChengBi', null, '451', '45', null, null, 'modules/naiyaojun/etiologyQuantityAndScale.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=etiologyQuantityAndScale.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40288c8d5bcd735e015bcd7c90d60004', '医疗机构维护', 'ORG_MRG', '医疗机构维护', '14', '1', '2', null, 'modules/Hospital_maintain.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a743301626aa1366d0001', 'MRS检出率及药敏对比结果', 'MRSJianChuLvJiYaoMinDuiBiJieGuo', null, '424', '42', null, null, 'modules/naiyaojun/MRS_stat.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=MRS.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a743301626aa1923a0002', 'MRSA检出率及药敏对比结果', 'MRSAJianChuLvJiYaoMinDuiBiJieGuo', null, '425', '42', null, null, 'modules/statistics/MRSA_stat.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=MRSA.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a743301626aa219080003', 'ESBLS检出率及药敏对比结果', 'ESBLSJianChuLvJiYaoMinDuiBiJieGuo', null, '426', '42', null, null, 'modules/statistics/ESBLS_stat.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=ESBLS.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40288c8d5bd0f813015bd0fd42c00000', '系统管理', 'SYS_MGR', '系统管理', '1', '0', '2', null, '/', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878dd611b6dc401611bcdaba40001', '条码生成规则维护', 'TiaoMaShengChengGuiZeWeiHu', null, '31', '3', null, null, 'modules/maintain/BarcodeRule.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a66261896801626199538d000e', '危急值通报率', 'WeiJiZhiTongBaoLv', null, '61', '5', null, null, 'modules/qualitycontrol/Statistics_of_critical_value.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=emergencySendSucceedPercent.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162619884a8000c', '实验室内周转时间', 'ShiYanShiNaZhouZhuanShiJian', null, '59', '5', null, null, 'modules/qualitycontrol/Statistics_of_test_time_median.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=jy_midelTime.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162619900ec000d', '检验报告不正确率', 'JianYanBaoGaoBuZhengQueLv', null, '60', '5', null, null, 'modules/qualitycontrol/Statistics_of_incorrect_rate_of_inspection_report.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=errorReporterSecound.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a5bb801626a5df0650000', '检验科送检科室标本统计', 'JianYanKeSongJianKeShiBiaoBenTongJi', null, '461', '46', null, null, 'modules/naiyaojun/sendSectionBacterial_sample.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=sendSectionBacterial_sample.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a66261896801626199dc410010', '危急值通报及时率', 'WeiJiZhiTongBaoJiShiLv', null, '62', '5', null, null, 'modules/qualitycontrol/Statistics_of_critical_value.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=emergencySendSucceedPercent.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a5bb801626a5ee1230001', '微生物阳性统计', 'WeiShengWuYangXingTongJi', null, '422', '42', null, null, 'modules/naiyaojun/MicroStatByMRDType.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=MicroStatByMRDType.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('4028788c60d392d80160d39f94e40002', '统计', 'TongJi', null, '2', '0', '2', null, null, null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('4028788c60d392d80160d3a090cf0004', '危急值统计', 'WeiJiZhiTongJi', null, '211', '21', null, null, 'modules/statistics/Statistics_of_critical_value.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('4028788c60d392d80160d39ffcbc0003', '检验全过程质量指标', 'JianYanQuanGuoChengZhiLiangZhiBiao', null, '21', '2', null, null, null, null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107246a5c0000', '标本错误率统计', 'BiaoBenCuoWuLvTongJi', null, '213', '21', null, null, 'modules/statistics/Statistics_specimen_error_rate.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107433d420003', '检验科项目开展情况统计', 'JianYanKeXiangMuKaiZhanQingKuangTongJi', null, '216', '21', null, null, 'modules/statistics/Statistics_of_project_development_in_laboratory.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107cdb82e0007', '质量控制指标--本年报告总数', 'ZhiLiangKongZhiZhiBiao--BenNianBaoGaoZongShu', null, '220', '21', null, null, 'modules/statistics/QCI_all_reports_this_year.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107ce59600008', '质量控制指标--本年标本总数', 'ZhiLiangKongZhiZhiBiao--BenNianBiaoBenZongShu', null, '221', '21', null, null, 'modules/statistics/QCI_all_specimens_this_year.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107cefe480009', '本年血培养污染率', 'BenNianXuePeiYangWuRanLv', null, '222', '21', null, null, 'modules/statistics/QCI_blood_culture_pollution_this_year.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107cf8fb5000a', '质量控制指标--本年IQC EQA', 'ZhiLiangKongZhiZhiBiao--BenNianIQC EQA', null, '223', '21', null, null, 'modules/statistics/QCI_iqc_eqa_this_year.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107d0fbd2000c', '质量控制指标--本年周转时间中位数1', 'ZLKZZB--BenNianZhouZhuanShiJianZhongWeiShu1', null, '224', '21', null, null, 'modules/statistics/QCI_median_time_of_turnover_time_this_year1.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107d2891c000e', '质量控制指标--本年周转时间中位数2', 'ZLKZZB--BenNianZhouZhuanShiJianZhongWeiShu2', null, '225', '21', null, null, 'modules/statistics/QCI_median_time_of_turnover_time_this_year2.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ca61071cee016107d32014000f', '检验科接收标本统计', 'JianYanKeJieShouBiaoBenTongJi', null, '226', '21', null, null, 'modules/statistics/Statistics_of_receive_specimens_in_laboratory.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878d76140ce18016140d1ee370001', '检验项目维护', 'JianYanXiangMuWeiHu', null, '33', '3', null, null, 'modules/maintain/InspecItemMaintain.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ba6217cecf016217d09c600000', '耐药菌监测', 'NaiYaoJunJianCe', null, '4', '0', null, null, null, null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ba6217cecf016217d0f28f0001', '医院抗生素分析', 'YiYuanKangShengSuFenXi', null, '41', '4', null, null, '123', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ba6217cecf016217d12fbf0002', '医院感染监控', 'YiYuanGanRanJianKong', null, '42', '4', null, null, '234', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ba6217cecf016217d1abde0003', '实验室质量控制', 'ShiYanShiZhiLiangKongZhi', null, '43', '4', null, null, 'modules/naiyaojun/LabQualityControl.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ba6217cecf016217d21c2a0004', '全院多重耐药菌株检出情况', 'QuanYuanDuoZhongNaiYaoJunZhuJianChuQingKuang', null, '421', '42', null, null, 'modules/naiyaojun/hospitalMultResistanceStat.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=hospitalMultResistanceStat.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878ba6217cecf016217d27d7a0005', '耐药菌株流行情况统计', 'NaiYaoJunZhuLiuXingQingKuangTongJi', null, '45', '4', null, null, null, null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a743301626a8970390000', '多重耐药菌检出科室分布情况', 'DuoZhongNaiYaoJunJianChuKeShiFenBuQingKuang', null, '423', '42', null, null, 'modules/naiyaojun/MultResistancePsecionStat.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=MultResistancePsecionStat.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162618b36bb0001', '标本错误率统计', 'BiaoBenCuoWuLvTongJi', null, '51', '5', null, null, 'modules/qualitycontrol/Statistics_specimen_error_rate.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=sampleErrorPercent.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162618b7c990002', '血培养污染率', 'XuePeiYangWuRanLv', null, '52', '5', '0', null, '1', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162618c393c0004', '检验前周转时间', 'JianYanQianZhouZhuanShiJian', null, '54', '5', null, null, 'modules/qualitycontrol/Statistics_of_inspection_time_median.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=ys_midelTime.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162618cebe60005', '室内质控项目开展率统计', 'ShiNaZhiKongXiangMuKaiZhanLvTongJi', null, '55', '5', null, null, 'modules/qualitycontrol/Statistics_of_quality_control_project_development_rate.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=itemQCPercents.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162618d6dca0006', '室内质控项目变异系数不合格率', 'ShiNaZhiKongXiangMuBianYiXiShuBuHeGeLv', null, '56', '5', null, null, 'modules/qualitycontrol/Unqualified_rate_of_variation_coefficient_of_quality_control_project.html', null, null, 'http://192.168.8.101:5050/WebReport/ReportServer?reportlet=QC_BianYi.cpt');
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162618faaa0000a', '质量控制指标统计', 'ZhiLiangKongZhiZhiBiaoTongJi', null, '5', '0', null, null, null, null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162618ede7f0008', '室间质评项目不合格率', 'ShiJianZhiPingXiangMuBuHeGeLv', null, '57', '5', '0', null, '1', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878a6626189680162618f56380009', '实验室间比对率', 'ShiYanShiJianBiDuiLv', null, '58', '5', '0', null, null, null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878dd611b6dc401611bb7b0a40000', '数据维护', 'ShuJuWeiHu', null, '3', '0', null, null, '、、', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878c761070d850161070fe0550000', '检验报告不正确率统计', 'JianYanBaoGaoBuZhengQueLvTongJi', null, '212', '21', null, null, 'modules/statistics/Statistics_of_incorrect_rate_of_inspection_report.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('402878d76140ce18016140d4a3e30002', '标本容器维护', 'BiaoBenRongQiWeiHu', null, '34', '3', null, null, 'modules/maintain/ContainerMaintain.html', null, null, null);
insert into LIS_WEB_INFO_QX_T (S_QXID, S_QXMC, S_QXPY, S_QXBZ, S_NOWID, S_PARID, S_LEAF, S_SONMAXID, S_URL, S_IOC, S_PX, REPORT_URL)
values ('40287894626a580001626a59551c0000', '医院耐药机制', 'YiYuanNaiYaoJiZhi', null, '46', '4', '1', null, null, null, null, null);
commit;