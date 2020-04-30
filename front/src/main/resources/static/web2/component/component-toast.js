/**
 * Toast提示解决方案
 */


function toastShow(msg){
	var toast=_toast_create();
	_toastCenter(toast);
	_toastShow(toast,msg);
}

/**
 * 
 * @param {Object} msg
 */
function _toastShow(toast,msg){
	toast.textContent=msg;
	toast.style.display="inline-block";
}

/**
 * toast居中显示
 * @param {String} id
 */
function _toastCenter(toast){
	var w=toast.offsetWidth;
	var h=toast.offsetHeight;
	var body=document.body;
	toast.style.left=(window.innerWidth-w)/2+"px";
	toast.style.top=(window.innerHeight-h)/2+"px";
}

/**
 * 全局判断toast是否存在，不存在创建
 */
function _toast_create(){
	var toast=document.querySelector("toast");
	if(isNotEmpty(toast)){
		toast.remove(); //删除之前存在的toast
	}
	toast=document.createElement("toast");
	toast.setAttribute("class","toast bg-gray text-whilte");
	document.body.append(toast);
	return toast;
}




/**
 * 解决问题：Toast本身会在网页中间弹出，所以我们采用fixed布局
 */