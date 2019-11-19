package com.mupei.tutor.vo;

public class Json {
	//状态
	private boolean success;
	//反馈信息
	private String msg;
	//数据
	private Object obj;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Json [success=" + success + ", msg=" + msg + ", obj=" + obj + "]";
	}
	
}
