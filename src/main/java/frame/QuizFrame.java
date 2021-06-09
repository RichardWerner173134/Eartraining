package frame;


import components.Answer;
import components.QuestionChecker;
import components.Sound;
import components.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private JPanel panelAnswerDisplay;
    private JLabel labelNoteCount;
    private JLabel labelAnswer;
    private SoundManager sm;


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

        btnShowAnswer = new JButton("Next Tune");
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

        labelNoteCount = new JLabel("Total notes: " + sm.getNotes().size());
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
            isAdded = answer.addAnswer(new Sound(1, 'n'));
        } else if (btnTWO.equals(source)) {
            isAdded = answer.addAnswer(new Sound(2, 'n'));
        } else if (btnTHREE.equals(source)) {
            isAdded = answer.addAnswer(new Sound(3, 'n'));
        } else if (btnFOUR.equals(source)) {
            isAdded = answer.addAnswer(new Sound(4, 'n'));
        } else if (btnFIVE.equals(source)) {
            isAdded = answer.addAnswer(new Sound(5, 'n'));
        } else if (btnSIX.equals(source)) {
            isAdded = answer.addAnswer(new Sound(6, 'n'));
        } else if (btnSEVEN.equals(source)) {
            isAdded = answer.addAnswer(new Sound(7, 'n'));
        } else if (btnFLATTWO.equals(source)) {
            isAdded = answer.addAnswer(new Sound(2, 'b'));
        } else if (btnFLATTHREE.equals(source)) {
            isAdded = answer.addAnswer(new Sound(3, 'b'));
        } else if (btnSHARPFOUR.equals(source)) {
            isAdded = answer.addAnswer(new Sound(4, '#'));
        } else if (btnFLATSIX.equals(source)) {
            isAdded = answer.addAnswer(new Sound(6, 'b'));
        } else if (btnFLATSEVEN.equals(source)) {
            isAdded = answer.addAnswer(new Sound(7, 'b'));
        } else if (btnBack.equals(source)) {
            new Home();
            dispose();
        }

        if(isAdded){
            labelAnswer.setText(labelAnswer.getText() + ((JButton)actionEvent.getSource()).getText() + ", ");

            if(answer.getSounds().size() == sm.getNotes().size()){
                List<QuestionChecker.CorrectedValue> correctedValues = QuestionChecker.checkQuestion(sm.getNotes(), answer);
                correctionOutput(correctedValues);
                Answer.resetAnswer();
                labelAnswer.setText("");
            }
        }
    }

    private void correctionOutput(List<QuestionChecker.CorrectedValue> correctedValues) {
        StringBuilder sb = new StringBuilder();
        correctedValues
                .forEach(correctedValue -> {
                    String isCorrect = correctedValue.isCorrect() ? "correct" : "wrong";
                    String acc = correctedValue.getAnswerSound().getAccidental() == 'n' ? "" :
                            correctedValue.getAnswerSound().getAccidental() == 'b' ? "b" : "#";
                    String cMajSound = getScaleDegreeRoman(correctedValue);

                    sb.append(cMajSound)
                            .append(acc)
                            .append(" ----------- ")
                            .append(isCorrect)
                            .append("\n");
                });
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private String getScaleDegreeRoman(QuestionChecker.CorrectedValue correctedValue) {
        return correctedValue.getAnswerSound().getScaleDegree() == 1 ? "I" :
                correctedValue.getAnswerSound().getScaleDegree() == 2 ? "II" :
                        correctedValue.getAnswerSound().getScaleDegree() == 3 ? "III" :
                                correctedValue.getAnswerSound().getScaleDegree() == 4 ? "IV" :
                                        correctedValue.getAnswerSound().getScaleDegree() == 5 ? "V" :
                                                correctedValue.getAnswerSound().getScaleDegree() == 6 ? "VI" : "VII";
    }
}
