package br.com.grupoperaltas.equipcontrol.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @classname Marca
 * @package   br.com.grupoperaltas.equipcontrol.models
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */

@Entity
public class Modelo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	

	@ManyToOne
	@JoinColumn(name = "idfabricante")
	private Fabricante fabricante;
	
	
	@Column(unique=true)
	private String modelo;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}


	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
