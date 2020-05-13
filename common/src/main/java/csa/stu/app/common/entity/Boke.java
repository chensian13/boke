package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("boke_boke")
public class Boke extends BaseEntity{
    @TableId("boke_id")
    private String bokeId;

    @TableField("boke_subtitle")
    private String bokeSubtitle;

    @TableField("boke_type")
    private String bokeType;

    @TableField("boke_title")
    private String bokeTitle;

    @TableField("boke_code")
    private String bokeCode;

    @TableField("creater")
    private String creater;

    @TableField("version")
    private String version;

    @TableField("collect_num")
    private int collectNum;

    @TableField("state")
    private String state;

    @TableField("picture_code")
    private String pictureCode;

    @TableField("path")
    private String path;

    @TableField("admin_code")
    private String adminCode;  //被谁审核

    @TableField("submittime")
    private long submittime;

    @TableField("ispublic")
    private String ispublic;

    private String cover; //封面
    //**********************************关联字段****************************************
    //对应作者
    @TableField(value = "author",exist = false)
    private String author;


}