package org.example.vo;

public class RelatorioFinanceiroVo {
    private String nomeFuncionario;
    private Double valorTotalFaturado;

    public RelatorioFinanceiroVo(String nomeFuncionario, Double valorTotalFaturado) {
        this.nomeFuncionario = nomeFuncionario;
        this.valorTotalFaturado = valorTotalFaturado;
    }

    @Override
    public String toString() {
        return "\n\nRelatorioFinanceiroVo{" +
                "nomeFuncionario='" + nomeFuncionario + "\n" +
                ", valorTotalFaturado=" + valorTotalFaturado +
                '}';
    }
}
