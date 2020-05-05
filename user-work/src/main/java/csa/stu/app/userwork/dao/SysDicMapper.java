package csa.stu.app.userwork.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import csa.stu.app.common.entity.SysDic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDicMapper extends BaseMapper<SysDic> {
	
	public List<SysDic> selectByParent(@Param("parentId") String parentId);
	
	public SysDic selectWithParentById(String id);

}
