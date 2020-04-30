package csa.stu.app.front.controller;

import csa.stu.app.common.entity.Boke;
import csa.stu.app.common.entity.Picture;
import csa.stu.app.common.entity.User;
import csa.stu.app.common.util.UserinfoUtil;
import csa.stu.app.front.feign.BokeService;
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

/**
 * @author csa
 */
@RequestMapping("/boke")
@Controller
public class BokeController{
    @Autowired
    private BokeService bokeService;
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
            return bokeService.addOne(entity);
        }else if(OperConstant.OPER_UPD.equals(oper)){
            return bokeService.updOne(entity);
        }else if(OperConstant.OPER_STOP.equals(oper)){
            return bokeService.stopOne(entity);
        }else if(OperConstant.OPER_DEL.equals(oper)){
            return bokeService.delOne(entity);
        }
        return ResultPojo.newInstance(ResultPojo.NO,"没有该操作");
    }

    @RequestMapping({"/queryData"})
    @ResponseBody
    public ResultPojo<Boke> queryData(@RequestBody ParamPojo paramPojo) {
        return bokeService.queryData(paramPojo);
    }

    /**
     * 上传图片
     * @param funNum
     * @param file
     * @param response
     * @throws IOException
     */
    @RequestMapping("/upload")
    public void uploadOne(@RequestParam("CKEditorFuncNum") String funNum
            , @RequestPart("upload")  MultipartFile file
            ,HttpServletRequest request
            , HttpServletResponse response)
                throws IOException {
        User user = userinfoUtil.getUserCookie(request);
        if(EmptyUtil.isEmptys(user,user.getUserCode())){
            return ;
        }
        Picture pic=new Picture();
        pic.setUserCode(user.getUserCode());
        ResultPojo<Picture> rs=bokeService.uploadOne(file,user.getUserCode(),user.getUserId());
        if(rs==null || rs.getModel()==null) return ;
        Picture picture=rs.getModel();
        String path="http://imgs/"+picture.getPath();
        String resp = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction(" + funNum + ",'" + path + "','')</script>";
        response.getWriter().println(resp);
    }


    @RequestMapping({"/queryById/{id}"})
    @ResponseBody
    public ResultPojo<Boke> queryById(@PathVariable String id) {
        return bokeService.queryById(id);
    }




}
