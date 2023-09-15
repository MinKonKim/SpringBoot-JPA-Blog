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