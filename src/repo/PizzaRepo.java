package repo;

import entity.Pizza;
import entity.User;

import java.io.*;
import java.util.ArrayList;

public class PizzaRepo implements Serializable{
    private static PizzaRepo pizzaRepoInstance;

    private final String dishRepoFilePath = "dishRepo.txt";
    private ArrayList<Pizza> pizzas;

    private PizzaRepo(){
        pizzas = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(dishRepoFilePath))) {
            pizzas = (ArrayList<Pizza>) in.readObject();
        }catch(EOFException e){
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static PizzaRepo getInstance(){
        if(pizzaRepoInstance == null){
            pizzaRepoInstance = new PizzaRepo();
        }
        return pizzaRepoInstance;
    }

    public void add(){
        Pizza firstPizza = Pizza.PizzaBuilder.aPizza().withName("Пепперони").
                withSauce("Томатный соус").withCheese("Сыр пармезан").
                withSausages("Колбаски пепперони").withMushrooms("Шампиньоны").
                withPeppers("Болгарский перец").withOlives("Маслины").build();
        pizzas.add(firstPizza);
        Pizza secondPizza = Pizza.PizzaBuilder.aPizza().withName("Охотничья").
                withSauce("Томатный соус").withSausages("Колбаски охотничьи").
                withMushrooms("Шампиньёны").withTomatoes("Томаты свежие").
                withCucumbers("Маринованные огурцы").withCheese("Сыр моцарелла").build();
        pizzas.add(secondPizza);
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dishRepoFilePath));
            out.writeObject(pizzas);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewMenu(){
        System.out.println("\tМеню пиццерии:");
        for(Pizza pizza:pizzas){
            System.out.println("Наименование: " + pizza.getNameOfPizza());
            System.out.println("Состав:");
            System.out.println(pizza.toString());
        }
    }
}
