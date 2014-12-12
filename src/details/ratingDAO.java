package details;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ratingDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
	EntityManager em = null;
	
	public ratingDAO() {
		em = factory.createEntityManager();
	}
	
	public void createRating(d_rating rating) {
		em.getTransaction().begin();
		em.persist(rating);
		em.getTransaction().commit();
	}
	
	public void removeRatingById(int id) {
		em.getTransaction().begin();
		d_rating rating = em.find(d_rating.class, id);
		em.remove(rating);
		em.getTransaction().commit();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		d_rating dr = new d_rating("testing review",(float) (3.14));
		ratingDAO rd = new ratingDAO();
		rd.createRating(dr);
	}

}
