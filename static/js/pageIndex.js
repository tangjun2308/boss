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
	var status = "";
	var ids = "";
	var user = getUser();
	if(user != null && user.type == 0){
		status = "<span class=\"had\"><b>已购买</b></span>";
		$.ajax({
			url : '/hello/userGoodsIds.do',
			async: false,
			success : function(json) {
				if (json.code == 200) {
					ids = json.goodsIds;
				} else {
					delCookie("user");
					location.href = '../html/index.html';
				}
			}
		});
	}
	if(user != null && user.type == 1){
		status = "<span class=\"had\"><b>已售出</b></span>";
		$.ajax({
			url : '/hello/selledGoodsIds.do',
			async: false,
			success : function(json) {
				if (json.code == 200) {
					ids = json.goodsIds;
				} else {
					delCookie("user");
					location.href = '../html/index.html';
				}
			}
		});
	}
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
	            	var status2 = "";
	            	var delStr = "";
	            	if(ids.indexOf(goods.id) != -1)
	            		status2 = status;
	            	else
	            		delStr ="<span class=\"u-btn u-btn-normal u-btn-xs del\" onclick=\"deleteGoods(" + goods.id + ");\">删除</span>";
	            	$("#plist").append(
	    	            "<li id=\"g-" + goods.id + "\">"+
	   	                 "<a href=\"../html/detail.html?id=" + goods.id + "\" class=\"link\">" +
	   	                     "<div class=\"img\"><img src=\"" +goods.picUrl + "\"></div>" +
	   	                     "<h3>" + goods.name + "</h3>" +
	   	                     "<div class=\"price\"><span class=\"v-unit\">¥</span><span class=\"v-value\">" + goods.price + "</span></div>" +
	   	                     status2 + 
	   	                 "</a>" + delStr +
	   	                "</li>"
	            			);
	            }
			} else {
				alert("获取商品列表失败！");
			}
		}
	});
}

function deleteGoods(goodsId){
	var layer = new Layer();
	var loading = new Loading();
	layer.reset({
		content:'确定要删除该内容吗？',
		onconfirm:function(){
			layer.hide();
			loading.show();
			$.ajax({
				url:'/hello/deleteGoods.do',
				data:{goodsId:goodsId},
				success:function(json){
					if(json.code == 200){
						$("#g-" + goodsId).remove();
						loading.result('删除成功');						
					}else{
						loading.result('删除失败');			
					}
				}
			});
		}
	}).show();

}

function removeElement(_element){
	 var _parentElement = _element.parentNode;
	 if(_parentElement){
	  _parentElement.removeChild(_element);
	 }
}