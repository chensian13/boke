package csa.stu.app.front.feign;

import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.entity.Picture;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
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

@FeignClient(name = "user-work",configuration = BokeService.FeignMultipartSupportConfig.class)
public interface BokeService {

    @RequestMapping("/boke/data/add")
    ResultPojo<Boke> addOne(@RequestBody Boke entity);

    @RequestMapping("/boke/data/stop")
    ResultPojo<Boke> stopOne(@RequestBody Boke entity);

    @RequestMapping("/boke/data/del")
    ResultPojo<Boke> delOne(@RequestBody Boke entity);

    @RequestMapping("/boke/data/upd")
    ResultPojo<Boke> updOne(@RequestBody Boke entity);

    @RequestMapping({"/boke/queryData"})
    public ResultPojo<Boke> queryData(@RequestBody ParamPojo paramPojo);

    @RequestMapping(value="/picture/upload",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultPojo<Picture> uploadOne(@RequestPart("upload") MultipartFile file
            ,@RequestParam("userCode") String code
            ,@RequestParam("userId") String userId);

    @RequestMapping({"/boke/queryById/{id}"})
    public ResultPojo<Boke> queryById(@PathVariable String id);

    /**
     * 既支持文件上传也支持实体类作为参数接收
     */
    @Configuration
    class FeignMultipartSupportConfig {
        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;

        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }

    }


}
