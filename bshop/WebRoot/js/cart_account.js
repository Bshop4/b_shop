  //请求用户的购物车数据
  function goodsList(page, callback){
    var page = page ? page : 1;
    // 页面打开就可以看到商品
    $.get('http://www.wjian.top/shop/api_goods.php',{
      'pagesize':3,
      'page':page,
    }, function(result){
      var result = JSON.parse(result);
      // 验证
      if(result.code != 0){
        console.log('数据请求失败');
        return;
      };
      // 调用
      callback(result);
    }); 
  };
  var allMount = 0;
  goodsList(1, function(result){
    var goodsList = result.data;
    // 得到数据了之后，在这里操作数据
    // 组装DOM结构
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
      // 把每次组装好的添加进table
      $('table').append(str);
    };
//		allMount = goodsList.length;
//     所有的业务逻辑都在这之后
// clickAll();
  });

 var content = window.opener.document.getElementById("all-sum").innerHTML;
 (function(){
 console.log(1111111111);
 $('#sum-all').html(content);
 })()


  function mysaveclicks(){
      var name = document.getElementById("myname").value;
      var iphone = document.getElementById("myiphone").value;
      var postcode = document.getElementById("mypostcode").value;
      var pro = document.getElementById("province").value;
      var city = document.getElementById("city").value;
      var area = document.getElementById("area").value;
      var detailaddress = document.getElementById("mydetailaddress").value;

      if(name == ""){
          $(".namelable").show();
          return ;
      }else{
          $(".namelable").hide();
      }

      var reiphone = /^1[0-9]{10}/;
      if(reiphone.test(iphone) != true){
          $(".iplabel").show();
          return;
      }else{
          $(".iplabel").hide();
      }

      if(postcode == ""){
          $(".postlabel").show();
          return ;
      }else{
          $(".postlabel").hide();
      }

      // 新加判断 原地址判断删除
      if(pro == "" || city == "" || area == "" || detailaddress == "" || pro == "请选择省份" || city == "请选择城市" || area == "请选择区县"){
          $("#addlabel").show();
          return;
      }else{
          $("#addlabel").hide();
      }


      if(reiphone.test(iphone) == true && name != "" && postcode != ""){
      // 定义变量
      var getPro;
      var getCity;
      var getArea;
      var AllAddress;

      for(var i=0;i<infos.length;i++){
          if(infos[i].code == $('#province').val()){
              getPro = infos[i].name;// 省份
          }
      };
      for(var j=0;j<cities.length;j++){
          if(cities[j].code == $('#city').val()){
              getCity = cities[j].name;// 城市
              for (var k=0;k<cities[j].area.length;k++){
                  if(cities[j].area[k].code == $('#area').val()){
                      getArea = cities[j].area[k].name;// 区县
                  }
              }
          }
      }
      AllAddress = getPro + getCity + getArea +  detailaddress;

      document.getElementById("save1").setAttribute("data-dismiss","modal");
      $(".address-list").css({
  		"width": "1180px",
  		"height": "80px",
  		"margin-left": "10px",
  		"position": "relative",
  	  })
  	  $(".btn-no-data").css({
  		"display": "none",
  	  })
  	  
  	  if(reiphone.test(iphone) == true && name != "" && postcode != ""){
	  	  var obj = $("<li style='float: left;margin-left: 20px;'></li>");
	  	  $(".address-list").append(obj)
	  	  obj.append("收货人姓名：" + name);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人电话：" + iphone);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人邮编：" + postcode);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人地址：" + AllAddress);
	
	  	  document.getElementById("myname").value = "";
	  	  document.getElementById("myiphone").value = "";
	  	  document.getElementById("mypostcode").value = "";
	  	  document.getElementById("province").value = "请选择省份";
	  	  document.getElementById("city").value = "请选择城市";
	  	  document.getElementById("area").value = "请选择区县";
	  	  document.getElementById("mydetailaddress").value = "";  	  
      }
      }
  }
