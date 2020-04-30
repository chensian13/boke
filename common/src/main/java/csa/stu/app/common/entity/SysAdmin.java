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
@TableName("sys_admin")
public class SysAdmin extends BaseSysEntity {
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
	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<SysRoleAdmin> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRoleAdmin> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "SysAdmin [adminId=" + adminId + ", adminCode=" + adminCode + ", realName=" + realName + ", adminName="
				+ adminName + ", password=" + password + ", salt=" + salt + ", email=" + email + ", tel=" + tel
				+ ", type=" + type + ", gender=" + gender + ", roles=" + roles + "]";
	}
	
	
	
}
