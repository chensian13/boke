package csa.stu.app.userwork.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import csa.stu.app.common.entity.Special;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SpecialMapper extends BaseMapper<Special> {

    List<Special> selectTable(Map<String, Object> map);

    List<Special> selectSimpleTable(Map<String, Object> map);

    Special checkSpecialName(Special special);

}