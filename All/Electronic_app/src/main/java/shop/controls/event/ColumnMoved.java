package shop.controls.event;


import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;



public abstract class ColumnMoved implements TableColumnModelListener {
    
    @Override // just use this method
    public abstract void columnMoved(TableColumnModelEvent e);
    
    @Override
    public void columnAdded(TableColumnModelEvent e) {
    }
    
    @Override
    public void columnRemoved(TableColumnModelEvent e) {
    }
    
    @Override
    public void columnMarginChanged(ChangeEvent e) {
    }
    
    @Override
    public void columnSelectionChanged(ListSelectionEvent e) {
    }
}
