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
@TableName("sys_admin")
@Data
public class SysAdmin extends BaseEntity {
	@TableId("admin_id")
	private String adminId;
	@TableField("admin_code")
	private String adminCode;
	@TableField("real_name")
	private String realName;
	@TableField("admin_name")
	private String adminName;
	private String password;
	private String salt;
	private String email;
	private Long tel;
	private String type;
	private String gender;
	@TableField(exist=false)
	private List<SysRoleAdmin> roles;
	
	

	
	
	
}
