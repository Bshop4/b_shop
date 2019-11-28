console.log("aaaa");
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
				//验证
				if(result==null) {
					alert('商品正在上架...');
					return;
				}
				//清除内容
				$('.merchandise>ul').empty();
				
				console.log(result);
				//渲染数据
				for(var i=0;i<result[0].goodsConditions.length;i++){
					var str = `
						<li>
							<a target="_blank" href="detail.jsp?goods_no=${result[0].goodsConditions[i].goods_no}">
								<img src="${result[0].goodsConditions[i].goods_photo}" />
								<div class="buttom">
									<span class="left" href="javascript:;">${result[0].goodsConditions[i].goods_name}</span>
								</div>
								<h3>￥${result[0].goodsConditions[i].goods_price}</h3>
							</a>
						</li>
					`;
						$('.merchandise>ul').append(str);
				}
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