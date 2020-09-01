package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.service.PlatServiceVersion2;

@SpringJUnitConfig (PlatDaoFichier.class)
@TestPropertySource ("classpath:test.properties")
@DirtiesContext (classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class PlatDaoFichierTest {

	@Autowired
	PlatDaoFichier dao;
	
	@Test
	void ajouterPlat() {		
		
		dao.ajouterPlat("blou", 1523);
		
		assertThat(dao.listerPlats().size()).isEqualTo(1);
		
	}
	
	@Test
	void ajouterPlat2() {		
		
		dao.ajouterPlat("blou", 1523);
		
		assertThat(dao.listerPlats().size()).isEqualTo(1);
		
	}

}
