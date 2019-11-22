var liNum = $('.section-banner>.banner>ul>li').length;
//设置ul
$('.banner>ul').css({
	width: liNum * parseInt($('.banner>ul>li:first').css('width')),
})
//信息量
var n = 0;
var num = 0;
//自动播放
var timer = null;
autoPlay();

//鼠标移入移出
$('.section-banner>.banner').mouseenter(function() {
	clearInterval(timer);
});
$('.section-banner>.banner').mouseleave(function() {
	autoPlay();
})

function autoPlay() {
	timer = setInterval(rightBtn, 4000);
}

//点击下一张
$('.banner>.next').click(rightBtn);

//点击上一张
$('.banner>.prev').click(function() {
	if($('.banner>ul').is(':animated')) {
		return;
	}
	//闪现
	if(n <= 0) {
		n = liNum - 1;
		$('.banner>ul').css({
			left: -n * parseInt($('.banner>ul>li:first').css('width')),
		});
	};
	n--;
	$('.banner>ul').animate({
		'left': -n * parseInt($('.banner>ul>li:first').css('width'))
	}, 1000, function() {})
	//小圆点
	num--;
	if(num < 0) {
		num = $('.banner>.number>span').length - 1
	};
	exclusive();
})

//点击小圆点
$('.banner>.number>span').each(function(i) {
	$(this).click(function() {
		if($('.banner>ul').is(':animated')) {
			return;
		}
		//事件关联
		n = i;
		num = i;
		$('.banner>ul').animate({
			'left': -i * parseInt($('.banner>ul>li:first').css('width'))
		}, 1000);
		//调用小圆点
		exclusive();
	})
});

//小圆点的变化
function exclusive() {
	$('.banner>.number>span').eq(num).css('background', '#707070').siblings('span').css('background', '#CCCCCC');
}

//右边走,下一张
function rightBtn() {
	if($('.banner>ul').is(':animated')) {
		return;
	}
	n++;
	if(n > liNum - 1) {
		n = 0;
	}
	//				console.log(n);
	//动画事件
	$('.banner>ul').animate({
		'left': -n * parseInt($('.banner>ul>li:first').css('width'))
	}, 1000, function() {
		//闪现
		if(n >= liNum - 1) {
			$('.banner>ul').css('left', 0);
			n = 0;
		}
		//					$(this).animate({'left':-n*parseInt($('.banner>ul>li:first').css('width'))},1000);
	})
	//小圆点
	num++;
	if(num > 6) {
		num = 0
	};
	exclusive();
}