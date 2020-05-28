package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@TableName("boke_user")
@Data
@ToString
public class User extends BaseEntity{
    @TableId("user_id")
    private String userId;

    private String email;

    private String userName;

    private String realname;

    private String userCode;

    private String creater;

    private String gender;

    private String tel;

    private String password;

    private String salt;

    @TableField(exist = false)
    private String oldPass;

    @TableField(exist = false)
    private String token;
}