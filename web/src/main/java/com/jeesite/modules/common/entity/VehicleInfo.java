/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import com.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * 车辆配置全表Entity
 * @author chenlitao
 * @version 2019-07-04
 */
@Table(name="common_vehicle_info", alias="a", columns={
		@Column(name="id", attrName="id", label="主键，车辆配置全表", isPK=true),
		@Column(name="shouzimu", attrName="shouzimu", label="shouzimu"),
		@Column(name="pinpai", attrName="pinpai", label="pinpai", queryType=QueryType.LIKE),
		@Column(name="pinpai_id", attrName="pinpaiId", label="pinpai_id"),
		@Column(name="pinpai_logo", attrName="pinpaiLogo", label="pinpai_logo"),
		@Column(name="chexi", attrName="chexi", label="chexi"),
		@Column(name="chexi_id", attrName="chexiId", label="chexi_id"),
		@Column(name="chexizhanshitu", attrName="chexizhanshitu", label="chexizhanshitu"),
		@Column(name="chexingmingcheng", attrName="chexingmingcheng", label="chexingmingcheng", queryType=QueryType.LIKE),
		@Column(name="chexing_id", attrName="chexingId", label="chexing_id"),
		@Column(name="xiaoshouzhuangtai", attrName="xiaoshouzhuangtai", label="xiaoshouzhuangtai"),
		@Column(name="changshang", attrName="changshang", label="changshang"),
		@Column(name="changshang_id", attrName="changshangId", label="changshang_id"),
		@Column(name="niankuan", attrName="niankuan", label="niankuan"),
		@Column(name="gengxinshijian", attrName="gengxinshijian", label="gengxinshijian"),
		@Column(name="shangshishijian", attrName="shangshishijian", label="shangshishijian"),
		@Column(name="changshangzhidaojia", attrName="changshangzhidaojia", label="changshangzhidaojia"),
		@Column(name="changshangzhidaojia_yuan", attrName="changshangzhidaojiaYuan", label="changshangzhidaojia_yuan"),
		@Column(name="jibie", attrName="jibie", label="jibie"),
		@Column(name="nengyuanleixing", attrName="nengyuanleixing", label="nengyuanleixing"),
		@Column(name="gongxinbuchundianxuhanglicheng_km", attrName="gongxinbuchundianxuhanglichengKm", label="gongxinbuchundianxuhanglicheng_km"),
		@Column(name="kuaichongshijian_xiaoshi", attrName="kuaichongshijianXiaoshi", label="kuaichongshijian_xiaoshi"),
		@Column(name="manchongshijian_xiaoshi", attrName="manchongshijianXiaoshi", label="manchongshijian_xiaoshi"),
		@Column(name="kuaichongdianliangbaifenbi", attrName="kuaichongdianliangbaifenbi", label="kuaichongdianliangbaifenbi"),
		@Column(name="zuidagonglv_kw", attrName="zuidagonglvKw", label="zuidagonglv_kw"),
		@Column(name="zuidaniuju_n_m", attrName="zuidaniujuNM", label="zuidaniuju_n_m"),
		@Column(name="fadongji", attrName="fadongji", label="fadongji"),
		@Column(name="biansuxiang", attrName="biansuxiang", label="biansuxiang"),
		@Column(name="changkuangao_mm", attrName="changkuangaoMm", label="changkuangao_mm"),
		@Column(name="cheshenjiegou", attrName="cheshenjiegou", label="cheshenjiegou"),
		@Column(name="zuigaochesu_km_h", attrName="zuigaochesuKmH", label="zuigaochesu_km_h"),
		@Column(name="guanfang0_100km_h_jiasu_s", attrName="guanfang0100kmHJiasuS", label="guanfang0_100km_h_jiasu_s"),
		@Column(name="shice0_100km_h_jiasu_s", attrName="shice0100kmHJiasuS", label="shice0_100km_h_jiasu_s"),
		@Column(name="shice100_0km_h_zhidong_m", attrName="shice1000kmHZhidongM", label="shice100_0km_h_zhidong_m"),
		@Column(name="shicexuhanglicheng_km", attrName="shicexuhanglichengKm", label="shicexuhanglicheng_km"),
		@Column(name="gongxinbuzongheyouhao_l_100km", attrName="gongxinbuzongheyouhaoL100km", label="gongxinbuzongheyouhao_l_100km"),
		@Column(name="shiceyouhao_l_100km", attrName="shiceyouhaoL100km", label="shiceyouhao_l_100km"),
		@Column(name="zhengchezhibao", attrName="zhengchezhibao", label="zhengchezhibao"),
		@Column(name="changdu_mm", attrName="changduMm", label="changdu_mm"),
		@Column(name="kuandu_mm", attrName="kuanduMm", label="kuandu_mm"),
		@Column(name="gaodu_mm", attrName="gaoduMm", label="gaodu_mm"),
		@Column(name="zhouju_mm", attrName="zhoujuMm", label="zhouju_mm"),
		@Column(name="qianlunju_mm", attrName="qianlunjuMm", label="qianlunju_mm"),
		@Column(name="houlunju_mm", attrName="houlunjuMm", label="houlunju_mm"),
		@Column(name="zuixiaolidijianxi_mm", attrName="zuixiaolidijianxiMm", label="zuixiaolidijianxi_mm"),
		@Column(name="chemenshu_ge", attrName="chemenshuGe", label="chemenshu_ge"),
		@Column(name="zuoweishu_ge", attrName="zuoweishuGe", label="zuoweishu_ge"),
		@Column(name="youxiangrongji_l", attrName="youxiangrongjiL", label="youxiangrongji_l"),
		@Column(name="xinglixiangrongji_l", attrName="xinglixiangrongjiL", label="xinglixiangrongji_l"),
		@Column(name="zhengbeizhiliang_kg", attrName="zhengbeizhiliangKg", label="zhengbeizhiliang_kg"),
		@Column(name="fadongjixinghao", attrName="fadongjixinghao", label="fadongjixinghao"),
		@Column(name="pailiang_ml", attrName="pailiangMl", label="pailiang_ml"),
		@Column(name="pailiang_l", attrName="pailiangL", label="pailiang_l"),
		@Column(name="jinqixingshi", attrName="jinqixingshi", label="jinqixingshi"),
		@Column(name="qigangpailiexingshi", attrName="qigangpailiexingshi", label="qigangpailiexingshi"),
		@Column(name="qigangshu_ge", attrName="qigangshuGe", label="qigangshu_ge"),
		@Column(name="meigangqimenshu_ge", attrName="meigangqimenshuGe", label="meigangqimenshu_ge"),
		@Column(name="yasuobi", attrName="yasuobi", label="yasuobi"),
		@Column(name="peiqijigou", attrName="peiqijigou", label="peiqijigou"),
		@Column(name="gangjing_mm", attrName="gangjingMm", label="gangjing_mm"),
		@Column(name="xingcheng_mm", attrName="xingchengMm", label="xingcheng_mm"),
		@Column(name="zuidamali_ps", attrName="zuidamaliPs", label="zuidamali_ps"),
		@Column(name="zuidagonglvzhuansu_rpm", attrName="zuidagonglvzhuansuRpm", label="zuidagonglvzhuansu_rpm"),
		@Column(name="zuidaniujuzhuansu_rpm", attrName="zuidaniujuzhuansuRpm", label="zuidaniujuzhuansu_rpm"),
		@Column(name="fadongjiteyoujishu", attrName="fadongjiteyoujishu", label="fadongjiteyoujishu"),
		@Column(name="ranliaoxingshi", attrName="ranliaoxingshi", label="ranliaoxingshi"),
		@Column(name="ranyoubiaohao", attrName="ranyoubiaohao", label="ranyoubiaohao"),
		@Column(name="gongyoufangshi", attrName="gongyoufangshi", label="gongyoufangshi"),
		@Column(name="ganggaicailiao", attrName="ganggaicailiao", label="ganggaicailiao"),
		@Column(name="gangticailiao", attrName="gangticailiao", label="gangticailiao"),
		@Column(name="huanbaobiaozhun", attrName="huanbaobiaozhun", label="huanbaobiaozhun"),
		@Column(name="dianjileixing", attrName="dianjileixing", label="dianjileixing"),
		@Column(name="diandongjizonggonglv_kw", attrName="diandongjizonggonglvKw", label="diandongjizonggonglv_kw"),
		@Column(name="diandongjizongniuju_n_m", attrName="diandongjizongniujuNM", label="diandongjizongniuju_n_m"),
		@Column(name="qiandiandongjizuidagonglv_kw", attrName="qiandiandongjizuidagonglvKw", label="qiandiandongjizuidagonglv_kw"),
		@Column(name="qiandiandongjizuidaniuju_n_m", attrName="qiandiandongjizuidaniujuNM", label="qiandiandongjizuidaniuju_n_m"),
		@Column(name="houdiandongjizuidagonglv_kw", attrName="houdiandongjizuidagonglvKw", label="houdiandongjizuidagonglv_kw"),
		@Column(name="houdiandongjizuidaniuju_n_m", attrName="houdiandongjizuidaniujuNM", label="houdiandongjizuidaniuju_n_m"),
		@Column(name="xitongzonghegonglv_kw", attrName="xitongzonghegonglvKw", label="xitongzonghegonglv_kw"),
		@Column(name="xitongzongheniuju_n_m", attrName="xitongzongheniujuNM", label="xitongzongheniuju_n_m"),
		@Column(name="qudongdianjishu", attrName="qudongdianjishu", label="qudongdianjishu"),
		@Column(name="dianjibuju", attrName="dianjibuju", label="dianjibuju"),
		@Column(name="dianchileixing", attrName="dianchileixing", label="dianchileixing"),
		@Column(name="dianchirongliang_kwh", attrName="dianchirongliangKwh", label="dianchirongliang_kwh"),
		@Column(name="baigonglihaodianliang_kwh_100km", attrName="baigonglihaodianliangKwh100km", label="baigonglihaodianliang_kwh_100km"),
		@Column(name="dianchizuzhibao", attrName="dianchizuzhibao", label="dianchizuzhibao"),
		@Column(name="kuaichongdianliang", attrName="kuaichongdianliang", label="kuaichongdianliang"),
		@Column(name="dangweigeshu", attrName="dangweigeshu", label="dangweigeshu"),
		@Column(name="biansuxiangleixing", attrName="biansuxiangleixing", label="biansuxiangleixing"),
		@Column(name="jiancheng", attrName="jiancheng", label="jiancheng"),
		@Column(name="qudongfangshi", attrName="qudongfangshi", label="qudongfangshi"),
		@Column(name="qianxuanjialeixing", attrName="qianxuanjialeixing", label="qianxuanjialeixing"),
		@Column(name="houxuanjialeixing", attrName="houxuanjialeixing", label="houxuanjialeixing"),
		@Column(name="zhulileixing", attrName="zhulileixing", label="zhulileixing"),
		@Column(name="chetijiegou", attrName="chetijiegou", label="chetijiegou"),
		@Column(name="qianzhidongqileixing", attrName="qianzhidongqileixing", label="qianzhidongqileixing"),
		@Column(name="houzhidongqileixing", attrName="houzhidongqileixing", label="houzhidongqileixing"),
		@Column(name="zhuchezhidongleixing", attrName="zhuchezhidongleixing", label="zhuchezhidongleixing"),
		@Column(name="qianluntaiguige", attrName="qianluntaiguige", label="qianluntaiguige"),
		@Column(name="houluntaiguige", attrName="houluntaiguige", label="houluntaiguige"),
		@Column(name="beitaiguige", attrName="beitaiguige", label="beitaiguige"),
		@Column(name="zhu_fujiashizuoanquanqinang", attrName="zhuFujiashizuoanquanqinang", label="zhu_fujiashizuoanquanqinang"),
		@Column(name="qian_houpaiceqinang", attrName="qianHoupaiceqinang", label="qian_houpaiceqinang"),
		@Column(name="qian_houpaitoubuqinang_qilian", attrName="qianHoupaitoubuqinangQilian", label="qian_houpaitoubuqinang_qilian"),
		@Column(name="xibuqinang", attrName="xibuqinang", label="xibuqinang"),
		@Column(name="houpaianquandaishiqinang", attrName="houpaianquandaishiqinang", label="houpaianquandaishiqinang"),
		@Column(name="houpaizhongyanganquanqinang", attrName="houpaizhongyanganquanqinang", label="houpaizhongyanganquanqinang"),
		@Column(name="beidongxingrenbaohu", attrName="beidongxingrenbaohu", label="beidongxingrenbaohu"),
		@Column(name="taiyajiancegongneng", attrName="taiyajiancegongneng", label="taiyajiancegongneng"),
		@Column(name="lingtaiyajixuxingshi", attrName="lingtaiyajixuxingshi", label="lingtaiyajixuxingshi"),
		@Column(name="anquandaiweixitixing", attrName="anquandaiweixitixing", label="anquandaiweixitixing"),
		@Column(name="isofixertongzuoyijiekou", attrName="isofixertongzuoyijiekou", label="isofixertongzuoyijiekou"),
		@Column(name="absfangbaosi", attrName="absfangbaosi", label="absfangbaosi"),
		@Column(name="zhidonglifenpei_ebd_cbcdeng", attrName="zhidonglifenpeiEbdCbcdeng", label="zhidonglifenpei_ebd_cbcdeng"),
		@Column(name="shachefuzhu_eba_bas_badeng", attrName="shachefuzhuEbaBasBadeng", label="shachefuzhu_eba_bas_badeng"),
		@Column(name="qianyinlikongzhi_asr_tcs_trcdeng", attrName="qianyinlikongzhiAsrTcsTrcdeng", label="qianyinlikongzhi_asr_tcs_trcdeng"),
		@Column(name="cheshenwendingkongzhi_esc_esp_dscdeng", attrName="cheshenwendingkongzhiEscEspDscdeng", label="cheshenwendingkongzhi_esc_esp_dscdeng"),
		@Column(name="bingxianfuzhu", attrName="bingxianfuzhu", label="bingxianfuzhu"),
		@Column(name="chedaopianliyujingxitong", attrName="chedaopianliyujingxitong", label="chedaopianliyujingxitong"),
		@Column(name="chedaobaochifuzhuxitong", attrName="chedaobaochifuzhuxitong", label="chedaobaochifuzhuxitong"),
		@Column(name="daolujiaotongbiaozhishibie", attrName="daolujiaotongbiaozhishibie", label="daolujiaotongbiaozhishibie"),
		@Column(name="zhudongshache_zhudonganquanxitong", attrName="zhudongshacheZhudonganquanxitong", label="zhudongshache_zhudonganquanxitong"),
		@Column(name="yeshixitong", attrName="yeshixitong", label="yeshixitong"),
		@Column(name="pilaojiashitishi", attrName="pilaojiashitishi", label="pilaojiashitishi"),
		@Column(name="qian_houzhucheleida", attrName="qianHouzhucheleida", label="qian_houzhucheleida"),
		@Column(name="jiashifuzhuyingxiang", attrName="jiashifuzhuyingxiang", label="jiashifuzhuyingxiang"),
		@Column(name="daochecheceyujingxitong", attrName="daochecheceyujingxitong", label="daochecheceyujingxitong"),
		@Column(name="xunhangxitong", attrName="xunhangxitong", label="xunhangxitong"),
		@Column(name="jiashimoshiqiehuan", attrName="jiashimoshiqiehuan", label="jiashimoshiqiehuan"),
		@Column(name="zidongbocheruwei", attrName="zidongbocheruwei", label="zidongbocheruwei"),
		@Column(name="fadongjiqitingjishu", attrName="fadongjiqitingjishu", label="fadongjiqitingjishu"),
		@Column(name="zidongzhuche", attrName="zidongzhuche", label="zidongzhuche"),
		@Column(name="shangpofuzhu", attrName="shangpofuzhu", label="shangpofuzhu"),
		@Column(name="doupohuanjiang", attrName="doupohuanjiang", label="doupohuanjiang"),
		@Column(name="kebianxuanjiagongneng", attrName="kebianxuanjiagongneng", label="kebianxuanjiagongneng"),
		@Column(name="kongqixuanjia", attrName="kongqixuanjia", label="kongqixuanjia"),
		@Column(name="dianciganyingxuanjia", attrName="dianciganyingxuanjia", label="dianciganyingxuanjia"),
		@Column(name="kebianzhuanxiangbi", attrName="kebianzhuanxiangbi", label="kebianzhuanxiangbi"),
		@Column(name="zhongyangchasuqisuozhigongneng", attrName="zhongyangchasuqisuozhigongneng", label="zhongyangchasuqisuozhigongneng"),
		@Column(name="zhengtizhudongzhuanxiangxitong", attrName="zhengtizhudongzhuanxiangxitong", label="zhengtizhudongzhuanxiangxitong"),
		@Column(name="xianhuachasuqi_chasusuo", attrName="xianhuachasuqiChasusuo", label="xianhuachasuqi_chasusuo"),
		@Column(name="sheshuiganyingxitong", attrName="sheshuiganyingxitong", label="sheshuiganyingxitong"),
		@Column(name="tianchuangleixing", attrName="tianchuangleixing", label="tianchuangleixing"),
		@Column(name="yundongwaiguantaojian", attrName="yundongwaiguantaojian", label="yundongwaiguantaojian"),
		@Column(name="lunquancaizhi", attrName="lunquancaizhi", label="lunquancaizhi"),
		@Column(name="diandongxihechemen", attrName="diandongxihechemen", label="diandongxihechemen"),
		@Column(name="cehuamenxingshi", attrName="cehuamenxingshi", label="cehuamenxingshi"),
		@Column(name="diandonghoubeixiang", attrName="diandonghoubeixiang", label="diandonghoubeixiang"),
		@Column(name="ganyinghoubeixiang", attrName="ganyinghoubeixiang", label="ganyinghoubeixiang"),
		@Column(name="diandonghoubeixiangweizhijiyi", attrName="diandonghoubeixiangweizhijiyi", label="diandonghoubeixiangweizhijiyi"),
		@Column(name="weimenbolidulikaiqi", attrName="weimenbolidulikaiqi", label="weimenbolidulikaiqi"),
		@Column(name="chedingxinglijia", attrName="chedingxinglijia", label="chedingxinglijia"),
		@Column(name="fadongjidianzifangdao", attrName="fadongjidianzifangdao", label="fadongjidianzifangdao"),
		@Column(name="cheneizhongkongsuo", attrName="cheneizhongkongsuo", label="cheneizhongkongsuo"),
		@Column(name="yaoshileixing", attrName="yaoshileixing", label="yaoshileixing"),
		@Column(name="wuyaoshiqidongxitong", attrName="wuyaoshiqidongxitong", label="wuyaoshiqidongxitong"),
		@Column(name="wuyaoshijinrugongneng", attrName="wuyaoshijinrugongneng", label="wuyaoshijinrugongneng"),
		@Column(name="zhudongbiheshijinqigezha", attrName="zhudongbiheshijinqigezha", label="zhudongbiheshijinqigezha"),
		@Column(name="yuanchengqidonggongneng", attrName="yuanchengqidonggongneng", label="yuanchengqidonggongneng"),
		@Column(name="checejiaotaban", attrName="checejiaotaban", label="checejiaotaban"),
		@Column(name="fangxiangpancaizhi", attrName="fangxiangpancaizhi", label="fangxiangpancaizhi"),
		@Column(name="fangxiangpanweizhitiaojie", attrName="fangxiangpanweizhitiaojie", label="fangxiangpanweizhitiaojie"),
		@Column(name="duogongnengfangxiangpan", attrName="duogongnengfangxiangpan", label="duogongnengfangxiangpan"),
		@Column(name="fangxiangpanhuandang", attrName="fangxiangpanhuandang", label="fangxiangpanhuandang"),
		@Column(name="fangxiangpanjiare", attrName="fangxiangpanjiare", label="fangxiangpanjiare"),
		@Column(name="fangxiangpanjiyi", attrName="fangxiangpanjiyi", label="fangxiangpanjiyi"),
		@Column(name="xingchediannaoxianshipingmu", attrName="xingchediannaoxianshipingmu", label="xingchediannaoxianshipingmu"),
		@Column(name="quanyejingyibiaopan", attrName="quanyejingyibiaopan", label="quanyejingyibiaopan"),
		@Column(name="yejingyibiaochicun", attrName="yejingyibiaochicun", label="yejingyibiaochicun"),
		@Column(name="hudtaitoushuzixianshi", attrName="hudtaitoushuzixianshi", label="hudtaitoushuzixianshi"),
		@Column(name="neizhixingchejiluyi", attrName="neizhixingchejiluyi", label="neizhixingchejiluyi"),
		@Column(name="zhudongjiangzao", attrName="zhudongjiangzao", label="zhudongjiangzao"),
		@Column(name="shoujiwuxianchongdiangongneng", attrName="shoujiwuxianchongdiangongneng", label="shoujiwuxianchongdiangongneng"),
		@Column(name="diandongketiaotaban", attrName="diandongketiaotaban", label="diandongketiaotaban"),
		@Column(name="zuoyicaizhi", attrName="zuoyicaizhi", label="zuoyicaizhi"),
		@Column(name="yundongfenggezuoyi", attrName="yundongfenggezuoyi", label="yundongfenggezuoyi"),
		@Column(name="zhuzuoyitiaojiefangshi", attrName="zhuzuoyitiaojiefangshi", label="zhuzuoyitiaojiefangshi"),
		@Column(name="fuzuoyitiaojiefangshi", attrName="fuzuoyitiaojiefangshi", label="fuzuoyitiaojiefangshi"),
		@Column(name="zhu_fujiashizuodiandongtiaojie", attrName="zhuFujiashizuodiandongtiaojie", label="zhu_fujiashizuodiandongtiaojie"),
		@Column(name="qianpaizuoyigongneng", attrName="qianpaizuoyigongneng", label="qianpaizuoyigongneng"),
		@Column(name="diandongzuoyijiyigongneng", attrName="diandongzuoyijiyigongneng", label="diandongzuoyijiyigongneng"),
		@Column(name="fujiashiweihoupaiketiaojieanniu", attrName="fujiashiweihoupaiketiaojieanniu", label="fujiashiweihoupaiketiaojieanniu"),
		@Column(name="dierpaizuoyitiaojie", attrName="dierpaizuoyitiaojie", label="dierpaizuoyitiaojie"),
		@Column(name="houpaizuoyidiandongtiaojie", attrName="houpaizuoyidiandongtiaojie", label="houpaizuoyidiandongtiaojie"),
		@Column(name="houpaizuoyigongneng", attrName="houpaizuoyigongneng", label="houpaizuoyigongneng"),
		@Column(name="houpaixiaozhuoban", attrName="houpaixiaozhuoban", label="houpaixiaozhuoban"),
		@Column(name="dierpaidulizuoyi", attrName="dierpaidulizuoyi", label="dierpaidulizuoyi"),
		@Column(name="zuoyibuju", attrName="zuoyibuju", label="zuoyibuju"),
		@Column(name="houpaizuoyifangdaoxingshi", attrName="houpaizuoyifangdaoxingshi", label="houpaizuoyifangdaoxingshi"),
		@Column(name="houpaizuoyidiandongfangdao", attrName="houpaizuoyidiandongfangdao", label="houpaizuoyidiandongfangdao"),
		@Column(name="qian_houzhongyangfushou", attrName="qianHouzhongyangfushou", label="qian_houzhongyangfushou"),
		@Column(name="houpaibeijia", attrName="houpaibeijia", label="houpaibeijia"),
		@Column(name="jiare_zhilengbeijia", attrName="jiareZhilengbeijia", label="jiare_zhilengbeijia"),
		@Column(name="zhongkongcaiseyejingpingmu", attrName="zhongkongcaiseyejingpingmu", label="zhongkongcaiseyejingpingmu"),
		@Column(name="zhongkongyejingpingchicun", attrName="zhongkongyejingpingchicun", label="zhongkongyejingpingchicun"),
		@Column(name="gpsdaohangxitong", attrName="gpsdaohangxitong", label="gpsdaohangxitong"),
		@Column(name="daohanglukuangxinxixianshi", attrName="daohanglukuangxinxixianshi", label="daohanglukuangxinxixianshi"),
		@Column(name="daolujiuyuanhujiao", attrName="daolujiuyuanhujiao", label="daolujiuyuanhujiao"),
		@Column(name="zhongkongyejingpingfenpingxianshi", attrName="zhongkongyejingpingfenpingxianshi", label="zhongkongyejingpingfenpingxianshi"),
		@Column(name="lanya_chezaidianhua", attrName="lanyaChezaidianhua", label="lanya_chezaidianhua"),
		@Column(name="shoujihulian_yingshe", attrName="shoujihulianYingshe", label="shoujihulian_yingshe"),
		@Column(name="yuyinshibiekongzhixitong", attrName="yuyinshibiekongzhixitong", label="yuyinshibiekongzhixitong"),
		@Column(name="shoushikongzhi", attrName="shoushikongzhi", label="shoushikongzhi"),
		@Column(name="chelianwang", attrName="chelianwang", label="chelianwang"),
		@Column(name="chezaidianshi", attrName="chezaidianshi", label="chezaidianshi"),
		@Column(name="houpaiyejingpingmu", attrName="houpaiyejingpingmu", label="houpaiyejingpingmu"),
		@Column(name="houpaikongzhiduomeiti", attrName="houpaikongzhiduomeiti", label="houpaikongzhiduomeiti"),
		@Column(name="waijieyinyuanjiekouleixing", attrName="waijieyinyuanjiekouleixing", label="waijieyinyuanjiekouleixing"),
		@Column(name="usb_type_cjiekoushuliang", attrName="usbTypeCjiekoushuliang", label="usb_type_cjiekoushuliang"),
		@Column(name="chezaicd_dvd", attrName="chezaicdDvd", label="chezaicd_dvd"),
		@Column(name="dianyuan_220v_230v", attrName="dianyuan220v230v", label="dianyuan_220v_230v"),
		@Column(name="xinglixiang12vdianyuanjiekou", attrName="xinglixiang12vdianyuanjiekou", label="xinglixiang12vdianyuanjiekou"),
		@Column(name="yangshengqipinpaimingcheng", attrName="yangshengqipinpaimingcheng", label="yangshengqipinpaimingcheng"),
		@Column(name="yangshengqishuliang", attrName="yangshengqishuliang", label="yangshengqishuliang"),
		@Column(name="jinguangdengguangyuan", attrName="jinguangdengguangyuan", label="jinguangdengguangyuan"),
		@Column(name="yuanguangdengguangyuan", attrName="yuanguangdengguangyuan", label="yuanguangdengguangyuan"),
		@Column(name="dengguangtesegongneng", attrName="dengguangtesegongneng", label="dengguangtesegongneng"),
		@Column(name="ledrijianxingchedeng", attrName="ledrijianxingchedeng", label="ledrijianxingchedeng"),
		@Column(name="zishiyingyuanjinguang", attrName="zishiyingyuanjinguang", label="zishiyingyuanjinguang"),
		@Column(name="zidongtoudeng", attrName="zidongtoudeng", label="zidongtoudeng"),
		@Column(name="zhuanxiangfuzhudeng", attrName="zhuanxiangfuzhudeng", label="zhuanxiangfuzhudeng"),
		@Column(name="zhuanxiangtoudeng", attrName="zhuanxiangtoudeng", label="zhuanxiangtoudeng"),
		@Column(name="cheqianwudeng", attrName="cheqianwudeng", label="cheqianwudeng"),
		@Column(name="qiandadengyuwumoshi", attrName="qiandadengyuwumoshi", label="qiandadengyuwumoshi"),
		@Column(name="dadenggaoduketiao", attrName="dadenggaoduketiao", label="dadenggaoduketiao"),
		@Column(name="dadengqingxizhuangzhi", attrName="dadengqingxizhuangzhi", label="dadengqingxizhuangzhi"),
		@Column(name="dadengyanshiguanbi", attrName="dadengyanshiguanbi", label="dadengyanshiguanbi"),
		@Column(name="chumoshiyuedudeng", attrName="chumoshiyuedudeng", label="chumoshiyuedudeng"),
		@Column(name="cheneihuanjingfenweideng", attrName="cheneihuanjingfenweideng", label="cheneihuanjingfenweideng"),
		@Column(name="qian_houdiandongchechuang", attrName="qianHoudiandongchechuang", label="qian_houdiandongchechuang"),
		@Column(name="chechuangyijianshengjianggongneng", attrName="chechuangyijianshengjianggongneng", label="chechuangyijianshengjianggongneng"),
		@Column(name="chechuangfangjiashougongneng", attrName="chechuangfangjiashougongneng", label="chechuangfangjiashougongneng"),
		@Column(name="fangziwaixianboli", attrName="fangziwaixianboli", label="fangziwaixianboli"),
		@Column(name="duocenggeyinboli", attrName="duocenggeyinboli", label="duocenggeyinboli"),
		@Column(name="waihoushijinggongneng", attrName="waihoushijinggongneng", label="waihoushijinggongneng"),
		@Column(name="neihoushijinggongneng", attrName="neihoushijinggongneng", label="neihoushijinggongneng"),
		@Column(name="houfengdangzheyanglian", attrName="houfengdangzheyanglian", label="houfengdangzheyanglian"),
		@Column(name="houpaicechuangzheyanglian", attrName="houpaicechuangzheyanglian", label="houpaicechuangzheyanglian"),
		@Column(name="houpaiceyinsiboli", attrName="houpaiceyinsiboli", label="houpaiceyinsiboli"),
		@Column(name="cheneihuazhuangjing", attrName="cheneihuazhuangjing", label="cheneihuazhuangjing"),
		@Column(name="houyushua", attrName="houyushua", label="houyushua"),
		@Column(name="ganyingyushuagongneng", attrName="ganyingyushuagongneng", label="ganyingyushuagongneng"),
		@Column(name="kejiarepenshuizui", attrName="kejiarepenshuizui", label="kejiarepenshuizui"),
		@Column(name="kongtiaowendukongzhifangshi", attrName="kongtiaowendukongzhifangshi", label="kongtiaowendukongzhifangshi"),
		@Column(name="houpaidulikongtiao", attrName="houpaidulikongtiao", label="houpaidulikongtiao"),
		@Column(name="houzuochufengkou", attrName="houzuochufengkou", label="houzuochufengkou"),
		@Column(name="wendufenqukongzhi", attrName="wendufenqukongzhi", label="wendufenqukongzhi"),
		@Column(name="chezaikongqijinghuaqi", attrName="chezaikongqijinghuaqi", label="chezaikongqijinghuaqi"),
		@Column(name="cheneipm2_5guolvzhuangzhi", attrName="cheneipm25guolvzhuangzhi", label="cheneipm2_5guolvzhuangzhi"),
		@Column(name="fulizifashengqi", attrName="fulizifashengqi", label="fulizifashengqi"),
		@Column(name="cheneixiangfenzhuangzhi", attrName="cheneixiangfenzhuangzhi", label="cheneixiangfenzhuangzhi"),
		@Column(name="chezaibingxiang", attrName="chezaibingxiang", label="chezaibingxiang"),
		@Column(name="xuanzhuangbao", attrName="xuanzhuangbao", label="xuanzhuangbao"),
		@Column(name="waiguanyanse", attrName="waiguanyanse", label="waiguanyanse"),
		@Column(name="neishiyanse", attrName="neishiyanse", label="neishiyanse"),
		@Column(name="upload_date", attrName="uploadDate", label="uploadDate"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class VehicleInfo extends PreEntity<VehicleInfo> {
	
	private static final long serialVersionUID = 1L;
	private String shouzimu;		// shouzimu
	private String pinpai;		// pinpai
	private String pinpaiId;		// pinpai_id
	private String pinpaiLogo;		// pinpai_logo
	private String chexi;		// chexi
	private String chexiId;		// chexi_id
	private String chexizhanshitu;		// chexizhanshitu
	private String chexingmingcheng;		// chexingmingcheng
	private String chexingId;		// chexing_id
	private String xiaoshouzhuangtai;		// xiaoshouzhuangtai
	private String changshang;		// changshang
	private String changshangId;		// changshang_id
	private String niankuan;		// niankuan
	private String gengxinshijian;		// gengxinshijian
	private String shangshishijian;		// shangshishijian
	private String changshangzhidaojia;		// changshangzhidaojia
	private String changshangzhidaojiaYuan;		// changshangzhidaojia_yuan
	private String jibie;		// jibie
	private String nengyuanleixing;		// nengyuanleixing
	private String gongxinbuchundianxuhanglichengKm;		// gongxinbuchundianxuhanglicheng_km
	private String kuaichongshijianXiaoshi;		// kuaichongshijian_xiaoshi
	private String manchongshijianXiaoshi;		// manchongshijian_xiaoshi
	private String kuaichongdianliangbaifenbi;		// kuaichongdianliangbaifenbi
	private String zuidagonglvKw;		// zuidagonglv_kw
	private String zuidaniujuNM;		// zuidaniuju_n_m
	private String fadongji;		// fadongji
	private String biansuxiang;		// biansuxiang
	private String changkuangaoMm;		// changkuangao_mm
	private String cheshenjiegou;		// cheshenjiegou
	private String zuigaochesuKmH;		// zuigaochesu_km_h
	private String guanfang0100kmHJiasuS;		// guanfang0_100km_h_jiasu_s
	private String shice0100kmHJiasuS;		// shice0_100km_h_jiasu_s
	private String shice1000kmHZhidongM;		// shice100_0km_h_zhidong_m
	private String shicexuhanglichengKm;		// shicexuhanglicheng_km
	private String gongxinbuzongheyouhaoL100km;		// gongxinbuzongheyouhao_l_100km
	private String shiceyouhaoL100km;		// shiceyouhao_l_100km
	private String zhengchezhibao;		// zhengchezhibao
	private String changduMm;		// changdu_mm
	private String kuanduMm;		// kuandu_mm
	private String gaoduMm;		// gaodu_mm
	private String zhoujuMm;		// zhouju_mm
	private String qianlunjuMm;		// qianlunju_mm
	private String houlunjuMm;		// houlunju_mm
	private String zuixiaolidijianxiMm;		// zuixiaolidijianxi_mm
	private String chemenshuGe;		// chemenshu_ge
	private String zuoweishuGe;		// zuoweishu_ge
	private String youxiangrongjiL;		// youxiangrongji_l
	private String xinglixiangrongjiL;		// xinglixiangrongji_l
	private String zhengbeizhiliangKg;		// zhengbeizhiliang_kg
	private String fadongjixinghao;		// fadongjixinghao
	private String pailiangMl;		// pailiang_ml
	private String pailiangL;		// pailiang_l
	private String jinqixingshi;		// jinqixingshi
	private String qigangpailiexingshi;		// qigangpailiexingshi
	private String qigangshuGe;		// qigangshu_ge
	private String meigangqimenshuGe;		// meigangqimenshu_ge
	private String yasuobi;		// yasuobi
	private String peiqijigou;		// peiqijigou
	private String gangjingMm;		// gangjing_mm
	private String xingchengMm;		// xingcheng_mm
	private String zuidamaliPs;		// zuidamali_ps
	private String zuidagonglvzhuansuRpm;		// zuidagonglvzhuansu_rpm
	private String zuidaniujuzhuansuRpm;		// zuidaniujuzhuansu_rpm
	private String fadongjiteyoujishu;		// fadongjiteyoujishu
	private String ranliaoxingshi;		// ranliaoxingshi
	private String ranyoubiaohao;		// ranyoubiaohao
	private String gongyoufangshi;		// gongyoufangshi
	private String ganggaicailiao;		// ganggaicailiao
	private String gangticailiao;		// gangticailiao
	private String huanbaobiaozhun;		// huanbaobiaozhun
	private String dianjileixing;		// dianjileixing
	private String diandongjizonggonglvKw;		// diandongjizonggonglv_kw
	private String diandongjizongniujuNM;		// diandongjizongniuju_n_m
	private String qiandiandongjizuidagonglvKw;		// qiandiandongjizuidagonglv_kw
	private String qiandiandongjizuidaniujuNM;		// qiandiandongjizuidaniuju_n_m
	private String houdiandongjizuidagonglvKw;		// houdiandongjizuidagonglv_kw
	private String houdiandongjizuidaniujuNM;		// houdiandongjizuidaniuju_n_m
	private String xitongzonghegonglvKw;		// xitongzonghegonglv_kw
	private String xitongzongheniujuNM;		// xitongzongheniuju_n_m
	private String qudongdianjishu;		// qudongdianjishu
	private String dianjibuju;		// dianjibuju
	private String dianchileixing;		// dianchileixing
	private String dianchirongliangKwh;		// dianchirongliang_kwh
	private String baigonglihaodianliangKwh100km;		// baigonglihaodianliang_kwh_100km
	private String dianchizuzhibao;		// dianchizuzhibao
	private String kuaichongdianliang;		// kuaichongdianliang
	private String dangweigeshu;		// dangweigeshu
	private String biansuxiangleixing;		// biansuxiangleixing
	private String jiancheng;		// jiancheng
	private String qudongfangshi;		// qudongfangshi
	private String qianxuanjialeixing;		// qianxuanjialeixing
	private String houxuanjialeixing;		// houxuanjialeixing
	private String zhulileixing;		// zhulileixing
	private String chetijiegou;		// chetijiegou
	private String qianzhidongqileixing;		// qianzhidongqileixing
	private String houzhidongqileixing;		// houzhidongqileixing
	private String zhuchezhidongleixing;		// zhuchezhidongleixing
	private String qianluntaiguige;		// qianluntaiguige
	private String houluntaiguige;		// houluntaiguige
	private String beitaiguige;		// beitaiguige
	private String zhuFujiashizuoanquanqinang;		// zhu_fujiashizuoanquanqinang
	private String qianHoupaiceqinang;		// qian_houpaiceqinang
	private String qianHoupaitoubuqinangQilian;		// qian_houpaitoubuqinang_qilian
	private String xibuqinang;		// xibuqinang
	private String houpaianquandaishiqinang;		// houpaianquandaishiqinang
	private String houpaizhongyanganquanqinang;		// houpaizhongyanganquanqinang
	private String beidongxingrenbaohu;		// beidongxingrenbaohu
	private String taiyajiancegongneng;		// taiyajiancegongneng
	private String lingtaiyajixuxingshi;		// lingtaiyajixuxingshi
	private String anquandaiweixitixing;		// anquandaiweixitixing
	private String isofixertongzuoyijiekou;		// isofixertongzuoyijiekou
	private String absfangbaosi;		// absfangbaosi
	private String zhidonglifenpeiEbdCbcdeng;		// zhidonglifenpei_ebd_cbcdeng
	private String shachefuzhuEbaBasBadeng;		// shachefuzhu_eba_bas_badeng
	private String qianyinlikongzhiAsrTcsTrcdeng;		// qianyinlikongzhi_asr_tcs_trcdeng
	private String cheshenwendingkongzhiEscEspDscdeng;		// cheshenwendingkongzhi_esc_esp_dscdeng
	private String bingxianfuzhu;		// bingxianfuzhu
	private String chedaopianliyujingxitong;		// chedaopianliyujingxitong
	private String chedaobaochifuzhuxitong;		// chedaobaochifuzhuxitong
	private String daolujiaotongbiaozhishibie;		// daolujiaotongbiaozhishibie
	private String zhudongshacheZhudonganquanxitong;		// zhudongshache_zhudonganquanxitong
	private String yeshixitong;		// yeshixitong
	private String pilaojiashitishi;		// pilaojiashitishi
	private String qianHouzhucheleida;		// qian_houzhucheleida
	private String jiashifuzhuyingxiang;		// jiashifuzhuyingxiang
	private String daochecheceyujingxitong;		// daochecheceyujingxitong
	private String xunhangxitong;		// xunhangxitong
	private String jiashimoshiqiehuan;		// jiashimoshiqiehuan
	private String zidongbocheruwei;		// zidongbocheruwei
	private String fadongjiqitingjishu;		// fadongjiqitingjishu
	private String zidongzhuche;		// zidongzhuche
	private String shangpofuzhu;		// shangpofuzhu
	private String doupohuanjiang;		// doupohuanjiang
	private String kebianxuanjiagongneng;		// kebianxuanjiagongneng
	private String kongqixuanjia;		// kongqixuanjia
	private String dianciganyingxuanjia;		// dianciganyingxuanjia
	private String kebianzhuanxiangbi;		// kebianzhuanxiangbi
	private String zhongyangchasuqisuozhigongneng;		// zhongyangchasuqisuozhigongneng
	private String zhengtizhudongzhuanxiangxitong;		// zhengtizhudongzhuanxiangxitong
	private String xianhuachasuqiChasusuo;		// xianhuachasuqi_chasusuo
	private String sheshuiganyingxitong;		// sheshuiganyingxitong
	private String tianchuangleixing;		// tianchuangleixing
	private String yundongwaiguantaojian;		// yundongwaiguantaojian
	private String lunquancaizhi;		// lunquancaizhi
	private String diandongxihechemen;		// diandongxihechemen
	private String cehuamenxingshi;		// cehuamenxingshi
	private String diandonghoubeixiang;		// diandonghoubeixiang
	private String ganyinghoubeixiang;		// ganyinghoubeixiang
	private String diandonghoubeixiangweizhijiyi;		// diandonghoubeixiangweizhijiyi
	private String weimenbolidulikaiqi;		// weimenbolidulikaiqi
	private String chedingxinglijia;		// chedingxinglijia
	private String fadongjidianzifangdao;		// fadongjidianzifangdao
	private String cheneizhongkongsuo;		// cheneizhongkongsuo
	private String yaoshileixing;		// yaoshileixing
	private String wuyaoshiqidongxitong;		// wuyaoshiqidongxitong
	private String wuyaoshijinrugongneng;		// wuyaoshijinrugongneng
	private String zhudongbiheshijinqigezha;		// zhudongbiheshijinqigezha
	private String yuanchengqidonggongneng;		// yuanchengqidonggongneng
	private String checejiaotaban;		// checejiaotaban
	private String fangxiangpancaizhi;		// fangxiangpancaizhi
	private String fangxiangpanweizhitiaojie;		// fangxiangpanweizhitiaojie
	private String duogongnengfangxiangpan;		// duogongnengfangxiangpan
	private String fangxiangpanhuandang;		// fangxiangpanhuandang
	private String fangxiangpanjiare;		// fangxiangpanjiare
	private String fangxiangpanjiyi;		// fangxiangpanjiyi
	private String xingchediannaoxianshipingmu;		// xingchediannaoxianshipingmu
	private String quanyejingyibiaopan;		// quanyejingyibiaopan
	private String yejingyibiaochicun;		// yejingyibiaochicun
	private String hudtaitoushuzixianshi;		// hudtaitoushuzixianshi
	private String neizhixingchejiluyi;		// neizhixingchejiluyi
	private String zhudongjiangzao;		// zhudongjiangzao
	private String shoujiwuxianchongdiangongneng;		// shoujiwuxianchongdiangongneng
	private String diandongketiaotaban;		// diandongketiaotaban
	private String zuoyicaizhi;		// zuoyicaizhi
	private String yundongfenggezuoyi;		// yundongfenggezuoyi
	private String zhuzuoyitiaojiefangshi;		// zhuzuoyitiaojiefangshi
	private String fuzuoyitiaojiefangshi;		// fuzuoyitiaojiefangshi
	private String zhuFujiashizuodiandongtiaojie;		// zhu_fujiashizuodiandongtiaojie
	private String qianpaizuoyigongneng;		// qianpaizuoyigongneng
	private String diandongzuoyijiyigongneng;		// diandongzuoyijiyigongneng
	private String fujiashiweihoupaiketiaojieanniu;		// fujiashiweihoupaiketiaojieanniu
	private String dierpaizuoyitiaojie;		// dierpaizuoyitiaojie
	private String houpaizuoyidiandongtiaojie;		// houpaizuoyidiandongtiaojie
	private String houpaizuoyigongneng;		// houpaizuoyigongneng
	private String houpaixiaozhuoban;		// houpaixiaozhuoban
	private String dierpaidulizuoyi;		// dierpaidulizuoyi
	private String zuoyibuju;		// zuoyibuju
	private String houpaizuoyifangdaoxingshi;		// houpaizuoyifangdaoxingshi
	private String houpaizuoyidiandongfangdao;		// houpaizuoyidiandongfangdao
	private String qianHouzhongyangfushou;		// qian_houzhongyangfushou
	private String houpaibeijia;		// houpaibeijia
	private String jiareZhilengbeijia;		// jiare_zhilengbeijia
	private String zhongkongcaiseyejingpingmu;		// zhongkongcaiseyejingpingmu
	private String zhongkongyejingpingchicun;		// zhongkongyejingpingchicun
	private String gpsdaohangxitong;		// gpsdaohangxitong
	private String daohanglukuangxinxixianshi;		// daohanglukuangxinxixianshi
	private String daolujiuyuanhujiao;		// daolujiuyuanhujiao
	private String zhongkongyejingpingfenpingxianshi;		// zhongkongyejingpingfenpingxianshi
	private String lanyaChezaidianhua;		// lanya_chezaidianhua
	private String shoujihulianYingshe;		// shoujihulian_yingshe
	private String yuyinshibiekongzhixitong;		// yuyinshibiekongzhixitong
	private String shoushikongzhi;		// shoushikongzhi
	private String chelianwang;		// chelianwang
	private String chezaidianshi;		// chezaidianshi
	private String houpaiyejingpingmu;		// houpaiyejingpingmu
	private String houpaikongzhiduomeiti;		// houpaikongzhiduomeiti
	private String waijieyinyuanjiekouleixing;		// waijieyinyuanjiekouleixing
	private String usbTypeCjiekoushuliang;		// usb_type_cjiekoushuliang
	private String chezaicdDvd;		// chezaicd_dvd
	private String dianyuan220v230v;		// dianyuan_220v_230v
	private String xinglixiang12vdianyuanjiekou;		// xinglixiang12vdianyuanjiekou
	private String yangshengqipinpaimingcheng;		// yangshengqipinpaimingcheng
	private String yangshengqishuliang;		// yangshengqishuliang
	private String jinguangdengguangyuan;		// jinguangdengguangyuan
	private String yuanguangdengguangyuan;		// yuanguangdengguangyuan
	private String dengguangtesegongneng;		// dengguangtesegongneng
	private String ledrijianxingchedeng;		// ledrijianxingchedeng
	private String zishiyingyuanjinguang;		// zishiyingyuanjinguang
	private String zidongtoudeng;		// zidongtoudeng
	private String zhuanxiangfuzhudeng;		// zhuanxiangfuzhudeng
	private String zhuanxiangtoudeng;		// zhuanxiangtoudeng
	private String cheqianwudeng;		// cheqianwudeng
	private String qiandadengyuwumoshi;		// qiandadengyuwumoshi
	private String dadenggaoduketiao;		// dadenggaoduketiao
	private String dadengqingxizhuangzhi;		// dadengqingxizhuangzhi
	private String dadengyanshiguanbi;		// dadengyanshiguanbi
	private String chumoshiyuedudeng;		// chumoshiyuedudeng
	private String cheneihuanjingfenweideng;		// cheneihuanjingfenweideng
	private String qianHoudiandongchechuang;		// qian_houdiandongchechuang
	private String chechuangyijianshengjianggongneng;		// chechuangyijianshengjianggongneng
	private String chechuangfangjiashougongneng;		// chechuangfangjiashougongneng
	private String fangziwaixianboli;		// fangziwaixianboli
	private String duocenggeyinboli;		// duocenggeyinboli
	private String waihoushijinggongneng;		// waihoushijinggongneng
	private String neihoushijinggongneng;		// neihoushijinggongneng
	private String houfengdangzheyanglian;		// houfengdangzheyanglian
	private String houpaicechuangzheyanglian;		// houpaicechuangzheyanglian
	private String houpaiceyinsiboli;		// houpaiceyinsiboli
	private String cheneihuazhuangjing;		// cheneihuazhuangjing
	private String houyushua;		// houyushua
	private String ganyingyushuagongneng;		// ganyingyushuagongneng
	private String kejiarepenshuizui;		// kejiarepenshuizui
	private String kongtiaowendukongzhifangshi;		// kongtiaowendukongzhifangshi
	private String houpaidulikongtiao;		// houpaidulikongtiao
	private String houzuochufengkou;		// houzuochufengkou
	private String wendufenqukongzhi;		// wendufenqukongzhi
	private String chezaikongqijinghuaqi;		// chezaikongqijinghuaqi
	private String cheneipm25guolvzhuangzhi;		// cheneipm2_5guolvzhuangzhi
	private String fulizifashengqi;		// fulizifashengqi
	private String cheneixiangfenzhuangzhi;		// cheneixiangfenzhuangzhi
	private String chezaibingxiang;		// chezaibingxiang
	private String xuanzhuangbao;		// xuanzhuangbao
	private String waiguanyanse;		// waiguanyanse
	private String neishiyanse;		// neishiyanse
	private String uploadDate;
	
	public VehicleInfo() {
		this(null);
	}

	public VehicleInfo(String id){
		super(id);
	}

	@ExcelField(title="首字母", align = ExcelField.Align.CENTER, sort = 1)
	public String getShouzimu() {
		return shouzimu;
	}

	public void setShouzimu(String shouzimu) {
		this.shouzimu = shouzimu;
	}

	@ExcelField(title="品牌", align = ExcelField.Align.CENTER, sort = 2)
	public String getPinpai() {
		return pinpai;
	}

	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	
	public String getPinpaiId() {
		return pinpaiId;
	}

	public void setPinpaiId(String pinpaiId) {
		this.pinpaiId = pinpaiId;
	}

	// @ExcelField(title="品牌logo", align = ExcelField.Align.CENTER, sort = 3)
	public String getPinpaiLogo() {
		return pinpaiLogo;
	}

	public void setPinpaiLogo(String pinpaiLogo) {
		this.pinpaiLogo = pinpaiLogo;
	}

	@ExcelField(title="车系", align = ExcelField.Align.CENTER, sort = 4)
	public String getChexi() {
		return chexi;
	}

	public void setChexi(String chexi) {
		this.chexi = chexi;
	}
	
	public String getChexiId() {
		return chexiId;
	}

	public void setChexiId(String chexiId) {
		this.chexiId = chexiId;
	}

	@ExcelField(title="车系展示图", align = ExcelField.Align.CENTER, sort = 5)
	public String getChexizhanshitu() {
		return chexizhanshitu;
	}

	public void setChexizhanshitu(String chexizhanshitu) {
		this.chexizhanshitu = chexizhanshitu;
	}

	@ExcelField(title="车型名称", align = ExcelField.Align.CENTER, sort = 6)
	public String getChexingmingcheng() {
		return chexingmingcheng;
	}

	public void setChexingmingcheng(String chexingmingcheng) {
		this.chexingmingcheng = chexingmingcheng;
	}
	
	public String getChexingId() {
		return chexingId;
	}

	public void setChexingId(String chexingId) {
		this.chexingId = chexingId;
	}

	@ExcelField(title="销售状态", align = ExcelField.Align.CENTER, sort = 7)
	public String getXiaoshouzhuangtai() {
		return xiaoshouzhuangtai;
	}

	public void setXiaoshouzhuangtai(String xiaoshouzhuangtai) {
		this.xiaoshouzhuangtai = xiaoshouzhuangtai;
	}

	@ExcelField(title="厂商", align = ExcelField.Align.CENTER, sort = 8)
	public String getChangshang() {
		return changshang;
	}

	public void setChangshang(String changshang) {
		this.changshang = changshang;
	}
	
	public String getChangshangId() {
		return changshangId;
	}

	public void setChangshangId(String changshangId) {
		this.changshangId = changshangId;
	}

	@ExcelField(title="年款", align = ExcelField.Align.CENTER, sort = 9)
	public String getNiankuan() {
		return niankuan;
	}

	public void setNiankuan(String niankuan) {
		this.niankuan = niankuan;
	}

	@ExcelField(title="更新时间", align = ExcelField.Align.CENTER, sort = 10)
	public String getGengxinshijian() {
		return gengxinshijian;
	}

	public void setGengxinshijian(String gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}

	@ExcelField(title="上市时间", align = ExcelField.Align.CENTER, sort = 11)
	public String getShangshishijian() {
		return shangshishijian;
	}

	public void setShangshishijian(String shangshishijian) {
		this.shangshishijian = shangshishijian;
	}

	@ExcelField(title="厂商指导价(元)", align = ExcelField.Align.CENTER, sort = 12)
	public String getChangshangzhidaojia() {
		return changshangzhidaojia;
	}

	public void setChangshangzhidaojia(String changshangzhidaojia) {
		this.changshangzhidaojia = changshangzhidaojia;
	}

	@ExcelField(title="厂商指导价(万元)", align = ExcelField.Align.CENTER, sort = 13)
	public String getChangshangzhidaojiaYuan() {
		return changshangzhidaojiaYuan;
	}

	public void setChangshangzhidaojiaYuan(String changshangzhidaojiaYuan) {
		this.changshangzhidaojiaYuan = changshangzhidaojiaYuan;
	}

	@ExcelField(title="级别", align = ExcelField.Align.CENTER, sort = 14)
	public String getJibie() {
		return jibie;
	}

	public void setJibie(String jibie) {
		this.jibie = jibie;
	}

	@ExcelField(title="能源类型", align = ExcelField.Align.CENTER, sort = 15)
	public String getNengyuanleixing() {
		return nengyuanleixing;
	}

	public void setNengyuanleixing(String nengyuanleixing) {
		this.nengyuanleixing = nengyuanleixing;
	}

	@ExcelField(title="工信部纯电续航里程(KM)", align = ExcelField.Align.CENTER, sort = 16)
	public String getGongxinbuchundianxuhanglichengKm() {
		return gongxinbuchundianxuhanglichengKm;
	}

	public void setGongxinbuchundianxuhanglichengKm(String gongxinbuchundianxuhanglichengKm) {
		this.gongxinbuchundianxuhanglichengKm = gongxinbuchundianxuhanglichengKm;
	}

	@ExcelField(title="快充时间", align = ExcelField.Align.CENTER, sort = 17)
	public String getKuaichongshijianXiaoshi() {
		return kuaichongshijianXiaoshi;
	}

	public void setKuaichongshijianXiaoshi(String kuaichongshijianXiaoshi) {
		this.kuaichongshijianXiaoshi = kuaichongshijianXiaoshi;
	}


	@ExcelField(title="慢充时间(小时)", align = ExcelField.Align.CENTER, sort = 18)
	public String getManchongshijianXiaoshi() {
		return manchongshijianXiaoshi;
	}

	public void setManchongshijianXiaoshi(String manchongshijianXiaoshi) {
		this.manchongshijianXiaoshi = manchongshijianXiaoshi;
	}

	@ExcelField(title="快充电量百分比", align = ExcelField.Align.CENTER, sort = 19)
	public String getKuaichongdianliangbaifenbi() {
		return kuaichongdianliangbaifenbi;
	}

	public void setKuaichongdianliangbaifenbi(String kuaichongdianliangbaifenbi) {
		this.kuaichongdianliangbaifenbi = kuaichongdianliangbaifenbi;
	}

	@ExcelField(title="最大功率(KM)", align = ExcelField.Align.CENTER, sort = 20)
	public String getZuidagonglvKw() {
		return zuidagonglvKw;
	}

	public void setZuidagonglvKw(String zuidagonglvKw) {
		this.zuidagonglvKw = zuidagonglvKw;
	}

	@ExcelField(title="最大扭矩(NM)", align = ExcelField.Align.CENTER, sort = 21)
	public String getZuidaniujuNM() {
		return zuidaniujuNM;
	}

	public void setZuidaniujuNM(String zuidaniujuNM) {
		this.zuidaniujuNM = zuidaniujuNM;
	}

	@ExcelField(title="发动机", align = ExcelField.Align.CENTER, sort = 22)
	public String getFadongji() {
		return fadongji;
	}

	public void setFadongji(String fadongji) {
		this.fadongji = fadongji;
	}

	@ExcelField(title="变速箱", align = ExcelField.Align.CENTER, sort = 23)
	public String getBiansuxiang() {
		return biansuxiang;
	}

	public void setBiansuxiang(String biansuxiang) {
		this.biansuxiang = biansuxiang;
	}

	@ExcelField(title="长宽高(mm)", align = ExcelField.Align.CENTER, sort = 24)
	public String getChangkuangaoMm() {
		return changkuangaoMm;
	}

	public void setChangkuangaoMm(String changkuangaoMm) {
		this.changkuangaoMm = changkuangaoMm;
	}

	@ExcelField(title="车身结构", align = ExcelField.Align.CENTER, sort = 25)
	public String getCheshenjiegou() {
		return cheshenjiegou;
	}

	public void setCheshenjiegou(String cheshenjiegou) {
		this.cheshenjiegou = cheshenjiegou;
	}

	@ExcelField(title="最高车速(Km/H)", align = ExcelField.Align.CENTER, sort = 26)
	public String getZuigaochesuKmH() {
		return zuigaochesuKmH;
	}

	public void setZuigaochesuKmH(String zuigaochesuKmH) {
		this.zuigaochesuKmH = zuigaochesuKmH;
	}

	@ExcelField(title="官方0-100Km/h加速(秒)", align = ExcelField.Align.CENTER, sort = 27)
	public String getGuanfang0100kmHJiasuS() {
		return guanfang0100kmHJiasuS;
	}

	public void setGuanfang0100kmHJiasuS(String guanfang0100kmHJiasuS) {
		this.guanfang0100kmHJiasuS = guanfang0100kmHJiasuS;
	}

	@ExcelField(title="实测0-100Km/H加速(秒)", align = ExcelField.Align.CENTER, sort = 28)
	public String getShice0100kmHJiasuS() {
		return shice0100kmHJiasuS;
	}

	public void setShice0100kmHJiasuS(String shice0100kmHJiasuS) {
		this.shice0100kmHJiasuS = shice0100kmHJiasuS;
	}

	@ExcelField(title="实测100-0Km/H制动(米)", align = ExcelField.Align.CENTER, sort = 29)
	public String getShice1000kmHZhidongM() {
		return shice1000kmHZhidongM;
	}

	public void setShice1000kmHZhidongM(String shice1000kmHZhidongM) {
		this.shice1000kmHZhidongM = shice1000kmHZhidongM;
	}

	@ExcelField(title="实测续航里程(Km)", align = ExcelField.Align.CENTER, sort = 30)
	public String getShicexuhanglichengKm() {
		return shicexuhanglichengKm;
	}

	public void setShicexuhanglichengKm(String shicexuhanglichengKm) {
		this.shicexuhanglichengKm = shicexuhanglichengKm;
	}

	@ExcelField(title="工信部综合油耗(L/100Km)", align = ExcelField.Align.CENTER, sort = 31)
	public String getGongxinbuzongheyouhaoL100km() {
		return gongxinbuzongheyouhaoL100km;
	}

	public void setGongxinbuzongheyouhaoL100km(String gongxinbuzongheyouhaoL100km) {
		this.gongxinbuzongheyouhaoL100km = gongxinbuzongheyouhaoL100km;
	}

	@ExcelField(title="实测油耗(L/100Km)", align = ExcelField.Align.CENTER, sort = 32)
	public String getShiceyouhaoL100km() {
		return shiceyouhaoL100km;
	}

	public void setShiceyouhaoL100km(String shiceyouhaoL100km) {
		this.shiceyouhaoL100km = shiceyouhaoL100km;
	}

	@ExcelField(title="整车质保", align = ExcelField.Align.CENTER, sort = 33)
	public String getZhengchezhibao() {
		return zhengchezhibao;
	}

	public void setZhengchezhibao(String zhengchezhibao) {
		this.zhengchezhibao = zhengchezhibao;
	}

	@ExcelField(title="长度(毫米)", align = ExcelField.Align.CENTER, sort = 34)
	public String getChangduMm() {
		return changduMm;
	}

	public void setChangduMm(String changduMm) {
		this.changduMm = changduMm;
	}

	@ExcelField(title="宽度(毫米)", align = ExcelField.Align.CENTER, sort = 35)
	public String getKuanduMm() {
		return kuanduMm;
	}

	public void setKuanduMm(String kuanduMm) {
		this.kuanduMm = kuanduMm;
	}

	@ExcelField(title="高度(毫米)", align = ExcelField.Align.CENTER, sort = 36)
	public String getGaoduMm() {
		return gaoduMm;
	}

	public void setGaoduMm(String gaoduMm) {
		this.gaoduMm = gaoduMm;
	}

	@ExcelField(title="轴距(毫米)", align = ExcelField.Align.CENTER, sort = 37)
	public String getZhoujuMm() {
		return zhoujuMm;
	}

	public void setZhoujuMm(String zhoujuMm) {
		this.zhoujuMm = zhoujuMm;
	}

	@ExcelField(title="前轮距(毫米)", align = ExcelField.Align.CENTER, sort = 38)
	public String getQianlunjuMm() {
		return qianlunjuMm;
	}

	public void setQianlunjuMm(String qianlunjuMm) {
		this.qianlunjuMm = qianlunjuMm;
	}

	@ExcelField(title="后轮距(毫米)", align = ExcelField.Align.CENTER, sort = 39)
	public String getHoulunjuMm() {
		return houlunjuMm;
	}

	public void setHoulunjuMm(String houlunjuMm) {
		this.houlunjuMm = houlunjuMm;
	}

	@ExcelField(title="最小离地间隙(毫米)", align = ExcelField.Align.CENTER, sort = 40)
	public String getZuixiaolidijianxiMm() {
		return zuixiaolidijianxiMm;
	}

	public void setZuixiaolidijianxiMm(String zuixiaolidijianxiMm) {
		this.zuixiaolidijianxiMm = zuixiaolidijianxiMm;
	}

	@ExcelField(title="车门数(个)", align = ExcelField.Align.CENTER, sort = 41)
	public String getChemenshuGe() {
		return chemenshuGe;
	}

	public void setChemenshuGe(String chemenshuGe) {
		this.chemenshuGe = chemenshuGe;
	}

	@ExcelField(title="座位数(个)", align = ExcelField.Align.CENTER, sort = 4)
	public String getZuoweishuGe() {
		return zuoweishuGe;
	}

	public void setZuoweishuGe(String zuoweishuGe) {
		this.zuoweishuGe = zuoweishuGe;
	}

	@ExcelField(title="邮箱容积(升)", align = ExcelField.Align.CENTER, sort = 43)
	public String getYouxiangrongjiL() {
		return youxiangrongjiL;
	}

	public void setYouxiangrongjiL(String youxiangrongjiL) {
		this.youxiangrongjiL = youxiangrongjiL;
	}

	@ExcelField(title="行李箱容积(升)", align = ExcelField.Align.CENTER, sort = 44)
	public String getXinglixiangrongjiL() {
		return xinglixiangrongjiL;
	}

	public void setXinglixiangrongjiL(String xinglixiangrongjiL) {
		this.xinglixiangrongjiL = xinglixiangrongjiL;
	}

	@ExcelField(title="整备质量(千克)", align = ExcelField.Align.CENTER, sort = 45)
	public String getZhengbeizhiliangKg() {
		return zhengbeizhiliangKg;
	}

	public void setZhengbeizhiliangKg(String zhengbeizhiliangKg) {
		this.zhengbeizhiliangKg = zhengbeizhiliangKg;
	}

	@ExcelField(title="发动机型号", align = ExcelField.Align.CENTER, sort = 46)
	public String getFadongjixinghao() {
		return fadongjixinghao;
	}

	public void setFadongjixinghao(String fadongjixinghao) {
		this.fadongjixinghao = fadongjixinghao;
	}

	@ExcelField(title="排量(毫升)", align = ExcelField.Align.CENTER, sort = 47)
	public String getPailiangMl() {
		return pailiangMl;
	}

	public void setPailiangMl(String pailiangMl) {
		this.pailiangMl = pailiangMl;
	}

	@ExcelField(title="排量(升)", align = ExcelField.Align.CENTER, sort = 48)
	public String getPailiangL() {
		return pailiangL;
	}

	public void setPailiangL(String pailiangL) {
		this.pailiangL = pailiangL;
	}

	@ExcelField(title="进气形式", align = ExcelField.Align.CENTER, sort = 49)
	public String getJinqixingshi() {
		return jinqixingshi;
	}

	public void setJinqixingshi(String jinqixingshi) {
		this.jinqixingshi = jinqixingshi;
	}

	@ExcelField(title="气缸排列形式", align = ExcelField.Align.CENTER, sort = 50)
	public String getQigangpailiexingshi() {
		return qigangpailiexingshi;
	}

	public void setQigangpailiexingshi(String qigangpailiexingshi) {
		this.qigangpailiexingshi = qigangpailiexingshi;
	}

	@ExcelField(title="气缸数(个)", align = ExcelField.Align.CENTER, sort = 51)
	public String getQigangshuGe() {
		return qigangshuGe;
	}

	public void setQigangshuGe(String qigangshuGe) {
		this.qigangshuGe = qigangshuGe;
	}

	@ExcelField(title="每缸气门数(个)", align = ExcelField.Align.CENTER, sort = 52)
	public String getMeigangqimenshuGe() {
		return meigangqimenshuGe;
	}

	public void setMeigangqimenshuGe(String meigangqimenshuGe) {
		this.meigangqimenshuGe = meigangqimenshuGe;
	}

	@ExcelField(title="压缩比", align = ExcelField.Align.CENTER, sort = 53)
	public String getYasuobi() {
		return yasuobi;
	}

	public void setYasuobi(String yasuobi) {
		this.yasuobi = yasuobi;
	}

	@ExcelField(title="排气形式", align = ExcelField.Align.CENTER, sort = 54)
	public String getPeiqijigou() {
		return peiqijigou;
	}

	public void setPeiqijigou(String peiqijigou) {
		this.peiqijigou = peiqijigou;
	}

	@ExcelField(title="缸径(毫米)", align = ExcelField.Align.CENTER, sort = 55)
	public String getGangjingMm() {
		return gangjingMm;
	}

	public void setGangjingMm(String gangjingMm) {
		this.gangjingMm = gangjingMm;
	}

	@ExcelField(title="行程(毫米)", align = ExcelField.Align.CENTER, sort = 56)
	public String getXingchengMm() {
		return xingchengMm;
	}

	public void setXingchengMm(String xingchengMm) {
		this.xingchengMm = xingchengMm;
	}

	@ExcelField(title="最大马力(Ps)", align = ExcelField.Align.CENTER, sort = 57)
	public String getZuidamaliPs() {
		return zuidamaliPs;
	}

	public void setZuidamaliPs(String zuidamaliPs) {
		this.zuidamaliPs = zuidamaliPs;
	}

	@ExcelField(title="最大功率转数(rpm)", align = ExcelField.Align.CENTER, sort = 58)
	public String getZuidagonglvzhuansuRpm() {
		return zuidagonglvzhuansuRpm;
	}

	public void setZuidagonglvzhuansuRpm(String zuidagonglvzhuansuRpm) {
		this.zuidagonglvzhuansuRpm = zuidagonglvzhuansuRpm;
	}

	@ExcelField(title="最大扭矩转数(rpm)", align = ExcelField.Align.CENTER, sort = 59)
	public String getZuidaniujuzhuansuRpm() {
		return zuidaniujuzhuansuRpm;
	}

	public void setZuidaniujuzhuansuRpm(String zuidaniujuzhuansuRpm) {
		this.zuidaniujuzhuansuRpm = zuidaniujuzhuansuRpm;
	}

	@ExcelField(title="发动机特有技术", align = ExcelField.Align.CENTER, sort = 60)
	public String getFadongjiteyoujishu() {
		return fadongjiteyoujishu;
	}

	public void setFadongjiteyoujishu(String fadongjiteyoujishu) {
		this.fadongjiteyoujishu = fadongjiteyoujishu;
	}

	@ExcelField(title="燃料形式", align = ExcelField.Align.CENTER, sort = 61)
	public String getRanliaoxingshi() {
		return ranliaoxingshi;
	}

	public void setRanliaoxingshi(String ranliaoxingshi) {
		this.ranliaoxingshi = ranliaoxingshi;
	}

	@ExcelField(title="燃油标号", align = ExcelField.Align.CENTER, sort = 62)
	public String getRanyoubiaohao() {
		return ranyoubiaohao;
	}

	public void setRanyoubiaohao(String ranyoubiaohao) {
		this.ranyoubiaohao = ranyoubiaohao;
	}

	@ExcelField(title="供油方式", align = ExcelField.Align.CENTER, sort = 62)
	public String getGongyoufangshi() {
		return gongyoufangshi;
	}

	public void setGongyoufangshi(String gongyoufangshi) {
		this.gongyoufangshi = gongyoufangshi;
	}

	@ExcelField(title="缸盖材料", align = ExcelField.Align.CENTER, sort = 63)
	public String getGanggaicailiao() {
		return ganggaicailiao;
	}

	public void setGanggaicailiao(String ganggaicailiao) {
		this.ganggaicailiao = ganggaicailiao;
	}

	@ExcelField(title="缸体材料", align = ExcelField.Align.CENTER, sort = 64)
	public String getGangticailiao() {
		return gangticailiao;
	}

	public void setGangticailiao(String gangticailiao) {
		this.gangticailiao = gangticailiao;
	}

	@ExcelField(title="环保标准", align = ExcelField.Align.CENTER, sort = 65)
	public String getHuanbaobiaozhun() {
		return huanbaobiaozhun;
	}

	public void setHuanbaobiaozhun(String huanbaobiaozhun) {
		this.huanbaobiaozhun = huanbaobiaozhun;
	}

	@ExcelField(title="电机类型", align = ExcelField.Align.CENTER, sort = 66)
	public String getDianjileixing() {
		return dianjileixing;
	}

	public void setDianjileixing(String dianjileixing) {
		this.dianjileixing = dianjileixing;
	}

	@ExcelField(title="电动机总功率(KW)", align = ExcelField.Align.CENTER, sort = 67)
	public String getDiandongjizonggonglvKw() {
		return diandongjizonggonglvKw;
	}

	public void setDiandongjizonggonglvKw(String diandongjizonggonglvKw) {
		this.diandongjizonggonglvKw = diandongjizonggonglvKw;
	}

	@ExcelField(title="电动机总扭矩(牛米)", align = ExcelField.Align.CENTER, sort = 68)
	public String getDiandongjizongniujuNM() {
		return diandongjizongniujuNM;
	}

	public void setDiandongjizongniujuNM(String diandongjizongniujuNM) {
		this.diandongjizongniujuNM = diandongjizongniujuNM;
	}

	@ExcelField(title="前电动机总功率(KW)", align = ExcelField.Align.CENTER, sort = 69)
	public String getQiandiandongjizuidagonglvKw() {
		return qiandiandongjizuidagonglvKw;
	}

	public void setQiandiandongjizuidagonglvKw(String qiandiandongjizuidagonglvKw) {
		this.qiandiandongjizuidagonglvKw = qiandiandongjizuidagonglvKw;
	}

	@ExcelField(title="前电动机最大扭矩(牛米)", align = ExcelField.Align.CENTER, sort = 70)
	public String getQiandiandongjizuidaniujuNM() {
		return qiandiandongjizuidaniujuNM;
	}

	public void setQiandiandongjizuidaniujuNM(String qiandiandongjizuidaniujuNM) {
		this.qiandiandongjizuidaniujuNM = qiandiandongjizuidaniujuNM;
	}

	@ExcelField(title="后电动机最大功率(KW)", align = ExcelField.Align.CENTER, sort = 71)
	public String getHoudiandongjizuidagonglvKw() {
		return houdiandongjizuidagonglvKw;
	}

	public void setHoudiandongjizuidagonglvKw(String houdiandongjizuidagonglvKw) {
		this.houdiandongjizuidagonglvKw = houdiandongjizuidagonglvKw;
	}

	@ExcelField(title="后电动机最大扭矩(牛米)", align = ExcelField.Align.CENTER, sort = 72)
	public String getHoudiandongjizuidaniujuNM() {
		return houdiandongjizuidaniujuNM;
	}

	public void setHoudiandongjizuidaniujuNM(String houdiandongjizuidaniujuNM) {
		this.houdiandongjizuidaniujuNM = houdiandongjizuidaniujuNM;
	}

	@ExcelField(title="系统总功率(KW)", align = ExcelField.Align.CENTER, sort = 73)
	public String getXitongzonghegonglvKw() {
		return xitongzonghegonglvKw;
	}

	public void setXitongzonghegonglvKw(String xitongzonghegonglvKw) {
		this.xitongzonghegonglvKw = xitongzonghegonglvKw;
	}

	@ExcelField(title="系统总扭矩(牛米)", align = ExcelField.Align.CENTER, sort = 74)
	public String getXitongzongheniujuNM() {
		return xitongzongheniujuNM;
	}

	public void setXitongzongheniujuNM(String xitongzongheniujuNM) {
		this.xitongzongheniujuNM = xitongzongheniujuNM;
	}

	@ExcelField(title="驱动电机数", align = ExcelField.Align.CENTER, sort = 75)
	public String getQudongdianjishu() {
		return qudongdianjishu;
	}

	public void setQudongdianjishu(String qudongdianjishu) {
		this.qudongdianjishu = qudongdianjishu;
	}

	@ExcelField(title="电机布局", align = ExcelField.Align.CENTER, sort = 76)
	public String getDianjibuju() {
		return dianjibuju;
	}

	public void setDianjibuju(String dianjibuju) {
		this.dianjibuju = dianjibuju;
	}

	@ExcelField(title="电池类型", align = ExcelField.Align.CENTER, sort = 77)
	public String getDianchileixing() {
		return dianchileixing;
	}

	public void setDianchileixing(String dianchileixing) {
		this.dianchileixing = dianchileixing;
	}

	@ExcelField(title="电池容量(千瓦时)", align = ExcelField.Align.CENTER, sort = 78)
	public String getDianchirongliangKwh() {
		return dianchirongliangKwh;
	}

	public void setDianchirongliangKwh(String dianchirongliangKwh) {
		this.dianchirongliangKwh = dianchirongliangKwh;
	}

	@ExcelField(title="百公里耗电量(千瓦时/100Km)", align = ExcelField.Align.CENTER, sort = 79)
	public String getBaigonglihaodianliangKwh100km() {
		return baigonglihaodianliangKwh100km;
	}

	public void setBaigonglihaodianliangKwh100km(String baigonglihaodianliangKwh100km) {
		this.baigonglihaodianliangKwh100km = baigonglihaodianliangKwh100km;
	}

	@ExcelField(title="电池组质保", align = ExcelField.Align.CENTER, sort = 80)
	public String getDianchizuzhibao() {
		return dianchizuzhibao;
	}

	public void setDianchizuzhibao(String dianchizuzhibao) {
		this.dianchizuzhibao = dianchizuzhibao;
	}

	@ExcelField(title="快充电量", align = ExcelField.Align.CENTER, sort = 81)
	public String getKuaichongdianliang() {
		return kuaichongdianliang;
	}

	public void setKuaichongdianliang(String kuaichongdianliang) {
		this.kuaichongdianliang = kuaichongdianliang;
	}

	@ExcelField(title="档位个数", align = ExcelField.Align.CENTER, sort = 82)
	public String getDangweigeshu() {
		return dangweigeshu;
	}

	public void setDangweigeshu(String dangweigeshu) {
		this.dangweigeshu = dangweigeshu;
	}

	@ExcelField(title="变速箱类型", align = ExcelField.Align.CENTER, sort = 83)
	public String getBiansuxiangleixing() {
		return biansuxiangleixing;
	}

	public void setBiansuxiangleixing(String biansuxiangleixing) {
		this.biansuxiangleixing = biansuxiangleixing;
	}

	@ExcelField(title="简称", align = ExcelField.Align.CENTER, sort = 84)
	public String getJiancheng() {
		return jiancheng;
	}

	public void setJiancheng(String jiancheng) {
		this.jiancheng = jiancheng;
	}

	@ExcelField(title="驱动方式", align = ExcelField.Align.CENTER, sort = 85)
	public String getQudongfangshi() {
		return qudongfangshi;
	}

	public void setQudongfangshi(String qudongfangshi) {
		this.qudongfangshi = qudongfangshi;
	}

	@ExcelField(title="前悬架类型", align = ExcelField.Align.CENTER, sort = 86)
	public String getQianxuanjialeixing() {
		return qianxuanjialeixing;
	}

	public void setQianxuanjialeixing(String qianxuanjialeixing) {
		this.qianxuanjialeixing = qianxuanjialeixing;
	}

	@ExcelField(title="后悬架类型", align = ExcelField.Align.CENTER, sort = 87)
	public String getHouxuanjialeixing() {
		return houxuanjialeixing;
	}

	public void setHouxuanjialeixing(String houxuanjialeixing) {
		this.houxuanjialeixing = houxuanjialeixing;
	}

	@ExcelField(title="助力类型", align = ExcelField.Align.CENTER, sort = 88)
	public String getZhulileixing() {
		return zhulileixing;
	}

	public void setZhulileixing(String zhulileixing) {
		this.zhulileixing = zhulileixing;
	}

	@ExcelField(title="车体结构", align = ExcelField.Align.CENTER, sort = 89)
	public String getChetijiegou() {
		return chetijiegou;
	}

	public void setChetijiegou(String chetijiegou) {
		this.chetijiegou = chetijiegou;
	}

	@ExcelField(title="前制动器类型", align = ExcelField.Align.CENTER, sort = 90)
	public String getQianzhidongqileixing() {
		return qianzhidongqileixing;
	}

	public void setQianzhidongqileixing(String qianzhidongqileixing) {
		this.qianzhidongqileixing = qianzhidongqileixing;
	}

	@ExcelField(title="后制动器类型", align = ExcelField.Align.CENTER, sort = 91)
	public String getHouzhidongqileixing() {
		return houzhidongqileixing;
	}

	public void setHouzhidongqileixing(String houzhidongqileixing) {
		this.houzhidongqileixing = houzhidongqileixing;
	}

	@ExcelField(title="驻车制动类型", align = ExcelField.Align.CENTER, sort = 92)
	public String getZhuchezhidongleixing() {
		return zhuchezhidongleixing;
	}

	public void setZhuchezhidongleixing(String zhuchezhidongleixing) {
		this.zhuchezhidongleixing = zhuchezhidongleixing;
	}

	@ExcelField(title="前轮胎规格", align = ExcelField.Align.CENTER, sort = 93)
	public String getQianluntaiguige() {
		return qianluntaiguige;
	}

	public void setQianluntaiguige(String qianluntaiguige) {
		this.qianluntaiguige = qianluntaiguige;
	}

	@ExcelField(title="后轮胎规格", align = ExcelField.Align.CENTER, sort = 94)
	public String getHouluntaiguige() {
		return houluntaiguige;
	}

	public void setHouluntaiguige(String houluntaiguige) {
		this.houluntaiguige = houluntaiguige;
	}

	@ExcelField(title="备胎规格", align = ExcelField.Align.CENTER, sort = 95)
	public String getBeitaiguige() {
		return beitaiguige;
	}

	public void setBeitaiguige(String beitaiguige) {
		this.beitaiguige = beitaiguige;
	}

	@ExcelField(title="主副驾驶座安全气囊", align = ExcelField.Align.CENTER, sort = 96)
	public String getZhuFujiashizuoanquanqinang() {
		return zhuFujiashizuoanquanqinang;
	}

	public void setZhuFujiashizuoanquanqinang(String zhuFujiashizuoanquanqinang) {
		this.zhuFujiashizuoanquanqinang = zhuFujiashizuoanquanqinang;
	}

	@ExcelField(title="前后排侧气囊", align = ExcelField.Align.CENTER, sort = 97)
	public String getQianHoupaiceqinang() {
		return qianHoupaiceqinang;
	}

	public void setQianHoupaiceqinang(String qianHoupaiceqinang) {
		this.qianHoupaiceqinang = qianHoupaiceqinang;
	}

	@ExcelField(title="前后排头部气囊气帘", align = ExcelField.Align.CENTER, sort = 98)
	public String getQianHoupaitoubuqinangQilian() {
		return qianHoupaitoubuqinangQilian;
	}

	public void setQianHoupaitoubuqinangQilian(String qianHoupaitoubuqinangQilian) {
		this.qianHoupaitoubuqinangQilian = qianHoupaitoubuqinangQilian;
	}

	@ExcelField(title="膝部气囊", align = ExcelField.Align.CENTER, sort = 99)
	public String getXibuqinang() {
		return xibuqinang;
	}

	public void setXibuqinang(String xibuqinang) {
		this.xibuqinang = xibuqinang;
	}

	@ExcelField(title="后排安全带式气囊", align = ExcelField.Align.CENTER, sort = 100)
	public String getHoupaianquandaishiqinang() {
		return houpaianquandaishiqinang;
	}

	public void setHoupaianquandaishiqinang(String houpaianquandaishiqinang) {
		this.houpaianquandaishiqinang = houpaianquandaishiqinang;
	}

	@ExcelField(title="后排中央安全气囊", align = ExcelField.Align.CENTER, sort = 101)
	public String getHoupaizhongyanganquanqinang() {
		return houpaizhongyanganquanqinang;
	}

	public void setHoupaizhongyanganquanqinang(String houpaizhongyanganquanqinang) {
		this.houpaizhongyanganquanqinang = houpaizhongyanganquanqinang;
	}

	@ExcelField(title="被动行人保护", align = ExcelField.Align.CENTER, sort = 102)
	public String getBeidongxingrenbaohu() {
		return beidongxingrenbaohu;
	}

	public void setBeidongxingrenbaohu(String beidongxingrenbaohu) {
		this.beidongxingrenbaohu = beidongxingrenbaohu;
	}

	@ExcelField(title="胎压监测功能", align = ExcelField.Align.CENTER, sort = 103)
	public String getTaiyajiancegongneng() {
		return taiyajiancegongneng;
	}

	public void setTaiyajiancegongneng(String taiyajiancegongneng) {
		this.taiyajiancegongneng = taiyajiancegongneng;
	}

	@ExcelField(title="零胎压继续行驶", align = ExcelField.Align.CENTER, sort = 104)
	public String getLingtaiyajixuxingshi() {
		return lingtaiyajixuxingshi;
	}

	public void setLingtaiyajixuxingshi(String lingtaiyajixuxingshi) {
		this.lingtaiyajixuxingshi = lingtaiyajixuxingshi;
	}

	@ExcelField(title="安全带未系提醒", align = ExcelField.Align.CENTER, sort = 105)
	public String getAnquandaiweixitixing() {
		return anquandaiweixitixing;
	}

	public void setAnquandaiweixitixing(String anquandaiweixitixing) {
		this.anquandaiweixitixing = anquandaiweixitixing;
	}

	@ExcelField(title="ISOFIX儿童座机接口", align = ExcelField.Align.CENTER, sort = 106)
	public String getIsofixertongzuoyijiekou() {
		return isofixertongzuoyijiekou;
	}

	public void setIsofixertongzuoyijiekou(String isofixertongzuoyijiekou) {
		this.isofixertongzuoyijiekou = isofixertongzuoyijiekou;
	}

	@ExcelField(title="ABS防抱死", align = ExcelField.Align.CENTER, sort = 107)
	public String getAbsfangbaosi() {
		return absfangbaosi;
	}

	public void setAbsfangbaosi(String absfangbaosi) {
		this.absfangbaosi = absfangbaosi;
	}

	@ExcelField(title="制动力分配EBDCBDENG", align = ExcelField.Align.CENTER, sort = 108)
	public String getZhidonglifenpeiEbdCbcdeng() {
		return zhidonglifenpeiEbdCbcdeng;
	}

	public void setZhidonglifenpeiEbdCbcdeng(String zhidonglifenpeiEbdCbcdeng) {
		this.zhidonglifenpeiEbdCbcdeng = zhidonglifenpeiEbdCbcdeng;
	}

	@ExcelField(title="刹车辅助EbaBasBadeng", align = ExcelField.Align.CENTER, sort = 109)
	public String getShachefuzhuEbaBasBadeng() {
		return shachefuzhuEbaBasBadeng;
	}

	public void setShachefuzhuEbaBasBadeng(String shachefuzhuEbaBasBadeng) {
		this.shachefuzhuEbaBasBadeng = shachefuzhuEbaBasBadeng;
	}

	@ExcelField(title="牵引力控制AsrTcsTrcdeng", align = ExcelField.Align.CENTER, sort = 110)
	public String getQianyinlikongzhiAsrTcsTrcdeng() {
		return qianyinlikongzhiAsrTcsTrcdeng;
	}

	public void setQianyinlikongzhiAsrTcsTrcdeng(String qianyinlikongzhiAsrTcsTrcdeng) {
		this.qianyinlikongzhiAsrTcsTrcdeng = qianyinlikongzhiAsrTcsTrcdeng;
	}

	@ExcelField(title="车身稳定控制EscEspDscdeng", align = ExcelField.Align.CENTER, sort = 111)
	public String getCheshenwendingkongzhiEscEspDscdeng() {
		return cheshenwendingkongzhiEscEspDscdeng;
	}

	public void setCheshenwendingkongzhiEscEspDscdeng(String cheshenwendingkongzhiEscEspDscdeng) {
		this.cheshenwendingkongzhiEscEspDscdeng = cheshenwendingkongzhiEscEspDscdeng;
	}

	@ExcelField(title="并线辅助", align = ExcelField.Align.CENTER, sort = 112)
	public String getBingxianfuzhu() {
		return bingxianfuzhu;
	}

	public void setBingxianfuzhu(String bingxianfuzhu) {
		this.bingxianfuzhu = bingxianfuzhu;
	}

	@ExcelField(title="车道偏离预警系统", align = ExcelField.Align.CENTER, sort = 113)
	public String getChedaopianliyujingxitong() {
		return chedaopianliyujingxitong;
	}

	public void setChedaopianliyujingxitong(String chedaopianliyujingxitong) {
		this.chedaopianliyujingxitong = chedaopianliyujingxitong;
	}

	@ExcelField(title="车道保持辅助系统", align = ExcelField.Align.CENTER, sort = 114)
	public String getChedaobaochifuzhuxitong() {
		return chedaobaochifuzhuxitong;
	}

	public void setChedaobaochifuzhuxitong(String chedaobaochifuzhuxitong) {
		this.chedaobaochifuzhuxitong = chedaobaochifuzhuxitong;
	}

	@ExcelField(title="道路箭筒标志识别", align = ExcelField.Align.CENTER, sort = 115)
	public String getDaolujiaotongbiaozhishibie() {
		return daolujiaotongbiaozhishibie;
	}

	public void setDaolujiaotongbiaozhishibie(String daolujiaotongbiaozhishibie) {
		this.daolujiaotongbiaozhishibie = daolujiaotongbiaozhishibie;
	}

	@ExcelField(title="主动刹车主动安全系统", align = ExcelField.Align.CENTER, sort = 116)
	public String getZhudongshacheZhudonganquanxitong() {
		return zhudongshacheZhudonganquanxitong;
	}

	public void setZhudongshacheZhudonganquanxitong(String zhudongshacheZhudonganquanxitong) {
		this.zhudongshacheZhudonganquanxitong = zhudongshacheZhudonganquanxitong;
	}

	@ExcelField(title="夜视系统", align = ExcelField.Align.CENTER, sort = 117)
	public String getYeshixitong() {
		return yeshixitong;
	}

	public void setYeshixitong(String yeshixitong) {
		this.yeshixitong = yeshixitong;
	}

	@ExcelField(title="疲劳驾驶提示", align = ExcelField.Align.CENTER, sort = 118)
	public String getPilaojiashitishi() {
		return pilaojiashitishi;
	}

	public void setPilaojiashitishi(String pilaojiashitishi) {
		this.pilaojiashitishi = pilaojiashitishi;
	}

	@ExcelField(title="前后驻车雷达", align = ExcelField.Align.CENTER, sort = 119)
	public String getQianHouzhucheleida() {
		return qianHouzhucheleida;
	}

	public void setQianHouzhucheleida(String qianHouzhucheleida) {
		this.qianHouzhucheleida = qianHouzhucheleida;
	}

	@ExcelField(title="驾驶辅助影像", align = ExcelField.Align.CENTER, sort = 120)
	public String getJiashifuzhuyingxiang() {
		return jiashifuzhuyingxiang;
	}

	public void setJiashifuzhuyingxiang(String jiashifuzhuyingxiang) {
		this.jiashifuzhuyingxiang = jiashifuzhuyingxiang;
	}

	@ExcelField(title="倒车车侧预警系统", align = ExcelField.Align.CENTER, sort = 121)
	public String getDaochecheceyujingxitong() {
		return daochecheceyujingxitong;
	}

	public void setDaochecheceyujingxitong(String daochecheceyujingxitong) {
		this.daochecheceyujingxitong = daochecheceyujingxitong;
	}

	@ExcelField(title="巡航系统", align = ExcelField.Align.CENTER, sort = 122)
	public String getXunhangxitong() {
		return xunhangxitong;
	}

	public void setXunhangxitong(String xunhangxitong) {
		this.xunhangxitong = xunhangxitong;
	}

	@ExcelField(title="驾驶模式切换", align = ExcelField.Align.CENTER, sort = 123)
	public String getJiashimoshiqiehuan() {
		return jiashimoshiqiehuan;
	}

	public void setJiashimoshiqiehuan(String jiashimoshiqiehuan) {
		this.jiashimoshiqiehuan = jiashimoshiqiehuan;
	}

	@ExcelField(title="自动泊车入位", align = ExcelField.Align.CENTER, sort = 124)
	public String getZidongbocheruwei() {
		return zidongbocheruwei;
	}

	public void setZidongbocheruwei(String zidongbocheruwei) {
		this.zidongbocheruwei = zidongbocheruwei;
	}

	@ExcelField(title="发动机启停技术", align = ExcelField.Align.CENTER, sort = 125)
	public String getFadongjiqitingjishu() {
		return fadongjiqitingjishu;
	}

	public void setFadongjiqitingjishu(String fadongjiqitingjishu) {
		this.fadongjiqitingjishu = fadongjiqitingjishu;
	}

	@ExcelField(title="自动驻车", align = ExcelField.Align.CENTER, sort = 126)
	public String getZidongzhuche() {
		return zidongzhuche;
	}

	public void setZidongzhuche(String zidongzhuche) {
		this.zidongzhuche = zidongzhuche;
	}

	@ExcelField(title="上坡辅助", align = ExcelField.Align.CENTER, sort = 128)
	public String getShangpofuzhu() {
		return shangpofuzhu;
	}

	public void setShangpofuzhu(String shangpofuzhu) {
		this.shangpofuzhu = shangpofuzhu;
	}

	@ExcelField(title="陡坡缓降", align = ExcelField.Align.CENTER, sort = 129)
	public String getDoupohuanjiang() {
		return doupohuanjiang;
	}

	public void setDoupohuanjiang(String doupohuanjiang) {
		this.doupohuanjiang = doupohuanjiang;
	}

	@ExcelField(title="可变悬架功能", align = ExcelField.Align.CENTER, sort = 130)
	public String getKebianxuanjiagongneng() {
		return kebianxuanjiagongneng;
	}

	public void setKebianxuanjiagongneng(String kebianxuanjiagongneng) {
		this.kebianxuanjiagongneng = kebianxuanjiagongneng;
	}

	@ExcelField(title="空气悬架", align = ExcelField.Align.CENTER, sort = 131)
	public String getKongqixuanjia() {
		return kongqixuanjia;
	}

	public void setKongqixuanjia(String kongqixuanjia) {
		this.kongqixuanjia = kongqixuanjia;
	}

	@ExcelField(title="电磁感应悬架", align = ExcelField.Align.CENTER, sort = 132)
	public String getDianciganyingxuanjia() {
		return dianciganyingxuanjia;
	}

	public void setDianciganyingxuanjia(String dianciganyingxuanjia) {
		this.dianciganyingxuanjia = dianciganyingxuanjia;
	}

	@ExcelField(title="可变转向比", align = ExcelField.Align.CENTER, sort = 133)
	public String getKebianzhuanxiangbi() {
		return kebianzhuanxiangbi;
	}

	public void setKebianzhuanxiangbi(String kebianzhuanxiangbi) {
		this.kebianzhuanxiangbi = kebianzhuanxiangbi;
	}

	@ExcelField(title="中央差速器锁止功能", align = ExcelField.Align.CENTER, sort = 134)
	public String getZhongyangchasuqisuozhigongneng() {
		return zhongyangchasuqisuozhigongneng;
	}

	public void setZhongyangchasuqisuozhigongneng(String zhongyangchasuqisuozhigongneng) {
		this.zhongyangchasuqisuozhigongneng = zhongyangchasuqisuozhigongneng;
	}

	@ExcelField(title="整体主动转向系统", align = ExcelField.Align.CENTER, sort = 135)
	public String getZhengtizhudongzhuanxiangxitong() {
		return zhengtizhudongzhuanxiangxitong;
	}

	public void setZhengtizhudongzhuanxiangxitong(String zhengtizhudongzhuanxiangxitong) {
		this.zhengtizhudongzhuanxiangxitong = zhengtizhudongzhuanxiangxitong;
	}

	@ExcelField(title="限滑差速器差速锁", align = ExcelField.Align.CENTER, sort = 136)
	public String getXianhuachasuqiChasusuo() {
		return xianhuachasuqiChasusuo;
	}

	public void setXianhuachasuqiChasusuo(String xianhuachasuqiChasusuo) {
		this.xianhuachasuqiChasusuo = xianhuachasuqiChasusuo;
	}

	@ExcelField(title="涉水感应系统", align = ExcelField.Align.CENTER, sort = 137)
	public String getSheshuiganyingxitong() {
		return sheshuiganyingxitong;
	}

	public void setSheshuiganyingxitong(String sheshuiganyingxitong) {
		this.sheshuiganyingxitong = sheshuiganyingxitong;
	}

	@ExcelField(title="天窗类型", align = ExcelField.Align.CENTER, sort = 138)
	public String getTianchuangleixing() {
		return tianchuangleixing;
	}

	public void setTianchuangleixing(String tianchuangleixing) {
		this.tianchuangleixing = tianchuangleixing;
	}

	@ExcelField(title="运动外观套件", align = ExcelField.Align.CENTER, sort = 139)
	public String getYundongwaiguantaojian() {
		return yundongwaiguantaojian;
	}

	public void setYundongwaiguantaojian(String yundongwaiguantaojian) {
		this.yundongwaiguantaojian = yundongwaiguantaojian;
	}

	@ExcelField(title="轮圈材质", align = ExcelField.Align.CENTER, sort = 140)
	public String getLunquancaizhi() {
		return lunquancaizhi;
	}

	public void setLunquancaizhi(String lunquancaizhi) {
		this.lunquancaizhi = lunquancaizhi;
	}

	@ExcelField(title="电动吸合车门", align = ExcelField.Align.CENTER, sort = 141)
	public String getDiandongxihechemen() {
		return diandongxihechemen;
	}

	public void setDiandongxihechemen(String diandongxihechemen) {
		this.diandongxihechemen = diandongxihechemen;
	}

	@ExcelField(title="侧滑门形式", align = ExcelField.Align.CENTER, sort = 142)
	public String getCehuamenxingshi() {
		return cehuamenxingshi;
	}

	public void setCehuamenxingshi(String cehuamenxingshi) {
		this.cehuamenxingshi = cehuamenxingshi;
	}

	@ExcelField(title="电动后备箱", align = ExcelField.Align.CENTER, sort = 143)
	public String getDiandonghoubeixiang() {
		return diandonghoubeixiang;
	}

	public void setDiandonghoubeixiang(String diandonghoubeixiang) {
		this.diandonghoubeixiang = diandonghoubeixiang;
	}

	@ExcelField(title="感应后备箱", align = ExcelField.Align.CENTER, sort = 144)
	public String getGanyinghoubeixiang() {
		return ganyinghoubeixiang;
	}

	public void setGanyinghoubeixiang(String ganyinghoubeixiang) {
		this.ganyinghoubeixiang = ganyinghoubeixiang;
	}

	@ExcelField(title="电动后备厢位置记忆", align = ExcelField.Align.CENTER, sort = 145)
	public String getDiandonghoubeixiangweizhijiyi() {
		return diandonghoubeixiangweizhijiyi;
	}

	public void setDiandonghoubeixiangweizhijiyi(String diandonghoubeixiangweizhijiyi) {
		this.diandonghoubeixiangweizhijiyi = diandonghoubeixiangweizhijiyi;
	}

	@ExcelField(title="尾门玻璃独立开启", align = ExcelField.Align.CENTER, sort = 146)
	public String getWeimenbolidulikaiqi() {
		return weimenbolidulikaiqi;
	}

	public void setWeimenbolidulikaiqi(String weimenbolidulikaiqi) {
		this.weimenbolidulikaiqi = weimenbolidulikaiqi;
	}

	@ExcelField(title="车顶行李架", align = ExcelField.Align.CENTER, sort = 147)
	public String getChedingxinglijia() {
		return chedingxinglijia;
	}

	public void setChedingxinglijia(String chedingxinglijia) {
		this.chedingxinglijia = chedingxinglijia;
	}

	@ExcelField(title="发动机电子防盗", align = ExcelField.Align.CENTER, sort = 148)
	public String getFadongjidianzifangdao() {
		return fadongjidianzifangdao;
	}

	public void setFadongjidianzifangdao(String fadongjidianzifangdao) {
		this.fadongjidianzifangdao = fadongjidianzifangdao;
	}

	@ExcelField(title="车内中控锁", align = ExcelField.Align.CENTER, sort = 149)
	public String getCheneizhongkongsuo() {
		return cheneizhongkongsuo;
	}

	public void setCheneizhongkongsuo(String cheneizhongkongsuo) {
		this.cheneizhongkongsuo = cheneizhongkongsuo;
	}

	@ExcelField(title="要是类型", align = ExcelField.Align.CENTER, sort = 150)
	public String getYaoshileixing() {
		return yaoshileixing;
	}

	public void setYaoshileixing(String yaoshileixing) {
		this.yaoshileixing = yaoshileixing;
	}

	@ExcelField(title="无钥匙启动系统", align = ExcelField.Align.CENTER, sort = 151)
	public String getWuyaoshiqidongxitong() {
		return wuyaoshiqidongxitong;
	}

	public void setWuyaoshiqidongxitong(String wuyaoshiqidongxitong) {
		this.wuyaoshiqidongxitong = wuyaoshiqidongxitong;
	}

	@ExcelField(title="无钥匙进入功能", align = ExcelField.Align.CENTER, sort = 152)
	public String getWuyaoshijinrugongneng() {
		return wuyaoshijinrugongneng;
	}

	public void setWuyaoshijinrugongneng(String wuyaoshijinrugongneng) {
		this.wuyaoshijinrugongneng = wuyaoshijinrugongneng;
	}

	// 这个不知道是什么
	@ExcelField(title="主动闭合式进气格栅", align = ExcelField.Align.CENTER, sort = 153)
	public String getZhudongbiheshijinqigezha() {
		return zhudongbiheshijinqigezha;
	}

	public void setZhudongbiheshijinqigezha(String zhudongbiheshijinqigezha) {
		this.zhudongbiheshijinqigezha = zhudongbiheshijinqigezha;
	}

	@ExcelField(title="远程启动功能", align = ExcelField.Align.CENTER, sort = 154)
	public String getYuanchengqidonggongneng() {
		return yuanchengqidonggongneng;
	}

	public void setYuanchengqidonggongneng(String yuanchengqidonggongneng) {
		this.yuanchengqidonggongneng = yuanchengqidonggongneng;
	}

	@ExcelField(title="车侧脚踏板", align = ExcelField.Align.CENTER, sort = 155)
	public String getChecejiaotaban() {
		return checejiaotaban;
	}

	public void setChecejiaotaban(String checejiaotaban) {
		this.checejiaotaban = checejiaotaban;
	}

	@ExcelField(title="方向盘材质", align = ExcelField.Align.CENTER, sort = 156)
	public String getFangxiangpancaizhi() {
		return fangxiangpancaizhi;
	}

	public void setFangxiangpancaizhi(String fangxiangpancaizhi) {
		this.fangxiangpancaizhi = fangxiangpancaizhi;
	}

	@ExcelField(title="方向盘位置调节", align = ExcelField.Align.CENTER, sort = 157)
	public String getFangxiangpanweizhitiaojie() {
		return fangxiangpanweizhitiaojie;
	}

	public void setFangxiangpanweizhitiaojie(String fangxiangpanweizhitiaojie) {
		this.fangxiangpanweizhitiaojie = fangxiangpanweizhitiaojie;
	}

	@ExcelField(title="多功能方向盘", align = ExcelField.Align.CENTER, sort = 158)
	public String getDuogongnengfangxiangpan() {
		return duogongnengfangxiangpan;
	}

	public void setDuogongnengfangxiangpan(String duogongnengfangxiangpan) {
		this.duogongnengfangxiangpan = duogongnengfangxiangpan;
	}

	@ExcelField(title="方向盘换挡", align = ExcelField.Align.CENTER, sort = 159)
	public String getFangxiangpanhuandang() {
		return fangxiangpanhuandang;
	}

	public void setFangxiangpanhuandang(String fangxiangpanhuandang) {
		this.fangxiangpanhuandang = fangxiangpanhuandang;
	}

	@ExcelField(title="方向盘加热", align = ExcelField.Align.CENTER, sort = 160)
	public String getFangxiangpanjiare() {
		return fangxiangpanjiare;
	}

	public void setFangxiangpanjiare(String fangxiangpanjiare) {
		this.fangxiangpanjiare = fangxiangpanjiare;
	}

	@ExcelField(title="方向盘记忆", align = ExcelField.Align.CENTER, sort = 161)
	public String getFangxiangpanjiyi() {
		return fangxiangpanjiyi;
	}

	public void setFangxiangpanjiyi(String fangxiangpanjiyi) {
		this.fangxiangpanjiyi = fangxiangpanjiyi;
	}

	@ExcelField(title="行车电脑显示屏幕", align = ExcelField.Align.CENTER, sort = 162)
	public String getXingchediannaoxianshipingmu() {
		return xingchediannaoxianshipingmu;
	}

	public void setXingchediannaoxianshipingmu(String xingchediannaoxianshipingmu) {
		this.xingchediannaoxianshipingmu = xingchediannaoxianshipingmu;
	}

	@ExcelField(title="全液晶仪表盘", align = ExcelField.Align.CENTER, sort = 162)
	public String getQuanyejingyibiaopan() {
		return quanyejingyibiaopan;
	}

	public void setQuanyejingyibiaopan(String quanyejingyibiaopan) {
		this.quanyejingyibiaopan = quanyejingyibiaopan;
	}

	@ExcelField(title="液晶仪表(寸)", align = ExcelField.Align.CENTER, sort = 163)
	public String getYejingyibiaochicun() {
		return yejingyibiaochicun;
	}

	public void setYejingyibiaochicun(String yejingyibiaochicun) {
		this.yejingyibiaochicun = yejingyibiaochicun;
	}

	@ExcelField(title="hud抬头数字显示", align = ExcelField.Align.CENTER, sort = 164)
	public String getHudtaitoushuzixianshi() {
		return hudtaitoushuzixianshi;
	}

	public void setHudtaitoushuzixianshi(String hudtaitoushuzixianshi) {
		this.hudtaitoushuzixianshi = hudtaitoushuzixianshi;
	}

	@ExcelField(title="内置行车记录仪", align = ExcelField.Align.CENTER, sort = 165)
	public String getNeizhixingchejiluyi() {
		return neizhixingchejiluyi;
	}

	public void setNeizhixingchejiluyi(String neizhixingchejiluyi) {
		this.neizhixingchejiluyi = neizhixingchejiluyi;
	}

	@ExcelField(title="主动降噪", align = ExcelField.Align.CENTER, sort = 166)
	public String getZhudongjiangzao() {
		return zhudongjiangzao;
	}

	public void setZhudongjiangzao(String zhudongjiangzao) {
		this.zhudongjiangzao = zhudongjiangzao;
	}

	@ExcelField(title="手机无线充电功能", align = ExcelField.Align.CENTER, sort = 167)
	public String getShoujiwuxianchongdiangongneng() {
		return shoujiwuxianchongdiangongneng;
	}

	public void setShoujiwuxianchongdiangongneng(String shoujiwuxianchongdiangongneng) {
		this.shoujiwuxianchongdiangongneng = shoujiwuxianchongdiangongneng;
	}

	@ExcelField(title="电动可调踏板", align = ExcelField.Align.CENTER, sort = 168)
	public String getDiandongketiaotaban() {
		return diandongketiaotaban;
	}

	public void setDiandongketiaotaban(String diandongketiaotaban) {
		this.diandongketiaotaban = diandongketiaotaban;
	}

	@ExcelField(title="座椅材质", align = ExcelField.Align.CENTER, sort = 169)
	public String getZuoyicaizhi() {
		return zuoyicaizhi;
	}

	public void setZuoyicaizhi(String zuoyicaizhi) {
		this.zuoyicaizhi = zuoyicaizhi;
	}

	@ExcelField(title="运动风格座椅", align = ExcelField.Align.CENTER, sort = 170)
	public String getYundongfenggezuoyi() {
		return yundongfenggezuoyi;
	}

	public void setYundongfenggezuoyi(String yundongfenggezuoyi) {
		this.yundongfenggezuoyi = yundongfenggezuoyi;
	}

	@ExcelField(title="主座椅调节方式", align = ExcelField.Align.CENTER, sort = 171)
	public String getZhuzuoyitiaojiefangshi() {
		return zhuzuoyitiaojiefangshi;
	}

	public void setZhuzuoyitiaojiefangshi(String zhuzuoyitiaojiefangshi) {
		this.zhuzuoyitiaojiefangshi = zhuzuoyitiaojiefangshi;
	}

	@ExcelField(title="辅座椅调节方式", align = ExcelField.Align.CENTER, sort = 172)
	public String getFuzuoyitiaojiefangshi() {
		return fuzuoyitiaojiefangshi;
	}

	public void setFuzuoyitiaojiefangshi(String fuzuoyitiaojiefangshi) {
		this.fuzuoyitiaojiefangshi = fuzuoyitiaojiefangshi;
	}

	@ExcelField(title="主副驾驶座椅电动调节", align = ExcelField.Align.CENTER, sort = 173)
	public String getZhuFujiashizuodiandongtiaojie() {
		return zhuFujiashizuodiandongtiaojie;
	}

	public void setZhuFujiashizuodiandongtiaojie(String zhuFujiashizuodiandongtiaojie) {
		this.zhuFujiashizuodiandongtiaojie = zhuFujiashizuodiandongtiaojie;
	}

	@ExcelField(title="前排座椅功能", align = ExcelField.Align.CENTER, sort = 174)
	public String getQianpaizuoyigongneng() {
		return qianpaizuoyigongneng;
	}

	public void setQianpaizuoyigongneng(String qianpaizuoyigongneng) {
		this.qianpaizuoyigongneng = qianpaizuoyigongneng;
	}

	@ExcelField(title="电动座椅记忆功能", align = ExcelField.Align.CENTER, sort = 175)
	public String getDiandongzuoyijiyigongneng() {
		return diandongzuoyijiyigongneng;
	}

	public void setDiandongzuoyijiyigongneng(String diandongzuoyijiyigongneng) {
		this.diandongzuoyijiyigongneng = diandongzuoyijiyigongneng;
	}

	@ExcelField(title="副驾驶位后排可调节按钮", align = ExcelField.Align.CENTER, sort = 176)
	public String getFujiashiweihoupaiketiaojieanniu() {
		return fujiashiweihoupaiketiaojieanniu;
	}

	public void setFujiashiweihoupaiketiaojieanniu(String fujiashiweihoupaiketiaojieanniu) {
		this.fujiashiweihoupaiketiaojieanniu = fujiashiweihoupaiketiaojieanniu;
	}

	@ExcelField(title="第二排座椅调解", align = ExcelField.Align.CENTER, sort = 177)
	public String getDierpaizuoyitiaojie() {
		return dierpaizuoyitiaojie;
	}

	public void setDierpaizuoyitiaojie(String dierpaizuoyitiaojie) {
		this.dierpaizuoyitiaojie = dierpaizuoyitiaojie;
	}

	@ExcelField(title="后排座椅电动调节", align = ExcelField.Align.CENTER, sort = 178)
	public String getHoupaizuoyidiandongtiaojie() {
		return houpaizuoyidiandongtiaojie;
	}

	public void setHoupaizuoyidiandongtiaojie(String houpaizuoyidiandongtiaojie) {
		this.houpaizuoyidiandongtiaojie = houpaizuoyidiandongtiaojie;
	}

	@ExcelField(title="后排座椅功能", align = ExcelField.Align.CENTER, sort = 179)
	public String getHoupaizuoyigongneng() {
		return houpaizuoyigongneng;
	}

	public void setHoupaizuoyigongneng(String houpaizuoyigongneng) {
		this.houpaizuoyigongneng = houpaizuoyigongneng;
	}

	@ExcelField(title="后排小桌板", align = ExcelField.Align.CENTER, sort = 180)
	public String getHoupaixiaozhuoban() {
		return houpaixiaozhuoban;
	}

	public void setHoupaixiaozhuoban(String houpaixiaozhuoban) {
		this.houpaixiaozhuoban = houpaixiaozhuoban;
	}

	@ExcelField(title="第二排独立座椅", align = ExcelField.Align.CENTER, sort = 179)
	public String getDierpaidulizuoyi() {
		return dierpaidulizuoyi;
	}

	public void setDierpaidulizuoyi(String dierpaidulizuoyi) {
		this.dierpaidulizuoyi = dierpaidulizuoyi;
	}

	@ExcelField(title="座椅布局", align = ExcelField.Align.CENTER, sort = 180)
	public String getZuoyibuju() {
		return zuoyibuju;
	}

	public void setZuoyibuju(String zuoyibuju) {
		this.zuoyibuju = zuoyibuju;
	}

	@ExcelField(title="后排座椅放倒形式", align = ExcelField.Align.CENTER, sort = 181)
	public String getHoupaizuoyifangdaoxingshi() {
		return houpaizuoyifangdaoxingshi;
	}

	public void setHoupaizuoyifangdaoxingshi(String houpaizuoyifangdaoxingshi) {
		this.houpaizuoyifangdaoxingshi = houpaizuoyifangdaoxingshi;
	}

	@ExcelField(title="后排座椅电动放倒", align = ExcelField.Align.CENTER, sort = 182)
	public String getHoupaizuoyidiandongfangdao() {
		return houpaizuoyidiandongfangdao;
	}

	public void setHoupaizuoyidiandongfangdao(String houpaizuoyidiandongfangdao) {
		this.houpaizuoyidiandongfangdao = houpaizuoyidiandongfangdao;
	}

	@ExcelField(title="前后中央负数", align = ExcelField.Align.CENTER, sort = 183)
	public String getQianHouzhongyangfushou() {
		return qianHouzhongyangfushou;
	}

	public void setQianHouzhongyangfushou(String qianHouzhongyangfushou) {
		this.qianHouzhongyangfushou = qianHouzhongyangfushou;
	}

	@ExcelField(title="后排杯架", align = ExcelField.Align.CENTER, sort = 184)
	public String getHoupaibeijia() {
		return houpaibeijia;
	}

	public void setHoupaibeijia(String houpaibeijia) {
		this.houpaibeijia = houpaibeijia;
	}

	@ExcelField(title="加热之类杯架", align = ExcelField.Align.CENTER, sort = 185)
	public String getJiareZhilengbeijia() {
		return jiareZhilengbeijia;
	}

	public void setJiareZhilengbeijia(String jiareZhilengbeijia) {
		this.jiareZhilengbeijia = jiareZhilengbeijia;
	}

	@ExcelField(title="中控彩色液晶屏幕", align = ExcelField.Align.CENTER, sort = 186)
	public String getZhongkongcaiseyejingpingmu() {
		return zhongkongcaiseyejingpingmu;
	}

	public void setZhongkongcaiseyejingpingmu(String zhongkongcaiseyejingpingmu) {
		this.zhongkongcaiseyejingpingmu = zhongkongcaiseyejingpingmu;
	}

	@ExcelField(title="中液晶屏尺寸", align = ExcelField.Align.CENTER, sort = 187)
	public String getZhongkongyejingpingchicun() {
		return zhongkongyejingpingchicun;
	}

	public void setZhongkongyejingpingchicun(String zhongkongyejingpingchicun) {
		this.zhongkongyejingpingchicun = zhongkongyejingpingchicun;
	}

	@ExcelField(title="GPS导航系统", align = ExcelField.Align.CENTER, sort = 188)
	public String getGpsdaohangxitong() {
		return gpsdaohangxitong;
	}

	public void setGpsdaohangxitong(String gpsdaohangxitong) {
		this.gpsdaohangxitong = gpsdaohangxitong;
	}

	@ExcelField(title="导航路况信息显示", align = ExcelField.Align.CENTER, sort = 189)
	public String getDaohanglukuangxinxixianshi() {
		return daohanglukuangxinxixianshi;
	}

	public void setDaohanglukuangxinxixianshi(String daohanglukuangxinxixianshi) {
		this.daohanglukuangxinxixianshi = daohanglukuangxinxixianshi;
	}

	@ExcelField(title="道路救援呼叫", align = ExcelField.Align.CENTER, sort = 190)
	public String getDaolujiuyuanhujiao() {
		return daolujiuyuanhujiao;
	}

	public void setDaolujiuyuanhujiao(String daolujiuyuanhujiao) {
		this.daolujiuyuanhujiao = daolujiuyuanhujiao;
	}

	@ExcelField(title="中控液晶屏分屏显示", align = ExcelField.Align.CENTER, sort = 191)
	public String getZhongkongyejingpingfenpingxianshi() {
		return zhongkongyejingpingfenpingxianshi;
	}

	public void setZhongkongyejingpingfenpingxianshi(String zhongkongyejingpingfenpingxianshi) {
		this.zhongkongyejingpingfenpingxianshi = zhongkongyejingpingfenpingxianshi;
	}

	@ExcelField(title="蓝牙车载电话", align = ExcelField.Align.CENTER, sort = 192)
	public String getLanyaChezaidianhua() {
		return lanyaChezaidianhua;
	}

	public void setLanyaChezaidianhua(String lanyaChezaidianhua) {
		this.lanyaChezaidianhua = lanyaChezaidianhua;
	}

	@ExcelField(title="手机互联映射", align = ExcelField.Align.CENTER, sort = 193)
	public String getShoujihulianYingshe() {
		return shoujihulianYingshe;
	}

	public void setShoujihulianYingshe(String shoujihulianYingshe) {
		this.shoujihulianYingshe = shoujihulianYingshe;
	}

	@ExcelField(title="语音识别控制系统", align = ExcelField.Align.CENTER, sort = 194)
	public String getYuyinshibiekongzhixitong() {
		return yuyinshibiekongzhixitong;
	}

	public void setYuyinshibiekongzhixitong(String yuyinshibiekongzhixitong) {
		this.yuyinshibiekongzhixitong = yuyinshibiekongzhixitong;
	}

	@ExcelField(title="手势控制", align = ExcelField.Align.CENTER, sort = 195)
	public String getShoushikongzhi() {
		return shoushikongzhi;
	}

	public void setShoushikongzhi(String shoushikongzhi) {
		this.shoushikongzhi = shoushikongzhi;
	}

	@ExcelField(title="车联网", align = ExcelField.Align.CENTER, sort = 196)
	public String getChelianwang() {
		return chelianwang;
	}

	public void setChelianwang(String chelianwang) {
		this.chelianwang = chelianwang;
	}

	@ExcelField(title="车载电视", align = ExcelField.Align.CENTER, sort = 197)
	public String getChezaidianshi() {
		return chezaidianshi;
	}

	public void setChezaidianshi(String chezaidianshi) {
		this.chezaidianshi = chezaidianshi;
	}

	@ExcelField(title="后排液晶屏幕", align = ExcelField.Align.CENTER, sort = 198)
	public String getHoupaiyejingpingmu() {
		return houpaiyejingpingmu;
	}

	public void setHoupaiyejingpingmu(String houpaiyejingpingmu) {
		this.houpaiyejingpingmu = houpaiyejingpingmu;
	}

	@ExcelField(title="后排控制多媒体", align = ExcelField.Align.CENTER, sort = 199)
	public String getHoupaikongzhiduomeiti() {
		return houpaikongzhiduomeiti;
	}

	public void setHoupaikongzhiduomeiti(String houpaikongzhiduomeiti) {
		this.houpaikongzhiduomeiti = houpaikongzhiduomeiti;
	}

	@ExcelField(title="外接音源接口类型", align = ExcelField.Align.CENTER, sort = 200)
	public String getWaijieyinyuanjiekouleixing() {
		return waijieyinyuanjiekouleixing;
	}

	public void setWaijieyinyuanjiekouleixing(String waijieyinyuanjiekouleixing) {
		this.waijieyinyuanjiekouleixing = waijieyinyuanjiekouleixing;
	}

	@ExcelField(title="USB-typec接口数量", align = ExcelField.Align.CENTER, sort = 201)
	public String getUsbTypeCjiekoushuliang() {
		return usbTypeCjiekoushuliang;
	}

	public void setUsbTypeCjiekoushuliang(String usbTypeCjiekoushuliang) {
		this.usbTypeCjiekoushuliang = usbTypeCjiekoushuliang;
	}

	@ExcelField(title="车载CD/DVD", align = ExcelField.Align.CENTER, sort = 202)
	public String getChezaicdDvd() {
		return chezaicdDvd;
	}

	public void setChezaicdDvd(String chezaicdDvd) {
		this.chezaicdDvd = chezaicdDvd;
	}

	@ExcelField(title="电源220V/230V", align = ExcelField.Align.CENTER, sort = 203)
	public String getDianyuan220v230v() {
		return dianyuan220v230v;
	}

	public void setDianyuan220v230v(String dianyuan220v230v) {
		this.dianyuan220v230v = dianyuan220v230v;
	}

	@ExcelField(title="行李箱12V电源接口", align = ExcelField.Align.CENTER, sort = 204)
	public String getXinglixiang12vdianyuanjiekou() {
		return xinglixiang12vdianyuanjiekou;
	}

	public void setXinglixiang12vdianyuanjiekou(String xinglixiang12vdianyuanjiekou) {
		this.xinglixiang12vdianyuanjiekou = xinglixiang12vdianyuanjiekou;
	}

	@ExcelField(title="扬声器品牌名称", align = ExcelField.Align.CENTER, sort = 205)
	public String getYangshengqipinpaimingcheng() {
		return yangshengqipinpaimingcheng;
	}

	public void setYangshengqipinpaimingcheng(String yangshengqipinpaimingcheng) {
		this.yangshengqipinpaimingcheng = yangshengqipinpaimingcheng;
	}

	@ExcelField(title="扬声器数量", align = ExcelField.Align.CENTER, sort = 206)
	public String getYangshengqishuliang() {
		return yangshengqishuliang;
	}

	public void setYangshengqishuliang(String yangshengqishuliang) {
		this.yangshengqishuliang = yangshengqishuliang;
	}

	@ExcelField(title="近光灯光源", align = ExcelField.Align.CENTER, sort = 207)
	public String getJinguangdengguangyuan() {
		return jinguangdengguangyuan;
	}

	public void setJinguangdengguangyuan(String jinguangdengguangyuan) {
		this.jinguangdengguangyuan = jinguangdengguangyuan;
	}

	@ExcelField(title="远光灯光源", align = ExcelField.Align.CENTER, sort = 208)
	public String getYuanguangdengguangyuan() {
		return yuanguangdengguangyuan;
	}

	public void setYuanguangdengguangyuan(String yuanguangdengguangyuan) {
		this.yuanguangdengguangyuan = yuanguangdengguangyuan;
	}

	@ExcelField(title="灯光特色功能", align = ExcelField.Align.CENTER, sort = 209)
	public String getDengguangtesegongneng() {
		return dengguangtesegongneng;
	}

	public void setDengguangtesegongneng(String dengguangtesegongneng) {
		this.dengguangtesegongneng = dengguangtesegongneng;
	}

	@ExcelField(title="LED日间行车灯", align = ExcelField.Align.CENTER, sort = 210)
	public String getLedrijianxingchedeng() {
		return ledrijianxingchedeng;
	}

	public void setLedrijianxingchedeng(String ledrijianxingchedeng) {
		this.ledrijianxingchedeng = ledrijianxingchedeng;
	}

	@ExcelField(title="自适应远近光", align = ExcelField.Align.CENTER, sort = 211)
	public String getZishiyingyuanjinguang() {
		return zishiyingyuanjinguang;
	}

	public void setZishiyingyuanjinguang(String zishiyingyuanjinguang) {
		this.zishiyingyuanjinguang = zishiyingyuanjinguang;
	}

	@ExcelField(title="自动头灯", align = ExcelField.Align.CENTER, sort = 212)
	public String getZidongtoudeng() {
		return zidongtoudeng;
	}

	public void setZidongtoudeng(String zidongtoudeng) {
		this.zidongtoudeng = zidongtoudeng;
	}

	@ExcelField(title="转向辅助灯", align = ExcelField.Align.CENTER, sort = 213)
	public String getZhuanxiangfuzhudeng() {
		return zhuanxiangfuzhudeng;
	}

	public void setZhuanxiangfuzhudeng(String zhuanxiangfuzhudeng) {
		this.zhuanxiangfuzhudeng = zhuanxiangfuzhudeng;
	}

	@ExcelField(title="转向头灯", align = ExcelField.Align.CENTER, sort = 214)
	public String getZhuanxiangtoudeng() {
		return zhuanxiangtoudeng;
	}

	public void setZhuanxiangtoudeng(String zhuanxiangtoudeng) {
		this.zhuanxiangtoudeng = zhuanxiangtoudeng;
	}

	@ExcelField(title="车前雾灯", align = ExcelField.Align.CENTER, sort = 215)
	public String getCheqianwudeng() {
		return cheqianwudeng;
	}

	public void setCheqianwudeng(String cheqianwudeng) {
		this.cheqianwudeng = cheqianwudeng;
	}

	@ExcelField(title="前大灯雨雾模式", align = ExcelField.Align.CENTER, sort = 216)
	public String getQiandadengyuwumoshi() {
		return qiandadengyuwumoshi;
	}

	public void setQiandadengyuwumoshi(String qiandadengyuwumoshi) {
		this.qiandadengyuwumoshi = qiandadengyuwumoshi;
	}

	@ExcelField(title="大灯高度可调", align = ExcelField.Align.CENTER, sort = 217)
	public String getDadenggaoduketiao() {
		return dadenggaoduketiao;
	}

	public void setDadenggaoduketiao(String dadenggaoduketiao) {
		this.dadenggaoduketiao = dadenggaoduketiao;
	}

	@ExcelField(title="大灯清洗装置", align = ExcelField.Align.CENTER, sort = 218)
	public String getDadengqingxizhuangzhi() {
		return dadengqingxizhuangzhi;
	}

	public void setDadengqingxizhuangzhi(String dadengqingxizhuangzhi) {
		this.dadengqingxizhuangzhi = dadengqingxizhuangzhi;
	}

	@ExcelField(title="大灯延时关闭", align = ExcelField.Align.CENTER, sort = 219)
	public String getDadengyanshiguanbi() {
		return dadengyanshiguanbi;
	}

	public void setDadengyanshiguanbi(String dadengyanshiguanbi) {
		this.dadengyanshiguanbi = dadengyanshiguanbi;
	}

	@ExcelField(title="触摸式阅读灯", align = ExcelField.Align.CENTER, sort = 220)
	public String getChumoshiyuedudeng() {
		return chumoshiyuedudeng;
	}

	public void setChumoshiyuedudeng(String chumoshiyuedudeng) {
		this.chumoshiyuedudeng = chumoshiyuedudeng;
	}

	@ExcelField(title="车内环境氛围灯", align = ExcelField.Align.CENTER, sort = 221)
	public String getCheneihuanjingfenweideng() {
		return cheneihuanjingfenweideng;
	}

	public void setCheneihuanjingfenweideng(String cheneihuanjingfenweideng) {
		this.cheneihuanjingfenweideng = cheneihuanjingfenweideng;
	}

	@ExcelField(title="前后电动车窗", align = ExcelField.Align.CENTER, sort = 222)
	public String getQianHoudiandongchechuang() {
		return qianHoudiandongchechuang;
	}

	public void setQianHoudiandongchechuang(String qianHoudiandongchechuang) {
		this.qianHoudiandongchechuang = qianHoudiandongchechuang;
	}

	@ExcelField(title="车窗一键升降功能", align = ExcelField.Align.CENTER, sort = 223)
	public String getChechuangyijianshengjianggongneng() {
		return chechuangyijianshengjianggongneng;
	}

	public void setChechuangyijianshengjianggongneng(String chechuangyijianshengjianggongneng) {
		this.chechuangyijianshengjianggongneng = chechuangyijianshengjianggongneng;
	}

	@ExcelField(title="车窗防夹手功能", align = ExcelField.Align.CENTER, sort = 224)
	public String getChechuangfangjiashougongneng() {
		return chechuangfangjiashougongneng;
	}

	public void setChechuangfangjiashougongneng(String chechuangfangjiashougongneng) {
		this.chechuangfangjiashougongneng = chechuangfangjiashougongneng;
	}

	@ExcelField(title="防紫外线玻璃", align = ExcelField.Align.CENTER, sort = 225)
	public String getFangziwaixianboli() {
		return fangziwaixianboli;
	}

	public void setFangziwaixianboli(String fangziwaixianboli) {
		this.fangziwaixianboli = fangziwaixianboli;
	}

	@ExcelField(title="多层隔音玻璃", align = ExcelField.Align.CENTER, sort = 226)
	public String getDuocenggeyinboli() {
		return duocenggeyinboli;
	}

	public void setDuocenggeyinboli(String duocenggeyinboli) {
		this.duocenggeyinboli = duocenggeyinboli;
	}

	@ExcelField(title="外后视镜功能", align = ExcelField.Align.CENTER, sort = 227)
	public String getWaihoushijinggongneng() {
		return waihoushijinggongneng;
	}

	public void setWaihoushijinggongneng(String waihoushijinggongneng) {
		this.waihoushijinggongneng = waihoushijinggongneng;
	}

	@ExcelField(title="内后视镜功能", align = ExcelField.Align.CENTER, sort = 228)
	public String getNeihoushijinggongneng() {
		return neihoushijinggongneng;
	}

	public void setNeihoushijinggongneng(String neihoushijinggongneng) {
		this.neihoushijinggongneng = neihoushijinggongneng;
	}

	@ExcelField(title="后风挡遮阳帘", align = ExcelField.Align.CENTER, sort = 229)
	public String getHoufengdangzheyanglian() {
		return houfengdangzheyanglian;
	}

	public void setHoufengdangzheyanglian(String houfengdangzheyanglian) {
		this.houfengdangzheyanglian = houfengdangzheyanglian;
	}

	@ExcelField(title="后排侧窗遮阳帘", align = ExcelField.Align.CENTER, sort = 230)
	public String getHoupaicechuangzheyanglian() {
		return houpaicechuangzheyanglian;
	}

	public void setHoupaicechuangzheyanglian(String houpaicechuangzheyanglian) {
		this.houpaicechuangzheyanglian = houpaicechuangzheyanglian;
	}

	@ExcelField(title="后排侧隐私玻璃", align = ExcelField.Align.CENTER, sort = 231)
	public String getHoupaiceyinsiboli() {
		return houpaiceyinsiboli;
	}

	public void setHoupaiceyinsiboli(String houpaiceyinsiboli) {
		this.houpaiceyinsiboli = houpaiceyinsiboli;
	}

	@ExcelField(title="车内化妆镜", align = ExcelField.Align.CENTER, sort = 232)
	public String getCheneihuazhuangjing() {
		return cheneihuazhuangjing;
	}

	public void setCheneihuazhuangjing(String cheneihuazhuangjing) {
		this.cheneihuazhuangjing = cheneihuazhuangjing;
	}

	@ExcelField(title="后雨刷", align = ExcelField.Align.CENTER, sort = 233)
	public String getHouyushua() {
		return houyushua;
	}

	public void setHouyushua(String houyushua) {
		this.houyushua = houyushua;
	}

	@ExcelField(title="感应雨刷功能", align = ExcelField.Align.CENTER, sort = 234)
	public String getGanyingyushuagongneng() {
		return ganyingyushuagongneng;
	}

	public void setGanyingyushuagongneng(String ganyingyushuagongneng) {
		this.ganyingyushuagongneng = ganyingyushuagongneng;
	}

	@ExcelField(title="可加热喷水嘴", align = ExcelField.Align.CENTER, sort = 235)
	public String getKejiarepenshuizui() {
		return kejiarepenshuizui;
	}

	public void setKejiarepenshuizui(String kejiarepenshuizui) {
		this.kejiarepenshuizui = kejiarepenshuizui;
	}

	@ExcelField(title="空调温度控制方式", align = ExcelField.Align.CENTER, sort = 236)
	public String getKongtiaowendukongzhifangshi() {
		return kongtiaowendukongzhifangshi;
	}

	public void setKongtiaowendukongzhifangshi(String kongtiaowendukongzhifangshi) {
		this.kongtiaowendukongzhifangshi = kongtiaowendukongzhifangshi;
	}

	@ExcelField(title="后排独立空调", align = ExcelField.Align.CENTER, sort = 237)
	public String getHoupaidulikongtiao() {
		return houpaidulikongtiao;
	}

	public void setHoupaidulikongtiao(String houpaidulikongtiao) {
		this.houpaidulikongtiao = houpaidulikongtiao;
	}

	@ExcelField(title="后做出风口", align = ExcelField.Align.CENTER, sort = 238)
	public String getHouzuochufengkou() {
		return houzuochufengkou;
	}

	public void setHouzuochufengkou(String houzuochufengkou) {
		this.houzuochufengkou = houzuochufengkou;
	}

	@ExcelField(title="温度分区控制", align = ExcelField.Align.CENTER, sort = 239)
	public String getWendufenqukongzhi() {
		return wendufenqukongzhi;
	}

	public void setWendufenqukongzhi(String wendufenqukongzhi) {
		this.wendufenqukongzhi = wendufenqukongzhi;
	}

	@ExcelField(title="车载控制器净化器", align = ExcelField.Align.CENTER, sort = 240)
	public String getChezaikongqijinghuaqi() {
		return chezaikongqijinghuaqi;
	}

	public void setChezaikongqijinghuaqi(String chezaikongqijinghuaqi) {
		this.chezaikongqijinghuaqi = chezaikongqijinghuaqi;
	}

	@ExcelField(title="车内PM2.5过滤装置", align = ExcelField.Align.CENTER, sort = 241)
	public String getCheneipm25guolvzhuangzhi() {
		return cheneipm25guolvzhuangzhi;
	}

	public void setCheneipm25guolvzhuangzhi(String cheneipm25guolvzhuangzhi) {
		this.cheneipm25guolvzhuangzhi = cheneipm25guolvzhuangzhi;
	}

	@ExcelField(title="负离子发生器", align = ExcelField.Align.CENTER, sort = 242)
	public String getFulizifashengqi() {
		return fulizifashengqi;
	}

	public void setFulizifashengqi(String fulizifashengqi) {
		this.fulizifashengqi = fulizifashengqi;
	}

	@ExcelField(title="车内香氛装置", align = ExcelField.Align.CENTER, sort = 243)
	public String getCheneixiangfenzhuangzhi() {
		return cheneixiangfenzhuangzhi;
	}

	public void setCheneixiangfenzhuangzhi(String cheneixiangfenzhuangzhi) {
		this.cheneixiangfenzhuangzhi = cheneixiangfenzhuangzhi;
	}

	@ExcelField(title="车载冰箱", align = ExcelField.Align.CENTER, sort = 244)
	public String getChezaibingxiang() {
		return chezaibingxiang;
	}

	public void setChezaibingxiang(String chezaibingxiang) {
		this.chezaibingxiang = chezaibingxiang;
	}

	@ExcelField(title="选装包", align = ExcelField.Align.CENTER, sort = 245)
	public String getXuanzhuangbao() {
		return xuanzhuangbao;
	}

	public void setXuanzhuangbao(String xuanzhuangbao) {
		this.xuanzhuangbao = xuanzhuangbao;
	}

	@ExcelField(title="外观颜色", align = ExcelField.Align.CENTER, sort = 246)
	public String getWaiguanyanse() {
		return waiguanyanse;
	}

	public void setWaiguanyanse(String waiguanyanse) {
		this.waiguanyanse = waiguanyanse;
	}

	@ExcelField(title="内饰颜色", align = ExcelField.Align.CENTER, sort = 247)
	public String getNeishiyanse() {
		return neishiyanse;
	}

	public void setNeishiyanse(String neishiyanse) {
		this.neishiyanse = neishiyanse;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
}