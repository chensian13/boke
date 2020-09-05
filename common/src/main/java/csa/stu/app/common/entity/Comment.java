package csa.stu.app.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 评论
 * @author csa
 */
@Data
@TableName("boke_comment")
public class Comment extends BaseEntity{
    @TableId("comment_id")
    private String commentId;

    private String creater;
    private String target;

    @TableId("target_type")
    private String targetType;

    @TableField("createtime")
    private Long createtime;

    @TableField("info")
    private String info;

    private String who; //针对谁的评论

    @TableField(exist = false)
    private String userName;



}
