package csa.stu.app.userwork.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import csa.stu.app.common.entity.Special;

import java.util.List;
import java.util.Map;

public interface SpecialMapper extends BaseMapper<Special> {

    List<Special> selectTable(Map<String, Object> map);

}
