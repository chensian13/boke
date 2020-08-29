var host="http://boke/";
var serviceF=host;

var bokeUrl=serviceF+"boke/";
var userUrl=serviceF+"user/";
var nouserUrl=serviceF+"nouser/";
var typeUrl=serviceF+"type/";
var pictureUrl=serviceF+"picture/";
var webUrl=serviceF+"web/";
var workUrl=serviceF+"work/";
var specialUrl=serviceF+"special/";

function post(url,param,reqOk,notNeedLogin){
    var headersParam={};
    if(isEmpty(notNeedLogin)){
        //需要校验登录
        headersParam.checkLogin=true;
    }
    $.ajax({
        type : "POST",
        url : url,
        dataType : "json",
        async : true,
        headers : headersParam,
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

function postFile(formData,reqOk){
    $.ajax({
        url:pictureUrl+'/upload',
        dataType:'json',
        type:'POST',
        async: false,
        data: formData,
        processData: false,
        contentType : false, // 不要设置Content-Type请求头
        success: function(data){
            reqOk(data.model);
        },
        error:function(response){
            console.log(response);
        }
    });
}

function queryUrlParam(key){
    var search=location.search;
    var search=search.substring(1,search.length);
    var qs=search.split("&");
    for(var i=0;i<qs.length;i++){
        var ss=qs[i].split("=");
        if(ss[0]==key){
            return ss[1];
        }
    }
    return null;
}
