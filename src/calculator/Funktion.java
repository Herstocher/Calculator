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
			case "%":
				try {
					double val = Double.parseDouble(currentInput.replace(",", "."));
					currentInput = String.valueOf(val / 100);
				} catch (Exception ex) {
					currentInput = "Error";
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
		
		
		//Zuerst Mal und Geteilt
		
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).equals("x") || tokens.get(i).equals("*") || tokens.get(i).equals("/")) {
				
				//Aufteilen in links und rechts
				double left = Double.parseDouble(tokens.get(i - 1));
				double right = Double.parseDouble(tokens.get(i + 1));
				double result = tokens.get(i).equals("/") ? left / right : left * right;
				
				tokens.set(i-1, String.valueOf(result));
				tokens.remove(i);	//Operator entfernen
				tokens.remove(i);	//rechte Zahl entfernen
				i--;
			}
		}
		
		//Addieren und Subtrahieren
		
		double result = Double.parseDouble(tokens.get(0));
		for (int i = 1; i < tokens.size(); i +=2) {
			String op = tokens.get(i);
			double val = Double.parseDouble(tokens.get(i + 1));
			if (op.equals("+")) {
				result += val;
			} else if (op.equals("-")) {
				result -= val;
			}
		}
		
		return result;
		
		
	}
	

}
