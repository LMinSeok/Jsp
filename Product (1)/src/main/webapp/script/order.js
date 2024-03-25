function open_win(url, orderid) {
	window.open(url, orderid, "width=500, height=230");
}
function confirmDelete() {
	if (confirm("정말 삭제하시겠습니까?")) {
		document.getElementById("order").submit();
	} else {
		return false; // 취소 버튼을 눌렀을 때 폼을 제출하지 않음
	}
}
