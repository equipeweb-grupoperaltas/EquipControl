package br.com.grupoperaltas.equipcontrol.models;


import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @classname Usuario
 * @package   br.com.grupoperaltas.equipcontrol.models
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 02/01/2013
 * @version 1.0
 * 
 */
@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	private String nome;
	@Column(unique=true)  
	private String email;
	@Column(unique=true)  
	private String usuario;
	private String password;
	@Column(unique=true)
	private String celular;
	private String adm;
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getAdm() {
		return adm;
	}
	public void setAdm(String adm) {
		this.adm = adm;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		    String sen = "";  
	        MessageDigest md = null;  
	        try {  
	            md = MessageDigest.getInstance("MD5");  
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	        }  
	        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));  
	        sen = hash.toString(16);              
		this.password =  sen;  
	}
	
	
	
	
	
	

}
