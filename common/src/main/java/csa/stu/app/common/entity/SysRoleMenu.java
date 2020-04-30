package csa.stu.app.common.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @author csa
 *
 */
@TableName("sys_role_menu")
public class SysRoleMenu implements Serializable{
	@TableField("role_id")
	private String roleId;
	@TableField("menu_id")
	private String menuId;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	
}
