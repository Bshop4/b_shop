
	var Timer=null;
	$('.admi_btn').mouseenter(function(){
		Timer=setInterval(function(){
			var r=randomNum(1,340);
			var r1=randomNum(1,18);
			$('.admi_btn .admi_anim').animate({"top":r1,"left":r},600,function(){});
		},610);
	});
	
	$('.admi_btn').mouseleave(function(){
		clearInterval(Timer);
	});
	
	function randomNum(minNum,maxNum){ 
   	 switch(arguments.length){ 
        case 1: 
            return parseInt(Math.random()*minNum+1,10); 
        break; 
        case 2: 
            return parseInt(Math.random()*(maxNum-minNum+1)+minNum,10); 
        break; 
            default: 
                return 0; 
            break; 
  	  } 
	}
	
	//失焦判断帐号是否存在
	$('.users').blur(function(){
		var user=$('.users').val();
		$.ajax({
			type:"post",
			url:"AdminLogin",
			data:{account:user},
			success:function(result){
				if(result){
					var myneed=JSON.parse(result);
					console.log(myneed);
					if(myneed.code==0){
						$('.admi_form>div>.mymsg').html(myneed.msg);
					}
				}
				else{
					$('.admi_form>div>.mymsg').html("");
				}
			}
		})
	})
	
	
	//登录
	function admi_login(){
		
		var user=$('.users').val();
		var pass=$('.pass').val();
		$.ajax({
			type:"post",
			url:"AdminDoLogin",
			data:{
				account:user,
				password:pass,
			},
			success:function(result){
				var needs=JSON.parse(result);
				console.log(needs);
				if(needs.code==0){
					location.href="/bshop/badAdminAccess/administrator_pyl.jsp";
				}else{
					alert(needs.msg);
				}
			}
		})
	}