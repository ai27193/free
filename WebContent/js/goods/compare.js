$(function(){ 
   checkcompare();
}); 

function addCompare(goods_id,goods_name){
	 $("#compareBox").css("display","block");
	/*alert(goods_id);*/
    if ($("#compare"+goods_id).attr('checked')){ //选中
        $('#compareList').prepend('<li id="the'+goods_id+'"><a href="javascript:delcompare('+goods_id+')"><img src="images/icon/drop.gif"></a><span>'+goods_name+'</span><input type="hidden" name="goods[]" value="'+goods_id+'"></li>');
    }else{ //否则
    	$("#the"+goods_id).remove();
    	//检测是否存在对比数据，有就不隐藏对比窗口
    	checkcompare();
    }
}

//删除
function delcompare(goods_id){	
	$("#the"+goods_id).remove();
	$("#compare"+goods_id).attr("checked",false);
	//检测是否存在对比数据，有就不隐藏对比窗口
	checkcompare();
}

//返回函数
function checkcompare(){
    if($("#compareList").find("li").length <=0){
    	{
    	   $("#compareBox").css("display","none");
    	}
    }else{
    	$("#compareBox").css("display","block");
    }
}
