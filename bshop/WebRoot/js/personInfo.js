//下拉列表
    var pro = document.getElementById("province");
    function getPro(){
        for(var i=0;i<infos.length;i++){
            pro.innerHTML+="<option value='"+infos[i].code+"'>"+infos[i].name+"</option>";
        };
    };
    var cities = [];
    var city = document.getElementById("city");
    function getCity(t){
//				console.log(t.value);
        var proID = t.value;
        area.innerHTML="<option>请选择县区</option>";
        city.innerHTML="<option>请选择城市</option>";
        for(var i=0;i<infos.length;i++){
            if(proID==infos[i].code){
                cities = infos[i].city;
                //遍历city
                for(var j=0;j<cities.length;j++){
                    city.innerHTML+="<option value='"+cities[j].code+"'>"+cities[j].name+"</option>";
                }
                break;
            }
        };
    }
    var area = document.getElementById("area");
    function getArea(t){
        var areaID = t.value;
        area.innerHTML="<option>请选择县区</option>";
        for(var j=0;j<cities.length;j++){
            if (areaID==cities[j].code){
                for (var k=0;k<cities[j].area.length;k++){
                    area.innerHTML+="<option value='"+cities[j].area[k].code+"'>"+cities[j].area[k].name+"</option>";
                }
                break;
            }
        };
    }
    //页面加载完成
    window.onload=function(){
        getPro();
    };




    $("#myinfo").click(function(){
        $("#myinfo").css({
            color:"red"
        });

        $("#mymenu").css({
            color:"black"
        })
        $("#myaddress").css({
            color:"black"
        })
        $(".user-right").show();
        $(".user-right1").hide();
        $(".user-right2").hide();

    })

    $("#mymenu").click(function(){
        $("#mymenu").css({
            color:"red"
        });
        $("#myinfo").css({
            color:"black"
        })
        $("#myaddress").css({
            color:"black"
        })
        $(".user-right1").show();
        $(".user-right").hide();
        $(".user-right2").hide();
    })

    $("#myaddress").click(function(){
        $("#myaddress").css({
            color:"red"
        });
        $("#myinfo").css({
            color:"black"
        })
        $("#mymenu").css({
            color:"black"
        })
        $(".user-right2").show();
        $(".user-right").hide();
        $(".user-right1").hide();
    })



    $("#user-myaddress").click(function(){
        document.getElementById("save1").setAttribute("data-dismiss","");
    })

    function mysaveclick(){
        var name = document.getElementById("myname").value;
        var iphone = document.getElementById("myiphone").value;
        var postcode = document.getElementById("mypostcode").value;
        var pro = document.getElementById("province").value;
        var city = document.getElementById("city").value;
        var area = document.getElementById("area").value;
        var detailaddress = document.getElementById("mydetailaddress").value;

        if(name == ""){
            $(".namelable").show();
            return ;
        }else{
            $(".namelable").hide();
        }

        var reiphone = /^1[0-9]{10}/;
        if(reiphone.test(iphone) != true){
            $(".iplabel").show();
            return;
        }else{
            $(".iplabel").hide();
        }

        if(postcode == ""){
            $(".postlabel").show();
            return ;
        }else{
            $(".postlabel").hide();
        }

        //新加判断  原地址判断删除
        if(pro == "" || city == "" || area == "" || detailaddress == "" || pro == "请选择省份" || city == "请选择城市" || area == "请选择区县"){
            $("#addlabel").show();
            return;
        }else{
            $("#addlabel").hide();
        }


        if(reiphone.test(iphone) == true && name != "" && postcode != ""){
        //定义变量
        var getPro;
        var getCity;
        var getArea;
        var AllAddress;

        for(var i=0;i<infos.length;i++){
            if(infos[i].code == $('#province').val()){
                getPro = infos[i].name;//省份
            }
        };
        for(var j=0;j<cities.length;j++){
            if(cities[j].code == $('#city').val()){
                getCity = cities[j].name;//城市
                for (var k=0;k<cities[j].area.length;k++){
                    if(cities[j].area[k].code == $('#area').val()){
                        getArea = cities[j].area[k].name;//区县
                    }
                }
            }
        }
        AllAddress = getPro + getCity + getArea +  detailaddress;


            document.getElementById("save1").setAttribute("data-dismiss","modal");
                $(".user-right2").append("<ul class='addresslist'><li><div class='insertName'>"+name+"&nbsp;&nbsp;&nbsp;&nbsp;"+iphone+"</div><div class='insertPostcode'>邮编:"+postcode+"</div><div class='insertMyaddress'>收货地址:"+AllAddress+"</div><span class='binggou'>√</span><span class='redefult'>设为默认</span><div class='edit'>编辑</div><div class='del' onclick='delclick(this)'>删除</div></li></ul>");
                $(".addresslist").css({
                    "width": "1000px",
                    "height": "120px",
                    "margin-left": "10px",
                    "position": "relative"
                })

                $(".addresslist>li").css({
                    "width": "750px",
                    "height": "100px",
                    "margin-top": "10px",
                    "margin-left": "10px",
                })

                $(".insertName,.insertMyaddress,.insertPostcode").css({
                    "padding": "0px 0px 10px",
                })

                $(".edit, .del").css({
                    "width": "30px",
                    "height": "20px",
                    "font-size": "15px",
                    "position": "absolute",
                    "right": "50px",
                    "top":"50%",
                    "cursor": "pointer",
                    "text-decoration": "underline"
                })

                $(".edit").css({
                    "right":"90px"
                })

                $(".binggou").css({
                    "width": "15px",
                    "height":"15px",
                    "background": "black",
                    "display": "inline-block",
                    "color": "whitesmoke",
                    "cursor": "pointer",
                })

                $(".redefult").css({
                    "font-weight": "bolder",
                })

        }
        var len = $(".user-right2").children().length;
        if(len > 3){
            $(".nowaddress").remove();
        }

        document.getElementById("myname").value = "";
        document.getElementById("myiphone").value = "";
        document.getElementById("mypostcode").value = "";
        document.getElementById("mydetailaddress").value = "";

    }


    function  delclick(obj){

        $(obj).parent().parent().remove();
        var len = $(".user-right2").children().length;
        if(len == 2){
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
    
    (function () {
        var len = $(".user-right2").children().length;
        if(len == 2){
            $(".user-right2").append("<div class='nowaddress'>-_-您现在暂无收获地址~<div>");
            $(".nowaddress").css({
                "font-size" : "25px",
                "width" : "1000px",
                "height" : "300px",
                "text-align" : "center",
                "line-height" : "300px"
            })
        }
    })()
    

