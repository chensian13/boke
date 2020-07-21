package csa.stu.app.common.util;

import csa.stu.util.myutils.utils.EmptyUtil;
import csa.stu.util.myutils.utils.ImageUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * info
 */
public abstract class InfoUtil extends ImageUtil {


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
