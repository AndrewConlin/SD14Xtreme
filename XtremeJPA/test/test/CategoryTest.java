package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.xtreme.entities.Category;

class CategoryTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Category category;

	@BeforeEach
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("extreme");
		em = emf.createEntityManager();
		category = em.find(Category.class, 1);
	}

	@Test
	void test_category_mappings() {
		assertEquals("skydiving", category.getName());
	}
	
	@Test
	void test_category_to_post() {
		assertEquals("Xtreme Single Engine", category.getPosts().get(0).getTitle());
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}

}
