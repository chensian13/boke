/**
 * 表达提交解决方案
 * 
 */
var formMap={};


function formComponent(id){
	var form=document.getElementById(id);
	form.onsubmit=function(){
		return false;
	}
	//表单组件发现
	_form_init(id);
}


/**
 * 获取表单数据
 * @param {Object} id
 */
function formDataMap(id){
	var form=document.getElementById(id);
	var is=formMap[id];
	var map={};
	for(var e in is){
		map[is[e].name]=is[e].value;
	}
	return map;
}

function formDataJSON(id){
	return JSON.stringify(formDataMap(id));
}


/**
 * 表单数据绑定
 * @param {Object} id
 */
function formDataBind(id,data){
	var form=document.getElementById(id);
	var is=formMap[id];
	var map={};
	for(var e in is){
		for(var k in data){
			if(is[e].name==k){
				is[e].value=data[k];
			}
		}
	}
	return map;
}

/**
 * 表单数据clean
 * @param {Object} id
 */
function formDataClean(id){
	var form=document.getElementById(id);
	form.reset();
}


/**
 * 校验表单数据
 * @param {Object} id
 */
function formCheckSubmit(id){
	var is=formMap[id];
	for(var e in is){
		var re=_form_check_item(is[e].value,
						is[e].getAttribute('check'),
						is[e].getAttribute('msg'));
		//校验不通过，返回校验结果
		if(re!==true) return re;
	} //end for
	return true;
}

function _form_init(id){
	var form=document.getElementById(id);
	var inputs=form.querySelectorAll('input[name]');
	var map={};
	for(var i=0;i<inputs.length;i++){
		map[inputs[i].name]=inputs[i];
	} //end for
	var selects=form.querySelectorAll('select[name]');
	for(var i=0;i<selects.length;i++){
		map[selects[i].name]=selects[i];
	} //end for
	var areas=form.querySelectorAll('textarea[name]');
	for(var i=0;i<areas.length;i++){
		map[areas[i].name]=areas[i];
	} //end for
	formMap[id]=map;
}

/**
 * 自定义校验和自带校验表达式匹配
 * @param {Object} val
 * @param {Object} check
 * @param {Object} msg
 */
function _form_check_item(val,check,msg){
	//无校验规则
	if(isEmpty(check)) return true;
	if(check=='tel' || check=='phone'){
		if(isEmpty(val.match("^1[0-9]{10}$"))){
			return msg;
		}
	}else if(check=='has'){
		if(isEmpty(val)){
			return msg;
		}
	}else if(check=='email'){
		if(isEmpty(val.match("^[A-z0-9_]+@[A-z0-9]+(\.[A-z0-9]+)+$"))){
			return msg;
		}
	}else if(check=='number'){
		if(isEmpty(val.match("^[0-9]+$"))){
			return msg;
		}
	}else{
		//用户自定义校验
		if((isEmpty(val.match(check))))
			return msg;
	}
	
	return true;
}
