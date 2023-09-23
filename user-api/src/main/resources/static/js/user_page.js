document.addEventListener("DOMContentLoaded", function () {
    const logoutButton = document.getElementById("logout-button");

    logoutButton.addEventListener("click", function () {
        localStorage.clear();
        console.log(localStorage.getItem('token'));
        window.location.href = "http://ec2-43-201-20-174.ap-northeast-2.compute.amazonaws.com:8081"
    });

    const userToken = localStorage.getItem('token');

    console.log(userToken)

    fetch("http://ec2-43-201-20-174.ap-northeast-2.compute.amazonaws.com:8081/customer/Inf/getInfo", {
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
            document.getElementById('email').textContent = "이메일" + data.first.email;
            document.getElementById('age').textContent = "연 령" + data.first.age;
            document.getElementById('volunteerTime').textContent = data.first.balance;
            document.getElementById('numOfActivity').textContent = data.second;
            console.log('서버 응답 데이터:', data);
        })
        .catch(error => {
            console.error('에러:', error);
        });
});



// 페이지 로드 후 데이터를 가져오도록 호출

function logout(){
    localStorage.clear();
    console.log(localStorage.getItem('token'));
}