package task_06_ui_counter.impl;

import task_06_ui_counter.Consts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class MyTextArea extends ActionCallee implements AdjustmentListener {
    private JScrollPane jScrollPane;


    public MyTextArea() {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setColumns(20);
        jTextArea.setRows(10);
        jTextArea.setText(Consts.LOREM_TEXT);
        jTextArea.setVisible(true);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);

        jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.getVerticalScrollBar().addAdjustmentListener(this);
    }


    public void addToPanel(Panel panel1) {
        panel1.add(this.jScrollPane);
    }


    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        this.callAction(new StringBuilder()
                .append("adjustmentValueChanged: ")
                .append(e.getValue())
                .toString());
    }
}