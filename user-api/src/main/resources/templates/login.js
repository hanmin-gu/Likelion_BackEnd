document.addEventListener("DOMContentLoaded", function () {
    const submitLogin = document.getElementById("submit");


    submitLogin.addEventListener("click", function () {

        //alert("버튼이 클릭되었습니다.")
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;


        login(email, password).then((response) => {
            if (response.ok) {
                alert("로그인 되었습니다!");

                return response.text()
                //window.location.href = 'http://localhost:8081/mypage.html'
            } else {
                alert("로그인 실패");
            }
        }).then(data => {
            localStorage.setItem('token', data);
            const responseText = localStorage.getItem('token')
            console.log(responseText)
        })

            .catch((error) => {
                console.error("에러 발생:", error);
                //alert("로그인 중 오류가 발생 했습니다. 다시 시도해주세요."); // 여기에 누락된 따옴표를 추가했습니다.
            })

    });

    function login(email, password) {
        return fetch("http://localhost:8081/signin/customer", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({email, password}),

        });
    }

    function validate() {
        return fetch("http://localhost:8081/checkVerify", {
            method: "GET",
            headers:
                {
                    "Content_Type":
                        "application/json",
                },
        });
    }

});

