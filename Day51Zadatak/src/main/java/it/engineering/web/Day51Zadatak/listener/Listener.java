package it.engineering.web.Day51Zadatak.listener;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import it.engineering.web.Day51Zadatak.domain.User;
import it.engineering.web.Day51Zadatak.persistence.MyEntityManagerFactory;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
public class Listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    
    	ServletContext sc = sce.getServletContext();
    	
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
    	List<User> users = em.createQuery("select u from User u", User.class).getResultList();
    	
    	System.out.println("===== Listener je obrazovao users");
    	System.out.println(users);
    	
//    	sc.setAttribute("users", users);
		
//		new ArrayList<User>() {
//    		{
//    			add(new User("admin","admin", "petar", "peric"));
//    			add(new User("user","pass", "nikola", "nikolic"));
//    			add(new User("test","test", "ana", "anic"));
//    		}
//    	};
//    	

    }
	
}