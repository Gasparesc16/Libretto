/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.LibrettoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	
	// Model model = new Model(); ------> SBAGLIATO!!!!!!!!! perchè possono esserci tanti controllori e il modello deve essere uno e non tanti per ogni controlllore

	LibrettoModel model ;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessaggi"
    private TextArea txtMessaggi; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    	
    	String codice = txtCodice.getText();
    	
    	if(codice.length() <5){
    		
    		txtMessaggi.appendText(" Codice esame non valido\n");
    		return;
    		
    		
    	}
    	
    	Esame e = model.trovaEsame(codice);
    	
    	if(e == null){
    		
    		txtMessaggi.appendText("Codice" + codice + "non trovato\n");
    	} else {
    		txtMessaggi.appendText("Codice" + codice + "trovato\n");
    		
    		
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}
    	

    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	// Recupera i dati dalla vista
    	
    	String codice = this.txtCodice.getText();
    	String titolo = this.txtTitolo.getText();
    	String docente = this.txtDocente.getText();
    	
    	// verifica le validità dei dati
    	
    	if(codice.length() <5 || titolo.length() ==0 || docente.length() == 0){
    		
    		this.txtMessaggi.appendText("dati esame insufficiente\n");
    		return;
    	}
    	
    	// chiedi al Model di effettuare l'operazione
    	
    	Esame e = new Esame(codice,titolo,docente);
    	boolean result = model.addEsame(e);
    	
    	      // CI sono 2 modi di cui uno sbagliato -----> Creare un modello con new Model all'interno del Controller
    	
    	// aggiorna la vista con il risultato dell'operazione
    	
    	if(result){
    		
    		this.txtMessaggi.appendText("Esame aggiunto correttamente\n");
    	}
    	else {
    		this.txtMessaggi.appendText("Esame non aggiunto correttamente (codice duplicato)\n");

    		
    		
    	}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessaggi != null : "fx:id=\"txtMessaggi\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	public void setModel(LibrettoModel model) {
		
		this.model = model;
	}
}

