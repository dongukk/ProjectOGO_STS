var allText = document.querySelectorAll('.txt');

window.addEventListener('scroll', function() {
  var dis = window.pageYOffset / ((document.querySelector('.scroll_box').offsetHeight - window.innerHeight) / 2.6);
  var gap = 1;
  allText.forEach(function(arr, index) {
    arr.style = '--progress:' + (Math.max(0, dis - (index * gap))) + '';
  })
})