package sample.mybatis.common;

import java.util.HashMap;
import java.util.Map;

public class Response {
	
	private  Map<String, Object> response = new HashMap<String, Object>();

	public void addResponse(String key, Object obj) {
		response.put(key, obj);
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> data) {
		response = data;
	}

	public void setStatusCode(String code){
		addResponse("status", code);
	}
	
	public void setMessage(String message){
		addResponse("msg", message);
	}	
	
	public void setRespData(Object data){
		addResponse("data", data);
	}	
	
}
