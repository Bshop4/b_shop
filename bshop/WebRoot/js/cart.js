$(document).ready(function(){
	$.ajax({
		type:"post",
		url:"setStatezero.do",
		success:function(result){
			console.log(result);
		}
	})
})
//请求数据库的购物车数据
var XMLHttp;
// 创建ajax对象
function createXMLHttp() {
	// google
	if (window.XMLHttpRequest) {
		XMLHttp = new XMLHttpRequest();
	} else {
		try {
			// IE
			XMLHttp = new ActiveXObject("Msxm2.XMLHTTP");
		} catch (e) {
			XMLHttp = new ActiveXObject("MicrosoftXMLHTTP");
		}
	}
}
// 定义一个需要进行操作的变量
var returnResult;
var account;
$(document).ready(function() {
//	account = "pyla1";
	createXMLHttp();
	$.ajax({
		type : "POST",
		url : "selectCartGoods.do",
//		data : {"account" : account},
		success : function(result) {
			var result=JSON.parse(result);
			returnResult = result;
			console.log(returnResult);
			var length  = returnResult.length;
			account = returnResult[length-1];
			console.log(account);
			// 验证
			if (result.account==0) {
				console.log("请求数据失败");
				return;
			};
			if (length-1==0) { 
				return;
			}
			
			console.log(length);
			for (var i = 0; i < length-1; i++) {
				var str = `
					<tr>
						<td class="left">
							<input type="checkbox" class="check" data-no=${result[i].cart_id}></input>
							<img src=${result[i].cgoods_photo} style="width:100px;height:100px;cursor: pointer;" onclick="forwarddetail(${result[i].cgoods_no})"/>
						</td>
						<td class="desc">${result[i].cgoods_desc}</td>
			            <td class="calculate">
				            <button class="add" data-add=${result[i].cart_id}>+</button>
				            <span class="count">${result[i].cgoods_number}</span>
				            <button class="reduce" data-red=${result[i].cart_id}>-</button>
			            </td>
						<td>${result[i].cgoods_color}</td>
						<td>${result[i].cgoods_size}</td>
			            <td>${result[i].cgoods_price}</td>
			            <td class="subtotal">${result[i].cgoods_sub}</td>
			            <td><a href="javascript:;" class="del" data-id=${result[i].cart_id}  data-toggle="modal" data-target="#myModal">删除</a></td>
			        </tr>
					`;
				 // 把每次组装好的添加进table
			     $('table').append(str);
			};
			$('.carts-number').text(returnResult.length-1);
			allMount = returnResult.length-1;
		    // 所有的业务逻辑都在这之后
		    clickAll();
		}
	})
})

function clickAll() {
	// 点击加减数量变 小计变 总价变
	// 点击全选 总价变
	// 点击单选 总价变
	// 点击删除 当前元素tr删除

	// 点击整个表格
	$('table').click(function(event) {
		console.log(event);
		// 验证，判断点击的是哪一个元素
		// 点击减
		if (event.target.className == 'reduce') {
			// 要做商品减的业务
			// 拿到数量
			var spanDom = event.target.previousElementSibling;
			var spanDomVal = parseInt(event.target.previousElementSibling.innerHTML);
			spanDomVal--;
			if (spanDomVal < 1) {
				spanDomVal = 1
				return;
			};
			var cart_id = $(event.target).attr("data-red");
			console.log(cart_id);
			$.ajax({
				type:"POST",
				url:"redCartGoods.do",
				data:{"cart_id":cart_id},
				success:function(result){
					var result = JSON.parse(result);
					console.log(result);// true(增加成功)
				}
			});
			// 数据库修改成功后才能去设置界面
			spanDom.innerHTML = spanDomVal;
			// 求小计
			subtotal(event.target, spanDomVal);
			// 求总价
			sumAll();
		}
		;

		// 点击加
		if (event.target.className == 'add') {
			// 要做商品减的业务
			// 拿到数量
			var spanDom = event.target.nextElementSibling;
			var spanDomVal = parseInt(event.target.nextElementSibling.innerHTML);
			spanDomVal++;
			if (spanDomVal > 99) {
				spanDomVal = 99
			};
			var cart_id = $(event.target).attr("data-add");
			console.log(cart_id);
			$.ajax({
				type:"POST",
				url:"addCartGoods.do",
				data:{"cart_id":cart_id},
// success:function(result){
// var result = JSON.parse(result);
// console.log(result);//true(增加成功)
// }
			});
			console.log(222);
			// 数据库修改成功后才能去设置界面
			spanDom.innerHTML = spanDomVal;
			// 求小计
			subtotal(event.target, spanDomVal);
			// 求总价
			sumAll();
		}
		;

		// 点击全选
		if (event.target.className == 'checkAll') {
			// 要做商品减的业务
			// console.log(event.target.checked)
			if (event.target.checked == true) {
				// 选中所有的
				$('.check').each(function() {
					$(this).prop('checked', true);
					// 给当前元素加个标识(自定义的属性)
					$(this).attr('data-price', 'active');
					$(this).attr('del-red','active')
				});
			} else {
				// 选中所有的
				$('.check').each(function() {
					$(this).prop('checked', false);
					// 拿掉标识(自定义的属性)
					$(this).attr('data-price', '');
					$(this).attr('del-red', '');
				});
			}
			;
			// 求总价
			sumAll();
		}
		;

		// 点击单选
		if (event.target.className == 'check') {
			// 要做商品减的业务
			// console.log('点击了单选');
			if (event.target.checked == true) {
				// 给当前元素加个标识(自定义的属性)
				event.target.setAttribute('data-price', 'active');
				event.target.setAttribute('del-red','active')
			} else {
				// 拿掉标识(自定义的属性)
				event.target.setAttribute('data-price', '');
				event.target.setAttribute('del-red', '');
			}
			allMounts();
			// 求总价
			sumAll();
		}
		;

		// 点击删除
		if (event.target.className == 'del') {
			// 要做商品减的业务
			console.log('点击了删除');
			// 找到tr删除自己
			var tab = event.target.parentNode.parentNode.parentNode;
			var tr = event.target.parentNode.parentNode;
// console.log(returnResult.length+"哈哈");
			// 得到删除的商品的id
			var cart_id = $(event.target).attr("data-id");
			$('.el-sure').click(function(){
				console.log(111)
				$.ajax({
					type:"POST",
					url:"deleteCartGoods.do",
					data:{"cart_id":cart_id},
					success:function(result){
						var result = JSON.parse(result);
						console.log(result);// true(删除成功)
						tab.removeChild(tr);
						$('.carts-number').text(--allMount);// 左上角购物车数量减一
					}
				});
			})
			// 调用总价
			sumAll();
		}
		;
	});
	$('.footer').click(function(event) {
		if (event.target.className == 'checkAll') {
			if (event.target.checked == true) {
				// 选中所有的
				$('.check').each(function() {
					$(this).prop('checked', true);
					// 给当前元素加个标识(自定义的属性)
					$(this).attr('data-price', 'active');
					$(this).attr('del-red','active')
				});
			} else {
				// 选中所有的
				$('.check').each(function() {
					$(this).prop('checked', false);
					// 拿掉标识(自定义的属性)
					$(this).attr('data-price', '');
					$(this).attr('del-red','')
				});
			}
			;
			// 求总价
			sumAll();
		};
		// 点击删除
		if (event.target.className == 'delAll') {
			// 全部删除
			console.log('点击了选中删除');
			// 调用删除
			delAll();
			// 调用总价
			sumAll();
		};
		if(event.target.className == 'btn-account'){
			consolelog("点了去结算");
			
		}
	});
};

// 求小计
function subtotal(that, count) {
	// 拿到单价
	var price = parseInt(that.parentNode.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML);
// console.log(price);
	// 拿到小计元素
	var subtotalDom = that.parentNode.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling;
	// 设置
	subtotalDom.innerHTML = price * count + '.00';
};

// 求总价方法
function sumAll() {
	var sum = 0;
	// 拿到所的 active
	$('[data-price="active"]').each(function() {
		sum += parseInt($(this).parent().siblings('.subtotal').html());
	});
	// 设置总价
	$('.sum-all').html('合计：¥' + sum + '.00');
};

// 删除选中商品
function delAll() {
	$('[data-price="active"]').each(function() {
		console.log($(this));
		var tab = $(this).parent().parent().parent();
		var tr = $(this).parent().parent();
		var cart_id = $('[del-red="active"]').attr("data-no");
		console.log(cart_id) 
		 $.ajax({
		 type:"POST",
		 url:"deleteCartGoods.do",
		 data:{"cart_id":cart_id},
		 success:function(result){
		 var result = JSON.parse(result);
		 console.log(result);//true(删除成功)
		 }
		 });
		tab.get(0).removeChild(tr.get(0));
	});
};

// 计算选中的商品数量
function allMounts() {
	$('[data-price="active"]').each(function() {
		var allMounts = $(this).parent().siblings('.calculate').children('.count').html();
		allMounts;
	})
}
var cart_id;
$('#open').click(function() {
	console.log(888);
	$('[data-price="active"]').each(function() {
		console.log($(this));	
		var tab = $(this).parent().parent().parent();
		var tr = $(this).parent().parent();
		cart_id = $('[del-red="active"]').attr("data-no");
		console.log(cart_id) 
// 先根cart_id更新一遍,选的是哪个id，将这个商品的状态值改变
		$.ajax({
			type : "POST",
			url : "selectCartGoodsById.do",
			data : {"cart_id" : cart_id}, 
			success : function(result) {
				var result=JSON.parse(result);
				console.log(result);
			}
		})
		tab.get(0).removeChild(tr.get(0));
	})
	location.href="/bshop/badAccess/account.jsp?account_name="+account;
})

function forwarddetail(goods_no){
	location.href="/bshop/detail.jsp?goods_no="+goods_no;
}

