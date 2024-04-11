/* S: 방명록 등록 함수*/
function registerGuestbook() {

    var title = $("#title").val();
    // 게시물 내용을 textarea에서 가져오기
    var content = $("#content").val();

    // AJAX를 사용하여 서버에 데이터 전송
    $.ajax({
        type: "POST", // POST 방식으로 전송
        url: "/guestbook_create", // 게시물 등록 API 엔드포인트
        contentType: "application/json", // 요청 본문의 데이터 타입을 JSON으로 설정
        data: JSON.stringify({
            title: title,
            content: content
        }), // 데이터를 JSON 문자열로 변환하여 전송
        success: function(response) {
            // 성공적으로 등록되면 처리할 내용
            alert("게시물이 등록되었습니다.");
            // 페이지 새로고침 또는 등록 후의 작업 처리
            window.location = "/guestbook_list";
        },
        error: function(xhr, status, error) {
            // 오류가 발생하면 처리할 내용
            alert("게시물 등록에 실패했습니다. 다시 시도해주세요.");
        }
    });
}
/* E: 방명록 등록 함수*/


/* S: 게시물 삭제 함수*/
function deleteGuestbook() {
    var guestbookId = $("#guestbookId").val();
    var confirmDelete = confirm("정말로 삭제하시겠습니까?");
    if (confirmDelete) {
        // 게시물 삭제를 위한 AJAX 요청
        $.ajax({
            type: "DELETE",
            url: "/guestbook_delete/"+guestbookId, // DELETE 핸들러로 요청을 보내기 위해 URL 수정
            success: function (response) {
                alert("게시물이 성공적으로 삭제되었습니다.");
                // 삭제 후 의 처리
                window.location.href = "/guestbook_list";
            },
            error: function (xhr, status, error) {
                // 오류 발생 시 처리할 내용
                alert("게시물 삭제에 실패했습니다. 다시 시도해주세요.");
            },
        })
    }

}
/* E: 게시물 삭제 함수*/


/* S: 게시물 수정 함수*/
function updateGuestbook() {
    var guestbookId = $("#guestbookId").val();
    var title = $("#title").val();
    var content = $("#content").val();

    // 유효성 검사 등 필요한 로직 추가

    var confirmupdate = confirm("수정하시겠습니까?");
    if (confirmupdate) {
        // 방명록 수정을 위한 AJAX 요청
        $.ajax({
            type: "PUT",
            url: "/update_guestbook/" + guestbookId, // URL에 게시물의 ID 포함
            data: JSON.stringify({
                title: title,
                content: content
            }),
            contentType: "application/json", // 요청의 Content-Type을 명시
            success: function (response) {
                alert("게시물이 성공적으로 수정되었습니다.");
                // 수정 후의 처리
                window.location.href = "/guestbook_list";
            },
            error: function (xhr, status, error) {
                // 오류 발생 시 처리할 내용
                alert("게시물 수정에 실패했습니다. 다시 시도해주세요.");
            },
        })
    }
}
/* E: 게시물 수정 함수*/