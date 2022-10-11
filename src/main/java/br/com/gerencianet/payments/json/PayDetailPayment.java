package br.com.gerencianet.payments.json;

import java.util.HashMap;


import org.json.JSONObject;

import br.com.gerencianet.Credentials;
import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;

public class PayDetailPayment {
    public static void main(String[] args) {
		Credentials credentials = new Credentials();

		JSONObject options = new JSONObject();
		options.put("client_id", credentials.getClientId());
		options.put("client_secret", credentials.getClientSecret());
		options.put("certificate", credentials.getCertificate());
		options.put("sandbox", credentials.isSandbox());
    	
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("idPagamento", "1");

		try {
			Gerencianet gn = new Gerencianet(options);
			JSONObject response = gn.call("payDetailPayment", params, new JSONObject());
			System.out.println(response);
		}catch (GerencianetException e){
			System.out.println(e.getError());
			System.out.println(e.getErrorDescription());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
}
