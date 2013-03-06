package br.com.grupoperaltas.equipcontrol.utils;

import java.util.Collection;

/**
 * @classname JQgrid
 * @package   br.com.grupoperaltas.equipcontrol.utils
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 09/01/2013
 * @version 1.0
 * 
 */
public class JQgrid<T> {

    private int page;
    
    private int total;
    
    private int records;
    

    private Collection<T> rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public Collection<T> getRows() {
        return rows;
    }

    public void setRows(Collection<T> rows) {
        this.rows = rows;
    }


    
   
}
