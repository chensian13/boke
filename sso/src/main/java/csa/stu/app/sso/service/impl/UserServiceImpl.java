package csa.stu.app.sso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import csa.stu.app.common.constent.GenerateCode;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.sso.dao.UserMapper;
import csa.stu.app.sso.service.UserService;
import csa.stu.util.myutils.constant.OperConstant;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserinfoUtil userinfoUtil;


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
    public ResultPojo<User> addOne(User user) {
        return null;
    }

    @Override
    public ResultPojo<User> updOne(User user) {
        return null;
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
        return null;
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
        return true;
    }
}
