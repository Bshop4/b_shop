	new WOW().init();
	var userflag=false;
	var passflag=false;
	
	if(localStorage.getItem('token')) {$('.pyl_panel').show();};
	
	$('.pyl_panel #backheadpage').click(function(){
		location.href='/bshop/index.jsp';
	});
	
	$('.pyl_panel #backlogin').click(function(){
		localStorage.removeItem('username');
		localStorage.removeItem('token');
		localStorage.removeItem('cartnumber');
		$('.pyl_panel').hide();
	});
	
	
	$('.pyl_login_user input').select();
	//帐号失焦判断
	$('.pyl_login_user input').blur(function(){
		if($('.pyl_login_user input').val()==""){$('.pyl_login_user_tips').html('帐号长度只能是4-20字符').css('color','orange').hide();return;};
		//长度判断
		if($('.pyl_login_user input').val().length<4||$('.pyl_login_user input').val().length>20){
			$('.pyl_login_user_tips').show();
			userflag=false;
			return;
		}else{
			$('.pyl_login_user_tips').hide();
		};
		userflag=true;
	});
	
	//帐号键盘弹起事件
	$('.pyl_login_user input').keyup(function(){
		$('.pyl_login_user_tips').hide();
	});
	
	
	//密码框失焦判断
	//密码失焦
	$('.pyl_login_userpass input').blur(function(){
		if($('.pyl_login_userpass input').val()==""){$('.pyl_login_password_tips').hide();return;}
		if($('.pyl_login_userpass input').val().length<6||$('.pyl_login_userpass').val().length>14){
			passflag=false;
			return;}
		//密码格式
		passflag=true;
	});
	
	//密码框获焦事件
	$('.pyl_login_userpass input').focus(function(){
		if($('.pyl_login_userpass input').val()==""){$('.pyl_login_password_tips').hide();return;}
	});
	
	
	//密码框键盘弹起事件
	$('.pyl_login_userpass input').keyup(function(){
		$('.pyl_login_password_tips').hide();
	});
	
	
	
	//点击注册按钮
	$('.pyl_userfindpass #pyl_login').click(function(){
		var goodsNO=getUrlVal('goods_no');
		if(goodsNO){
			location.href='/bshop/sign.jsp?goods_no='+goodsNO;
		}else{
			location.href='/bshop/sign.jsp';
		}
	});
	
	//点击找回密码按钮
	$('.pyl_userfindpass #pyl_findpass').click(function(){
		var goodsNO=getUrlVal('goods_no');
		if(goodsNO){
			location.href='/bshop/findpass.jsp?goods_no='+goodsNO;
		}else{
			location.href='/bshop/findpass.jsp';
		}
	});
	
	
	
	var loginTimer=null;
	
	//立即登录按钮点击
	$('.pyl_fastlogin_btn').click(function(){
		if(!passflag||!userflag){
			//console.log(passflag+''+userflag+$('.pyl_login_user input').val());
			$('.pyl_login_password_tips').show();
			return;
		}
		
		//去数据库验证帐号
		var uName=$('.pyl_login_user input').val();
		var upass=$('.pyl_login_userpass input').val();
		
		//如果前面两个都对了就开始请求服务器
		$.post('Login_Action.do',
			{
			account:uName,
			password:upass,
			},function(result){
				//console.log(result);
				var obj=JSON.parse(result);
				//var obj=result;
				
				//登录分两种加入购物车过来和直接登录
				if(obj.code==0){
					var goodsNO=getUrlVal('goods_no');
					console.log(goodsNO);
					if(goodsNO){
//						localStorage.setItem('username',obj.data.username);
//						localStorage.setItem('token',obj.data.token);			
						location.href='/bshop/detail.jsp?goods_no='+goodsNO;	
						
					}else{
						//直接登录
//						localStorage.setItem('cartnumber','0');
//						localStorage.setItem('username',obj.data.username);
//						localStorage.setItem('token',obj.data.token);
						//提示成功登录
						$('.pyl_sign_tips').show();
						loginTimer=setTimeout(function(){
							location.href='/bshop/index.jsp';	
						},1500);
					}
				};
				if(obj.code==414){
					$('.pyl_login_password_tips').show().html(obj.msg);//密码错误
				};
				if(obj.code==413){
					$('.pyl_login_user_tips').html(obj.msg).show();//帐号不存在
				};
					
			}
		);
	});
	
	//关闭登录时的计时
	function closeTime(){
		clearTimeout(loginTimer);
		location.href='/bshop/index.jsp';
	}