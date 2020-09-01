package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlatDaoMemoireTest {
	
	private PlatDaoMemoire platDaoMemoire;

	@BeforeEach
	void setUp() {
		this.platDaoMemoire = new PlatDaoMemoire();
	}

	@Test
	void listerPlatsVideALInitialisation() {
		assertThat(platDaoMemoire.listerPlats().size()).isEqualTo(0);
	}

	@Test
	void ajouterPlatCasPassants() {
		platDaoMemoire.ajouterPlat("Sardines", 3000);
		
		assertThat(platDaoMemoire.listerPlats().size()).isEqualTo(1);
	}
}
