window.onload = function() {

  //scroll overRap

	var top = document.querySelector('.srolltext_wrap');
	var sectionMainVisual = document.querySelector('.sec_mainvis');
	var sectionOverlap = document.querySelector('.sec_list_overlap');
	var sectionMainTop;
	var sectionMainBottom;

	var winScrollTop;
	var sectionIsMoving = false;

	function setProperty() {

		winScrollTop = window.pageYOffset;
		sectionMainTop = sectionMainVisual.getBoundingClientRect().top + winScrollTop;
		sectionMainBottom = sectionMainTop + sectionMainVisual.offsetHeight;
	};

	function moveSection() {

		setProperty();

		if(winScrollTop > sectionMainTop && winScrollTop < sectionMainBottom) {

			if(!sectionIsMoving) {
				sectionIsMoving = true;
				moveStartRender();
			}
		}

		if(winScrollTop >= sectionMainBottom) {
			activeCehck();
		}

	};

	function activeCehck() {
		top.classList.add('active');
		sectionMainVisual.classList.add('active');
		sectionOverlap.classList.add('active');
	};

	function moveStartRender() {

			if(!top.classList.contains('active')) {
				sectionMainVisual.classList.add('active');
				sectionOverlap.classList.add('active');

				scrollMove(sectionMainBottom+1);

			}else {
        top.classList.remove('active');
				sectionMainVisual.classList.remove('active');
				sectionOverlap.classList.remove('active');

				scrollMove(sectionMainTop);
			}

	};

	function scrollMove(moveY) {

		var speed = 1;
		var vy = 0;
		var scrollY = 0;

		var loop = setInterval(function() {

			var dir = moveY > window.pageYOffset ? 1 : -1;
				vy += speed * dir;

				if(dir > 0) {
					scrollY = Math.min(moveY, window.pageYOffset + vy)
				} else {
					scrollY = Math.max(moveY, window.pageYOffset + vy)
				}

			window.scrollTo(0, scrollY);

			if(scrollY >= moveY && dir > 0) {
				sectionIsMoving = false;
				clearInterval(loop)
			} else if(scrollY <= moveY && dir < 0) {
				sectionIsMoving = false;
				clearInterval(loop)
			}
		}, 10);
	};

	function init() {

		moveSection();

	};

	window.addEventListener('scroll', function() {

		moveSection();
	});

	init();

  //TextImgScroll

  var TextImgScroll = function(element, fuc) {

    var el = document.querySelector(element);
    var TextImgScrollTop;
    var TextImgOfffsetTop;
    var TextImgHeight;
    var TextImgOffsetBottom;
    var checkInSection = false;
    var fastIn;
    
    var startFunction = fuc;
    var isFunction = typeof(startFunction) === 'function' ? true : false;
    
    function setTextImgScroll() {
    
      fastIn = window.innerHeight / 2;
      TextImgScrollTop = window.pageYOffset;
      TextImgOfffsetTop = el.getBoundingClientRect().top + TextImgScrollTop - fastIn;
      TextImgHeight = el.offsetHeight;
      TextImgOffsetBottom = TextImgOfffsetTop + TextImgHeight + fastIn;
    };
    
    function inSection() {
    
      setTextImgScroll();
    
      if(TextImgScrollTop >= TextImgOfffsetTop && TextImgScrollTop <= TextImgOffsetBottom) {
    
        if(isFunction && !checkInSection) {
          checkInSection = true;
          startFunction();
        }
      }
    };
    
    function init() {
    
      inSection();
    
    };
    
    window.addEventListener('scroll', function(){
      inSection();
    }, false);
    
    
    init();
    
    };
    
    
    
      TextImgScroll('.section_product .prd_mask', function(){
        document.querySelector('.section_product .prd_mask').classList.add('active');
      });
    
      TextImgScroll('.section_product .text_img', function(){
        document.querySelector('.section_product .text_img').classList.add('active');
      });


  //SVG Scroll

	var svgPath = document.querySelector('#takeoff path');
	var isPlay = false;

	function svgSet(){

		svgPath.style.strokeDasharray = svgPath.getTotalLength() + ',' + svgPath.getTotalLength();
		svgPath.style.strokeDashoffset = svgPath.getTotalLength();
	}

	function SVGinit(){
		svgSet();
		drawSvg();
	}

	function drawSvg(){

		var SVGTop = window.pageYOffset;
		var SVGHeight = document.body.offsetHeight;
		var SVGRealHeight = SVGHeight - window.innerHeight;
		var SVGPercent = (SVGTop / SVGRealHeight * 100) * 1;

		var SVGStartValue = svgPath.getTotalLength();
		var SVGMoveDistance = Math.max(SVGStartValue - SVGStartValue, Math.min(SVGStartValue, SVGStartValue - (SVGStartValue * (SVGPercent/100))));


		svgPath.style.strokeDashoffset = SVGMoveDistance;

		if(SVGPercent >= 96 && !isPlay){

			isPlay = true;
			document.querySelector('.video_wrap').style.opacity = 1;

			setTimeout(function(){
				document.querySelector('.video_wrap video').play();
				document.querySelector('.svg_wrap').style.opacity = 0;
			},500)

      setTimeout(function(){
        location.href='https://www.naver.com/'
      },3000);

		}else if(SVGPercent < 100 && isPlay){

			isPlay = false;
			document.querySelector('.video_wrap').style.opacity = 0;

			document.querySelector('.video_wrap video').pause();
			document.querySelector('.video_wrap video').currentTime = 0;

			document.querySelector('.svg_wrap').style.opacity = 1;

		}

	}

	window.addEventListener('scroll', function(){
		drawSvg();
	}, false);

	SVGinit();


}
