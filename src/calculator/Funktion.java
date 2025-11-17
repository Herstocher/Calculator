package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Funktion implements ActionListener {

    private Fenster fenster;           // Referenz auf das Fenster (GUI)
    private String currentInput = "";  // Speichert den aktuellen Ausdruck, den der Benutzer eingibt

    public Funktion(Fenster fenster) {
        this.fenster = fenster;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand(); // Holt den Text des gedrückten Buttons (z. B. "1", "+", "=")

        switch (cmd) {
            case "CE":
                // Löscht die gesamte Eingabe
                currentInput = "";
                break;

            case "DEL":
                // Löscht das letzte Zeichen, falls vorhanden
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                }
                break;

            case "%":
                try {
                    if (!currentInput.isEmpty()) {
                        // Teile den Ausdruck in Operatoren und Zahlen
                        String[] parts = currentInput.split("(?=[+\\-*/x])|(?<=[+\\-*/x])");

                        for (int i = parts.length - 1; i >= 0; i--) {
                            if (parts[i].matches("\\(?-?\\d+(,\\d+)?\\)?")) {
                                // Entferne Klammern für Berechnung
                                String cleanNumber = parts[i].replace("(", "").replace(")", "");
                                double val = Double.parseDouble(cleanNumber.replace(",", "."));
                                // Ersetze durch Prozentwert
                                parts[i] = formatResult(val / 100);
                                break;
                            }
                        }

                        currentInput = String.join("", parts);
                    }
                } catch (Exception ex) {
                    currentInput = "Error";
                }
                break;

            case "+/-":
                // Negiert die letzte Zahl im Ausdruck (wie beim Windows-Rechner)
                try {
                    if (!currentInput.isEmpty()) {
                        // Zerlegt den Ausdruck in Operatoren und Zahlen
                        String[] parts = currentInput.split("(?=[+\\-*/x])|(?<=[+\\-*/x])");

                        // Geht von rechts nach links, um die letzte Zahl zu finden
                        for (int i = parts.length - 1; i >= 0; i--) {
                            // Regex erkennt normale Zahlen und Zahlen in Klammern
                            if (parts[i].matches("\\(?-?\\d+(,\\d+)?\\)?")) {
                                if (parts[i].startsWith("(-") && parts[i].endsWith(")")) {
                                    // Wenn die Zahl schon negiert ist, entferne Klammern und Minus
                                    parts[i] = parts[i].substring(2, parts[i].length() - 1);
                                } else {
                                    // Negiere die Zahl und setze sie in Klammern
                                    parts[i] = "(-" + parts[i].replace("(", "").replace(")", "") + ")";
                                }
                                break; // Nur die letzte Zahl wird geändert
                            }
                        }
                        // Setzt den Ausdruck wieder zusammen
                        currentInput = String.join("", parts);
                    }
                } catch (Exception ex) {
                    currentInput = "Error";
                }
                break; // WICHTIG: verhindert, dass "=" sofort ausgeführt wird

            case "=":
                // Berechnet den Ausdruck
                try {
                    currentInput = formatResult(eval(currentInput));
                } catch (Exception ex) {
                    currentInput = "Error";
                }
                break;

            default:
                // Für Zahlen und Operatoren: prüft, ob die Eingabe gültig ist
                if (isValidInput(cmd)) {
                    currentInput += cmd;
                }
        }

        // Aktualisiert das Textfeld im Fenster
        fenster.getTextField().setText(currentInput);
    }

    /**
     * Prüft, ob die Eingabe gültig ist:
     * - Keine zwei Operatoren hintereinander
     * - Komma nur einmal pro Zahl
     */
    private boolean isValidInput(String cmd) {
        if ("+-*/x".contains(cmd)) {
            return !currentInput.isEmpty() && !"+-*/x".contains(currentInput.substring(currentInput.length() - 1));
        }
        if (cmd.equals(",")) {
            String[] parts = currentInput.split("[+\\-*/x]");
            String lastNumber = parts[parts.length - 1];
            return !lastNumber.contains(",");
        }
        return true; // Zahlen sind immer erlaubt
    }

    /**
     * Formatiert das Ergebnis:
     * - Entfernt unnötige Nachkommastellen (z. B. 5.0 → 5)
     */
    private String formatResult(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        } else {
            return String.valueOf(value);
        }
    }

    /**
     * eval():
     * - Berechnet den mathematischen Ausdruck
     * - Unterstützt +, -, *, /
     * - Entfernt Klammern vor der Berechnung
     */
    private double eval(String expr) throws Exception {
        if (expr == null || expr.isEmpty()) {
            throw new IllegalArgumentException("Leerer Ausdruck");
        }

        // Entfernt Klammern und ersetzt Komma/Pseudo-Operatoren
        expr = expr.replace("(", "").replace(")", "").replace(",", ".").replace("x", "*");

        List<String> tokens = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        boolean lastWasOperator = true;

        // Zerlegt den Ausdruck in Zahlen und Operatoren
        for (char c : expr.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                number.append(c);
                lastWasOperator = false;
            } else if (c == '-' && lastWasOperator) {
                number.append(c); // Negatives Vorzeichen
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
                tokens.remove(i);
                tokens.remove(i);
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