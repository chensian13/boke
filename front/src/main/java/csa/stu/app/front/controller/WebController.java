package csa.stu.app.front.controller;

import csa.stu.util.myutils.utils.EmptyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author  csa
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping("/hello/{userCode}")
    public String goUserWork(@PathVariable("userCode") String userCode, @RequestParam(required = false) String bokeType){
        if(EmptyUtil.isEmptys(bokeType)){
            return "redirect:/publish/index.html?userCode="+userCode;
        }
        return "redirect:/publish/index.html?userCode="+userCode+"&bokeType="+bokeType;
    }

    @RequestMapping("/detail/{bokeId}")
    public String goUserWork(@PathVariable("bokeId") String bokeId){
        return "redirect:/publish/detail.html?bokeId="+bokeId;
    }


}
