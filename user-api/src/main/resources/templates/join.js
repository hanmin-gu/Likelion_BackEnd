document.addEventListener("DOMContentLoaded", function () {
    const submitBtn = document.getElementById("submitBtn");


    function registerUser(birth, email, name, password, phone) {
        return fetch("http://localhost:8081/signup/customer", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({birth, email, name, password, phone}),
        });
    }

    submitBtn.addEventListener("click", function () {

        alert("버튼이 클릭되었습니다.")
        const inputName = document.getElementById("name").value;
        const inputEmail = document.getElementById("email").value;
        const inputPassword = document.getElementById("password").value;
        //const inputPasswordConfirm = document.getElementById("passwordConfirm").value;
        const inputBirth = document.getElementById("birth").value;
        const inputPhone = document.getElementById("phone").value;

        // 이 부분에 원하는 작업 수행
        console.log("이름:", inputName);
        console.log("이메일:", inputEmail);
        console.log("비밀번호:", inputPassword);
        //console.log("비밀번호 확인:", inputPasswordConfirm);

        // 회원가입 처리
        registerUser(inputBirth, inputEmail, inputName, inputPassword, inputPhone)
            .then((response) => {
                if (response.ok) {
                    alert("회원가입이 되었습니다!");

                    //window.location.href = 'http://ec2-52-78-115-0.ap-northeast-2.compute.amazonaws.com:8081/index.html'
                } else {
                    alert("회원가입 실패");
                }
            })
            .catch((error) => {
                console.error("에러 발생:", error);
                alert("회원가입 중 오류가 발생했습니다. 다시 시도해주세요."); // 여기에 누락된 따옴표를 추가했습니다.
            })
    });

})
;
