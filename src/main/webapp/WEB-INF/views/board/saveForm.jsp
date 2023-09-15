<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../layout/header.jsp"%>
<div class="container" style="margin-top:30px">
   <div class="container">
      <h1 class="mt-5">글쓰기</h1>
      <form action="/api/board" method="post">
         <div class="form-group">
            <label for="title">제목:</label>
            <input type="text" class="form-control" id="title" name="title" required placeholder="제목 입력">
         </div>

         <div class="form-group">
            <label for="content">내용:</label>
            <textarea class="form-control summernote" id="content" name="content" rows="5" ></textarea>
         </div>
      </form>
      <button id="btn-save" class="btn btn-primary">완료</button>
   </div>
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>



