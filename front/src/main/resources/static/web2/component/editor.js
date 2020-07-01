var content=document.getElementById("content");
var imgW=document.getElementById("imgW");
var imgH=document.getElementById("imgH");
var imgSrc=document.getElementById("imgSrc");
var showImg=document.getElementById("showImg");
var fileUp=document.getElementById("file");

var maxW=content.offsetWidth;
var maxH=content.offsetHeight;

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
	btn.onclick=function(){
		btnHref();
	}
	popShow("contentHref",false);
}

function setImg(){
	cleanImg();
	popShow("contentImg");
	showImg.style.display="none";
	fileUp.style.display="block";
	
	var btnImg=contentImg.querySelectorAll("button")[1];
	btnImg.onclick=function(){
		var formData = new FormData();
		formData.append("upload",fileInputForm("file")[0]);
		postFile(formData,function (url) {
			saveImg(null,url);
		})
	};
}

function saveImg(img,url){
	if(isEmpty(img)){
		img=document.createElement("img");
		imgEvent(img);
		content.append(img);
		content.append(document.createElement("br"));
	}
	if(!isEmpty(url))
		img.setAttribute("src",url); //imgSrc.value
	
	var w=imgW.value;
	var h=imgH.value;
	if((isNotEmpty(w) && w>=maxW) 
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
	imgW.value="";
	imgH.value="";
	imgSrc.value="";
}

function imgEvent(img){
	img.ondblclick=function(){
		cleanImg();
		popShow("contentImg");
		showImg.style.display="block";
		fileUp.style.display="none";
		
		showImg.setAttribute("src",img.getAttribute("src"));
		imgW.value=img.getAttribute("width");
		imgH.value=img.getAttribute("height");
		imgSrc.value=img.getAttribute("src");
		
		var btnImg=contentImg.querySelectorAll("button")[1];
		btnImg.onclick=function(){
			saveImg(img);
		};
	};
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
		t=document.createElement("div");
		content.append(t);
		content.append(document.createElement("br"));
	}
	t.innerHTML=inpu.value;
	t.setAttribute("class",sele.value);
	t.ondblclick=function(){
		//cleanTitle();
		var thisT=this;
		inpu.value=thisT.innerHTML;
		sele.value=t.getAttribute("class");
		var btn=contentTitle.querySelector("button");
		btn.onclick=function(){
			btnTitle(thisT);
		}
		popShow("contentTitle");
	}
	popShow("contentTitle",false);
}

