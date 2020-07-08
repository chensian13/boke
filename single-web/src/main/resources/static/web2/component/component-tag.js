/**
 * 选项卡解决方案
 * 
 */




function tagComponent(tagId){
	_tag_register(tagId);
}


//************************************私有方法***********************************

/**
 * 选项卡页注册
 * 操作：点击按钮-->选项卡页显示对应的框架iframe
 * 1)按钮设置两个自定义属性：tag-target和tag-href
 * 2)tag-target表示对应哪个tag选项卡页，tag-href表示iframe加载的页面路径，也是用来区分同一个选项卡下的不同iframe
 * 3)iframe的高度由(csa-tag高度)-(csa-"高度)决定
 * 4)依据按钮的tag-href选择iframe标签显示，比对src路径是否相同
 */
function _tag_register(tagId){
	//依据属性获取tag按钮
	var bs=document.querySelectorAll("[tag-target='"+tagId+"']");
	for(var i=0;i<bs.length;i++){
		bs[i].onclick=function(){
			//找到对应选项卡的tag-name
			var name=this.getAttribute("tag-target");
			var src=this.getAttribute("tag-href");
			//找到选项卡,选项卡的tag-name保证唯一
			var tag=document.getElementById(tagId);
			//设置"显示字体与点击对象的innerText一致
			var fs=tag.getElementsByTagName("iframe");
			var b=0;
			//遍历对应选项卡中所有iframe
			for(var j=0;j<fs.length;j++){
				if(fs[j].getAttribute("src")==src){
					//匹配iframe成功
					fs[j].style.display="block";
					b=1;
				}else{
					//其它iframe设置为不显示
					fs[j].style.display="none";
				}
			}
			//表示需要创建新的iframe
			if(b==0){
				//新建框架iframe
				var iframe=document.createElement("iframe");
				iframe.setAttribute("src",src);
				iframe.style.display="block";
				_tag_iframe_height(tagId,iframe);
				//添加新iframe
				tag.getElementsByTagName("tag-body")[0].appendChild(iframe);
				//为选项卡创建点击标签
				_tag_add_label(tagId,src,this.innerText);
			}
			//标签样式
			_tag_label_style(tagId,src);
		}//绑定事件
	}
}

/**
 * 设置tag的iframe高度
 * @param {Object} tag
 * @param {Object} f
 */
function _tag_iframe_height(tagId,frame){
	//获取所有tag
	try{
		var tag=document.getElementById(tagId);
		var topHeight=tag.getElementsByTagName("tag-top")[0].offsetHeight;
		var tagHeight=tag.offsetHeight;
		frame.style.height=(tagHeight-topHeight)+"px";
	}catch(err){
		console.log("没有选项卡对象");
	}
}

/*
 * 注册选项卡标签
 * src只点击标签的target-href值，tag只选项卡，name设置点击按钮对应标签显示字体名称
 */
function _tag_add_label(tagId,src,name){
	var tag=document.getElementById(tagId);
	//获得选定选项卡下的iframe
	var iframes=tag.getElementsByTagName("tag-body")[0].getElementsByTagName("iframe");
	//新建标签
	var label=document.createElement("label");
	label.setAttribute("tag-href",src);
	//创建关闭图标
	var i=document.createElement("i");
	i.innerText="关闭";
	i.onclick=function(){
		//当前要被删除的标签
		var label=this.parentNode;
		//tag选项卡中所有label
		var labels=tag.getElementsByTagName("tag-top")[0].getElementsByTagName("label");
		for(var i=0;i<labels.length;i++){
			if(labels[i]==label){
				//获取要关闭的iframe
				var f=tag.querySelector("iframe[src='"+label.getAttribute("tag-href")+"']");
				//如果要关闭的iframe是被显示的
				if(f.style.display=="block"){
					var src=null;
					//显示被关闭标签页的右边或者左边标签页
					if(i<labels.length-1){
						src=labels[i+1].getAttribute("tag-href");
					}else if(i>0){
						src=labels[i-1].getAttribute("tag-href");
					}
					//显示iframe
					if(src!=null){
						tag.querySelector("iframe[src='"+src+"']").style.display="block";
						_tag_label_style(tagId,src);
					}
				}
				//然后关闭iframe
				f.remove();
				//删除被选择的label标签
				label.remove();
				break;
			}
		}
	};
	//创建span
	var span=document.createElement("span");
	//设置label显示字体与点击对象的innerText一致
	span.innerText=name;
	//绑定事件，显示对于iframe
	span.onclick=function(){
		for(var i=0;i<iframes.length;i++){
			//比较标签对应的iframe，比较条件为src框架路径
			if(iframes[i].getAttribute("src")==this.parentNode.getAttribute("tag-href")){
				//显示iframe
				iframes[i].style.display="block";
			}else{
				iframes[i].style.display="none";
			}
		}
		_tag_label_style(tagId,src);
		
	};
	//label添加子元素
	label.appendChild(span);
	label.appendChild(i);
	//添加新label
	tag.getElementsByTagName("tag-top")[0].appendChild(label);
}

/**
 * 依据标签是否被选中修改样式
 * tag选项卡
 * src是iframe路径
 */
function _tag_label_style(tagId,src){
	var tag=document.getElementById(tagId);
	var labels=tag.getElementsByTagName("tag-top")[0].getElementsByTagName("label");
	for(var i=0;i<labels.length;i++){
		//比较标签对应的iframe，比较条件为src框架路径
		if(src==labels[i].getAttribute("tag-href")){
			labels[i].style.background="white";
		}else{
			labels[i].style.background="lightgray";
		}
	}
}

