package csa.stu.app.single.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoRequestUtil;
import csa.stu.app.single.dao.UserMapper;
import csa.stu.app.single.service.UserService;
import csa.stu.util.myutils.constant.OperConstant;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
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
    private UserinfoRequestUtil userinfoUtil;

    @Override
    public ResultPojo<User> addOne(User user) {
        return null;
    }

    @Transactional
    @Override
    public ResultPojo<User> updOne(User user) {
        userMapper.updateById(user);
        return ResultPojo.newInstance(userMapper.selectById(user.getUserId()));
    }

    @Transactional
    @Override
    public ResultPojo<User> register(User user) {
        ResultPojo<User> rs=ResultPojo.newInstance();
        user.setSalt(StrUtil.generateUUID32());
        String sp=userinfoUtil.saltPassword(user.getPassword(),user.getSalt());
        user.setPassword(sp);
        user.setUserCode(StrUtil.generateCode(GenerateCode.USER));
        user.setUserId(StrUtil.generateUUID32());
        user.initDefault();
        //重复校验
        if(!checkUniqueField(user,rs, OperConstant.OPER_ADD)){
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
        String pass=userinfoUtil.saltPassword(user.getOldPass(),user2.getSalt());
        if(pass.equals(user2.getPassword())){
            user.setPassword(userinfoUtil.saltPassword(user.getPassword(),user2.getSalt()));
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

    @Override
    public ResultPojo<User> login(User user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        User user1=userMapper.selectOne(queryWrapper);
        if(user1==null)
            return ResultPojo.newInstance(ResultPojo.NO,"该用户不存在");
        String sp=userinfoUtil.saltPassword(user.getPassword(),user1.getSalt());
        user.setPassword(sp);
        ResultPojo<User> rs=ResultPojo.newInstance(userMapper.login(user));
        if(EmptyUtil.isEmpty(rs.getModel())){
            rs.setMessage("登录失败，请检查用户名或者密码");
        }
        return rs;
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
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_name",data.getUserName());
        int count=userMapper.selectCount(queryWrapper);
        if(OperConstant.OPER_ADD.equals(oper)){
            if(count>0){
                rs.setCode(ResultPojo.NO);
                rs.setMessage("用户名重复");
                return false;
            }
        }
        return true;
    }
}
