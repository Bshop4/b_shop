	new WOW().init();
	
	var pyl_flag_user=false;
	var pyl_flag_pass=false;
	var pyl_flag_email=false;
	
	var flagclear=false;
	//用户名失焦
	$('.user').blur(function(){
		//父级下边框变色
		$('.user').parent().css('border-bottom','1px solid gainsboro');
		$('.user').parent().css('box-shadow','');
		$('.user').parent().css('border-radius','');
		
		if(flagclear){flagclear=false;return;};
		$('.userclear').hide();
		if($('.user').val()==''){$('.use-tips').html("&Theta; 支持中文，英文，数字，'-','_'的组合，4-20个字符").css('color','gray').hide();$('.userclear').hide();return;};
		
		var re =/^[\u4e00-\u9fa5A-z\d-_]{4,20}$/g;
		var renumber=/^\d+$/g;
		if(renumber.test($('.user').val())){$('.use-tips').html("&otimes; 不能为纯数字！").css('color','orange');return;};
		
		if(re.test($('.user').val())){
			
			pyl_flag_user=true;//成功就对，返回不变false
			$('.user').siblings('.pyl_true').show();$('.use-tips').html("&Theta; 支持中文，英文，数字，'-','_'的组合，4-20个字符").css('color','gray').hide();
			$('.userclear').hide();
			return;
			
		}else{
			$('.user').siblings('.pyl_true').hide();$('.use-tips').html("&otimes; 仅支持中文，英文，数字，'-','_'的组合，4-20个字符").css('color','orange').show();
			$('.userclear').show();
		};
		pyl_flag_user=false;
	});
	
	//用户获焦
	$('.user').focus(function(){
		$('.use-tips').show();
//		box-shadow: 3px 3px 7px #666;
//		border-radius: 5px;
//		$('.user').parent().css('border-bottom','1px solid black');
		$('.user').parent().css('box-shadow','3px 3px 7px #666');
		$('.user').parent().css('border-radius','5px');
	});
	
	
	//用户松开按键
	$('.user').keyup(function(){
		$('.user').siblings('.pyl_true').hide();
		$('.userclear').show();
		$('.use-tips').html("&Theta; 支持中文，英文，数字，'-','_'的组合，4-20个字符").css('color','gray');
	});
	
	
	//用户点击清空输出
	$('.userclear').click(function(){
		$('.use-tips').html("&Theta; 支持中文，英文，数字，'-','_'的组合，4-20个字符").css('color','gray').hide();
		$('.user').val('');
	});
	//用户鼠标进入清空
	$('.userclear').mouseover(function(){
		flagclear=true;
	});
	//用户鼠标进入清空
	$('.userclear').mouseout(function(){
		flagclear=false;
	});
	
	
//	var flag_pass=false;
	//密码获焦事件
	$('.pyl_sign_password').focus(function(){
		$('.pass-tips').show();
//		$('.pyl_sign_password').parent().css('border-bottom','1px solid black');
		$('.pyl_sign_password').parent().css('box-shadow','3px 3px 7px #666');
		$('.pyl_sign_password').parent().css('border-radius','5px');
	});
	//密码失焦
	$('.pyl_sign_password').blur(function(){
		$('.pyl_sign_password').parent().css('border-radius','');
		$('.pyl_sign_password').parent().css('box-shadow','');
//		$('.pyl_sign_password').parent().css('border-bottom','1px solid gainsboro');
		if($('.pyl_sign_password').val()==''){$('.pass-tips').html('&Theta; 建议使用数字，字母，和符号两种及以上的组合，6-20个字符').hide();return;};
		//数据库去匹配
	});

	//密码按键事件
	$('.pyl_sign_password').keyup(function(){
		$('.pyl_sign_password').siblings('.pyl_true').hide();
		if($('.pyl_sign_password').val()=='')return;
		if($('.pyl_sign_password').val().length<6||$('.pyl_sign_password').val().length>20){$('.pass-tips').html('&otimes; 长度只能在6-20之间').css('color','orange');return;};
		var re1_6_20=/^(\d{6,20}|[A-z]{6,10}|[\W]{6,10})$/g;
		if(re1_6_20.test($('.pyl_sign_password').val())){
			$('.pass-tips').html('<i></i>&Theta; 有被盗风险，建议使用数字、字母、和符号两种及以上的组合').css('color','orange');
			$('.pass-tips i').css('background','url("img/ruo_03.png")');
			$('.pyl_sign_password').siblings('.pyl_true').show();return;
		};
		
		var re2_6_20=/^([\D]{6,20}|[^A-z]{6,10}|[\w]{6,10})$/g;
		if(re2_6_20.test($('.pyl_sign_password').val())){
			$('.pass-tips').html('<i></i>&Theta; 安全强度适中，可以使用三种及以上的组合来提高安全强度').css('color','gray');
			$('.pass-tips i').css('background','url("img/zhong_03.png")');
			$('.pyl_sign_password').siblings('.pyl_true').show();return;
		};
		
		var renumber=/^.{7,20}$/g;
		if(renumber.test($('.pyl_sign_password').val())){
			var re3_1=/[\W]/;
			if(re3_1.test($('.pyl_sign_password').val())){
				var re3_2=/[\d]/;
				if(re3_2.test($('.pyl_sign_password').val())){
					var re3_3=/[A-z]/;
					if(re3_3.test($('.pyl_sign_password').val())){
						$('.pass-tips').html('<i></i>&Theta; 你的密码很安全').css('color','gray');
						$('.pass-tips i').css('background','url(img/qiang_03.png)');
						$('.pyl_sign_password').siblings('.pyl_true').show();return;
					};
				};
			};
		};
	});
	
	//确认密码获焦
	$('.truepassword').focus(function(){
//		$('.truepassword').parent().css('border-bottom','1px solid black');
		$('.truepassword').parent().css('box-shadow','3px 3px 7px #666');
		$('.truepassword').parent().css('border-radius','5px');
	});
	
	
	//确定密码失焦
	$('.truepassword').blur(function(){
		$('.truepassword').parent().css('box-shadow','');
		$('.truepassword').parent().css('border-radius','');
//		$('.truepassword').parent().css('border-bottom','1px solid gainsboro');
		if($('.truepassword').val()==''){$('.truepass-tips').hide();$('.truepassword').siblings('.pyl_true').hide();return;};
		if($('.truepassword').val()==$('.pyl_sign_password').val()){
			$('.truepassword').siblings('.pyl_true').show();
			$('.truepass-tips').hide();
			pyl_flag_pass=true;//成功返回不变false，最后注册验证
			return;
		}else{
			$('.truepass-tips').css('color','orange').show();
			$('.truepassword').siblings('.pyl_true').hide();
		}
		console.log('密码变false');
		pyl_flag_pass=false;
	});
	
	
	
	//邮箱获焦
	$('.email').focus(function(){
//		$('.email').parent().css('border-bottom','1px solid black');
		$('.email').parent().css('box-shadow','3px 3px 7px #666');
		$('.email').parent().css('border-radius','5px');

	});
	
	
	//邮箱失焦
	$('.email').blur(function(){
//		$('.email').parent().css('border-bottom','1px solid gainsboro');
		$('.email').parent().css('box-shadow','');
		$('.email').parent().css('border-radius','');
		
		
		if($('.email').val()==''){$('.email-tips').hide();$('.email').siblings('.pyl_true').hide();return;};
		var  re=/^[0-9A-z_]+@[0-9A-z_]+\.com$/g;
		if(re.test($('.email').val())){
			$('.email').siblings('.pyl_true').show();
			$('.email-tips').hide();
			pyl_flag_email=true; //成功返回不变false，最后注册验证
			return;
		}else{
			$('.email-tips').css('color','orange').show();
			$('.email').siblings('.pyl_true').hide();
		}
		pyl_flag_email=false;
	});
	
	
	//邮箱验证获焦
	$('.emailcode').focus(function(){
//		$('.emailcode').parent().css('border-bottom','1px solid black');
		$('.emailcode').parent().css('box-shadow','3px 3px 7px #666');
		$('.emailcode').parent().css('border-radius','5px');
	});
	
	
	
	//邮箱验证失焦
	$('.emailcode').blur(function(){
//		$('.emailcode').parent().css('border-bottom','1px solid gainsboro');
		$('.emailcode').parent().css('box-shadow','');
		$('.emailcode').parent().css('border-radius','');
	});
	
	
	
	
	//注册点击事件去匹配数据库
	$('.pyl_sign_btn').click(function(){
		
		var uName=$('.user').val();
		var upass=$('.pyl_sign_password').val();
		
		if(pyl_flag_email&&pyl_flag_user&&pyl_flag_pass){
			$.post('http://www.wjian.top/shop/api_user.php?',
				{status:'register',
				 username:uName,
				 password:upass,
				},function(result){
					var obj=JSON.parse(result);
					var objlogin=null;
					console.log(1);
					
					if(obj.code==0){
						console.log(2);
						
						var goodsID=getUrlVal('goods_id');
						$.post('http://www.wjian.top/shop/api_user.php?',
						{status:'login',
							 username:uName,
							 password:upass,
							},function(result1){
								objlogin=JSON.parse(result1);
								console.log(objlogin);
								//登录分两种加入购物车过来和直接登录
								if(goodsID){
									$('.pyl_sign_tips').show();
									
		//							不能写死需要去数据库查购物车的数量
									localStorage.setItem('cartnumber','0');
									localStorage.setItem('username',objlogin.data.username);
								    localStorage.setItem('token',objlogin.data.token);
									var t=3;
									var time =setInterval(function(){
										t--;
										$('.pyl_sign_tips #backtime').html(t+'后秒自动进入当前商品');
										if(t==0){
											clearInterval(time);
											location.href='detail.jsp?goods_id='+goodsID;	
										}
									},1000);
									
								}else{
										//直接登录
										//======================================
										$('.pyl_sign_tips').show();
										localStorage.setItem('cartnumber','0');
										localStorage.setItem('username',objlogin.data.username);
									    localStorage.setItem('token',objlogin.data.token);
										var t=3;
										var time =setInterval(function(){
											t--;
											$('.pyl_sign_tips #backtime').html(t+'后秒自动进入主页');
											if(t==0){
												clearInterval(time);
												location.href='index.jsp';
											}
										},1000);
								}
							});
						
						
					}
				}
			);
		}
	});