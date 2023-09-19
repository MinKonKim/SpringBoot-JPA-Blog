<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>
<%--<script>--%>
<%--    Kakao.init('KAKAO_JAVASCRIPT_KEY'); // YOUR_JAVASCRIPT_KEY를 발급받은 키로 대체하세요.--%>

<%--    function loginWithKakao() {--%>
<%--        Kakao.Auth.login({--%>
<%--            success: function(authObj) {--%>
<%--                // 사용자 토큰은 authObj.access_token을 통해 얻을 수 있습니다.--%>
<%--                var userToken = authObj.access_token;--%>
<%--                // 여기에서 사용자 토큰을 사용하거나 서버로 전송할 수 있습니다.--%>
<%--            },--%>
<%--            fail: function(err) {--%>
<%--                console.log(err);--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>
<div class="container" style="margin-top:30px">
    <form class="was-validated" action="/auth/loginProc"  method = "post" >
        <div class="form-group">
            <label for="uname">Username:</label>
            <input type="text" name="username" class="form-control" id="uname" placeholder="Enter Username" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" name ="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <button  id="btn-login" class="btn btn-primary">로그인</button>

        <!-- KAKAO 로그인 요청 주소-->
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=8c28c140ae5be295966e9baae7c4991e&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img src="/image/kakao_login_button.png" height="38" /></a>
    </form>
</div>
<%@ include file="../layout/footer.jsp"%>



