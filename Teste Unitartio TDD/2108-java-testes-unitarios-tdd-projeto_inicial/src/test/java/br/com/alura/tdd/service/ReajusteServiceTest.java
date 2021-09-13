package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import static org.junit.jupiter.api.Assertions.*;

import br.com.alura.tdd.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        service = new ReajusteService();
        funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    void desempenhoAdesejarReajusteDeveriaSerDeTresPorcento() {
        service.consederReajuste(funcionario, Desempenho.A_Desejar);
        assertEquals(new BigDecimal(("1030.00")), funcionario.getSalario());
    }

    @Test
    void desempenhoBomReajusteDeveriaSerDe15Porcento() {
        service.consederReajuste(funcionario, Desempenho.Bom);
        assertEquals(new BigDecimal(("1150.00")), funcionario.getSalario());
    }

    @Test
    void desempenhoOtimoReajusteDeveriaSerDe20Porcento() {
        service.consederReajuste(funcionario, Desempenho.Otimo);
        assertEquals(new BigDecimal(("1200.00")), funcionario.getSalario());
    }

}
