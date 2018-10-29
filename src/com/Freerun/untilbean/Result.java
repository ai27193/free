package com.Freerun.untilbean;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Result implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final int SUCCESS = 1;
	public static final int ERROR = 0;
	public static final int WRAN = 2;
	public static final String SUCCESS_MSG = "操作成功";
	public static final String ERROR_MSG = "操作失败";
	
	//对象转为json字符串
	public static String getJsonObject(boolean statu, String url, String msg, Object data){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject obj = null;
		if(data != null){
			obj = (JsonObject)gson.toJsonTree(data);//利用GSON将POJO转为jsonobject
		}
		JsonObject jo = new JsonObject();//创建结果jsonobject
		//在结果jsonobject中加入返回 的属性参数和数据
		jo.addProperty("success", statu);
		if(msg==null){
			if(statu) jo.addProperty("msg", SUCCESS_MSG);
			else jo.addProperty("msg", ERROR_MSG);
		}else{
			jo.addProperty("msg", msg);
		}		
		jo.addProperty("url", url);
		if(data != null){
			jo.add("data", obj);
		}		
		//将结果jsonobject转为json字符串，并返回
		return gson.toJson(jo);
	}
	//对象集合转为json字符串
	public static String getJsonArrayObject(boolean statu, String url, String msg, List<Object> list){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonArray arryObj = (JsonArray)gson.toJsonTree(list); 
		JsonObject jo = new JsonObject();
		jo.addProperty("success", statu);
		if(msg==null){
			if(statu) jo.addProperty("msg", SUCCESS_MSG);
			else jo.addProperty("msg", ERROR_MSG);
		}else{
			jo.addProperty("msg", msg);
		}
		jo.addProperty("url", url);
		jo.add("data", arryObj);		
		return gson.toJson(jo);
	}	
}
