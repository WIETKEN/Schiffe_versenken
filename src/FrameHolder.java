import javax.swing.*;
import java.awt.*;

/**
 * Created by cwiegers on 01.06.2016.
 */
public class FrameHolder {

    public JPanel mypanel = new JPanel(),
            cpupanel = new JPanel(),
            middleborder = new JPanel();
    JFrame frame = new JFrame("Schiffe versenken");
    JButton[][] myBarray = new JButton[10][10],
            cpuBarray = new JButton[10][10];
    static ImageIcon icon = new ImageIcon();
    Dimension dim = new Dimension(440, 440);
    Dimension bordim = new Dimension(40, 440);


    public FrameHolder() {
        frame.setBounds(0, 0, 1020, 480); //Gr��e des Frames
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); //alle Elemente werden nebeneinander angeordnet
        mypanel = setPanel(mypanel, myBarray, false);
        mypanel.setPreferredSize(dim); //dieses panel darf seine bevoruzige Gr��e (dim) haben und wird nicht automatisch angepasst
        middleborder = initmiddleBorder(middleborder);
        middleborder.setPreferredSize(bordim);
        cpupanel = setPanel(cpupanel, cpuBarray, true);
        cpupanel.setPreferredSize(dim);
        frame.add(mypanel); //mypanel wird zum Frame hinzugef�gt
        frame.add(middleborder);
        frame.add(cpupanel);
        frame.setVisible(true); //das Frame ist f�r den Spieler sichtbar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //bei Wegklicken des Frames wird das ganze Programm beendet

    }

    public static JPanel setPanel(JPanel panel, JButton[][] Barray, boolean cpu)
    /*
     * Ein Panel, also ein Bereich, in den Komponenten angeordnet werden, wird n�her bestimmt
	 */ {
        if (cpu == false)
            panel.setBounds(0, 0, 440, 440);
        else
            panel.setBounds(480, 0, 440, 440);

        Barray = initButtons(Barray, false);
        Barray = initButtons(Barray, true);
        panel = initBorder(panel);
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++)
                panel.add(Barray[i][j]);
        }
        panel.setLayout(new GridLayout(11, 10, 0, 0)); //alle Elemente in diesem Panel werden rasterf�rmig angeordnet
        return panel;
    }

    public static JButton[][] initButtons(JButton[][] Barray, boolean cpu)
	/*
	 * die Buttons n�her bestimmt: Am Anfang hat jeder Button das Bild "water" und die Gr��e 40*40 Pixel
	 */ {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                Barray[i][j] = new JButton(loadImage("water"));
                if (cpu == false)
                    Barray[i][j].setBounds(40 + 40 * i, 40 + 40 * j, 40, 40);
                else
                    Barray[i][j].setBounds(480 + 40 * i, 480 + 40 * j, 40, 40);
            }
        }
        return Barray;
    }

    public static JPanel initBorder(JPanel panel)
	/*
	 * Die x-Achsen-Beschriftung wird definiert
	 */ {
        JButton[] border = new JButton[10];
        for (int i = 0; i <= 9; i++) {
            String name = String.valueOf(i + 1);
            ImageIcon icon = loadImage(name);
            border[i] = new JButton();
            border[i].setIcon(icon);
            border[i].setBounds(10 + 40 * i, 40 + 40 * i, 40, 40);
            panel.add(border[i]);
        }
        return panel;
    }

    public static JPanel initmiddleBorder(JPanel panel)
	/*
	 * Hier ist dann die y-Achsen-Beschriftung dran
	 */ {
        JButton[] borButtons = new JButton[11];
        borButtons[0] = new JButton();
        borButtons[0].setBounds(440, 0, 40, 40);
        panel.add(borButtons[0]);
        for (int i = 1; i <= 10; i++) {
            String name = String.valueOf(i);
            ImageIcon icon2 = loadImage(name);
            borButtons[i] = new JButton();
            borButtons[i].setIcon(icon2);
            borButtons[i].setBounds(440, 40 * i, 40, 40);
            panel.add(borButtons[i]);
        }
        panel.setLayout(new GridLayout(11, 1, 0, 0));
        return panel;
    }

    public void changeIcon(boolean cpu, String name, int x, int y)
	/*
	 * Eine der wichtigsten Methoden: Der Button, der in Playeraction oder CPUAction gew�hlt wird,
	 * wird hier aktualisiert. Es wird ihm ein neues Bildchen zugewiesen
	 */ {
        if (cpu == false) {
            myBarray[y][x].setIcon(loadImage(name));
            mypanel.repaint();
        } else {
            cpuBarray[y][x].setIcon(loadImage(name));
            cpupanel.repaint();
        }
    }

    public static ImageIcon loadImage(String name) {
        return new ImageIcon(name + ".jpg");
    }
}

