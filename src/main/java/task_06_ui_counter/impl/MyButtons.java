package task_06_ui_counter.impl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyButtons extends ActionCallee implements IPanelChild, ActionListener {
    private static final String NO_COMMAND = "NO_COMMAND";


    private ArrayList<AbstractButton> buttons;


    public MyButtons() {
        buttons = new ArrayList<AbstractButton>();
    }


    public void addButton(AbstractButton button) {
        this.addButton(button, NO_COMMAND);
    }


    public void addButton(AbstractButton button, String actionCommand) {
        button.setActionCommand(actionCommand);
        button.addActionListener(this);

        buttons.add(button);
    }


    @Override
    public void addToPanel(Panel panel1) {
        for (AbstractButton button : buttons) {
            panel1.add(button);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton a = (AbstractButton) e.getSource();
        this.callAction(new StringBuilder()
                .append("actionPerformed, command: ")
                .append(e.getActionCommand())
                .append(" source: ")
                .append(a.getText())
                .toString());
    }
}
