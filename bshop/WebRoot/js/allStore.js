//所有商品
(function() {
	var page = 1;
	var pagesize = 16;
	//封装热门商品
	function getGoodsList() {
		$.get('http://www.wjian.top/shop/api_goods.php', {
			page: page,
			pagesize: pagesize,
		}, function(result) {
			var obj = JSON.parse(result);
			console.log(obj);
			if(obj.code != 0) {
				console.log(obj.message);
				return;
			}
			//清除内容
			$('.merchandise>ul').empty();
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
		})
	}
	//商品刷新
	getGoodsList();
	//鼠标点击下一页
	$('.btnNext').click(function(){
		page++;
		if(page>=50){
			page=50;
		}
		$('.pageNum').val(page);
		getGoodsList();
		//返回顶部
		$('html').animate({'scrollTop':0},100);
	})
	//鼠标点击上一页
	$('.btnPrev').click(function(){
		page--;
		if(page<1){
			page=1;
		}
		$('.pageNum').val(page);
		getGoodsList();
		//		返回顶部
		$('html').animate({'scrollTop':0},100);
	})
	//失焦跳转
	$('.btnJump').click(function(){
		page=$('.pageNum').val();
		if(parseInt($('.pageNum').val())>50){
			page=50;
		}
		if(parseInt($('.pageNum').val())<1){
			page=1;
		}
		$('.pageNum').val(page);
		getGoodsList();
		//返回顶部
		$('html').animate({'scrollTop':0},100);
	})
	
	//获得地址栏参数值?  cat_id=55&name=xiaoming
	function getUrlVal(property){
	  //地址栏
	  var urlStr = window.location.search.substring(1);
	  var re = new RegExp('(^|&)'+ property +'=([^&]*)(&|$)');
	  var result = urlStr.match(re);
	  if(result == null){return null};
	  return result[2];
	};
})()