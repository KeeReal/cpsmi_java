package task_07_notepad.impl;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class EditorBody extends JPanel implements DocumentListener {
    private final JTextArea textArea;
    private final JScrollPane scrollPane;
    private int sourceId;
    private IActionObserver observer;
    private boolean hasChanges;


    public EditorBody(int sourceId, IActionObserver observer) {
        this.sourceId = sourceId;
        this.observer = observer;

        setLayout(new BorderLayout());

        textArea = new JTextArea();

        textArea.getDocument().addDocumentListener(this);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
    }


    public void setText(String lines) {
        textArea.setText(lines);
        hasChanges = false;
    }


    public void clear() {
        textArea.setText("");
        hasChanges = false;
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        dispatchChangeAction();
    }


    @Override
    public void removeUpdate(DocumentEvent e) {
        dispatchChangeAction();
    }


    private void dispatchChangeAction() {
        hasChanges = true;
        observer.onAction(sourceId);
    }


    @Override
    public void changedUpdate(DocumentEvent e) {
        dispatchChangeAction();
    }


    public String getLines() {
        return textArea.getText();
    }


    public boolean getHasChanges() {
        return hasChanges;
    }


    public void resetChanges() {
        hasChanges = false;
    }
}
