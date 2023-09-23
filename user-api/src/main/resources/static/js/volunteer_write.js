var startTimeInput = document.getElementById("startTime");
var endTimeInput = document.getElementById("endTime");

// 입력 필드에 이벤트 리스너를 추가하여 값이 변경될 때마다 계산합니다.
startTimeInput.addEventListener("input", calculateTimeDifference);
endTimeInput.addEventListener("input", calculateTimeDifference);

//시간 차 계산
function calculateTimeDifference() {
    // 시작 시간과 종료 시간의 값을 파싱하여 Date 객체로 변환합니다.
    var startTime = new Date("2023-09-23 " + startTimeInput.value);
    var endTime = new Date("2023-09-23 " + endTimeInput.value);

    // 시작 시간과 종료 시간의 차를 계산합니다.
    var timeDifference = endTime - startTime;

    // 차를 시간과 분으로 변환합니다.
    var hours = Math.floor(timeDifference / 3600000); // 밀리초를 시간으로 변환
    var minutes = Math.round((timeDifference % 3600000) / 60000); // 남은 밀리초를 분으로 변환

    var resultElement = document.getElementById("result");

    // 결과를 'time' 변수에 저장합니다.
    var time = hours + "시간 " + minutes + "분";

    // 결과를 화면의 p 태그에 자동으로 삽입합니다.
    resultElement.textContent = time;
}

function confirmTitle() {
    var dateInput = document.getElementById('date').value;
    var locationInput = document.getElementById('locatinInfo').value;
    var jobInput = document.getElementById('job').value;
    var contentInput = document.getElementById('content').value;
    var imageInput = document.getElementById('imageInput').value;
    var preferredQualificationInput = document.getElementById('preferredQualification').value;



    if (dateInput.trim() === '') {
        alert("일시를 입력해주세요");
        return false;
    } else if (detailTitle.trim() === '') {
        alert("제목을 입력해주세요.");
        return false;
    } else if (startTimeInput.trim() === '') {
        alert("시작시간을 입력해주세요.");
        return false;
    } else if (endTimeInput.trim() === '') {
        alert("종료시간을 입력해주세요.");
        return false;
    } else if (locationInput.trim() === '') {
        alert("주소를 입력해주세요.");
        return false;
    } else if (jobInput.trim() === '') {
        alert("업무을 입력해주세요.");
        return false;
    } else if (contentInput.trim() === '') {
        alert("상세내용을 입력해주세요.");
        return false;
    } else if (imageInput.trim() === '') {
        alert("사진을 등록해주세요.");
        return false;
    } else if (preferredQualificationInput.trim() === '') {
        alert("우대사항을 입력해주세요.");
        return false;
    } else {
        return confirm("게시글을 저장하시겠습니까?");
    }
}

/*
// 이미지 받기
document.addEventListener("DOMContentLoaded", function () {
    const imageInput = document.getElementById("imageInput");
    const downloadLink = document.getElementById("downloadLink");

    imageInput.addEventListener("change", function () {
        const selectedFile = imageInput.files[0];

        if (selectedFile) {
            const reader = new FileReader();

            reader.onload = function (e) {
                const imageData = e.target.result;

                // 이미지 데이터를 JSON으로 변환
                const jsonImageData = {
                    name: selectedFile.name,
                    type: selectedFile.type,
                    size: selectedFile.size,
                    data: imageData,
                };
            };

            reader.readAsDataURL(selectedFile);
        } else {
            alert("이미지를 먼저 선택하세요.");
        }
    });
});
*/

// 뒤로가기
function goBack() {
    window.history.back();
}