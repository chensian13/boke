package csa.stu.app.common.entity;

import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 
 * @author csa
 *
 */
@TableName(value="sys_role")
@Data
public class SysRole extends BaseEntity {
	@TableId("role_id")
	private String roleId;
	@TableField("role_code")
	private String roleCode;
	@TableField("role_name")
	private String roleName;
	
	@TableField(exist=false)
	private List<SysRoleMenu> menus;

	
	
	
	
}
