$(document).ready(function () {
    /* 페이지 로드 시 댓글 데이터 가져오기*/
    fetchComments();

});



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

/* S: 댓글 등록 */
function submitGuestbookComment() {
    // 댓글 내용과 게시물 ID 가져오기
    var commentContent = $("#textareaid").val();
    var guestbookId = $("#guestbookId").val(); // 게시물 ID 가져오기
    var satisfaction = $("input[name='rdo_chip_size2']:checked").val();
    // 선택된 체크박스 값 가져오기
    var selectedCheckboxes = [];
    $("input[name='chk1_1']:checked").each(function() {
        selectedCheckboxes.push($(this).val());
    });

    // 댓글 데이터
    var commentData = {
        content: commentContent,
        guestbookId: guestbookId, // 게시물 ID를 commentData에 추가
        satisfaction: satisfaction, // 만족 여부 추가
        selectedCheckboxes: selectedCheckboxes // 선택된 체크박스 값 추가
    };

    // Ajax 요청으로 댓글 데이터를 백엔드 컨트롤러로 전송
    $.ajax({
        type: "POST",
        url: "/comment/create/" + guestbookId, // 백엔드 컨트롤러의 URL에 게시물 ID 추가
        contentType: "application/json",
        data: JSON.stringify(commentData),
        success: function (response) {
            // 성공적으로 댓글이 등록된 경우
            alert("댓글이 성공적으로 등록되었습니다.");
            // 성공 후 수행할 작업 추가
        },
        error: function (xhr, status, error) {
            // 댓글 등록에 실패한 경우
            alert("댓글 등록에 실패했습니다. 다시 시도해주세요.");
            console.error(xhr.responseText);
        }
    });
}
/* E: 댓글 등록 */



/* S: 댓글 데이터를 가져와서 화면에 표시하는 함수 */
function fetchComments() {
    // Ajax 요청으로 댓글 데이터를 백엔드에서 가져옵니다.
    $.ajax({
        type: "GET",
        url: "/comments", // 댓글 데이터를 가져올 엔드포인트 URL
        success: function(response) {
            // 성공적으로 데이터를 가져온 경우
            displayComments(response); // 가져온 데이터를 화면에 표시합니다.
        },
        error: function(xhr, status, error) {
            // 데이터를 가져오는 데 실패한 경우
            console.error(xhr.responseText);
        }
    });
}
/* E: 댓글 데이터를 가져와서 화면에 표시하는 함수 */


/* S: 댓글 데이터를 화면에 표시하는 함수*/
function displayComments(comments) {
    var commentList = $("#comment-list"); // 댓글을 표시할 요소
    commentList.empty(); // 기존에 표시되던 댓글을 모두 지웁니다.

    // 각 댓글을 순회하면서 화면에 추가합니다.
    comments.forEach(function(comment) {
        // 댓글을 표시할 HTML 코드를 생성합니다.
        var commentHTML = '<div class="comment">';
        commentHTML += '<p class="comment-content">' + comment.content + '</p>';
        commentHTML += '<p class="comment-date">' + comment.createdAt + '</p>';
        commentHTML += '</div>';

        // 생성된 HTML 코드를 댓글 리스트에 추가합니다.
        commentList.append(commentHTML);
    });
}
/* E: 댓글 데이터를 화면에 표시하는 함수*/