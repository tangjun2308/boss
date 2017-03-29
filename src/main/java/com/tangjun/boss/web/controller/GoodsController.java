package com.tangjun.boss.web.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tangjun.boss.meta.Goods;
import com.tangjun.boss.meta.Order;
import com.tangjun.boss.meta.User;
import com.tangjun.boss.service.impl.GoodsServiceImpl;
import com.tangjun.boss.service.impl.OrderServiceImpl;

@Controller
public class GoodsController {
	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@RequestMapping(value = "/public.do")
	@ResponseBody
	public Map<String, Object> publicGoods(HttpServletRequest request, Goods goods){
		Map<String, Object> map=new HashMap<String, Object>();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getType()==0){
			map.put("code", -1);
			return map;
		}
		
		
		boolean success = false;
		goods.setStatus(1);
		if(goods.getId() != 0){
			success = goodsServiceImpl.updateGoods(goods);
		}else{
			success = goodsServiceImpl.insertGoods(goods);
		}

		if(success){
			map.put("code", 200);
			map.put("goodsId", goods.getId());
		}else{
			map.put("code", 0);
		}
		
		return map;
	}
	
	@RequestMapping(value = "/deleteGoods.do")
	@ResponseBody
	public Map<String, Object> deleteGoods(HttpServletRequest request, @RequestParam("goodsId") Integer goodsId){
		Map<String, Object> map=new HashMap<String, Object>();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getType()==0){
			map.put("code", -1);
			return map;
		}

		boolean success = goodsServiceImpl.deleteGoods(goodsId);
		if(success){
			map.put("code", 200);
		}else{
			map.put("code", 0);
		}
		
		return map;
	}
	
	@RequestMapping(value = "/goodsSelledNum.do")
	@ResponseBody
	public Map<String, Object> goodsSelledNum(HttpServletRequest request, @RequestParam("goodsId") Integer goodsId){
		Map<String, Object> map=new HashMap<String, Object>();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getType()==0){
			map.put("code", -1);
			return map;
		}

		int num = orderServiceImpl.getGoodsSelledNum(goodsId);

		map.put("code", 200);
		map.put("num", num);
		
		return map;
	}
	
	@RequestMapping(value = "/goodsUserBuyNum.do")
	@ResponseBody
	public Map<String, Object> goodsUserBuyNum(HttpServletRequest request, 
			                                   @RequestParam("goodsId") Integer goodsId,
			                                   @RequestParam("userId") Integer userId){
		Map<String, Object> map=new HashMap<String, Object>();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getType()==1){
			map.put("code", -1);
			return map;
		}

		int num = orderServiceImpl.getGoodsUserBuyNum(goodsId,userId);
		if(num>0){
			Order order = orderServiceImpl.getOrderByUserIdAndGoodsId(goodsId, userId);
			map.put("price", order.getGoodsPrice());
		}
		map.put("code", 200);
		map.put("num", num);
		
		return map;
	}
	
	@RequestMapping(value = "/getAllGoods")
	@ResponseBody
	public Map<String, Object> getAllGoods(){
		Map<String, Object> map=new HashMap<String, Object>();
		List<Goods> list = goodsServiceImpl.getGoodsList();
		map.put("code", 200);
		map.put("goodsList", list);

		return map;
	}
	
	@RequestMapping(value = "/goodsDetail")
	@ResponseBody
	public Map<String, Object> goodsDetail(@RequestParam("goodsId") Integer goodsId){
		Map<String, Object> map=new HashMap<String, Object>();
		Goods goods = goodsServiceImpl.findById(goodsId);
		
		map.put("code", 200);
		map.put("goods", goods);

		return map;
	}
	
	@RequestMapping(value = "/fileUpload.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> fileUpload(HttpServletRequest request,
			                              @RequestParam("file") MultipartFile file){
		Map<String, Object> map=new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null || user.getType()==0){
			map.put("code", -1);
			return map;
		}
		
        if(!file.isEmpty()){
        	try{
	            //ȡ�õ�ǰ�ϴ��ļ����ļ�����  
	            String myFileName = file.getOriginalFilename();  
	            //������Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������  
	            if(myFileName.trim() !=""){  
	                System.out.println(myFileName);  
	                Date d = new Date();
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	                //�������ϴ�����ļ���  
	                String fileName = sdf.format(d) + "-" + file.getOriginalFilename();  
	                //�����ϴ�·��  
	                String path = "D:\\bossPic\\" + fileName;  
	                File localFile = new File(path);  
	                file.transferTo(localFile); 
	                map.put("code", 200);
	                map.put("path", "..\\..\\img\\" + fileName);
	            }
        	}catch (Exception e) {
        		map.put("code", -2);
			}
        }  

		return map;
	}
	
	
}
