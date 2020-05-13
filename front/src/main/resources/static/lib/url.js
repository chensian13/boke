var host="http://127.0.0.1:9000/";
var bokeUrl=host+"boke/";
var userUrl=host+"user/";
var typeUrl=host+"type/";
var pictureUrl=host+"picture/";
var webUrl=host+"web/";

function post(url,param,reqOk){
    $.ajax({
        type : "POST",
        url : url,
        dataType : "json",
        async : true,
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

// function postFile(url,boxId,dataObj,reqOk){
//     $.ajaxFileUpload({
//         url: url,
//         secureuri: false, //安全模式
//         processData:false,
//         fileElementId: boxId,
//         dataType: 'json',
//         type:'post',
//         data:JSON.stringify(dataObj),
//         success : function (data) {
//             reqOk(data);
//         }
//     });
// }

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
