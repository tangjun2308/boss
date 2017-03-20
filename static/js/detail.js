/*
	var $ = function(id){
		return document.getElementById(id);
	}
	
	$('plusNum').onclick = function(e){
		e = window.event || e;
		o = e.srcElement || e.target;
		var num = $('allNum').textContent;
		if(num > 0){
			num --;
			$('allNum').innerHTML = num;
		}else{
		 alert("您没有购买任何商品");
		}
	};

	$('addNum').onclick = function(e){
		e = window.event || e;
		o = e.srcElement || e.target;
		var num = $('allNum').textContent;
		num ++;
		$('allNum').innerHTML = num;
	};
	
	var loading = new Loading();
	var layer = new Layer();

	
	$('add').onclick = function(e){
		var ele = e.target;
		var id = ele && ele.dataset.id;
		var title = ele && ele.dataset.title;
		var price = ele && ele.dataset.price;
		var num = $('allNum').innerHTML;
		var productDetail = {'id':id,'price':price,'title':title,'num':num};
		var name = 'products';
		var productList1 = new Array;
		var productList = util.getCookie(name);
		if(productList == "" || productList == null){
			productList1.push(productDetail);
			util.setCookie(name,productList1);
		}else if(util.findOne(productList,id)){
			util.modifyTwo(productList,id,num);
			util.setCookie(name,productList);
		}else{
			productList.push(productDetail);
			util.setCookie(name,productList);
		}
		console.log(document.cookie);
//		util.deleteCookie(name);
		e == window.event || e;
		layer.reset({
			content:'确认加入购物车吗？',
			onconfirm:function(){
				layer.hide();
				loading.show();
				loading.result('添加购物车成功');
			}.bind(this)
		}).show();
		return;
	};
*/
window.onload = function(){
	initNum();
	
    var thisURL = document.URL;    
    var getval =thisURL.split('?')[1];  
    var showval= getval.split("=")[1]; 
	$.ajax({
		url : '/hello/goodsDetail',
		type : 'POST',
		data : {goodsId : showval},
		dataType : 'json',
		success : function(json) {
			if (json.code == 200) {
				var goods = json.goods;
				$("#picImg").attr('src',goods.picUrl);
				$("#name").html(goods.name);
				$("#summary").html(goods.summary);
				$("#price").html(goods.price);
				$("#detail").html(goods.detail);
	            
			} else {
				alert("获取商品详情失败！");
			}
		}
	});
	
	var user = getUser();
	if(user != null && user.type == 1){    //卖家
		$("#editOrCart").html("<a href=\"public.html?id=" + showval + "\" class=\"u-btn u-btn-primary\">编 辑</a>");
		$.ajax({
			url : '/hello/goodsSelledNum.do',
			data : {goodsId : showval},
			success : function(json) {
				if (json.code == 200) {
					var num = json.num;
					$("#num").html("已售数量： " + num);
				} else {
					alert("获取商品已售数量失败！");
				}
			}
		});
	}else if(user != null && user.type == 0){ //买家
		$.ajax({
			url : '/hello/goodsUserBuyNum.do',
			data : {goodsId : showval,  userId:user.id},
			success : function(json) {
				if (json.code == 200) {
					var num = json.num;
					if(num>0){
						var oldPrice = json.price;
						$("#num").html("已购买数量： " + num);
					    $("#editOrCart").html("<span class=\"u-btn u-btn-primary z-dis\">已购买</span>" +
					                          "<span class=\"buyprice\">当时购买价格：¥" + oldPrice + "</span>"
					    );
					}else{      //未购买
						$("#editOrCart").html(
						"<button class=\"u-btn u-btn-primary\"  data-id=\""+ showval + "\" onclick=\"addCart(this);\">加入购物车</button>"
						);
					}
				} else {
					alert("获取商品已售数量失败！");
				}
			}
		});
	}
}

function addCart(element){
	var loading = new Loading();
	var layer = new Layer();
	layer.reset({
		content:'确认加入购物车吗？',
		onconfirm:function(){
			layer.hide();
			loading.show();
			
			var goodsId = $(element).attr("data-id");
			var num = $("#allNum").html();
			var userId = getUser().id;
			
			$.ajax({
				url : '/hello/addToMyCart.do',
				data : {goodsId : goodsId, num : num, userId : userId},
				success : function(json) {
					if (json.code == 200) {
						loading.result('添加购物车成功');
					} else {
						//alert("加入到购物车失败！");
						loading.result('添加购物车失败');
					}
				}
			});
			//loading.result('添加购物车成功');
		}.bind(this)
	}).show();

}

function initNum(){
	$("#plusNum").click(function(){
		var num = $("#allNum").html();
		if(num > 0){
			num --;
			$("#allNum").html(num);
		}else{
		 alert("您没有购买任何商品");
		}
	});

	$("#addNum").click(function(){
		var num = $("#allNum").html();
		num ++;
		$("#allNum").html(num);
	});
}
