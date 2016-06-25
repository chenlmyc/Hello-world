package dao;

import java.util.ArrayList;
import java.util.List;

import model.Host;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tools.HibernateHelper;

public class HostDao {
	private static SessionFactory sessionFactory;

	public Object findHostFromIP(String ip) {
		sessionFactory = HibernateHelper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "from Host where ip=?";
		Query query = session.createQuery(hql);
		query.setString(0, ip);

		List<Object> list = query.list();
		tx.commit();
		session.close();
		return null;
	}

	public List<String> ip2ips(String ip) {
		if(ip.endsWith("0")){
			ArrayList<String> list = new ArrayList<String>();
			String[] ips = ip.split("\\.");

			ArrayList<Integer> list1 = new ArrayList<Integer>();
			String ipsuff = "";
			for (int i = 0; i < ips.length - 1; i++){
				ipsuff = ipsuff + ips[i] + ".";
			}
			int ip1 = Integer.parseInt(ips[3]);
			for (int i = ip1 + 1; i <= Integer.parseInt(ips[3]) + 253; i++){
				list.add(ipsuff + String.valueOf(i));
				// System.out.println(ipsuff+String.valueOf(i));
			}
			return list;
		}
		return null;
	}

	public List findHostFromIPs(String ip) {
		sessionFactory = HibernateHelper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<String> list = ip2ips(ip);
		String hql = "from Host where ip in (:ips)";
		Query query = session.createQuery(hql);
		query.setParameterList("ips", list);

		List<Object> list1 = query.list();
		tx.commit();
		session.close();
		return list1;
	}

	public Object findHostFromOS(String os) {
		sessionFactory = HibernateHelper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "select t1.ip,t1.location,t2.`port`,t2.service" + "from host  t1 inner join service t2 on t1.ip = t2.ip " + "where t2.os=?";
		Query query = session.createQuery(hql);
		query.setString(0, os);

		List<Object> list = query.list();
		tx.commit();
		session.close();
		return list.get(0);
	}

	/*
	 * 存入储数据库
	 */
	public void insertFromXML(String ip, String port, String service) {
		sessionFactory = HibernateHelper.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		tx.commit();
		session.close();
	}
}
