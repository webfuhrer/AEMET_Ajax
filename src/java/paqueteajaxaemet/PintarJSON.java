/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteajaxaemet;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class PintarJSON {
    public static String pinta(ArrayList<Municipio> lista)
    {
     /*   {
"municipios":[{"nombre":"Albacete", "id_muni":45, "id_prov":23},
{"nombre":"Soria", "id_muni":78, "id_prov":16},...]
}
*/
        String json="{\"municipios\":[";
        for (Municipio municipio : lista) {
            json+="{\"nombre\": \""+municipio.getNombre()+"\", \"id_muni\": "+municipio.getCod_municipio()+
               ", \"id_prov\":"+municipio.getId_provincia()+"},";
        }
        if(json.contains(","))
        {
            json=json.substring(0, json.length()-1);
        }
        
        
        
        json+="]}";
        return json;
    }
    
}
