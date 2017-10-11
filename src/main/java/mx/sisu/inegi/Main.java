/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.sisu.inegi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import mx.sisu.inegi.excel.GenerarExcel;
import mx.sisu.inegi.servicioinegi.InegiService;
import org.json.JSONObject;

/**
 *
 * @author Gibrán moreno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            InegiService inegiService = new InegiService();

            GenerarExcel generarExcel = new GenerarExcel();
            
            generarExcel.generarExcel(inegiService.getTotalEdoMex(),inegiService.getMujeresEdoMex(), inegiService.getHombresEdoMex());
            
           

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}
