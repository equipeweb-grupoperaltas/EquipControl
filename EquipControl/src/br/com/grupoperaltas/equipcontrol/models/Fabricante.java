package br.com.grupoperaltas.equipcontrol.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @classname Fabricante
 * @package   br.com.grupoperaltas.equipcontrol.models
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */

@Entity
public class Fabricante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String fabricante;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	

}
