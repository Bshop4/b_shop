(function() {
	var account = "zjl";
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
		success : function(result) {},
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
	$(".user-right3").show();
	$(".user-right").hide();
	$(".user-right1").hide();
	$(".user-right2").hide();
	
	$(".pro-list").html("");
	
	var account = "pyla1";
	
	$.ajax({
		
		type : "post",
		url : "selectCollectionByAccount.do",
		data : {"account" : account},
		success : function (re) {
			var obj = JSON.parse(re);
			console.log(obj)
			if(obj.length > 10){
				var str="";
				for(var i = 0; i < 10; i++){
					str += `
						<li class="pro-product">
							<img class="pro-logo" src=${obj[i].goods_photo}>
							<img src="img/show.png" class="pro-select" id="pro-hide">
							<div class="pro-name">${obj[i].goods_name}</div>
							<div class="heart"><img onclick="clickmyheart(obj)" data-myid=${obj[i].cid} class="imgheart" src="img/6.png"/></div>
						</li>
					`;
					
				}
				$(".pro-list").append(str);
			}else if(obj.length > 0 && obj.length <= 10){
				console.log(obj.length)
				var str="";
				for(var i = 0; i < obj.length; i++){
					str += `
						<li class="pro-product">
							<img class="pro-logo" src=${obj[i].goods_photo}>
							<img src="img/show.png" class="pro-select" id="pro-hide">
							<div class="pro-name">${obj[i].goods_name}</div>
							<div class="heart"><img onclick="clickmyheart(obj)" data-myid=${obj[i].cid} class="imgheart" src="img/6.png"/></div>
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
	$(".user-right").show();
	$(".user-right1").hide();
	$(".user-right2").hide();
	$(".user-right3").hide();

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
	$(".user-right1").show();
	$(".user-right").hide();
	$(".user-right2").hide();
	$(".user-right3").hide();
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
	$(".user-right2").show();
	$(".user-right").hide();
	$(".user-right1").hide();
	$(".user-right3").hide();
	//从数据库查找地址数据然后显示在页面
	var account = "zjl";
	$.ajax({
		type : "post",
		url : "selectReceiverByAccount.do",
		data : {
			"account" : account
		},
		success : function(re) {
			var obj = JSON.parse(re)
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
							$(".user-right2").append("<ul class='addresslist' data-ul='1'><li><div class='insertName'>" + obj[i].receiver + "&nbsp;&nbsp;&nbsp;&nbsp;" + obj[i].telephone + "</div><div class='insertPostcode'>邮编:" + obj[i].receiver + "</div><div class='insertMyaddress'>收货地址:" + obj[i].address + "</div><span class='binggou' onclick='changeBinggou(this)' >√</span><span class='redefult'>设为默认</span><div class='edit'>编辑</div><div class='del' onclick='delclick(this)' data-rid='" + obj[i].rid + "'>删除</div></li></ul>");
						} else {
							$(".user-right2").append("<ul class='addresslist'><li><div class='insertName'>" + obj[i].receiver + "&nbsp;&nbsp;&nbsp;&nbsp;" + obj[i].telephone + "</div><div class='insertPostcode'>邮编:" + obj[i].receiver + "</div><div class='insertMyaddress'>收货地址:" + obj[i].address + "</div><span class='binggou' onclick='changeBinggou(this)' >√</span><span class='redefult'>设为默认</span><div class='edit'>编辑</div><div class='del' onclick='delclick(this)' data-rid='" + obj[i].rid + "'>删除</div></li></ul>");
						}
						$(".addresslist").css({
							"width" : "1000px",
							"height" : "120px",
							"margin-left" : "10px",
							"position" : "relative",
							"border" : "1px solid white"
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
					"border" : "1px solid black"
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
		var account = "zjl"

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
				$(".user-right2").append("<ul class='addresslist'><li><div class='insertName'>" + name + "&nbsp;&nbsp;&nbsp;&nbsp;" + iphone + "</div><div class='insertPostcode'>邮编:" + postcode + "</div><div class='insertMyaddress'>收货地址:" + AllAddress + "</div><span class='binggou' onclick='changeBinggou(this)'>√</span><span class='redefult'>设为默认</span><div class='edit'>编辑</div><div class='del' onclick='delclick(this)' data-rid='" + result + "'>删除</div></li></ul>");
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


function changeBinggou(obj) {
	var account = "zjl";

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
				"border" : "1px solid white"
			})
			$(obj).parent().parent().css({
				"border" : "1px solid black"
			})

		}
	})
}