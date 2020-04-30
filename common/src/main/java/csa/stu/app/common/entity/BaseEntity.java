package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import csa.stu.util.myutils.utils.DateUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础实体类
 * @author csa
 */
@Data
public class BaseEntity implements Serializable {
    @TableField("createtime")
    private Long createtime;

    @TableField("modtime")
    private Long modtime;

    @TableField("isdel")
    private String isdel;

    @TableField("info")
    private String info;

    /**
     * 默认初始化
     */
    public void initDefault(){
        createtime= DateUtil.nowTime();
        isdel="0";
        modtime=createtime;
    }


}
