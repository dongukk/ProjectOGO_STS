const toggleBtn = document.querySelector('.menuBtn');
const menu = document.querySelector('#nav_Menu');
const login = document.querySelector('#nav_login');

toggleBtn.addEventListener("click", () => { //클릭시 이벤트
  console.log("버튼클릭");
  menu.classList.toggle("navActive");
  login.classList.toggle("navActive"); // 설정너비 이하로 줄어들면 active 클래스 토글 설정
});
