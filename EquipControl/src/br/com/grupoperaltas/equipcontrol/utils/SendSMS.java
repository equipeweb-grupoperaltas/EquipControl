package br.com.grupoperaltas.equipcontrol.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;



/**
 * @classname sendSMS
 * @package br.com.grupoperaltas.equipcontrol.utils
 * 
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 07/02/2013
 * @version 1.0
 * 
 */
public class SendSMS {
	
	
	public SendSMS(String telefone, String mensagem){
		 try {
		   
		 URL url = new URL("http://sigp.intranet.local/webservice?telefone="+telefone+"&mensagem="+URLEncoder.encode(mensagem,"UTF8"));
	       
		   URLConnection urlConn = url.openConnection();

	        System.out.println(urlConn.getContentType());  //it returns text/html

	        BufferedReader in = new BufferedReader
	        (new InputStreamReader(urlConn.getInputStream()));

	        String text;

	        while ((text = in.readLine()) != null) {

	            System.out.println(text);
	        }

	        in.close();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}