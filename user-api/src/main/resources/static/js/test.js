// JavaScript 파일 (script.js)

// 초기 페이지 로드 시 로그인 상태 확인
var isLoggedIn = false; // 예시: 초기에는 로그인되지 않은 상태로 설정

// HTML 업데이트 함수
function updatePageContent() {
    var loggedInContent = document.getElementById("loggedInContent");
    var loggedOutContent = document.getElementById("loggedOutContent");

    if (isLoggedIn) {
        loggedInContent.style.display = "block";
        loggedOutContent.style.display = "none";
    } else {
        loggedInContent.style.display = "none";
        loggedOutContent.style.display = "block";
    }
}

// 로그인 버튼 클릭 이벤트 핸들러
document.getElementById("loginButton").addEventListener("click", function() {
    // 로그인 로직을 추가 (예: 로그인 API 호출)

    // 로그인 상태 업데이트
    isLoggedIn = true;

    // HTML 업데이트
    updatePageContent();
});

// 로그아웃 버튼 클릭 이벤트 핸들러
document.getElementById("logoutButton").addEventListener("click", function() {
    // 로그아웃 로직을 추가 (예: 로그아웃 API 호출)

    // 로그아웃 상태 업데이트
    isLoggedIn = false;

    // HTML 업데이트
    updatePageContent();
});

// 초기 페이지 로드 시 HTML 업데이트
updatePageContent();