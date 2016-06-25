package tools;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JsonHelper {

	/*
	 * 对象转json
	 */
	public static Map obj2json(Object javaBean) {
		Map result = new HashMap();
		Method[] methods = javaBean.getClass().getDeclaredMethods();
		for (Method method : methods){
			try{
				if(method.getName().startsWith("get")){
					String field = method.getName();
					field = field.substring(field.indexOf("get") + 3);
					field = field.toLowerCase().charAt(0) + field.substring(1);
					Object value = method.invoke(javaBean, (Object[]) null);
					result.put(field, null == value ? "" : value.toString());
				}
			}catch (Exception e){
				e.printStackTrace();
			}

		}
		return result;
	}
}
