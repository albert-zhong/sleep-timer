package sh.surge.albert.sleeptimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class SleepTimer extends JFrame
                        implements ActionListener {

    private JPanel mainPane;

    private JPanel cards;
    private JComboBox<String> setting;
    private String[] settingItems = {"I'm sleeping right now, when do I wake up?", "I know when I'm waking up, when do I fall asleep?",
                                        "I know when I'm falling asleep, when do I wake up?"};

    private JTextArea outputTimes;


    public SleepTimer() {
        super("Sleep timer");

        mainPane = new JPanel(new BorderLayout());

        setting = new JComboBox<>(settingItems);

        JPanel card1 = new JPanel();
        JTextField currentTime = new JTextField(20);
        Calendar c = Calendar.getInstance();
        String am_or_pm;
        if (c.get(Calendar.AM_PM) == 1) {
            am_or_pm = "PM";
        } else {
            am_or_pm = "AM";
        }
        currentTime.setText("Current time is " + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + " " + am_or_pm);
        currentTime.setEditable(false);
        card1.add(currentTime);


        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();

        cards = new JPanel(new CardLayout());
        cards.add(card1, settingItems[0]);
        cards.add(card2, settingItems[1]);
        cards.add(card3, settingItems[2]);

        outputTimes = new JTextArea("Outputted times");
        outputTimes.setEditable(false);

        mainPane.add(setting, BorderLayout.PAGE_START);
        mainPane.add(cards, BorderLayout.CENTER);
        mainPane.add(outputTimes, BorderLayout.PAGE_END);

        add(mainPane);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

    }
}
