package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("boke_special")
@Data
public class Special extends  BaseEntity{
    @TableId("special_id")
    private String specialId;

    private String specialCode;

    private String ispublic;

    private String specialName;

    private String creater;


}