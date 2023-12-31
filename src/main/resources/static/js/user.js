let index= {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
    },

    save:function (){
        let data={
            username:$("#uname").val(),
            password:$("#pwd").val(),
            email:$("#uemail").val()
        };

        console.log(data);

        //AJAX 요청
        //ajax호출시 default가 비동기 호출
        // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
        $.ajax({
            //회원가입 수행 요청
            type:"POST",
            url:"/auth/joinProc",
            data:JSON.stringify(data), //JSON 문자열, http body 데이터
            contentType: "application/json;charset=utf-8", //body 데이터가 어떤 타입인지(MIME)
            dataType:"json"//요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면)=>
            // javascript 오브젝트로 변경
        }).done(function (resp){//응답결과가 성공인 경우
            alert("회원가입 완료.");
            location.href="/";
        }).fail(function (error){//응답결과가 실패인 경우
            alert(JSON.stringify(error));
        });
    },
    update:function (){
        let data={
            id:$("#id").val(),
            password:$("#pwd").val(),
            email:$("#uemail").val()
        };

        //AJAX 요청
        //ajax호출시 default가 비동기 호출
        // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
        $.ajax({
            //회원가입 수행 요청
            type:"PUT",
            url:"/user",
            data:JSON.stringify(data), //JSON 문자열, http body 데이터
            contentType: "application/json;charset=utf-8", //body 데이터가 어떤 타입인지(MIME)
            dataType:"json"//요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면)=>
            // javascript 오브젝트로 변경
        }).done(function (resp){//응답결과가 성공인 경우
            alert("회원 수정 완료.");
            location.href="/";
        }).fail(function (error){//응답결과가 실패인 경우
            alert(JSON.stringify(error));
        });
    }

}


index.init();