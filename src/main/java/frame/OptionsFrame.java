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

    private JRadioButton jCheckBoxALLDIATONIC;
    private JRadioButton jCheckBoxChromatic;
    private JRadioButton jCheckBoxOneThreeFourFive;

    private JRadioButton jCheckBoxOne;
    private JRadioButton jCheckBoxTwo;
    private JRadioButton jCheckBoxThree;
    private JRadioButton jCheckBoxFour;
    private JRadioButton jCheckBoxFive;

    private JRadioButton jRadioButtonOct1, jRadioButtonOct2, jRadioButtonOct3;

    private JButton buttonBack;

    public OptionsFrame(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400, 200));
        setVisible(true);
        setResizable(false);
        setLayout(new GridLayout(3, 1));

        buttonGroupScaleDegreeMix = new ButtonGroup();
        buttonGroupNumberOfNotes = new ButtonGroup();
        buttonGroupNumberOfOctaves = new ButtonGroup();


        // init ScaleDegreeMix JRadioButton
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

        buttonBack = new JButton("Go Back");
        buttonBack.setPreferredSize(new Dimension(40, 20));
        buttonBack.addActionListener(this);

        jRadioButtonOct1 = new JRadioButton("1");
        jRadioButtonOct2 = new JRadioButton("2");
        jRadioButtonOct3 = new JRadioButton("3");

        jRadioButtonOct1.addActionListener(this);
        jRadioButtonOct2.addActionListener(this);
        jRadioButtonOct3.addActionListener(this);

        buttonGroupNumberOfOctaves.add(jRadioButtonOct1);
        buttonGroupNumberOfOctaves.add(jRadioButtonOct2);
        buttonGroupNumberOfOctaves.add(jRadioButtonOct3);

        JPanel panelScaleDegreeMix = new JPanel();

        panelScaleDegreeMix.setPreferredSize(new Dimension(350, 150));
        panelScaleDegreeMix.setLayout(new GridLayout(5, 1));
        panelScaleDegreeMix.add(new JLabel("Select the Scale Degree which should be played"));
        panelScaleDegreeMix.add(jCheckBoxOneThreeFourFive);
        panelScaleDegreeMix.add(jCheckBoxALLDIATONIC);
        panelScaleDegreeMix.add(jCheckBoxChromatic);
        panelScaleDegreeMix.add(buttonBack);


        JPanel panelNumberOfNotes = new JPanel();

        panelNumberOfNotes.setPreferredSize(new Dimension(350, 150));
        panelNumberOfNotes.setLayout(new GridLayout(6,1));
        panelNumberOfNotes.add(new JLabel("Select how many notes should be played at the same time"));
        panelNumberOfNotes.add(jCheckBoxOne);
        panelNumberOfNotes.add(jCheckBoxTwo);
        panelNumberOfNotes.add(jCheckBoxThree);
        panelNumberOfNotes.add(jCheckBoxFour);
        panelNumberOfNotes.add(jCheckBoxFive);

        JPanel panelNumberOfOctaves = new JPanel();

        panelNumberOfOctaves.setPreferredSize(new Dimension(350, 150));
        panelNumberOfOctaves.setLayout(new GridLayout(4,1));
        panelNumberOfOctaves.add(new JLabel("Range of used octaves: "));
        panelNumberOfOctaves.add(jRadioButtonOct1);
        panelNumberOfOctaves.add(jRadioButtonOct2);
        panelNumberOfOctaves.add(jRadioButtonOct3);

        add(panelNumberOfNotes);
        add(panelNumberOfOctaves);
        add(panelScaleDegreeMix);
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
            case ONE_THREE_FOUR_FIVE:
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
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Config.NumberOfNotes number = null;
        Config.ScaleDegreeMix scaleMix = null;
        Config.NumberOfOctaves numberOfOctaves = null;

        if (actionEvent.getSource() == jCheckBoxOneThreeFourFive) {
            scaleMix = ScaleDegreeMix.ONE_THREE_FOUR_FIVE;
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
        if(actionEvent.getSource() == jCheckBoxFive){
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

        if(number != null) {
            Config.getInstance().setNumberOfNotes(number);
        }

        if(scaleMix != null){
            Config.getInstance().setScaleDegreeMix(scaleMix);
        }

        if(numberOfOctaves != null){
            Config.getInstance().setNumberOfOctaves(numberOfOctaves);
        }

        if(actionEvent.getSource() == buttonBack){
            dispose();
            new Home();
        }
    }
}
