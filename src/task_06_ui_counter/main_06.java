package task_06_ui_counter;

import task_06_ui_counter.impl.*;

import javax.swing.*;
import java.awt.*;


/**
 * Подсчет действий пользователя.
 * Создать простой графический интерфейс с подсчетом количества нажатий на кнопку,
 * прокручаваемой областью текста, радио-кнопками и ползунком.
 */

public class main_06 extends JPanel implements IActionObserver {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("My JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new main_06());

        frame.pack();
        frame.setVisible(true);
    }


    private int actionCounter;
    private JLabel statusLabel;


    public main_06() {
        actionCounter = 0;

        setLayout(new BorderLayout());

        Panel body = new Panel(new FlowLayout());
        initializeTextPanel((Panel) body.add(new Panel()));
        initializeControlsPanel((Panel) body.add(new Panel()));

        statusLabel = new JLabel("Count", JLabel.LEFT);

        add(body, BorderLayout.PAGE_START);
        add(statusLabel, BorderLayout.PAGE_END);
    }


    private void initializeTextPanel(Panel panel) {
        MyTextArea myTextArea = new MyTextArea();
        myTextArea.setActionObserver(this);
        myTextArea.addToPanel(panel);
    }


    private void initializeControlsPanel(Panel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        MyButtons myButtons = new MyButtons();
        myButtons.setActionObserver(this);
        myButtons.addButton(new JButton("button1"), "action1");
        myButtons.addButton(new JButton("button2"), "action2");
        myButtons.addToPanel(panel);

        MyRadioButtons myRadioButtons = new MyRadioButtons();
        myRadioButtons.setActionObserver(this);
        myRadioButtons.addButton(new JRadioButton("hello"), "radio1");
        myRadioButtons.addButton(new JRadioButton("world"), "radio2");
        myRadioButtons.addToPanel(panel);

        MySlider mySlider = new MySlider();
        mySlider.setActionObserver(this);
        mySlider.addToPanel(panel);
    }


    @Override
    public void onAction(String action) {
        actionCounter++;
        statusLabel.setText(new StringBuilder()
                .append("Count: ")
                .append(actionCounter++)
                .append(" last: ")
                .append(action).toString());
    }
}
