package csa.stu.app.common.entity.spring;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName("spring_config")
public class SpringConfig implements Serializable {
    @TableField("config_id")
    private String configId;
    private String akey;
    private String avalue;
    private String application;
    private String profile;
    private String label;
}
