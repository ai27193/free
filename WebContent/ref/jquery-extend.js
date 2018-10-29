/**
 * 
 */
//扩展jQuery成员方法
$.fn.extend({
	eSerializeObject: function(){
		var obj = {};
		var f = $(this).serializeArray();

		$.each(f,function(index){			
			if(!obj[this['name']]){				
				obj[this['name']] = this['value'];
			}else{
				obj[this['name']] = this['name'] + "," + this['value'];
			}
		});
		return obj;
	}
});
	

//下面的写法也有同样效果
/*$.fn.eSerializeObject = function(){
	var obj = {};
	var f = this.serializeArray();
	$.each(f,function(index){
		if(!obj[this['name']]){
			obj[this['name']] = this['value'];
		}else{
			obj[this['name']] = this['name'] + "," + this['value'];
		}
	});
	return obj;
}*/
			
	


