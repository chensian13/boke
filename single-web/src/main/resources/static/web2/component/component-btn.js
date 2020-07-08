var BTN_TEXT_SIZE="13px";
var BTN_TEXT_SIZE_BIG="14px";
var BTN_PADDING="3px 8px 3px 8px";
var BTN_PADDING_BIG="5px 10px 5px 10px";


/**
 * 按钮的属性：
 * 1）大小：正常，大按钮
 * 2）背景色
 * 3）字体色
 * 
 * 绑定方法
 * 1）setColor设置按钮颜色
 */
function btnComponent(){
	_btn_decorate(document.querySelectorAll("button"));
	_btn_decorate(document.querySelectorAll("input[type='button'],[type='submit']"));
}


function _btn_decorate(btns){
	if(isEmpty(btns) || btns.length==0) return;
	for(var i=0;i<btns.length;i++){
		//按钮大小
		if(isNotUndefined(btns[i].getAttribute("big"))){
			btns[i].style.padding=BTN_PADDING_BIG;
			btns[i].style.fontSize=BTN_TEXT_SIZE_BIG;
		}else{
			btns[i].style.padding=BTN_PADDING;
			btns[i].style.fontSize=BTN_TEXT_SIZE;
		}
		//设置颜色
		var color=btns[i].getAttribute("color");
		if(isNotEmpty(color)){
			_btn_setColor(btns[i],color);
			btns[i].setColor=function(color2){
				_btn_setColor(this,color2);
			}
		}
		//边框
		if(isNotEmpty(color)){
			if(color.match("white") 
				|| color.match("light")){
				btns[i].style.borderStyle="solid";
				btns[i].style.borderWidth="thin";
			}else{
				btns[i].style.borderStyle="none";
			}
		}else{
			btns[i].style.borderStyle="solid";
			btns[i].style.borderWidth="thin";
		} //end if
	} //end for
}


function _btn_setColor(btn,color){
	btn.style.backgroundColor=analyseColor(color);
	btn.style.color=analyseTextColor(color);
}





