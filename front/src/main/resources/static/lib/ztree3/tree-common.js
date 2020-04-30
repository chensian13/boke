//默认配置
function defaultSetting(urlTree){
    var setting = {
        async: {
            enable: true,
            url:urlTree,
            autoParam:["id","id=parentId"],
            dataFilter: filter
        }
    };
    return setting;
}


function radioSetting(urlTree){
    var setting =  {
        async: {
            enable: true,
            url:urlTree,
            autoParam:["id","id=parentId"],
            dataFilter: filter
        },
        check: {
            enable: true,
            chkStyle :"radio",
            chkboxType: { "Y": "", "N": "" },
            radioType: "all"
        },
        callback:{
            onNodeCreated: function(e,treeId, treeNode){
                if(isEmpty(treeNode)) return ;
                if(treeNode.id==setting.radioId){
                    var tree=$.fn.zTree.getZTreeObj(treeId);
                    tree.checkNode(treeNode,true,false);
                }
            },
        } //end back
    };
    return setting;
}


function filter(treeId, parentNode, childNodes) {
    if (!childNodes || !childNodes.list) return null;
    var list=childNodes.list;
    for(var i=0;i<list.length;i++){
        list[i].isParent=true;
    }
    return list;
}

function getNodeById(tree,id){
    var node=tree.getNodeByParam("id",id);
    return node;
}


/**
 * 刷新节点
 * @param tree
 * @param id
 */
function reAsyncNode(tree,id){
    var node=getNodeById(tree,id);
    tree.reAsyncChildNodes(node,"refresh",false); //刷新节点后展开
}

function getCheckNode(tree){
    var cs=tree.getCheckedNodes(true);
    if(!isEmpty(cs) && !isEmpty(cs[0])){
        return cs[0];
    }
}

/**
 *
 * @param tree
 * @param id
 * @returns {*}
 */
function getCheckNodeId(tree){
    var node=getCheckNode(tree);
    if(!isEmpty(node)){
        return node.id;
    }
}


function getSelectNode(tree){
    var ss=tree.getSelectedNodes();
    if(!isEmpty(ss) && !isEmpty(ss[0])) return ss[0];
}

function getSelectNodeId(tree){
    var node=getSelectNode(tree);
    if(!isEmpty(node)){
        return node.id;
    }
}

/**
 *
 * @param tree
 * @param name
 * @param parentId 移动到该节点下
 */
function editSelectedName(tree,name,parentId){
    var selNode=getSelectNode(tree);
    selNode.name=name;
    //移动
    if(selNode.parentId!=parentId){
        //加载原来父节点下的子节点
        reAsyncNode(tree1,selNode.parentId);
    }
    reAsyncNode(tree1,parentId);
}