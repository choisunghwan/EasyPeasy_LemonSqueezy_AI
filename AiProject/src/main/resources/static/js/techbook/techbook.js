// Quill 에디터 초기화
var quill = new Quill('#editor', {
    theme: 'snow'
});


function registerTechbook() {

    var title = $("#title").val(); // 게시물 제목 가져오기
    var content = quill.root.innerHTML; // Quill 에디터의 내용을 HTML 형식으로 가져오기


    // AJAX를 사용하여 서버에 데이터 전송
    $.ajax({
        type: "POST", // POST 방식으로 전송
        url: "/techbook_create", // 게시물 등록 API 엔드포인트
        contentType: "application/json", // 요청 본문의 데이터 타입을 JSON으로 설정
        data: JSON.stringify({
            title: title,
            content: content
        }), // 데이터를 JSON 문자열로 변환하여 전송
        success: function(response) {
            // 성공적으로 등록되면 처리할 내용
            alert("게시물이 등록되었습니다.");
            // 페이지 새로고침 또는 등록 후의 작업 처리
            window.location = "/techbook_list";
        },
        error: function(xhr, status, error) {
            // 오류가 발생하면 처리할 내용
            alert("게시물 등록에 실패했습니다. 다시 시도해주세요.");
        }
    });
}