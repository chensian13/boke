package csa.stu.app.common.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 
 * @author csa
 *
 */
@TableName("sys_role_admin")
public class SysRoleAdmin implements Serializable{
	@TableField("role_id")
	private String roleId;
	@TableField("admin_id")
	private String adminId;
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	
}
