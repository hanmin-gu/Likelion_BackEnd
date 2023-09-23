// JSON 데이터 (예제를 위해 하드코딩)
var jsonRegionData = [
  { id: 'regionCategory1', name: '특별ㆍ광역시' },
  { id: 'regionCategory2', name: '경기도' },
  { id: 'regionCategory3', name: '강원도' },
  { id: 'regionCategory4', name: '충청북도' },
  { id: 'regionCategory5', name: '충청남도' },
  { id: 'regionCategory6', name: '경상북도' },
  { id: 'regionCategory7', name: '경상남도' },
  { id: 'regionCategory8', name: '전라북도' },
  { id: 'regionCategory9', name: '전라남도' },
];
var jsonjobData = [
  { id: 'jobCategory1', name: '농산ㆍ수산ㆍ축산' },
  { id: 'jobCategory2', name: '환경' },
];

// JSON 데이터를 기반으로 자동으로 탭 생성
jsonRegionData.forEach(function (region) {
  addRegionTab(region.id, region.name);
});
jsonjobData.forEach(function (job) {
  addJobTab(job.id, job.name);
});

// 지역 탭
// 새로운 탭을 추가하는 함수
function addRegionTab(tabId, tabText) {
  // 새로운 탭을 생성
  var newTab = document.createElement('li');
  newTab.classList.add('nav-items');
  newTab.innerHTML = `
              <a class="nav-link top_category" id="${tabId}-tab" data-bs-toggle="tab" href="#${tabId}" role="tab"
                  aria-controls="${tabId}" aria-selected="false">${tabText}</a>
          `;

  // 탭 목록에 새로운 탭을 추가
  document.getElementById('regionTab').appendChild(newTab);
}

// 업무 탭
// 새로운 탭을 추가하는 함수
function addJobTab(tabId, tabText) {
  // 새로운 탭을 생성
  var newTab = document.createElement('li');
  newTab.classList.add('nav-items');
  newTab.innerHTML = `
              <a class="nav-link" id="${tabId}-tab" data-bs-toggle="tab" href="#${tabId}" role="tab"
                  aria-controls="${tabId}" aria-selected="false">${tabText}</a>
          `;

  // 탭 목록에 새로운 탭을 추가
  document.getElementById('jobTab').appendChild(newTab);
}

// 지역 상세 카테고리 생성
// JSON 데이터 (예시)
const regions1 = [
  "서울종로구",
  "서울중구",
  "서울용산구",
  "서울성동구",
  "서울광진구",
  "서울동대문구",
  "서울중랑구",
  "서울성북구",
  "서울강북구",
  "서울도봉구",
  "서울노원구",
  "서울은평구",
  "서울서대문구",
  "서울마포구",
  "서울양천구",
  "서울강서구",
  "서울구로구",
  "서울금천구",
  "서울영등포구",
  "서울동작구",
  "서울관악구",
  "서울서초구",
  "서울강남구",
  "서울송파구",
  "서울강동구",
  "세종",
  "대전",
  "대구",
  "부산",
  "광주",
  "제주"
];
const regions2 = [
  "가평시",
  "고양시",
  "과천시",
  "광명시",
  "광주시",
  "구리시",
  "군포시",
  "김포시",
  "남양주시",
  "동두천시",
  "부천시",
  "성남시",
  "수원시",
  "시흥시",
  "안산시",
  "안성시",
  "안양시",
  "양주시",
  "양평시",
  "여주시",
  "오산시",
  "용인시",
  "의왕시",
  "의정부시",
  "이천시",
  "파주시",
  "평택시",
  "포천시",
  "하남시",
  "화성시"];
const regions3 = [
  "강릉시",
  "동해시",
  "삼척시",
  "태백시",
  "속초시",
  "양구군",
  "인제군",
  "고성군",
  "양양군",
  "춘천시",
  "원주시",
  "강릉군",
  "평창군",
  "정선군",
  "철원군",
  "화천군"
];
const regions4 = [
  "괴산군",
  "단양군",
  "보은군",
  "영동군",
  "옥천군",
  "음성군",
  "제천시",
  "진천군",
  "청주시"
];
const regions5 = [
  "계룡시",
  "공주시",
  "금산군",
  "논산시",
  "당진시",
  "보령시",
  "부여군",
  "서산시",
  "서천군",
  "아산시",
  "예산군",
  "천안시",
  "청양군",
  "태안군",
  "홍성군"
];
const regions6 = [
  "경산시",
  "경주시",
  "고령군",
  "구미시",
  "군위군",
  "김천시",
  "문경시",
  "봉화군",
  "상주시",
  "성주군",
  "안동시",
  "영덕군",
  "영양군",
  "영주시",
  "영천시",
  "예천군",
  "울릉군",
  "울진군",
  "의성군",
  "청도군",
  "청송군",
  "칠곡군",
  "포항시"
];
const regions7 = [
  "거제시",
  "거창군",
  "고성군",
  "김해시",
  "남해군",
  "밀양시",
  "사천시",
  "산청군",
  "양산시",
  "의령군",
  "진주시",
  "창녕군",
  "창원시",
  "통영시",
  "하동군",
  "함안군",
  "함양군",
  "합천군"
];
const regions8 = [
  "고창군",
  "군산시",
  "김제시",
  "남원시",
  "무주군",
  "부안군",
  "순창군",
  "완주군",
  "익산시",
  "임실군",
  "장수군",
  "전주시",
  "정읍시",
  "진안군"
];
const regions9 = [
  "강진군",
  "고흥군",
  "곡성군",
  "광양시",
  "구례군",
  "나주시",
  "담양군",
  "목포시",
  "무안군",
  "보성군",
  "순천시",
  "신안군",
  "여수시",
  "영광군",
  "영암군",
  "완도군",
  "장성군",
  "장흥군",
  "진도군",
  "함평군",
  "해남군",
  "화순군"
];

// HTML에 버튼과 텍스트를 추가하는 함수
function addRegionButtonsAndText(categoryId, regionData) {
  const categoryContent = document.getElementById(categoryId + "Content");
  const categoryButtons = document.getElementById(categoryId + "Buttons");

  const buttonGroup = document.createElement("div");
  buttonGroup.className = "btn-group-toggle d-flex flex-wrap"; // 버튼 그룹을 가로로 정렬

  regionData.forEach((region, index) => {
    const buttonId = `${categoryId}Btn${index + 1}`; // 버튼 Id를 수정
    const labelText = region; // 지역 이름을 버튼 텍스트로 사용

    // 버튼 생성
    const button = document.createElement("input");
    button.type = "radio";
    button.className = `btn-check ctg${categoryId}`;
    button.name = "regionBtnRadio";
    button.id = buttonId;
    button.autocomplete = "off";

    // 라벨 생성
    const label = document.createElement("label");
    label.className = "btn btn-outline-primary";
    label.htmlFor = buttonId;
    label.innerText = labelText;

    // 버튼과 라벨을 div에 추가
    const buttonContainer = document.createElement("div");
    buttonContainer.appendChild(button);
    buttonContainer.appendChild(label);

    // div를 버튼 그룹에 추가
    categoryButtons.appendChild(buttonContainer);
  });
}

// JSON 데이터를 사용하여 HTML에 내용 추가
addRegionButtonsAndText("regionCategory1", regions1);
addRegionButtonsAndText("regionCategory2", regions2);
addRegionButtonsAndText("regionCategory3", regions3);
addRegionButtonsAndText("regionCategory4", regions4);
addRegionButtonsAndText("regionCategory5", regions5);
addRegionButtonsAndText("regionCategory6", regions6);
addRegionButtonsAndText("regionCategory7", regions7);
addRegionButtonsAndText("regionCategory8", regions8);
addRegionButtonsAndText("regionCategory9", regions9);


// 업무 상세 카테고리 생성
const job1 = [
  "판매",
  "포장",
  "유통",
  "수확",
  "기계",
  "경작",
  "시설관리"
];

const job2 = [
  "녹지조성",
  "생태계보호",
  "정화",
  "캠페인"
];

// HTML에 버튼과 텍스트를 추가하는 함수
function addJobButtonsAndText(categoryId, jobData) {
  const categoryContent = document.getElementById(categoryId + "Content");
  const categoryButtons = document.getElementById(categoryId + "Buttons");

  const buttonGroup = document.createElement("div");
  buttonGroup.className = "btn-group-toggle d-flex flex-wrap"; // 버튼 그룹을 가로로 정렬

  jobData.forEach((job, index) => {
    const buttonId = `${categoryId}Btn${index + 1}`; // 버튼 Id를 수정
    const labelText = job; // 업무 이름을 버튼 텍스트로 사용

    // 버튼 생성
    const button = document.createElement("input");
    button.type = "radio";
    button.className = `btn-check ctg${categoryId}`;
    button.name = "jobBtnRadio";
    button.id = buttonId;
    button.autocomplete = "off";

    // 라벨 생성
    const label = document.createElement("label");
    label.className = "btn btn-outline-primary";
    label.htmlFor = buttonId;
    label.innerText = labelText;

    // 버튼과 라벨을 div에 추가
    const buttonContainer = document.createElement("div");
    buttonContainer.appendChild(button);
    buttonContainer.appendChild(label);

    // div를 버튼 그룹에 추가
    categoryButtons.appendChild(buttonContainer);
  });
}

// JSON 데이터를 사용하여 HTML에 내용 추가
addJobButtonsAndText("jobCategory1", job1);
addJobButtonsAndText("jobCategory2", job2);


// 봉사글 상세 내용

/*
// json 예시
{
  "title": "감자캐기",
  "status": "모집중",
  "date": "2023-09-23",
  "capacity": "2명",
  "duration": "3시간",
  "location": "대전",
  "time": "20:59-23:59"
}
*/
fetch('http://localhost:8081/')
  .then(response => response.json())
  .then(data => {
    // JSON 데이터를 HTML 요소에 적용
    document.getElementById('title').textContent = data.title;
    document.getElementById('status').textContent = data.status;
    document.getElementById('date').textContent = data.date;
    document.getElementById('capacity').textContent = data.capacity;
    document.getElementById('duration').textContent = data.duration;
    document.getElementById('location').textContent = data.location;
    document.getElementById('time').textContent = data.time;
  })
  .catch(error => {
    console.error('JSON 파일 로드 중 오류 발생:', error);
  });