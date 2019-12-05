
var account = getUrlVal('account');

(function() {
//	var account = "zjl";
	if(account != undefined){
		$.ajax({
			type : "post",
			url : "getInfo.do",
			data : {
				"account" : account
			},
			success : function(re) {
				var obj = JSON.parse(re);

				//头像
				$('#imgPhoto').attr("src", `${obj[3]}`);
				//账号
				$('.user-acc-input').attr("value", `${obj[2]}`)
				//昵称
				$('.user-in-nickName').attr("value", `${obj[1]}`);

				//性别
				var sex = `${obj[5]}`;
				if (sex == "男") {
					$('.man').prop("checked", "checked");
					$('.woman').prop("checked", "");
				}
				if (sex == "女") {
					$('.man').prop("checked", "");
					$('.woman').prop("checked", "checked");
				}

				//生日
				var userdate = `${obj[6]}`;
				$(".userdate").attr("value", userdate);

				//保存按钮保存personInfo_id
				$(".save").attr("data-id", `${obj[0]}`);

				//地址
				var useraddress = `${obj[4]}`;
				$('.myAddress').attr("value", useraddress);
			}
		})


		
	}
	
})()

//更新个人信息
$('.save').click(function() {
	//id
	var pid = $('.save').attr("data-id");
	//头像
	var imgPhoto1 = $('#imgPhoto').attr("src");
	//账号
	var account1 = $(".user-acc-input").val();
	//昵称
	var nickName1 = $(".user-in-nickName").val();
	//性别
	var sex1 = $('input:radio:checked').val() == "male" ? "男" : "女";
	//日期
	var date1 = $(".userdate").val();
	//收货地址
	var myAddress1 = $(".myAddress").val();

	var personInfo = {
		"pid" : pid,
		"imgPhoto1" : imgPhoto1,
		"account1" : account1,
		"nickName1" : nickName1,
		"sex1" : sex1,
		"date1" : date1,
		"myAddress1" : myAddress1
	};

	//	console.log(personInfo)
	$.ajax({
		type : 'post',
		url : 'updatePersonInfo.do',
		data : {
			"msg" : JSON.stringify(personInfo)
		},
		success : function(result) {
			
			$(".savesuccess").animate({opacity: "1"},500,function(){
				setTimeout(function() {
					$('.savesuccess').css("opacity",0);
				}, 1500)
			})
			
			
		},
	});



})



//下拉列表
var pro = document.getElementById("province");
function getPro() {
	for (var i = 0; i < infos.length; i++) {
		pro.innerHTML += "<option value='" + infos[i].code + "'>" + infos[i].name + "</option>";
	}
	;
}
;
var cities = [];
var city = document.getElementById("city");
function getCity(t) {
	//				console.log(t.value);
	var proID = t.value;
	area.innerHTML = "<option>请选择县区</option>";
	city.innerHTML = "<option>请选择城市</option>";
	for (var i = 0; i < infos.length; i++) {
		if (proID == infos[i].code) {
			cities = infos[i].city;
			//遍历city
			for (var j = 0; j < cities.length; j++) {
				city.innerHTML += "<option value='" + cities[j].code + "'>" + cities[j].name + "</option>";
			}
			break;
		}
	}
	;
}
var area = document.getElementById("area");
function getArea(t) {
	var areaID = t.value;
	area.innerHTML = "<option>请选择县区</option>";
	for (var j = 0; j < cities.length; j++) {
		if (areaID == cities[j].code) {
			for (var k = 0; k < cities[j].area.length; k++) {
				area.innerHTML += "<option value='" + cities[j].area[k].code + "'>" + cities[j].area[k].name + "</option>";
			}
			break;
		}
	}
	;
}
//页面加载完成
window.onload = function() {
	getPro();
};



//切换
$("#mycollection").click(function() {
	
	$("#mycollection").css({
		color : "red"
	});

	$("#myinfo").css({
		color : "black"
	})
	
	$("#mymenu").css({
		color : "black"
	})
	$("#myaddress").css({
		color : "black"
	})
	$("#myfooter").css({
		color : "black"
	})
	$(".user-right3").show();
	$(".user-right").hide();
	$(".user-right1").hide();
	$(".user-right2").hide();
	$(".user-right4").hide();
	
	$(".pro-list").html("");
	
	
	$.ajax({
		
		type : "post",
		url : "selectCollectionByAccount.do",
		data : {"account" : account},
		success : function (re) {
			var obj = JSON.parse(re);
//			console.log(obj)
//			if(obj.length > 10){
//				var str="";
//				for(var i = 0; i <obj.length; i++){
//					str += `
//						<li class="pro-product"  >
//							<img class="pro-logo" onclick="clickli(this)" data-url=${obj[i].goods_no} src=${obj[i].goods_photo}>
//							<img src="img/show.png" class="pro-select" id="pro-hide">
//							<div class="pro-name">${obj[i].goods_name}</div>
//							<div class="heart"><img title="取消收藏" onclick="clickmyheart(this)" onmouseleave="leaveMyHeart(this)" onmouseenter="enterMyHeart(this)" data-myid=${obj[i].cid} class="imgheart" src="img/7.png"/></div>
//						</li>
//					`;
//					
//				}
//				$(".pro-list").append(str);
//			}else
				if(obj.length > 0){
				var str="";
				for(var i = 0; i < obj.length; i++){
					str += `
						<li class="pro-product"  >
							<img class="pro-logo" onclick="clickli(this)" data-url=${obj[i].goods_no} src=${obj[i].goods_photo}>
							<img src="img/show.png" class="pro-select" id="pro-hide">
							<div class="pro-name">${obj[i].goods_name}</div>
							<div class="heart"><img title="取消收藏" onclick="clickmyheart(this)" onmouseleave="leaveMyHeart(this)" onmouseenter="enterMyHeart(this)" data-myid=${obj[i].cid} class="imgheart" src="img/7.png"/></div>
						</li>
					`;
				}
				$(".pro-list").append(str);
			}else if(obj.length == 0){
				
				var str = `
					<div class="descr">-_-您现在暂无收藏</div>
				`;
				
				$(".pro-list").append(str);
			}
		}
		
	})
})


$("#myinfo").click(function() {
	$("#myinfo").css({
		color : "red"
	});

	$("#mycollection").css({
		color : "black"
	});
	$("#mymenu").css({
		color : "black"
	})
	$("#myaddress").css({
		color : "black"
	})
	$("#myfooter").css({
		color : "black"
	})
	$(".user-right").show();
	$(".user-right1").hide();
	$(".user-right2").hide();
	$(".user-right3").hide();
	$(".user-right4").hide();
})

$("#mymenu").click(function() {
	$("#mymenu").css({
		color : "red"
	});
	$("#mycollection").css({
		color : "black"
	});
	$("#myinfo").css({
		color : "black"
	})
	$("#myaddress").css({
		color : "black"
	})
	$("#myfooter").css({
		color : "black"
	})
	$(".user-right1").show();
	$(".user-right").hide();
	$(".user-right2").hide();
	$(".user-right3").hide();
	$(".user-right4").hide();
})

$("#myaddress").click(function() {
	$("#myaddress").css({
		color : "red"
	});
	$("#mycollection").css({
		color : "black"
	});
	$("#myinfo").css({
		color : "black"
	})
	$("#mymenu").css({
		color : "black"
	})
	$("#myfooter").css({
		color : "black"
	})
	$(".user-right2").show();
	$(".user-right").hide();
	$(".user-right1").hide();
	$(".user-right3").hide();
	$(".user-right4").hide();
	//从数据库查找地址数据然后显示在页面
//	var account = "zjl";
	$.ajax({
		type : "post",
		url : "selectReceiverByAccount.do",
		data : {
			"account" : account
		},
		success : function(re) {
			var obj = JSON.parse(re)
			console.log(obj)
			var len = $(".user-right2").children().length;
			if (len == 2) {
				if (obj.length == 0) {
					$(".user-right2").append("<div class='nowaddress'>-_-您现在暂无收获地址~<div>");
					$(".nowaddress").css({
						"font-size" : "25px",
						"width" : "1000px",
						"height" : "300px",
						"text-align" : "center",
						"line-height" : "300px"
					})

				}

				if (obj.length > 0) {
					for (var i = 0; i < obj.length; i++) {
						if (obj[i].ischeck == "1") {
							$(".user-right2").append("<ul class='addresslist' data-ul='1'><li><div class='insertName'>" + obj[i].receiver + "&nbsp;&nbsp;&nbsp;&nbsp;" + obj[i].telephone + "</div><div class='insertPostcode'>邮编:" + obj[i].postal + "</div><div class='insertMyaddress'>收货地址:" + obj[i].address + "</div><span class='binggou' onclick='changeBinggou(this)' >√</span><span class='redefult'>设为默认</span><div class='edit' onclick='editclick(this)' id='#editAddress' data-eid='" + obj[i].rid + "'>编辑</div><div class='del' onclick='delclick(this)' data-rid='" + obj[i].rid + "'>删除</div></li></ul>");
						} else {
							$(".user-right2").append("<ul class='addresslist'><li><div class='insertName'>" + obj[i].receiver + "&nbsp;&nbsp;&nbsp;&nbsp;" + obj[i].telephone + "</div><div class='insertPostcode'>邮编:" + obj[i].postal + "</div><div class='insertMyaddress'>收货地址:" + obj[i].address + "</div><span class='binggou' onclick='changeBinggou(this)' >√</span><span class='redefult'>设为默认</span><div class='edit' onclick='editclick(this)' id='#editAddress' data-eid='" + obj[i].rid + "'>编辑</div><div class='del' onclick='delclick(this)' data-rid='" + obj[i].rid + "'>删除</div></li></ul>");
						}
						$(".addresslist").css({
							"width" : "1000px",
							"height" : "120px",
							"margin-left" : "10px",
							"position" : "relative",
							"border" : "2px solid white"
						})

						$(".addresslist>li").css({
							"width" : "750px",
							"height" : "100px",
							"margin-top" : "10px",
							"margin-left" : "10px",
						})

						$(".insertName,.insertMyaddress,.insertPostcode").css({
							"padding" : "0px 0px 10px",
						})

						$(".edit, .del").css({
							"width" : "30px",
							"height" : "20px",
							"font-size" : "15px",
							"position" : "absolute",
							"right" : "50px",
							"top" : "50%",
							"cursor" : "pointer",
							"text-decoration" : "underline"
						})

						$(".edit").css({
							"right" : "90px"
						})

						$(".binggou").css({
							"width" : "15px",
							"height" : "15px",
							"background" : "black",
							"display" : "inline-block",
							"color" : "whitesmoke",
							"cursor" : "pointer",
						})

						$(".redefult").css({
							"font-weight" : "bolder",
						})

					}
				}
				$("[data-ul='1']").css({
					"border" : "2px solid black"
				})
			} else if (len > 2) {
				return;
			}

		}
	})
})



$("#user-myaddress").click(function() {
	document.getElementById("save1").setAttribute("data-dismiss", "");
})

//保存地址
function mysaveclick() {
	var name = document.getElementById("myname").value;
	var iphone = document.getElementById("myiphone").value;
	var postcode = document.getElementById("mypostcode").value;
	var pro = document.getElementById("province").value;
	var city = document.getElementById("city").value;
	var area = document.getElementById("area").value;
	var detailaddress = document.getElementById("mydetailaddress").value;

	if (name == "") {
		$(".namelable").show();
		return;
	} else {
		$(".namelable").hide();
	}

	var reiphone = /^1[0-9]{10}/;
	if (reiphone.test(iphone) != true) {
		$(".iplabel").show();
		return;
	} else {
		$(".iplabel").hide();
	}

	if (postcode == "") {
		$(".postlabel").show();
		return;
	} else {
		$(".postlabel").hide();
	}

	//新加判断  原地址判断删除
	if (pro == "" || city == "" || area == "" || detailaddress == "" || pro == "请选择省份" || city == "请选择城市" || area == "请选择区县") {
		$("#addlabel").show();
		return;
	} else {
		$("#addlabel").hide();
	}


	if (reiphone.test(iphone) == true && name != "" && postcode != "") {
		//定义变量
		var getPro;
		var getCity;
		var getArea;
		var AllAddress;

		for (var i = 0; i < infos.length; i++) {
			if (infos[i].code == $('#province').val()) {
				getPro = infos[i].name; //省份
			}
		}
		;
		for (var j = 0; j < cities.length; j++) {
			if (cities[j].code == $('#city').val()) {
				getCity = cities[j].name; //城市
				for (var k = 0; k < cities[j].area.length; k++) {
					if (cities[j].area[k].code == $('#area').val()) {
						getArea = cities[j].area[k].name; //区县
					}
				}
			}
		}
		AllAddress = getPro + getCity + getArea + detailaddress;
		document.getElementById("save1").setAttribute("data-dismiss", "modal");

		//插入数据库
//		var account = "zjl"

		var reveiver = {
			"name" : name,
			"iphone" : iphone,
			"postcode" : postcode,
			"AllAddress" : AllAddress,
			"account" : account
		}
		$.ajax({
			type : 'post',
			url : 'insertIntoReceiver.do',
			data : {
				"msg" : JSON.stringify(reveiver)
			},
			success : function(result) {
				$(".user-right2").append("<ul class='addresslist'><li><div class='insertName'>" + name + "&nbsp;&nbsp;&nbsp;&nbsp;" + iphone + "</div><div class='insertPostcode'>邮编:" + postcode + "</div><div class='insertMyaddress'>收货地址:" + AllAddress + "</div><span class='binggou' onclick='changeBinggou(this)'>√</span><span class='redefult'>设为默认</span><div class='edit' onclick='editclick(this)' id='#editAddress' data-eid='" + result.rid + "'>编辑</div><div class='del' onclick='delclick(this)' data-rid='" + result + "'>删除</div></li></ul>");
				$(".addresslist").css({
					"width" : "1000px",
					"height" : "120px",
					"margin-left" : "10px",
					"position" : "relative"
				})
				
				

				$(".addresslist>li").css({
					"width" : "750px",
					"height" : "100px",
					"margin-top" : "10px",
					"margin-left" : "10px",
				})

				$(".insertName,.insertMyaddress,.insertPostcode").css({
					"padding" : "0px 0px 10px",
				})

				$(".edit, .del").css({
					"width" : "30px",
					"height" : "20px",
					"font-size" : "15px",
					"position" : "absolute",
					"right" : "50px",
					"top" : "50%",
					"cursor" : "pointer",
					"text-decoration" : "underline"
				})

				$(".edit").css({
					"right" : "90px"
				})

				$(".binggou").css({
					"width" : "15px",
					"height" : "15px",
					"background" : "black",
					"display" : "inline-block",
					"color" : "whitesmoke",
					"cursor" : "pointer",
				})

				$(".redefult").css({
					"font-weight" : "bolder",
				})
				var len = $(".user-right2").children().length;
				if (len > 3) {
					$(".nowaddress").remove();
				}

				document.getElementById("myname").value = "";
				document.getElementById("myiphone").value = "";
				document.getElementById("mypostcode").value = "";
				document.getElementById("mydetailaddress").value = "";

			},
		});


	}


}



//删除地址
function delclick(obj) {
	var rid = $(obj).attr("data-rid");
	if (confirm("您确定要删除该地址吗?")) {
		$.ajax({
			type : "post",
			url : "deleteAddressByRid.do",
			data : {
				"msg" : rid
			},
			success : function(re) {
				//    			console.log(re)
				if (re == "1") {
					$(obj).parent().parent().remove();
					var len = $(".user-right2").children().length;
					if (len == 2) {
						$(".user-right2").append("<div class='nowaddress'>-_-您现在暂无收获地址~<div>");
						$(".nowaddress").css({
							"font-size" : "25px",
							"width" : "1000px",
							"height" : "300px",
							"text-align" : "center",
							"line-height" : "300px"
						})
					}

				}
			}
		})
	}
}


$(".user-acc-input").focus(function () {
	$(".notModify").show();
})
$(".user-acc-input").blur(function () {
	$(".notModify").hide();
})


function changeBinggou(obj) {

	var s1 = $(obj).parent().find("div").eq(0).html()
	var s2 = $(obj).parent().find("div").eq(1).html()
	var s3 = $(obj).parent().find("div").eq(2).html()

	var arr1 = s1.split("&nbsp;&nbsp;&nbsp;&nbsp;")
	var name = arr1[0];
	var iphone = arr1[1];
	var postcode = s2.slice(3);
	var address = s3.slice(5);
	var rid = $(obj).parent().find("div").eq(4).attr("data-rid");

	var mes = {
		"name" : name,
		"iphone" : iphone,
		"postcode" : postcode,
		"address" : address,
		"rid" : rid,
		"account" : account
	};

	$.ajax({
		type : "post",
		url : "updateCheckAndInsert.do",
		data : {
			"msg" : JSON.stringify(mes)
		},
		success : function(re) {
			//    		 	$(".binggou").css({
			//    	    		"color" : "white"
			//    	    	})
			//    	    	$(obj).css({
			//    	    		"color" : "red"
			//    	    	})
			$(".addresslist").css({
				"border" : "2px solid white"
			})
			$(obj).parent().parent().css({
				"border" : "2px solid black"
			})

		}
	})
}





var zjl_shoucangflag=true;
//取消收藏
function clickmyheart(obj) {
	var myid = $(obj).attr("data-myid");
	
	$.ajax({
		type : "post",
		url : "deleteCollectionById.do",
		data : {"account" : account, "myid" : myid},
		success : function(re){
			$(".pro-list").html("");
			var obj = JSON.parse(re);
			if(obj.length > 10){
				var str="";
				for(var i = 0; i < 10; i++){
					str += `
						<li class="pro-product"  >
							<img class="pro-logo" onclick="clickli(this)" data-url=${obj[i].goods_no} src=${obj[i].goods_photo}>
							<img src="img/show.png" class="pro-select" id="pro-hide">
							<div class="pro-name">${obj[i].goods_name}</div>
							<div class="heart"><img title="取消收藏" onclick="clickmyheart(this)" onmouseleave="leaveMyHeart(this)" onmouseenter="enterMyHeart(this)" data-myid=${obj[i].cid} class="imgheart" src="img/7.png"/></div>
						</li>
					`;
					
				}
				$(".pro-list").append(str);
			}else if(obj.length > 0 && obj.length <= 10){
				var str="";
				for(var i = 0; i < obj.length; i++){
					str += `
						<li class="pro-product"  onclick="clickli(this)">
							<img class="pro-logo" onclick="clickli(this)" data-url=${obj[i].goods_no} src=${obj[i].goods_photo}>
							<img src="img/show.png" class="pro-select" id="pro-hide">
							<div class="pro-name">${obj[i].goods_name}</div>
							<div class="heart"><img title="取消收藏" onclick="clickmyheart(this)" onmouseleave="leaveMyHeart(this)" onmouseenter="enterMyHeart(this)" data-myid=${obj[i].cid} class="imgheart" src="img/7.png"/></div>
						</li>
					`;
				}
				$(".pro-list").append(str);
			}else if(obj.length == 0){
				
				var str = `
					<div class="descr">-_-您现在暂无收藏</div>
				`;
				
				$(".pro-list").append(str);
			}
		}
	})
}
	
	
function clickli(obj){
	if(zjl_shoucangflag){return;};
	var id = $(obj).attr("data-url");
	
	location.href = "detail.jsp?goods_no=" + id;
	
}


function enterMyHeart(obj) {
	zjl_shoucangflag=true;
	$(obj).attr("src","img/6.png")
}

function leaveMyHeart(obj) {
	zjl_shoucangflag=false;
	$(obj).attr("src","img/7.png")
}


function editclick(obj) {
	console.log(obj.attr("data-eid"))
	
}

//下拉列表
var pro1 = document.getElementById("province1");
function getPro1() {
	for (var i = 0; i < infos.length; i++) {
		pro1.innerHTML += "<option value='" + infos[i].code + "'>" + infos[i].name + "</option>";
	}
	;
}
;
var cities1 = [];
var city1 = document.getElementById("city1");
function getCity1(t) {
	//				console.log(t.value);
	var proID1 = t.value;
	area1.innerHTML = "<option>请选择县区</option>";
	city1.innerHTML = "<option>请选择城市</option>";
	for (var i = 0; i < infos.length; i++) {
		if (proID1 == infos[i].code) {
			cities1 = infos[i].city;
			//遍历city
			for (var j = 0; j < cities1.length; j++) {
				city1.innerHTML += "<option value='" + cities1[j].code + "'>" + cities1[j].name + "</option>";
			}
			break;
		}
	}
	;
}
var area1 = document.getElementById("area1");
function getArea1(t) {
	var areaID1 = t.value;
	area1.innerHTML = "<option>请选择县区</option>";
	for (var j = 0; j < cities1.length; j++) {
		if (areaID1 == cities1[j].code) {
			for (var k = 0; k < cities1[j].area.length; k++) {
				area1.innerHTML += "<option value='" + cities1[j].area[k].code + "'>" + cities1[j].area[k].name + "</option>";
			}
			break;
		}
	}
}



var eid="";
function editclick(obj) {
	getPro1();
	$("#editAddress").modal('show');
//	console.log(eid);
	eid = $(obj).attr('data-eid')
	console.log(eid);
	
	$.ajax({
		
		type : "post",
		url : "editModal.do",
		data : {"eid" : eid},
		success : function (re) {
			var obj = JSON.parse(re);
			
			var address = obj.address;
			var postal = obj.postal;
			var receiver = obj.receiver;
			var tel = obj.telephone;
			
			$("#myname1").attr("value",receiver);
			$("#myiphone1").attr("value",tel);
			$("#mypostcode1").attr("value",postal);
			
			var p;
			var pname;
			for (var i = 0; i < infos.length; i++) {
				if(address.indexOf(infos[i].name) != -1){
					p = infos[i].code;
					pname = infos[i].name;
					$("#province1").find("option[value='"+p+"']").attr("selected",true);
					break;
				}
			}
			
			var c;
			var c1;
			var cname;
			for (var i = 0; i < infos.length; i++) {
				if (p == infos[i].code) {
					c1 = infos[i].city;
					//遍历city
					for (var j = 0; j < c1.length; j++) {
						if(address.indexOf(c1[j].name) != -1){
							c = c1[j].code;
							cname = c1[j].name;
							city1.innerHTML = "<option value='" + c1[j].code + "'>" + c1[j].name + "</option>";
						}
					}
					break;
				}
			}
			
			var aname;
			for (var j = 0; j < c1.length; j++) {
				if (c == c1[j].code) {
					for (var k = 0; k < c1[j].area.length; k++) {
						if(address.indexOf(c1[j].area[k].name) != -1){
							aname = c1[j].area[k].name;
							area1.innerHTML = "<option value='" + c1[j].area[k].code + "'>" + c1[j].area[k].name + "</option>";
						}
					}
					break;
				}
			}
			
			var dname;
			dname = address.replace(pname, "");
			dname = dname.replace(cname, "");
			dname = dname.replace(aname,"");
			
			$("#mydetailaddress1").attr("value",dname);
		}
	})
}

function mysaveclick1() {
	var name = document.getElementById("myname1").value;
	var iphone = document.getElementById("myiphone1").value;
	var postcode = document.getElementById("mypostcode1").value;
	var pro = document.getElementById("province1").value;
	var city = document.getElementById("city1").value;
	var area = document.getElementById("area1").value;
	var detailaddress = document.getElementById("mydetailaddress1").value;
	
//	console.log(name)
//	console.log(iphone)
//	console.log(postcode)
//	console.log(pro)
//	console.log(city)
//	console.log(area)
//	console.log(detailaddress)
	
	var getPro;
	var getCity;
	var getArea;
	var AllAddress;

	var cities1;
	for (var i = 0; i < infos.length; i++) {
		if (infos[i].code == $('#province1').val()) {
			getPro = infos[i].name; //省份
			cities1 = infos[i].city;
		}
	}
	
//	var area1 = document.getElementById("area1");
	for (var j = 0; j < cities1.length; j++) {
		if (cities1[j].code == $('#city1').val()) {
			getCity = cities1[j].name; //城市
			for (var k = 0; k < cities1[j].area.length; k++) {
				if (cities1[j].area[k].code == $('#area1').val()) {
					getArea = cities1[j].area[k].name; //区县
				}
			}
		}
	}
	AllAddress = getPro + getCity + getArea + detailaddress;
	document.getElementById("save2").setAttribute("data-dismiss", "modal");

//	console.log(AllAddress)
//	console.log(eid)
	
	var test = {
		"name" : name,
		"iphone" : iphone,
		"postcode" : postcode,
		"AllAddress" : AllAddress,
		"account" : account,
		"eid" : eid,
	}
	
	$.ajax({
		
		type : "post",
		url : "updateAllAddress.do",
		data : {"msg" : JSON.stringify(test)},
		success : function (re) {
			if(re == "1"){
				var l = $("[data-eid='"+eid+"']").parent().children();
				$(l).eq(0).html(name+"&nbsp;&nbsp;&nbsp;&nbsp;"+iphone)
				$(l).eq(1).html("邮编："+postcode);
				$(l).eq(2).html("收货地址："+AllAddress);
				
			}
		}
		
	})
}

//我的足迹点击
$("#myfooter").click(function() {
	$("#myinfo").css({
		color : "black"
	});

	$("#mycollection").css({
		color : "black"
	});
	$("#mymenu").css({
		color : "black"
	})
	$("#myaddress").css({
		color : "black"
	})
	$("#myfooter").css({
		color : "red"
	})
	$(".user-right").hide();
	$(".user-right1").hide();
	$(".user-right2").hide();
	$(".user-right3").hide();
	$(".user-right4").show();
	
	getFooter();
})



var  footflag=false;
//根据账号查看我的足迹
function getFooter(){
	$.ajax({
		type : "post",
		url : "MyFooter",
		success:function(result){
			if(result==null){
				alert("你没有浏览过任何商品");
				return;
			}
			
			//清空记录
			$('.user-right4').empty();
			
			console.log(result);
			var mylength=result.length-1;
			
			var str=``;
			for(var i=mylength;i>=0;i--){
				if(i==mylength){
					var strday=`
					<p class="djtDate">${result[i].footprint_time}</p>`;
					str+=`
					<ul>
						<li djt-data-goods="${result[i].goods_no}" onclick="djtclick(this)">
							<img src="${result[i].goods_photo}">
							<span class="djtbrand">${result[i].goods_brand}</span>
							<span class="djtprice">￥${result[i].goods_price}</span>
							<p class="djtname">${result[i].goods_name}</p>
							<span djt-mtdate="${result[i].footprint_time}" class="djtdelete glyphicon glyphicon-trash" onclick="mydjtdelete(this)"></span>
						</li>
					`;
					$('.user-right4').append(strday);
					continue;
				}
				if(result[i+1].footprint_time!=result[i].footprint_time){
					//日期不相等就创建日期
					$('.user-right4').append(str);
					var strday=`
					<p class="djtDate">${result[i].footprint_time}</p>`;
					str=`<ul>
						<li djt-data-goods="${result[i].goods_no}" onclick="djtclick(this)">
							<img src="${result[i].goods_photo}">
							<span class="djtbrand">${result[i].goods_brand}</span>
							<span class="djtprice">￥${result[i].goods_price}</span>
							<p class="djtname">${result[i].goods_name}</p>
							<span djt-mtdate="${result[i].footprint_time}" class="djtdelete glyphicon glyphicon-trash" onclick="mydjtdelete(this)"></span>
						</li>
						`;
					$('.user-right4').append(strday);
				}else{
						 str+=`
							<li djt-data-goods="${result[i].goods_no}" onclick="djtclick(this)">
								<img src="${result[i].goods_photo}">
								<span class="djtbrand">${result[i].goods_brand}</span>
								<span class="djtprice">￥${result[i].goods_price}</span>
								<p class="djtname">${result[i].goods_name}</p>
								<span djt-mtdate="${result[i].footprint_time}" class="djtdelete glyphicon glyphicon-trash" onclick="mydjtdelete(this)"></span>
							</li>
						`;
//						$('.user-right4').append(str);
				}
				if(i==0){
					$('.user-right4').append(str);
				}
			}
			//显示删除
			$('.user-right4>ul>li').each(function(i){
				$('.user-right4>ul>li').eq(i).mouseover(function(){
					$('.user-right4>ul>li').eq(i).children('span.djtdelete').show();
				})
				$('.user-right4>ul>li').eq(i).mouseout(function(){
					$('.user-right4>ul>li').eq(i).children('span.djtdelete').hide();
				})
				$('.user-right4>ul>li').eq(i).children('span.djtdelete').mouseover(function(){
					footflag=false;
				});
				$('.user-right4>ul>li').eq(i).children('span.djtdelete').mouseout(function(){
					footflag=true;
				});
			})
		}
		
	})
}

//点击跳转
function djtclick(obj){
	if(!footflag){return;};
	var goods_no=$(obj).attr('djt-data-goods');
	location.href="/bshop/detail.jsp?goods_no="+goods_no;
}

var goods_no;
var footprint_time;
//点击删除
function mydjtdelete(obj){
	goods_no=$(obj).parent().attr('djt-data-goods');
	footprint_time=$(obj).attr("djt-mtdate");
	djtAjaxDelete();
}

//通过ajax删除
function djtAjaxDelete(){
	$.ajax({
		type : "post",
		url : "MyDelete.do",
		data:{
			goods_no:goods_no,
			footprint_time:footprint_time,
		},
		dataType:"json",
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		success:function(result){
			if(result==true){
				alert("删除成功");
				//重新查询
				getFooter();
				return;
			}else{
				alert("删除失败");
			}
		}
	})
}


