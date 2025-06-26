import java.util.HashSet;
import java.util.Set;

public class PlantTestDemoQ2 {
    public static void main(String[] args) {
        // 1. Cria a primeira planta com código "001"
        PlantQ2 p1 = new PlantQ2("001", "Rosa");

        // 2. Cria outra instância com o mesmo código, mas descrição diferente
        PlantQ2 p2 = new PlantQ2("001", "Rosa Silvestre");

        // 3. Cria planta com código distinto
        PlantQ2 p3 = new PlantQ2("002", "Girassol");

        // 4. equals(): compara p1 e p2.
        //    Como ambos têm code="001", deve retornar true.
        System.out.println("p1.equals(p2)? " + p1.equals(p2));

        // 5. HashSet: só guardará instâncias “únicas” segundo equals/hashCode.
        Set<PlantQ2> conjunto = new HashSet<>();

        // 6. Adiciona p1 → conjunto contém [p1]
        conjunto.add(p1);

        // 7. Adiciona p2 → não adiciona, pois p2.equals(p1) é true
        conjunto.add(p2);

        // 8. Adiciona p3 → adiciona, distinto de p1/p2
        conjunto.add(p3);

        // 9. Imprime o tamanho: deve ser 2, não 3
        System.out.println("Tamanho do Set: " + conjunto.size());

        // 10. Mostra elementos do Set para confirmarmos quais foram mantidos
        System.out.println("Conteúdo do Set: " + conjunto);
    }
}
