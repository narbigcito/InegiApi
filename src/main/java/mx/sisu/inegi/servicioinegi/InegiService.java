package mx.sisu.inegi.servicioinegi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

/**
 *
 * @author Gibrán moreno
 */
public class InegiService {

    private JSONObject obtenerDatos(String url) {
        Client client = Client.create();

        WebResource webResource = client
                .resource(url);

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200)
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());

        return new JSONObject(response.getEntity(String.class));
    }

    public JSONObject getTotalEdoMex() {
        return obtenerDatos("http://inegifacil.com/rest/indice/1002000001/15033");
    }
    
    public JSONObject getHombresEdoMex() {
        return obtenerDatos("http://inegifacil.com/rest/indice/1002000003/1002000002");
    }
    
    public JSONObject getMujeresEdoMex() {
        return obtenerDatos("http://inegifacil.com/rest/indice/1002000003/15033");
    }


}
