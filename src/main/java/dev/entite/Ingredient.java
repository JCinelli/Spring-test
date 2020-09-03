package dev.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nom", length = 100, nullable = false, unique = true)
	private String nom;

	@ManyToMany(mappedBy = "listIngredients")
	private List<Plat> listPlatsQuiContiennentIng;

	@Override
	public String toString() {
		return "Id = " + id + "|| Nom = " + nom;
	}

	// GETTERS & SETTERS
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the listPlatsQuiContiennentIng
	 */
	public List<Plat> getListPlatsQuiContiennentIng() {
		return listPlatsQuiContiennentIng;
	}

	/**
	 * @param listPlatsQuiContiennentIng the listPlatsQuiContiennentIng to set
	 */
	public void setListPlatsQuiContiennentIng(List<Plat> listPlatsQuiContiennentIng) {
		this.listPlatsQuiContiennentIng = listPlatsQuiContiennentIng;
	}
}
