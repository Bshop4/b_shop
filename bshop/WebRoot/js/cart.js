  //请求用户的购物车数据
  function goodsList(page, callback){
    var page = page ? page : 1;
    //页面打开就可以看到商品
    $.get('http://www.wjian.top/shop/api_goods.php',{
    	//http://www.xiu.com/#/search?dispId=003
    	//http://www.wjian.top/shop/api_goods.php
      'pagesize':2,
      'page':page,
    }, function(result){
      var result = JSON.parse(result);
      //验证
      if(result.code != 0){
        console.log('数据请求失败');
        return;
      };
      //调用
      callback(result);
    }); 
  };
  var allMount = 0;
  goodsList(1, function(result){
    var goodsList = result.data;
    //得到数据了之后，在这里操作数据
    //组装DOM结构
    for(var i = 0; i < goodsList.length; i++){
      //拿到每一项  goodsList[i].goodsName
      var str = `
        <tr>
          <td class="left">
            <input type="checkbox" class="check"/>
            <img src="${goodsList[i].goods_thumb}"/>
          </td>
          <td class="desc">${goodsList[i].goods_desc}</td>
          <td class="calculate">
            <button class="add">+</button>
            <span class="count">1</span>
            <button class="reduce">-</button>
          </td>
          <td>${goodsList[i].price}</td>
          <td class="subtotal">${goodsList[i].price}</td>
          <td><a href="javascript:;" class="del">删除</a></td>
        </tr>
      `;
      //把每次组装好的添加进table
      $('table').append(str);
    };
		$('.carts-number').text(goodsList.length);
		allMount = goodsList.length;
    //所有的业务逻辑都在这之后
    clickAll();
  });
  
function clickAll(){
  //点击加减数量变   小计变  总价变
  //点击全选        总价变
  //点击单选        总价变
  //点击删除        当前元素tr删除
  
  //点击整个表格
  $('table').click(function(event){
      console.log(event);
    //验证，判断点击的是哪一个元素
    //点击减
    if(event.target.className == 'reduce'){
      //要做商品减的业务
      //拿到数量
      var spanDom = event.target.previousElementSibling;
      var spanDomVal = parseInt(event.target.previousElementSibling.innerHTML);
      spanDomVal--;
      if(spanDomVal < 1){spanDomVal = 1};
      //数据库修改成功后才能去设置界面
      spanDom.innerHTML = spanDomVal;
      //求小计
      subtotal(event.target, spanDomVal);
      //求总价
      sumAll();
    };
    
    //点击加
    if(event.target.className == 'add'){
      //要做商品减的业务
      //拿到数量
      var spanDom = event.target.nextElementSibling;
      var spanDomVal = parseInt(event.target.nextElementSibling.innerHTML);
      spanDomVal++;
      if(spanDomVal > 99){spanDomVal = 99};
      //数据库修改成功后才能去设置界面
      spanDom.innerHTML = spanDomVal;
      //求小计
      subtotal(event.target, spanDomVal);
      //求总价
      sumAll();
    };
    
    //点击全选
    if(event.target.className == 'checkAll'){
      //要做商品减的业务
      //console.log(event.target.checked)
      if(event.target.checked == true){
        //选中所有的
        $('.check').each(function(){
          $(this).prop('checked', true);
          //给当前元素加个标识(自定义的属性)
          $(this).attr('data-price', 'active');        
        });
      }else{
        //选中所有的
        $('.check').each(function(){
          $(this).prop('checked', false);
          //拿掉标识(自定义的属性)
          $(this).attr('data-price', '');
        });
      };
      //求总价
      sumAll();
    };
    
    //点击单选
    if(event.target.className == 'check'){
      //要做商品减的业务
      //console.log('点击了单选');
      if(event.target.checked == true){
        //给当前元素加个标识(自定义的属性)
        event.target.setAttribute('data-price', 'active');
      }else{
        //拿掉标识(自定义的属性)
        event.target.setAttribute('data-price', '');       
      }
      allMounts();
      //求总价
      sumAll();
    };
    
    //点击删除
    if(event.target.className == 'del'){
      //要做商品减的业务
      console.log('点击了全选');
      //找到tr删除自己
      var tab = event.target.parentNode.parentNode.parentNode;
//    console.log(tab)
      var tr = event.target.parentNode.parentNode;
//    console.log(tr)
      tab.removeChild(tr);
      $('.carts-number').text(--allMount);
      //$(event.target).html('哈另一个')
      //调用总价
      sumAll();
    };  
  });
  $('.footer').click(function(event){
//	console.log(event);
  	if (event.target.className == 'checkAll') {
  		if(event.target.checked == true){
        //选中所有的
        $('.check').each(function(){
          $(this).prop('checked', true);
          //给当前元素加个标识(自定义的属性)
          $(this).attr('data-price', 'active');        
        });
      }else{
        //选中所有的
        $('.check').each(function(){
          $(this).prop('checked', false);
          //拿掉标识(自定义的属性)
          $(this).attr('data-price', '');
        });
      };
      //求总价
      sumAll();
  	};
  	//点击删除
    if(event.target.className == 'delAll'){
      //全部删除
      console.log('点击了选中删除');
//      调用删除
      delAll();
      //调用总价
      sumAll();
		};
  });
};  

//求小计
function subtotal(that, count){
  //拿到单价
  var price = parseInt(that.parentNode.nextElementSibling.innerHTML);
  //拿到小计元素
  var subtotalDom = that.parentNode.nextElementSibling.nextElementSibling;
  //设置
  subtotalDom.innerHTML = price * count + '.00';
};

//求总价方法
function sumAll(){
  var sum = 0;
  //拿到所的   active
  $('[data-price="active"]').each(function(){
    sum += parseInt($(this).parent().siblings('.subtotal').html());
  });
  //设置总价
  $('.sum-all').html('合计：¥' + sum + '.00');
};

//删除选中商品
function delAll(){
	$('[data-price="active"]').each(function(){
		var tab = $(this).parent().parent().parent();
		var tr = $(this).parent().parent();
		console.log(tab);
		console.log('你好');
		console.log(tr.length);
		console.log('你好');
		tab.get(0).removeChild(tr.get(0));
		console.log(tr.get(0).length);
	});
};

//计算选中的商品数量
function allMounts(){
	$('[data-price="active"]').each(function(){
		var allMounts = $(this).parent().siblings('.calculate').children('.count').html();
		allMounts;
//		console.log('你好');
//		console.log(allMounts);
//		$('.carts-number').text(allMounts);
		
	})
}
$('#open').click(function(){
	window.open('account.jsp')
})
