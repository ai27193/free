$(document).ready(function(){
    // 搜索框选项
    $(".search_title").click(function () {
        if($(".search_item").css("display")=="none"){
            $(".search_item").css("display","block")
        }else{
            $(".search_item").css("display","none")
        }
    })

    $(".nav1").mouseover(function () {
            $(".nav1 .nav_sub").css("display","block")
    })
    $(".nav1").mouseout(function () {
        $(".nav1 .nav_sub").css("display","none")
    })
    // $(".nav1 .nav_sub").mouseover(function () {
    //     if($(".nav1 .nav_sub").css("display")=="none"){
    //         $(".nav1 .nav_sub").css("display","block")
    //     }else{
    //         $(".nav1 .nav_sub").css("display","none")
    //     }
    // })
    // 导航条
    $(".nav4").mouseover(function () {
        $(".nav4 .nav_sub").css("display","block")
    })
    $(".nav4").mouseout(function () {
        $(".nav4 .nav_sub").css("display","none")
    })
    $(".nav5").mouseover(function () {
        $(".nav5 .nav_sub").css("display","block")
    })
    $(".nav5").mouseout(function () {
        $(".nav5 .nav_sub").css("display","none")
    })

// 搜索框提示框
    $("#keyword").focus(function () {
        // alert("聚焦");
        $(".search_con").css("display","block")
    })
    $("#keyword").blur(function () {
         // alert("不聚焦");
        $(".search_con").css("display","none")
    })

    // 点击导航条哪个就变颜色
    $(".mainNav ul li a").click(function () {
       // alert("dianji");
        var f = this;
        $(".mainNav ul li a").each(function () {
            this.className = this == f ? 'cur' : ''
        });
    })
    
        //这里是行情提交出现框
    $(".list_mode_m").mouseover(function () {
        $(".list_mode_m").addClass("phov_cur");
    })
    $(".list_mode_m").mouseout(function () {
        $(".list_mode_m").removeClass("phov_cur");
    })
        //这里是行情出现选择人气等选择
    $(".list_mode_l dl").mouseover(function () {
        $(this).find("dd").css("display","block");
    })
    $(".list_mode_l dl").mouseout(function () {
        $(this).find("dd").css("display","none");
    })

})