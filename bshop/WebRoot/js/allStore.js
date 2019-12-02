
//加载更多
var djtLoadMore;


//全局变量
var goods_price;
var goods_brand;
var middle_color;
var middle_size;
var goods_place;
var middle_type;
var goods_name;

//为了能自动跳分页
var a;
var b;
var c;
var d;
var e;
var f;
var g;

//最大页数
var maxPageCount;

//分类id
var page = 1;
var pagesize = 16;

//立即执行
(function() {
	if(getUrlVal("middle_type")){
		middle_type=decodeURI(getUrlVal("middle_type"));
	};
	if(getUrlVal("goods_name")){
		goods_name=decodeURI(getUrlVal("goods_name"));
	}
	console.log(goods_name);
	$('title').html('B-SHOP嘿店——'+"所有商品");
	
	//把条件拼接
	if(middle_type){
		$('.part-screen>.product-filter').append("<div data-condition='middle_type' data-condition-datail='"+middle_type+"'  onclick='duanjuntang(this)'><span>分类:</span><span>"+middle_type+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	}
	
	//商品刷新
	getGoodsList();
	
})();

//鼠标点击下一页
$('.btnNext').click(function() {
	page++;
	if(page >= maxPageCount) {
		page = maxPageCount;
	}
	$('.pageNum').val(page);
	
	//获取需要的值
	getNeedsList();
	
	getGoodsList();
	
	//返回顶部
	$('body').animate({
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
	//获取需要的值
	getNeedsList();
	
	getGoodsList();
	
	//		返回顶部
	$('body').animate({
		'scrollTop': 0
	}, 100);
})

//点击跳转
$('.btnJump').click(function() {
	page = $('.pageNum').val();
	if(parseInt($('.pageNum').val()) > maxPageCount) {
		page = maxPageCount;
	}
	if(parseInt($('.pageNum').val()) < 1) {
			page = 1;
	}
	$('.pageNum').val(page);
	getGoodsList();
	//返回顶部
	$('body').animate({
		'scrollTop': 0
	}, 100);
})

//点击首页
$('.btnStart').click(function(){
	page = 1;
	$('.pageNum').val(page);
	//获取需要的值
	getNeedsList();
	
	getGoodsList();
	
	//		返回顶部
	$('body').animate({
		'scrollTop': 0
	}, 100);
})

//点击尾页
$('.btnEnd').click(function(){
	page = maxPageCount;
	$('.pageNum').val(page);
	//获取需要的值
	getNeedsList();
	
	getGoodsList();
	
	//		返回顶部
	$('body').animate({
		'scrollTop': 0
	}, 100);
})

//获得地址参数栏的值
function getUrlVal(property) {
	//地址栏
	var urlStr = window.location.search.substring(1);
	var re = new RegExp('(^|&)' + property + '=([^&]*)(&|$)');
	var result = urlStr.match(re);
	if(result == null) {
		return;
	};
	return result[2];
};

function getGoodsList() {
	$.ajax({
		type:"post",
		url:"goodsByConditionsAction.do",
		data:{
			goods_price:goods_price,
			goods_brand:goods_brand,
			middle_color:middle_color,
			middle_size:middle_size,
			goods_place:goods_place,
			goods_name:goods_name,
			page:page,
			pagesize:pagesize,
			middle_type:middle_type,
		},
		dataType:"json",
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		success:function(result){
			//清除内容
			$('.merchandise>ul').empty();
			
			console.log(result);
			
			//存取最大页数
			maxPageCount=result[0].maxPageCount[0].maxPageCount;
			
			//判断是否搜到相应的商品
			if(maxPageCount==0){
				alert("未搜索到相关商品");
				return;
			}
			
			//为了加载更多
			djtLoadMore=result;
			
			//渲染数据,如果当前页大于总页数
			page = $('.pageNum').val();
			if(parseInt($('.pageNum').val()) > maxPageCount) {
				page = maxPageCount;
				$('.pageNum').val(page);
				
				$('.merchandise>ul').empty();
				$('.part-screen>.product-next>ul').empty();
				
				goods_price=a;
				goods_brand=b;
				middle_color=c;
				middle_size=d;
				goods_place=e;
				middle_type=f;
				goods_name=g;
				
				getGoodsList();
				return;
			}
			
			$('.merchandise>ul').empty();
			$('.part-screen>.product-next>ul').empty();
			
			//渲染商品
			for(var i=0;i<result[0].goodsConditions.length;i++){
				var str = `
					<li>
						<a target="_blank" href="/bshop/detail.jsp?goods_no=${result[0].goodsConditions[i].goods_no}">
							<img src="${result[0].goodsConditions[i].goods_photo}" />
							<div class="buttom">
								<span class="left">${result[0].goodsConditions[i].goods_brand}</span>
							</div>
							<p>${result[0].goodsConditions[i].goods_name}</p>
							<h3>￥${result[0].goodsConditions[i].goods_price}</h3>
						</a>
					</li>
				`;
					$('.merchandise>ul').append(str);
			}
			
			
			//渲染品牌
			for(var i=0;i<result[0].goods_brand.length;i++){
				if(i<=6){
					var str=`<li><a data-msg="品牌" data-title="goods_brand" data-jump="${result[0].goods_brand[i].goods_brand}" onclick="djtAdd(this)">${result[0].goods_brand[i].goods_brand}</a></li>`;
					$('.part-screen>.product-next>ul').eq(0).append(str);
				}else{
					var str=`<li class="djtMore" onclick="djtAddMore(this)"><span data-more="品牌">加载更多</span><span class="glyphicon glyphicon-chevron-down"></span></li>`;
					$('.part-screen>.product-next>ul').eq(0).append(str);
					var str=`<div class='pyl_moretype'>`;
					for(var j=7;j<result[0].goods_brand.length;j++){
						str+=`<span data-msg="品牌" data-title="goods_brand" onclick="djtAdd(this)">${result[0].goods_brand[j].goods_brand}</span>`;
					}
					str+=`</div>`;
					$('.part-screen>.product-next>ul').eq(0).append(str);
					break;
				}
			}
			
			//渲染分类
			for(var i=0;i<result[0].middle_type.length;i++){
				if(i<=8){
					var str=`<li><a data-msg="分类" data-title="middle_type" data-jump="${result[0].middle_type[i].middle_type}"  onclick="djtAdd(this)">${result[0].middle_type[i].middle_type}</a></li>`;
					$('.part-screen>.product-next>ul').eq(1).append(str);
				}else{
					var str=`<li class="djtMore" onclick="djtAddMore(this)"><span data-more="分类" >加载更多</span><span class="glyphicon glyphicon-chevron-down"></span></li>`;
					$('.part-screen>.product-next>ul').eq(1).append(str);
					var str=`<div class='pyl_moretype'>`;
					for(var j=9;j<result[0].middle_type.length;j++){
						str+=`<span data-msg="分类" data-title="middle_type" onclick="djtAdd(this)">${result[0].middle_type[j].middle_type}</span>`;
					}
					str+=`</div>`;
					$('.part-screen>.product-next>ul').eq(1).append(str);
					break;
				}
			}
			
			//渲染发货地
			for(var i=0;i<result[0].goods_place.length;i++){
				if(i<=8){
					var str=`<li><a data-msg="发货地" data-title="goods_place" data-jump="${result[0].goods_place[i].goods_place}" onclick="djtAdd(this)">${result[0].goods_place[i].goods_place}</a></li>`;
					$('.part-screen>.product-next>ul').eq(2).append(str);
				}else{
					var str=`<li class="djtMore" onclick="djtAddMore(this)"><span data-more="发货地">加载更多</span><span class="glyphicon glyphicon-chevron-down"></span></li>`;
					$('.part-screen>.product-next>ul').eq(2).append(str);
					var str=`<div class='pyl_moretype'>`;
					for(var j=9;j<result[0].goods_place.length;j++){
						str+=`<span data-msg="发货地" data-title="goods_place" onclick="djtAdd(this)">${result[0].goods_place[j].goods_place}</span>`;
					}
					str+=`</div>`;
					$('.part-screen>.product-next>ul').eq(2).append(str);
					break;
				}
			}
			
			//渲染颜色
			for(var i=0;i<result[0].middle_color.length;i++){
				if(i<=10){
					var str=`<li><a data-msg="颜色" data-title="middle_color" data-jump="${result[0].middle_color[i].middle_color}" onclick="djtAdd(this)">${result[0].middle_color[i].middle_color}</a></li>`;
					$('.part-screen>.product-next>ul').eq(3).append(str);
				}else{
					var str=`<li class="djtMore" onclick="djtAddMore(this)"><span data-more="颜色">加载更多</span><span class="glyphicon glyphicon-chevron-down"></span></li>`;
					$('.part-screen>.product-next>ul').eq(3).append(str);
					var str=`<div class='pyl_moretype'>`;
					for(var j=9;j<result[0].middle_color.length;j++){
						str+=`<span data-msg="颜色" data-title="middle_color" onclick="djtAdd(this)">${result[0].middle_color[j].middle_color}</span>`;
					}
					str+=`</div>`;
					$('.part-screen>.product-next>ul').eq(3).append(str);
					break;
				}
			}
			
			//渲染尺码
			for(var i=0;i<result[0].middle_size.length;i++){
				if(i<=10){
					var str=`<li><a data-msg="尺码" data-title="middle_size" data-jump="${result[0].middle_size[i].middle_size}" onclick="djtAdd(this)">${result[0].middle_size[i].middle_size}</a></li>`;
					$('.part-screen>.product-next>ul').eq(4).append(str);
				}else{
					var str=`<li class="djtMore" onclick="djtAddMore(this)"><span data-more="尺码">加载更多</span><span class="glyphicon glyphicon-chevron-down"></span></li>`;
					$('.part-screen>.product-next>ul').eq(4).append(str);
					var str=`<div class='pyl_moretype'>`;
					for(var j=11;j<result[0].middle_size.length;j++){
						str+=`<span data-msg="尺码" data-title="middle_size" onclick="djtAdd(this)">${result[0].middle_size[j].middle_size}</span>`;
					}
					str+=`</div>`;
					$('.part-screen>.product-next>ul').eq(4).append(str);
					break;
				}
			}
			
			//渲染价格区间
			for(var i=0;i<result[0].goods_price.length;i++){
				if(i<=10){
					var str=`<li><a data-msg="价格" data-title="goods_price" data-jump="${result[0].goods_price[i].goods_price}" onclick="djtAdd(this)">${result[0].goods_price[i].goods_price}</a></li>`;
					$('.part-screen>.product-next>ul').eq(5).append(str);
				}else{
					break;
				}
			}
			
			//渲染
			$('.pageSkining>center>span').html("总共："+maxPageCount+"页");
		}
	})
}

//鼠标点击进行筛选
function djtAdd(obj){
	/*用来防止选择类别时重复点击*/
	var myuse=$(obj).attr("data-jump");
	var pylflag=$('[data-condition-datail="'+myuse+'"]');
	if(pylflag.length!="0"){return;};
	/*用来防止选择类别时重复点击*/
	
	
	if($(obj).attr("djtclick")=="1"){return;};
	/*$(obj).css("color",'black');
	$(obj).css("font-weight",'bold');*/
	var condition=$(obj).html();
	$('.part-screen>.product-filter').append("<div data-condition='"+$(obj).attr('data-title')+"' data-condition-datail='"+condition+"'  onclick='duanjuntang(this)'><span>"+$(obj).attr('data-msg')+":</span><span>"+condition+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	
	//调用筛选
	getNeedsList();
	
	oldValue();
	
	getGoodsList();
	
	//赋值为空
	allIsNull();
}

//点击筛选中的值
function duanjuntang(obj){
	var myuse=$(obj).attr("data-condition-datail");
	/*其它操作*/
	$(obj).remove();
	$('[data-jump="'+myuse+'"]').css("color",'#337ab7');
	$('[data-jump="'+myuse+'"]').css("font-weight",'normal');
	
	//赋值为空
	allIsNull();
	
	//调用筛选
	getNeedsList();
	getGoodsList();
	
	allIsNull();
	
}

//获取筛选后面的值
function getNeedsList(){
	$('.part-screen>.product-filter>div').each(function(i){
		var myNeedsKey=$('.part-screen>.product-filter>div').eq(i).attr("data-condition");
		var myNeedsValue=$('.part-screen>.product-filter>div').eq(i).attr("data-condition-datail");
		console.log(myNeedsKey+"===="+myNeedsValue);
		if(myNeedsKey&&"goods_price"==myNeedsKey){
			goods_price=myNeedsValue;
		}
		if(myNeedsKey&&"goods_brand"==myNeedsKey){
			goods_brand=myNeedsValue;
		}
		if(myNeedsKey&&"middle_color"==myNeedsKey){
			middle_color=myNeedsValue;
		}
		if(myNeedsKey&&"middle_size"==myNeedsKey){
			middle_size=myNeedsValue;
		}
		if(myNeedsKey&&"goods_place"==myNeedsKey){
			goods_place=myNeedsValue;
		}
		if(myNeedsKey&&"middle_type"==myNeedsKey){
			middle_type=myNeedsValue;
		}
		if(myNeedsKey&&"goods_name"==myNeedsKey){
			goods_name=myNeedsValue;
		}
	})
}

//赋值为空
function allIsNull(){
	//赋值为空
	goods_price=undefined;
	goods_brand=undefined;
	middle_color=undefined;
	middle_size=undefined;
	goods_place=undefined;
	middle_type=undefined;
	goods_name=undefined;
}

//用来存储旧值
function oldValue(){
	a=goods_price;
	b=goods_brand;
	c=middle_color;
	d=middle_size;
	e=goods_place;
	f=middle_type;
	g=goods_name;
}

//页面跳转，条件不变
function noChangeCondition(){
	if(middle_type){
		//把条件拼接
		$('.part-screen>.product-filter').append("<div data-condition='middle_type' data-condition-datail='"+middle_type+"'  onclick='duanjuntang(this)'><span>分类:</span><span>"+middle_type+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	}
	if(goods_price){
		$('.part-screen>.product-filter').append("<div data-condition='goods_price' data-condition-datail='"+goods_price+"'  onclick='duanjuntang(this)'><span>价格:</span><span>"+goods_price+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	}
	if(goods_brand){
		$('.part-screen>.product-filter').append("<div data-condition='goods_brand' data-condition-datail='"+goods_brand+"'  onclick='duanjuntang(this)'><span>品牌:</span><span>"+goods_brand+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	}
	if(middle_color){
		$('.part-screen>.product-filter').append("<div data-condition='middle_color' data-condition-datail='"+middle_color+"'  onclick='duanjuntang(this)'><span>颜色:</span><span>"+middle_color+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	}
	if(middle_size){
		$('.part-screen>.product-filter').append("<div data-condition='middle_size' data-condition-datail='"+middle_size+"'  onclick='duanjuntang(this)'><span>尺码:</span><span>"+middle_size+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	}
	if(goods_place){
		$('.part-screen>.product-filter').append("<div data-condition='goods_place' data-condition-datail='"+goods_place+"'  onclick='duanjuntang(this)'><span>发货地:</span><span>"+goods_place+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	}
	if(goods_name){
		$('.part-screen>.product-filter').append("<div data-condition='goods_name' data-condition-datail='"+goods_name+"'  onclick='duanjuntang(this)'><span>查询:</span><span>"+goods_name+"</span><span class='glyphicon glyphicon-remove'></span></div>");
	}
}

//点击搜寻
$('.search-wrap>button').click(function(){
	var goods_name=$('.search-wrap>input').val();
	location.href="/bshop/search.jsp?goods_name="+goods_name;
})

//加载更多
function djtAddMore(obj){
		if($(".pyl_moretype").is(':animated')){return;}
		$(obj).siblings(".pyl_moretype").slideToggle();
}













