package csa.stu.app.common.entity;

import lombok.Data;

/**
 * 树节点
 * @author  csa
 */
@Data
public class TreeNode extends BaseEntity{
    private String id;
    private String name;
    private String parentId;
    private String code;
    private String parent;


}
