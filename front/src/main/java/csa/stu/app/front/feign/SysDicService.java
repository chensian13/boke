package csa.stu.app.front.feign;

import csa.stu.app.common.entity.SysDic;
import csa.stu.app.common.entity.TreeNode;
import csa.stu.util.myutils.pojo.ResultPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sys-manager")
public interface SysDicService {

    @RequestMapping("/dic/getTree")
    public ResultPojo<TreeNode> getTree(@RequestParam(name="parentId",required = false) String parentId);

    @RequestMapping("/dic/getBokeTypes")
    public ResultPojo<SysDic> getBokeTypes();

    @RequestMapping("/dic/data/add")
    ResultPojo<SysDic> addOne(@RequestBody SysDic entity);

    @RequestMapping("/dic/data/upd")
    ResultPojo<SysDic> updOne(@RequestBody SysDic entity);

    @RequestMapping("/dic/data/del")
    ResultPojo<SysDic> delOne(@RequestBody SysDic entity);


    @RequestMapping({"/dic/queryById/{id}"})
    public ResultPojo<SysDic> queryById(@PathVariable String id) ;

}
