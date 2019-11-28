//获得地址参数栏的值
function getUrlVal(property) {
	//地址栏
	var urlStr = window.location.search.substring(1);
	var re = new RegExp('(^|&)' + property + '=([^&]*)(&|$)');
	var result = urlStr.match(re);
	if(result == null) {
		return null
	};
	return result[2];
};
(function() {
	//分类id
	var page = 1;
	var pagesize = 16;
	var urlVal;
	if(getUrlVal("middle_type")){
		urlVal=decodeURI(getUrlVal("middle_type"));
	};
	if(getUrlVal("goods_name")){
		urlVal=decodeURI(getUrlVal("goods_name"));
	}
	console.log(urlVal);
	$('title').html('B-SHOP嘿店——'+urlVal);
	function getGoodsList() {
		
		$.ajax({
			type:"post",
			url:"goodsByConditionsAction.do",
			data:{
				page:page,
				pagesize:pagesize,
				middle_type:urlVal,
			},
			dataType:"json",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(result){
				
			}
		})
		
		$.get('http://www.wjian.top/shop/api_goods.php', {
			cat_id: catId,
			page: page,
			pagesize: pagesize,
		}, function(result) {
			var obj = JSON.parse(result);
			//验证
			if(obj.code != 0) {
				console.log(obj.message);
				alert('商品正在上架...');
				return;
			}
			//清除内容
			$('.merchandise>ul').empty();
			var goodsList = obj.data;
			//渲染数据
			for(var i = 0; i < obj.data.length; i++) {
				var str = `
				<li>
					<a target="_blank" href="detail.jsp?goods_id=${goodsList[i].goods_id}">
						<img src="${goodsList[i].goods_thumb}" />
						<div class="buttom">
							<span class="left" href="javascript:;">${goodsList[i].goods_name}</span>
							<span class="right" href="javascript:;">${goodsList[i].star_number}❤</span>
						</div>
						<p>${goodsList[i].goods_desc}</p>
						<h3>￥${goodsList[i].price}</h3>
					</a>
				</li>
			`;
				$('.merchandise>ul').append(str);
			}
		})
	}
	//商品刷新
	getGoodsList();
	//鼠标点击下一页
	$('.btnNext').click(function() {
		page++;
		if(page >= 50) {
			page = 50;
		}
		$('.pageNum').val(page);
		getGoodsList();
		//返回顶部
		$('html').animate({
			'scrollTop': 0
		}, 100);
	})
	//鼠标点击上一页
	$('.btnPrev').click(function() {
		page--;
		if(page < 1) {
			page = 1;
		}
		$('.pageNum').val(page);
		getGoodsList();
		//		返回顶部
		$('html').animate({
			'scrollTop': 0
		}, 100);
	})

	//失焦跳转
	$('.btnJump').click(function() {
		page = $('.pageNum').val();
		if(parseInt($('.pageNum').val()) > 50) {
			page = 50;
		}
		if(parseInt($('.pageNum').val()) < 1) {
			page = 1;
		}
		$('.pageNum').val(page);
		getGoodsList();
		//返回顶部
		$('html').animate({
			'scrollTop': 0
		}, 100);
	})
})();