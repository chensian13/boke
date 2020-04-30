var host="http://127.0.0.1:9000/";
var bokeUrl=host+"boke/";
var userUrl=host+"user/";
var dicUrl=host+"dic/";

function post(url,param,reqOk){
    $.ajax({
        type : "POST",
        url : url,
        dataType : "json",
        async : false,
        contentType : 'application/json;charset=utf-8',
        data:JSON.stringify(param),
        xhrFields: {
            withCredentials: true //允许跨域带Cookie
        },
        success : function(data) {
            reqOk(data);
        },
        error : function(jqXHR) {
            console.log("Error: " + jqXHR.status);
        }
    });
}

function postFile(url,boxId,dataObj,reqOk){
    $.ajaxFileUpload({
        url: url,
        secureuri: false, //安全模式
        processData:false,
        fileElementId: boxId,
        dataType: 'json',
        type:'post',
        data:JSON.stringify(dataObj),
        success : function (data) {
            reqOk(data);
        }
    });
}