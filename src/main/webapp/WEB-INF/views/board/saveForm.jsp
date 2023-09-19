<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/summernote-bs4.min.js"></script>

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

<!-- 스타일 직접 정의 -->
<style>
   /* Summernote 텍스트 스타일 변경 예제 */
   .note-editable p {
      font-family: 'Arial', sans-serif;
      font-size: 14px;
      color: #333;
   }

   /* Summernote 버튼 스타일 변경 예제 */
   .note-btn {
      background-color: #000;
      color: #fff;
   }
</style>
<script src="/js/board.js"></script>
<script>
   $(document).ready(function() {
      $('.summernote').summernote();
   });
</script>

<%@ include file="../layout/footer.jsp"%>



