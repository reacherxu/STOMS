package com.stoms.utils;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class JSONTranslation {
	
	/**
	 * 将对象的内容转化为JSON数据
	 * @param currentObject   被转为JSON数据的对象
	 * @param excludes    屏蔽对象里的一些属性
	 * @return   返回转换后的JSON数据
	 */
	public static String objectToJson(Object currentObject, String[] excludes) {
		
		String jsonResult = "{}";
		JsonConfig jsonConfig = new JsonConfig(); // JSON的配置类
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.setExcludes(excludes);

		JSONObject jsonModel = JSONObject.fromObject(currentObject, jsonConfig);
		jsonResult = jsonModel.toString();
		
		return jsonResult;
	}
	
	/**
	 * 将数组对象的内容转化为JSON数据
	 * @param currentArray 被转为JSON数据的数组对象
	 * @param excludes 屏蔽对象里的一些属性
	 * @return 返回转换后的JSON数据
	 */
	public static String arrayToJson(Object currentArray, String[] excludes) {
		
		String jsonResult = "{}";
		JsonConfig jsonConfig = new JsonConfig(); // JSON的配置类
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.setExcludes(excludes);
		
		JSONArray jsonModel = JSONArray.fromObject(currentArray, jsonConfig);
		jsonResult = jsonModel.toString();
		return jsonResult;
	}

}
