// 2. Importa utilitários para facilitar comparações e geração de hash.
//    A classe Objects contém métodos estáticos de uso geral como equals() e hash().
import java.util.Objects;

/**
 * 3. Declaração da classe Plant.
 *    Representa uma “planta” no sistema, com código único e descrição.
 */
public class PlantQ2 {

    // 4. Campo 'code': identificador único da planta.
    //    Declarado como final porque não mudará após a criação do objeto.
    private final String code;

    // 5. Campo 'description': texto opcional descrevendo a planta.
    private String description;

    /**
     * 6. Construtor da classe Plant.
     *    É o método chamado quando alguém faz 'new Plant(...)'.
     *
     * @param code        Código único. Obrigatório, não pode ser nulo ou vazio.
     * @param description Descrição opcional.
     */
    public PlantQ2(String code, String description) {
        // 7. Validação: código não pode ser nulo.
        if (code == null) {
            throw new IllegalArgumentException("Código não pode ser nulo.");
        }
        // 8. Validação: código não pode ser só espaços em branco.
        if (code.isBlank()) {
            throw new IllegalArgumentException("Código não pode ser vazio.");
        }
        // 9. Atribuição dos valores aos campos de instância.
        this.code = code;
        this.description = description;
    }

    // 10. Getter para o código (não há setter, pois é imutável).
    public String getCode() {
        return code;
    }

    // 11. Getter e setter para description, pois a descrição pode mudar.
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 12. Sobrescrita do método equals().
     *     Define quando duas Plant são consideradas “iguais”.
     */
    @Override
    public boolean equals(Object o) {
        // 13. Verifica se a referência é a mesma: neste caso, é exatamente o mesmo objeto.
        //     Então, por definição, são iguais.
        if (this == o) {
            return true;
        }
        // 14. Verifica se 'o' é nulo ou de classe diferente.
        //     Se for, não tem como ser igual.
        if (!(o instanceof PlantQ2)) {
            return false;
        }
        // 15. Faz o cast de Object para Plant, pois agora sabemos que é seguro.
        PlantQ2 other = (PlantQ2) o;
        // 16. Compara os campos de interesse: aqui, somente 'code'.
        //     Usa Objects.equals() para lidar com potenciais nulls de forma segura.
        return Objects.equals(this.code, other.code);
    }

    /**
     * 17. Sobrescrita de hashCode().
     *     Gera um inteiro baseado nos mesmos campos usados em equals().
     *     Crucial para estruturas como HashSet e HashMap.
     */
    @Override
    public int hashCode() {
        // 18. Usa Objects.hash() para combinar os campos em um hash único.
        //     Como equals() compara apenas 'code', o hashCode também usa só 'code'.
        return Objects.hash(code);
    }

    /**
     * 19. Sobrescrita de toString() para facilitar debug e logs.
     */
    @Override
    public String toString() {
        // 20. Retorna uma string legível representando o objeto.
        return "Plant{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
