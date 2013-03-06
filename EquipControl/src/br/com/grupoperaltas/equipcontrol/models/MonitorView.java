package br.com.grupoperaltas.equipcontrol.models;

/**
 * @classname MonitorView
 * @package   br.com.grupoperaltas.equipcontrol.models
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 07/02/2013
 * @version 1.0
 * 
 */
public class MonitorView {

	private String local;
	private String equipamento;
	private String ip;
	private String status;
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
