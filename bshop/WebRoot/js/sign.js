	new WOW().init();
	
	var pyl_flag_user=false;
	var pyl_flag_pass=false;
	var pyl_flag_email=false;
	var pyl_flag_emailcode=false;
	var pyl_flag_emailcodeMath=false;
	var pyl_flag_emailcodeDie=false;
	var pyl_flag_sendEmailcode=false;
	
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
		var users=$('.user').val();
		if(re.test($('.user').val())){
			
			$.ajax({
				url:"Check_isaccount",
				type:"post",
				data:{"account":users},
				success:function(result){
					if(result=="true"){
						$('.user').siblings('.pyl_true').show();
						$('.user').attr("pyl_flag_user",1);
						$('.use-tips').html("&Theta; 支持中文，英文，数字，'-','_'的组合，4-20个字符").css('color','gray').hide();
						$('.userclear').hide();
					}else{
						$('.user').attr("pyl_flag_user",0);
						$('.user').siblings('.pyl_true').hide();$('.use-tips').html("&otimes;该帐号已存在").css('color','orange').show();
						$('.userclear').show();
					}
				}
			});
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
		$('.emailcode-tips').hide().html("").css('color','red');
	});
	
	
	//邮箱验证失焦
	$('.emailcode').blur(function(){
//		$('.emailcode').parent().css('border-bottom','1px solid gainsboro');
		$('.emailcode').parent().css('box-shadow','');
		$('.emailcode').parent().css('border-radius','');
		if($('.emailcode').val()==''){$('.emailcode-tips').hide();return;};
		var re3=/^\d+$/g;
		if(re3.test($('.emailcode').val())){
//			$('.emailcode').siblings('.pyl_true').show();
			pyl_flag_emailcodeMath=true;//邮箱验证码是否为数字
//			return;
		}else{
//			$('.emailcode-tips').show().html("&otimes; 验证码不正确").css('color','orange');
			pyl_flag_emailcodeMath=false;//邮箱验证码是否为数字
		}
	});
	
	var account1=$('.user').val();
	var password1=$('.pyl_sign_password').val();
	
	
	var clickSendcode=0;
	//点击发送验证码
	$(".sendemailcode").click(function(){
		if(pyl_flag_sendEmailcode){return;}
		clickSendcode++;
		pyl_flag_sendEmailcode=true;
		console.log("发送验证码");
		var email1=$('.email').val();
		$.ajax({
			url:"Sendemailcode",
			type:"post",
			data:{"email":email1},
			success:function(result){
				var resu=JSON.parse(result);
				$('.emailcode').attr("serverEmailCode",resu.passage);
				emailCodeDie(resu.passage);
			}
		});
	})
	
	
	var Timeout=null;//用来放倒计时验证码失效的 
	//倒计时60秒。验证码失效
	function emailCodeDie(code){
		var timeemail=60; 
		var c=code;
		pyl_flag_emailcodeDie=true;
		var Timer=setInterval(function() {
			timeemail--;
			$(".sendemailcode").html(timeemail+"S秒后重新获取");
			if(timeemail==0){
				$(".sendemailcode").html("免费获取验证码");
				pyl_flag_sendEmailcode=false;//是否发送了验证码；
				clearTimeout(Timer);
			}
		}, 1000);
		
		if(clickSendcode==1){
			clickSendcode=0;
			clearTimeout(Timeout);
			Timeout=setTimeout(function() {
				c="无";//服务器反馈来的
				pyl_flag_emailcodeDie=false;//验证码失效
			}, 180000);
		}
		
	}
	
	
	//注册点击事件去匹配数据库
	$('.pyl_sign_btn').click(function(){
		//帐号为对就为真
		if($('.user').attr("pyl_flag_user")==1){
			pyl_flag_user=true;//成功就对，返回不变false
		}else{
			pyl_flag_user=false;//成功就对，返回不变false
		}
		
		//获得用户的验证码
		var EmailCode=$('.emailcode').val();
		var clientEmailCode=Base64.encode(EmailCode);
		
		if(!pyl_flag_emailcodeMath){$('.emailcode-tips').show().html("&otimes; 验证码不正确");return;}//邮箱验证码不为数字
		if(clientEmailCode){
			if(!pyl_flag_emailcodeDie){$('.emailcode-tips').show().html("&otimes; 验证码已失效，请重新发送");return;};
		}
		//获得服务器返回的验证码
		var serverEmailCode=$('.emailcode').attr("serverEmailCode");
		console.log(clientEmailCode);
		if(clientEmailCode==serverEmailCode&&clientEmailCode){
			pyl_flag_emailcode=true;
		}else{
			$('.emailcode-tips').show().html("&otimes; 验证码不正确");
			pyl_flag_emailcode=false;
			return;
		}
		
		if(pyl_flag_email&&pyl_flag_user&&pyl_flag_pass&&pyl_flag_emailcode){
			console.log(55);
			$.post('Sign_account.do',
				{
				email:email1,
				account:account1,
				password:password1,
				},function(result){
					console.log(result);
					var obj=JSON.parse(result);
					var objlogin=null;
					
					if(obj.code==0){
						console.log(2);
						var goodsID=getUrlVal('goods_id');
						$.post('xxx.do',
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
		}else{
			
			
		}
	});