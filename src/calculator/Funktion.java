package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funktion implements ActionListener {
	
	private Fenster fenster;
	private String currentInput = "";
	
	public Funktion(Fenster fenster) {
		this.fenster = fenster;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
	
	
	/*
	 * Wenn C oder CE	-> Eingabe löschen
	 * Wenn DEL			-> letztes Zeichen löschen
	 * Wenn =			-> Berechnung durchführen
	 * Sonst			-> Text an Eingabe anhängen
	 */
	
		switch (cmd) {
			case "C":
			case "CE":
				currentInput = "";
				break;
			case "DEL":
				if (!currentInput.isEmpty()) {
					currentInput = currentInput.substring(0, currentInput.length() - 1);
				}
				break;
			case "=":
				try {
					currentInput = String.valueOf(eval(currentInput));
				} catch (Exception ex) {
					currentInput = "Error";
				}
				break;
			default:
				currentInput += cmd;
		}
		
		//Zeigt den neuen Wert im Display
		fenster.getTextField().setText(currentInput);
	}
	
	
	
	
	private double eval(String expr) {
		return Double.parseDouble(expr);
	}


}
