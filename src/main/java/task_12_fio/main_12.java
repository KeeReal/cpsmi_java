package task_12_fio;

import task_07_notepad.impl.IActionObserver;
import task_12_fio.impl.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class main_12 extends JPanel implements IActionObserver {
    private final int CONTROLS_ACTION = 0;
    private final int TABLE_ACTION = 1;
    private final TableBody table;
    private final TableControls controls;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Accounts list");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(400, 400));

        frame.add(new main_12());

        frame.pack();
        frame.setVisible(true);
    }


    public main_12() {
        setLayout(new BorderLayout());



        controls = new TableControls(CONTROLS_ACTION, this);
        table = new TableBody(TABLE_ACTION,this);
        add(controls, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);


        table.setUsers(readUsers());
    }


    private ArrayList<UserVO> readUsers() {
        UserDataReader reader = new UserDataReader(Consts.getUsersFilePath());
        return reader.readUsers();
    }


    @Override
    public void onAction(int sourceId) {
        switch (sourceId) {
            case CONTROLS_ACTION:
                handleControlsAction();
                break;

            case TABLE_ACTION:
                handleTableAction();
                break;
        }
    }


    private void handleTableAction() {

    }


    private void handleControlsAction() {
        String lastCommand = controls.getLastCommand();
        switch (lastCommand) {
            case TableControls.A_ADD:
                table.addRow();
                break;

            case TableControls.A_SAVE:
                saveData();
                break;

            case TableControls.A_DELETE:
                deleteSelectedRow();
                break;
        }

        controls.resetCommand();
    }


    private void deleteSelectedRow() {
        table.deleteSelectedRow();
    }


    private void saveData() {
        UsersDataWriter writer = new UsersDataWriter(table.getUsers());
        writer.write();
    }
}
