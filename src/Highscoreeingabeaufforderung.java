import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by doetken on 08.06.2016.
 */
public class Highscoreeingabeaufforderung {

    Highscore highscore;

    public Highscoreeingabeaufforderung() {
        JFrame highscoreFrame = new JFrame("Highscoreeingabeaufforderung");

        highscoreFrame.add(panelBauen());

        highscoreFrame.pack();
        highscoreFrame.setLocationRelativeTo(null);
        highscoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        highscoreFrame.setVisible(true);
    }

    private JPanel panelBauen() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextField vorname = new JTextField(12);
        JTextField nachname = new JTextField(12);
        JButton fertig = new JButton("Fertig");
        fertig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Gespeichert");
                highscore=new Highscore();
                highscore.erweitern(vorname, nachname);
            }
        });
        panel.add(fertig, BorderLayout.SOUTH);
        panel.add(vorname, BorderLayout.NORTH);
        panel.add(nachname, BorderLayout.CENTER);
        return panel;
    }
}
