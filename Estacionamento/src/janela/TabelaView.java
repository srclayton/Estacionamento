/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import principal.Cliente;

/**
 *
 * @author Lucas-PC
 */
public class TabelaView extends AbstractTableModel {
    private List<Cliente> clientes;

    public TabelaView() {
        clientes = new ArrayList<>();
    }

    public TabelaView(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
        /*switch (columnIndex) {
            case 0: return String.class;
            case 1: 
            case 2: 
            case 3: return Double.class;
        }
        return Object.class;*/
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Vaga";
            case 1: return "Nome Cliente";
            case 2: return "Carro";
            case 3: return "Status";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getVeiculo().getModelo();
            case 2: return cliente.getVeiculo().getPlaca();
            case 3: return cliente.getCpf();
        }
        return null;
    }

    public void add(Cliente cliente) {
        clientes.add(cliente);
        int row = clientes.indexOf(cliente);
        fireTableRowsInserted(row, row);
    }

    public void remove(Cliente cliente) {
        if (clientes.contains(cliente)) {
            int row = clientes.indexOf(cliente);
            clientes.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

}