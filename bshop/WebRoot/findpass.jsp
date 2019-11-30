<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/findpass.css" />
		<link rel="stylesheet" href="css/animate.css" />
	    <link rel="stylesheet" href="css/bootstrap.css" />
	    <link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/base.css" />
		<style>
		</style>
	</head>
	<body>
		<!--头部-->
    <div class="top">
      <div class="top-bar">
        <div class="btn">
          <a>注册</a>
          <a>登录</a>
          <a class="glyphicon glyphicon-shopping-cart"></a>
        </div>
        <div class="logo">
        </div>
        <div class="search-wrap">
          <input placeholder="搜索商品" />
          <button class="glyphicon glyphicon-search"></button>
        </div>
      </div>
    </div>
    <!--导航-->
    <div class="taber-bar">
      <!--上部分导航-->
      <div class="tabs-list-top">
        <ul class="tabs-list text-center">
          <li class="tab">
            <a>首页</a>
          </li>
          <li class="tab">
            <a>新品</a>
          </li>
          <li class="tab">
            <a>男士</a>
          </li>
          <li class="tab">
            <a>女士</a>
          </li>
          <li class="tab">
            <a>品牌</a>
          </li>
          <li class="tab">
            <a>走秀移动版</a>
          </li>
        </ul>
      </div>
      <!--下部分导航-->
      <div class="tabs-list-buttom">
        <ul class="tabs-list text-center">
        </ul>
      </div>
    </div>
    <!--所有商品-->
    <section class="section-merchandise">
      <div class="merchandise">
        <ul></ul>
      </div>
    </section>
		<div class="top-safety">安全校验</div>
		<div class="top-forget">你忘记密码了吗？</div>
		<div class="if-foget">如果您忘记了密码，请输入您用于创建账户的手 机号码，我们将会给你发送一条验证码信息，以 便恢复密码。</div>
		<div class="pyl_div">
			<div class="phone-num">帐号</div>
			<input autocomplete="off" type="text" class="input-control user" />
			<div class="use-tips">帐号格式不正确</div>
			<div class="userclear"></div>
		</div>
		<div class="pyl_div">
			<div class="img-varify">邮箱</div>
			<input autocomplete="off" type="text" class="input-control email" />
			<div class="email-tips">邮箱格式不正确</div>
		</div>
		<div class="pyl_div">
			<div class="msg-varify">邮箱验证码</div>
			<input autocomplete="off" type="text" class="input-controls emailcode" /><button class="el-button">免费获取验证码</button>
			<div class="emailcode-tips">邮箱验证码不正确</div>
		</div>
		<button class="find-button">找回密码</button>
		
	<!-- 模态框 -->
	<div class="modal fade" id="addAddress" data-backdrop="static" id="addressform">
        <div class="modal-dialog">
            <div class="modal-content" style="width:700px;height:380px;">
                <div class="modal-header">
                    <h2 class="text-success modal-title">请设置新密码
                        <span class="close" data-dismiss="modal">&times;</span>
                    </h2>
                </div>

                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="form-group">
                                <label>新密码:</label>
                                <input type="password" class="form-control" id="newPassWord"/><label class="newPassWord-tips">设置一个新密码</label>
                            </div>

                            <div class="form-group">
                                <label>确认密码:</label>
                                <input type="password" class="form-control" id="truePassWord"/><label class="truePassWord-tips">再次输入密码</label>
                            </div>
                    	</div>
                    </div>
               </div>

                <div class="modal-footer">
                	<center>
                    <button class="btn btn-success "   id="savepass" onclick="saveNewPassWord()">确认修改</button>
                	</center>
                </div>

        	</div>
   		</div>
    </div>
    
    <!--底部-->
    <div id="row-1">
    	<!--底部三个图标-->
      <div class="row-1">
        <div class="ariplane">
          <img src="img/airplane.png" /> 海外直销
        </div>
        <div class="handshake">
          <img src="img/handshake.png" /> 品质保证
        </div>
        <div class="zheng">
          <img src="img/zheng.png" /> 售后保障
        </div>
      </div>
    </div>
	<!--底部banner与二维码-->
    <div id="row-2">
      <div class="row-2">
        <div class="logo-wrap">
          <img src="img/Bshop_logo1.png" class="logo-wrap-img1" />
          <a><img src="img/weixin.png" class="logo-wrap-img2" /></a>
          <a><img src="img/weibo.png" class="logo-wrap-img3" /></a>
        </div>
        <ul class="help-link-list">
          <li class="link">
            <a>ceo邮箱</a>
          </li>
          <li class="link">
            <a>售后服务</a>
          </li>
          <li class="link">
            <a>常见问题</a>
          </li>
          <li class="link">
            <a>关税问题</a>
          </li>
          <li class="link">
            <a>物流配送</a>
          </li>
        </ul>
        <div class="qrcode-wrap">
          <div class="qrcode-wrap-title">
            <span>移动嘿店</span>
          </div>
          <ul>
            <li class="qrcpde"><img src="img/erweima.png"></li>
            <li class="qrcpde"><img src="img/erweima.png"></li>
            <li class="qrcpde"><img src="img/erweima.png"></li>
          </ul>
        </div>
        <div class="contact-wrap">
          <div class="contact-wrap-title">
            <span>联系我们</span>
            <p>
              <a>400-888-4499(9:00~19:00)</a>
            </p>
          </div>
          <div class="btn-service">
            在线客服
          </div>
        </div>
      </div>
    </div>

    <div id="row-3">
      <div class="row-3">
        <div class="copytright">
          Copyright © 2008-2018 Xiu.com深圳走秀网络科技有限公司版权所有 . 粤ICP备07502993号 粤公网安备 44030402000804号
        </div>
      </div>
    </div>

    <div id="row-4">
      <div class="row-4">
        <div class="row-4-m">
          <div class="row-4-service">
            <a><img src="img/licence2.png"/></a></div>
          <div class="row-4-service">
            <a><img src="img/licence1.png"></a>
          </div>
          <a class="row-4-service-2"><img src="img/police2.png"></a>
          <a class="row-4-service-2"><img src="img/police1.png"></a>
          <a class="row-4-service-2"><img src="img/rights.png"></a>
        </div>
      </div>
    </div>
	</body>
</html>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/base.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script>
	var pyl_flag_email=false;
	var pyl_flag_sendEmailcode=false;
	var pyl_flag_user=false;
	var flagclear=false;
	var pyl_flag_emailcodeMath=false;
	var pyl_flag_emailcode=false;
	var pyl_flag_emailcodeDie=false;
	var truepassflag=false;//确定修改密码
	
	
	//用户名失焦
	$('.user').blur(function(){
		if(flagclear){flagclear=false;return;};
		$('.userclear').hide();
		if($('.user').val()==""){return;};
		var re =/^[\u4e00-\u9fa5A-z\d-_]{4,20}$/g;
		var renumber=/^\d+$/g;
		if(renumber.test($('.user').val())){
			$('.use-tips').html("&otimes; 不能为纯数字").css('color','red').show();return;
		};
		var users=$('.user').val();
		if(re.test($('.user').val())){
			$.ajax({
				url:"Check_isaccount",
				type:"post",
				data:{"account":users,"state":"A"},
				success:function(result){
					if(result=="false"){
						$('.userclear').hide();
					}else{
						$('.user').attr("pyl_flag_user",0).focus();
						$('.use-tips').html("&otimes;该帐号不存在").css('color','red').show();
					}
				}
			});
			return;
		}else{
			$('.user').siblings('.pyl_true').hide();$('.use-tips').html("&otimes; 帐号长度为4-20个字符").css('color','orange').show();
			$('.userclear').show();
		};
		pyl_flag_user=false;
		
	});
	
	//用户获焦
	$('.user').focus(function(){
		$('.use-tips').hide();
		$('.userclear').show();
	});
	
	//用户点击清空输出
	$('.userclear').click(function(){
		//$('.use-tips').html("&Theta; 支持中文，英文，数字，'-','_'的组合，4-20个字符").css('color','gray').hide();
		$('.user').val('').focus();
	});
	//用户鼠标进入清空
	$('.userclear').mouseover(function(){
		flagclear=true;
	});
	//用户鼠标进入清空
	$('.userclear').mouseout(function(){
		flagclear=false;
	});
	
	
	//邮箱失焦
	$('.email').blur(function(){
		if($('.email').val()==""){
			$('.email-tips').hide();return;
		}
		var  re=/^[0-9A-z_]+@[0-9A-z_]+\.com$/g;
		if(re.test($('.email').val())){
			$('.email-tips').hide();
			pyl_flag_email=true; //成功返回不变false，最后注册验证
			return;
		}else{
			$('.email-tips').show();
		}
		pyl_flag_email=false; 
	});
	
	
	//邮箱获焦
	$('.email').focus(function(){
		$('.email-tips').hide();
	});
	
	
	
	
	var clickSendcode=0;
	//点击发送验证码
	$(".el-button").click(function(){
		if(!pyl_flag_email){return};//当邮箱正确时才能发送验证码
		if(pyl_flag_sendEmailcode){return;}//还在倒计时60S时不能发送验证码
		clickSendcode++;
		pyl_flag_sendEmailcode=true;
		console.log("发送验证码");
		email1=$('.email').val();
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
	});
	
	var Timeout=null;//用来放倒计时验证码失效的 
	//倒计时60秒。验证码失效
	function emailCodeDie(code){
		var timeemail=60; 
		var c=code;
		pyl_flag_emailcodeDie=true;
		var Timer=setInterval(function() {
			timeemail--;
			$(".el-button").html(timeemail+"S秒后重新获取");
			if(timeemail==0){
				$(".el-button").html("免费获取验证码");
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
			}, 60000);
		}
	};
	
	
	//邮箱验证码失焦
	$('.emailcode').blur(function(){
		if($('.emailcode').val()==''){return;};
		var re3=/^\d+$/g;
		if(re3.test($('.emailcode').val())){
			pyl_flag_emailcodeMath=true;//邮箱验证码是否为数字
		}else{
			pyl_flag_emailcodeMath=false;//邮箱验证码是否为数字
		}
	});
	
	//验证码获焦
	$('.emailcode').blur(function(){
		$('.emailcode-tips').hide();
	});
	
	
	//点击找回密码
	$('.find-button').click(function(){
		popupModel();
		var email1=$('.email').val();
		var users=$('.user').val();
		
		//获得用户的验证码
		var EmailCode=$('.emailcode').val();
		var clientEmailCode=Base64.encode(EmailCode);
		
		if(!pyl_flag_emailcodeMath){$('.emailcode-tips').show().html("&otimes; 验证码不正确");return;}//邮箱验证码不为数字
		if(clientEmailCode){
			if(!pyl_flag_emailcodeDie){$('.emailcode-tips').show().html("&otimes; 验证码已失效，请重新发送");return;};
		}
		
		//获得服务器返回的验证码
		var serverEmailCode=$('.emailcode').attr("serverEmailCode");
		if(clientEmailCode==serverEmailCode&&clientEmailCode){
			pyl_flag_emailcode=true;
		}else{
			$('.emailcode-tips').show().html("&otimes; 验证码不正确");
			pyl_flag_emailcode=false;
			return;
		}
		
		$.ajax({
			url:"Check_isaccount",
			type:"post",
			data:{
				"account":users,
				"email":email1,
				"state":"AE"
				},
			success:function(result){
				if(result=="true"){
					$('.user').attr("pyl_flag_user",1);
				}else{
					$('.user').attr("pyl_flag_user",0).focus();
					$('.use-tips').html("&otimes;该帐号与邮箱不匹配").css('color','red').show();
				}
				
				//帐号为对就为真
				if($('.user').attr("pyl_flag_user")==1){
					pyl_flag_user=true;//成功就对，返回不变false
					$('.use-tips').hide();
				}else{
					pyl_flag_user=false;//成功就对，返回不变false
					return;
				}
				
				//所有的逻辑都为真后
				if(pyl_flag_email&&pyl_flag_user&&pyl_flag_emailcode){
						
				}
				
			}
		});
		
		
	});
	
	//模态框弹出方法
	function popupModel(){
		 $('#addAddress').modal('show');
	}
	var newPass=document.querySelector("#newPassWord");
	var truePass=document.querySelector("#truePassWord");
	
	//新密码获焦事件
	$('#newPassWord').focus(function(){
		$('.newPassWord-tips').show().html("密码长度为6-20位").css("color","black");
	});
	//新密码失焦
	$('#newPassWord').blur(function(){
		if($('#newPassWord').val()==""){$('.newPassWord-tips').show().html("设置一个新密码").css("color","black");return;};
		var re1_6_20=/^[\dA-z\W]{6,20}$/g;
		if(re1_6_20.test($('#newPassWord').val())){
			$('.newPassWord-tips').show().html("密码可用").css("color","green");
		}else{
			$('.newPassWord-tips').show().html("密码长度不对").css("color","red");
		};
	});
	
	
	
	//确认密码获焦事件
	$('#truePassWord').focus(function(){
		
	});
	
	//确认密码失焦
	$('#truePassWord').blur(function(){
		if($('#truePassWord').val()==""){
			$('.truePassWord-tips').show().html("再次输入密码").css("color","black");
			return;
		};
		if($('#newPassWord').val()==$('#truePassWord').val()){
			truepassflag=true;
			$('.truePassWord-tips').show().html("完全一样").css("color","green");
		}else{
			$('.truePassWord-tips').show().html("两次密码不用").css("color","red");
		};
	});
	
	
	//去数据库修改密码
	function saveNewPassWord(){
		//拿到上面的数据去修改帐号数据库
		if(!truepassflag){return;};
		$.ajax({
			url:"",
			type:"post",
			data:"",
			success:function(result){
				console.log(11);
			}
		})
		
	}

	
</script>
    