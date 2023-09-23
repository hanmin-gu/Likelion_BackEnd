document.addEventListener("DOMContentLoaded", function () {
    const submitBtn = document.getElementById("submitBtn");
  
    // 회원가입 처리 함수
    function registerUser(birth, email, name, password, phone) {
      return fetch("http://ec2-43-201-20-174.ap-northeast-2.compute.amazonaws.com:8081/signup/customer", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({birth, email, name, password, phone}),
      });
    }
  
    submitBtn.addEventListener("click", function () {
      const inputName = document.getElementById("name").value;
      const inputEmail = document.getElementById("email").value;
      const inputPassword = document.getElementById("password").value;
      //const inputPasswordConfirm = document.getElementById("passwordConfirm").value;
      const inputBirth= document.getElementById("birth").value;
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
            alert("회원가입이 되었습니다! 이메일 인증 해주세요.");
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

  // 생년월일 변환
  function formatNumber(input) {
    if (/^\d{8}$/.test(input)) {
      return input.slice(0, 4) + '-' + input.slice(4, 6) + '-' + input.slice(6, 8);
    } else {
      alert('올바른 8자리 숫자를 입력하세요.');
    }
  }

  function formatBirth() {
    var inputElement = document.getElementById('birth');
    var inputValue = inputElement.value.replace(/\D/g, ''); // 숫자 이외의 문자 제거

    if (inputValue.length >= 8) {
        var formattedValue = inputValue.slice(0, 4) + '-' + inputValue.slice(4, 6) + '-' + inputValue.slice(6, 8);
        inputElement.value = formattedValue;
    } else {
        inputElement.value = inputValue;
    }
}
