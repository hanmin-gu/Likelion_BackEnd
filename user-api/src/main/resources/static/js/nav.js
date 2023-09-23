//document.addEventListener("DOMContentLoaded", function () {
const navContainer = document.getElementById("navContainer");

//const loginPath = document.getElementById("login");
const xhr = new XMLHttpRequest();
const xhrLogin = new XMLHttpRequest();


xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
        // 성공적으로 파일을 불러올 때 파일 내용을 출력합니다.
        navContainer.innerHTML = xhr.responseText;
    }
};

function pageLogin() {
    return fetch("http://ec2-43-201-20-174.ap-northeast-2.compute.amazonaws.com:8081/login", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    });
}


xhr.open("GET", "http://ec2-43-201-20-174.ap-northeast-2.compute.amazonaws.com:8081/navrequest", true);

xhr.send();


/*

function isUserLoggedIn() {
    if (localStorage.getItem('token') != null) {
        return true;
    } else {
        return false;
    }
}

var isLoggedIn = isUserLoggedIn();


//console.log(isLoggedIn);

/*
// 로그인 상태 확인
var login_Content = document.getElementById("loginContent");
var logout_Content = document.getElementById("logoutContent");

//console.log(login_Content);
//console.log(logout_Content);

if (isLoggedIn) {
    login_Content.style.display = "block";
    logout_Content.style.display = "none";
} else {
    login_Content.style.display = "none";
    logout_Content.style.display = "block";
}

*/

