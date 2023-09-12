<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-top:30px">
    <form action="" class="was-validated">
        <div class="form-group">
            <label for="uemail">Email:</label>
            <input type="text" class="form-control" id="uemail" placeholder="Enter Email" name="uemail" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>


        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember" required> 위 내용을 기억합니다.
                <div class="valid-feedback">Valid.</div>
<%--                <div class="invalid-feedback">Check this checkbox to continue.</div>--%>
            </label>
        </div>
    </form>
    <button id="btn-login" class="btn btn-primary">로그인</button>
</div>
<script src="/blog/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>



