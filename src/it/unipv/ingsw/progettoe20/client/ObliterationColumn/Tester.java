package it.unipv.ingsw.progettoe20.client.ObliterationColumn;

import it.unipv.ingsw.progettoe20.client.ObliterationColumn.oblController.OblController;
import it.unipv.ingsw.progettoe20.client.ObliterationColumn.oblModel.ObliterationColumn;
import it.unipv.ingsw.progettoe20.client.ObliterationColumn.oblView.OblGui;


// tester momentaneo per obliterazione
//funziona solo mettendo la stringa test come id
public class Tester {
    public static void main(String[] args){

        ObliterationColumn oc = new ObliterationColumn();
        OblGui oblgui = new OblGui();
        OblController oblc = new OblController(oblgui, oc);
    }
}
