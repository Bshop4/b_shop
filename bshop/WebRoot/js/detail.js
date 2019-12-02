/**
 * Created by 10415 on 2019/10/26.
 */


var goodsno = getUrlVal('goods_no');
var account="";
var token = "";
(function(){
	
	$.ajax({
		type:"POST",
		url:"selectGoodsNo.do",
		data:{"goodsno":goodsno},
		success:function(result){
			
			result=JSON.parse(result);
			console.log(result)
			console.log(result.length)
			
			var len = result.length;
			var obj = result[len-1];
			var str = result[len-2];
			account = result[len-4];
			token = result[len-3];
			
	        $('title').html('B-SHOP嘿店——'+obj.goods_name);
	        var strColle;
	        if(str == "1"){
	        	strColle = `
		        	<label for="" data-coid=${obj.goods_no} onclick="collection(this)"><a href="javascript:;"><img src="img/6.png" alt="">收藏商品</a></label>
		        `;
	        }else if(str == "0"){
	        	strColle = `
	        		<label for="" data-coid=${obj.goods_no} onclick="collection(this)"><a href="javascript:;"><img src="img/4.png" alt="">收藏商品</a></label>
	        `;
	        }
	        
	        $('.zjl-product-lableList').append(strColle);
	        
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

	        //小图
	        var strsm="";
//	        if(len>=4){
//	        	for(var i = 0; i < 4; i++){
//	        		strsm+="<li><img src='"+result[i]+"'/></li>";
//	        	}
//	        }
//	        if(len>=2 && len <=6){
//	        	for(var i = 0; i < len-5; i++){
//	        		strsm+="<li><img src='"+result[i]+"'/></li>";
//	        	}
//	        }
	        for(var i = 0;i < len-5; i++){
	        	strsm+="<li><img src='"+result[i]+"'/></li>";
	        }
	        
	        var str2 = `
	        	<ul>
	              ${strsm}
	            </ul>
	            <span class="glyphicon glyphicon-chevron-left left-span"></span>
	            <span class="glyphicon glyphicon-chevron-right right-span"></span>
	        `;
	        
	        var str3 = `
	            <div class="zjl-product-name">${obj.goods_name}</div>
	        `;

	        //品牌
	        var str4 = `
	        	<span><a href="">品牌：${obj.goods_brand}</a></span>
	           <span class="zjl-product-no">商品编号：${obj.goods_no}</span>
	        `;

	        var price = parseFloat(`${obj.goods_price}`);
	        var discount = parseFloat(`${obj.goods_discount}`)
	        price = parseInt(price / discount);
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
	               <li id="buyNowBtn"><a href="javascript:;" data-goods-no=${obj.goods_no}>立即购买</a></li>
	               <li id="addCartBtn"><a href="javascript:;" data-goods-no=${obj.goods_no}>加入购物车</a></li>
	             </ul>
	        `;

	        var str8 = `
	            <div class="big"></div>
	        `;
			
			//飞入购物车的图
			var str9=`<img src=${result[0]}>`
			
			//发货地
			var str10 = `
				<span class="zjl-send">发货地:</span>
	            <span class="zjl-place">${obj.goods_place}</span>
	            <span class="zjl-waitTime">预计3-7工作日送达</span>
			`;
			
			
			//颜色
			var strcolor = obj.goods_color;
			var arrcolor = new Array();
			arrcolor = strcolor.split(',');
			
			var strcolor1 = "";
			for(var i = 0; i < arrcolor.length; i++){
				strcolor1 += "<li>"+arrcolor[i]+"<a></a></li>"
			}
			strcolor1  = strcolor1.slice(0,3) + " class=active" + strcolor1.slice(3);
			
			var str11 = `
				<ul style="width:300px">
					${strcolor1}
	            </ul>
			`;
			
			
			
			
			//尺码
			var strsize1 = obj.goods_size;
			var arrSize = strsize1.split(",");
			var strsize2 = "";
			for(var i = 0; i < arrSize.length ;i++){
				strsize2 += "<li>"+arrSize[i]+"<a></a></li>"
			}
			
			var str12 = `
				<ul style="width:450px">
	              ${strsize2}
	            </ul>
			`;
				

			var pp = result[len-5];
			$(".zjl-footer-img").append(pp);
			
			
			
	        $('.zjl-link').append(str);
	        $('.zjl-top').append(str1);
	        $('.zjl-bottom').append(str2);
	        $('.zjl-product').prepend(str3);
	        $('.zjl-product-brandName').append(str4);
	        $('.price').append(str5);
	        $('.price').prepend('￥<span class=realPrice>'+ obj.goods_price+'</span>');
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
	        $(".zjl-product-color ul li").eq(0).attr("data-color","checked").siblings().attr("data-color","");
	        $(".zjl-product-size ul li").eq(0).attr("data-size","checked").siblings().attr("data-size","");

	        opration();
		}
	})

})();




//各种操作
function opration(){

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
	
	
    //注册
    $('.zjl-register').click(function(){
    	var goodsNo = $('#addCartBtn').children().attr('data-goods-no');
        console.log(goodsNo);
        location.href = 'sign.jsp?goods_no=' + goodsNo;
    })


    //登录
    $('.zjl-login').click(function(){
    	var goodsNo = $('#addCartBtn').children().attr('data-goods-no');
        console.log(goodsNo);
        
        location.href = 'Login.jsp?goods_no=' + goodsNo;
    })

    //点击购物车图标
    $('#zjl-cart').click(function(){
    	var goodsNo = $('#addCartBtn').children().attr('data-goods-no');

        console.log(goodsNo);
        console.log(token);

        //验证
        if(token){
        }else{
            if(confirm('未登录，点击确定跳到登录界面')){
                location.href = 'Login.jsp?goods_no=' + goodsNo;
            };
        };
    })

    
    
//	添加到购物车      	点一次数量也要加一次?????????????
    $('#addCartBtn').click(function(e){
    	
        var goodsNumber=parseInt(localStorage.getItem('cartnumber'))+0;
        var goodsNo = $('#addCartBtn').children().attr('data-goods-no');//编号
//        var account = "pyla1";//账号
        var getnumber = $('.number').attr('value');//数量
        var imgurl = $(".zjl-bottom ul li").eq(0).children().attr('src');//图片
        var getgoodsname = $('.zjl-product-name').html();//商品名字
        var getprice = $('.realPrice').html();//单价-string
        var getAllprice = parseInt(getprice) * parseInt(getnumber);//总价-int
        getAllprice+="";
        
        var getcolor = "";//颜色
        $('.zjl-product-color ul li').each(function(i){
        	if($(this).attr("data-color") == "checked"){
        		getcolor = $(this).text();
        	}
        })
        
        var getsize = "";//尺寸
        $('.zjl-product-size ul li').each(function(i){
        	if($(this).attr("data-size") == "checked"){
        		getsize = $(this).text();
        	}
        })

        
        var allnew = {
        	"goodsNo":goodsNo,
        	"getnumber":getnumber,
        	"imgurl":imgurl,
        	"getgoodsname":getgoodsname,
        	"getprice":getprice,
        	"getAllprice":getAllprice,
        	"getcolor":getcolor,
        	"getsize":getsize,
        	"account":account
        }
           
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
//			var num=parseInt($('.zjl-product-condition .number').val());
//			goodsNumber+=num;
//			localStorage.setItem('cartnumber',goodsNumber);
			
//			设置起始位置
			$('.zjl-flyincart img').css({'left':intiX,'top':intiY,display:'block'});
			
//			动画
			$('.zjl-flyincart img').animate({left:targetX,top:targetY},1200,function(){
				$('.zjl-flyincart img').css('display','none');
				judgementLogin();
				//$('.store_number').html(goodsNumber);
			});
			
			
			
			
            $.ajax({
                type : 'post',
                url : 'insertCart.do',
                data: {"msg":JSON.stringify(allnew)},
                success : function(result){
                	
                	
                },
            });
        }else{
            if(confirm('未登录，点击确定跳到登录界面')){
                location.href = 'Login.jsp?goods_no=' + goodsNo;
            };
        };
    });



    $('#buyNowBtn').click(function(){
        
        var goodsNo = $('#buyNowBtn').children().attr('data-goods-no');
//        var account = "pyla1";//账户
        var getnumber = $('.number').attr('value');//数量
        var imgurl = $(".zjl-bottom ul li").eq(0).children().attr('src');//图片
        var getgoodsname = $('.zjl-product-name').html();//商品名字
        var getprice = $('.realPrice').html();//单价-string
        var getAllprice = parseInt(getprice) * parseInt(getnumber);//总价-int
        getAllprice+="";
        
        var getcolor = "";//颜色
        $('.zjl-product-color ul li').each(function(i){
        	if($(this).attr("data-color") == "checked"){
        		getcolor = $(this).text();
        	}
        })
        
        var getsize = "";//尺寸
        $('.zjl-product-size ul li').each(function(i){
        	if($(this).attr("data-size") == "checked"){
        		getsize = $(this).text();
        	}
        })

        var allnew = {
        	"goodsNo":goodsNo,
        	"getnumber":getnumber,
        	"imgurl":imgurl,
        	"getgoodsname":getgoodsname,
        	"getprice":getprice,
        	"getAllprice":getAllprice,
        	"getcolor":getcolor,
        	"getsize":getsize,
        	"account":account
        }
        
        
        //验证
        if(token){
        	
        	$.ajax({
        		type : "post",
        		url : "insertCartBuy.do",
        		data : {"msg" : JSON.stringify(allnew)},
        		success : function (re) {
        			
        			if(re == "1"){
        				location.href = "account.jsp?account_name="+account;
        			}
        			
        		}
        	})
        	
        }else{
            if(confirm('未登录，点击确定跳到登录界面')){
                location.href = 'Login.jsp?goods_id=' + goodsId;
            };
        };
    })

   
    //颜色选择
    $('.zjl-product-color ul li').each(function(i){
    	var goods_no = goodsno;
        $(this).click(function(i){
            $(this).children().show().parent().siblings().children().hide();
            $(this).attr("data-color","checked").siblings().attr("data-color","");
            
            var color = $(this).text();
            var nocolor = {
            	"goods_no" : goods_no,
            	"color" : color
            }
            
            $.ajax({
            	type : "post",
            	url : "selectColor.do",
            	data : {"msg" : JSON.stringify(nocolor)},
            	success : function (re) {
            		$('.zjl-top').html("");
            		$('.zjl-bottom').html("");
            		var obj = JSON.parse(re);
            		var strsm = "";
            		for(var i = 0; i < obj.length; i++){
            			strsm+="<li><img src='"+obj[i]+"'/></li>";
            		}
            		var strsmm = `
        	        	<ul>
        	              ${strsm}
        	            </ul>
        	            <span class="glyphicon glyphicon-chevron-left left-span"></span>
        	            <span class="glyphicon glyphicon-chevron-right right-span"></span>
        	        `;
            		$('.zjl-bottom').append(strsmm);
            		
            		var strbig = `
        	            <ul>
        	             <li class="active"><img src=${obj[0]}></li>
        	             </ul>
        	            <div class="slide"></div>
        	        `;
            		$('.zjl-top').append(strbig);
            		
            		var imgStr = `${obj[0]}`;
        	        
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
            		
            	}
            })
            
        })
    })

    //size选择
    $('.zjl-product-size ul li').each(function (i) {
        $(this).click(function(){
            $(this).children().show().parent().siblings().children().hide();
            $(this).attr("data-size","checked").siblings().attr("data-size","");
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

function collection(obj) {
	var goodsno = $(obj).attr("data-coid");
//	var account = "pyla1";
	
	var test = {
		"goodsno" : goodsno,
		"account" : account
	};
	if($(obj).children().children(":first").attr("src") == "img/6.png"){
		$.ajax({
			
			type : "post",
			url : "deleteCollection.do",
			data : {"msg" : JSON.stringify(test)},
			success : function(re){
				if(re == "1"){
					$(obj).children().children(":first").attr("src","img/4.png");
				}
			}
			
		})	

	}else{
		$.ajax({
			type : "post",
			url : "insertCollection.do",
			data : {"msg" : JSON.stringify(test)},
			success : function(re){
				if(re == "1"){
					$(obj).children().children(":first").attr("src","img/6.png");
				}
			}
			
		})
	}
	
	
	
	
	
}

