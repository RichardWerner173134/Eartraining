package frame;

import components.Config;
import components.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private JButton btnPlay;
    private JButton btnOptions;
    private JPanel panCenter;
    private JPanel panCenterFlow;
    private JButton btnChords;

    public Home(){

        initButtons();
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout());

        panCenterFlow.setBackground(Color.WHITE);

        add(panCenterFlow, BorderLayout.CENTER);
        panCenterFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 250));

        btnPlay.setPreferredSize(new Dimension(100, 60));
        btnPlay.setBorder(BorderFactory.createRaisedBevelBorder());
        btnOptions.setPreferredSize(new Dimension(100, 60));
        btnOptions.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        btnChords.setPreferredSize(new Dimension(100, 60));
        btnChords.setBorder(BorderFactory.createRaisedBevelBorder());

        btnPlay.setBackground(Color.LIGHT_GRAY);
        btnOptions.setBackground(Color.LIGHT_GRAY);
        btnChords.setBackground(Color.LIGHT_GRAY);

        panCenterFlow.add(btnPlay);
        panCenterFlow.add(btnOptions);
        panCenterFlow.add(btnChords);

        panCenter.setPreferredSize(new Dimension(200, 300));
    }

    private void initButtons() {
        btnPlay = new JButton("Play");
        btnOptions = new JButton("Options");
        btnChords = new JButton("Chords");
        panCenter = new JPanel();
        panCenterFlow = new JPanel();
        btnPlay.addActionListener(new BtnActionListener());
        btnOptions.addActionListener(new BtnActionListener());
        btnChords.addActionListener(new BtnActionListener());
        btnPlay.setBackground(Color.BLACK);
        btnPlay.setSize(200, 200);
        btnPlay.setVisible(true);
    }

    class BtnActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();
            if (source == btnPlay) {
                // open Game
                System.out.println("Starting Game");
                dispose();
                new QuizFrame();
            } else if (source == btnOptions){
                // open Options
                System.out.println("starting Options");
                dispose();
                new OptionsFrame();
            } else if(source == btnChords){
                System.out.println("Starting Chord Game");
                dispose();
                new ChordQuizFrame();
            }
        }
    }

}
