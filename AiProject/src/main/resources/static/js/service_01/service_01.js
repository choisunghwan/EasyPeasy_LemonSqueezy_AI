function registerService() {

    // 입력 필드에서 값을 가져옵니다.
    var serviceTitle = $("#service_title").val(); // 서비스 제목
    var guideContent = $("#guide_content").val(); // 서비스 가이드 내용
    var serviceTarget = $("#serviceTarget").val(); // 서비스 대상
    var serviceType = $("#serviceType").val(); // 서비스 유형
    var selectionCriteria = $("#selectionCriteria").val(); // 선정 기준
    var applicationMethod = $("#applicationMethod").val(); // 신청 방법

    // 데이터 유효성 검사 등이 필요하다면 여기서 수행합니다.

    // Ajax 요청을 보냅니다.
    $.ajax({
        url: '/register-service', // 서버 엔드포인트를 여기에 입력합니다.
        type: 'POST', // POST 요청을 보냅니다. 필요에 따라 변경할 수 있습니다.
        contentType: "application/json", // 요청 본문의 데이터 타입을 JSON으로 설정
        data:JSON.stringify( {
            service_title: serviceTitle,
            guide_content: guideContent,
            serviceTarget: serviceTarget,
            serviceType: serviceType,
            selectionCriteria: selectionCriteria,
            applicationMethod: applicationMethod
        }),
        success: function(response) {
            // 성공적으로 데이터를 등록한 경우에 수행할 작업을 여기에 추가합니다.
            alert("성공적으로 등록되었습니다.");
            console.log('데이터가 성공적으로 등록되었습니다.');
        },
        error: function(xhr, status, error) {
            // Ajax 요청이 실패한 경우에 대한 처리를 여기에 추가합니다.
            alert("등록에 실패했습니다.");
            console.error('데이터 등록에 실패했습니다:', error);
        }
    });
}