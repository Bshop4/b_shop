//请求热门商品
(function() {
	var page = 1;
	var pagesize = 8;
	//封装热门商品
	function getGoodsList() {
		
		$.ajax({
			type:"post",
			url:"newsGoodByTime.do",
			data:{
				page: page,
				pagesize: pagesize,
			},
			dataType:"json",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(result){
				console.log(result);
				//渲染
				for(var i = 0; i < result.length; i++) {
					var str = `
					<li>
						<a target="_blank" href="/bshop/detail.jsp?goods_no=${result[i].goods_no}">
							<img src="${result[i].goods_photo}" />
							<div class="buttom">
								<span class="left" href="javascript:;">${result[i].goods_brand}</span>
								<span class="right" href="javascript:;">${result[i].goods_like}❤</span>
							</div>
							<p>${result[i].goods_name}</p>
							<h3>￥${result[i].goods_price}</h3>
						</a>
					</li>
				`;
					$('.merchandise>ul').append(str);
				}
				//隐藏加载元素
				$('#loading').css('display', 'none');
				//放锁
				lock = false;
			}
		})
	}
	//商品刷新
	getGoodsList();
	//	定义一个锁
	var lock = false;
	$(window).scroll(function() {
		var scrollTop = $(window).scrollTop();
		var windowH = $(window).height();
		var documentH = $(document).height();
		if(scrollTop / documentH >0.6) {
			if(lock) {
				return
			};
			lock = true;
			//加载下一页
			page++;
			//加载中显示
			$('#loading').css('display', 'block');
			if(page > 10) {
				$('#loading').css('display', 'none');
				return;
			} else {
				getGoodsList();
			}
		}
	})
})()