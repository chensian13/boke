package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_menu_r_role")
public class MenuRole {
    @TableId("mr_id")
    private String mrId;

    @TableField("menu_id")
    private String menuId;

    @TableField("role_id")
    private String roleId;
}
