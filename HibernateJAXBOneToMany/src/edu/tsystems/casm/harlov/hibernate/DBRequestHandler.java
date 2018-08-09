package edu.tsystems.casm.harlov.hibernate;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import javax.xml.bind.*;

@ManagedBean(name = "dBRequestHandler", eager = true)
@SessionScoped
public class DBRequestHandler {
private ArrayList<User> users;
private StringWriter stringWriter = new StringWriter();
	
	public DBRequestHandler() {
		this.users = new ArrayList<User>();
	}
	
	public String searchUsers() {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(UserConfig.class)
								.addAnnotatedClass(UserGroupConfig.class)
								.addAnnotatedClass(GroupConfig.class)
								.addAnnotatedClass(Filter.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			String hql = "from User u WHERE u.id = :user_id";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", 1000115);
			this.users = (ArrayList<User>) query.getResultList();
			
			for(User user : users) {
				//System.out.println(user);
				JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
				Marshaller marshaller = jaxbContext.createMarshaller();
				
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.marshal(user, new File("C:\\andy\\Development\\Projects\\HibernateJAXBOneToMany\\xmlData\\searchResults.xml"));
				marshaller.marshal(user, stringWriter);
				
				System.out.println(this.getStringWriter());
			}
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
		return "success";
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public String getStringWriter() {
		return stringWriter.toString();
	}
}
