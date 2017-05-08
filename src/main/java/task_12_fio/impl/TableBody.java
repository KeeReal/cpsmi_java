package task_12_fio.impl;

import task_07_notepad.impl.IActionObserver;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.util.ArrayList;

public class TableBody extends JPanel implements TableModelListener{
    private final JTable table;
    private final MyTableModel model;
    private int sourceId;
    private IActionObserver actionObserver;
    private Object users;


    public TableBody(int sourceId, IActionObserver actionObserver) {
        this.sourceId = sourceId;
        this.actionObserver = actionObserver;
        setLayout(new BorderLayout());

        model = new MyTableModel();
        table = new JTable(model);

        add(new JScrollPane(table));

        table.getModel().addTableModelListener(this);
    }


    public void addRow() {
        model.addEmptyRow();
    }


    @Override
    public void tableChanged(TableModelEvent e) {
        actionObserver.onAction(sourceId);
    }


    public void deleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            model.deleteRow(selectedRow);
        }
    }


    public void setUsers(ArrayList<UserVO> users) {
        for (UserVO user : users) {
            model.addRowImpl(user.getFullname(),
                    user.getBirthdate(),
                    user.getAddress(),
                    user.getTel());
        }
    }


    public ArrayList<UserVO> getUsers() {
        ArrayList<UserVO> users = new ArrayList<>();

        ArrayList<ArrayList<Object>> rows = model.getRows();
        for (ArrayList<Object> row : rows) {
            users.add(new UserVO(
                    (String) row.get(0),
                    (String) row.get(1),
                    (String) row.get(2),
                    (String) row.get(3)
            ));
        }

        return users;
    }
}
