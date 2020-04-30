package csa.stu.app.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import csa.stu.app.common.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    User login(User user);

}