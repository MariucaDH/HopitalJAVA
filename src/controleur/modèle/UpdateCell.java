/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur.modèle;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author jbkaloya
 */
public class UpdateCell implements TableModelListener{

    
        private String table = "";
        private Requetes req;
        private Object[][] previous;
        
        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();

    
                TableModel model = (TableModel) e.getSource();
                String columnName = model.getColumnName(column);
                String val = (String) model.getValueAt(row, column);
                
                 System.out.println(columnName + ": " + val);
                 System.out.println(column + ": " + row);
                 System.out.println(this.previous);
                 
                
                this.req.updaterow(table, columnName, val, (String) this.previous[row][column]);
                
               
              
                
                //this.is_deleted();
                
            
        }
        
        
        /*public void is_deleted(){
            int row = table.getSelectedRow();
            int modelRow = table.convertRowIndexToModel( row );
                
                System.out.println(row + ": " + modelRow);
                if(modelRow > 0){
                    table.remove(modelRow - 1);
                }
        }*/

        public UpdateCell(){
            
        }
        
        public UpdateCell(String t, Requetes r){
            this.table = t;
            this.req = r;
            try {
                this.previous = this.req.gettable(t);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateCell.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
