<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>B-SHOP嘿店</title>
	<meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/detail.css" type="text/css">

</head>
<body>

<!--头部-->
<div class="top">
    <div class="top-bar">
        <div class="btn">
            <a class="zjl-register">注册</a>
            <a class="zjl-login">登录</a>
            <a class="glyphicon glyphicon-shopping-cart" id="zjl-cart"></a>
        </div>
        <div class="logBtn">
					<a class="mingZi"></a>
					<a class="exitM">[退出]&nbsp;&nbsp;&nbsp;|</a>
					<a class="glyphicon glyphicon-shopping-cart" id="zjl-login-cart" href="cart.jsp"></a>
					<span class="badge store_number">0</span>
					<ul class="last-span">|&nbsp;&nbsp;&nbsp;我的走秀<p class="glyphicon glyphicon-chevron-down"></p>
						<li>
							<div class="personalInfo">
								<a>个人中心</a>
								<a>我的订单</a>
								<a>我的收藏</a>
							</div>
						</li>
					</ul>
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
                <a href="index.jsp">首页</a>
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


<!--商品详情-->
    <div class="zjl-content">

        <div class="zjl-link">
            <a href="index.jsp">嘿店首页</a>
            <span class="glyphicon glyphicon-chevron-right" style="color: #ccddf2"></span>
            <a href="">生活</a>
            <span class="glyphicon glyphicon-chevron-right" style="color: #ccddf2"></span>
            <!--<span>声波震动牙刷 Aq-110 感应式充电 自带紫外线（Uv杀毒 31000次震动/分钟)</span>-->
        </div>

        <div class="zjl-big">
            <div class="zjl-banner">

                <div class="zjl-top">

                </div>
                <div class="zjl-bottom">

                </div>

                <!--<div class="big"></div>-->
            </div>

            <div class="zjl-product">
                <!--<div class="zjl-product-name">声波震动牙刷 Aq-110 感应式充电 自带紫外线（Uv杀毒 31000次震动/分钟)</div>-->

                <div class="zjl-product-brandName">
                    <span><a href="">品牌：Aquapick</a></span>
                    <!--<span class="zjl-product-no">商品编号：496536517554291</span>-->
                </div>

                <hr style="color: #ccddf2;">

                <div class="zjl-product-price">
                    <div class="price">

                    </div>
                </div>

                <div class="zjl-product-region">
                    <span class="zjl-send">发货地:</span>
                    <span class="zjl-place">上海</span>
                    <span class="zjl-waitTime">预计3-7工作日送达</span>

                </div>

                <div class="zjl-product-tariff">
                    <span>税费：</span>
                    <span>商家承担</span>
                </div>

                <div class="zjl-product-color">
                    <span>颜色：</span>
                    <ul>
                        <li class="active">米白<a href=""></a></li>
                        <li>惨白<a></a></li>
                    </ul>
                </div>

                <div class="zjl-product-size">
                    <span>尺码：</span>
                    <ul>
                        <li>均码<a></a></li>
                    </ul>
                </div>

                <div class="zjl-product-condition">

                </div>

                <div class="zjl-product-service">
                    <span class="glyphicon glyphicon-gift"></span>
                    <label>由提供</label>
                    <span class="glyphicon glyphicon-user zjl-user-server"></span>
                    <label class="zjl-serive">嘿店网提供售后服务</label>
                </div>

                <div class="zjl-product-button">
					<!--动画飞入购物车-->
					<div class="zjl-flyincart">
					</div>
					
				
                </div>
                
                
				
				
                <div class="zjl-product-phone">
                    <span>电话订购: 400-888-4499</span>
                    <span>(9:00~19:00)</span>
                </div>

                <div class="zjl-product-lableList">
                    <label for=""><img src="img/1.png" alt="">正品保障</label>
                    <label for=""><img src="img/2.png" alt="">七天退货</label>
                    <label for=""><img src="img/3.png" alt="">权威质检</label>
                    <label for=""><a href=""><img src="img/4.png" alt="">收藏商品</a></label>
                    <label for=""> <a href=""><img src="img/5.png" alt="">收藏品牌</a></label>
                </div>
            </div>
        </div>
        <div class="upToTop">
            <span class="glyphicon glyphicon-open upToTop"></span>
        </div>
    </div>

    <div class="zjl-footer">
        <div class="zjl-footer-top">
            <ul>
                <li class="active" id="detail">商品详情</li>
                <li class="zjl-footer-desc" id="desc">商品评价</li>
            </ul>
        </div>

        <div class="zjl-footer-detail">
            <div class="zjl-footer-title">
                <p>商品参数</p>
            </div>

            <div class="zjl-footer-goodsList">
                <p>商品类别：牙刷</p>
            </div>

            <div class="zjl-footer-tips">
                <div class="title">
                    消费者购前须知：
                </div>
                    尊敬的顾客，您在走秀网购买的境外发货商品，等同于您在境外购买，请在购买前仔细阅读全部内容，并对自身风险承担作出客观判断。
                    <br>1.	海外商品无中文简体标签，如需了解中文信息，请联系客服。
                    <br>2. 海外商品适用的关于品质、安全、健康、卫生、环保、标识等标准与我国大陆相关标准可能有所不同，在使用过程中由此可能产生的危害、损失或其他风险，走秀网不承担责任。
                    <br>3.	进口税海关收取，抽税告知：
                    <br>“根据跨境电子商务零售进口税收政策，个人单笔交易限值人民币5000元，个人年度交易限值人民币26000元。在限值以内进口的跨境电子商务零售进口商品，关税税率暂设为0%；进口环节增值税、消费税按法定应纳税额的70%征收。
                    <br>计算规则：税费 = 购买单价 × 件数 × 跨境电商综合税率
                    <br>跨境电商综合税率 =（消费税率 + 增值税率）/（1 - 消费税率）× 70%”
                    <br>4.	海外购买商品仅限个人自用，不得再次销售。
                    <br>5.	海外商家不定期更换包装，走秀网尽力准确展示商品最新包装，如有不符，以收到实物为主。
                    <br>6.	所有的商品图片均为专业摄影师拍摄，经后期修制与色彩调整，尽量与实际商品保持一致，但由于灯光、显示器色彩偏差，个人对颜色理解不同等因素，实物与图片出现一定程度色差实属难免，商品颜色请以实际商品为准 ，此类问题不属于商品质量问题。
                    <br>7.	在您收到货时有任何问题请第一时间联系客服解决，对支持七天无理由退货且未拆封、未使用、不影响二次销售的商品，可享受7天无理由退换货。
                    <br>8.	确认收货之日7天（含）内，如有质量问题、实物与图文描述不符或缺发，可申请退货。
            </div>

            <div class="zjl-footer-img">
                <img src="img/details.jpg" alt="">

            </div>

            <div class="zjl-footer-info">
                <p>发票说明:</p>
                <p>1. 若您购买的是【国内发货】商品，商家有义务按照买家实际支付现金，开具正规发票，相关税收应按国家相关规定由商家自行承担。</p>
                <p>2. 若您购买的是【海外直邮】、【海外发货】或【国内保税仓发货】商品，商家均为海外商家，暂时无法按照国内法律规定提供购物发票。</p>
            </div>

            <div class="zjl-footer-priceInfo">
                <p>价格说明:</p>
                <p>走秀价：指商家在走秀网开放平台销售商品时的售价。</p>
                <p>限时抢购价、特卖价：指商家在促销活动中的售价。</p>
                <p>划线价：商品的参考价,并非原价,该价格可能是品牌专柜价、商品吊牌价或由品牌供应商提供的零售价或商品在走秀网平台曾经展示的走秀价。</p>
            </div>
        </div>
        <div class="zjl-footer-decs"></div>
    </div>
	<!--返回顶部-->
	<div class="toTop">
		<span class="glyphicon glyphicon-open"></span>
	</div>



<!--底部-->
    <div id="row-1">

        <div class="row-1">
            <div class="ariplane">
                <img src="img/airplane.png"/>
                海外直销
            </div>
            <div class="handshake">
                <img src="img/handshake.png"/>
                品质保证
            </div>
            <div class="zheng">
                <img src="img/zheng.png"/>
                售后保障
            </div>
        </div>

    </div>

    <div id="row-2">
        <div class="row-2">
            <div class="logo-wrap">
                <img src="img/zouxiu.png" class="logo-wrap-img1"/>
                <a><img src="img/weixin.png" class="logo-wrap-img2"/></a>
                <a><img src="img/weibo.png" class="logo-wrap-img3"/></a>
            </div>
            <ul class="help-link-list">
                <li class="link"><a>ceo邮箱</a></li>
                <li class="link"><a>售后服务</a></li>
                <li class="link"><a>常见问题</a></li>
                <li class="link"><a>关税问题</a></li>
                <li class="link"><a>物流配送</a></li>
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
                    <p><a>400-888-4499(9:00~19:00)</a></p>
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
                <div class="row-4-service"><a><img src="img/licence2.png"></a></div>
                <div class="row-4-service"><a><img src="img/licence1.png"></a></div>
                <a class="row-4-service-2"><img src="img/police2.png"></a>
                <a class="row-4-service-2"><img src="img/police1.png"></a>
                <a class="row-4-service-2"><img src="img/rights.png"></a>
            </div>
        </div>
    </div>


</body>
</html>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/bigGlass.js"></script>
<script src="js/base.js"></script>
<script src="js/detail.js"></script>