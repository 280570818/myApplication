/**
 * 主页js
 */
$(function(){
    // nav收缩展开
    $('.nav-item>a').on('click',function(){
        if (!$('body>.nav').hasClass('nav-mini')) {
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
        if (!$('body>.nav').hasClass('nav-mini')) {
            $('.nav-item.nav-show').removeClass('nav-show');
            $('.nav-item').children('ul').removeAttr('style');
            $('body>.nav').addClass('nav-mini');
            changeContentWidth(60);
        }else{
            $('body>.nav').removeClass('nav-mini');
            setTimeout(function(){changeContentWidth(200);}, 280);
        }
    });
    //内容区宽度调整
    var w = document.documentElement.clientWidth || document.body.clientWidth;
    var h = document.documentElement.clientHeight || document.body.clientHeight;
    wid = w-200;
    $(".contentDiv").css({width: wid});
    $(".bodyDiv").css({height: h-60});
    $(".tabbable").css("height",(parseInt($(".tabbable").css("height"))-42));
    
});
function changeContentWidth(flag){
	var w = document.documentElement.clientWidth || document.body.clientWidth;
	$(".contentDiv").css({width: w-flag});
}
function openTab(url,name,id){
	$("li[id^='tab_']").removeClass("active");
	$("div[id^='panel-']").removeClass("active");
	
	if(!$("#tab_"+id)[0]){
		var tab = "<li id='tab_"+id+"' onmouseover=\"showCloseImg('closeImg-"+id+"');\" onmouseout=\"hideCloseImg('closeImg-"+id+"');\"><a href='#panel-"+id+"' data-toggle='tab'>"+
				name+"</a><span class='tabCloseIcon' onclick='closeTab(this);' data="+id+" id='closeImg-"+id+"'></span></li>";
		var content = "<div class='tab-pane' id='panel-"+id+"'></div>";
		
		$("#tabParent").append(tab);
		$("#contentParent").append(content);
		
		$.ajax({
			url: url,
			async:false,
			type:"post",
			success:function (data){
				console.log(data);
				$("#panel-"+id).append(data);
			}
		});
	}
	$("#tab_"+id).addClass("active");
	$("#panel-"+id).addClass("active");
}
function closeTab(obj){
	obj = $(obj).attr("data");
	if($("#tab_"+obj).hasClass('active')){
		$("#tab_"+obj).prev().addClass('active');
		$("#panel-"+obj).prev().addClass('active');
    }
	$("#tab_"+obj).remove();
	$("#panel-"+obj).remove();
}
function hideCloseImg(id){
	$("#"+id).hide();
}
function showCloseImg(id){
	$("#"+id).show();
}