//package csa.stu.app.front.controller;
//
//import csa.stu.app.common.entity.Picture;
//import csa.stu.app.common.entity.User;
//import csa.stu.app.common.util.UserinfoRequestUtil;
//import csa.stu.app.front.feign.UserWorkService;
//import csa.stu.util.ap.mvc.plus.CheckLoginController;
//import csa.stu.util.ap.pojo.ParamPojo;
//import csa.stu.util.ap.pojo.ResultPojo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author csa
// */
//@RequestMapping("/picture")
//@Controller
//public class PictureController implements CheckLoginController {
//    @Autowired
//    private UserWorkService userWorkService;
//    @Autowired
//    private UserinfoRequestUtil userinfoUtil;
//
//    @ResponseBody
//    @RequestMapping("/data/del")
//    public ResultPojo<Picture> delOne(@RequestBody Picture entity, HttpServletRequest request){
//        return mustWrapUser(request,data->{
//            return userWorkService.delPictureOne(entity);
//        });
//    }
//
//    @RequestMapping({"/queryData"})
//    @ResponseBody
//    public ResultPojo<Picture> queryData(@RequestBody ParamPojo paramPojo, HttpServletRequest request) {
//        return mustWrapUser(request,data->{
//            return userWorkService.queryPictureData(paramPojo);
//        });
//    }
//
//
//
//    /**
//     * 上传图片
//     * @param funNum
//     * @param file
//     * @param response
//     * @throws IOException
//     */
//    @RequestMapping("/upload")
//    @ResponseBody
//    public ResultPojo<String> uploadOne(@RequestPart("upload") MultipartFile file
//            ,@RequestParam(value = "bokeId",required = false) String bokeId
//            ,HttpServletRequest request
//            , HttpServletResponse response)
//            throws IOException {
//        return mustWrapUser(request,data->{
//            User user = (User)data;
//            ResultPojo<Picture> rs= userWorkService.uploadOne(file,user.getUserId(),bokeId);
//            if(rs==null || rs.getModel()==null) return ResultPojo.newInstance(ResultPojo.NO,null);;
//            Picture picture=rs.getModel();
//            return ResultPojo.newInstance(picture.getHttpPath());
//        });
//    }
//
//
//    @Override
//    public Object getLoginUser(HttpServletRequest request) {
//        return userinfoUtil.getUser(request);
//    }
//}
