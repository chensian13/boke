package csa.stu.app.common.util;

import csa.stu.util.myutils.utils.EmptyUtil;
import java.net.URI;

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

    /**
     * 获取第一张图片
     * @param info
     * @return
     */
    public static String getFirstImgSrc(String info){
        if(EmptyUtil.isEmpty(info)) return null;
        String src="src=\"";
        String m="\"";
        int i=0;
        int j=0;
        String img=null;
        StringBuffer sb=new StringBuffer(info);
        try {
            while(i<sb.length()
                    && i>=0
                    && j>i){
                i=info.indexOf(src,i)+src.length()+1;
                j=sb.indexOf(m,i);
                img=sb.substring(i,j);
                if(isImgPath(img)){
                    return img;
                }
                i=j;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
