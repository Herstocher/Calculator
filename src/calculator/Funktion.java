package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

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
		//Komma in Punkt umwandeln
		expr = expr.replace(",", ".");

		List<String> tokens = new ArrayList<>();
		StringBuilder  number = new StringBuilder();
		
		//Input in Teile zerlegen
		for (char c : expr.toCharArray()) {
			if (Character.isDigit(c) || c == '.') {
				number.append(c);
			} else {
				if (number.length() > 0 ) {
					tokens.add(number.toString());
					number.setLength(0);
				}
				tokens.add(String.valueOf(c));
			}
		}
		
		if (number.length() > 0) {
			tokens.add(number.toString());
		}
		
		//Addition und Substraktion
		
		double result = Double.parseDouble(tokens.get(0));
		for (int i = 1; i < tokens.size(); i += 2) {
			String op = tokens.get(i);
			double value = Double.parseDouble(tokens.get(i + 1));
			if (op.equals("+")) {
				result += value;
			} else if (op.equals("-")) {
				result -= value;
			}
		}
		
		return result;
	}


}
