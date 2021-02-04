package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import csa.stu.util.myutils.direct.EmptyUtil;
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

    @TableField("table_id")
    private String tableId;


    private String creater;

    private long size;

    private String path;


}