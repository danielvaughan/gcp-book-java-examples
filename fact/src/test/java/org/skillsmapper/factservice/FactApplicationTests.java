package org.skillsmapper.factservice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FactApplicationTests {

	@Test
	void contextLoads() {
	}

	@DataJpaTest
	public class FactRepositoryTests {
		@Autowired
		private TestEntityManager entityManager;

		@Autowired
		private FactRepository facts;

		@Test
		public void testFindByType() {
			Fact fact = new Fact("Learning", "GCP");
			entityManager.persist(fact);

			List<Fact> findByType = facts.findByType(fact.getType());

			assertThat(findByType).extracting(Fact::getType).containsOnly(fact.getSkill());
		}
	}
}
