/**
 * 列表方案
 */

function listComponent(id,datas,fn){
	var li=queryComponent('list',id);
	li.innerHTML=null;
	for(var i=0;i<datas.length;i++){
		var e=_list_create_one(id,datas[i]);
		e.eid=datas[i].id;
		e.onclick=function(){
			if(!isEmpty(fn))
				fn(this.eid);
		}
	}
}



//**************************************************

function _list_create_one(id,data){
	var li=queryComponent('list',id);
	var liste=document.createElement("list-item");
	var img=document.createElement("img");
	var di=document.createElement("div");
	var h1=document.createElement("h1");
	var info=document.createElement("div");
	var cl=document.createElement("div");
	
	di.setAttribute("class","list-info");
	cl.style.clear="both";

	if(!isEmpty(data.img)){
		img.setAttribute("src",data.img);
		liste.appendChild(img);
	}else{
		di.style.width="100%";
	}
	liste.appendChild(di);
	liste.appendChild(cl);
	di.appendChild(h1);
	di.appendChild(document.createElement("hr"));
	di.appendChild(info);
	li.appendChild(liste);

	h1.innerHTML=data.title;
	info.innerHTML=data.info;
	return liste;
}


