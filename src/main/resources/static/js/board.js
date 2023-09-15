let index= {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
    },

    save:function (){
        let data={
            title:$("#title").val(),
            content:$("#content").val(),
        };

        // console.log(data);
        $.ajax({
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data), //JSON 문자열, http body 데이터
            contentType: "application/json;charset=utf-8", //body 데이터가 어떤 타입인지(MIME)
            dataType:"json"//요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면)=>
            // javascript 오브젝트로 변경
        }).done(function (resp){//응답결과가 성공인 경우
            alert("글쓰기 완료!");
            location.href="/";
        }).fail(function (error){//응답결과가 실패인 경우
            alert(JSON.stringify(error));
        });
    },
    update:function (){
        let id= $("#id").val();

        let data={
            title:$("#title").val(),
            content:$("#content").val(),
        };

        // console.log(data);
        $.ajax({
            type:"PUT",
            url:"/api/board/"+id,
            data:JSON.stringify(data), //JSON 문자열, http body 데이터
            contentType: "application/json;charset=utf-8", //body 데이터가 어떤 타입인지(MIME)
            dataType:"json"//요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면)=>
            // javascript 오브젝트로 변경
        }).done(function (resp){//응답결과가 성공인 경우
            alert("글수정 완료!");
            location.href="/";
        }).fail(function (error){//응답결과가 실패인 경우
            alert(JSON.stringify(error));
        });
    },

    deleteById:function (){
        var id = $("#id").text();

        $.ajax({
            type:"DELETE",
            url:"/api/board/"+id,
            dataType:"json"//요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면)=>
        }).done(function (resp){//응답결과가 성공인 경우
            alert("글 삭제가 완료!");
            location.href="/";
        }).fail(function (error){//응답결과가 실패인 경우
            alert(JSON.stringify(error));
        });
    }

}


index.init();