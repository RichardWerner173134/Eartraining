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

    private JRadioButton jCheckBoxALLDIATONIC;
    private JRadioButton jCheckBoxALLDIATONICACCIDENTALS;
    private JRadioButton jCheckBoxOneFourFive;

    private JRadioButton jCheckBoxOne;
    private JRadioButton jCheckBoxTwo;
    private JRadioButton jCheckBoxThree;
    private JRadioButton jCheckBoxFour;
    private JRadioButton jCheckBoxFive;

    private JButton buttonBack;

    public OptionsFrame(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400, 200));
        setVisible(true);
        setResizable(false);
        setLayout(new GridLayout(2, 1));

        buttonGroupScaleDegreeMix = new ButtonGroup();
        buttonGroupNumberOfNotes = new ButtonGroup();


        // init ScaleDegreeMix JRadioButton
        jCheckBoxALLDIATONIC = new JRadioButton("Diatonic");
        jCheckBoxALLDIATONICACCIDENTALS = new JRadioButton("DiatonicAccidentals");
        jCheckBoxOneFourFive = new JRadioButton("OneFourFive");

        buttonGroupScaleDegreeMix.add(jCheckBoxALLDIATONIC);
        buttonGroupScaleDegreeMix.add(jCheckBoxALLDIATONICACCIDENTALS);
        buttonGroupScaleDegreeMix.add(jCheckBoxOneFourFive);

        jCheckBoxOneFourFive.addActionListener(this);
        jCheckBoxALLDIATONIC.addActionListener(this);
        jCheckBoxALLDIATONICACCIDENTALS.addActionListener(this);

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

        /*add(jCheckBoxOneFourFive);
        add(jCheckBoxALLDIATONIC);
        add(jCheckBoxALLDIATONICACCIDENTALS);

        add(jCheckBoxOne);
        add(jCheckBoxTwo);
        add(jCheckBoxThree);
        add(jCheckBoxFour);
        add(jCheckBoxFive);*/


        JPanel panelScaleDegreeMix = new JPanel();

        panelScaleDegreeMix.setPreferredSize(new Dimension(350, 150));
        panelScaleDegreeMix.setLayout(new GridLayout(5, 1));
        panelScaleDegreeMix.add(new JLabel("Select the Scale Degree which should be played"));
        panelScaleDegreeMix.add(jCheckBoxOneFourFive);
        panelScaleDegreeMix.add(jCheckBoxALLDIATONIC);
        panelScaleDegreeMix.add(jCheckBoxALLDIATONICACCIDENTALS);
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

        add(panelNumberOfNotes);
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
            case ONE_FOUR_FIVE:
                buttonGroupScaleDegreeMix.clearSelection();
                jCheckBoxOneFourFive.setSelected(true);
                break;
            case ALL_DIATONIC:
                buttonGroupScaleDegreeMix.clearSelection();
                jCheckBoxALLDIATONIC.setSelected(true);
                break;
            case ALL_DIATONIC_AND_ACCIDENTALS:
                buttonGroupScaleDegreeMix.clearSelection();
                jCheckBoxALLDIATONICACCIDENTALS.setSelected(true);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Config.NumberOfNotes number = null;
        ScaleDegreeMix scaleMix = null;

        if (actionEvent.getSource() == jCheckBoxOneFourFive) {
            scaleMix = ScaleDegreeMix.ONE_FOUR_FIVE;
        }
        if (actionEvent.getSource() == jCheckBoxALLDIATONIC) {
            scaleMix = ScaleDegreeMix.ALL_DIATONIC;
        }
        if (actionEvent.getSource() == jCheckBoxALLDIATONICACCIDENTALS) {
            scaleMix = ScaleDegreeMix.ALL_DIATONIC_AND_ACCIDENTALS;
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

        if(number != null) {
            Config.getInstance().setNumberOfNotes(number);
        }

        if(scaleMix != null){
            Config.getInstance().setScaleDegreeMix(scaleMix);
        }

        if(actionEvent.getSource() == buttonBack){
            dispose();
            new Home();
        }
    }
}
