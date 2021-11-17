package frame;

import components.SoundManager;
import components.chordpicker.FullyRandomChordPicker;
import components.chordpicker.IChordPicker;
import model.conceptOfChords.Chord;

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
    private IChordPicker chordPicker;

    public ChordQuizFrame() throws HeadlessException {
        // keeps track of the selected chords and the config
        sm = new SoundManager();
        chordPicker = new FullyRandomChordPicker();

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(btnShowAnswer.equals(source)){
            Chord chord = chordPicker.pickChord();
            sm.playChord(chord);
        }
    }
}
