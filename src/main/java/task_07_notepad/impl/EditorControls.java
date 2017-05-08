package task_07_notepad.impl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorControls extends JPanel implements ActionListener {
    public static final String A_OPEN = "open";
    public static final String A_CREATE = "new";
    public static final String A_SAVE = "save";
    public static final String A_SAVE_AS = "save-as";

    private final JButton buttonOpen;
    private final JButton buttonSave;
    private final JButton buttonSaveAs;
    private final JButton buttonCreate;
    private int sourceId;
    private IActionObserver observer;
    private String lastCommand;


    public EditorControls(int sourceId, IActionObserver observer) {
        this.sourceId = sourceId;
        this.observer = observer;
        setLayout(new FlowLayout(FlowLayout.LEFT));

        buttonCreate = createAndAddButton(A_CREATE);
        buttonOpen = createAndAddButton(A_OPEN);
        buttonSave = createAndAddButton(A_SAVE);
        buttonSaveAs = createAndAddButton(A_SAVE_AS);
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
        observer.onAction(sourceId);
    }


    public String getLastCommand() {
        return lastCommand;
    }


    public void resetCommand() {
        lastCommand = null;
    }
}
