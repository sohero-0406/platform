/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 车辆配置全表Entity
 * @author chenlitao
 * @version 2019-07-04
 */
@Table(name="common_vehicle_info", alias="a", columns={
		@Column(name="id", attrName="id", label="主键，车辆配置全表", isPK=true),
		@Column(name="shouzimu", attrName="shouzimu", label="shouzimu"),
		@Column(name="pinpai", attrName="pinpai", label="pinpai"),
		@Column(name="pinpai_id", attrName="pinpaiId", label="pinpai_id"),
		@Column(name="pinpai_logo", attrName="pinpaiLogo", label="pinpai_logo"),
		@Column(name="chexi", attrName="chexi", label="chexi"),
		@Column(name="chexi_id", attrName="chexiId", label="chexi_id"),
		@Column(name="chexizhanshitu", attrName="chexizhanshitu", label="chexizhanshitu"),
		@Column(name="chexingmingcheng", attrName="chexingmingcheng", label="chexingmingcheng"),
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
	
	public VehicleInfo() {
		this(null);
	}

	public VehicleInfo(String id){
		super(id);
	}
	
	public String getShouzimu() {
		return shouzimu;
	}

	public void setShouzimu(String shouzimu) {
		this.shouzimu = shouzimu;
	}
	
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
	
	public String getPinpaiLogo() {
		return pinpaiLogo;
	}

	public void setPinpaiLogo(String pinpaiLogo) {
		this.pinpaiLogo = pinpaiLogo;
	}
	
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
	
	public String getChexizhanshitu() {
		return chexizhanshitu;
	}

	public void setChexizhanshitu(String chexizhanshitu) {
		this.chexizhanshitu = chexizhanshitu;
	}
	
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
	
	public String getXiaoshouzhuangtai() {
		return xiaoshouzhuangtai;
	}

	public void setXiaoshouzhuangtai(String xiaoshouzhuangtai) {
		this.xiaoshouzhuangtai = xiaoshouzhuangtai;
	}
	
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
	
	public String getNiankuan() {
		return niankuan;
	}

	public void setNiankuan(String niankuan) {
		this.niankuan = niankuan;
	}
	
	public String getGengxinshijian() {
		return gengxinshijian;
	}

	public void setGengxinshijian(String gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	
	public String getShangshishijian() {
		return shangshishijian;
	}

	public void setShangshishijian(String shangshishijian) {
		this.shangshishijian = shangshishijian;
	}
	
	public String getChangshangzhidaojia() {
		return changshangzhidaojia;
	}

	public void setChangshangzhidaojia(String changshangzhidaojia) {
		this.changshangzhidaojia = changshangzhidaojia;
	}
	
	public String getChangshangzhidaojiaYuan() {
		return changshangzhidaojiaYuan;
	}

	public void setChangshangzhidaojiaYuan(String changshangzhidaojiaYuan) {
		this.changshangzhidaojiaYuan = changshangzhidaojiaYuan;
	}
	
	public String getJibie() {
		return jibie;
	}

	public void setJibie(String jibie) {
		this.jibie = jibie;
	}
	
	public String getNengyuanleixing() {
		return nengyuanleixing;
	}

	public void setNengyuanleixing(String nengyuanleixing) {
		this.nengyuanleixing = nengyuanleixing;
	}
	
	public String getGongxinbuchundianxuhanglichengKm() {
		return gongxinbuchundianxuhanglichengKm;
	}

	public void setGongxinbuchundianxuhanglichengKm(String gongxinbuchundianxuhanglichengKm) {
		this.gongxinbuchundianxuhanglichengKm = gongxinbuchundianxuhanglichengKm;
	}
	
	public String getKuaichongshijianXiaoshi() {
		return kuaichongshijianXiaoshi;
	}

	public void setKuaichongshijianXiaoshi(String kuaichongshijianXiaoshi) {
		this.kuaichongshijianXiaoshi = kuaichongshijianXiaoshi;
	}
	
	public String getManchongshijianXiaoshi() {
		return manchongshijianXiaoshi;
	}

	public void setManchongshijianXiaoshi(String manchongshijianXiaoshi) {
		this.manchongshijianXiaoshi = manchongshijianXiaoshi;
	}
	
	public String getKuaichongdianliangbaifenbi() {
		return kuaichongdianliangbaifenbi;
	}

	public void setKuaichongdianliangbaifenbi(String kuaichongdianliangbaifenbi) {
		this.kuaichongdianliangbaifenbi = kuaichongdianliangbaifenbi;
	}
	
	public String getZuidagonglvKw() {
		return zuidagonglvKw;
	}

	public void setZuidagonglvKw(String zuidagonglvKw) {
		this.zuidagonglvKw = zuidagonglvKw;
	}
	
	public String getZuidaniujuNM() {
		return zuidaniujuNM;
	}

	public void setZuidaniujuNM(String zuidaniujuNM) {
		this.zuidaniujuNM = zuidaniujuNM;
	}
	
	public String getFadongji() {
		return fadongji;
	}

	public void setFadongji(String fadongji) {
		this.fadongji = fadongji;
	}
	
	public String getBiansuxiang() {
		return biansuxiang;
	}

	public void setBiansuxiang(String biansuxiang) {
		this.biansuxiang = biansuxiang;
	}
	
	public String getChangkuangaoMm() {
		return changkuangaoMm;
	}

	public void setChangkuangaoMm(String changkuangaoMm) {
		this.changkuangaoMm = changkuangaoMm;
	}
	
	public String getCheshenjiegou() {
		return cheshenjiegou;
	}

	public void setCheshenjiegou(String cheshenjiegou) {
		this.cheshenjiegou = cheshenjiegou;
	}
	
	public String getZuigaochesuKmH() {
		return zuigaochesuKmH;
	}

	public void setZuigaochesuKmH(String zuigaochesuKmH) {
		this.zuigaochesuKmH = zuigaochesuKmH;
	}
	
	public String getGuanfang0100kmHJiasuS() {
		return guanfang0100kmHJiasuS;
	}

	public void setGuanfang0100kmHJiasuS(String guanfang0100kmHJiasuS) {
		this.guanfang0100kmHJiasuS = guanfang0100kmHJiasuS;
	}
	
	public String getShice0100kmHJiasuS() {
		return shice0100kmHJiasuS;
	}

	public void setShice0100kmHJiasuS(String shice0100kmHJiasuS) {
		this.shice0100kmHJiasuS = shice0100kmHJiasuS;
	}
	
	public String getShice1000kmHZhidongM() {
		return shice1000kmHZhidongM;
	}

	public void setShice1000kmHZhidongM(String shice1000kmHZhidongM) {
		this.shice1000kmHZhidongM = shice1000kmHZhidongM;
	}
	
	public String getShicexuhanglichengKm() {
		return shicexuhanglichengKm;
	}

	public void setShicexuhanglichengKm(String shicexuhanglichengKm) {
		this.shicexuhanglichengKm = shicexuhanglichengKm;
	}
	
	public String getGongxinbuzongheyouhaoL100km() {
		return gongxinbuzongheyouhaoL100km;
	}

	public void setGongxinbuzongheyouhaoL100km(String gongxinbuzongheyouhaoL100km) {
		this.gongxinbuzongheyouhaoL100km = gongxinbuzongheyouhaoL100km;
	}
	
	public String getShiceyouhaoL100km() {
		return shiceyouhaoL100km;
	}

	public void setShiceyouhaoL100km(String shiceyouhaoL100km) {
		this.shiceyouhaoL100km = shiceyouhaoL100km;
	}
	
	public String getZhengchezhibao() {
		return zhengchezhibao;
	}

	public void setZhengchezhibao(String zhengchezhibao) {
		this.zhengchezhibao = zhengchezhibao;
	}
	
	public String getChangduMm() {
		return changduMm;
	}

	public void setChangduMm(String changduMm) {
		this.changduMm = changduMm;
	}
	
	public String getKuanduMm() {
		return kuanduMm;
	}

	public void setKuanduMm(String kuanduMm) {
		this.kuanduMm = kuanduMm;
	}
	
	public String getGaoduMm() {
		return gaoduMm;
	}

	public void setGaoduMm(String gaoduMm) {
		this.gaoduMm = gaoduMm;
	}
	
	public String getZhoujuMm() {
		return zhoujuMm;
	}

	public void setZhoujuMm(String zhoujuMm) {
		this.zhoujuMm = zhoujuMm;
	}
	
	public String getQianlunjuMm() {
		return qianlunjuMm;
	}

	public void setQianlunjuMm(String qianlunjuMm) {
		this.qianlunjuMm = qianlunjuMm;
	}
	
	public String getHoulunjuMm() {
		return houlunjuMm;
	}

	public void setHoulunjuMm(String houlunjuMm) {
		this.houlunjuMm = houlunjuMm;
	}
	
	public String getZuixiaolidijianxiMm() {
		return zuixiaolidijianxiMm;
	}

	public void setZuixiaolidijianxiMm(String zuixiaolidijianxiMm) {
		this.zuixiaolidijianxiMm = zuixiaolidijianxiMm;
	}
	
	public String getChemenshuGe() {
		return chemenshuGe;
	}

	public void setChemenshuGe(String chemenshuGe) {
		this.chemenshuGe = chemenshuGe;
	}
	
	public String getZuoweishuGe() {
		return zuoweishuGe;
	}

	public void setZuoweishuGe(String zuoweishuGe) {
		this.zuoweishuGe = zuoweishuGe;
	}
	
	public String getYouxiangrongjiL() {
		return youxiangrongjiL;
	}

	public void setYouxiangrongjiL(String youxiangrongjiL) {
		this.youxiangrongjiL = youxiangrongjiL;
	}
	
	public String getXinglixiangrongjiL() {
		return xinglixiangrongjiL;
	}

	public void setXinglixiangrongjiL(String xinglixiangrongjiL) {
		this.xinglixiangrongjiL = xinglixiangrongjiL;
	}
	
	public String getZhengbeizhiliangKg() {
		return zhengbeizhiliangKg;
	}

	public void setZhengbeizhiliangKg(String zhengbeizhiliangKg) {
		this.zhengbeizhiliangKg = zhengbeizhiliangKg;
	}
	
	public String getFadongjixinghao() {
		return fadongjixinghao;
	}

	public void setFadongjixinghao(String fadongjixinghao) {
		this.fadongjixinghao = fadongjixinghao;
	}
	
	public String getPailiangMl() {
		return pailiangMl;
	}

	public void setPailiangMl(String pailiangMl) {
		this.pailiangMl = pailiangMl;
	}
	
	public String getPailiangL() {
		return pailiangL;
	}

	public void setPailiangL(String pailiangL) {
		this.pailiangL = pailiangL;
	}
	
	public String getJinqixingshi() {
		return jinqixingshi;
	}

	public void setJinqixingshi(String jinqixingshi) {
		this.jinqixingshi = jinqixingshi;
	}
	
	public String getQigangpailiexingshi() {
		return qigangpailiexingshi;
	}

	public void setQigangpailiexingshi(String qigangpailiexingshi) {
		this.qigangpailiexingshi = qigangpailiexingshi;
	}
	
	public String getQigangshuGe() {
		return qigangshuGe;
	}

	public void setQigangshuGe(String qigangshuGe) {
		this.qigangshuGe = qigangshuGe;
	}
	
	public String getMeigangqimenshuGe() {
		return meigangqimenshuGe;
	}

	public void setMeigangqimenshuGe(String meigangqimenshuGe) {
		this.meigangqimenshuGe = meigangqimenshuGe;
	}
	
	public String getYasuobi() {
		return yasuobi;
	}

	public void setYasuobi(String yasuobi) {
		this.yasuobi = yasuobi;
	}
	
	public String getPeiqijigou() {
		return peiqijigou;
	}

	public void setPeiqijigou(String peiqijigou) {
		this.peiqijigou = peiqijigou;
	}
	
	public String getGangjingMm() {
		return gangjingMm;
	}

	public void setGangjingMm(String gangjingMm) {
		this.gangjingMm = gangjingMm;
	}
	
	public String getXingchengMm() {
		return xingchengMm;
	}

	public void setXingchengMm(String xingchengMm) {
		this.xingchengMm = xingchengMm;
	}
	
	public String getZuidamaliPs() {
		return zuidamaliPs;
	}

	public void setZuidamaliPs(String zuidamaliPs) {
		this.zuidamaliPs = zuidamaliPs;
	}
	
	public String getZuidagonglvzhuansuRpm() {
		return zuidagonglvzhuansuRpm;
	}

	public void setZuidagonglvzhuansuRpm(String zuidagonglvzhuansuRpm) {
		this.zuidagonglvzhuansuRpm = zuidagonglvzhuansuRpm;
	}
	
	public String getZuidaniujuzhuansuRpm() {
		return zuidaniujuzhuansuRpm;
	}

	public void setZuidaniujuzhuansuRpm(String zuidaniujuzhuansuRpm) {
		this.zuidaniujuzhuansuRpm = zuidaniujuzhuansuRpm;
	}
	
	public String getFadongjiteyoujishu() {
		return fadongjiteyoujishu;
	}

	public void setFadongjiteyoujishu(String fadongjiteyoujishu) {
		this.fadongjiteyoujishu = fadongjiteyoujishu;
	}
	
	public String getRanliaoxingshi() {
		return ranliaoxingshi;
	}

	public void setRanliaoxingshi(String ranliaoxingshi) {
		this.ranliaoxingshi = ranliaoxingshi;
	}
	
	public String getRanyoubiaohao() {
		return ranyoubiaohao;
	}

	public void setRanyoubiaohao(String ranyoubiaohao) {
		this.ranyoubiaohao = ranyoubiaohao;
	}
	
	public String getGongyoufangshi() {
		return gongyoufangshi;
	}

	public void setGongyoufangshi(String gongyoufangshi) {
		this.gongyoufangshi = gongyoufangshi;
	}
	
	public String getGanggaicailiao() {
		return ganggaicailiao;
	}

	public void setGanggaicailiao(String ganggaicailiao) {
		this.ganggaicailiao = ganggaicailiao;
	}
	
	public String getGangticailiao() {
		return gangticailiao;
	}

	public void setGangticailiao(String gangticailiao) {
		this.gangticailiao = gangticailiao;
	}
	
	public String getHuanbaobiaozhun() {
		return huanbaobiaozhun;
	}

	public void setHuanbaobiaozhun(String huanbaobiaozhun) {
		this.huanbaobiaozhun = huanbaobiaozhun;
	}
	
	public String getDianjileixing() {
		return dianjileixing;
	}

	public void setDianjileixing(String dianjileixing) {
		this.dianjileixing = dianjileixing;
	}
	
	public String getDiandongjizonggonglvKw() {
		return diandongjizonggonglvKw;
	}

	public void setDiandongjizonggonglvKw(String diandongjizonggonglvKw) {
		this.diandongjizonggonglvKw = diandongjizonggonglvKw;
	}
	
	public String getDiandongjizongniujuNM() {
		return diandongjizongniujuNM;
	}

	public void setDiandongjizongniujuNM(String diandongjizongniujuNM) {
		this.diandongjizongniujuNM = diandongjizongniujuNM;
	}
	
	public String getQiandiandongjizuidagonglvKw() {
		return qiandiandongjizuidagonglvKw;
	}

	public void setQiandiandongjizuidagonglvKw(String qiandiandongjizuidagonglvKw) {
		this.qiandiandongjizuidagonglvKw = qiandiandongjizuidagonglvKw;
	}
	
	public String getQiandiandongjizuidaniujuNM() {
		return qiandiandongjizuidaniujuNM;
	}

	public void setQiandiandongjizuidaniujuNM(String qiandiandongjizuidaniujuNM) {
		this.qiandiandongjizuidaniujuNM = qiandiandongjizuidaniujuNM;
	}
	
	public String getHoudiandongjizuidagonglvKw() {
		return houdiandongjizuidagonglvKw;
	}

	public void setHoudiandongjizuidagonglvKw(String houdiandongjizuidagonglvKw) {
		this.houdiandongjizuidagonglvKw = houdiandongjizuidagonglvKw;
	}
	
	public String getHoudiandongjizuidaniujuNM() {
		return houdiandongjizuidaniujuNM;
	}

	public void setHoudiandongjizuidaniujuNM(String houdiandongjizuidaniujuNM) {
		this.houdiandongjizuidaniujuNM = houdiandongjizuidaniujuNM;
	}
	
	public String getXitongzonghegonglvKw() {
		return xitongzonghegonglvKw;
	}

	public void setXitongzonghegonglvKw(String xitongzonghegonglvKw) {
		this.xitongzonghegonglvKw = xitongzonghegonglvKw;
	}
	
	public String getXitongzongheniujuNM() {
		return xitongzongheniujuNM;
	}

	public void setXitongzongheniujuNM(String xitongzongheniujuNM) {
		this.xitongzongheniujuNM = xitongzongheniujuNM;
	}
	
	public String getQudongdianjishu() {
		return qudongdianjishu;
	}

	public void setQudongdianjishu(String qudongdianjishu) {
		this.qudongdianjishu = qudongdianjishu;
	}
	
	public String getDianjibuju() {
		return dianjibuju;
	}

	public void setDianjibuju(String dianjibuju) {
		this.dianjibuju = dianjibuju;
	}
	
	public String getDianchileixing() {
		return dianchileixing;
	}

	public void setDianchileixing(String dianchileixing) {
		this.dianchileixing = dianchileixing;
	}
	
	public String getDianchirongliangKwh() {
		return dianchirongliangKwh;
	}

	public void setDianchirongliangKwh(String dianchirongliangKwh) {
		this.dianchirongliangKwh = dianchirongliangKwh;
	}
	
	public String getBaigonglihaodianliangKwh100km() {
		return baigonglihaodianliangKwh100km;
	}

	public void setBaigonglihaodianliangKwh100km(String baigonglihaodianliangKwh100km) {
		this.baigonglihaodianliangKwh100km = baigonglihaodianliangKwh100km;
	}
	
	public String getDianchizuzhibao() {
		return dianchizuzhibao;
	}

	public void setDianchizuzhibao(String dianchizuzhibao) {
		this.dianchizuzhibao = dianchizuzhibao;
	}
	
	public String getKuaichongdianliang() {
		return kuaichongdianliang;
	}

	public void setKuaichongdianliang(String kuaichongdianliang) {
		this.kuaichongdianliang = kuaichongdianliang;
	}
	
	public String getDangweigeshu() {
		return dangweigeshu;
	}

	public void setDangweigeshu(String dangweigeshu) {
		this.dangweigeshu = dangweigeshu;
	}
	
	public String getBiansuxiangleixing() {
		return biansuxiangleixing;
	}

	public void setBiansuxiangleixing(String biansuxiangleixing) {
		this.biansuxiangleixing = biansuxiangleixing;
	}
	
	public String getJiancheng() {
		return jiancheng;
	}

	public void setJiancheng(String jiancheng) {
		this.jiancheng = jiancheng;
	}
	
	public String getQudongfangshi() {
		return qudongfangshi;
	}

	public void setQudongfangshi(String qudongfangshi) {
		this.qudongfangshi = qudongfangshi;
	}
	
	public String getQianxuanjialeixing() {
		return qianxuanjialeixing;
	}

	public void setQianxuanjialeixing(String qianxuanjialeixing) {
		this.qianxuanjialeixing = qianxuanjialeixing;
	}
	
	public String getHouxuanjialeixing() {
		return houxuanjialeixing;
	}

	public void setHouxuanjialeixing(String houxuanjialeixing) {
		this.houxuanjialeixing = houxuanjialeixing;
	}
	
	public String getZhulileixing() {
		return zhulileixing;
	}

	public void setZhulileixing(String zhulileixing) {
		this.zhulileixing = zhulileixing;
	}
	
	public String getChetijiegou() {
		return chetijiegou;
	}

	public void setChetijiegou(String chetijiegou) {
		this.chetijiegou = chetijiegou;
	}
	
	public String getQianzhidongqileixing() {
		return qianzhidongqileixing;
	}

	public void setQianzhidongqileixing(String qianzhidongqileixing) {
		this.qianzhidongqileixing = qianzhidongqileixing;
	}
	
	public String getHouzhidongqileixing() {
		return houzhidongqileixing;
	}

	public void setHouzhidongqileixing(String houzhidongqileixing) {
		this.houzhidongqileixing = houzhidongqileixing;
	}
	
	public String getZhuchezhidongleixing() {
		return zhuchezhidongleixing;
	}

	public void setZhuchezhidongleixing(String zhuchezhidongleixing) {
		this.zhuchezhidongleixing = zhuchezhidongleixing;
	}
	
	public String getQianluntaiguige() {
		return qianluntaiguige;
	}

	public void setQianluntaiguige(String qianluntaiguige) {
		this.qianluntaiguige = qianluntaiguige;
	}
	
	public String getHouluntaiguige() {
		return houluntaiguige;
	}

	public void setHouluntaiguige(String houluntaiguige) {
		this.houluntaiguige = houluntaiguige;
	}
	
	public String getBeitaiguige() {
		return beitaiguige;
	}

	public void setBeitaiguige(String beitaiguige) {
		this.beitaiguige = beitaiguige;
	}
	
	public String getZhuFujiashizuoanquanqinang() {
		return zhuFujiashizuoanquanqinang;
	}

	public void setZhuFujiashizuoanquanqinang(String zhuFujiashizuoanquanqinang) {
		this.zhuFujiashizuoanquanqinang = zhuFujiashizuoanquanqinang;
	}
	
	public String getQianHoupaiceqinang() {
		return qianHoupaiceqinang;
	}

	public void setQianHoupaiceqinang(String qianHoupaiceqinang) {
		this.qianHoupaiceqinang = qianHoupaiceqinang;
	}
	
	public String getQianHoupaitoubuqinangQilian() {
		return qianHoupaitoubuqinangQilian;
	}

	public void setQianHoupaitoubuqinangQilian(String qianHoupaitoubuqinangQilian) {
		this.qianHoupaitoubuqinangQilian = qianHoupaitoubuqinangQilian;
	}
	
	public String getXibuqinang() {
		return xibuqinang;
	}

	public void setXibuqinang(String xibuqinang) {
		this.xibuqinang = xibuqinang;
	}
	
	public String getHoupaianquandaishiqinang() {
		return houpaianquandaishiqinang;
	}

	public void setHoupaianquandaishiqinang(String houpaianquandaishiqinang) {
		this.houpaianquandaishiqinang = houpaianquandaishiqinang;
	}
	
	public String getHoupaizhongyanganquanqinang() {
		return houpaizhongyanganquanqinang;
	}

	public void setHoupaizhongyanganquanqinang(String houpaizhongyanganquanqinang) {
		this.houpaizhongyanganquanqinang = houpaizhongyanganquanqinang;
	}
	
	public String getBeidongxingrenbaohu() {
		return beidongxingrenbaohu;
	}

	public void setBeidongxingrenbaohu(String beidongxingrenbaohu) {
		this.beidongxingrenbaohu = beidongxingrenbaohu;
	}
	
	public String getTaiyajiancegongneng() {
		return taiyajiancegongneng;
	}

	public void setTaiyajiancegongneng(String taiyajiancegongneng) {
		this.taiyajiancegongneng = taiyajiancegongneng;
	}
	
	public String getLingtaiyajixuxingshi() {
		return lingtaiyajixuxingshi;
	}

	public void setLingtaiyajixuxingshi(String lingtaiyajixuxingshi) {
		this.lingtaiyajixuxingshi = lingtaiyajixuxingshi;
	}
	
	public String getAnquandaiweixitixing() {
		return anquandaiweixitixing;
	}

	public void setAnquandaiweixitixing(String anquandaiweixitixing) {
		this.anquandaiweixitixing = anquandaiweixitixing;
	}
	
	public String getIsofixertongzuoyijiekou() {
		return isofixertongzuoyijiekou;
	}

	public void setIsofixertongzuoyijiekou(String isofixertongzuoyijiekou) {
		this.isofixertongzuoyijiekou = isofixertongzuoyijiekou;
	}
	
	public String getAbsfangbaosi() {
		return absfangbaosi;
	}

	public void setAbsfangbaosi(String absfangbaosi) {
		this.absfangbaosi = absfangbaosi;
	}
	
	public String getZhidonglifenpeiEbdCbcdeng() {
		return zhidonglifenpeiEbdCbcdeng;
	}

	public void setZhidonglifenpeiEbdCbcdeng(String zhidonglifenpeiEbdCbcdeng) {
		this.zhidonglifenpeiEbdCbcdeng = zhidonglifenpeiEbdCbcdeng;
	}
	
	public String getShachefuzhuEbaBasBadeng() {
		return shachefuzhuEbaBasBadeng;
	}

	public void setShachefuzhuEbaBasBadeng(String shachefuzhuEbaBasBadeng) {
		this.shachefuzhuEbaBasBadeng = shachefuzhuEbaBasBadeng;
	}
	
	public String getQianyinlikongzhiAsrTcsTrcdeng() {
		return qianyinlikongzhiAsrTcsTrcdeng;
	}

	public void setQianyinlikongzhiAsrTcsTrcdeng(String qianyinlikongzhiAsrTcsTrcdeng) {
		this.qianyinlikongzhiAsrTcsTrcdeng = qianyinlikongzhiAsrTcsTrcdeng;
	}
	
	public String getCheshenwendingkongzhiEscEspDscdeng() {
		return cheshenwendingkongzhiEscEspDscdeng;
	}

	public void setCheshenwendingkongzhiEscEspDscdeng(String cheshenwendingkongzhiEscEspDscdeng) {
		this.cheshenwendingkongzhiEscEspDscdeng = cheshenwendingkongzhiEscEspDscdeng;
	}
	
	public String getBingxianfuzhu() {
		return bingxianfuzhu;
	}

	public void setBingxianfuzhu(String bingxianfuzhu) {
		this.bingxianfuzhu = bingxianfuzhu;
	}
	
	public String getChedaopianliyujingxitong() {
		return chedaopianliyujingxitong;
	}

	public void setChedaopianliyujingxitong(String chedaopianliyujingxitong) {
		this.chedaopianliyujingxitong = chedaopianliyujingxitong;
	}
	
	public String getChedaobaochifuzhuxitong() {
		return chedaobaochifuzhuxitong;
	}

	public void setChedaobaochifuzhuxitong(String chedaobaochifuzhuxitong) {
		this.chedaobaochifuzhuxitong = chedaobaochifuzhuxitong;
	}
	
	public String getDaolujiaotongbiaozhishibie() {
		return daolujiaotongbiaozhishibie;
	}

	public void setDaolujiaotongbiaozhishibie(String daolujiaotongbiaozhishibie) {
		this.daolujiaotongbiaozhishibie = daolujiaotongbiaozhishibie;
	}
	
	public String getZhudongshacheZhudonganquanxitong() {
		return zhudongshacheZhudonganquanxitong;
	}

	public void setZhudongshacheZhudonganquanxitong(String zhudongshacheZhudonganquanxitong) {
		this.zhudongshacheZhudonganquanxitong = zhudongshacheZhudonganquanxitong;
	}
	
	public String getYeshixitong() {
		return yeshixitong;
	}

	public void setYeshixitong(String yeshixitong) {
		this.yeshixitong = yeshixitong;
	}
	
	public String getPilaojiashitishi() {
		return pilaojiashitishi;
	}

	public void setPilaojiashitishi(String pilaojiashitishi) {
		this.pilaojiashitishi = pilaojiashitishi;
	}
	
	public String getQianHouzhucheleida() {
		return qianHouzhucheleida;
	}

	public void setQianHouzhucheleida(String qianHouzhucheleida) {
		this.qianHouzhucheleida = qianHouzhucheleida;
	}
	
	public String getJiashifuzhuyingxiang() {
		return jiashifuzhuyingxiang;
	}

	public void setJiashifuzhuyingxiang(String jiashifuzhuyingxiang) {
		this.jiashifuzhuyingxiang = jiashifuzhuyingxiang;
	}
	
	public String getDaochecheceyujingxitong() {
		return daochecheceyujingxitong;
	}

	public void setDaochecheceyujingxitong(String daochecheceyujingxitong) {
		this.daochecheceyujingxitong = daochecheceyujingxitong;
	}
	
	public String getXunhangxitong() {
		return xunhangxitong;
	}

	public void setXunhangxitong(String xunhangxitong) {
		this.xunhangxitong = xunhangxitong;
	}
	
	public String getJiashimoshiqiehuan() {
		return jiashimoshiqiehuan;
	}

	public void setJiashimoshiqiehuan(String jiashimoshiqiehuan) {
		this.jiashimoshiqiehuan = jiashimoshiqiehuan;
	}
	
	public String getZidongbocheruwei() {
		return zidongbocheruwei;
	}

	public void setZidongbocheruwei(String zidongbocheruwei) {
		this.zidongbocheruwei = zidongbocheruwei;
	}
	
	public String getFadongjiqitingjishu() {
		return fadongjiqitingjishu;
	}

	public void setFadongjiqitingjishu(String fadongjiqitingjishu) {
		this.fadongjiqitingjishu = fadongjiqitingjishu;
	}
	
	public String getZidongzhuche() {
		return zidongzhuche;
	}

	public void setZidongzhuche(String zidongzhuche) {
		this.zidongzhuche = zidongzhuche;
	}
	
	public String getShangpofuzhu() {
		return shangpofuzhu;
	}

	public void setShangpofuzhu(String shangpofuzhu) {
		this.shangpofuzhu = shangpofuzhu;
	}
	
	public String getDoupohuanjiang() {
		return doupohuanjiang;
	}

	public void setDoupohuanjiang(String doupohuanjiang) {
		this.doupohuanjiang = doupohuanjiang;
	}
	
	public String getKebianxuanjiagongneng() {
		return kebianxuanjiagongneng;
	}

	public void setKebianxuanjiagongneng(String kebianxuanjiagongneng) {
		this.kebianxuanjiagongneng = kebianxuanjiagongneng;
	}
	
	public String getKongqixuanjia() {
		return kongqixuanjia;
	}

	public void setKongqixuanjia(String kongqixuanjia) {
		this.kongqixuanjia = kongqixuanjia;
	}
	
	public String getDianciganyingxuanjia() {
		return dianciganyingxuanjia;
	}

	public void setDianciganyingxuanjia(String dianciganyingxuanjia) {
		this.dianciganyingxuanjia = dianciganyingxuanjia;
	}
	
	public String getKebianzhuanxiangbi() {
		return kebianzhuanxiangbi;
	}

	public void setKebianzhuanxiangbi(String kebianzhuanxiangbi) {
		this.kebianzhuanxiangbi = kebianzhuanxiangbi;
	}
	
	public String getZhongyangchasuqisuozhigongneng() {
		return zhongyangchasuqisuozhigongneng;
	}

	public void setZhongyangchasuqisuozhigongneng(String zhongyangchasuqisuozhigongneng) {
		this.zhongyangchasuqisuozhigongneng = zhongyangchasuqisuozhigongneng;
	}
	
	public String getZhengtizhudongzhuanxiangxitong() {
		return zhengtizhudongzhuanxiangxitong;
	}

	public void setZhengtizhudongzhuanxiangxitong(String zhengtizhudongzhuanxiangxitong) {
		this.zhengtizhudongzhuanxiangxitong = zhengtizhudongzhuanxiangxitong;
	}
	
	public String getXianhuachasuqiChasusuo() {
		return xianhuachasuqiChasusuo;
	}

	public void setXianhuachasuqiChasusuo(String xianhuachasuqiChasusuo) {
		this.xianhuachasuqiChasusuo = xianhuachasuqiChasusuo;
	}
	
	public String getSheshuiganyingxitong() {
		return sheshuiganyingxitong;
	}

	public void setSheshuiganyingxitong(String sheshuiganyingxitong) {
		this.sheshuiganyingxitong = sheshuiganyingxitong;
	}
	
	public String getTianchuangleixing() {
		return tianchuangleixing;
	}

	public void setTianchuangleixing(String tianchuangleixing) {
		this.tianchuangleixing = tianchuangleixing;
	}
	
	public String getYundongwaiguantaojian() {
		return yundongwaiguantaojian;
	}

	public void setYundongwaiguantaojian(String yundongwaiguantaojian) {
		this.yundongwaiguantaojian = yundongwaiguantaojian;
	}
	
	public String getLunquancaizhi() {
		return lunquancaizhi;
	}

	public void setLunquancaizhi(String lunquancaizhi) {
		this.lunquancaizhi = lunquancaizhi;
	}
	
	public String getDiandongxihechemen() {
		return diandongxihechemen;
	}

	public void setDiandongxihechemen(String diandongxihechemen) {
		this.diandongxihechemen = diandongxihechemen;
	}
	
	public String getCehuamenxingshi() {
		return cehuamenxingshi;
	}

	public void setCehuamenxingshi(String cehuamenxingshi) {
		this.cehuamenxingshi = cehuamenxingshi;
	}
	
	public String getDiandonghoubeixiang() {
		return diandonghoubeixiang;
	}

	public void setDiandonghoubeixiang(String diandonghoubeixiang) {
		this.diandonghoubeixiang = diandonghoubeixiang;
	}
	
	public String getGanyinghoubeixiang() {
		return ganyinghoubeixiang;
	}

	public void setGanyinghoubeixiang(String ganyinghoubeixiang) {
		this.ganyinghoubeixiang = ganyinghoubeixiang;
	}
	
	public String getDiandonghoubeixiangweizhijiyi() {
		return diandonghoubeixiangweizhijiyi;
	}

	public void setDiandonghoubeixiangweizhijiyi(String diandonghoubeixiangweizhijiyi) {
		this.diandonghoubeixiangweizhijiyi = diandonghoubeixiangweizhijiyi;
	}
	
	public String getWeimenbolidulikaiqi() {
		return weimenbolidulikaiqi;
	}

	public void setWeimenbolidulikaiqi(String weimenbolidulikaiqi) {
		this.weimenbolidulikaiqi = weimenbolidulikaiqi;
	}
	
	public String getChedingxinglijia() {
		return chedingxinglijia;
	}

	public void setChedingxinglijia(String chedingxinglijia) {
		this.chedingxinglijia = chedingxinglijia;
	}
	
	public String getFadongjidianzifangdao() {
		return fadongjidianzifangdao;
	}

	public void setFadongjidianzifangdao(String fadongjidianzifangdao) {
		this.fadongjidianzifangdao = fadongjidianzifangdao;
	}
	
	public String getCheneizhongkongsuo() {
		return cheneizhongkongsuo;
	}

	public void setCheneizhongkongsuo(String cheneizhongkongsuo) {
		this.cheneizhongkongsuo = cheneizhongkongsuo;
	}
	
	public String getYaoshileixing() {
		return yaoshileixing;
	}

	public void setYaoshileixing(String yaoshileixing) {
		this.yaoshileixing = yaoshileixing;
	}
	
	public String getWuyaoshiqidongxitong() {
		return wuyaoshiqidongxitong;
	}

	public void setWuyaoshiqidongxitong(String wuyaoshiqidongxitong) {
		this.wuyaoshiqidongxitong = wuyaoshiqidongxitong;
	}
	
	public String getWuyaoshijinrugongneng() {
		return wuyaoshijinrugongneng;
	}

	public void setWuyaoshijinrugongneng(String wuyaoshijinrugongneng) {
		this.wuyaoshijinrugongneng = wuyaoshijinrugongneng;
	}
	
	public String getZhudongbiheshijinqigezha() {
		return zhudongbiheshijinqigezha;
	}

	public void setZhudongbiheshijinqigezha(String zhudongbiheshijinqigezha) {
		this.zhudongbiheshijinqigezha = zhudongbiheshijinqigezha;
	}
	
	public String getYuanchengqidonggongneng() {
		return yuanchengqidonggongneng;
	}

	public void setYuanchengqidonggongneng(String yuanchengqidonggongneng) {
		this.yuanchengqidonggongneng = yuanchengqidonggongneng;
	}
	
	public String getChecejiaotaban() {
		return checejiaotaban;
	}

	public void setChecejiaotaban(String checejiaotaban) {
		this.checejiaotaban = checejiaotaban;
	}
	
	public String getFangxiangpancaizhi() {
		return fangxiangpancaizhi;
	}

	public void setFangxiangpancaizhi(String fangxiangpancaizhi) {
		this.fangxiangpancaizhi = fangxiangpancaizhi;
	}
	
	public String getFangxiangpanweizhitiaojie() {
		return fangxiangpanweizhitiaojie;
	}

	public void setFangxiangpanweizhitiaojie(String fangxiangpanweizhitiaojie) {
		this.fangxiangpanweizhitiaojie = fangxiangpanweizhitiaojie;
	}
	
	public String getDuogongnengfangxiangpan() {
		return duogongnengfangxiangpan;
	}

	public void setDuogongnengfangxiangpan(String duogongnengfangxiangpan) {
		this.duogongnengfangxiangpan = duogongnengfangxiangpan;
	}
	
	public String getFangxiangpanhuandang() {
		return fangxiangpanhuandang;
	}

	public void setFangxiangpanhuandang(String fangxiangpanhuandang) {
		this.fangxiangpanhuandang = fangxiangpanhuandang;
	}
	
	public String getFangxiangpanjiare() {
		return fangxiangpanjiare;
	}

	public void setFangxiangpanjiare(String fangxiangpanjiare) {
		this.fangxiangpanjiare = fangxiangpanjiare;
	}
	
	public String getFangxiangpanjiyi() {
		return fangxiangpanjiyi;
	}

	public void setFangxiangpanjiyi(String fangxiangpanjiyi) {
		this.fangxiangpanjiyi = fangxiangpanjiyi;
	}
	
	public String getXingchediannaoxianshipingmu() {
		return xingchediannaoxianshipingmu;
	}

	public void setXingchediannaoxianshipingmu(String xingchediannaoxianshipingmu) {
		this.xingchediannaoxianshipingmu = xingchediannaoxianshipingmu;
	}
	
	public String getQuanyejingyibiaopan() {
		return quanyejingyibiaopan;
	}

	public void setQuanyejingyibiaopan(String quanyejingyibiaopan) {
		this.quanyejingyibiaopan = quanyejingyibiaopan;
	}
	
	public String getYejingyibiaochicun() {
		return yejingyibiaochicun;
	}

	public void setYejingyibiaochicun(String yejingyibiaochicun) {
		this.yejingyibiaochicun = yejingyibiaochicun;
	}
	
	public String getHudtaitoushuzixianshi() {
		return hudtaitoushuzixianshi;
	}

	public void setHudtaitoushuzixianshi(String hudtaitoushuzixianshi) {
		this.hudtaitoushuzixianshi = hudtaitoushuzixianshi;
	}
	
	public String getNeizhixingchejiluyi() {
		return neizhixingchejiluyi;
	}

	public void setNeizhixingchejiluyi(String neizhixingchejiluyi) {
		this.neizhixingchejiluyi = neizhixingchejiluyi;
	}
	
	public String getZhudongjiangzao() {
		return zhudongjiangzao;
	}

	public void setZhudongjiangzao(String zhudongjiangzao) {
		this.zhudongjiangzao = zhudongjiangzao;
	}
	
	public String getShoujiwuxianchongdiangongneng() {
		return shoujiwuxianchongdiangongneng;
	}

	public void setShoujiwuxianchongdiangongneng(String shoujiwuxianchongdiangongneng) {
		this.shoujiwuxianchongdiangongneng = shoujiwuxianchongdiangongneng;
	}
	
	public String getDiandongketiaotaban() {
		return diandongketiaotaban;
	}

	public void setDiandongketiaotaban(String diandongketiaotaban) {
		this.diandongketiaotaban = diandongketiaotaban;
	}
	
	public String getZuoyicaizhi() {
		return zuoyicaizhi;
	}

	public void setZuoyicaizhi(String zuoyicaizhi) {
		this.zuoyicaizhi = zuoyicaizhi;
	}
	
	public String getYundongfenggezuoyi() {
		return yundongfenggezuoyi;
	}

	public void setYundongfenggezuoyi(String yundongfenggezuoyi) {
		this.yundongfenggezuoyi = yundongfenggezuoyi;
	}
	
	public String getZhuzuoyitiaojiefangshi() {
		return zhuzuoyitiaojiefangshi;
	}

	public void setZhuzuoyitiaojiefangshi(String zhuzuoyitiaojiefangshi) {
		this.zhuzuoyitiaojiefangshi = zhuzuoyitiaojiefangshi;
	}
	
	public String getFuzuoyitiaojiefangshi() {
		return fuzuoyitiaojiefangshi;
	}

	public void setFuzuoyitiaojiefangshi(String fuzuoyitiaojiefangshi) {
		this.fuzuoyitiaojiefangshi = fuzuoyitiaojiefangshi;
	}
	
	public String getZhuFujiashizuodiandongtiaojie() {
		return zhuFujiashizuodiandongtiaojie;
	}

	public void setZhuFujiashizuodiandongtiaojie(String zhuFujiashizuodiandongtiaojie) {
		this.zhuFujiashizuodiandongtiaojie = zhuFujiashizuodiandongtiaojie;
	}
	
	public String getQianpaizuoyigongneng() {
		return qianpaizuoyigongneng;
	}

	public void setQianpaizuoyigongneng(String qianpaizuoyigongneng) {
		this.qianpaizuoyigongneng = qianpaizuoyigongneng;
	}
	
	public String getDiandongzuoyijiyigongneng() {
		return diandongzuoyijiyigongneng;
	}

	public void setDiandongzuoyijiyigongneng(String diandongzuoyijiyigongneng) {
		this.diandongzuoyijiyigongneng = diandongzuoyijiyigongneng;
	}
	
	public String getFujiashiweihoupaiketiaojieanniu() {
		return fujiashiweihoupaiketiaojieanniu;
	}

	public void setFujiashiweihoupaiketiaojieanniu(String fujiashiweihoupaiketiaojieanniu) {
		this.fujiashiweihoupaiketiaojieanniu = fujiashiweihoupaiketiaojieanniu;
	}
	
	public String getDierpaizuoyitiaojie() {
		return dierpaizuoyitiaojie;
	}

	public void setDierpaizuoyitiaojie(String dierpaizuoyitiaojie) {
		this.dierpaizuoyitiaojie = dierpaizuoyitiaojie;
	}
	
	public String getHoupaizuoyidiandongtiaojie() {
		return houpaizuoyidiandongtiaojie;
	}

	public void setHoupaizuoyidiandongtiaojie(String houpaizuoyidiandongtiaojie) {
		this.houpaizuoyidiandongtiaojie = houpaizuoyidiandongtiaojie;
	}
	
	public String getHoupaizuoyigongneng() {
		return houpaizuoyigongneng;
	}

	public void setHoupaizuoyigongneng(String houpaizuoyigongneng) {
		this.houpaizuoyigongneng = houpaizuoyigongneng;
	}
	
	public String getHoupaixiaozhuoban() {
		return houpaixiaozhuoban;
	}

	public void setHoupaixiaozhuoban(String houpaixiaozhuoban) {
		this.houpaixiaozhuoban = houpaixiaozhuoban;
	}
	
	public String getDierpaidulizuoyi() {
		return dierpaidulizuoyi;
	}

	public void setDierpaidulizuoyi(String dierpaidulizuoyi) {
		this.dierpaidulizuoyi = dierpaidulizuoyi;
	}
	
	public String getZuoyibuju() {
		return zuoyibuju;
	}

	public void setZuoyibuju(String zuoyibuju) {
		this.zuoyibuju = zuoyibuju;
	}
	
	public String getHoupaizuoyifangdaoxingshi() {
		return houpaizuoyifangdaoxingshi;
	}

	public void setHoupaizuoyifangdaoxingshi(String houpaizuoyifangdaoxingshi) {
		this.houpaizuoyifangdaoxingshi = houpaizuoyifangdaoxingshi;
	}
	
	public String getHoupaizuoyidiandongfangdao() {
		return houpaizuoyidiandongfangdao;
	}

	public void setHoupaizuoyidiandongfangdao(String houpaizuoyidiandongfangdao) {
		this.houpaizuoyidiandongfangdao = houpaizuoyidiandongfangdao;
	}
	
	public String getQianHouzhongyangfushou() {
		return qianHouzhongyangfushou;
	}

	public void setQianHouzhongyangfushou(String qianHouzhongyangfushou) {
		this.qianHouzhongyangfushou = qianHouzhongyangfushou;
	}
	
	public String getHoupaibeijia() {
		return houpaibeijia;
	}

	public void setHoupaibeijia(String houpaibeijia) {
		this.houpaibeijia = houpaibeijia;
	}
	
	public String getJiareZhilengbeijia() {
		return jiareZhilengbeijia;
	}

	public void setJiareZhilengbeijia(String jiareZhilengbeijia) {
		this.jiareZhilengbeijia = jiareZhilengbeijia;
	}
	
	public String getZhongkongcaiseyejingpingmu() {
		return zhongkongcaiseyejingpingmu;
	}

	public void setZhongkongcaiseyejingpingmu(String zhongkongcaiseyejingpingmu) {
		this.zhongkongcaiseyejingpingmu = zhongkongcaiseyejingpingmu;
	}
	
	public String getZhongkongyejingpingchicun() {
		return zhongkongyejingpingchicun;
	}

	public void setZhongkongyejingpingchicun(String zhongkongyejingpingchicun) {
		this.zhongkongyejingpingchicun = zhongkongyejingpingchicun;
	}
	
	public String getGpsdaohangxitong() {
		return gpsdaohangxitong;
	}

	public void setGpsdaohangxitong(String gpsdaohangxitong) {
		this.gpsdaohangxitong = gpsdaohangxitong;
	}
	
	public String getDaohanglukuangxinxixianshi() {
		return daohanglukuangxinxixianshi;
	}

	public void setDaohanglukuangxinxixianshi(String daohanglukuangxinxixianshi) {
		this.daohanglukuangxinxixianshi = daohanglukuangxinxixianshi;
	}
	
	public String getDaolujiuyuanhujiao() {
		return daolujiuyuanhujiao;
	}

	public void setDaolujiuyuanhujiao(String daolujiuyuanhujiao) {
		this.daolujiuyuanhujiao = daolujiuyuanhujiao;
	}
	
	public String getZhongkongyejingpingfenpingxianshi() {
		return zhongkongyejingpingfenpingxianshi;
	}

	public void setZhongkongyejingpingfenpingxianshi(String zhongkongyejingpingfenpingxianshi) {
		this.zhongkongyejingpingfenpingxianshi = zhongkongyejingpingfenpingxianshi;
	}
	
	public String getLanyaChezaidianhua() {
		return lanyaChezaidianhua;
	}

	public void setLanyaChezaidianhua(String lanyaChezaidianhua) {
		this.lanyaChezaidianhua = lanyaChezaidianhua;
	}
	
	public String getShoujihulianYingshe() {
		return shoujihulianYingshe;
	}

	public void setShoujihulianYingshe(String shoujihulianYingshe) {
		this.shoujihulianYingshe = shoujihulianYingshe;
	}
	
	public String getYuyinshibiekongzhixitong() {
		return yuyinshibiekongzhixitong;
	}

	public void setYuyinshibiekongzhixitong(String yuyinshibiekongzhixitong) {
		this.yuyinshibiekongzhixitong = yuyinshibiekongzhixitong;
	}
	
	public String getShoushikongzhi() {
		return shoushikongzhi;
	}

	public void setShoushikongzhi(String shoushikongzhi) {
		this.shoushikongzhi = shoushikongzhi;
	}
	
	public String getChelianwang() {
		return chelianwang;
	}

	public void setChelianwang(String chelianwang) {
		this.chelianwang = chelianwang;
	}
	
	public String getChezaidianshi() {
		return chezaidianshi;
	}

	public void setChezaidianshi(String chezaidianshi) {
		this.chezaidianshi = chezaidianshi;
	}
	
	public String getHoupaiyejingpingmu() {
		return houpaiyejingpingmu;
	}

	public void setHoupaiyejingpingmu(String houpaiyejingpingmu) {
		this.houpaiyejingpingmu = houpaiyejingpingmu;
	}
	
	public String getHoupaikongzhiduomeiti() {
		return houpaikongzhiduomeiti;
	}

	public void setHoupaikongzhiduomeiti(String houpaikongzhiduomeiti) {
		this.houpaikongzhiduomeiti = houpaikongzhiduomeiti;
	}
	
	public String getWaijieyinyuanjiekouleixing() {
		return waijieyinyuanjiekouleixing;
	}

	public void setWaijieyinyuanjiekouleixing(String waijieyinyuanjiekouleixing) {
		this.waijieyinyuanjiekouleixing = waijieyinyuanjiekouleixing;
	}
	
	public String getUsbTypeCjiekoushuliang() {
		return usbTypeCjiekoushuliang;
	}

	public void setUsbTypeCjiekoushuliang(String usbTypeCjiekoushuliang) {
		this.usbTypeCjiekoushuliang = usbTypeCjiekoushuliang;
	}
	
	public String getChezaicdDvd() {
		return chezaicdDvd;
	}

	public void setChezaicdDvd(String chezaicdDvd) {
		this.chezaicdDvd = chezaicdDvd;
	}
	
	public String getDianyuan220v230v() {
		return dianyuan220v230v;
	}

	public void setDianyuan220v230v(String dianyuan220v230v) {
		this.dianyuan220v230v = dianyuan220v230v;
	}
	
	public String getXinglixiang12vdianyuanjiekou() {
		return xinglixiang12vdianyuanjiekou;
	}

	public void setXinglixiang12vdianyuanjiekou(String xinglixiang12vdianyuanjiekou) {
		this.xinglixiang12vdianyuanjiekou = xinglixiang12vdianyuanjiekou;
	}
	
	public String getYangshengqipinpaimingcheng() {
		return yangshengqipinpaimingcheng;
	}

	public void setYangshengqipinpaimingcheng(String yangshengqipinpaimingcheng) {
		this.yangshengqipinpaimingcheng = yangshengqipinpaimingcheng;
	}
	
	public String getYangshengqishuliang() {
		return yangshengqishuliang;
	}

	public void setYangshengqishuliang(String yangshengqishuliang) {
		this.yangshengqishuliang = yangshengqishuliang;
	}
	
	public String getJinguangdengguangyuan() {
		return jinguangdengguangyuan;
	}

	public void setJinguangdengguangyuan(String jinguangdengguangyuan) {
		this.jinguangdengguangyuan = jinguangdengguangyuan;
	}
	
	public String getYuanguangdengguangyuan() {
		return yuanguangdengguangyuan;
	}

	public void setYuanguangdengguangyuan(String yuanguangdengguangyuan) {
		this.yuanguangdengguangyuan = yuanguangdengguangyuan;
	}
	
	public String getDengguangtesegongneng() {
		return dengguangtesegongneng;
	}

	public void setDengguangtesegongneng(String dengguangtesegongneng) {
		this.dengguangtesegongneng = dengguangtesegongneng;
	}
	
	public String getLedrijianxingchedeng() {
		return ledrijianxingchedeng;
	}

	public void setLedrijianxingchedeng(String ledrijianxingchedeng) {
		this.ledrijianxingchedeng = ledrijianxingchedeng;
	}
	
	public String getZishiyingyuanjinguang() {
		return zishiyingyuanjinguang;
	}

	public void setZishiyingyuanjinguang(String zishiyingyuanjinguang) {
		this.zishiyingyuanjinguang = zishiyingyuanjinguang;
	}
	
	public String getZidongtoudeng() {
		return zidongtoudeng;
	}

	public void setZidongtoudeng(String zidongtoudeng) {
		this.zidongtoudeng = zidongtoudeng;
	}
	
	public String getZhuanxiangfuzhudeng() {
		return zhuanxiangfuzhudeng;
	}

	public void setZhuanxiangfuzhudeng(String zhuanxiangfuzhudeng) {
		this.zhuanxiangfuzhudeng = zhuanxiangfuzhudeng;
	}
	
	public String getZhuanxiangtoudeng() {
		return zhuanxiangtoudeng;
	}

	public void setZhuanxiangtoudeng(String zhuanxiangtoudeng) {
		this.zhuanxiangtoudeng = zhuanxiangtoudeng;
	}
	
	public String getCheqianwudeng() {
		return cheqianwudeng;
	}

	public void setCheqianwudeng(String cheqianwudeng) {
		this.cheqianwudeng = cheqianwudeng;
	}
	
	public String getQiandadengyuwumoshi() {
		return qiandadengyuwumoshi;
	}

	public void setQiandadengyuwumoshi(String qiandadengyuwumoshi) {
		this.qiandadengyuwumoshi = qiandadengyuwumoshi;
	}
	
	public String getDadenggaoduketiao() {
		return dadenggaoduketiao;
	}

	public void setDadenggaoduketiao(String dadenggaoduketiao) {
		this.dadenggaoduketiao = dadenggaoduketiao;
	}
	
	public String getDadengqingxizhuangzhi() {
		return dadengqingxizhuangzhi;
	}

	public void setDadengqingxizhuangzhi(String dadengqingxizhuangzhi) {
		this.dadengqingxizhuangzhi = dadengqingxizhuangzhi;
	}
	
	public String getDadengyanshiguanbi() {
		return dadengyanshiguanbi;
	}

	public void setDadengyanshiguanbi(String dadengyanshiguanbi) {
		this.dadengyanshiguanbi = dadengyanshiguanbi;
	}
	
	public String getChumoshiyuedudeng() {
		return chumoshiyuedudeng;
	}

	public void setChumoshiyuedudeng(String chumoshiyuedudeng) {
		this.chumoshiyuedudeng = chumoshiyuedudeng;
	}
	
	public String getCheneihuanjingfenweideng() {
		return cheneihuanjingfenweideng;
	}

	public void setCheneihuanjingfenweideng(String cheneihuanjingfenweideng) {
		this.cheneihuanjingfenweideng = cheneihuanjingfenweideng;
	}
	
	public String getQianHoudiandongchechuang() {
		return qianHoudiandongchechuang;
	}

	public void setQianHoudiandongchechuang(String qianHoudiandongchechuang) {
		this.qianHoudiandongchechuang = qianHoudiandongchechuang;
	}
	
	public String getChechuangyijianshengjianggongneng() {
		return chechuangyijianshengjianggongneng;
	}

	public void setChechuangyijianshengjianggongneng(String chechuangyijianshengjianggongneng) {
		this.chechuangyijianshengjianggongneng = chechuangyijianshengjianggongneng;
	}
	
	public String getChechuangfangjiashougongneng() {
		return chechuangfangjiashougongneng;
	}

	public void setChechuangfangjiashougongneng(String chechuangfangjiashougongneng) {
		this.chechuangfangjiashougongneng = chechuangfangjiashougongneng;
	}
	
	public String getFangziwaixianboli() {
		return fangziwaixianboli;
	}

	public void setFangziwaixianboli(String fangziwaixianboli) {
		this.fangziwaixianboli = fangziwaixianboli;
	}
	
	public String getDuocenggeyinboli() {
		return duocenggeyinboli;
	}

	public void setDuocenggeyinboli(String duocenggeyinboli) {
		this.duocenggeyinboli = duocenggeyinboli;
	}
	
	public String getWaihoushijinggongneng() {
		return waihoushijinggongneng;
	}

	public void setWaihoushijinggongneng(String waihoushijinggongneng) {
		this.waihoushijinggongneng = waihoushijinggongneng;
	}
	
	public String getNeihoushijinggongneng() {
		return neihoushijinggongneng;
	}

	public void setNeihoushijinggongneng(String neihoushijinggongneng) {
		this.neihoushijinggongneng = neihoushijinggongneng;
	}
	
	public String getHoufengdangzheyanglian() {
		return houfengdangzheyanglian;
	}

	public void setHoufengdangzheyanglian(String houfengdangzheyanglian) {
		this.houfengdangzheyanglian = houfengdangzheyanglian;
	}
	
	public String getHoupaicechuangzheyanglian() {
		return houpaicechuangzheyanglian;
	}

	public void setHoupaicechuangzheyanglian(String houpaicechuangzheyanglian) {
		this.houpaicechuangzheyanglian = houpaicechuangzheyanglian;
	}
	
	public String getHoupaiceyinsiboli() {
		return houpaiceyinsiboli;
	}

	public void setHoupaiceyinsiboli(String houpaiceyinsiboli) {
		this.houpaiceyinsiboli = houpaiceyinsiboli;
	}
	
	public String getCheneihuazhuangjing() {
		return cheneihuazhuangjing;
	}

	public void setCheneihuazhuangjing(String cheneihuazhuangjing) {
		this.cheneihuazhuangjing = cheneihuazhuangjing;
	}
	
	public String getHouyushua() {
		return houyushua;
	}

	public void setHouyushua(String houyushua) {
		this.houyushua = houyushua;
	}
	
	public String getGanyingyushuagongneng() {
		return ganyingyushuagongneng;
	}

	public void setGanyingyushuagongneng(String ganyingyushuagongneng) {
		this.ganyingyushuagongneng = ganyingyushuagongneng;
	}
	
	public String getKejiarepenshuizui() {
		return kejiarepenshuizui;
	}

	public void setKejiarepenshuizui(String kejiarepenshuizui) {
		this.kejiarepenshuizui = kejiarepenshuizui;
	}
	
	public String getKongtiaowendukongzhifangshi() {
		return kongtiaowendukongzhifangshi;
	}

	public void setKongtiaowendukongzhifangshi(String kongtiaowendukongzhifangshi) {
		this.kongtiaowendukongzhifangshi = kongtiaowendukongzhifangshi;
	}
	
	public String getHoupaidulikongtiao() {
		return houpaidulikongtiao;
	}

	public void setHoupaidulikongtiao(String houpaidulikongtiao) {
		this.houpaidulikongtiao = houpaidulikongtiao;
	}
	
	public String getHouzuochufengkou() {
		return houzuochufengkou;
	}

	public void setHouzuochufengkou(String houzuochufengkou) {
		this.houzuochufengkou = houzuochufengkou;
	}
	
	public String getWendufenqukongzhi() {
		return wendufenqukongzhi;
	}

	public void setWendufenqukongzhi(String wendufenqukongzhi) {
		this.wendufenqukongzhi = wendufenqukongzhi;
	}
	
	public String getChezaikongqijinghuaqi() {
		return chezaikongqijinghuaqi;
	}

	public void setChezaikongqijinghuaqi(String chezaikongqijinghuaqi) {
		this.chezaikongqijinghuaqi = chezaikongqijinghuaqi;
	}
	
	public String getCheneipm25guolvzhuangzhi() {
		return cheneipm25guolvzhuangzhi;
	}

	public void setCheneipm25guolvzhuangzhi(String cheneipm25guolvzhuangzhi) {
		this.cheneipm25guolvzhuangzhi = cheneipm25guolvzhuangzhi;
	}
	
	public String getFulizifashengqi() {
		return fulizifashengqi;
	}

	public void setFulizifashengqi(String fulizifashengqi) {
		this.fulizifashengqi = fulizifashengqi;
	}
	
	public String getCheneixiangfenzhuangzhi() {
		return cheneixiangfenzhuangzhi;
	}

	public void setCheneixiangfenzhuangzhi(String cheneixiangfenzhuangzhi) {
		this.cheneixiangfenzhuangzhi = cheneixiangfenzhuangzhi;
	}
	
	public String getChezaibingxiang() {
		return chezaibingxiang;
	}

	public void setChezaibingxiang(String chezaibingxiang) {
		this.chezaibingxiang = chezaibingxiang;
	}
	
	public String getXuanzhuangbao() {
		return xuanzhuangbao;
	}

	public void setXuanzhuangbao(String xuanzhuangbao) {
		this.xuanzhuangbao = xuanzhuangbao;
	}
	
	public String getWaiguanyanse() {
		return waiguanyanse;
	}

	public void setWaiguanyanse(String waiguanyanse) {
		this.waiguanyanse = waiguanyanse;
	}
	
	public String getNeishiyanse() {
		return neishiyanse;
	}

	public void setNeishiyanse(String neishiyanse) {
		this.neishiyanse = neishiyanse;
	}
	
}