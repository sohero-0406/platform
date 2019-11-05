package com.jeesite.modules.common.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.constant.CodeConstant;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.common.utils.jwt.JwtUtils;
import com.jeesite.modules.common.dao.CommonUserDao;
import com.jeesite.modules.common.entity.*;
import com.jeesite.modules.common.util.CommonUserUtil;
import com.jeesite.modules.common.vo.ExamUserListAndOtherInfoVO;
import com.jeesite.modules.common.vo.LoginVO;
import com.jeesite.modules.common.vo.StuSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * common_userService
 *
 * @author lvchangwei
 * @version 2019-07-16
 */
@Service
@Transactional(readOnly = true)
public class CommonUserService extends CrudService<CommonUserDao, CommonUser> {


    @Autowired
    private CommonRoleService commonRoleService;
    @Autowired
    private CommonSchoolService commonSchoolService;
    @Autowired
    private CommonAssessmentStuService commonAssessmentStuService;
    @Autowired
    private CommonAssessmentService commonAssessmentService;

    /**
     * 获取单条数据
     *
     * @param commonUser 1
     * @return 1
     */
    @Override
    public CommonUser get(CommonUser commonUser) {
        return super.get(commonUser);
    }

    /**
     * 查询分页数据
     *
     * @param commonUser      查询条件

     * @return 1
     */
    @Override
    public Page<CommonUser> findPage(CommonUser commonUser) {
//        if(!PageUtils.checkPageParams(vehicleInfo)){
//            return new CommonResult(CodeConstant.PARA_MUST_NEED, "您未传入分页数据");
//        }
//        Page<CommonUser> page = super.findPage(commonUser);
//        List<CommonUser> list = page.getList();
//        String schoolIds = "";
//        for (int i = 0; i < list.size(); i++) {
//            if(i==0){
//                schoolIds = list.get(i).getSchoolId();
//            }else{
//                if(schoolIds.indexOf(list.get(i).getSchoolId())==-1){
//                    schoolIds += ","+list.get(i).getSchoolId();
//                }
//            }
//        }
//        CommonSchool schoolCon = new CommonSchool();
//        schoolCon.setId_in(schoolIds.split(","));
//        List<CommonSchool> schoolList = commonSchoolDao.findList(schoolCon);
//        for (int i = 0; i < list.size(); i++) {
//            CommonUser u = list.get(i);
//            for (int j = 0; j < schoolList.size(); j++) {
//                CommonSchool school = schoolList.get(j);
//                if(school.getId().equals(u.getSchoolId())){
//                    u.setSchoolName(school.getSchoolName());
//                    break;
//                }
//            }
//            list.set(i, u);
//        }
//        page.setList(list);
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = super.get(loginUserId);
        if(loginUser.getRoleId().equals("2")){
            commonUser.setSchoolId(loginUser.getSchoolId());
        }
        Page page = commonUser.getPage();
        page.setList(dao.findCommonUserWithSchoolName(commonUser));
        return page;
    }

    /**
     * 保存数据（插入或更新）
     *
     * @param commonUser 1
     */
    @Override
    @Transactional
    public void save(CommonUser commonUser) {
        super.save(commonUser);
    }

    /**
     * 更新状态
     *
     * @param commonUser 1
     */
    @Override
    @Transactional
    public void updateStatus(CommonUser commonUser) {
        super.updateStatus(commonUser);
    }

    /**
     * 删除数据
     *
     * @param commonUser 1
     */
    @Override
    @Transactional
    public void delete(CommonUser commonUser) {
        super.delete(commonUser);
    }

    /**
     * 依据用户名查找用户信息 getByEntity
     */
    @Transactional
    public CommonUser getByEntity(CommonUser user) {
        return dao.getByEntity(user);
    }


    /**
     * 保存数据（插入或更新）
     *
     * @param commonUser
     */
    @Transactional
    public CommonResult addCommonUser(CommonUser commonUser) {
        if(StringUtils.isNotBlank(commonUser.getPhoneNum())&&commonUser.getPhoneNum().length()!=11){
            return new CommonResult(CodeConstant.ERROR_DATA, "手机号长度不是11位!");
        }
        if(StringUtils.isNotBlank(commonUser.getTrueName())&&commonUser.getTrueName().length()>32){
            return new CommonResult(CodeConstant.ERROR_DATA, "姓名的长度不得大于32!");
        }
        if(StringUtils.isNotBlank(commonUser.getMajorName())&&commonUser.getMajorName().length()>100){
            return new CommonResult(CodeConstant.ERROR_DATA, "专业的长度不得大于100!");
        }
        if(StringUtils.isNotBlank(commonUser.getClassName())&&commonUser.getClassName().length()>100){
            return new CommonResult(CodeConstant.ERROR_DATA, "班级的长度不得大于100!");
        }
        if(StringUtils.isBlank(commonUser.getId())){
            if(commonUser.getSchoolId()==null){
                return new CommonResult(CodeConstant.ERROR_DATA, "该用户没有设置学校属性!");
            }
            if(StringUtils.isBlank(commonUser.getUserName())){
                return new CommonResult(CodeConstant.ERROR_DATA, "请填写身份证信息!");
            }
            if(commonUser.getUserName()!=null&&commonUser.getUserName().length()!=18){
                return new CommonResult(CodeConstant.ERROR_DATA, "登录名长度不是18位!");
            }
            commonUser.setPassword(commonUser.getPhoneNum().substring(commonUser.getPhoneNum().length()-6));
            CommonUser con = new CommonUser();
            con.setUserName(commonUser.getUserName());

            List<CommonUser> exist = super.findList(con);
            if(exist!=null&&exist.size()>0){
                return new CommonResult(CodeConstant.USER_EXIST, commonUser.getUserName()+"已存在！");
            }
            super.save(commonUser);
        }else{
            super.update(commonUser);
        }
        return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
    }

    /**
     * 保存多条用户（导入的数据）
     * @param userList 1
     * @param roleId 1
     * @return 1
     */
    @Transactional
    public CommonResult saveUserList(List<CommonUser> userList, String roleId){
        if(ListUtils.isEmpty(userList)){
            return new CommonResult(CodeConstant.EXCEL_NO_DATA, "您上传的excel没有数据，请检查");
        }
        int okNum = 0;
        int errorNum = 0;
        String msg = "";
        for (CommonUser user: userList) {
            user.setPassword("123456");
            CommonUser con = new CommonUser();
            con.setUserName(user.getUserName());
            List<CommonUser> exist = super.findList(con);
            if(exist!=null&&exist.size()>0){
                msg += user.getUserName()+"已存在！<br/>";
                errorNum++;
            }else{
                int sum = 0;
                if(StringUtils.isNotBlank(user.getPhoneNum())&&user.getPhoneNum().length()!=11){
                    sum++;
                    //return new CommonResult(CodeConstant.ERROR_DATA, "手机号长度不是11位!");
                    msg += user.getUserName()+"手机号长度不是11位!<br/>";
                }
                if(StringUtils.isNotBlank(user.getTrueName())&&user.getTrueName().length()>32){
                    sum++;
                    msg += user.getUserName()+"姓名的长度不得大于32!<br/>";
//                    return new CommonResult(CodeConstant.ERROR_DATA, "姓名的长度不得大于32!");
                }
                if(StringUtils.isNotBlank(user.getMajorName())&&user.getMajorName().length()>100){
                    sum++;
                    msg += user.getUserName()+"专业的长度不得大于100!<br/>";
                    //return new CommonResult(CodeConstant.ERROR_DATA, "专业的长度不得大于100!");
                }
                if(StringUtils.isNotBlank(user.getClassName())&&user.getClassName().length()>100){
                    sum++;
                    msg += user.getUserName()+"班级的长度不得大于100!<br/>";
                    //return new CommonResult(CodeConstant.ERROR_DATA, "班级的长度不得大于100!");
                }
                if(user.getUserName().trim().length()!=18){
                    msg += user.getUserName()+"长度不是18！<br/>";
                    sum++;
                }
                CommonSchool commonSchool = new CommonSchool();
                commonSchool.setSchoolName(user.getSchoolName());
                CommonSchool cs = commonSchoolService.getByEntity(commonSchool);
                if(cs==null){
                    msg += user.getUserName()+"设置的学校名称无法查询到!<br/>";
                    sum++;
                }
                if(sum>0){
                    errorNum++;
                }else{
                    user.setSchoolId(cs.getId());
                    user.setRoleId(roleId);

                    user.setPassword(user.getPhoneNum().substring(user.getPhoneNum().length()-6));
                    super.save(user);
                    okNum++;
                }
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("successNum", okNum);
        jo.put("errorNum", errorNum);
        return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, msg, jo);
    }

    /**
     * 重置密码
     * @param id 1
     * @return 1
     */
    @Transactional
    public CommonResult resetPass(String id) {
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = super.get(loginUserId);
        if(loginUser.getRoleId().equals("1")&&id.equals(loginUserId)){ // 管理员不能给自己重置密码
            return new CommonResult(CodeConstant.ERROR_DATA, "您无权执行该操作！");
        }
        CommonUser commonUser = super.get(id);
        if(loginUser.getRoleId().equals("1")){ // 管理员可以重置所有密码
            commonUser.setPassword("123456");
            super.update(commonUser);
            return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
        }else if(loginUser.getRoleId().equals("2")){ // 教师可以重置密码
            if(loginUser.getSchoolId().equals(commonUser.getSchoolId())){ // 教师该校的教师才能重置该校的密码
                commonUser.setPassword("123456");
                super.update(commonUser);
                return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
            }else{
                return new CommonResult(CodeConstant.ERROR_DATA, "您无权执行该操作！");
            }
        }else{ // 学生不能执行重置密码的操作
            return new CommonResult(CodeConstant.ERROR_DATA, "您无权执行该操作！");
        }


    }

    /**
     * 更靠权限
     * @param id 1
     * @param isExamRight 1
     * @return 1
     */
    @Transactional
    public CommonResult changeRight(String id, String isExamRight){
        CommonUser commonUser = super.get(id);
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = super.get(loginUserId);
        if(loginUser.getRoleId().equals("1")&&commonUser.getRoleId().equals("2")){ // 只有超管才能给教师开启考试权限
            commonUser.setIsExamRight(isExamRight);
            super.update(commonUser);
            return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL);
        }else{
            return new CommonResult(CodeConstant.ERROR_DATA, "您无权修改该数据！");
        }

    }

    /**
     * 根据json删除一个或者多个用户
     * @param json 1
     * @return 1
     */
    @Transactional
    public CommonResult deleteCommonUser(String json) {

        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = super.get(loginUserId);
        if("3".equals(loginUser.getRoleId())){
            return new CommonResult(CodeConstant.NO_RIGHT, "您没有权限进行该操作");
        }

        JSONObject jsonObject = JSONObject.parseObject(json);
        Integer length =jsonObject.getInteger("length");
        JSONArray ja = JSONArray.parseArray(jsonObject.getString("datas"));
        int deletedNum = 0;
        for (int i = 0; i < length; i++) {
            String id = ja.getString(i);
            CommonUser cu = this.get(id);
            if(CommonUserUtil.isSuperAdmin(loginUser)||CommonUserUtil.isSameSchool(loginUser, cu)){
                super.delete(cu);
                deletedNum++;
            }
        }
        JSONObject object = new JSONObject();
        object.put("deletedNum", deletedNum);
        int x = length - deletedNum;
        object.put("notDeletedNum", x);
        if(x>0){
            return new CommonResult(CodeConstant.DATA_LOCK, "有"+x+"条件数据不符合删除条件，不能删除，符合的已删除", object);
        }else{
            return new CommonResult(CodeConstant.REQUEST_SUCCESSFUL, object);
        }

    }

    /**
     * 教师端登录的service方法
     * @param vo 1
     * @return 1
     */
    public CommonResult<CommonUser> teacherSideLogin(LoginVO vo){
        CommonResult<CommonUser> result = new CommonResult<>();
        String userName = vo.getUserName();
        String password = vo.getPassword();
        CommonUser user = dao.findByUserName(userName);
        if(user==null){
            return new CommonResult<>(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD, "用户名或密码不正确");
        }else{
            if(user.getRoleId().equals("1")){
                result.setCode(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD);
                result.setMsg("用户名或密码不正确");
                return result;
            }
            if (!password.equals(user.getPassword())) {
                result.setCode(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD);
                result.setMsg("用户名或密码不正确");
                return result;
            }
            user.setToken(JwtUtils.generateToken(user.getId()));
            user.setPassword(null);
            result.setData(user);

            result.setCode(CodeConstant.REQUEST_SUCCESSFUL);
            return result;
        }
    }



    /**
     * 登录
     *
     * @param vo 1
     * @return 1
     */
    public CommonResult login(LoginVO vo) {
        CommonResult result = new CommonResult();
        String userName = vo.getUserName();
        String password = vo.getPassword();
        //登录入口标识
        //int flag = vo.getFlag();

//        CommonUser user = new CommonUser();
//
//        user.setUserName(userName);

        CommonUser user = dao.findByUserName(userName);

        if (null == user || !password.equals(user.getPassword())) {
            result.setCode(CodeConstant.INCORRECT_USER_NAME_OR_PASSWORD);
            result.setMsg("用户名或密码不正确");
            return result;
        }

        //HttpSession session = ServletUtils.getRequest().getSession();
       // session.setAttribute("flag", flag);
        result.setCode(CodeConstant.REQUEST_SUCCESSFUL);

        CommonRole cr = commonRoleService.get(user.getRoleId());
        if("0".equals(user.getSchoolId())){
            user.setSchoolName("没有学校");
        }else{
            user.setSchoolName(commonSchoolService.get(user.getSchoolId()).getSchoolName());
        }
        user.setRoleArray(cr.getRightArray());
        user.setToken(JwtUtils.generateToken(user.getId()));
        user.setPassword(null);
        result.setData(user);
        return result;
    }

    /**
     * 根据token返回用户数据
     * @return 1
     */
    public CommonResult loadUserByToken(){
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser user = super.get(loginUserId);
        if("0".equals(user.getSchoolId())){
            user.setSchoolName("没有学校");
        }else{
            user.setSchoolName(commonSchoolService.get(user.getSchoolId()).getSchoolName());
        }
        return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, user);
    }


    /**
     * 根据搜索条件返回用户列表（考试的时候会带有考生信息）
     * @param vo 1
     * @return 1
     */
    public CommonResult<List<CommonUser>> loadStuListInPlatform(StuSearchVO vo){
        CommonResult<List<CommonUser>> result = new CommonResult<>();
        if(vo.getCommonUserId()!=null&&vo.getExamOrPractice()!=null){
            CommonUser commonUser = super.get(vo.getCommonUserId());
            if(vo.getExamOrPractice().equals("exam")){
                List<CommonUser> commonUserList = dao.findAssessmentStu(commonUser.getSchoolId(),
                        vo.getAssessmentName(), vo.getAssessmentDate(), vo.getAssessmentTime());
                result.setCode(CodeConstant.REQUEST_SUCCESSFUL);
                result.setData(commonUserList);
            }else{
                List<CommonUser> commonUserList = dao.findNormalStu(commonUser.getSchoolId(), vo.getMajorName(), vo.getClassName());
                result.setCode(CodeConstant.REQUEST_SUCCESSFUL);
                result.setData(commonUserList);
            }
        }else{
            result.setCode(CodeConstant.PARA_MUST_NEED);
            result.setMsg("commonUserId或者examOrPractice");
        }
        return result;
    }

    /**
     * 根据用户id加载专业列表
     * @param commonUserId 1
     * @return 1
     */
    public CommonResult<List<String>> loadMajorList(String commonUserId){
        CommonUser commonUser = super.get(commonUserId);
        if("2".equals(commonUser.getRoleId())){
            return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, dao.findMajorNameList(commonUser.getSchoolId()));
        }
        return new CommonResult<>(CodeConstant.ERROR_DATA, "传入的参数错误");
    }

    /**
     * 根据用户id和专业名称加载班级列表
     * @param commonUserId 1
     * @param majorName 1
     * @return 1
     */
    public CommonResult<List<String>> loadClassList(String commonUserId, String majorName){
        CommonUser commonUser = super.get(commonUserId);
        if("2".equals(commonUser.getRoleId())){
            return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, dao.findClassNameList(commonUser.getSchoolId(), majorName));
        }
        return new CommonResult<>(CodeConstant.ERROR_DATA, "传入的参数错误");
    }

    /**
     * 根据用户的多个id，加载用户列表信息
     * @param ids 1
     * @return 1
     */
    public CommonResult<List<CommonUser>> loadStuListByIds(String ids){
        String[] isArray = ids.split(",");
        List<String> idList = Arrays.asList(isArray);
        List<CommonUser> list = dao.findStuByIdsWithSchoolName(idList);
        return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, list);
    }

    public CommonResult<ExamUserListAndOtherInfoVO> loadStuListAndOtherByUserIds(String ids) {
        String[] isArray = ids.split(",");
        List<String> idList = Arrays.asList(isArray);
        List<CommonUser> list = dao.findStuByIdsWithSchoolName(idList);
        ExamUserListAndOtherInfoVO e = new ExamUserListAndOtherInfoVO();
        e.setList(list);
        CommonUser commonUser = list.get(0);
        e.setMajorName(commonUser.getMajorName());
        e.setClsName(commonUser.getClassName());
        e.setMajorNameList(dao.findMajorNameList(commonUser.getSchoolId()));
        e.setClsNameList(dao.findClassNameList(commonUser.getSchoolId(), commonUser.getMajorName()));
        return new CommonResult<>(e);
    }

    /**
     * 根据多个考生id加载用户列表信息
     * @param examUserIds 1
     * @return 1
     */
    public CommonResult<List<CommonUser>> loadStuListByExamUserIds(String examUserIds){
        String[] idsArray = examUserIds.split(",");
        List<String> examUserIdList = Arrays.asList(idsArray);
        List<CommonUser> list = dao.findStuByExamStuIdsWithSchoolName(examUserIdList);
        return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, list);
    }

    public CommonResult<ExamUserListAndOtherInfoVO> loadStuListAndOtherByExamUserIds(String examUserIds) {
        String[] idsArray = examUserIds.split(",");
        List<String> examUserIdList = Arrays.asList(idsArray);
        List<CommonUser> list = dao.findStuByExamStuIdsWithSchoolName(examUserIdList);
        ExamUserListAndOtherInfoVO e = new ExamUserListAndOtherInfoVO();
        e.setList(list);
        CommonAssessmentStu commonAssessmentStu = commonAssessmentStuService.get(list.get(0).getCommonAssessmentStuId());
        CommonAssessment commonAssessment = commonAssessmentService.get(commonAssessmentStu.getAssessmentId());
        e.setAssessmentName(commonAssessment.getAssessmentName());
        e.setAssessmentDate(commonAssessmentStu.getAssessmentDate());
        e.setAssessmentTime(commonAssessmentStu.getAssessmentTime());
        e.setAssessmentNameList(commonAssessmentService.loadAssessmentNameListBySchoolId(commonAssessment.getSchoolId()));
        e.setAssessmentDateList(commonAssessmentStuService.loadAssessmentDateListBySchoolId(commonAssessment.getSchoolId(), commonAssessment.getAssessmentName()));
        e.setAssessmentTimeList(commonAssessmentStuService.loadAssessmentTimeListBySchoolId(commonAssessment.getSchoolId(), commonAssessment.getAssessmentName(), commonAssessmentStu.getAssessmentDate()));
        return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, e);
    }

    /**
     * 根据已有的基本用户列表，把需要的信息从数据库架子啊出来，放到每个对应的对象中去
     * @param userConditionList 1
     * @return 1
     */
    public CommonResult<JSONObject> fillUserConditionList(List<UserCondition> userConditionList){
        List<String> userNameList = new ArrayList<>();
        String msg = "";
        for (UserCondition userCondition:userConditionList ) {
            userNameList.add(userCondition.getLoginName());
            try {
                Date d = DateUtils.parseDate(userCondition.getAssessmentDate(), "yyyyMMdd");
            } catch (ParseException e) {
                //e.printStackTrace();
                msg += "身份证号为"+userCondition.getLoginName()+"的考核日期填写格式不正确，请按照20190828的样式来填写";
            }
        }
        if(!"".equals(msg)){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("successNum", 0);
            jsonObject.put("errorNum", userConditionList.size());
            return new CommonResult<>(CodeConstant.EXCEL_WRONG_DATA, msg, jsonObject);
        }
        List<CommonUser> userList = dao.findStuByUserNamesWithSchoolName(userNameList);
        if(ListUtils.isEmpty(userList)){
            return new CommonResult<>(CodeConstant.EXCEL_NO_DATA, "根据您文件内提供的身份号，系统没有查询到任何用户信息");
        }
        List<UserCondition> list2 = new ArrayList<>();
        for (UserCondition userCondition:userConditionList ) {
            for (CommonUser commonUser:userList) {
                if(userCondition.getLoginName().equals(commonUser.getUserName())){
                    userCondition.setClassName(commonUser.getClassName());
                    userCondition.setMajorName(commonUser.getMajorName());
                    userCondition.setSchoolName(commonUser.getSchoolName());
                    userCondition.setGender(commonUser.getGender());
                    userCondition.setCommonUserId(commonUser.getId());
                    userCondition.setSchoolId(commonUser.getSchoolId());
                    list2.add(userCondition);
                    break;
                }
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("successNum", list2.size());
        jsonObject.put("errorNum", userNameList.size()-list2.size());
        jsonObject.put("list", list2);
        return new CommonResult<>(CodeConstant.REQUEST_SUCCESSFUL, jsonObject);
    }

    /**
     * 用户
     * @param commonUserId 1
     * @return 1
     */
    public CommonResult<CommonUser> loadOneUser(String commonUserId) {
        CommonUser commonUser = super.get(commonUserId);
        if(commonUser==null){
            return new CommonResult<>(CodeConstant.ERROR_DATA, "您传入的参数不正确");
        }
        commonUser.setSchoolName(commonSchoolService.get(commonUser.getSchoolId()).getSchoolName());
        return new CommonResult<>(commonUser);
    }

    @Transactional
    public CommonResult changePassword(String oldPassword, String newPassword) {
        String loginUserId = PreEntity.getUserIdByToken();
        CommonUser loginUser = super.get(loginUserId);
        if(oldPassword.equals(loginUser.getPassword())){
            loginUser.setPassword(newPassword);
            super.save(loginUser);
            return new CommonResult();
        }else{
            return new CommonResult(CodeConstant.WRONG_PASS, "您提供的旧密码不正确");
        }
    }



}