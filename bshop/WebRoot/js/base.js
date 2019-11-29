
//导航栏上菜单
(function() {
	$.ajax({
		type:"post",
		url:"navigationAction.do",
		data:{"min":0,"max":9},
		dataType:"json",
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		success:function(result){
			var str = ``;
			for(var i = 0; i < result.length; i++) {
				if(i < result.length - 1) {
					str = `
					<li class="category">
						<a target="_blank" href="/bshop/classify.jsp?middle_type=${result[i]}">${result[i]}</a>
						<div class="list-content left">
							<div class="inner-content">
								<h1>${result[i]}</h1>
								<p></p>
							</div>
						</div>
					</li>
				`;
					$('.tabs-list-buttom>.tabs-list').append(str);
				} else {
					str = `
					<li class="category">
						<a target="_blank" href="/bshop/classify.jsp?middle_type=${result[i]}">${result[i]}</a>
						<div class="list-content right">
							<div class="inner-content">
								<h1>${result[i]}</h1>
								<p></p>
							</div>
						</div>
					</li>
				`;
					$('.tabs-list-buttom>.tabs-list').append(str);
				}
			};
		}
	})

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

////鼠标点击进行筛选
//$('.part-screen>.product-next>ul').each(function(u){
//	var ttt=$('.part-screen>.product-next>ul').eq(u).siblings().children().children().html();
//	$('.part-screen>.product-next>ul').eq(u).children().each(function(i){
//		var myli=$('.part-screen>.product-next>ul').eq(u).children().eq(i).children();
//		myli.click(function(){
//			myli.css("color",'black');
//			myli.css("font-weight",'bold');
//			var condition=myli.html();
//			$('.part-screen>.product-filter').append("<div onclick='duanjuntang(this,"+u+","+i+")'><span>"+ttt+":</span><span>"+condition+"</span><span class='glyphicon glyphicon-remove'></span></div>");
//		})
//	})
//})
//
////获得筛选中的值
//function duanjuntang(obj,u,i){
//	$(obj).remove();
//	var myli=$('.part-screen>.product-next>ul').eq(u).children().eq(i);
//	myli.children().css("color",'#337ab7');
//	myli.children().css("font-weight",'normal');
//}

//BASE64加密解密方法
//创建Base64对象
var Base64 = {
_keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
encode: function(e) {
var t = "";
var n, r, i, s, o, u, a;
var f = 0;
e = Base64._utf8_encode(e);
while (f < e.length) {
n = e.charCodeAt(f++);
r = e.charCodeAt(f++);
i = e.charCodeAt(f++);
s = n >> 2;
o = (n & 3) << 4 | r >> 4;
u = (r & 15) << 2 | i >> 6;
a = i & 63;
if (isNaN(r)) {
 u = a = 64
} else if (isNaN(i)) {
 a = 64
}
t = t + this._keyStr.charAt(s) + this._keyStr.charAt(o) + this._keyStr.charAt(u) + this._keyStr.charAt(a)
}
return t
},
decode: function(e) {
var t = "";
var n, r, i;
var s, o, u, a;
var f = 0;
e=e.replace(/[^A-Za-z0-9+/=]/g,"");
while (f < e.length) {
s = this._keyStr.indexOf(e.charAt(f++));
o = this._keyStr.indexOf(e.charAt(f++));
u = this._keyStr.indexOf(e.charAt(f++));
a = this._keyStr.indexOf(e.charAt(f++));
n = s << 2 | o >> 4;
r = (o & 15) << 4 | u >> 2;
i = (u & 3) << 6 | a;
t = t + String.fromCharCode(n);
if (u != 64) {
 t = t + String.fromCharCode(r)
}
if (a != 64) {
 t = t + String.fromCharCode(i)
}
}
t = Base64._utf8_decode(t);
return t
},
_utf8_encode: function(e) {
e = e.replace(/rn/g, "n");
var t = "";
for (var n = 0; n < e.length; n++) {
var r = e.charCodeAt(n);
if (r < 128) {
 t += String.fromCharCode(r)
} else if (r > 127 && r < 2048) {
 t += String.fromCharCode(r >> 6 | 192);
 t += String.fromCharCode(r & 63 | 128)
} else {
 t += String.fromCharCode(r >> 12 | 224);
 t += String.fromCharCode(r >> 6 & 63 | 128);
 t += String.fromCharCode(r & 63 | 128)
}
}
return t
},
_utf8_decode: function(e) {
var t = "";
var n = 0;
var r = c1 = c2 = 0;
while (n < e.length) {
r = e.charCodeAt(n);
if (r < 128) {
 t += String.fromCharCode(r);
 n++
} else if (r > 191 && r < 224) {
 c2 = e.charCodeAt(n + 1);
 t += String.fromCharCode((r & 31) << 6 | c2 & 63);
 n += 2
} else {
 c2 = e.charCodeAt(n + 1);
 c3 = e.charCodeAt(n + 2);
 t += String.fromCharCode((r & 15) << 12 | (c2 & 63) << 6 | c3 & 63);
 n += 3
}
}
return t
}
}

