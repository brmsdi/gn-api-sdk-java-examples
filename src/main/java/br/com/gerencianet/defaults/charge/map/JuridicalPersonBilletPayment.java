package br.com.gerencianet.defaults.charge.map;

import java.util.HashMap;
import java.util.Map;
import br.com.gerencianet.Credentials;
import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;

public class JuridicalPersonBilletPayment {
	public static void main(String[] args) {
		/* *********  Set credentials parameters ******** */

		Credentials credentials = new Credentials();

		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put("client_id", credentials.getClientId());
		options.put("client_secret", credentials.getClientSecret());
		options.put("sandbox", credentials.isSandbox());

		/* ************************************************* */ 

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", "0");

		Map<String, Object> juridicalData = new HashMap<String, Object>();
		juridicalData.put("corporate_name", "Company Name");
		juridicalData.put("cnpj", "99794567000144");

		Map<String, Object> customer = new HashMap<String, Object>();
		customer.put("phone_number", "5144916523");
		customer.put("juridical_person", juridicalData);

		Map<String, Object> bankingBillet = new HashMap<String, Object>();
		bankingBillet.put("expire_at", "2018-12-12");
		bankingBillet.put("customer", customer);

		Map<String, Object> payment = new HashMap<String, Object>();
		payment.put("banking_billet", bankingBillet);

		Map<String, Object> body = new HashMap<String, Object>();
		body.put("payment", payment);

		try {
			Gerencianet gn = new Gerencianet(options);
			Map<String, Object> response = gn.call("payCharge", params, body);
			System.out.println(response);
		}catch (GerencianetException e){
			System.out.println(e.getCode());
			System.out.println(e.getError());
			System.out.println(e.getErrorDescription());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
