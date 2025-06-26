// Importa as classes necessárias.
// ArrayList e List servem para armazenar dinamicamente as permutações geradas.
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal para geração de anagramas (permutações) de uma string de letras.
 */
public class AnagramGeneratorQ1 {

    /**
     * Gera todas as permutações (anagramas) das letras distintas fornecidas.
     *
     * @param input String contendo apenas letras distintas.
     * @return Lista de anagramas gerados.
     * @throws IllegalArgumentException se input for nulo, vazio ou contiver caracteres não-alfabéticos.
     */
    public static List<String> generateAnagrams(String input) {
        // Validação: entrada não pode ser null
        if (input == null) {
            throw new IllegalArgumentException("Entrada não pode ser nula.");
        }
        // Validação: entrada não pode ser vazia
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Entrada não pode ser vazia.");
        }
        // Validação: cada caractere deve ser uma letra
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                // Se encontrar dígito ou símbolo, rejeita
                throw new IllegalArgumentException("Entrada deve conter apenas letras.");
            }
        }

        // Cria a lista que receberá todos os anagramas
        List<String> resultado = new ArrayList<>();

        // Inicia o processo de backtracking: prefixo vazio e resto igual à string original
        backtrack("", input, resultado);

        // Retorna a lista com todas as permutações encontradas
        return resultado;
    }

    /**
     * Método recursivo que constrói as permutações removendo uma letra por vez de 'rest'
     * e acrescentando-a ao 'prefix'.
     *
     * @param prefix   A parte já construída da permutação.
     * @param rest     As letras ainda não utilizadas.
     * @param resultado Lista onde serão armazenadas as permutações completas.
     */
    private static void backtrack(String prefix, String rest, List<String> resultado) {
        // Caso base: se não restam letras em 'rest', temos uma permutação completa
        if (rest.isEmpty()) {
            // Adiciona o prefixo (que agora é uma permutação completa) à lista de resultados
            resultado.add(prefix);
            return;
        }

        // Loop sobre cada posição de 'rest'
        for (int i = 0; i < rest.length(); i++) {
            // Escolhe o caractere na posição i
            char c = rest.charAt(i);

            // Constrói novo prefixo acrescentando o caractere escolhido
            String novoPrefix = prefix + c;

            // Constrói novo 'rest' removendo o caractere escolhido
            String novoRest = rest.substring(0, i) + rest.substring(i + 1);

            // Chamada recursiva: continua construindo permutações com o novo estado
            backtrack(novoPrefix, novoRest, resultado);
        }
    }

    /**
     * Método main para demonstração rápida.
     * Permite executar sem testes, via linha de comando ou IDE.
     */
    public static void main(String[] args) {
        // Gera anagramas para "abc" e imprime no console
        System.out.println(generateAnagrams("abc"));
    }
}
