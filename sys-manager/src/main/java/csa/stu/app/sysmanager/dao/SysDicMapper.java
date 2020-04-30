package csa.stu.app.sysmanager.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import csa.stu.app.common.entity.SysDic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysDicMapper extends BaseMapper<SysDic> {
	
	public List<SysDic> selectByParent(@Param("parentId") String parentId);
	
	public SysDic selectWithParentById(String id);

}
