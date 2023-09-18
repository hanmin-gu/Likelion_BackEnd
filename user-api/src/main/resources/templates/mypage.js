document.addEventListener("DOMContentLoaded", function () {
    const userNameElement = document.getElementById("user-name");
    const userEmailElement = document.getElementById("user-email");
    const logoutButton = document.getElementById("logout-button");

    const user = getUserInfo();

    if (user) {
        userNameElement.textContent = user.name;
        userEmailElement.textContent = user.email;
    }

    logoutButton.addEventListener("click", function () {
        logout();
        window.location.href = "login.html";
    });
});

// 사용자 정보를 가져오는 가상 함수
function getUserInfo() {

    const userToken = localStorage.getItem('token');

    console.log(userToken)

    fetch("http://localhost:8081/customer/getInfo", {
        method: 'GET',
        //mode: 'no-cors',
        headers: {
            "Content-Type": "application/json",
            "X-AUTH-TOKEN" : userToken
            },
    }).then(response => {
            //console.log(response.text())
            if (!response.ok){
                throw new Error('서버 응답이 실패했습니다.');
            }
            return response.json();
        })
        .then(data => {
            console.log('서버 응답 데이터:', data);
        })
        .catch(error => {
            console.error('에러:', error);
        });
}

function logout() {


}