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
<script>
   $(document).ready(function() {
      $('.summernote').summernote({
         placeholder: '내용 입력',
         tabsize: 2,
         height: 300,
         fontNames: ['Arial', 'Helvetica', 'Times New Roman', '맑은 고딕', '돋움', '굴림'], // 원하는 한글 폰트를 추가합니다.
         fontNamesIgnoreCheck: ['맑은 고딕', '돋움', '굴림'], // 검사를 무시할 폰트를 지정합니다.
         toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['fontsize', ['fontsize']],
            ['fontname', ['fontname']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']]
         ]

      });
   });
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>



