/**
 * 分页解决方案
 * 
 * 按钮渲染方案：
 * 按钮分页，针对按钮类型有两种：上一页和下一页按钮，代表页数的按钮
 * 按钮的状态：选择，未选择
 * 
 * 按钮生成方案：
 * 当按钮索引超过一列按钮数量百分之60时，所有页数按钮数字加上（按钮数量的百分之40）
 * 
 * 数据结构：
 * 按钮对象是在dom中获取，是父节点下的兄弟子节点，一个数组结构
 * 分页必须掌握两大基本信息：当前页+每页记录数+总页数
 */
var PAGE_BTN_NUM=10;
var pageEventMap={};
var pageMap={};

/**
 * 
 */
function pageComponent(id,max){
	var page=document.getElementById(id);
	if(isNotEmpty(id)){
		pageEventMap[id]={}; //数据初始化
		pageMap[id]=page;
	}else{
		//不设置id不注册
		return ;
	}
	page.max=max;
	//设置当前页为1
	page.nowPage=1;
	//生成按钮
	_page_btnsGenerate(page);
	//设置样式，当前页样式
	_page_btns_decorate(page,1,true);
	//按钮样式注册
	btnComponent();
}

/**
 * 注册按钮点击事件
 * @param {Object} id
 * @param {Object} event
 */
function pageResgisterEvent(id,fn){
	if(isEmpty(pageEventMap[id])) return;
	var btns=pageMap[id].querySelectorAll("button");
	for(var i=0;i<btns.length;i++){
		btns[i].addEventListener('click',function(){
			fn(pageMap[id].nowPage,pageMap[id].max);
		},false);
	} //end for
}

/**
 * 设置最大页数
 * @param {Object} id
 * @param {Object} max
 */
function pageSetMaxPage(id,max){
	if(max<1) return;
	var page=pageMap[id];
	page.max=max;
	_page_btnsGenerate(page);
	//设置当前页
	if(page.nowPage>max){
		page.nowPage=max;
	}
	//设置样式，当前页样式
	_page_btns_decorate(page,page.nowPage,true);
	btnComponent(); //按钮样式组件
}

function pageGetNowPage(id){
	return pageMap[id].nowPage;
}


//********************************************算法升级*******************************************
/**
 * page css属性
 * 1）nowPage：当前页
 * 2)最大页: max
 * @param {Object} pages
 */
function _page_btn_decorate(btn,isNum,isActive){
	if(isNum){
		btn.style.marginRight="5px";
		var page=parseInt(btn.textContent);
		if(page%PAGE_BTN_NUM==1){
			btn.style.marginLeft="5px";
		} //end if
		if(isActive){
			btn.setAttribute("class","bg-purple text-whilte");
		}else{
			btn.setAttribute("class","bg-light text-black");
		}
	}else{
		//上一页或者下一页
		btn.setAttribute("class","bg-purple text-whilte");
	} //and else
}

/**
 * 创建按钮
 */
function _page_btn_create(text){
	var btn=document.createElement("button");;
	btn.textContent=text;
	return btn;
}

/**
 * 分页按钮渲染，分页合理化
 * @param {Object} btns
 * @param {Object} nowPage
 * @param {Object} isInit
 */
function _page_btns_decorate(page,futPage,isInit){
	var btns=page.querySelectorAll("button");
	if(isInit){
		_page_btn_decorate(btns[0],false,false);
		_page_btn_decorate(btns[btns.length-1],false,false);
	}
	//页数按钮方案
	var pageNumberDivide=parseInt(PAGE_BTN_NUM/2)+2; //增页分水岭
	var pageNumberOffset=PAGE_BTN_NUM-pageNumberDivide; //页码增量
	var minPage=parseInt(btns[1].textContent);
	var maxPage=parseInt(btns[btns.length-2].textContent);
	var futIndex=futPage-minPage+1; //选择的索引（从1开始）
	var max=page.max;
	log("****************************page****************************")
	log("原先当前页",page.nowPage);
	log("当前页",futPage);
	log("当前索引",futIndex);
	log("最大页",max);
	
	if(futPage>page.nowPage 
			&& futIndex>pageNumberDivide){
		//往前
		pageNumberOffset=(max-maxPage)>pageNumberOffset?pageNumberOffset:max-maxPage;
	}else if(futPage<page.nowPage 
			&& futIndex<=pageNumberDivide){
		//回退
		pageNumberOffset=(minPage-pageNumberOffset)>0?pageNumberOffset:minPage-1;
		pageNumberOffset=-pageNumberOffset;
	}else{
		//选择就是当前页
		pageNumberOffset=0;
	} //end else
	log("分页增量",pageNumberOffset);
	
	for(var i=1;i<btns.length-1;i++){
		//需要重新渲染按钮和业务页数
		btns[i].textContent=parseInt(btns[i].textContent)+pageNumberOffset;
		//选择和未选择样式
		if(btns[i].textContent==futPage){
			_page_btn_decorate(btns[i],true,true);
		}else{
			_page_btn_decorate(btns[i],true,false);
		}
	} //end for
	page.nowPage=futPage;
} //end fn

/**
 * 按钮设置点击事件
 * @param {Object} btn
 */
function _page_btn_click(btn,page,btnType){
	btn.addEventListener('click',function(){
		var futPage=page.nowPage; //设置未来选择页默认值
		if(btnType==1){
			//下一页
			if(futPage<page.max) {
				futPage++;
			}
		}else if(btnType==-1){
			//上一页
			if(futPage>1){
				futPage--;
			}
		}else{
			futPage=parseInt(this.textContent);
		}
		_page_btns_decorate(page,futPage,false);
	},false);
}

/**
 * 分页组件 生成按钮
 * @param {Object} page
 */
function _page_btnsGenerate(page){
	page.innerHTML="";
	var max=page.max; //理论最大页
	//上一页按钮
	var pre=_page_btn_create('pre');
	_page_btn_click(pre,page,-1);
	page.appendChild(pre);
	//下一页按钮
	var next=_page_btn_create('next');
	_page_btn_click(next,page,1);
	
	//分页按钮
	var btnSize=PAGE_BTN_NUM<max?PAGE_BTN_NUM:max; //按钮数量
	for(var j=0;j<btnSize;j++){
		var btn=_page_btn_create(j+1);
		_page_btn_click(btn,page);
		page.appendChild(btn);
	} //end for
	page.appendChild(next);
}



/**
 * 问题总结：
 * js属于弱类型语言，在做数学计算 时，注意将字符串转换为数字
 */