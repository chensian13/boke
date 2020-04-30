/**
 * 表单解决方案
 */
var FILE_TEXT_SIZE="14px";
var DEFAULT_IMG_HEIGHT="140px";

/**
 * 属性：
 * 1）头像高度 head
 * 2）支持文件类型
 * 3）按钮颜色
 * 4）按钮大小：普通，大型按钮
 */
function fileInputComponent(id){
	_file_decorate(document.getElementById(id));
}

function fileInputForm(id){
	var fi=document.getElementById(id);
	return fi.getElementsByTagName("input")[0].files;
}

//*************************************************************************************************
function _file_decorate(fi){
	if(isEmpty(fi)) return;
	_file_createComponents(fi);
	_file_input(fi);
	_file_Btn(fi);
	_file_span(fi);
	_file_img(fi);
	//按钮组件注入
	btnComponent();
}


function _file_createComponents(fi){
	var btn=document.createElement("button");
	var ip=document.createElement("input");
	var span=document.createElement("span");
	//是否支持头像显示
	if(isNotEmpty(fi.getAttribute("head"))){
		var img=document.createElement("img");
		fi.appendChild(img);
	}
	
	fi.appendChild(btn);
	fi.appendChild(span);
	fi.appendChild(ip);
}


/**
 * 创建按钮
 */
function _file_Btn(fi){
	var btn=fi.querySelector("button");
	var ip=fi.querySelector("input");
	var span=fi.querySelector("span");
	
	btn.setAttribute("big","");
	btn.setAttribute("color",fi.getAttribute("color"));
	btn.textContent=fi.getAttribute("value");
	btn.onclick=function(){
		ip.click();
	}
}

/**
 * 创建图片
 */
function _file_img(fi){
	var img=fi.querySelector("img");
	if(isEmpty(img)) return ;
	
	img.style.display="none";
	var h=fi.getAttribute("height");
	if(isNotEmpty(h)){
		img.style.height=h+"px";
	}else{
		img.style.height=DEFAULT_IMG_HEIGHT;
	}
	img.style.marginBottom="10px";
	img.style.borderStyle="solid";
	img.style.borderWidth="thin";
}

/**
 * 创建
 */
function _file_span(fi){
	var span=fi.querySelector("span");
	
	span.style.fontSize=FILE_TEXT_SIZE;
	span.style.marginLeft="10px";
}

/**
 * 创建按钮
 */
function _file_input(fi){
	var ip=fi.querySelector("input");
	var span=fi.querySelector("span");
	var img=fi.querySelector("img");
	
	ip.style.display="none";
	ip.setAttribute("type","file");
	if(isNotEmpty(fi.getAttribute("multiple"))){
		ip.setAttribute("multiple",fi.getAttribute("multiple"));
	}
	ip.setAttribute("accept",fi.getAttribute("accept"));
	ip.onchange=function(){
		if(isNotEmpty(ip.files[0]) 
				&& ip.files.length>0){
			if(ip.files.length>1){
				span.textContent=ip.files.length+"个文件";
			}else{
				//单个文件
				span.textContent=ip.files[0].name;
			}

			//是否显示图片
			if(isNotEmpty(img)){
				var windowURL = window.URL || window.webkitURL;
				img.setAttribute("src",windowURL.createObjectURL(ip.files[0]));
				img.style.display="block";
			}
		}else{
			//取消选择
			span.textContent="";
			if(isNotEmpty(img)){
				img.style.display="none";
			}
		} //end else
	} //end bind
}



