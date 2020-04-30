package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_menu")
@Data
public class Menu extends  BaseEntity{
    @TableId("menu_id")
    private String menuId;

    @TableField("menu_name")
    private String menuName;

    @TableField("menu_code")
    private String menuCode;

    @TableField("sort")
    private int sort;

    @TableField("permission")
    private String permission;

    @TableField("menu_type")
    private String menuType;

    @TableField("parent_id")
    private String parentId;

    @TableField(value = "parent" ,exist = false)
    private String parent;

}
