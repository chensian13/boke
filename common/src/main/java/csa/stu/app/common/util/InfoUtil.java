package csa.stu.app.common.util;

import csa.stu.util.myutils.utils.EmptyUtil;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * info
 */
public abstract class InfoUtil {

    /**
     * 图片路径验证
     * @param imgPath
     * @return
     */
    public static boolean isImgPath(String imgPath){
        if(imgPath.endsWith(".jpg")
                || imgPath.endsWith(".JPG")
                || imgPath.endsWith(".png")
                || imgPath.endsWith(".PNG")
                || imgPath.endsWith(".gif")
                || imgPath.endsWith(".GIF")
                || imgPath.endsWith(".jpeg")
                || imgPath.endsWith(".JPEG")){
            return true;
        }
        return false;
    }

    public static boolean isImgURL(String imgPath){
       if(isImgPath(imgPath)){
           try{
               URI uri=URI.create(imgPath);
               return true;
           }catch (Exception e){
               return false;
           }
       }
        return false;
    }

    private static final String patternString = "[http|https]+[://]+[0-9A-Za-z:/[-]_#[?][=][.][&]]*";

    /**
     * 获取第一张图片
     * @param info
     * @return
     */
    public static String getFirstImgSrc(String info){
        if(EmptyUtil.isEmpty(info)) return null;
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(info);
        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

}
