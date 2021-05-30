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
    private JPanel panPanAccidentals;
    private JButton btnFLATTWO;
    private JButton btnFLATTHREE;
    private JButton btnSHARPFOUR;
    private JButton btnFLATSIX;
    private JButton btnFLATSEVEN;
    private JPanel panelBack;
    private JButton btnBack;
    private SoundManager sm;
    private JPanel panelAnswerDisplay;
    private JLabel labelNoteCount;
    private JLabel labelAnswer;

    public QuizFrame() {

        // keeps track of the selected chords and the config
        sm = new SoundManager();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setVisible(true);
        setLayout(new GridLayout(4, 1));

        // first row, contains navigation buttons
        panelButtons = new JPanel();
        panelButtons.setBackground(Color.LIGHT_GRAY);
        FlowLayout mgr1 = new FlowLayout();
        mgr1.setVgap(10);
        mgr1.setHgap(20);
        panelButtons.setLayout(mgr1);

        btnPlayTune = new JButton("Play Tune");
        btnPlayTune.setSize(80, 30);
        btnPlayTune.setVisible(true);
        btnPlayTune.setHorizontalAlignment(SwingConstants.CENTER);

        btnCadence = new JButton("Play Cadence");
        btnCadence.setSize(80, 30);
        btnCadence.setVisible(true);

        btnShowAnswer = new JButton("Show Answer");
        btnShowAnswer.setSize(80, 30);
        btnShowAnswer.setVisible(true);

        panelButtons.add(btnPlayTune);
        panelButtons.add(btnCadence);
        panelButtons.add(btnShowAnswer);

        // second row, contains scaleDegreesButtons to receive user input
        // divided into 2 rows, natural notes and accidental notes
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


        panPanAccidentals = new JPanel();
        FlowLayout mgr2 = new FlowLayout();
        mgr2.setHgap(40);
        panPanAccidentals.setLayout(mgr2);
        btnFLATTWO = new JButton("bII");
        btnFLATTHREE = new JButton("bIII");
        btnSHARPFOUR = new JButton("#IV");
        btnFLATSIX = new JButton("bVI");
        btnFLATSEVEN = new JButton("bVII");

        panPanAccidentals.add(btnFLATTWO);
        panPanAccidentals.add(btnFLATTHREE);
        panPanAccidentals.add(Box.createHorizontalStrut(30));
        panPanAccidentals.add(btnSHARPFOUR);
        panPanAccidentals.add(btnFLATSIX);
        panPanAccidentals.add(btnFLATSEVEN);

        panelUserSelection.add(panPanNaturals);
        panelUserSelection.add(panPanAccidentals);

        // third row, displays user input
        panelAnswerDisplay = new JPanel();
        panelAnswerDisplay.setBackground(Color.LIGHT_GRAY);
        GridLayout mgr3 = new GridLayout(2,1);
        mgr3.setVgap(20);
        panelAnswerDisplay.setLayout(mgr3);

        labelNoteCount = new JLabel("Total notes: " + sm.getSounds().size());
        labelNoteCount.setVisible(true);
        labelNoteCount.setHorizontalAlignment(SwingConstants.CENTER);

        labelAnswer = new JLabel();
        labelAnswer.setVisible(true);
        labelAnswer.setHorizontalAlignment(SwingConstants.CENTER);

        panelAnswerDisplay.add(labelNoteCount);
        panelAnswerDisplay.add(labelAnswer);

        // fourth row, contains home button
        panelBack = new JPanel();
        btnBack = new JButton("Go Back");
        panelBack.add(btnBack);



        add(panelButtons);
        add(panelUserSelection);
        add(panelAnswerDisplay);
        add(panelBack);
        pack();

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
        boolean isAdded = false;

        Object source = actionEvent.getSource();
        if (btnPlayTune.equals(source)) {
            sm.playCurrentSound();
        } else if (btnCadence.equals(source)) {
            sm.playCadence();
        } else if (btnShowAnswer.equals(source)) {
            sm.playNewSound();
        } else if (btnONE.equals(source)) {
            isAdded = answer.addAnswer(Sound.ONE);
        } else if (btnTWO.equals(source)) {
            isAdded = answer.addAnswer(Sound.TWO);
        } else if (btnTHREE.equals(source)) {
            isAdded = answer.addAnswer(Sound.THREE);
        } else if (btnFOUR.equals(source)) {
            isAdded = answer.addAnswer(Sound.FOUR);
        } else if (btnFIVE.equals(source)) {
            isAdded = answer.addAnswer(Sound.FIVE);
        } else if (btnSIX.equals(source)) {
            isAdded = answer.addAnswer(Sound.SIX);
        } else if (btnSEVEN.equals(source)) {
            isAdded = answer.addAnswer(Sound.SEVEN);
        } else if (btnFLATTWO.equals(source)) {
            isAdded = answer.addAnswer(Sound.FLAT_TWO);
        } else if (btnFLATTHREE.equals(source)) {
            isAdded = answer.addAnswer(Sound.FLAT_THREE);
        } else if (btnSHARPFOUR.equals(source)) {
            isAdded = answer.addAnswer(Sound.SHARP_FOUR);
        } else if (btnFLATSIX.equals(source)) {
            isAdded = answer.addAnswer(Sound.FLAT_SIX);
        } else if (btnFLATSEVEN.equals(source)) {
            isAdded = answer.addAnswer(Sound.FLAT_SEVEN);
        } else if (btnBack.equals(source)) {
            new Home();
            dispose();
        }

        if(isAdded){
            labelAnswer.setText(labelAnswer.getText() + ((JButton)actionEvent.getSource()).getText() + ", ");
        }
    }
}
