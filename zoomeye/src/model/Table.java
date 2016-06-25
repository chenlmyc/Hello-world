package model;

public class Table {
	private Integer id;
	private String ip;
	private String city;
	private String os;
	private String port;
	private String service;
	
	public Table(){
		
	}
	
	public Table(String ip, String city, String os, String port, String service) {
		super();
		this.ip = ip;
		this.city = city;
		this.os = os;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
}
