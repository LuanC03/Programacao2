package testesUnidade;

import static org.junit.Assert.*;

import org.junit.Test;

import systemTrackingThings.Utilidades.Validador;

public class ValidadorTeste {
    
    Validador validador;

    @Test
    public void testValidaEmail() {
        assertEquals(true, validador.validaEmail("arthur.santos@ccc.ufcg.edu.br"));
        assertEquals(true, validador.validaEmail("@."));
        assertEquals(true, validador.validaEmail("@.arthur"));
        assertEquals(true, validador.validaEmail("abc@."));
        assertEquals(true, validador.validaEmail("@abc......."));
        
        assertEquals(false, validador.validaEmail("arthur@santos"));
        assertEquals(false, validador.validaEmail("arthur.santos"));
        assertEquals(false, validador.validaEmail("@@."));
        assertEquals(false, validador.validaEmail(".@abc"));
    }

}