/**
 * Created by 10415 on 2019/10/26.
 */

(function(){
      //var goodsId = getUrlVal('goods_id');
	var goodsno = "9042194192054";
    //发起
	$.ajax({
		type:"POST",
		url:"selectGoodsNo.do",
		data:{"goodsno":goodsno},
		success:function(result){
			console.log(result);
			result=JSON.parse(result);
			var len = result.length;
			var obj = result[len-1];
			console.log(obj)
			
	        $('title').html('B-SHOP嘿店——'+obj.goods_name);
	        
	        //商品名字
	        var str = `
	            <span>${obj.goods_name}</span>
	        `;
	        
	        //大图
	        var str1 = `
	            <ul>
	             <li class="active"><img src=${result[0]}></li>
	             </ul>
	            <div class="slide"></div>
	        `;

//	        //小图
	        var strsm="";
	        for(var i = 0; i < 4; i++){
	        	strsm+="<li><img src='"+result[i]+"'/></li>";
	        }
//	        console.log(strsm)
	        var str2 = `
	        	<ul>
	              ${strsm}
	            </ul>
	            <span class="glyphicon glyphicon-chevron-left left-span"></span>
	            <span class="glyphicon glyphicon-chevron-right right-span"></span>
	        `;
//	        console.log(str2)
	        
//
	        var str3 = `
	            <div class="zjl-product-name">${obj.goods_name}</div>
	        `;
//
//	        //品牌
	        var str4 = `
	        	<span><a href="">品牌：${obj.goods_brand}</a></span>
	           <span class="zjl-product-no">商品编号：${obj.goods_no}</span>
	        `;
//
	        var price = parseFloat(`${obj.goods_price}`);
	        var discount = parseFloat(`${obj.goods_discount}`)
	        price = parseInt(price / discount);
//	        console.log(price)
//	        var strPrice = price + '.00';
	        var str5 = `
	              <span>￥${price}</span>
	        `;

	        var str6 = `
	            <span class="buyName">购买数量:</span>
	            <span class="de">-</span>
	            <input type="text" value="1" class="number" readonly>
	            <span class="add">+</span>
	        `;

	        
	        var str7 = `
	            <ul>
	               <li id="buyNowBtn"><a href="javascript:;" data-goods-id="${obj.goods_no}">立即购买</a></li>
	               <li id="addCartBtn"><a href="javascript:;" data-goods-id="${obj.goods_no}">加入购物车</a></li>
	             </ul>
	        `;

	        var str8 = `
	            <div class="big"></div>
	        `;
			
//			飞入购物车的图
			var str9=`<img src=${result[0]}>`
			
			//发货地
			var str10 = `
				<span class="zjl-send">发货地:</span>
	            <span class="zjl-place">${obj.goods_place}</span>
	            <span class="zjl-waitTime">预计3-7工作日送达</span>
			`;
			
			
			//颜色
			var strcolor = obj.goods_color;
//			console.log(strcolor)
			var arrcolor = new Array();
//			var ss = "123,345,456"
			arrcolor = strcolor.split(',');
			
			var strcolor1 = "";
			for(var i = 0; i < arrcolor.length; i++){
				strcolor1 += "<li>"+arrcolor[i]+"<a></a></li>"
			}
			strcolor1  = strcolor1.slice(0,3) + " class=active" + strcolor1.slice(3);
//			console.log(strcolor1)			
			
			var str11 = `
				<ul style="width:300px">
					${strcolor1}
	            </ul>
			`;
			
//			//尺码
			var strsize1 = obj.goods_size;
			var arrSize = strsize1.split(",");
//			console.log(arrSize.length)
			var strsize2 = "";
			for(var i = 0; i < arrSize.length ;i++){
				strsize2 += "<li>"+arrSize[i]+"<a></a></li>"
			}
			console.log(strsize2)
			var str12 = `
				<ul style="width:450px">
	              ${strsize2}
	            </ul>
			`;
//				
			
			var bigphtoo = obj.goods_explainphoto;
			console.log(bigphtoo)
//			console.log(Uint8ToStr(bigphtoo));
			$(".zjl-footer-img").append(Uint8ToStr(bigphtoo));
			
			
	        $('.zjl-link').append(str);
	        $('.zjl-top').append(str1);
	        $('.zjl-bottom').append(str2);
	        $('.zjl-product').prepend(str3);
	        $('.zjl-product-brandName').append(str4);
	        $('.price').append(str5);
	        $('.price').prepend('￥<span>'+ obj.goods_price+'</span>');
	        $('.zjl-product-condition').append(str6);
	        $('.zjl-product-button').append(str7);
	        $('.zjl-banner').append(str8);
			
			//		飞入购物车的图
			$('.zjl-flyincart').append(str9);
			
			$('.zjl-product-region').append(str10);
			
			$('.zjl-product-color').append(str11);
			
			$('.zjl-product-size').append(str12);
			
	        var imgStr = `${result[0]}`;
	        
	        //放大镜大图
	        $('.big').css({

	            width: 400,
	            height: 400,
	            border: '2px solid orange',
	            position: 'absolute',
	            left: 600,
	            top: 10,
	            background: 'url("'+imgStr+'")',
	            /*background-image: url("img/big-01.jpg");*/
	            'background-size': '800px 800px' ,
	            'background-position': '0px 0px',
	            'z-index': 999,
	            display: 'none',
	        })


	        opration();

			
			
		}
	})
	
	
	
	
	
//    $.get('http://www.wjian.top/shop/api_goods.php', {
//        goods_id : goodsId,
//    }, function(result){
//        var obj = JSON.parse(result);
//        
//        $('title').html('B-SHOP嘿店——'+obj.data[0].goods_name);
//        var goods = obj.data[0];
//        
//        //商品名字
//        var str = `
//            <span>${goods.goods_name}</span>
//        `;
//
//        //大图
//        var str1 = `
//            <ul>
//             <li class="active"><img src=${goods.goods_thumb}></li>
//             </ul>
//            <div class="slide"></div>
//        `;
//
//        //小图
//        var str2 = `
//        	<ul>
//              <li class="cur"><img src=${goods.goods_thumb} alt=""></li>
//              <li><img src="img/big-01.jpg" alt=""></li>
//              <li><img src="" alt=""></li>
//              <li><img src="" alt=""></li>
//            </ul>
//            <span class="glyphicon glyphicon-chevron-left left-span"></span>
//            <span class="glyphicon glyphicon-chevron-right right-span"></span>
//        `;
//
//        var str3 = `
//            <div class="zjl-product-name">${goods.goods_name}</div>
//        `;
//
//        //品牌
//        var str4 = `
//        	<span><a href="">品牌：Aquapick</a></span>
//           <span class="zjl-product-no">商品编号：${goods.brand_id}</span>
//        `;
//
//        var price = parseFloat(`${goods.price}`) - 150.00;
//        var strPrice = price + '.00';
//        var str5 = `
//              <span>￥${goods_price}</span>
//        `;
//
//        var str6 = `
//            <span class="buyName">购买数量:</span>
//            <span class="de">-</span>
//            <input type="text" value="1" class="number" readonly>
//            <span class="add">+</span>
//        `;
//
//
//        var str7 = `
//            <ul>
//               <li  id="buyNowBtn"><a href="javascript:;" data-goods-id="${goods.goods_id}">立即购买</a></li>
//               <li id="addCartBtn"><a href="javascript:;"  data-goods-id="${goods.goods_id}">加入购物车</a></li>
//             </ul>
//        `;
//
//        var str8 = `
//            <div class="big"></div>
//        `;
//		
////		飞入购物车的图
//		var str9=`<img src=${goods.goods_thumb}>`
//		
//		//发货地
//		var str10 = `
//			<span class="zjl-send">发货地:</span>
//            <span class="zjl-place">上海</span>
//            <span class="zjl-waitTime">预计3-7工作日送达</span>
//		`;
//		
//		//颜色
//		var str11 = `
//			<ul>
//              <li class="active">米白<a href=""></a></li>
//              <li>惨白<a></a></li>
//            </ul>
//		`;
//		
//		//尺码
//		var str12 = `
//			<ul>
//              <li>均码<a></a></li>
//            </ul>
//		`;
//			
//        $('.zjl-link').append(str);
//        $('.zjl-top').append(str1);
//        $('.zjl-bottom').append(str2);
//        $('.zjl-product').prepend(str3);
//        $('.zjl-product-brandName').append(str4);
//        $('.price').append(str5);
//        $('.price').prepend('￥<span>'+ strPrice+'</span>');
//        $('.zjl-product-condition').append(str6);
//        $('.zjl-product-button').append(str7);
//        $('.zjl-banner').append(str8);
//		
//		//		飞入购物车的图
//		$('.zjl-flyincart').append(str9);
//		
//		$('.zjl-product-region').append(str10);
//		
//		$('.zjl-product-color').append(str11);
//		
//		$('.zjl-product-size').append(str12);
//		
//        var imgStr = `${goods.goods_thumb}`;
//        //console.log(imgStr);
//        
//        //放大镜大图
//        $('.big').css({
//
//            width: 400,
//            height: 400,
//            border: '2px solid orange',
//            position: 'absolute',
//            left: 600,
//            top: 10,
//            background: 'url("'+imgStr+'")',
//            /*background-image: url("img/big-01.jpg");*/
//            'background-size': '800px 800px' ,
//            'background-position': '0px 0px',
//            'z-index': 999,
//            display: 'none',
//        })
//
//
//        opration();
//
//    });



})();




//各种操作
function opration(){

    //注册
    $('.zjl-register').click(function(){
        var goodsId = $('#addCartBtn').attr('data-goods-id');//将goodsid传到注册界面
        console.log(goodsId);
        location.href = 'sign.jsp?goods_id=' + goodsId;
    })


    //登录
    $('.zjl-login').click(function(){
        var goodsId = $('#addCartBtn').attr('data-goods-id');
        console.log(goodsId);
        
        location.href = 'Login.jsp?goods_id=' + goodsId;
    })

    //点击购物车图标
    $('#zjl-cart').click(function(){
        var goodsId = $('#addCartBtn').attr('data-goods-id');
        var token = localStorage.getItem('token');

        console.log(goodsId);
        console.log(token);

        //验证
        if(token){

            $.ajax({
                type : 'post',
                url : 'http://www.wjian.top/shop/api_cart.php',
                data: {'goods_id':goodsId, 'number': parseInt($('.number').attr('value'))},
                dataType:'json',
                success : function(e){
                    console.log(e);
                    
                    
//                  待写进入数据库加数据        


                },
            });
        }else{
            if(confirm('未登录，点击确定跳到登录界面')){
                location.href = 'Login.jsp?goods_id=' + goodsId;
            };
        };
    })



//	添加到购物车      	点一次数量也要加一次?????????????
    $('#addCartBtn').click(function(e){
        var token = localStorage.getItem('token');
        var goodsNumber=parseInt(localStorage.getItem('cartnumber'))+0;
        var goodsId = $('#addCartBtn').attr('data-goods-id');
        console.log(goodsId);
        console.log(token);
        console.log($('.number').attr('value'));
        
        //验证
        if(token){
        	
        	if($('.zjl-flyincart img').is(':animated')){return;};
//			动画飞入购物车动画,购物车的净位置,和加入购物车的净位置
			var targetX=$('#zjl-login-cart').offset().left;
			var targetY=$('#zjl-login-cart').offset().top;
			var intiX=$('#addCartBtn').offset().left;
			var intiY=$('#addCartBtn').offset().top;
			
			
//			需要判断库存数量????????????????????????????????????????????????????????????????????
//			物品数量
			var num=parseInt($('.zjl-product-condition .number').val());
			goodsNumber+=num;
			localStorage.setItem('cartnumber',goodsNumber);
			
//			设置起始位置
			$('.zjl-flyincart img').css({'left':intiX,'top':intiY,display:'block'});
			
//			动画
			$('.zjl-flyincart img').animate({left:targetX,top:targetY},1200,function(){
				$('.zjl-flyincart img').css('display','none');
				$('.store_number').html(goodsNumber);
			});
			
			
			
            $.ajax({
                type : 'post',
                url : 'http://www.wjian.top/shop/api_cart.php',
                data: {'goods_id':goodsId, 'number': parseInt($('.number').attr('value'))},
                dataType:'json',
                success : function(e){
                    
                    
                    
                    
                    
//                  待写进入数据库加数据
                    
                    
                    
                },
            });
        }else{
            if(confirm('未登录，点击确定跳到登录界面')){
                location.href = 'Login.jsp?goods_id=' + goodsId;
            };
        };
    });

    $('#buyNowBtn').click(function(){
        var token = localStorage.getItem('token');
        var goodsId = $('#buyNowBtn').attr('data-goods-id');

        //验证
        if(token){

            console.log(111)
            $.ajax({
                type : 'post',
                url : 'http://www.wjian.top/shop/api_cart.php',
                data: {'goods_id':goodsId, 'number': parseInt($('.number').attr('value'))},
                dataType:'json',
                success : function(e){
                    
//                  数据库
                    
                    
                },
            });
        }else{
            if(confirm('未登录，点击确定跳到登录界面')){
                location.href = 'Login.jsp?goods_id=' + goodsId;
            };
        };
    })



    //图片切换0
      $('.zjl-bottom ul li').each(function(i){
        $(this).mouseenter(function(){
            //$('.zjl-top ul li').eq(i).show().siblings().hide();
            $(this).css('border','1px solid black').siblings().css('border','');

            var imgSrc = $(this).children().attr('src');
            $('.zjl-top ul li img').attr('src',imgSrc);
            $('.big').css({
                'background':'url('+ imgSrc +')',
            });
        }) ;
    });
   
    //颜色选择
    $('.zjl-product-color ul li').each(function(i){
        $(this).click(function(i){
            $(this).children().show().parent().siblings().children().hide();

        })
    })

    //size选择
    $('.zjl-product-size ul li').each(function (i) {
        $(this).click(function(){
            $(this).children().show().parent().siblings().children().hide();
        })
    })

    //数量
    var num = 1;
    $('.zjl-product-condition .add').click(function () {
        num++;
        $('.number').attr('value',num);
    })

    $('.zjl-product-condition .de').click(function () {
        num--;
        if(num<=1){
            num=1;
        }
        $('.number').attr('value',num);
    })


    //以下是商品详情点击事件
    $('#desc').click(function () {
        $('.zjl-footer-detail').hide();
        $('.zjl-footer-decs').show();

        $('#detail').css({
            'font-size':14,
            'border-bottom' : 'none',
            'font-weight':'normal'
        });
        $('#desc').css({
            'font-size': 20,
            'border-bottom': '2px solid black',
            'font-weight': 'bold'
        })
    })

    $('#detail').click(function () {
        $('.zjl-footer-detail').show();
        $('.zjl-footer-decs').hide();

        $('#desc').css({
            'font-size':14,
            'border-bottom' : 'none',
            'font-weight':'normal'
        });
        $('#detail').css({
            'font-size': 20,
            'border-bottom': '2px solid black',
            'font-weight': 'bold'
        });
    });


}
function Uint8ToStr(arr){
	  for (var i = 0,str=''; i < arr.length; i++) 
	    str+= String.fromCharCode(arr[i]);
	  return str;
	}


