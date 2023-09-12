document.addEventListener("DOMContentLoaded", function () {
  const submitBtn = document.getElementById("submitBtn");

  // 회원가입 처리 함수
  function registerUser(birth, name, email, password, phone) {
    return fetch("http://localhost:8081/signup/customer", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({birth, email, name, password, phone}),
    });
  }

  submitBtn.addEventListener("click", function () {
    const inputName = document.getElementById("InputFrom1").value;
    const inputEmail = document.getElementById("InputFrom2").value;
    const inputPassword = document.getElementById("InputFrom3").value;
    const inputPasswordConfirm = document.getElementById("InputFrom4").value;
    const inputBirth= document.getElementById("InputFrom5").value;
    const inputPhone = document.getElementById("InputFrom6").value;

    // 이 부분에 원하는 작업 수행
    console.log("이름:", inputName);
    console.log("이메일:", inputEmail);
    console.log("비밀번호:", inputPassword);
    console.log("비밀번호 확인:", inputPasswordConfirm);

    // 회원가입 처리
    registerUser(inputBirth, inputEmail, inputName, inputPassword, inputPhone)
      .then((response) => {
        if (response.ok) {
          alert("회원가입이 되었습니다!");
        } else {
          alert("회원가입 실패");
        }
      })
      .catch((error) => {
        console.error("에러 발생:", error);
        alert("회원가입 중 오류가 발생했습니다. 다시 시도해주세요."); // 여기에 누락된 따옴표를 추가했습니다.
      })

  });
});
