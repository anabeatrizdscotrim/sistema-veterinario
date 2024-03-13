package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CadastroAnimal {
    private List<Animal> listaAnimais;

   public CadastroAnimal(){
       this.listaAnimais = new ArrayList<>();
   }


   //Cadastro
   public void cadastrarAnimal(Animal animal){
       if (animal.getNome().isEmpty() || animal.getEspecie().isEmpty() || animal.getRaca().isEmpty()) {
           System.out.println("Preencha todos os campos para cadastrar o animalzinho!");
           return;
       }

       if (animal.getIdade() <= 0){
           System.out.println("Preencha o campo idade com um número maior do que zero!");
           return;
       }

       if (animal.getId() <= 0){
           System.out.println("Coloque o ID como um número maior que zero!");
           return;
       }
       listaAnimais.add(animal);
   }

   //Busca pelo Id na Lista
   public Animal buscarAnimal(int id){
       if (id <= 0) {
           System.out.println("Forneça um id válido para buscar o animalzinho!");
       }

       for (Animal animal : listaAnimais) {
           if (animal.getId() == id){
               return animal;
           }
       }

       System.out.println("Animal não cadastrado :(");
       return null;
   }

   //Edição de algum dado
   public boolean editarAnimal (int id, Animal animalEditado) {
       for (int i = 0; i < listaAnimais.size(); i++) {
           Animal animalAtual = listaAnimais.get(i);
           if (animalAtual.getId() == animalEditado.getId()){
               listaAnimais.set(i,animalEditado);
               return true;
           }
       }
       return false;
   }

   //Exclusão de um animal
   public boolean excluirAnimal(int id) {
       for (int i = 0; i < listaAnimais.size(); i++) {
           Animal animalAtual = listaAnimais.get(i);
           if(animalAtual.getId() == id) {
               listaAnimais.remove(i);
               return true;
           }
       }
       return false;
   }

   //Listar animais
    public List<Animal> listarAnimais(){
       return listaAnimais;
    }

}
