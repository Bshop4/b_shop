  //请求用户的购物车数据
  function goodsList(page, callback){
    var page = page ? page : 1;
    //页面打开就可以看到商品
    $.get('http://www.wjian.top/shop/api_goods.php',{
      'pagesize':3,
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
      var str = `
        <tr>
          <td class="left">
            <img src="${goodsList[i].goods_thumb}"/>
          </td>
          <td class="desc">${goodsList[i].goods_desc}</td>
          <td class="calculate">
            <span class="count">1</span>
          </td>
          <td>${goodsList[i].price}</td>
          <td class="subtotal">${goodsList[i].price}</td>
        </tr>
      `;
      //把每次组装好的添加进table
      $('table').append(str);
    };
		allMount = goodsList.length;
    //所有的业务逻辑都在这之后
    clickAll();
  });

var content = window.opener.document.getElementById("all-sum").innerHTML;
(function(){
	console.log(1111111111);
	$('#sum-all').html(content);
})()
