package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("file_picture")
@Data
public class Picture extends BaseEntity{
    @TableId("picture_id")
    private String pictureId;

    @TableField("picture_name")
    private String pictureName;

    private String suffix;

    @TableField("picture_code")
    private String pictureCode;

    private String creater;

    private long size;

    private String path;

    @TableField(exist = false)
    private String httpPath;


}