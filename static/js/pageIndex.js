(function(w,d,u){
	var plist = util.get('plist');
	if(!plist){
		return;
	}
	var layer = new Layer();
	var loading = new Loading();
	var page = {
		init:function(){
			plist.addEventListener('click',function(e){
				var ele = e.target;
				var delId = ele.dataset && ele.dataset.del;
				if(delId){
					this.ondel(delId);
					return;
				}
			}.bind(this),false);
		},
		ondel:function(id){
			layer.reset({
				content:'确定要删除该内容吗？',
				onconfirm:function(){
					layer.hide();
					loading.show();
					ajax({
						url:'/api/delete',
						data:{id:id},
						success:function(json){
							this.delItemNode(id);
							loading.result('删除成功');
						}.bind(this)
					});
				}.bind(this)
			}).show();
		},
		delItemNode:function(id){
			var item = util.get('p-'+id);
			if(item && item.parentNode){
				item.parentNode.removeChild(item);
			}
		}
	};
	page.init();
})(window,document);


window.onload = function(){
	$.ajax({
		url : '/hello/getAllGoods',
		type : 'POST',
		dataType : 'json',
		success : function(json) {
			if (json.code == 200) {
				var list = json.goodsList;
				var len = list.length;
	            for(var i=0; i<len; i++){
	            	var goods = list[i];
	            	$("#plist").append(
	    	            "<li>"+
	   	                 "<a href=\"../html/detail.html?id=" + goods.id + "\" class=\"link\">" +
	   	                     "<div class=\"img\"><img src=\"" +goods.picUrl + "\"></div>" +
	   	                     "<h3>" + goods.name + "</h3>" +
	   	                     "<div class=\"price\"><span class=\"v-unit\">¥</span><span class=\"v-value\">" + goods.price + "</span></div>" +
	   	                 "</a>" +
	   	                "</li>"
	            			);
	            }
			} else {
				alert("获取商品列表失败！");
			}
		}
	});
}