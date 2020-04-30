package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_role_r_admin")
public class RoleAdmin {
    @TableId("ra_id")
    private String raId;

    @TableField("role_id")
    private String roleId;

    @TableField("admin_id")
    private String adminId;
}
