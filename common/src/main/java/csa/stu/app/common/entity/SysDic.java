package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * 
 * @author csa
 *
 */
@Data
@TableName("sys_dictionary")
public class SysDic extends BaseEntity {
	@TableId("dic_id")
	private String dicId;
	@TableField("dic_code")
	private String dicCode;
	@TableField("dic_name")
	private String dicName;
	@TableField("parent_id")
	private String parentId;

	@TableField("creater")
	private String creater;
	
	@TableField(exist=false)
	private String parent;
	
	

	
	
}
