/**
 * 菜单解决方案
 */

function menuComponent(id,items){
	_menu_create(id);
	_menu_addItems(id,items);
}

/**
 * 显示菜单
 * @param {Object} id
 * @param {Object} show
 */
function menuShow(id,event){
	var md=document.getElementById(id);
	var y = document.body.scrollTop+event.clientY;
    var x = document.body.scrollLeft+event.clientX;
	md.style.visibility="visible";
	md.style.left=x+"px";
	md.style.top=y+"px";
}

function menuHide(id){
	var md=document.getElementById(id);
	md.style.visibility="hidden";
}

/**
 * 创建menu
 * @param {Object} id
 */
function _menu_create(id){
	var md=document.getElementById(id);
	var ul=document.createElement("ul");
	md.append(ul);
	//body
	var body=document.getElementsByTagName("body")[0];
	if(body!=null){
		body.addEventListener('mouseup',function(){
			md.style.visibility="hidden";
		});
	}
}

/**
 * 生成菜单项
 * @param {Object} id
 * @param {Object} items [{name:string,fn:function}]
 */
function _menu_addItems(id,items){
	if(isEmpty(items)) return ;
	var ul=document.getElementById(id).getElementsByTagName("ul")[0];
	ul.innerHTML="";
	for(var i=0;i<items.length;i++){
		var li=document.createElement("li");
		li.textContent=items[i].name;
		li.addEventListener("click",items[i].fn);
		ul.appendChild(li);
	} //end for
}
