/**
 * 表格解决方案
 * 表格比较关键的组成：表头+数据
 */
var TABLE_FONT_SIZE="14px";
var tableMap={
};
var tableConfig={};

function tableComponent(id,config){
	tableConfig[id]=config;
	_table_header(id,config); //table头加入
	var table=document.getElementById(id);
	var tbody=_table_create_("tbody",null,table); //table体加入
}

/**
 * 给指定table添加数据
 * @param {Object} table
 * @param {Array} data
 */
function tableData(tableId,data){
	var config=tableConfig[tableId];
	var table=document.getElementById(tableId);
	var tbody=table.getElementsByTagName("tbody")[0];
	tbody.innerHTML=""; //清空之前数据
	if(data==null || data.length==0) return ;
	for(var i=0;i<data.length;i++){
		var tr=_table_create_("tr",null,tbody);
		_table_tr_data(tr,data[i],config);
	} //end for
}


/**
 * 删除某个table下被选中的行
 * @param {Object} tableId
 */
function tableDeleteRows(id){
	var trs=document.getElementById(id).querySelectorAll('tr');
	if(trs==null) return ;
	for(var i=1;i<trs.length;i++){
		var checkbox=trs[i].querySelector("input[type='checkbox']");
		if(checkbox.checked){
			trs[i].remove();
		}
	} //end for
}

/**
 * 
 * @param {Object} id
 */
function tableSelectedIds(id){
	var ids=[];
	var trs=document.getElementById(id).querySelectorAll('tr');
	if(trs==null) return ;
	for(var i=1;i<trs.length;i++){
		var checkbox=trs[i].querySelector("input[type='checkbox']");
		if(checkbox.checked){
			ids.push(checkbox.value);
		}
	} //end for
	return ids;
}

//*****************************************************************************************************
/**
 * 
 * @param {Object} td
 * @param {Object} color
 */
function _table_style_td(td,color){
	td.style.borderBottomStyle="solid";
	td.style.borderWidth="thin";
	if(isNotEmpty(color)){
		td.style.borderColor=analyseColor(color);
	}
}

function _table_style_header(header,color){
	var ths=header.getElementsByTagName("th");
	for(var i=0;i<ths.length;i++){
		if(isNotEmpty(color)){
			ths[i].style.backgroundColor=analyseColor(color);
		}else{
			ths[i].style.backgroundColor=analyseColor("gray");
		}
		ths[i].style.fontWeight="normal";
		ths[i].style.color=analyseColor("white");
	} //end for
}

//****************************************************算法精进**************************************************
/**
 * 创建一个dom节点并加入父节点
 * @param {String} na
 * @param {String} textContent
 * @param {Object} parent
 */
function _table_create_(na,textContent,parent){
	var co=document.createElement(na);
	if(na=='td' || na==='th'){
		if(isNotEmpty(textContent)){
			co.innerHTML=textContent;
		}
	}else if(na=='input'){
		co.setAttribute("type","checkbox");
		if(isNotEmpty(textContent)){
			co.value=textContent;
		}
	}
	if(isNotEmpty(parent)){
		parent.appendChild(co);
	}
	return co;
}

/**
 * 表头设置
 * @param {Object} id
 * @param {Object} config
 */
function _table_header(id,config){
	var table=document.getElementById(id);
	table.innerHTML=""; //清空
	var tr=_table_create_("tr",null,table);
	for(var i=0;i<config.header.length;i++){
		var item=config.header[i];
		var th=_table_create_("th",item.value,tr);
		if(isNotEmpty(item.style))
			th.setAttribute("class",item.style);
		if(isNotEmpty(item.width))
			th.style.minWidth=item.width;
		th.field=item.field;
		if(item.oper){
			//是否可以操作
			var check=_table_create_("input",null,th);
			_table_th_checkbox(id,check);
		}
	} //end for
	_table_style_header(tr,config.color);//样式
}

/**
 * 设置表头复选框改变事件
 * @param {Object} id
 * @param {Object} box
 */
function _table_th_checkbox(id,box){
	box.onchange=function(){
		var boxes=document.getElementById(id).querySelectorAll("td input[type='checkbox']");
		for(var i=0;i<boxes.length;i++){
			boxes[i].checked=this.checked;
		} //end for
	} //end bind
}

/**
 * 每一行设置数据
 * @param {Object} tr
 * @param {Object} data
 * @param {Object} oper
 */
function _table_tr_data(tr,data,config){
	for(var i=0;i<config.header.length;i++){
		var item=config.header[i];
		var val=data[item.field];
		//是否操作
		if(item.oper){
			//可以操作
			var td=_table_create_("td",null,tr);
			var check=_table_create_("input",val,td);
			continue ;
		}
		if(isNotEmpty(config.style))
			tr.setAttribute("class",config.style);
		if(!isEmpty(item.template)){
			//模板修饰
			var td=_table_create_("td",item.template(val,data),tr);
		}else if(!isEmpty(val)) {
			//直接赋值
			var td=_table_create_("td",val,tr);
			continue;
		}else{
			//请求数据对应不上列，自己创建一个td占位
			var td=_table_create_("td",'',tr);
		}
	} //end for
}

