package csa.stu.app.front.feign;

import csa.stu.app.common.entity.*;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "user-work")
public interface UserWorkService {

    //*********************************************boke*******************************************

    @RequestMapping("/boke/data/add")
    ResultPojo<Boke> addOneBoke(@RequestBody Boke entity);

    @RequestMapping("/boke/data/stop")
    ResultPojo<Boke> stopOneBoke(@RequestBody Boke entity);

    @RequestMapping("/boke/data/del")
    ResultPojo<Boke> delOneBoke(@RequestBody Boke entity);

    @RequestMapping("/boke/data/upd")
    ResultPojo<Boke> updOneBoke(@RequestBody Boke entity);

    @RequestMapping({"/boke/queryData"})
    public ResultPojo<Boke> queryBokeData(@RequestBody ParamPojo paramPojo);

    @RequestMapping({"/boke/queryById/{id}"})
    public ResultPojo<Boke> queryBokeById(@PathVariable String id);


    //*********************************************博客类型********************************************
    @RequestMapping("/type/getBokeTypes")
    public ResultPojo<Type> getBokeTypes(@RequestBody String userId);

    @RequestMapping("/type/data/add")
    ResultPojo<Type> addOne(@RequestBody Type entity);

    @RequestMapping("/type/data/upd")
    ResultPojo<Type> updOne(@RequestBody Type entity);

    @RequestMapping("/type/data/del")
    ResultPojo<Type> delOne(@RequestBody Type entity);


    @RequestMapping({"/type/queryById/{id}"})
    public ResultPojo<Type> queryTypeById(@PathVariable String id) ;


//*********************************************special*******************************************

    @RequestMapping("/special/data/add")
    ResultPojo<Special> addOneSpecial(@RequestBody Special entity);

    @RequestMapping("/special/data/stop")
    ResultPojo<Special> stopOneSpecial(@RequestBody Special entity);

    @RequestMapping("/special/data/del")
    ResultPojo<Special> delOneSpecial(@RequestBody Special entity);

    @RequestMapping("/special/data/upd")
    ResultPojo<Special> updOneSpecial(@RequestBody Special entity);

    @RequestMapping({"/special/queryData"})
    public ResultPojo<Special> querySpecialData(@RequestBody ParamPojo paramPojo);

    @RequestMapping({"/special/queryById/{id}"})
    public ResultPojo<Special> querySpecialById(@PathVariable String id);




}
