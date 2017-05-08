package task_08_threads;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

interface TaskObserver {
    void onTaskCompleted(Task t);
}

public class main_08 extends JPanel implements ActionListener, TaskObserver {
    private static final int BAR_MIN = 0;
    private static final int BAR_MAX = 100;

    private final ArrayList<JProgressBar> bars;
    private final JButton button;


    public main_08() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        bars = new ArrayList<JProgressBar>(3);
        bars.add(new JProgressBar(BAR_MIN, BAR_MAX));
        bars.add(new JProgressBar(BAR_MIN, BAR_MAX));
        bars.add(new JProgressBar(BAR_MIN, BAR_MAX));

        for (JProgressBar bar : bars) {
            panel.add(bar);
        }

        button = new JButton();
        panel.add(button);

        button.addActionListener(this);

        updateGui();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Threads");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        frame.setMinimumSize(new Dimension(200, 200));

        frame.add(new main_08());

        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // get empty progress bar and start
        // create working task, save it

        if (bars.size() == 0) {
            return;
        }

        JProgressBar bar = bars.remove(0);
        Task task = new Task(this, bar);
        Thread taskThread = new Thread(task, String.valueOf(bars.size()));
        taskThread.start();
        updateGui();
    }


    private void updateGui() {
        if (bars.size() == 0) {
            button.setText("Plz wait!");
        } else {
            button.setText("Do work!");
        }
    }


    @Override
    public void onTaskCompleted(Task t) {
        JProgressBar bar = t.getBar();
        bar.setValue(0);
        bars.add(bar);
        updateGui();
    }
}

class Task implements Runnable {
    private TaskObserver taskObserver;
    private JProgressBar bar;
    private int counter = 0;
    private boolean isRunning;


    public Task(TaskObserver taskObserver, JProgressBar bar) {
        this.taskObserver = taskObserver;
        this.bar = bar;
        isRunning = true;
    }


    public JProgressBar getBar() {
        return bar;
    }


    @Override
    public void run() {
        while (isRunning) {
            try {
                long sleepDelay = (long) (Math.random() * 40 + 2);
                Thread.sleep(sleepDelay);

                bar.setValue(counter);
                if (counter++ >= bar.getMaximum()) {
                    taskObserver.onTaskCompleted(this);
                    isRunning = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                taskObserver.onTaskCompleted(this);
            }
        }
    }
}