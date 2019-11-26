/**
 * Created by 10415 on 2019/10/25.
 */


(function(){

    $('.zjl-top').mouseenter(function(e){
        $('.zjl-top').mousemove(function(e){

            var x = e.clientX - $('.zjl-top').offset().left - $('.slide').outerWidth()/2;
            var y = e.clientY - $('.zjl-top').offset().top - $('.slide').outerHeight()/2 + $(document).scrollTop();
            //console.log(y)
            //console.log(x);

            //验证范围
            if(x <= 0){
                x = 0
            }
            if(y <= 0){
                y = 0;
            }
            if(x >= $('.zjl-top').width() - $('.slide').outerWidth()){
                x = $('.zjl-top').width() - $('.slide').outerWidth()
            }
            if(y >= $('.zjl-top').height() - $('.slide').outerHeight()){
                y= $('.zjl-top').height() - $('.slide').outerHeight()
            }


            //设置滑块
            $('.slide').css({
                left : x,
                top : y,
            });

            //设置放大背景
            var bili = (800 - $('.big').width()) / ($('.zjl-top').width() - $('.slide').outerWidth());
            //console.log(bili);
            var str = -x * bili + 'px ' + -y * bili + 'px';
            //console.log(str)
            $('.big').css('backgroundPosition',str);

        });

    });

   // $('.zjl-bottom ul li').each(function(i){
    //    $(this).mouseenter(function(){

     //       var imgSrc = $(this).children().attr('src');
            //console.log(imgSrc)
     //       $('.zjl-top>li>img').attr('src',imgSrc);
    //        $('.big').css({
    //            'background-image' : 'url(' + imgSrc + ')',
    //        });

   //     }) ;
  //  });

    //鼠标移入移出
    $('.zjl-top').hover(function(){

        $('.slide,.big').show();

    },function(){
        $('.slide,.big').hide();
    })



})();