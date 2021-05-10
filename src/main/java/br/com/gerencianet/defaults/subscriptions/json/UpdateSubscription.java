package br.com.gerencianet.defaults.subscriptions.json;

import java.util.HashMap;

import org.json.JSONObject;
import br.com.gerencianet.Credentials;
import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;

public class UpdateSubscription {
	public static void main(String[] args) {
		/* *********  Set credential parameters ******** */

		Credentials credentials = new Credentials();

		JSONObject options = new JSONObject();
		options.put("client_id", credentials.getClientId());
		options.put("client_secret", credentials.getClientSecret());
		options.put("sandbox", credentials.isSandbox());

		/* ************************************************* */

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", "0");

		JSONObject body = new JSONObject();
		body.put("notification_url", "http://localhost");
		body.put("custom_id", "Custom Subscription 0001");
		
		try {
            Gerencianet gn = new Gerencianet(options);
            JSONObject subscription = gn.call("updateSubscriptionMetadata", params, body);
            System.out.println(subscription);
        }catch (GerencianetException e){
            System.out.println(e.getCode());
            System.out.println(e.getError());
            System.out.println(e.getErrorDescription());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

	}
}
