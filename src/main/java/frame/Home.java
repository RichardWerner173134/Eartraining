package frame;

import components.Config;
import components.SoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    private Config config;
    private JButton btnPlay;
    private JButton btnOptions;
    private JPanel panCenter;
    private JPanel panCenterFlow;
    private OptionsFrame optionsFrame;
    private QuizFrame quizFrame;

    public Home(){

        initButtons();
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout());

        panCenterFlow.setBackground(Color.ORANGE);

        add(panCenterFlow, BorderLayout.CENTER);
        panCenterFlow.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 400));

        btnPlay.setPreferredSize(new Dimension(100, 100));
        btnOptions.setPreferredSize(new Dimension(100, 100));

        btnPlay.setBackground(Color.GREEN);
        btnOptions.setBackground(Color.BLACK);

        panCenterFlow.add(btnPlay);
        panCenterFlow.add(btnOptions);

        panCenter.setPreferredSize(new Dimension(200, 300));

        config = Config.getInstance();
    }

    private void initButtons() {
        btnPlay = new JButton("Play");
        btnOptions = new JButton("Options");
        panCenter = new JPanel();
        panCenterFlow = new JPanel();
        btnPlay.addActionListener(new BtnActionListener());
        btnOptions.addActionListener(new BtnActionListener());
        add(btnPlay, BorderLayout.CENTER);
        btnPlay.setBackground(Color.BLACK);
        btnPlay.setSize(200, 200);
        add(btnOptions);
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
                quizFrame = new QuizFrame();
            } else if (source == btnOptions){
                // open Options
                System.out.println("starting Options");
                dispose();
                optionsFrame = new OptionsFrame();
            }
        }
    }

}
