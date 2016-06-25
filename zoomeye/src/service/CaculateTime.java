package service;

public class CaculateTime {
	public static String cmd = "nmap  -v 202.141.160.8 -p 80 -oX result.xml --unprivileged";
	public static int dbTime = 0;
	public static int nmapTime = 0;
	
	public static String getCmd(String result) {
		return result;
	}
}
