(function(){
//	$.get('http://www.wjian.top/shop/api_cat.php?',{},function(result){
//	var obj=JSON.parse(result);
//	if(obj.code!=0){return;}
//	for(var i=0;i<5;i++){
//		var str=`<li><a href="" target="_blank">${obj.data[i].cat_name}</a></li>`;
//		$('.pyl_navbar_nav ul').append(str);
//	}
//	});
	

	$('nav .aimg').mouseenter(function(){
		$('nav img').attr('src','img/bg-logo2-black.png');
	});
	
	$('nav .aimg').mouseleave(function(){
		$('nav img').attr('src','img/bg-logo2-white.png');
	});


})();


