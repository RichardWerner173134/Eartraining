package frame;


import components.answer.Answer;
import components.answerCorrection.NoteAnswerCorrectedValue;
import components.answerCorrection.DiatonicNoteChecker;
import model.oldStuff.Sound;
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
    private JButton btnNextTune;
    private JButton btnPlaySeparate;
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
    private Answer answer;


    public QuizFrame() {

        // keeps track of the selected chords and the config
        sm = new SoundManager();
        sm.playNewSound();

        answer = Answer.getInstance();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setVisible(true);
        setLayout(new GridLayout(4, 1));
        setResizable(false);

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

        btnPlaySeparate = new JButton("Play Separate Notes");
        btnPlaySeparate.setSize(80, 30);
        btnPlaySeparate.setVisible(true);

        btnNextTune = new JButton("Next Tune");
        btnNextTune.setSize(80, 30);
        btnNextTune.setVisible(true);

        panelButtons.add(btnPlayTune);
        panelButtons.add(btnCadence);
        panelButtons.add(btnPlaySeparate);
        panelButtons.add(btnNextTune);

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
        btnNextTune.addActionListener(this);
        btnPlaySeparate.addActionListener(this);
        btnBack.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean isAdded = false;

        Object source = actionEvent.getSource();
        if (btnPlayTune.equals(source)) {
            sm.playCurrentSound();
        } else if (btnCadence.equals(source)) {
            sm.playCadence();
        } else if (btnNextTune.equals(source)) {
            sm.playNewSound();
            answer.resetAnwer();
            labelAnswer.setText("");
        } else if(btnPlaySeparate.equals(source)){
            sm.playSoundSeparately();
        } else if (btnONE.equals(source)) {
            Sound I = new Sound(1, 'n');
            answer.addAnswer(I);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + I.toString() + ", ");
        } else if (btnTWO.equals(source)) {
            Sound II = new Sound(2, 'n');
            answer.addAnswer(II);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + II.toString() + ", ");
        } else if (btnTHREE.equals(source)) {
            Sound III = new Sound(3, 'n');
            answer.addAnswer(III);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + III.toString() + ", ");
        } else if (btnFOUR.equals(source)) {
            Sound IV = new Sound(4, 'n');
            answer.addAnswer(IV);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + IV.toString() + ", ");
        } else if (btnFIVE.equals(source)) {
            Sound V = new Sound(5, 'n');
            answer.addAnswer(V);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + V.toString() + ", ");
        } else if (btnSIX.equals(source)) {
            Sound VI = new Sound(6, 'n');
            answer.addAnswer(VI);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + VI.toString() + ", ");
        } else if (btnSEVEN.equals(source)) {
            Sound VII = new Sound(7, 'n');
            answer.addAnswer(VII);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + VII.toString() + ", ");
        } else if (btnFLATTWO.equals(source)) {
            Sound IIb = new Sound(2, 'b');
            answer.addAnswer(IIb);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + IIb.toString() + ", ");
        } else if (btnFLATTHREE.equals(source)) {
            Sound IIIb = new Sound(3, 'b');
            answer.addAnswer(IIIb);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + IIIb.toString() + ", ");
        } else if (btnSHARPFOUR.equals(source)) {
            Sound IVSHARP = new Sound(4, '#');
            answer.addAnswer(IVSHARP);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + IVSHARP.toString() + ", ");
        } else if (btnFLATSIX.equals(source)) {
            Sound VIb = new Sound(6, 'b');
            answer.addAnswer(VIb);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + VIb.toString() + ", ");
        } else if (btnFLATSEVEN.equals(source)) {
            Sound VIIb = new Sound(7, 'b');
            answer.addAnswer(VIIb);
            isAdded = true;
            labelAnswer.setText(labelAnswer.getText() + VIIb.toString() + ", ");
        } else if (btnBack.equals(source)) {
            new Home();
            dispose();
        }

        if(isAdded){
            if(answer.getAnswerObjects().size() == sm.getNotes().size()){
                List<NoteAnswerCorrectedValue> correctedValues = DiatonicNoteChecker.checkQuestion(sm.getNotes(), answer);
                answer.resetAnwer();
                labelAnswer.setText("");
                correctionOutput(correctedValues);
            }
        }
    }

    private void correctionOutput(List<NoteAnswerCorrectedValue> correctedValues) {
        StringBuilder sb = new StringBuilder();

        sb.append("Played notes:\n");
        sb.append("--------------------------------------------\n");

        correctedValues.stream()
                .filter(x -> x.getCountCorrect() > 0)
                .forEach(x -> {
                    for(int i = 0; i < x.getCountCorrect(); i++) {
                        sb.append(x.getCorrectedSound().toString()).append("\n");
                    }
                });

        sb.append("--------------------------------------------\n");
        sb.append("Missing notes in answer:\n");

        correctedValues.stream()
                .filter(x -> x.getCountCorrect() - x.getCountAnswer() > 0)
                .forEach(x -> {
                    for(int i = 0; i < x.getCountCorrect() - x.getCountAnswer(); i++) {
                        sb.append(x.getCorrectedSound().toString()).append("\n");
                    }
                });

        sb.append("--------------------------------------------\n");
        sb.append("Wrong submitted notes:\n");

        correctedValues.stream()
                .filter(x -> x.getCountCorrect() - x.getCountAnswer() < 0)
                .forEach(x -> {
                    for(int i = 0; i < x.getCountAnswer() - x.getCountCorrect(); i++){
                        sb.append(x.getCorrectedSound().toString()).append("\n");
                    }
                });

        Object stringArray[] = {"Next", "Listen again"};
        int checking_answer = JOptionPane.showOptionDialog(this,
                sb.toString(),
                "Checking Answer",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                stringArray,
                stringArray[0]
        );

        if (checking_answer == 0){
            sm.playNewSound();
        }
    }


}
