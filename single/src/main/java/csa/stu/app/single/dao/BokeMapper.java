package csa.stu.app.single.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import csa.stu.app.common.entity.Boke;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BokeMapper extends BaseMapper<Boke> {

    List<Boke> selectTable(Map<String, Object> map);


}