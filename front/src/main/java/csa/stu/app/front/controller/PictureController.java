package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.token.UserInfoUtilBoth;
import csa.stu.app.front.feign.BokeKeeperService;
import csa.stu.util.ap.mvc.plus.CheckLoginController;
import csa.stu.util.ap.pojo.ParamPojo;
import csa.stu.util.ap.pojo.ResultPojo;
import csa.stu.util.ap.web_helper.token.TokenUtilDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author csa
 */
@RequestMapping("/picture")
@Controller
public class PictureController implements CheckLoginController {
    @Autowired
    private BokeKeeperService bokeKeeperService;
    @Autowired
    private TokenUtilDefault tokenUtilDefault;
    @Autowired
    private UserInfoUtilBoth userInfoUtilBoth;


    @ResponseBody
    @RequestMapping("/data/del")
    public ResultPojo<Picture> delOne(@RequestBody Picture entity, HttpServletRequest request){
        return mustWrapUser(request,data->{
            return bokeKeeperService.delPictureOne(entity);
        });
    }

    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<Picture> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request) {
        return mustWrapUser(request,data->{
            User user=(User) data;
            paramPojo.put("creater",user.getUserId());
            return bokeKeeperService.queryPictureData(paramPojo);
        });
    }



    /**
     * 上传图片
     * @param funNum
     * @param file
     * @param response
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public ResultPojo<String> uploadOne(@RequestPart("upload") MultipartFile file
            ,HttpServletRequest request
            , HttpServletResponse response)
            throws IOException {
        return mustWrapUser(request,data->{
            User user = (User)data;
            ResultPojo<Picture> rs= bokeKeeperService.uploadOne(file,user.getUserId());
            if(rs==null || rs.getModel()==null) return ResultPojo.newInstance(ResultPojo.NO,null);
            Picture picture=rs.getModel();
            return ResultPojo.newInstance(picture.getHttpPath());
        });
    }


    @Override
    public Object getLoginUser(HttpServletRequest request) {
        return userInfoUtilBoth.getUser(tokenUtilDefault.getTokenCookie(request));
    }

    @Override
    public String[] getWhiteMethod() {
        return null;
    }
}
