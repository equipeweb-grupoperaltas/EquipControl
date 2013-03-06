package br.com.grupoperaltas.equipcontrol.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @classname LocalFisico
 * @package   br.com.grupoperaltas.equipcontrol.models
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */

@Entity
public class LocalFisico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String local;
	private String obs;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
}
