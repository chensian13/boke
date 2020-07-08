/**
 * 下拉选择框解决方案
 */


/**
 * 
 */
function dropDialogComponent(){
	_drop_decorate(document.querySelectorAll("drop-dialog"));
}

/**
 * 
 * @param {Object} drops
 */
function _drop_decorate(drops){
	if(isEmpty(drops) || drops.length==0) return ;
	
	var dropDivs=document.getElementsByTagName("drop-div");
	for(var k=0;k<dropDivs.length;k++){
		dropDivs[k].style.display="none";
		dropDivs[k].style.position="absolute";
	} //end for
	
	for(var i=0;i<drops.length;i++){
		drops[i].style.display="inline-block";
		drops[i].onmouseenter=function(){
			var dropDiv=this.getElementsByTagName("drop-div")[0];
			dropDiv.style.display="block";
		} //end bind
		drops[i].onmouseleave=function(){
			var dropDiv=this.getElementsByTagName("drop-div")[0];
			dropDiv.style.display="none";
		} //end bind
	} //end for
}




