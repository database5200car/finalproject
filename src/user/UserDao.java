package user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import user.User;
@Path("/login")
public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("finalproject");
	EntityManager em = null;
	//create---------------------------------------------------------------
		@POST
		@Path("/create")
		@Consumes("application/json")
		@Produces("application/json")
		public void createUser(User user){
			em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();
		}
		//update---------------------------------------------------------------
		@PUT
		@Path("/changepassword")
		@Consumes("application/json")
		@Produces("application/json")
		public void updateUser(User user){
			em = factory.createEntityManager();
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			em.close();
		}
		
		//find---------------------------------------------------------------
		@GET
		@Path("/find/{username}")
		@Produces("application/json")
		public User findUserByUsernamePassword(@PathParam("username") String username,@PathParam("password") String password){
			User user = null;
			em = factory.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select u from User u where u.username=?1 and u.password=?2");
			query.setParameter(1, username);
			query.setParameter(2, password);
			try{
			user=(User) query.getSingleResult();
			System.out.println(user.getPassword());
			}catch(NoResultException e){
				user=null;
			}
			em.getTransaction().commit();
			em.close();
			return user;
		}
		public static void main(String[] args) {
		}
}
