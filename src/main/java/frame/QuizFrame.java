package frame;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QuizFrame extends JFrame {
    public QuizFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setVisible(true);
        setLayout(new GridLayout(3, 1));

        JPanel panelButtons = new JPanel();
        FlowLayout mgr1 = new FlowLayout();
        mgr1.setVgap(60);
        mgr1.setHgap(30);
        panelButtons.setLayout(mgr1);

        JButton btnPlayTune = new JButton("Play Tune");
        btnPlayTune.setSize(80, 30);
        btnPlayTune.setVisible(true);

        JButton btnCadence = new JButton("Play Cadence");
        btnCadence.setSize(80, 30);
        btnCadence.setVisible(true);

        JButton btnShowAnswer = new JButton("Show Answer");
        btnShowAnswer.setSize(80, 30);
        btnShowAnswer.setVisible(true);

        panelButtons.add(btnPlayTune);
        panelButtons.add(btnCadence);
        panelButtons.add(btnShowAnswer);


        JPanel panelUserSelection = new JPanel();

        panelUserSelection.setLayout(new GridLayout(2, 1));

        JPanel panPanNaturals = new JPanel();
        FlowLayout mgr = new FlowLayout();
        mgr.setHgap(40);
        panPanNaturals.setLayout(mgr);

        JButton btnONE = new JButton("I");
        btnONE.setSize(70, 30);
        JButton btnTWO = new JButton("II");
        JButton btnTHREE = new JButton("III");
        JButton btnFOUR = new JButton("IV");
        JButton btnFIVE = new JButton("V");
        JButton btnSIX = new JButton("VI");
        JButton btnSEVEN = new JButton("VII");

        panPanNaturals.add(btnONE);
        panPanNaturals.add(btnTWO);
        panPanNaturals.add(btnTHREE);
        panPanNaturals.add(btnFOUR);
        panPanNaturals.add(btnFIVE);
        panPanNaturals.add(btnSIX);
        panPanNaturals.add(btnSEVEN);


        JPanel panpanAccidentals = new JPanel();
        FlowLayout mgr2 = new FlowLayout();
        mgr2.setHgap(40);
        panpanAccidentals.setLayout(mgr2);
        JButton btnFLATTWO = new JButton("bII");
        JButton btnFLATTHREE = new JButton("bIII");
        JButton btnSHARPFOUR = new JButton("#IV");
        JButton btnFLATSIX = new JButton("bVI");
        JButton btnFLATSEVEN = new JButton("bVII");

        panpanAccidentals.add(btnFLATTWO);
        panpanAccidentals.add(btnFLATTHREE);
        panpanAccidentals.add(Box.createHorizontalStrut(30));
        panpanAccidentals.add(btnSHARPFOUR);
        panpanAccidentals.add(btnFLATSIX);
        panpanAccidentals.add(btnFLATSEVEN);

        panelUserSelection.add(panPanNaturals);
        panelUserSelection.add(panpanAccidentals);

        JPanel panelBack = new JPanel();


        add(panelButtons);
        add(panelUserSelection);
        add(panelBack);

    }
}
