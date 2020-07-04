/**
 * 弹窗解决方案
 * 
 */


/**
 * 弹出注册
 * @param {String} id pop的id
 * @param int z 
 */
function popComponent(id,z,title){
	if(isNaN(z)) z=1;
	_pop_decorate(id,z);
	//标题栏
	_pop_title_default(id,title);
}


/**
 * 显示或者隐藏弹窗
 * @param {Object} id
 * @param {Object} show
 */
function popShow(id,show){
	var pop=document.getElementById(id);
	var lay=document.querySelector("lay["+id+"]");
	if(isEmpty(show)){
		show=true;
	}
	if(show){
		pop.style.display="inline-block";
		lay.style.display="block";
		//每次弹出时计算更精准
		_pop_lay_size(id);
		//设置pop居中
		_popCenter(id);
	}else{
		pop.style.display="none";
		lay.style.display="none";
	}
}


/**
 * pop居中显示
 * @param {String} id
 */
function _popCenter(id){
	var pop=document.getElementById(id);
	var popW=pop.offsetWidth;
	var popH=pop.offsetHeight;
	var body=document.body;
	pop.style.marginLeft=(body.offsetWidth-popW)/2+"px";
	if(window.innerHeight>popH){
		pop.style.marginTop=(window.innerHeight-popH)/2+"px";
	}
}

/**
 * 样式
 * @param {Object} pl
 */
function _pop_decorate(id,z){
	var pop=document.getElementById(id);
	var lay=document.querySelector("lay["+id+"]");
	
	lay.style.zIndex=z;
	pop.style.zIndex=z;
}

/**
 * 计算弹出层尺寸
 * @param {Object} id
 */
function _pop_lay_size(id){
	var lay=document.querySelector("lay["+id+"]");
	
	var sh=document.body.scrollHeight; //滚动条高度
	var width=window.innerWidth;
	var height=window.innerHeight;
	if(sh>window.innerHeight){
		height=sh;
	}
	lay.style.width=width+"px";
	lay.style.height=height+"px";
}

/**
 * 添加标题
 * @param {Object} id
 */
function _pop_title_default(id,titleMsg){
	var pop=document.getElementById(id);
	var div=document.createElement("div");
	div.setAttribute("class","titleDiv");
	
	if(isNotEmpty(titleMsg)){
		var title=document.createElement("h3");
		title.textContent=titleMsg;
		title.setAttribute('class','title');
		div.appendChild(title);
	}
	
	var close=document.createElement("span");
	close.textContent="关闭";
	close.setAttribute('class','close');
	div.appendChild(close);
	close.onclick=function(){
		popShow(id,false);
	}
	
	var both=document.createElement("div");
	both.style.clear="both";
	div.appendChild(both);
	
	pop.prepend(div);
}


/**
 * 问题解决：
 * 1)每次弹出时计算lay的尺寸更精准
 * 2)z-index只能在position属性值为relative或absolute或fixed的元素上有效
 * 
 * 3)弹出pop为什么使用fixed定位:
 * 指定position值fixed元素会脱离文档的普通流，相对于浏览器窗口偏移，固定在浏览器的某个位置
 * 指定position值absolute行内元素也会隐形变成块元素，元素会脱离文档的普通流，相对于最近的已定位祖先元素偏移，如果元素没有已定位的祖先元素，那么它的位置相对于最初的包含块偏移
 */
