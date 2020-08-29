var content=document.getElementById("content");
var imgW=document.getElementById("imgW");
var imgH=document.getElementById("imgH");
var imgSrc=document.getElementById("imgSrc");
var fileUp=document.getElementById("file");

var contentImg=document.getElementById("contentImg");
var contentHref=document.getElementById("contentHref");
var contentTitle=document.getElementById("contentTitle");


btnComponent();
popComponent("contentImg");
popComponent("contentHref")
popComponent("contentTitle")
fileInputComponent('file',function(url){
	imgSrc.value=fileInputUrl("file");
});


function setHref(){
	var textA=contentHref.querySelector("textarea");
	var inpu=contentHref.querySelector("input");
	textA.value=null;
	inpu.value=null;
	popShow("contentHref");
}

function btnHref(a){
	var textA=contentHref.querySelector("textarea");
	var inpu=contentHref.querySelector("input");
	var btn=contentHref.querySelector("button");
	
	if(a==null){
		a=document.createElement("a");
		content.append(a);
	}
	a.innerHTML=textA.value;
	a.setAttribute("href",inpu.value);
	a.setAttribute("target","_blank");
	btn.onclick=function(){
		btnHref();
	}
	popShow("contentHref",false);
}

function setImg(){
	cleanImg();
	popShow("contentImg");

	var btnImg=contentImg.querySelectorAll("button")[1];
	btnImg.onclick=function(){
		var formData = new FormData();
		formData.append("upload",fileInputForm("file")[0]);
		postFile(formData,function (url) {
			if(isEmpty(url)){
				toastShow("图片格式不合法");
				return ;
			}
			saveImg(null,url);
		})
	};
}

function saveImg(img,url){
	if(isEmpty(img)){
		img=document.createElement("img");
		content.append(img);
		content.append(document.createElement("br"));
	}
	if(!isEmpty(url))
		img.setAttribute("src",url); //imgSrc.value
	
	var w=imgW.value;
	var h=imgH.value;
	if((isNotEmpty(w) && w>=content.offsetWidth)
		|| isEmpty(w)){
		w="100%";
	}
	img.setAttribute("width",w);
	
	if(isNotEmpty(h)){
		img.setAttribute("height",h);
	}
	
	popShow('contentImg',false);
}

function cleanImg(){
	fileInputClean('file');
	fileBanUpload('file',false);
	imgW.value="";
	imgH.value="";
	imgSrc.value="";
}



function cleanTitle(){
	var inpu=contentTitle.querySelector("input");
	var sele=contentTitle.querySelector("select");
	inpu.value=null;
	sele.value="h1";
}

function setTitle(){
	popShow("contentTitle");
	var inpu=contentTitle.querySelector("input");
	var sele=contentTitle.querySelector("select");
	inpu.value=null;
	sele.value="h1";
}


function btnTitle(t){
	var inpu=contentTitle.querySelector("input");
	var sele=contentTitle.querySelector("select");
	
	if(!t){
		t=document.createElement("title");
		content.append(t);
		content.append(document.createElement("br"));
	}
	t.innerHTML=inpu.value;
	t.setAttribute("class",sele.value);
	popShow("contentTitle",false);
}



//************************************编辑事件***********************************

function _edit_imgbind(){
	var imgs=content.querySelectorAll("img");
	for(var i=0;i<imgs.length;i++){
		imgs[i].ondblclick=function(){
			var img=this;
			cleanImg();
			popShow("contentImg");
			fileShowImgae('file',img.getAttribute("src"));
			fileBanUpload('file',true);

			imgW.value=img.getAttribute("width");
			imgH.value=img.getAttribute("height");
			imgSrc.value=img.getAttribute("src");

			var btnImg=contentImg.querySelectorAll("button")[1];
			btnImg.onclick=function(){
				saveImg(img);
			};
		};
	}
}


function _edit_titlebind() {
	var ts = content.querySelectorAll("title");
	for (var i = 0; i < ts.length; i++) {
		var t = ts[i];
		t.ondblclick=function(){
			var thisT=this;
			inpu.value=thisT.innerHTML;
			sele.value=t.getAttribute("class");
			var btn=contentTitle.querySelector("button");
			btn.onclick=function(){
				btnTitle(thisT);
			}
			popShow("contentTitle");
		}
	}
}


function _edit_hrefbind() {
	var as = content.querySelectorAll("a");
	for (var i = 0; i < as.length; i++) {
		var a = as[i];
		a.ondblclick=function(){
			var thisA=this;
			contentHref.getElementsByTagName("input")[0].value=thisA.getAttribute("href");
			contentHref.getElementsByTagName("textarea")[0].value=thisA.innerHTML;
			popShow("contentHref");

			var btn=contentHref.getElementsByTagName("button")[0];
			btn.onclick=function(){
				btnHref(thisA);
			}
		}
	}
}


function _edit_bindAll() {
	_edit_hrefbind();
	_edit_imgbind();
	_edit_titlebind();
}


window.setInterval(_edit_bindAll,500);