<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-top:30px">
    <div class="container">
        <h1 class="mt-5">글쓰기</h1>
        <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
        <c:if test="${board.user.id == principal.user.id}">
            <a href="/board/${board.id}/updateForm" class="btn btn-primary">수정</a>
            <button id="btn-delete" class="btn btn-danger">삭제</button>
        </c:if>
        <br/><br/>
        <div>
            글 번호: <span id="id"><i>${board.id}</i></span>
            작성자: <span><i>${board.user.username}</i></span>
        </div>
        <br/>
            <div class="form-group">
                <h3 id="title" name="title">${board.title}</h3>
            </div>
            <hr/>
                <div id="content">
                    ${board.content}
                </div>
            <hr/>
        <button id="btn-save" class="btn btn-primary">완료</button>
    </div>
</div>
<%@ include file="../fontStyle.jsp"%>
<script src="/js/summerNoteManager.js"></script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>



