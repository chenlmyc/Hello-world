package model;

public class Service {
	private Integer id;
	private String ip;
	private Integer port;
	private String service;
	
	public Service(){
		
	}
	
	public Service(String ip, Integer port, String service) {
		super();
		this.ip = ip;
		this.port = port;
		this.service = service;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
}
