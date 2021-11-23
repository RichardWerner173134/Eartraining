package frame;

import components.SoundManager;
import components.answer.Answer;
import components.answerCorrection.ChordAnswerCorrectedValue;
import components.answerCorrection.ChordChecker;
import model.conceptOfChords.ChordType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChordQuizFrame extends JFrame implements ActionListener {
    private JPanel panelButtons;
    private JButton btnPlayTune;
    private JButton btnNextTune;
    private JButton btnPlaySeparate;
    private JPanel panelUserSelection;

    private JPanel panTriads;

    private JButton btnMajTriad;
    private JButton btnMinTriad;
    private JButton btnDimTriad;
    private JButton btnAugTriad;

    private JPanel panSeventh;

    private JButton btnMaj7;
    private JButton btnMin7;
    private JButton btnDom7;
    private JButton btnHalfDim7;
    private JButton btnFullyDim7;
    private JButton btnMinMaj7;

    private JPanel panCrazyJazzChords;

    private JButton btnMaj9;
    private JButton btnMin9;
    private JButton btnDom9b9;
    private JButton btnDomS9;
    private JButton btnDom11S11;

    private JPanel panelBack;
    private JButton btnBack;

    private SoundManager sm;
    private Answer<ChordType> answer;

    public ChordQuizFrame() {
        // keeps track of the selected chords and the config
        sm = new SoundManager();
        answer = Answer.getInstance();

        sm.playNewChord();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setVisible(true);
        setLayout(new GridLayout(3, 1));
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

        btnPlaySeparate = new JButton("Play Separate Notes");
        btnPlaySeparate.setSize(80, 30);
        btnPlaySeparate.setVisible(true);

        btnNextTune = new JButton("Next Tune");
        btnNextTune.setSize(80, 30);
        btnNextTune.setVisible(true);

        panelButtons.add(btnPlayTune);
        panelButtons.add(btnPlaySeparate);
        panelButtons.add(btnNextTune);

        panelUserSelection = new JPanel();
        panelUserSelection.setLayout(new GridLayout(3, 1));

        FlowLayout mgr = new FlowLayout();
        mgr.setHgap(40);

        panTriads = new JPanel();
        panTriads.setLayout(mgr);

        panSeventh = new JPanel();
        panSeventh.setLayout(mgr);

        panCrazyJazzChords = new JPanel();
        panCrazyJazzChords.setLayout(mgr);

        btnMajTriad = new JButton("Maj");
        btnMinTriad = new JButton("Min");
        btnAugTriad = new JButton("Aug");
        btnDimTriad = new JButton("Dim");

        btnMaj7 = new JButton("Maj7");
        btnMin7 = new JButton("Min7");
        btnDom7 = new JButton("Dom7");
        btnHalfDim7 = new JButton("Min7b5");
        btnFullyDim7 = new JButton("Dim7");
        btnMinMaj7 = new JButton("MinMaj7");

        btnMaj9 = new JButton("Maj9");
        btnMin9 = new JButton("Min9");
        btnDom9b9 = new JButton("Dom7b9");
        btnDomS9 = new JButton("Dom7#9");
        btnDom11S11 = new JButton("Dom9#11");

        panTriads.add(btnMajTriad);
        panTriads.add(btnMinTriad);
        panTriads.add(btnAugTriad);
        panTriads.add(btnDimTriad);

        panSeventh.add(btnMaj7);
        panSeventh.add(btnMin7);
        panSeventh.add(btnDom7);
        panSeventh.add(btnHalfDim7);
        panSeventh.add(btnFullyDim7);
        panSeventh.add(btnMinMaj7);

        panCrazyJazzChords.add(btnMaj9);
        panCrazyJazzChords.add(btnMin9);
        panCrazyJazzChords.add(btnDom9b9);
        panCrazyJazzChords.add(btnDomS9);
        panCrazyJazzChords.add(btnDom11S11);

        panelUserSelection.add(panTriads);
        panelUserSelection.add(panSeventh);
        panelUserSelection.add(panCrazyJazzChords);

        // fourth row, contains home button
        panelBack = new JPanel();
        btnBack = new JButton("Go Back");
        panelBack.add(btnBack);

        add(panelButtons);
        add(panelUserSelection);
        add(panelBack);
        pack();

        btnMajTriad.addActionListener(this);
        btnMinTriad.addActionListener(this);
        btnAugTriad.addActionListener(this);
        btnDimTriad.addActionListener(this);
        btnMaj7.addActionListener(this);
        btnMin7.addActionListener(this);
        btnDom7.addActionListener(this);
        btnHalfDim7.addActionListener(this);
        btnFullyDim7.addActionListener(this);
        btnMinMaj7.addActionListener(this);
        btnMaj9.addActionListener(this);
        btnMin9.addActionListener(this);
        btnDom9b9.addActionListener(this);
        btnDomS9.addActionListener(this);
        btnDom11S11.addActionListener(this);

        btnPlayTune.addActionListener(this);
        btnNextTune.addActionListener(this);
        btnBack.addActionListener(this);
        btnPlaySeparate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean isAdded = false;

        Object source = actionEvent.getSource();
        if (btnPlayTune.equals(source)) {
            sm.playCurrentChord();
        } else if (btnNextTune.equals(source)) {
            sm.playNewChord();
            answer.resetAnwer();
        } else if(btnPlaySeparate.equals(source)){
            sm.playChordSeparately();
        } else if(btnMajTriad.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.MAJOR);
        } else if(btnMinTriad.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.MINOR);
        } else if(btnMaj7.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.MAJOR_SEVENTH);
        } else if(btnMin7.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.MINOR_SEVENTH);
        } else if(btnDom7.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.DOMINANT_SEVENTH);
        } else if(btnHalfDim7.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.HALF_DIMINISHED_SEVENTH);
        } else if(btnFullyDim7.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.FULLY_DIMINISHED_SEVEN);
        } else if(btnMinMaj7.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.MINOR_MAJOR_SEVENTH);
        }  else if(btnAugTriad.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.AUGMENTED);
        } else if(btnDimTriad.equals(source)) {
            isAdded = true;
            answer.addAnswer(ChordType.DIMINISHED);
        } else if(btnMaj9.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.MAJOR_NINTH);
        } else if(btnMin9.equals(source)){
            isAdded = true;answer.addAnswer(ChordType.MINOR_NINTH);
        } else if(btnDom9b9.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.DOMINANT_NINTH_FLAT_NINTH);
        } else if(btnDomS9.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.DOMINANT_NINTH_SHARP_NINTH);
        } else if(btnDom11S11.equals(source)){
            isAdded = true;
            answer.addAnswer(ChordType.DOMINANT_ELEVENTH_SHARP_ELEVEN);
        } else if (btnBack.equals(source)) {
            new Home();
            dispose();
        }

        ChordAnswerCorrectedValue chordAnswerCorrectedValue = null;
        if(isAdded){
            try {
                chordAnswerCorrectedValue = ChordChecker.checkQuestion(sm.getChordPicker().getCurrentChord().getChordType(), sm.getChordPicker().getCurrentVoicing(), answer);
                correctionOutput(chordAnswerCorrectedValue);
                answer.resetAnwer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void correctionOutput(ChordAnswerCorrectedValue correctedValues){
        StringBuilder sb = new StringBuilder();

        sb.append(correctedValues.isCorrect() ? "Correct\n" : "Wrong\n");

        sb.append("--------------------------------------------\n");
        sb.append("Played Chordtype:  ");
        sb.append(correctedValues.getActualChordType());
        sb.append("\n");
        if(!correctedValues.isCorrect()) {
            sb.append("Submitted Chordtype:  ");
            sb.append(correctedValues.getSubmittedChordType());
            sb.append("\n");
        }

        sb.append("Played Voicing: ");
        sb.append(correctedValues.getPlayedVoicing().toString());


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
            sm.playNewChord();
        }
    }
}
