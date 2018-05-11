package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.xtreme.entities.Post;

class PostTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Post post;

	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("extreme");
		em = emf.createEntityManager();
		post = em.find(Post.class, 1);
	}

	@Test
	void test_post_mappings() {
		assertEquals("Xander Cage", post.getName());
	}
	
	@Test
	void test_post_to_comment() {
		assertEquals("Augustus Gibbons", post.getComments().get(0).getName());
	}
	
	@Test
	void test_post_to_category() {
		assertEquals("skydiving", post.getCategory().getName());
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
}
