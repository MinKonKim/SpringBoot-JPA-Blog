<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-top:30px">
    <form class="was-validated">
        <div class="form-group">
            <label for="uname">Username:</label>
            <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="uemail">Email:</label>
            <input type="email" class="form-control" id="uemail" placeholder="Enter Email" name="uemail" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
    </form>
    <button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>



