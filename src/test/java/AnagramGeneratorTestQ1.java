// Importa as APIs de teste do JUnit Jupiter (JUnit 5).
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Suíte de testes unitários para a classe AnagramGenerator.
 */
public class AnagramGeneratorTestQ1 {

    @Test
    void testThreeLetters() {
        // Chama o método com 3 letras distintas
        List<String> result = AnagramGeneratorQ1.generateAnagrams("abc");

        // Verifica se retornou exatamente 6 permutações (3! = 6)
        assertEquals(6, result.size(), "Deve gerar 6 anagramas para 3 letras");

        // Assegura que certas permutações esperadas estão presentes
        assertTrue(result.contains("abc"), "Deve conter 'abc'");
        assertTrue(result.contains("cba"), "Deve conter 'cba'");
    }

    @Test
    void testSingleLetter() {
        // Se a entrada for uma única letra, só há uma permutação possível
        List<String> result = AnagramGeneratorQ1.generateAnagrams("x");
        assertEquals(1, result.size(), "Para 1 letra, só 1 permutação");
        assertEquals("x", result.get(0), "A única permutação deve ser a própria letra");
    }

    @Test
    void testEmptyInput() {
        // Entrada vazia deve lançar exceção IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            AnagramGeneratorQ1.generateAnagrams("");
        }, "Entrada vazia deve causar IllegalArgumentException");
    }

    @Test
    void testNonLetter() {
        // Se a string contiver dígito, também deve lançar IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            AnagramGeneratorQ1.generateAnagrams("ab1");
        }, "Caracter não-letra deve causar IllegalArgumentException");
    }
}
