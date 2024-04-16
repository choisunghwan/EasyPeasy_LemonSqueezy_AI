function submitReservation() {
    // 입력된 데이터 가져오기
    var reservationDate = $("#reservationDate").val();
    var attachmentType = $("input[name='rdo_1']:checked").val();
    var additionalMessage = $("#additionalMessage").val();

    // AJAX를 사용하여 서버로 데이터 전송
    $.ajax({
        url: "/submit-reservation", // 서버 엔드포인트 설정
        type: "POST", // POST 방식 사용
        contentType: "application/json", // 데이터 타입 설정
        data: JSON.stringify({
            reservationDate: reservationDate,
            attachmentType: attachmentType,
            additionalMessage: additionalMessage
        }),
        success: function(response) {
            // 서버로부터 응답을 받았을 때 실행할 코드
            alert("신청이 성공적으로 완료되었습니다.");
            // 필요한 경우 추가 작업 수행
        },
        error: function(xhr, status, error) {
            // AJAX 요청이 실패했을 때 실행할 코드
            alert("신청을 처리하는 동안 오류가 발생했습니다.");
            console.error("에러 발생:", error);
        }
    });
}
