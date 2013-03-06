package br.com.grupoperaltas.equipcontrol.controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.grupoperaltas.equipcontrol.dao.EquipamentoDao;
import br.com.grupoperaltas.equipcontrol.models.Equipamento;
import br.com.grupoperaltas.equipcontrol.utils.Monitor;

/**
 * @classname MonitorController
 * @package   br.com.grupoperaltas.equipcontrol.controllers
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 05/02/2013
 * @version 1.0
 * 
 */

@Resource
public class MonitorController {

	private final Result result;
	private EquipamentoDao daoEquip;
	
	public MonitorController(Result result, EquipamentoDao daoEquip) {
		this.result = result;
		this.daoEquip = daoEquip;
	}
	
	@Path("/monitor")
	public void index(){
		//get All Ips
		List<Equipamento> equipList = daoEquip.fetchAll();
		List<String> listResults = new ArrayList<String>();
		for (int i = 0; i < equipList.size(); i++) {
			if(equipList.get(i).getMonitora() == 1){
				boolean result = Monitor.doPing(String.valueOf(equipList.get(i).getIp()), 3000);
				listResults.add("IP:  " + equipList.get(i).getIp() + "  Resultado: " + result );
				System.out.println(equipList.get(i).getIp());
			}
			
		}
		result.include("resultsArray", listResults);
	}
	
}
