/**
 * Created by doetken on 24.05.2016.
 */
public abstract class Schiffstyp implements Schiffe {

    String richtung;
    int xKoordinate1;
    int yKoordinate1;
    int anzahlPunkte;
    int[] xKoord = new int[4];
    int[] yKoord = new int[4];


    public Schiffstyp(String richtung, int xKoordinate1, int yKoordinate1) {
        this.richtung = richtung;
        this.xKoordinate1 = xKoordinate1;
        this.yKoordinate1 = yKoordinate1;

        if (richtung == "horizontal") {
            for (int i = 0; i < xKoord.length; i++) {
                xKoord[i] = xKoordinate1;
                xKoordinate1 += 1;
            }
        } else {
            for (int i = 0; i < yKoord.length; i++) {
                yKoord[i] = yKoordinate1;
                yKoordinate1 += 1;
            }
        }
    }

    @Override
    public void richtungFestlegen(String richtung) {
        this.richtung = richtung;
    }

    @Override
    public void trefferEintragen() {

    }

    @Override
    public void verschieben(int xUm, int yUm) {
        if (richtung == "horizontal") {
            for (int i = 0; i < xKoord.length; i++) {
                xKoord[i] = xKoordinate1;
                xKoordinate1 += xUm;
            }
        } else {
            for (int i = 0; i < yKoord.length; i++) {
                yKoord[i] = yKoordinate1;
                yKoordinate1 += yUm;
            }

        }

    }
}
