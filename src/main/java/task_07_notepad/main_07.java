package task_07_notepad;

import task_07_notepad.impl.EditorBody;
import task_07_notepad.impl.EditorControls;
import task_07_notepad.impl.IActionObserver;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class main_07 extends JPanel implements IActionObserver {
    private final int BODY_ACTION = 0;
    private final int CONTROLS_ACTION = 1;

    private final EditorControls controls;
    private final EditorBody body;
    private final JLabel statusBar;
    private final JFileChooser fileChooser;
    private File currentFile;


    public main_07() {
        setLayout(new BorderLayout());

        controls = new EditorControls(CONTROLS_ACTION, this);
        body = new EditorBody(BODY_ACTION, this);
        statusBar = new JLabel();

        add(controls, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(false);

        setStatus("Hello world!");
    }


    @Override
    public void onAction(int sourceId) {
        switch (sourceId) {
            case CONTROLS_ACTION:
                handleControlsAction();
                break;

            case BODY_ACTION:
                handleBodyAction();
                break;
        }
    }


    private void handleBodyAction() {
        updateGUI();
    }


    private void handleControlsAction() {
        String command = controls.getLastCommand();
        switch (command) {
            case EditorControls.A_OPEN:
                openFile();
                break;

            case EditorControls.A_CREATE:
                createNew();
                break;

            case EditorControls.A_SAVE:
                saveCurrent();
                break;

            case EditorControls.A_SAVE_AS:
                saveToNewFile();
                break;
        }

        controls.resetCommand();
    }


    private void saveToNewFile() {
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(currentFile));
                String lines = body.getLines();
                out.write(lines, 0, lines.length());
                out.close();
                body.resetChanges();
            }
            catch(IOException ex) {
                System.err.println(ex);
            }

            updateGUI();
        }

    }


    private void saveCurrent() {
        if (currentFile == null) {
            saveToNewFile();
            return;
        }

        FileWriter fileWriter = null;
        try {
            String lines = body.getLines();
            fileWriter = new FileWriter(currentFile);
            fileWriter.write(lines, 0, lines.length());
            fileWriter.flush();
            fileWriter.close();
            body.resetChanges();
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateGUI();
    }


    private void createNew() {
        currentFile = null;
        body.clear();
        updateGUI();
    }

    private void updateGUI() {
        String changes = body.getHasChanges()
                ? " *"
                : "";

        String statusLine = currentFile == null
                ? "Not saved yet"
                : currentFile.getPath();
        statusLine += changes;
        setStatus(statusLine);
    }


    private void openFile() {
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();

            try{
                BufferedReader in = new BufferedReader(new FileReader(currentFile));
                String line = null;
                StringBuilder lines = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    lines.append(line).append("\n");
                }
                body.setText(lines.toString());
                in.close();
            }
            catch(IOException ex) {
                System.err.println("Open plaintext error: "+ex);
            }

            updateGUI();
        }
    }


    private void setStatus(String line) {
        statusBar.setText(line);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
        // show empty text frame with 2 buttons
    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Notepad+++++++++");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(400, 400));

        frame.add(new main_07());

        frame.pack();
        frame.setVisible(true);
    }
}
