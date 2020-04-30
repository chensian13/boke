/**
 * 本解析类致力提供常用解析方案
 */


/**
 * is解决方案
 * @param {Object} obj
 */
function isUndefined(obj){
	if(obj==undefined) return true;
	return false;
}

function isNotUndefined(obj){
	if(obj!=undefined) return true;
	return false;
}

function isNotEmpty(obj){
	if(obj!=undefined 
		&& obj!=null){
		if(obj instanceof String){
			if(obj.trim()!="")
				return true;
		}else{
			return true;
		}
	} //end if
	return false;
}
function isEmpty(obj){
	if(obj instanceof String){
		obj=obj.trim();
	}else if(typeof obj=='boolean'){
		return false;
	} 
	//开始校验
	if(obj==undefined 
			|| obj==null 
			|| obj==''){
		return true;
	} //end if
	return false;
}



/**
 * 日志打印
 */
function log(tag,msg){
	if(isEmpty(tag)) tag="";
	if(isEmpty(msg)) msg="";
	console.log(tag+": "+msg);
}



/**
 * 依据组件背景色解析出字体颜色
 * @param {Object} bgColor
 */
function analyseTextColor(bgColor){
	if(isEmpty(bgColor)) return;
	log("依据背景色",bgColor);
	if(bgColor.match("black")
		|| bgColor.match("blue")
		|| bgColor.match("gray") 
		|| bgColor.match("red")
		|| bgColor.match("purple")
		|| bgColor.match("orange")){
		//白色
		return "#FFFFFF";
	}else if(bgColor.match("light") 
		|| bgColor.match("white")){
		//黑色
		return "#393D49";
	}
}

/**
 * 依据color属性匹配颜色
 * @param {Object} color
 */
function analyseColor(color){
	if(isEmpty(color)) return;
	if(color.match("black")){
		return "#393D49";
	}else if(color.match("blue")){
		return "#1E9FFF";
	}else if(color.match("gray")){
		return "#009688";
	}else if(color.match("red")){
		return "#FF5722";
	}else if(color.match("orange")){
		return "#FFB800";
	}else if(color.match("light")){
		return "#F0F0F0";
	}else if(color.match("purple")){
		return "#4B0082";
	}else if(color.match("white")){
		return "#FFFFFF";
	}
}







