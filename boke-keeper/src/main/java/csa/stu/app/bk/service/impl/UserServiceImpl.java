package csa.stu.app.bk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import csa.stu.app.bk.dao.UserMapper;
import csa.stu.app.bk.service.UserService;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.redis.RedisUtil;
import csa.stu.app.common.token.UserInfoUtilBoth;
import csa.stu.util.ap.mvc.helper.ServiceHelper;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.myutils.direct.EmptyUtil;
import csa.stu.util.myutils.direct.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoUtilBoth userInfoUtilBoth;

    @Override
    public ResultPojo<User> addOne(User user) {
        return null;
    }

    @Transactional
    @Override
    public ResultPojo<User> updOne(User user) {
        ResultPojo<User> rs = ResultPojo.newInstance();
        if(checkUniqueField(user,rs,null)){
            userMapper.updateById(user);
            User user1 = userMapper.selectById(user.getUserId());
            //安全处理
            user1.setPassword(null);
            user1.setSalt(null);
            user1.setToken(user.getToken());
            userInfoUtilBoth.putUser(user.getToken(), user1);
            rs.setCode(ResultPojo.OK);
        }
        return rs;
    }

    @Override
    public ResultPojo<User> login(User user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        User user1=userMapper.selectOne(queryWrapper);
        if(user1==null)
            throw new RuntimeException("该用户不存在");
        String sp=ServiceHelper.md5Password(user.getPassword(),user1.getSalt());
        user.setPassword(sp);
        ResultPojo<User> rs=ResultPojo.newInstance(userMapper.login(user));
        if(EmptyUtil.isEmpty(rs.getModel())){
            throw new RuntimeException("登录失败，请检查用户名或者密码");
        }
        rs.getModel().setToken(ServiceHelper.generateUUID32());
        //验证通过，设置cookie
        userInfoUtilBoth.putUser(rs.getModel().getToken(),rs.getModel());
        return rs;
    }

    @Override
    public ResultPojo<User> delOne(User user) {
        return null;
    }

    @Override
    public ResultPojo<User> stopOne(User user) {
        return null;
    }

    @Override
    public ResultPojo<User> submitOne(User user) {
        return null;
    }

    @Override
    public ResultPojo<User> selectById(String id) {
        User user=userMapper.selectById(id);
        //安全处理
        user.setPassword(null);
        user.setSalt(null);
        return ResultPojo.newInstance(user);
    }

    @Transactional
    @Override
    public ResultPojo<User> register(User user) {
        ResultPojo<User> rs=ResultPojo.newInstance();
        user.setSalt(ServiceHelper.generateUUID32());
        String sp=ServiceHelper.md5Password(user.getPassword(),user.getSalt());
        user.setPassword(sp);
        user.setUserCode(ServiceHelper.generateCode(GenerateCode.USER));
        user.setUserId(ServiceHelper.generateUUID32());
        user.initDefault();
        // 重复校验
        if(!checkUniqueField(user,rs, null)){
            return rs;
        }
        userMapper.insert(user);
        //安全处理
        user.setPassword(null);
        user.setSalt(null);
        return ResultPojo.newInstance(user);
    }

    @Override
    public ResultPojo<User> modPass(User user) {
        User user2=userMapper.selectById(user.getUserId());
        String pass=ServiceHelper.md5Password(user.getOldPass(),user2.getSalt());
        if(pass.equals(user2.getPassword())){
            user.setPassword(ServiceHelper.md5Password(user.getPassword(),user2.getSalt()));
            userMapper.updateById(user);
            return ResultPojo.newInstance(ResultPojo.OK,null);
        }
        return ResultPojo.newInstance(ResultPojo.NO,"旧密码不正确");
    }

    @Override
    public ResultPojo<User> selectByCode(String code) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_code",code);
        return ResultPojo.newInstance(userMapper.selectOne(queryWrapper));
    }

    @Override
    public ResultPojo<User> selectData(ParamPojo wrap) {
        return null;
    }

    @Override
    public ResultPojo<User> selectSimpleData(ParamPojo wrap) {
        return null;
    }

    @Override
    public boolean checkUniqueField(User data, ResultPojo<User> rs, String oper) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.eq("user_name",data.getUserName());
        int count=userMapper.selectCount(queryWrapper);
        if(!EmptyUtil.isEmpty(data.getUserId())
                && count > 0){
            // 修改
            User user=userMapper.selectById(data.getUserId());
            if(user.getUserName().equals(data.getUserName())){
                count = 0;
            }
        }
        if(count>0){
            throw new RuntimeException("用户名重复");
        }
        return true;
    }
}
