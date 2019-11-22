
//导航栏上菜单
(function() {
	$.get('http://www.wjian.top/shop/api_cat.php', {}, function(result) {
		var obj = JSON.parse(result);
		if(obj.code != 0) {
			console.log(obj.message);
			return;
		}
		var goodsC = obj.data;
		var str = ``;
		for(var i = 0; i < goodsC.length; i++) {
			if(i < goodsC.length - 1) {
				str = `
				<li class="category">
					<a target="_blank" href="classify.jsp?cat_id=${goodsC[i].cat_id}&cat_name=${goodsC[i].cat_name}">${goodsC[i].cat_name}</a>
					<div class="list-content left">
						<div class="inner-content">
							<h1>上装</h1>
							<p></p>
						</div>
					</div>
				</li>
			`;
				$('.tabs-list-buttom>.tabs-list').append(str);
			} else {
				str = `
				<li class="category">
					<a target="_blank" href="classify.jsp?cat_id=${goodsC[i].cat_id}&cat_name=${goodsC[i].cat_name}">${goodsC[i].cat_name}</a>
					<div class="list-content right">
						<div class="inner-content">
							<h1>上装</h1>
							<p></p>
						</div>
					</div>
				</li>
			`;
				$('.tabs-list-buttom>.tabs-list').append(str);
			}
		};
	});
})();
//返回顶部
(function(){
	$(window).scroll(function(event){
		$(window).scrollTop()>=400?($('.toTop').show()):$('.toTop').hide();
	})
	$('.toTop').click(function(){
		$('body').animate({'scrollTop':0},500);
	})
})();


$('.logo').click(function(){
	location.href='index.jsp';
});



//获得地址栏参数值?  cat_id=55&name=xiaoming
function getUrlVal(property){
  //地址栏
  var urlStr = window.location.search.substring(1);
  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
  var result = urlStr.match(re);
  if(result == null){return null};
  return result[2];
};
//首页打开，判断用户是否登录
function checkLogin(){
	var userName=localStorage.getItem('username');
	var token=localStorage.getItem('token');
	var cartNumber=localStorage.getItem('cartnumber');
	$('.store_number').html(cartNumber);
	$('.mingZi').html('你好,'+userName);
	//验证
	if(token){
		$('.logBtn').show();
		$('.top-bar>.btn').hide();
	}else{
		$('.top-bar>.btn').show();
		$('.logBtn').hide();
	}
}
checkLogin();

//退出
$('.logBtn>.exitM').click(function(){
	localStorage.removeItem('username');
	localStorage.removeItem('token');
	localStorage.removeItem('cartnumber');
	
	$('.top-bar>.btn').show();
	$('.logBtn').hide();
})

//鼠标进入
$('.logBtn>.last-span').mouseenter(function(){
	$('.personalInfo').fadeIn(300);
})
$('.logBtn>.last-span').mouseleave(function(){
	$('.personalInfo').fadeOut(300);
})

