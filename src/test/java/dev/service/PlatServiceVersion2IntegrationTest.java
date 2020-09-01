package dev.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import dev.dao.IPlatDao;
import dev.dao.PlatDaoMemoire;
import dev.exception.PlatException;

@ExtendWith (SpringExtension.class)
@ContextConfiguration (classes = {PlatServiceVersion2.class, PlatDaoMemoire.class})
class PlatServiceVersion2IntegrationTest {

	@Autowired
	IPlatDao dao;

	@Autowired
	PlatServiceVersion2 pSerV2;

	@Test
	void ajouterPlat() {
		assertThat(pSerV2.listerPlats().size()).isEqualTo(0);
		
		pSerV2.ajouterPlat("Sardines", 30000);
		
		assertThat(pSerV2.listerPlats().size()).isEqualTo(1);
	}
	
	@Test
	void ajouterPlatPrixInvalid() {

		assertThrows(PlatException.class, () -> pSerV2.ajouterPlat("Moule", 32));
	}
}
