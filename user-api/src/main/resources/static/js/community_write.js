function confirmTitle() {
    var selectBoard = document.getElementById('boardTitle').value;
    var titleInput = document.getElementById('title').value;
    var contentInput = document.getElementById('content').value;
    if (selectBoard.trim() === '') {
        alert("게시판 종류를 선택해주세요");
        return false;
    } else if (titleInput.trim() === '') {
        alert("제목을 입력해주세요.");
        return false;
    } else if (contentInput.trim() === '') {
        alert("내용을 입력해주세요.");
        return false;
    } else {
        return confirm("게시글을 저장하시겠습니까?");
    }
}

function goBack() {
    window.history.back();
}