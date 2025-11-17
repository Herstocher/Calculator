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
	                currentInput = formatResult(val / 100);
	            } catch (Exception ex) {
	                currentInput = "Error";
	            }
	            break;
	        case "+/-":
	            try {
	                double val = Double.parseDouble(currentInput.replace(",", "."));
	                currentInput = formatResult(val * -1);
	            } catch (Exception ex) {
	                currentInput = "Error";
	            }
	            break;
	        case "=":
	            try {
	                currentInput = formatResult(eval(currentInput));
	            } catch (Exception ex) {
	                currentInput = "Error";
	            }
	            break;
	        default:
	            // Eingabe validieren
	            if (isValidInput(cmd)) {
	                currentInput += cmd;
	            }
	    }

	    fenster.getTextField().setText(currentInput);
	}

	
	// Prüft, ob die Eingabe gültig ist (kein doppelter Operator, Komma nur einmal pro Zahl)
	 
	private boolean isValidInput(String cmd) {
	    if ("+-*/x".contains(cmd)) {
	        // Verhindere zwei Operatoren hintereinander
	        return !currentInput.isEmpty() && !"+-*/x".contains(currentInput.substring(currentInput.length() - 1));
	    }
	    if (cmd.equals(",")) {
	        // Prüfe, ob aktuelle Zahl schon ein Komma hat
	        String[] parts = currentInput.split("[+\\-*/x]");
	        String lastNumber = parts[parts.length - 1];
	        return !lastNumber.contains(",");
	    }
	    return true; // Zahlen sind immer erlaubt
	}

 	// Formatiert das Ergebnis: entfernt unnötige Nachkommastellen
	 
	private String formatResult(double value) {
	    if (value == (long) value) {
	        return String.valueOf((long) value);
	    } else {
	        return String.valueOf(value);
	    }
	}
	
	
	
	
	private double eval(String expr) throws Exception {
	    if (expr == null || expr.isEmpty()) {
	        throw new IllegalArgumentException("Leerer Ausdruck");
	    }

	    // Komma in Punkt umwandeln und 'x' durch '*' ersetzen
	    expr = expr.replace(",", ".").replace("x", "*");

	    // Tokenisierung
	    List<String> tokens = new ArrayList<>();
	    StringBuilder number = new StringBuilder();
	    boolean lastWasOperator = true; // Für negatives Vorzeichen am Anfang

	    for (char c : expr.toCharArray()) {
	        if (Character.isDigit(c) || c == '.') {
	            number.append(c);
	            lastWasOperator = false;
	        } else if (c == '-' && lastWasOperator) {
	            // Negatives Vorzeichen
	            number.append(c);
	        } else {
	            if (number.length() > 0) {
	                tokens.add(number.toString());
	                number.setLength(0);
	            }
	            tokens.add(String.valueOf(c));
	            lastWasOperator = true;
	        }
	    }
	    if (number.length() > 0) {
	        tokens.add(number.toString());
	    }

	    // Validierung: keine doppelten Punkte
	    for (String t : tokens) {
	        if (t.chars().filter(ch -> ch == '.').count() > 1) {
	            throw new IllegalArgumentException("Ungültige Zahl: " + t);
	        }
	    }

	    // Multiplikation und Division zuerst
	    for (int i = 0; i < tokens.size(); i++) {
	        String token = tokens.get(i);
	        if (token.equals("*") || token.equals("/")) {
	            double left = Double.parseDouble(tokens.get(i - 1));
	            double right = Double.parseDouble(tokens.get(i + 1));
	            double result = token.equals("/") ? left / right : left * right;

	            tokens.set(i - 1, String.valueOf(result));
	            tokens.remove(i); // Operator entfernen
	            tokens.remove(i); // rechte Zahl entfernen
	            i--;
	        }
	    }

	    // Addition und Subtraktion
	    double result = Double.parseDouble(tokens.get(0));
	    for (int i = 1; i < tokens.size(); i += 2) {
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
