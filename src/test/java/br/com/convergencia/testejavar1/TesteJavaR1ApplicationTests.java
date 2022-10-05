package br.com.convergencia.testejavar1;

import br.com.convergencia.testejavar1.util.CpfValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TesteJavaR1ApplicationTests {

    @Test
    void testCpfValid() {
        String cpf = "33931722805";

        Assertions.assertTrue(CpfValidator.isValid(cpf));
    }

    @Test
    void testCpfInvalid() {
        String cpf = "33931722895";

        Assertions.assertFalse(CpfValidator.isValid(cpf));
    }
}
