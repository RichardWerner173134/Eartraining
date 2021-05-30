package frame;


import components.Answer;
import components.Sound;
import components.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizFrame extends JFrame implements ActionListener {
        private JPanel panelButtons;
        private JButton btnPlayTune;
        private JButton btnCadence;
        private JButton btnShowAnswer;
        private JPanel panelUserSelection;
        private JPanel panPanNaturals;
        private JButton btnONE;
        private JButton btnTWO;
        private JButton btnTHREE;
        private JButton btnFOUR;
        private JButton btnFIVE;
        private JButton btnSIX;
        private JButton btnSEVEN;
        private JPanel panpanAccidentals;
        private JButton btnFLATTWO;
        private JButton btnFLATTHREE;
        private JButton btnSHARPFOUR;
        private JButton btnFLATSIX;
        private JButton btnFLATSEVEN;
        private JPanel panelBack;
        private JButton btnBack;
        private SoundManager sm;

    public QuizFrame() {

        sm = new SoundManager();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setVisible(true);
        setLayout(new GridLayout(3, 1));


        panelButtons = new JPanel();
        FlowLayout mgr1 = new FlowLayout();
        mgr1.setVgap(60);
        mgr1.setHgap(30);
        panelButtons.setLayout(mgr1);

        btnPlayTune = new JButton("Play Tune");
        btnPlayTune.setSize(80, 30);
        btnPlayTune.setVisible(true);

        btnCadence = new JButton("Play Cadence");
        btnCadence.setSize(80, 30);
        btnCadence.setVisible(true);

        btnShowAnswer = new JButton("Show Answer");
        btnShowAnswer.setSize(80, 30);
        btnShowAnswer.setVisible(true);

        panelButtons.add(btnPlayTune);
        panelButtons.add(btnCadence);
        panelButtons.add(btnShowAnswer);


        panelUserSelection = new JPanel();

        panelUserSelection.setLayout(new GridLayout(2, 1));

        panPanNaturals = new JPanel();
        FlowLayout mgr = new FlowLayout();
        mgr.setHgap(40);
        panPanNaturals.setLayout(mgr);

        btnONE = new JButton("I");
        btnONE.setSize(70, 30);
        btnTWO = new JButton("II");
        btnTHREE = new JButton("III");
        btnFOUR = new JButton("IV");
        btnFIVE = new JButton("V");
        btnSIX = new JButton("VI");
        btnSEVEN = new JButton("VII");

        panPanNaturals.add(btnONE);
        panPanNaturals.add(btnTWO);
        panPanNaturals.add(btnTHREE);
        panPanNaturals.add(btnFOUR);
        panPanNaturals.add(btnFIVE);
        panPanNaturals.add(btnSIX);
        panPanNaturals.add(btnSEVEN);


        panpanAccidentals = new JPanel();
        FlowLayout mgr2 = new FlowLayout();
        mgr2.setHgap(40);
        panpanAccidentals.setLayout(mgr2);
        btnFLATTWO = new JButton("bII");
        btnFLATTHREE = new JButton("bIII");
        btnSHARPFOUR = new JButton("#IV");
        btnFLATSIX = new JButton("bVI");
        btnFLATSEVEN = new JButton("bVII");

        panpanAccidentals.add(btnFLATTWO);
        panpanAccidentals.add(btnFLATTHREE);
        panpanAccidentals.add(Box.createHorizontalStrut(30));
        panpanAccidentals.add(btnSHARPFOUR);
        panpanAccidentals.add(btnFLATSIX);
        panpanAccidentals.add(btnFLATSEVEN);

        panelUserSelection.add(panPanNaturals);
        panelUserSelection.add(panpanAccidentals);

        panelBack = new JPanel();
        btnBack = new JButton("Go Back");
        panelBack.add(btnBack);

        add(panelButtons);
        add(panelUserSelection);
        add(panelBack);

        btnONE.addActionListener(this);
        btnTWO.addActionListener(this);
        btnTHREE.addActionListener(this);
        btnFOUR.addActionListener(this);
        btnFIVE.addActionListener(this);
        btnSIX.addActionListener(this);
        btnSEVEN.addActionListener(this);
        btnFLATTWO.addActionListener(this);
        btnFLATTHREE.addActionListener(this);
        btnSHARPFOUR.addActionListener(this);
        btnFLATSIX.addActionListener(this);
        btnFLATSEVEN.addActionListener(this);
        btnPlayTune.addActionListener(this);
        btnCadence.addActionListener(this);
        btnShowAnswer.addActionListener(this);
        btnBack.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Answer answer = Answer.getInstance();

        Object source = actionEvent.getSource();
        if (btnPlayTune.equals(source)) {
            sm.playCurrentSound();
        } else if (btnCadence.equals(source)) {
            sm.playCadence();
        } else if (btnShowAnswer.equals(source)) {
            // show answer
            sm.playNewSound();
        } else if (btnONE.equals(source)) {
            answer.addAnswer(Sound.ONE);
        } else if (btnTWO.equals(source)) {
            answer.addAnswer(Sound.TWO);
        } else if (btnTHREE.equals(source)) {
            answer.addAnswer(Sound.THREE);
        } else if (btnFOUR.equals(source)) {
            answer.addAnswer(Sound.FOUR);
        } else if (btnFIVE.equals(source)) {
            answer.addAnswer(Sound.FIVE);
        } else if (btnSIX.equals(source)) {
            answer.addAnswer(Sound.SIX);
        } else if (btnSEVEN.equals(source)) {
            answer.addAnswer(Sound.SEVEN);
        } else if (btnFLATTWO.equals(source)) {
            answer.addAnswer(Sound.FLAT_TWO);
        } else if (btnFLATTHREE.equals(source)) {
            answer.addAnswer(Sound.FLAT_THREE);
        } else if (btnSHARPFOUR.equals(source)) {
            answer.addAnswer(Sound.SHARP_FOUR);
        } else if (btnFLATSIX.equals(source)) {
            answer.addAnswer(Sound.FLAT_SIX);
        } else if (btnFLATSEVEN.equals(source)) {
            answer.addAnswer(Sound.FLAT_SEVEN);
        } else if (btnBack.equals(source)) {
            new Home();
            dispose();
        }
    }
}
