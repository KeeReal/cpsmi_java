package task_06_ui_counter.impl;

import java.awt.*;

public abstract class ActionCallee {
    private IActionObserver actionObserver;


    public void setActionObserver(IActionObserver actionObserver) {
        this.actionObserver = actionObserver;
    }


    protected void callAction(String action) {
        if (this.actionObserver == null) {
            return;
        }

        this.actionObserver.onAction(action);
    }
}
