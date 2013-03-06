package br.com.grupoperaltas.equipcontrol.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @classname Equipamento
 * @package   br.com.grupoperaltas.equipcontrol.models
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 08/01/2013
 * @version 1.0
 * 
 */

@Entity
public class Equipamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idfabricante")
	private Fabricante fabricante;
	
	@ManyToOne
	@JoinColumn(name = "idmodelo")
	private Modelo modelo;
	
	@ManyToOne
	@JoinColumn(name = "idlocal")
	private LocalFisico local;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	private String ip;
	
	private Integer ativo;
	
	private Integer monitora;
	
	private String responsavel;
	
	private String obs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public LocalFisico getLocal() {
		return local;
	}

	public void setLocal(LocalFisico local) {
		this.local = local;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Integer getMonitora() {
		return monitora;
	}

	public void setMonitora(Integer monitora) {
		this.monitora = monitora;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
