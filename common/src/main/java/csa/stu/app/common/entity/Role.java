package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("sys_role")
@Data
public class Role extends BaseEntity{
    @TableId("role_id")
    private String roleId;

    @TableField("role_name")
    private String roleName;

    @TableField("role_code")
    private String roleCode;

    @TableField(exist = false)
    private List<MenuRole> menuRoles;


}
