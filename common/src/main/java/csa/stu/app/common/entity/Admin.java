package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("sys_admin")
@Data
public class Admin extends  BaseEntity{
    @TableId("admin_id")
    private String adminId;

    @TableField("tel")
    private String tel;

    @TableField("email")
    private String email;

    @TableField("admin_type")
    private String adminType;

    @TableField("admin_name")
    private String adminName;

    @TableField("admin_code")
    private String adminCode;

    @TableField("creater")
    private String creater;

    @TableField("gender")
    private String gender;

    @TableField("password")
    private String password;

    @TableField("real_name")
    private String realName;


    @TableField(exist = false)
    private List<RoleAdmin> roleAdmins;

}