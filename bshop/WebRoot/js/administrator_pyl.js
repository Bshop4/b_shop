	
//全局变量
var pageNo=1;
var pageSize=10;
var email;
var account;
var maxPageCount;

	//页面打开
	(function(){
		myNeedsList();
		getMaxPage();
	})();
//一进来就要根据帐号去查管理员
	$(function(){
		$.ajax({
			type:"post",
			url:"admi_personInfo",
			success:function(result){
				var obj=JSON.parse(result);
				//抛这个值出来result.administrator_account;
				if(obj.code==0){
					var strUser=`<div class="photo"><img src="img/11_03.png"/></div><div class="name"><span>${obj.data.account}</span><div class="triangle-top"></div></div>`;
					$('.AM_top .right_user').append(strUser);
				}
			}
		});
	});
	
	
	//点击选择变色
	$('.AM_body .left_bar ul li').each(function(i){
		$('.AM_body .left_bar ul li').eq(i).click(function(){
			for(var j=0;j<$('.AM_body .left_bar ul li').length;j++){
				$('.AM_body .left_bar ul li').eq(j).removeClass("active");
			};
			$('.AM_body .left_bar ul li').eq(i).addClass("active");
			selectContext(i);
		});
	});
	
	//获取帐号框的值
	$('.find_key>.myaccount').keyup(function(){
		emial=$('.find_key>.email').val();
		if(account!=$('.find_key>.myaccount').val()){
			account=$('.find_key>.myaccount').val();
			pageNo=1;
			$('.pageNum').val(pageNo);
			myNeedsList();
			getMaxPage();
		}
	})
	
	//获得密码框的值
	$('.find_key>.myemail').keyup(function(){
		account=$('.find_key>.myaccount').val();
		if(email!=$('.find_key>.myemail').val()){
			email=$('.find_key>.myemail').val();
			pageNo=1;
			$('.pageNum').val(pageNo);
			myNeedsList();
			getMaxPage();
		}
	})
	
	function selectContext(n){
		console.log(n);
		if(n==0){
			$('.use_play').show();
			myNeedsList();
		}
		
		if(n==1){
			$('.use_play').hide();
			$.ajax({
				type:"post",
				url:"",
				success:function(result){
					
				
				}
			});	
		}
	}
	
	//获取需求的数据
	function myNeedsList(){
		$.ajax({
			type:"post",
			url:"Administrator_selectAccount.do",
			data:{
				pageNo:pageNo,
				pageSize:pageSize,
				account:account,
				email:email,
			},
			success:function(result){
				
				$('.play_context table').empty();
				
				var stri=`
					<tr style="text-align: center;">
									<th>id</th>
									<th>account</th>
									<th>password</th>
									<th>email</th>
									<th>ipaddress</th>
									<th>ban</th>
									<th>操作</th>
									<th>神操作</th>
								</tr>
				`;
				
				$('.play_context table').append(stri);
				
				console.log(result);
				if(result.length!=0){
					for(var j=0;j<result.length;j++){
						var str=`
								<tr>
								<td>${j+1}</td>
								<td class="myAc">${result[j].account}</td>
								<td class="myPa">${result[j].password}</td>
								<td class="myEm">${result[j].email}</td>
								<td class="myIp">${result[j].ipaddress}</td>
								<td class="myBa">${result[j].ban}</td>
								<td onclick="myUpdate(this)">修改</td>
								<td style="cursor:pointer;" onclick="myDelete(this)">删除</td>
							</tr>`;
						$('.play_context table').append(str);
					}
				}else{
					alert("没有找到相应的帐号");
				}
			}
		});
	}
	
	//获得最大页数
	function getMaxPage(){
		$.ajax({
			type:"post",
			url:"AdminMaxPage.do",
			data:{
				pageNo:pageNo,
				pageSize:pageSize,
				account:account,
				email:email,
			},
			success:function(result){
				maxPageCount=result;
				$('.pageSkining>center>span').html("总共有"+maxPageCount+"页");
			}
		})
	}
	
	//鼠标点击下一页
	$('.btnNext').click(function() {
		pageNo++;
		if(pageNo >= maxPageCount) {
			pageNo = maxPageCount;
		}
		$('.pageNum').val(pageNo);
		
		//获取需要的值
		myNeedsList();
	})

	//鼠标点击上一页
	$('.btnPrev').click(function() {
		pageNo--;
		if(pageNo < 1) {
			pageNo = 1;
		}
		$('.pageNum').val(pageNo);
		//获取需要的值
		myNeedsList();
	})

	//点击跳转
	$('.btnJump').click(function() {
		pageNo = $('.pageNum').val();
		if(parseInt($('.pageNum').val()) > maxPageCount) {
			pageNo = maxPageCount;
		}
		if(parseInt($('.pageNum').val()) < 1) {
				pageNo = 1;
		}
		$('.pageNum').val(pageNo);
		myNeedsList();
	})

	//点击首页
	$('.btnStart').click(function(){
		pageNo = 1;
		$('.pageNum').val(pageNo);
		//获取需要的值
		myNeedsList();
	})

	//点击尾页
	$('.btnEnd').click(function(){
		pageNo = maxPageCount;
		$('.pageNum').val(pageNo);
		//获取需要的值
		myNeedsList();
	})
	
	//点击修改弹框
	function myUpdate(obj){
		//拿值
		var myac=$(obj).siblings('.myAc').html();
		var mypa=$(obj).siblings('.myPa').html();
		var myem=$(obj).siblings('.myEm').html();
		var myip=$(obj).siblings('.myIp').html();
		var myba=$(obj).siblings('.myBa').html();
		console.log(myac);
		//放值
		$('.ac').val(myac);
		$('.pa').val(mypa);
		$('.em').val(myem);
		$('.ip').val(myip);
		$('.ba').val(myba);
		
		//表显示
		$('.myupdate').show();
	}
	
	$('.mycance').click(function(){
		$('.myupdate').hide();					
	})
	
	//点击提交
	$('.updateBtn').click(function(){
		//获取需要的值
		var account=$('.ac').val();	
		var password=$('.pa').val();
		var email=$('.em').val();
		var	ipaddress=$('.ip').val();
		var	ban=$('.ba').val();	
		
		$.ajax({
			type:"post",
			url:"UpdateMyAccount.do",
			data:{
				account:account,
				email:email,
				password:password,
				ipaddress:ipaddress,
				ban:ban,
			},
			success:function(result){
				var myneeds=JSON.parse(result);
				if(myneeds.code==0){
					alert(myneeds.msg);
					$('.myupdate').hide();
					//执行查询
					myNeedsList();
					getMaxPage();
					
				}else{
					alert(myneeds.msg);
					$('.myupdate').hide();
					//执行查询
					myNeedsList();
					getMaxPage();
				}
			}				
		})
	})
	
	//删除
	function myDelete(obj){
		confirm("确定删除？");
		//获得所需要的值
		var account=$(obj).siblings('.myAc').html();
		
		$.ajax({
			type:"post",
			url:"DeleteMyAccount",
			data:{
				account:account,
			},
			success:function(result){
				var myneeds=JSON.parse(result);
				if(myneeds.code==0){
					alert(myneeds.msg);
					//执行查询
					myNeedsList();
					getMaxPage();
					
				}else{
					alert(myneeds.msg);
					//执行查询
					myNeedsList();
					getMaxPage();
				}
			}
		})
	}
	
	
	