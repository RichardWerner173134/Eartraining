package frame;

import components.Config;
import components.Config.ScaleDegreeMix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsFrame extends JFrame implements ActionListener{
    private ButtonGroup buttonGroupScaleDegreeMix;
    private ButtonGroup buttonGroupNumberOfNotes;
    private ButtonGroup buttonGroupNumberOfOctaves;
    private ButtonGroup buttonGroupChordMix;

    private JRadioButton jCheckBoxALLDIATONIC;
    private JRadioButton jCheckBoxChromatic;
    private JRadioButton jCheckBoxOneThreeFourFive;

    private JRadioButton jCheckBoxOne;
    private JRadioButton jCheckBoxTwo;
    private JRadioButton jCheckBoxThree;
    private JRadioButton jCheckBoxFour;
    private JRadioButton jCheckBoxFive;

    private JRadioButton jCheckBoxAllChords;
    private JRadioButton jCheckBoxTriads;
    private JRadioButton jCheckboxSevenths;

    private JRadioButton jRadioButtonOct1, jRadioButtonOct2, jRadioButtonOct3;

    private JButton buttonBack;

    public OptionsFrame(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setSize(new Dimension(400, 200));
        setVisible(true);
        setResizable(false);

        buttonGroupScaleDegreeMix = new ButtonGroup();
        buttonGroupNumberOfNotes = new ButtonGroup();
        buttonGroupNumberOfOctaves = new ButtonGroup();

        buttonGroupChordMix = new ButtonGroup();

        // init ScaleDegreeMix
        jCheckBoxALLDIATONIC = new JRadioButton("Diatonic");
        jCheckBoxChromatic = new JRadioButton("Chromatic");
        jCheckBoxOneThreeFourFive = new JRadioButton("One,Three,Four,Five");

        buttonGroupScaleDegreeMix.add(jCheckBoxALLDIATONIC);
        buttonGroupScaleDegreeMix.add(jCheckBoxChromatic);
        buttonGroupScaleDegreeMix.add(jCheckBoxOneThreeFourFive);

        jCheckBoxOneThreeFourFive.addActionListener(this);
        jCheckBoxALLDIATONIC.addActionListener(this);
        jCheckBoxChromatic.addActionListener(this);

        // init NumberOfNotes Option JRadioButton
        jCheckBoxOne = new JRadioButton("1");
        jCheckBoxTwo = new JRadioButton("2");
        jCheckBoxThree = new JRadioButton("3");
        jCheckBoxFour = new JRadioButton("4");
        jCheckBoxFive = new JRadioButton("5");

        jCheckBoxOne.addActionListener(this);
        jCheckBoxTwo.addActionListener(this);
        jCheckBoxThree.addActionListener(this);
        jCheckBoxFour.addActionListener(this);
        jCheckBoxFive.addActionListener(this);

        buttonGroupNumberOfNotes.add(jCheckBoxOne);
        buttonGroupNumberOfNotes.add(jCheckBoxTwo);
        buttonGroupNumberOfNotes.add(jCheckBoxThree);
        buttonGroupNumberOfNotes.add(jCheckBoxFour);
        buttonGroupNumberOfNotes.add(jCheckBoxFive);

        // init ChordMix Option
        jCheckBoxAllChords = new JRadioButton("All Chords");
        jCheckBoxTriads = new JRadioButton("Triads");
        jCheckboxSevenths = new JRadioButton("Sevenths");

        jCheckBoxAllChords.addActionListener(this);
        jCheckBoxTriads.addActionListener(this);
        jCheckboxSevenths.addActionListener(this);

        buttonGroupChordMix.add(jCheckBoxAllChords);
        buttonGroupChordMix.add(jCheckBoxTriads);
        buttonGroupChordMix.add(jCheckboxSevenths);

        // init Back Button
        buttonBack = new JButton("Go Back");
        buttonBack.addActionListener(this);

        // init Number of Octaves Option
        jRadioButtonOct1 = new JRadioButton("1");
        jRadioButtonOct2 = new JRadioButton("2");
        jRadioButtonOct3 = new JRadioButton("3");

        jRadioButtonOct1.addActionListener(this);
        jRadioButtonOct2.addActionListener(this);
        jRadioButtonOct3.addActionListener(this);

        buttonGroupNumberOfOctaves.add(jRadioButtonOct1);
        buttonGroupNumberOfOctaves.add(jRadioButtonOct2);
        buttonGroupNumberOfOctaves.add(jRadioButtonOct3);

        // add ScaleDegreeMix Buttons to panel
        JPanel panelScaleDegreeMix = new JPanel();

        JLabel jHeaderScaleDegreeMix = new JLabel("Select the Scale Degree which should be played");
        GridBagLayout gblScaleDegreeMix = new GridBagLayout();
        GridBagConstraints gbcScaleDegree;

        gbcScaleDegree = getGbc(0, 0, 1, 1, 0, GridBagConstraints.WEST);
        gblScaleDegreeMix.setConstraints(jHeaderScaleDegreeMix, gbcScaleDegree);
        gbcScaleDegree = getGbc(0, 1, 1, 1, 0, GridBagConstraints.WEST);
        gblScaleDegreeMix.setConstraints(jCheckBoxOneThreeFourFive, gbcScaleDegree);
        gbcScaleDegree = getGbc(0, 2, 1, 1, 0, GridBagConstraints.WEST);
        gblScaleDegreeMix.setConstraints(jCheckBoxALLDIATONIC, gbcScaleDegree);
        gbcScaleDegree = getGbc(0, 3, 1, 1, 0, GridBagConstraints.WEST);
        gblScaleDegreeMix.setConstraints(jCheckBoxChromatic, gbcScaleDegree);

        panelScaleDegreeMix.setPreferredSize(new Dimension(350, 150));
        panelScaleDegreeMix.setLayout(gblScaleDegreeMix);
        panelScaleDegreeMix.add(jHeaderScaleDegreeMix);
        panelScaleDegreeMix.add(jCheckBoxOneThreeFourFive);
        panelScaleDegreeMix.add(jCheckBoxALLDIATONIC);
        panelScaleDegreeMix.add(jCheckBoxChromatic);

        // add NumberOfNotes Buttons to panel
        JPanel panelNumberOfNotes = new JPanel();

        JLabel jHeaderNumberOfNotes = new JLabel("Select how many notes should be played at the same time");
        GridBagLayout gblNumberOfNotes = new GridBagLayout();
        GridBagConstraints gbcNumberOfNotes;

        gbcNumberOfNotes = getGbc(0, 0, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfNotes.setConstraints(jHeaderNumberOfNotes, gbcNumberOfNotes);

        gbcNumberOfNotes = getGbc(0, 1, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfNotes.setConstraints(jCheckBoxOne, gbcNumberOfNotes);

        gbcNumberOfNotes = getGbc(0, 2, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfNotes.setConstraints(jCheckBoxTwo, gbcNumberOfNotes);

        gbcNumberOfNotes = getGbc(0, 3, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfNotes.setConstraints(jCheckBoxThree, gbcNumberOfNotes);

        gbcNumberOfNotes = getGbc(0, 4, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfNotes.setConstraints(jCheckBoxFour, gbcNumberOfNotes);

        gbcNumberOfNotes = getGbc(0, 5, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfNotes.setConstraints(jCheckBoxFive, gbcNumberOfNotes);

        panelNumberOfNotes.setPreferredSize(new Dimension(350, 150));
        panelNumberOfNotes.setLayout(gblNumberOfNotes);
        panelNumberOfNotes.add(jHeaderNumberOfNotes);
        panelNumberOfNotes.add(jCheckBoxOne);
        panelNumberOfNotes.add(jCheckBoxTwo);
        panelNumberOfNotes.add(jCheckBoxThree);
        panelNumberOfNotes.add(jCheckBoxFour);
        panelNumberOfNotes.add(jCheckBoxFive);

        // add NumberOfOctaves Buttons to panel
        JPanel panelNumberOfOctaves = new JPanel();

        JLabel jHeaderNumberOfOctaves = new JLabel("Range of used octaves: ");
        GridBagLayout gblNumberOfOctaves = new GridBagLayout();
        GridBagConstraints gbcNumberOfOctaves;

        gbcNumberOfOctaves = getGbc(0, 0, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfOctaves.setConstraints(jHeaderNumberOfOctaves, gbcNumberOfOctaves);

        gbcNumberOfOctaves = getGbc(0, 1, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfOctaves.setConstraints(jRadioButtonOct1, gbcNumberOfOctaves);

        gbcNumberOfOctaves = getGbc(0, 2, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfOctaves.setConstraints(jRadioButtonOct2, gbcNumberOfOctaves);

        gbcNumberOfOctaves = getGbc(0, 3, 1, 1, 0, GridBagConstraints.WEST);
        gblNumberOfOctaves.setConstraints(jRadioButtonOct3, gbcNumberOfOctaves);


        panelNumberOfOctaves.setPreferredSize(new Dimension(350, 150));
        panelNumberOfOctaves.setLayout(gblNumberOfOctaves);
        panelNumberOfOctaves.add(jHeaderNumberOfOctaves);
        panelNumberOfOctaves.add(jRadioButtonOct1);
        panelNumberOfOctaves.add(jRadioButtonOct2);
        panelNumberOfOctaves.add(jRadioButtonOct3);

        // add ChordMix Buttons to Panel
        JPanel panelChordMix = new JPanel();

        JLabel lHeaderChordMix = new JLabel("Chord-Mix");
        GridBagLayout gblChordMix = new GridBagLayout();
        GridBagConstraints bgcChordMix = new GridBagConstraints();

        bgcChordMix = getGbc(0, 0, 1, 1, 0, GridBagConstraints.WEST);
        gblChordMix.setConstraints(lHeaderChordMix, bgcChordMix);
        bgcChordMix = getGbc(0, 1, 1, 1, 0, GridBagConstraints.WEST);
        gblChordMix.setConstraints(jCheckBoxAllChords, bgcChordMix);
        bgcChordMix = getGbc(0, 2, 1, 1, 0, GridBagConstraints.WEST);
        gblChordMix.setConstraints(jCheckBoxTriads, bgcChordMix);
        bgcChordMix = getGbc(0, 3, 1, 1, 0, GridBagConstraints.WEST);
        gblChordMix.setConstraints(jCheckboxSevenths, bgcChordMix);

        panelChordMix.setPreferredSize(new Dimension(350, 150));
        panelChordMix.setLayout(gblChordMix);
        panelChordMix.add(lHeaderChordMix);
        panelChordMix.add(jCheckBoxAllChords);
        panelChordMix.add(jCheckBoxTriads);
        panelChordMix.add(jCheckboxSevenths);

        // add backButton to Panel
        JPanel panelBackButton = new JPanel();
        panelBackButton.setMaximumSize(new Dimension(panelBackButton.getWidth(), 40));
        panelBackButton.setLayout(new GridLayout(1, 1));
        panelBackButton.add(buttonBack);

        // topLevel Frame
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc;

        gbc = getGbc(0, 0, 1, 1, 0, GridBagConstraints.WEST);
        gbl.setConstraints(panelNumberOfNotes, gbc);

        gbc = getGbc(0, 1, 1, 1, 0, GridBagConstraints.WEST);
        gbl.setConstraints(panelNumberOfOctaves, gbc);

        gbc = getGbc(0, 2, 1, 1, 0, GridBagConstraints.WEST);
        gbl.setConstraints(panelScaleDegreeMix, gbc);

        gbc = getGbc(0, 3, 1, 1, 0, GridBagConstraints.WEST);
        gbl.setConstraints(panelChordMix, gbc);

        gbc = getGbc(0, 4, 1, 1, 0, GridBagConstraints.NORTH);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(panelBackButton, gbc);

        setLayout(gbl);

        // add panels to Frame
        add(panelNumberOfNotes);
        add(panelNumberOfOctaves);
        add(panelScaleDegreeMix);
        add(panelChordMix);
        add(panelBackButton);
        pack();

        Config config = Config.getInstance();

        switch(config.getNumberOfNotes()){
            case ONE:
                buttonGroupNumberOfNotes.clearSelection();
                jCheckBoxOne.setSelected(true);
                break;
            case TWO:
                buttonGroupNumberOfNotes.clearSelection();
                jCheckBoxTwo.setSelected(true);
                break;
            case THREE:
                buttonGroupNumberOfNotes.clearSelection();
                jCheckBoxThree.setSelected(true);
                break;
            case FOUR:
                buttonGroupNumberOfNotes.clearSelection();
                jCheckBoxFour.setSelected(true);
                break;
            case FIVE:
                buttonGroupNumberOfNotes.clearSelection();
                jCheckBoxFive.setSelected(true);
                break;
        }

        switch(config.getScaleDegreeMix()){
            case ONE_TWO_THREE_FOUR_FIVE:
                buttonGroupScaleDegreeMix.clearSelection();
                jCheckBoxOneThreeFourFive.setSelected(true);
                break;
            case ALL_DIATONIC:
                buttonGroupScaleDegreeMix.clearSelection();
                jCheckBoxALLDIATONIC.setSelected(true);
                break;
            case CHROMATIC:
                buttonGroupScaleDegreeMix.clearSelection();
                jCheckBoxChromatic.setSelected(true);
                break;
        }

        switch(config.getNumberOfOctaves()){
            case ONE_OCTAVE:
                buttonGroupNumberOfOctaves.clearSelection();
                jRadioButtonOct1.setSelected(true);
                break;
            case TWO_OCTAVES:
                buttonGroupNumberOfOctaves.clearSelection();
                jRadioButtonOct2.setSelected(true);
                break;
            case THREE_OCTAVES:
                buttonGroupNumberOfOctaves.clearSelection();
                jRadioButtonOct3.setSelected(true);
                break;
        }

        switch(config.getChordMix()){
            case ALL_CHORDS:
                buttonGroupChordMix.clearSelection();
                jCheckBoxAllChords.setSelected(true);
                break;
            case TRIADIC_CHORDS:
                buttonGroupChordMix.clearSelection();
                jCheckBoxTriads.setSelected(true);
                break;
            case SEVENTH_CHORDS:
                buttonGroupChordMix.clearSelection();
                jCheckboxSevenths.setSelected(true);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Config.NumberOfNotes number = null;
        Config.ScaleDegreeMix scaleMix = null;
        Config.NumberOfOctaves numberOfOctaves = null;
        Config.ChordMix chordMix = null;

        if (actionEvent.getSource() == jCheckBoxOneThreeFourFive) {
            scaleMix = ScaleDegreeMix.ONE_TWO_THREE_FOUR_FIVE;
        }
        if (actionEvent.getSource() == jCheckBoxALLDIATONIC) {
            scaleMix = ScaleDegreeMix.ALL_DIATONIC;
        }
        if (actionEvent.getSource() == jCheckBoxChromatic) {
            scaleMix = ScaleDegreeMix.CHROMATIC;
        }


        if(actionEvent.getSource() == jCheckBoxOne){
            number = Config.NumberOfNotes.ONE;
        }
        if(actionEvent.getSource() == jCheckBoxTwo){
            number = Config.NumberOfNotes.TWO;
        }
        if(actionEvent.getSource() == jCheckBoxThree){
            number = Config.NumberOfNotes.THREE;
        }
        if(actionEvent.getSource() == jCheckBoxFour){
            number = Config.NumberOfNotes.FOUR;
        }
        if(actionEvent.getSource() == jCheckBoxFive) {
            number = Config.NumberOfNotes.FIVE;
        }

        if(actionEvent.getSource() == jRadioButtonOct1){
            numberOfOctaves = Config.NumberOfOctaves.ONE_OCTAVE;
        }
        if(actionEvent.getSource() == jRadioButtonOct2){
            numberOfOctaves = Config.NumberOfOctaves.TWO_OCTAVES;
        }
        if(actionEvent.getSource() == jRadioButtonOct3){
            numberOfOctaves = Config.NumberOfOctaves.THREE_OCTAVES;
        }

        if(actionEvent.getSource() == jCheckBoxAllChords){
            chordMix = Config.ChordMix.ALL_CHORDS;
        }
        if(actionEvent.getSource() == jCheckBoxTriads){
            chordMix = Config.ChordMix.TRIADIC_CHORDS;
        }
        if(actionEvent.getSource() == jCheckboxSevenths){
            chordMix = Config.ChordMix.SEVENTH_CHORDS;
        }


        if(number != null) {
            Config.getInstance().setNumberOfNotes(number);
        }

        if(scaleMix != null){
            Config.getInstance().setScaleDegreeMix(scaleMix);
        }

        if(numberOfOctaves != null){
            Config.getInstance().setNumberOfOctaves(numberOfOctaves);
        }

        if(chordMix != null){
            Config.getInstance().setChordMix(chordMix);
        }

        if(actionEvent.getSource() == buttonBack){
            dispose();
            new Home();
        }
    }

    private GridBagConstraints getGbc(int x, int y, int height, int width, double weightY, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridheight = height;
        gbc.gridwidth = width;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;
        gbc.weighty = weightY;
        gbc.anchor = anchor;

        return gbc;
    }
}
