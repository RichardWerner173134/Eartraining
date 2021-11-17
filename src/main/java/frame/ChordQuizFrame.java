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
    private JButton btnShowAnswer;
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

    private JPanel panelBack;
    private JButton btnBack;

    private SoundManager sm;
    private Answer<ChordType> answer;

    public ChordQuizFrame() throws HeadlessException {
        // keeps track of the selected chords and the config
        sm = new SoundManager();
        answer = Answer.getInstance();

        sm.playCurrentChord();

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

        btnPlaySeparate = new JButton("Play Separate Notes");
        btnPlaySeparate.setSize(80, 30);
        btnPlaySeparate.setVisible(true);

        btnShowAnswer = new JButton("Next Tune");
        btnShowAnswer.setSize(80, 30);
        btnShowAnswer.setVisible(true);

        panelButtons.add(btnPlayTune);
        panelButtons.add(btnPlaySeparate);
        panelButtons.add(btnShowAnswer);

        panelUserSelection = new JPanel();
        panelUserSelection.setLayout(new GridLayout(2, 1));

        panTriads = new JPanel();
        FlowLayout mgr = new FlowLayout();
        mgr.setHgap(40);
        panTriads.setLayout(mgr);

        panSeventh = new JPanel();
        panSeventh.setLayout(mgr);

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

        panelUserSelection.add(panTriads);
        panelUserSelection.add(panSeventh);

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

        btnPlayTune.addActionListener(this);
        btnShowAnswer.addActionListener(this);
        btnBack.addActionListener(this);
        btnPlaySeparate.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean isAdded = false;

        Object source = actionEvent.getSource();
        if (btnPlayTune.equals(source)) {
            sm.playCurrentChord();
        } else if (btnShowAnswer.equals(source)) {
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
        }

        ChordAnswerCorrectedValue chordAnswerCorrectedValue = null;
        if(isAdded){
            try {
                chordAnswerCorrectedValue = ChordChecker.checkQuestion(sm.getChordPicker().getCurrentChord().getChordType(), answer);
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
        if(!correctedValues.isCorrect()) {
            sb.append("\n");
            sb.append("Submitted Chordtype:  ");
            sb.append(correctedValues.getSubmittedChordType());
        }


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
