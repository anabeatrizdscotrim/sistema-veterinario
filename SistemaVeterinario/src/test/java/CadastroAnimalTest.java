import org.example.Animal;
import org.example.CadastroAnimal;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CadastroAnimalTest {

    @Test
    public void testCadastrarAnimal(){
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        Animal animal = new Animal(4,"Luna", "Cachorro", "Shitzu", 8, 5.25);
        cadastroAnimal.cadastrarAnimal(animal);
        assertTrue(cadastroAnimal.listarAnimais().contains(animal));
    }

    /*
     * teste 01: Cadastro de um novo animal
     * entrada -> um novo animal é cadastrado, com todos os dados.
     * saída esperada -> o cadastro correto do animal, adicionado na lista.
     */

    @Test
    public void testCadastrarAnimalComCampoVazio(){
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        Animal animal = new Animal(2,"", "Gato", "Persa", 4, 4.20);
        cadastroAnimal.cadastrarAnimal(animal);
        assertFalse(cadastroAnimal.listarAnimais().contains(animal));
    }

    /*
     * teste 02: Cadastro de um novo animal com campo obrigatório vaqzio
     * entrada -> um novo animal é cadastrado, mas com o nome vazio.
     * saída esperada -> "Preencha todos os campos para cadastrar o animalzinho!"
     */

    @Test
    public void testCadastrarAnimalComIdInvalido() {
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        Animal animal = new Animal(-1, "Luna", "Cachorro", "Shitzu", 8, 5.25); // ID inválido
        cadastroAnimal.cadastrarAnimal(animal);
        assertFalse(cadastroAnimal.listarAnimais().contains(animal));
    }

    /*
     * teste 03: Cadastro de um novo animal com id negativo
     * entrada -> um novo animal é cadastrado, mas com um ID inválido
     * saída esperada -> "Coloque o ID como um número maior ou igual a zero!"
     */

    @Test
    public void testBuscarAnimalExistente(){
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        Animal animal =  new Animal(5, "Molly", "Cachorro", "Vira-lata", 10, 6.50);
        cadastroAnimal.cadastrarAnimal(animal);
        assertEquals(animal, cadastroAnimal.buscarAnimal(5));
    }

    /*
     * teste 04: Busca de um animal cadastrado
     * entrada -> o id cadastrado do animalzinho
     * saída esperada -> o animal com o id cadastrado
     */

    @Test
    public void testBuscarAnimalInexistente(){
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        assertNull(cadastroAnimal.buscarAnimal(1));
    }

    /*
     * teste 05: Busca de um animal que não foi cadastrado
     * entrada -> o id cadastrado do animalzinho
     * saída esperada -> "Animal não cadastrado :("
     */

    @Test
    public void testEditarAnimalExistente(){
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        Animal animalOriginal = new Animal(8, "Zeca", "Urubu", "urubu-de-cabeça-preta", 5, 1.9);
        cadastroAnimal.cadastrarAnimal(animalOriginal);
        Animal animalEditado = new Animal(8, "Zeca", "Urubu", "urubu-de-cabeça-preta", 6, 1.9);
        cadastroAnimal.editarAnimal(8, animalEditado);
        assertEquals(animalEditado, cadastroAnimal.buscarAnimal(8));
    }

    /*
     * teste 06: Edição de um animal que já foi cadastrado
     * entrada -> modificação de algum dado de um animal já existente
     * saída esperada -> a edição do animal
     */

    @Test
    public void testEditarAnimalInexistente(){
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        Animal animalEditado = new Animal(2,"Woody", "Pássaro", "Canário", 2,0.024);
        cadastroAnimal.editarAnimal(2,animalEditado);
        assertNull(cadastroAnimal.buscarAnimal(2));
    }

    /*
     * teste 07: Edição de um animal que não foi cadastrado
     * entrada -> modificação de algum dado de um animal que não foi cadastrado
     * saída esperada -> "Animal não cadastrado :("
     */

    @Test
    public void testExcluirAnimalExistente(){
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        Animal animal = new Animal(3, "Marocas", "Hamster", "Roborovski", 1, 0.022);
        cadastroAnimal.cadastrarAnimal(animal);
        cadastroAnimal.excluirAnimal(3);
        assertFalse(cadastroAnimal.listarAnimais().contains(animal));
    }

    /*
     * teste 08: Exclusão de um animal que já foi cadastrado
     * entrada -> o id do animal que será excluido
     * saída esperada -> a exclusão do animal
     */

    @Test
    public void testExcluirAnimalInexistente(){
        CadastroAnimal cadastroAnimal = new CadastroAnimal();
        cadastroAnimal.excluirAnimal(1);
        assertEquals(0, cadastroAnimal.listarAnimais().size());
    }

    /*
     * teste 09: Exclusão de um animal que não foi cadastrado
     * entrada -> o id de um animal que não foi cadastrado e que será excluido
     * saída esperada -> verificação se o tamanho da lista continua a mesma
     */

}
