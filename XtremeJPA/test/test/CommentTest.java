package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.xtreme.entities.Comment;

class CommentTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Comment comment;

	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("extreme");
		em = emf.createEntityManager();
		comment = em.find(Comment.class, 1);
	}

	@Test
	void test_comment_mappings() {
		assertEquals("Augustus Gibbons", comment.getName());
	}
	
	@Test
	void test_comment_to_post() {
		assertEquals("Xtreme Single Engine", comment.getPost().getTitle());
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
}
