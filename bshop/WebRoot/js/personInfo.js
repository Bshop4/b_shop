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
        var address = document.getElementById("myproaddress").value;

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
        if(address == ""){
            $(".addresslabel").show();
            return;
        }else{
            $(".addresslabel").hide();
        }

        if(reiphone.test(iphone) == true && name != "" && postcode != "" && address != ""){
            document.getElementById("save1").setAttribute("data-dismiss","modal");
                $(".user-right2").append("<ul class='addresslist'><li><div class='insertName'>"+name+"&nbsp;&nbsp;&nbsp;&nbsp;"+iphone+"</div><div class='insertPostcode'>邮编:"+postcode+"</div><div class='insertMyaddress'>收货地址:"+address+"</div><span class='binggou'>√</span><span class='redefult'>设为默认</span><div class='edit'>编辑</div><div class='del' onclick='delclick(this)'>删除</div></li></ul>");
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
        document.getElementById("myproaddress").value = "";

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

    
    function show(obj){
        var fr =new  FileReader();
        var f = obj.files[0];
        fr.readAsDataURL(f);
        fr.onload=function(e){
            var content = e.target.result;
            //console.log(content)
            //预览
            document.getElementById("imgPhoto").src=content;
        }
    }

