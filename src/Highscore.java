import javax.swing.*;

/**
 * Created by doetken on 08.06.2016.
 */
public class Highscore {

    //    todo  Umsetzung mit XML!!
    private JTextField nachname = new JTextField();
    private JTextField vorname = new JTextField();
    private String nachnamenString = "";
    private String vornamenString = "";
    private int zeit = 500;
    private int fehlschuesse = 500;
    private int punkte = 0;

    public void einlesen() {

    }

    public void schreiben() {
//      todo        Methodenaufruf:    erweitern(Vorname und Nachname aus Eingabefeldern lesen);
    }

    public void erweitern(JTextField vorname, JTextField nachname) {
        einlesen();
        this.vornamenString = vorname.getText();
        this.nachnamenString = nachname.getText();
        this.punkte = punkteBerechnen(this.zeit, this.fehlschuesse);
        System.out.println("Highscoretest:" + this.vornamenString + ", "+this.nachnamenString + ", " + punkte);
    }

    private void punkteBerechnen(int zeit, int fehlschuesse) {
        this.punkte = 1000;
        this.fehlschuesse = fehlschuesse;
        this.zeit = zeit;
        punkte -= fehlschuesse;
        punkte -= zeit;
    }
}

