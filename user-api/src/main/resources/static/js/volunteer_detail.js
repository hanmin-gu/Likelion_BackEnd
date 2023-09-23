// JSON 데이터 예시
const jsonData = {
    "시간": "3시간",
    "일시": "2023-09-23",
    "업무": "감자캐기",
    "지역": "대전광역시 대덕구 한남로 70",
    "봉사자격": "봉사자격 내용입니다.",
    "우대사항": "우대사항 내용입니다."
};

let combinedTimeText = "아이콘1: " + jsonData["시간"];
let combinedDateText = "아이콘2: " + jsonData["일시"];
let combinedLocationInfoText = "아이콘3: " + jsonData["지역"];

document.getElementById('headTime').textContent = combinedTimeText;
document.getElementById('headDate').textContent = combinedDateText;
document.getElementById('headLocationInfo').textContent = combinedLocationInfoText;

document.getElementById('time').textContent = jsonData["시간"];
document.getElementById('date').textContent = jsonData["일시"];
document.getElementById('jobDescription').textContent = jsonData["업무"];
document.getElementById('locationInfo').textContent = jsonData["지역"];
document.getElementById('volunteerQualification').textContent = jsonData["봉사자격"];
document.getElementById('preferredQualification').textContent = jsonData["우대사항"];


// 지원하기 기능

// 지도 출력하기
// 지도 출력하는 api가져와서 해야된다는데 부탁드립니다!