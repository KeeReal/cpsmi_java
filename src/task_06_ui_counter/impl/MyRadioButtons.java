package task_06_ui_counter.impl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyRadioButtons extends MyButtons {
    private ButtonGroup buttonGroup;


    public MyRadioButtons() {
        super();
        buttonGroup = new ButtonGroup();
    }


    @Override
    public void addButton(AbstractButton button, String actionCommand) {
        super.addButton(button, actionCommand);
        buttonGroup.add(button);
    }
}
