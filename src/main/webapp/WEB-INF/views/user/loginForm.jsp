<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>
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


<%--        <div class="form-group form-check">--%>
<%--            <label class="form-check-label">--%>
<%--                <input class="form-check-input" name="remember" type="checkbox" name="remember" required> 위 내용을 기억합니다.--%>
<%--                <div class="valid-feedback">Valid.</div>--%>
<%--&lt;%&ndash;                <div class="invalid-feedback">Check this checkbox to continue.</div>&ndash;%&gt;--%>
<%--            </label>--%>
<%--        </div>--%>
        <button  id="btn-login" class="btn btn-primary">로그인</button>
    </form>
</div>
<%@ include file="../layout/footer.jsp"%>



