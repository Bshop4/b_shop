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
	
	function selectContext(n){
		console.log(n);
		if(n==0){
			$('.use_play').show();
			$.ajax({
				type:"post",
				url:"",
				success:function(resulte){
					var obj=JSON.parse(resulte);
					if(obj.code==0){
						for(var j=0;j<obj.length;j++){
							var str=`
									<tr>
									<td>j+1</td>
									<td>${obj.data[j].xxxxxxxxx}</td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>`;
							$('.play_context table').append(str);
						}
					}
				}
			});
		}
		
		if(n==1){
			$('.use_play').hide();
			$.ajax({
				type:"post",
				url:"",
				success:function(resulte){
					
					
				}
			});
			
			
		}
	}