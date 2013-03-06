package br.com.grupoperaltas.equipcontrol.controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.grupoperaltas.equipcontrol.dao.EquipamentoDao;
import br.com.grupoperaltas.equipcontrol.dao.LocalFisicoDao;
import br.com.grupoperaltas.equipcontrol.infra.Public;
import br.com.grupoperaltas.equipcontrol.models.Equipamento;
import br.com.grupoperaltas.equipcontrol.models.LocalFisico;
import br.com.grupoperaltas.equipcontrol.models.MonitorView;
import br.com.grupoperaltas.equipcontrol.utils.Monitor;
import br.com.grupoperaltas.equipcontrol.utils.SendSMS;

/**
 * @classname IndexController
 * @package br.com.grupoperaltas.equipcontrol.controllers
 * 
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 11/12/2012
 * @version 1.0
 * 
 */

@Resource
public class IndexController {

	private final Result result;
	private EquipamentoDao equipDao;
	private LocalFisicoDao localDao;

	public IndexController(Result result, EquipamentoDao equipDao, LocalFisicoDao localDao) {
		this.result = result;
		this.equipDao = equipDao;
		this.localDao = localDao;
	}

	@Path("/")
	public void index() {
	
		String mensagem = "";
		List<Equipamento> equipList = equipDao.fetchAll();
		List<MonitorView> listResults = new ArrayList<MonitorView>();
		
		for (int i = 0; i < equipList.size(); i++) {
			
			if (equipList.get(i).getMonitora() == 1) {
				
				boolean result = Monitor.doPing(String.valueOf(equipList.get(i).getIp()), 3000);		
				Long idLocal = Long.valueOf(equipList.get(i).getLocal().getId());
				LocalFisico local = localDao.find(idLocal);
				
				String obs = "";
				if(local.getObs() != null){
					obs = " / " + local.getObs();
				}
				
				MonitorView mon = new MonitorView();
				
				mon.setLocal(local.getLocal() + obs);
				mon.setEquipamento(equipList.get(i).getFabricante().getFabricante() + " / " + equipList.get(i).getModelo().getModelo());
				mon.setIp(equipList.get(i).getIp());
				
				
				
				if(result){
					mon.setStatus("<p style='color:green;'>Funcionando</p>");	
				}else{
					mensagem += "Equipamento Parado IP: " + equipList.get(i).getIp() + " Local: " + local.getLocal() + obs + "\r\n";
					mon.setStatus("<p style='color:red;'>Parado</p>");
				}
				
				
				
			//	SendSMS send = new SendSMS("1498229077","envio do java");
				listResults.add(mon);
				
				System.out.println(equipList.get(i).getIp());
			}

		}
		SendSMS send = new SendSMS("1498229077",mensagem);
		
		
		result.include("resultsArray", listResults);
	}
	
	@Public
	@Path("/sms")
	public void sms(String telefone, String mensagem){
		SendSMS send = new SendSMS("1498229077","Testando");
	}

}
