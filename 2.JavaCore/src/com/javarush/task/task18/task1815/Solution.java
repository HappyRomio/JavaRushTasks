package com.javarush.task.task18.task1815;

import java.util.ArrayList;
import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{

        private TableInterface tblIn;

        TableInterfaceWrapper(TableInterface t) {
            tblIn = t;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            tblIn.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return tblIn.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
                tblIn.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}