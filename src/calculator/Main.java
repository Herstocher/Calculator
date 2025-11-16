package calculator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(() ->{
			Fenster fenster = new Fenster();
			Funktion funktion = new Funktion(fenster);
			fenster.addButtonListener(funktion);
			fenster.setVisible(true);
		});

	}

}
