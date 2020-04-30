package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import csa.stu.util.myutils.pojo.BaseSysEntity;
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
	@TableId("dic_code")
	private String dicCode;
	@TableId("dic_name")
	private String dicName;
	@TableId("parent_id")
	private String parentId;
	
	@TableField(exist=false)
	private String parent;
	
	

	
	
}
