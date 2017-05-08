package task_12_fio.impl;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    private final String[] columnNames = {
            "fullname",
            "birthdate",
            "address",
            "tel"
    };

    private final ArrayList<ArrayList<Object>> data;
    private Object users;


    public MyTableModel() {
        data = new ArrayList<ArrayList<Object>>();
    }


    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    @Override
    public int getRowCount() {
        return data.size();
    }


    @Override
    public int getColumnCount() {
        return columnNames.length;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList<Object> row = data.get(rowIndex);
        return row.get(columnIndex);
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ArrayList<Object> row = data.get(rowIndex);
        row.set(columnIndex, aValue);
    }


    public void addEmptyRow() {
        addRowImpl("", "", "", "");
    }


    public void addRowImpl(String fullname,
                           String bdate,
                           String address,
                           String tel) {
        ArrayList<Object> row = new ArrayList<>();
        row.add(fullname);
        row.add(bdate);
        row.add(address);
        row.add(tel);
        data.add(row);
        fireTableRowsInserted(0, data.size());
    }


    public void deleteRow(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(0, data.size());
    }


    public ArrayList<ArrayList<Object>> getRows() {
        return data;
    }
}
