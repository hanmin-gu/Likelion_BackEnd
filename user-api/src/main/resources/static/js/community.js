// 글 목록 데이터 (예시)
var articles = [
    { 번호: 1, 제목: '첫번째 글이 엄청 길어진다면 어떻게 될까 궁금해서 진짜 돌아버리겠네 빙글빙글', 작성일: '2023-09-14', 조회수: 100 },
    { 번호: 2, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 },
    { 번호: 3, 제목: '세 번째 글', 작성일: '2023-09-16', 조회수: 300 },
    { 번호: 4, 제목: '첫 번째 글', 작성일: '2023-09-14', 조회수: 100 },
    { 번호: 5, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 },
    { 번호: 6, 제목: '세 번째 글', 작성일: '2023-09-16', 조회수: 300 },
    { 번호: 7, 제목: '첫 번째 글', 작성일: '2023-09-14', 조회수: 100 },
    { 번호: 8, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 },
    { 번호: 9, 제목: '세 번째 글', 작성일: '2023-09-16', 조회수: 300 },
    { 번호: 10, 제목: '첫 번째 글', 작성일: '2023-09-14', 조회수: 100 },
    { 번호: 11, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 },
    { 번호: 12, 제목: '세 번째 글', 작성일: '2023-09-16', 조회수: 300 },
    { 번호: 13, 제목: '첫 번째 글', 작성일: '2023-09-14', 조회수: 100 },
    { 번호: 14, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 },
    { 번호: 15, 제목: '세 번째 글', 작성일: '2023-09-16', 조회수: 300 },
    { 번호: 16, 제목: '첫 번째 글', 작성일: '2023-09-14', 조회수: 100 },
    { 번호: 17, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 },
    { 번호: 18, 제목: '세 번째 글', 작성일: '2023-09-16', 조회수: 300 },
    { 번호: 19, 제목: '첫 번째 글', 작성일: '2023-09-14', 조회수: 100 },
    { 번호: 20, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 },
    { 번호: 21, 제목: '세 번째 글', 작성일: '2023-09-16', 조회수: 300 },
    { 번호: 22, 제목: '첫 번째 글', 작성일: '2023-09-14', 조회수: 100 },
    { 번호: 23, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 },
    { 번호: 24, 제목: '세 번째 글', 작성일: '2023-09-16', 조회수: 300 },
    { 번호: 25, 제목: '두 번째 글', 작성일: '2023-09-15', 조회수: 200 }
];

// HTML 요소를 찾기 위한 부모 요소를 선택합니다.
var container = document.querySelector('.container.text-center');

// 테이블 요소를 생성합니다.
var table = document.createElement('table');
table.className = 'table table-bordered'; // Bootstrap 테이블 스타일 클래스

// 테이블 헤더를 생성합니다.
var thead = document.createElement('thead');
var headerRow = document.createElement('tr');

var headers = ['번호', '제목', '작성일', '조회수'];

headers.forEach(function (headerText) {
  var th = document.createElement('th');
  th.textContent = headerText;
  headerRow.appendChild(th);
});

thead.appendChild(headerRow);
table.appendChild(thead);

// 테이블 바디를 생성합니다.
var tbody = document.createElement('tbody');

articles.forEach(function (article) {
  var row = document.createElement('tr');

  var columns = ['번호', '제목', '작성일', '조회수'];

  columns.forEach(function (column) {
    var td = document.createElement('td');

    // 제목 열인 경우 <a> 태그로 생성
    if (column === '제목') {
      var link = document.createElement('a');
      link.href = ''; // 여기에 링크 URL을 설정하세요.
      link.textContent = article[column];
      td.appendChild(link);
    } else {
      td.textContent = article[column];
    }

    row.appendChild(td);
  });

  tbody.appendChild(row);
});

table.appendChild(tbody);

// 생성된 테이블을 부모 요소에 추가합니다.
container.appendChild(table);
