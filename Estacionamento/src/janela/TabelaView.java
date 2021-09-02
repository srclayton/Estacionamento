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
import principal.Vaga;

/**
 *
 * @author Lucas-PC
 */
@SuppressWarnings("serial")
public class TabelaView extends AbstractTableModel {
    private List<Vaga> vagas;

    public TabelaView() {
    	vagas = new ArrayList<>();
    }

    public TabelaView(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    @Override
    public int getRowCount() {
        return vagas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
            case 5: return float.class;
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Vaga";
            case 1: return "Status";
            case 2: return "Nome Cliente";
            case 3: return "Cpf Cliente";
            case 4: return "Placa carro";
            case 5: return "Valor";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vaga vaga = vagas.get(rowIndex);
        switch (columnIndex) {
            case 0: 
            	return vaga.getLocalizacao();
            case 1:
            	return vaga.getOcupacao() != null ? "Ocupada" : "Vazia";
            case 2: 
            	return vaga.getOcupacao() != null ? vaga.getOcupacao().getCliente().getNome() : "";
            case 3:
            	return vaga.getOcupacao() != null ? vaga.getOcupacao().getCliente().getCpf() : "";
            case 4: 
            	return vaga.getOcupacao() != null ? vaga.getOcupacao().getVeiculo().getPlaca() : "";
            case 5:
            	return vaga.getOcupacao() != null ? vaga.getOcupacao().getValorAtual() : "";
        }
        return null;
    }

    public void add(Vaga vaga) {
    	vagas.add(vaga);
        int row = vagas.indexOf(vaga);
        fireTableRowsInserted(row, row);
    }

    public void remove(Vaga vaga) {
        if (vagas.contains(vaga)) {
            int row = vagas.indexOf(vaga);
            vagas.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

}