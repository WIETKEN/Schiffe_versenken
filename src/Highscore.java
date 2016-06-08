import javax.swing.*;

/**
 * Created by doetken on 08.06.2016.
 */
public class Highscore {

    //    todo  Umsetzung mit XML!!
    JTextField nachname=new JTextField();
    JTextField vorname= new JTextField();
    String nachnamenString = "";
    String vornamenString = "";
    int zeit = 500;
    int fehlschuesse = 500;
    int punkte = 0;

    public void einlesen() {

    }

    public void schreiben() {
//      todo        Methodenaufruf:    erweitern(Vorname und Nachname aus Eingabefeldern lesen);
    }

    public void erweitern(JTextField vorname, JTextField nachname) {
        einlesen();
        this.vornamenString = vorname.getText();
        this.nachnamenString = nachname.getText();
        punkteBerechnen(this.zeit, this.fehlschuesse);
    }

    private void punkteBerechnen(int zeit, int fehlschuesse) {
        this.punkte = 1000;
        this.fehlschuesse = fehlschuesse;
        this.zeit = zeit;
        punkte -= fehlschuesse;
        punkte -= zeit;
    }
}

