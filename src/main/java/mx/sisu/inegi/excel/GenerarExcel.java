package mx.sisu.inegi.excel;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Gibrán moreno
 */
public class GenerarExcel {

    XSSFWorkbook libro;
    Sheet hoja;

    public void generarExcel(JSONObject totalEdoMex, JSONObject jsonMujeresEdoMex, JSONObject hombresEdoMex) {
        libro = new XSSFWorkbook();

        hoja = libro.createSheet();

        int noFila = 1;

        crearHeaders();

        JSONArray arrayTotalEdomex = totalEdoMex.getJSONArray("indices");
        JSONArray arrayMujeresEdoMex = jsonMujeresEdoMex.getJSONArray("indices");
        JSONArray arrayHombresEdomex = hombresEdoMex.getJSONArray("indices");

        for (int i = 0; i < arrayMujeresEdoMex.length(); i++) {
            Row fila = hoja.createRow(noFila);
            
            Cell cell = fila.createCell(0);
            cell.setCellValue(arrayTotalEdomex.getJSONObject(i).getInt("TIME_PERIOD"));
            
            cell = fila.createCell(1);
            cell.setCellValue(arrayTotalEdomex.getJSONObject(i).getInt("OBS_VALUE"));
            
            cell = fila.createCell(2);
            cell.setCellValue(arrayMujeresEdoMex.getJSONObject(i).getInt("OBS_VALUE"));
            
            cell = fila.createCell(3);
            cell.setCellValue(arrayHombresEdomex.getJSONObject(i).getInt("OBS_VALUE"));
            noFila++;
        }

        try {
            FileOutputStream out = new FileOutputStream("/Users/sisu/Desktop/inegi.xls");
            libro.write(out);
            out.close();
        } catch (Exception e) {
        }
    }

    private void crearHeaders() {
        Row fila = hoja.createRow(0);

        Cell cell = fila.createCell(0);
        cell.setCellValue("Año");
        
        cell = fila.createCell(1);
        cell.setCellValue("Poblacion Total");

        cell = fila.createCell(2);
        cell.setCellValue("Poblacion Mujeres");

        cell = fila.createCell(3);
        cell.setCellValue("Poblacion Mujeres");
    }


}
