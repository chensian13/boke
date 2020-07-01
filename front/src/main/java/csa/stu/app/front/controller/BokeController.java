package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.feign.UserWorkService;
import csa.stu.util.myutils.constant.OperConstant;
import csa.stu.util.myutils.pojo.ParamPojo;
import csa.stu.util.myutils.pojo.ResultPojo;
import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author csa
 */
@RequestMapping("/boke")
@Controller
public class BokeController{
    @Autowired
    private UserWorkService userWorkService;
    @Autowired
    private UserinfoUtil userinfoUtil;

    @ResponseBody
    @RequestMapping("/data/{oper}")
    public ResultPojo<Boke> addOne(@RequestBody Boke entity, @PathVariable String oper, HttpServletRequest request){
        User user=userinfoUtil.getUserCookie(request);
        if(user==null)
            return ResultPojo.newInstance(ResultPojo.NO,"获取用户信息失败，请重新登录");
        entity.setCreater(user.getUserId());
        if(OperConstant.OPER_ADD.equals(oper)){
            return userWorkService.addOne(entity);
        }else if(OperConstant.OPER_UPD.equals(oper)){
            return userWorkService.updOne(entity);
        }else if(OperConstant.OPER_STOP.equals(oper)){
            return userWorkService.stopOne(entity);
        }else if(OperConstant.OPER_DEL.equals(oper)){
            return userWorkService.delOne(entity);
        }
        return ResultPojo.newInstance(ResultPojo.NO,"没有该操作");
    }

    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<Boke> queryData(@RequestBody ParamPojo paramPojo,HttpServletRequest request) {
        User user=userinfoUtil.getUserCookie(request);
        if(user!=null){
            if(paramPojo.getMap()==null){
                Map<String,Object> map=new HashMap<>();
                map.put("creater",user.getUserId());
                paramPojo.setMap(map);
            }else{
                paramPojo.getMap().put("creater",user.getUserId());
            }
        }
        return userWorkService.queryData(paramPojo);
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
    public ResultPojo<String> uploadOne(@RequestPart("upload")  MultipartFile file
            ,HttpServletRequest request
            , HttpServletResponse response)
                throws IOException {
        User user = userinfoUtil.getUserCookie(request);
        if(EmptyUtil.isEmpty(user)){
            return ResultPojo.newInstance(ResultPojo.NO,"登录信息过期");
        }
        ResultPojo<Picture> rs= userWorkService.uploadOne(file,user.getUserId());
        if(rs==null || rs.getModel()==null) return ResultPojo.newInstance(ResultPojo.NO,null);;
        Picture picture=rs.getModel();
        String path="http://imgs/"+picture.getPath();
        return ResultPojo.newInstance(path);
    }


    @RequestMapping({"/queryById/{id}"})
    @ResponseBody
    public ResultPojo<Boke> queryById(@PathVariable String id) {
        return userWorkService.queryById(id);
    }



}
