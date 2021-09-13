package br.com.alura.tdd.service;

import br.com.alura.tdd.BonusService;
import br.com.alura.tdd.modelo.Funcionario;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    private BonusService bonusService;

    @BeforeEach
    public void inicializar(){
        bonusService = new BonusService();
    }

    @Test
    void deveriarRetornarZeroParaSalariosMuitoAltos(){
       assertThrows(IllegalArgumentException.class,
               () -> bonusService.calcularBonus((new Funcionario("Bia", LocalDate.now(), new BigDecimal("25000")))));

    }

    @Test
    void deveriarRetornar10PorCentoDovalorDoBonusParaSalariosAbaixoDe10000(){
        BigDecimal bonus = bonusService.calcularBonus((new Funcionario("Bia", LocalDate.now(), new BigDecimal("2500"))));
        assertEquals(new BigDecimal(("250.00")), bonus);
    }

    @Test
    void deveriarRetornarBonusParaSalariosDe10000(){
        BigDecimal bonus = bonusService.calcularBonus((new Funcionario("Bia", LocalDate.now(), new BigDecimal("10000"))));
        assertEquals(new BigDecimal(("1000.00")), bonus);
    }


}
