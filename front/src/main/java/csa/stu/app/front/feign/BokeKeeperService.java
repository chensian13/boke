package csa.stu.app.front.feign;

import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.entity.User;
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
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name = "boke-keeper",
        fallback = BokeKeeperService.BokeKeeperServiceFallback.class ,
        configuration = BokeKeeperService.FeignMultipartSupportConfig.class)
public interface BokeKeeperService {

    @PostMapping("/user/register")
    public ResultPojo register(@RequestBody User user);

    @PostMapping("/user/modPass")
    public ResultPojo modPass(@RequestBody User user);

    @RequestMapping("/user/data/{oper}")
    public ResultPojo<User> operUserData(@RequestBody User entity, @PathVariable String oper);

    @RequestMapping("/user/queryById/{id}")
    public ResultPojo<User> queryUserById(@PathVariable String id);

    /**
     * 网站用户登录
     * @return
     */
    @RequestMapping("/sso/login")
    public ResultPojo<User> login(@RequestBody User user);


    //***********************************************picture**********************************************
    @RequestMapping("/picture/data/del")
    ResultPojo<Picture> delPictureOne(@RequestBody Picture entity);

    @RequestMapping({"/picture/queryData"})
    public ResultPojo<Picture> queryPictureData(@RequestBody ParamPojo paramPojo);

    @RequestMapping(value="/picture/upload/{userId}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultPojo<Picture> uploadOne(@RequestPart("upload") MultipartFile file
            ,@PathVariable("userId") String userId);


    @Component
    public static class BokeKeeperServiceFallback implements BokeKeeperService{

        @Override
        public ResultPojo register(User user) {
            return null;
        }

        @Override
        public ResultPojo modPass(User user) {
            return null;
        }

        @Override
        public ResultPojo<User> operUserData(User entity, String oper) {
            return null;
        }

        @Override
        public ResultPojo<User> queryUserById(String id) {
            return null;
        }

        @Override
        public ResultPojo<User> login(User user) {
            return ResultPojo.newInstance(ResultPojo.NO,"请求失败");
        }

        @Override
        public ResultPojo<Picture> delPictureOne(Picture entity) {
            return null;
        }

        @Override
        public ResultPojo<Picture> queryPictureData(ParamPojo paramPojo) {
            return null;
        }

        @Override
        public ResultPojo<Picture> uploadOne(MultipartFile file, String userId) {
            return null;
        }
    }


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
