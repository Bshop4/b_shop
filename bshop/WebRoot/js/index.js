
//请求热门商品
(function() {
	var page = 1;
	var pagesize = 8;
	//封装热门商品
	function getGoodsList() {
		
		$.ajax({
			type:"post",
			url:"pageBranchAction.do",
			data:{
				page: page,
				pagesize: pagesize,
			},
			dataType:"json",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(result){
				
			}
		})
		
		$.get('http://www.wjian.top/shop/api_goods.php', {
			page: page,
			pagesize: pagesize,
		}, function(result) {
			var obj = JSON.parse(result);
			if(obj.code != 0) {
				console.log(obj.message);
				return;
			}
			var goodsList = obj.data;
			//渲染
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
			//隐藏加载元素
			$('#loading').css('display', 'none');
			//放锁
			lock = false;
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
		if(scrollTop / documentH >0.8) {
			if(lock) {
				return
			};
			lock = true;
			//加载下一页
			page++;
			//加载中显示
			$('#loading').css('display', 'block');
			if(page > 3) {
				$('#loading').css('display', 'none');
				more();
				return;
			} else {
				getGoodsList();
			}
		}
	})
})()
//添加按钮
function more(){
	var moreB=`
		<a href="allStore.jsp" target="_blank">
			发现更多
			<span class="glyphicon glyphicon-chevron-right"></span>		
		</a>
	`;
	$('.more').append(moreB);
}

