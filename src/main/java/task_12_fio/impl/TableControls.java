package task_12_fio.impl;

import task_07_notepad.impl.IActionObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableControls extends JPanel implements ActionListener {
    public static final String A_ADD = "add";
    public static final String A_SAVE = "save";
    public static final String A_DELETE = "delete row";

    private final JButton buttonAdd;
    private final JButton buttonSave;
    private final JButton buttonDelete;
    private int sourceId;
    private IActionObserver observer;
    private String lastCommand;


    public TableControls(int sourceId, IActionObserver observer) {
        this.sourceId = sourceId;
        this.observer = observer;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        buttonAdd = createAndAddButton(A_ADD);
        buttonSave = createAndAddButton(A_SAVE);
        buttonDelete = createAndAddButton(A_DELETE);
    }


    private JButton createAndAddButton(String action) {
        JButton button = new JButton(action);
        add(button);
        button.setActionCommand(action);
        button.addActionListener(this);
        return button;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        lastCommand = e.getActionCommand();
        observer.onAction(0);
    }


    public String getLastCommand() {
        return lastCommand;
    }


    public void resetCommand() {
        lastCommand = null;
    }
}
