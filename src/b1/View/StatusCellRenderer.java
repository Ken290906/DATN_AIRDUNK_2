package b1.View;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class StatusCellRenderer extends DefaultTableCellRenderer {
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Lấy giá trị của cột "Trạng thái" (cột 5)
        String status = (String) table.getValueAt(row, 5);

        // Thiết lập màu sắc cho ô dựa trên giá trị của cột "Trạng thái"
        if ("Hết hàng".equals(status)) {
            cellComponent.setForeground(Color.RED);
        } else if ("Còn hàng".equals(status)) {
            cellComponent.setForeground(Color.GREEN);
        }

        return cellComponent;
    }
}
