/**
 * 
 */
$(function(){
    // nav收缩展开
    $('.nav-item>a').on('click',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            if ($(this).next().css('display') == "none") {
                //展开未展开
                $('.nav-item').children('ul').slideUp(300);
                $(this).next('ul').slideDown(300);
                $(this).parent('li').addClass('nav-show').siblings('li').removeClass('nav-show');
            }else{
                //收缩已展开
                $(this).next('ul').slideUp(300);
                $('.nav-item.nav-show').removeClass('nav-show');
            }
        }
    });
    //nav-mini切换
    $('#mini').on('click',function(){
        if (!$('.nav').hasClass('nav-mini')) {
            $('.nav-item.nav-show').removeClass('nav-show');
            $('.nav-item').children('ul').removeAttr('style');
            $('.nav').addClass('nav-mini');
            changeContentWidth(60);
        }else{
            $('.nav').removeClass('nav-mini');
            setTimeout(function(){changeContentWidth(200);}, 280);
        }
    });
    //内容区宽度调整
    var w = document.documentElement.clientWidth || document.body.clientWidth;
    var h = document.documentElement.clientHeight || document.body.clientHeight;
    wid = w-200;
    $(".contentDiv").css({width: wid});
    
});
function changeContentWidth(flag){
	var w = document.documentElement.clientWidth || document.body.clientWidth;
	$(".contentDiv").css({width: w-flag});
}

