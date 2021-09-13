package br.com.alura.tdd;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void consederReajuste(Funcionario funcionario, Desempenho desempenho){
        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.addReajuste(reajuste);
    }
}
