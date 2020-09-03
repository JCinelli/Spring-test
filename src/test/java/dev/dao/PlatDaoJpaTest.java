package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.config.JpaConfig;

@SpringJUnitConfig({ JdbcTestConfig.class, JpaConfig.class, PlatDaoJpa.class })
@ActiveProfiles("jpa")
class PlatDaoJpaTest {

	@Autowired
	IPlatDao dao;

	@Test
	void listerPlats() {

		assertThat(dao.listerPlats()).isNotEmpty();

	}

	@Test
	void ajouterPlats() {

		int tailleListe = dao.listerPlats().size();

		dao.ajouterPlat("Cousous", 3000);

		assertThat(dao.listerPlats().size()).isEqualTo(tailleListe + 1);

	}

}
