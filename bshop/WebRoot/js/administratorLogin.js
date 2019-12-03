	function admi_login(){
		
		
		
	}
	
	
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