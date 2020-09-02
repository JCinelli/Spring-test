package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;

@SpringJUnitConfig ({JdbcTestConfig.class, PlatDaoJdbc.class})
@ActiveProfiles("jdbc")
class PlatDaoJdbcIntegrationTest {
	
	@Autowired
	private PlatDaoJdbc dao;
	
	@Autowired
	private JdbcTemplate template;
	
	/**
	 * Valide que PlatDaoJdbc::listerPlats ne retourne pas une liste vide
	 */
	@Test
	void listerPlatsNonVide() {

		assertThat(dao.listerPlats()).isNotEmpty();
		
		System.out.println("Basic list : ");
		dao.listerPlats().forEach(p -> System.out.println(p));
		
	}
	
	/**
	 * Vérifie à l’aide du JdbcTemplate qu’un plat est bien inséré.
	 */
	@Test
	void ajouterPlat() {
		
//		Verification avec le dao
		assertThat(dao.listerPlats().size()).isEqualTo(6);
		dao.ajouterPlat("Burger", 1500);
		assertThat(dao.listerPlats().size()).isEqualTo(7);
		
//		Verification avec le JdbcTemplate
		Integer prixPlat = template.queryForObject("select prix from plat where nom = 'Burger'", Integer.class);
		assertThat(prixPlat).isEqualTo(1500);
		
		System.out.println("\rList after insert :");
		dao.listerPlats().forEach(p -> System.out.println(p));
		
	}

}
