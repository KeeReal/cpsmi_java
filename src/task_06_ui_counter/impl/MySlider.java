package task_06_ui_counter.impl;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MySlider extends ActionCallee implements IPanelChild, ChangeListener {
    private final JSlider jSlider;


    public MySlider() {
        jSlider = new JSlider(JSlider.HORIZONTAL, 0, 30, 20);
        jSlider.addChangeListener(this);
    }


    @Override
    public void addToPanel(Panel panel) {
        panel.add(jSlider);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        this.callAction(new StringBuilder()
                .append("stateChanged: ")
                .append(jSlider.getValue())
                .toString());
    }
}
