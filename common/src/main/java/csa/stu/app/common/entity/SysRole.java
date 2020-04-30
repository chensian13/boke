package csa.stu.app.common.entity;

import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import csa.stu.util.myutils.pojo.BaseSysEntity;


/**
 * 
 * @author csa
 *
 */
@TableName(value="sys_role")
public class SysRole extends BaseSysEntity {
	@TableId("role_id")
	private String roleId;
	@TableField("role_code")
	private String roleCode;
	@TableField("role_name")
	private String roleName;
	
	@TableField(exist=false)
	private List<SysRoleMenu> menus;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<SysRoleMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<SysRoleMenu> menus) {
		this.menus = menus;
	}
	
	
	
	
}
