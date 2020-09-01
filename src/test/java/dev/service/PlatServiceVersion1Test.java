package dev.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import dev.dao.IPlatDao;
import dev.exception.PlatException;

class PlatServiceVersion1Test {

	IPlatDao daoMock;

	PlatServiceVersion1 pSerV1;

	@BeforeEach
	void init() {
		
		daoMock = Mockito.mock(IPlatDao.class); 
		
		pSerV1 = new PlatServiceVersion1(daoMock);
	}

	@Test
	void ajouterPlatNomInvalid() {

		assertThrows(PlatException.class, () -> {

			pSerV1.ajouterPlat("le", 32000);

		});
	}

	@Test
	void ajouterPlatPrixInvalid() {

		assertThrows(PlatException.class, () -> {

			pSerV1.ajouterPlat("blabla", 32);

		});
	}

	@Test
	void ajouterPlat() {
		
		pSerV1.ajouterPlat("blabla", 3200);
		
		verify(daoMock).ajouterPlat("blabla", 3200);

	}

}
