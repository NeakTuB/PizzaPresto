package entity;

import java.io.Serializable;

public class Pizza implements Serializable {
    private String nameOfPizza;
    private String sauce;
    private String cheese;
    private String sausages;
    private String mushrooms;
    private String tomatoes;
    private String cucumbers;
    private String peppers;
    private String olives;

    public static final class PizzaBuilder{
        private String nameOfPizza;
        private String sauce;
        private String cheese;
        private String sausages;
        private String mushrooms;
        private String tomatoes;
        private String cucumbers;
        private String peppers;
        private String olives;

        private PizzaBuilder() {
        }

        public static PizzaBuilder aPizza(){
            return new PizzaBuilder();
        }

        public PizzaBuilder withName(String name){
            this.nameOfPizza = name;
            return this;
        }

        public PizzaBuilder withSauce(String sauce){
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder withCheese(String cheese){
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder withSausages(String sausages){
            this.sausages = sausages;
            return this;
        }

        public PizzaBuilder withMushrooms(String state){
            this.mushrooms = state;
            return this;
        }

        public PizzaBuilder withTomatoes(String state){
            this.tomatoes = state;
            return this;
        }

        public PizzaBuilder withCucumbers(String state){
            this.cucumbers = state;
            return this;
        }

        public PizzaBuilder withPeppers(String state){
            this.peppers = state;
            return this;
        }

        public PizzaBuilder withOlives(String state){
            this.olives = state;
            return this;
        }

        public Pizza build(){
            Pizza pizza = new Pizza();
            pizza.setCheese(cheese);
            pizza.setCucumbers(cucumbers);
            pizza.setMushrooms(mushrooms);
            pizza.setNameOfPizza(nameOfPizza);
            pizza.setOlives(olives);
            pizza.setPeppers(peppers);
            pizza.setSauce(sauce);
            pizza.setTomatoes(tomatoes);
            pizza.setSausages(sausages);
            return pizza;
        }
    }

    @Override
    public String toString() {
        String tempStr = "";
        if(sauce != null){
            tempStr = tempStr + "\t" + getSauce() + "\n";
        }
        if(cheese != null){
            tempStr = tempStr + "\t" + getCheese() + "\n";
        }
        if(sausages != null){
            tempStr = tempStr + "\t" + getSausages() + "\n";
        }
        if(mushrooms != null){
            tempStr = tempStr + "\t" + "Шампиньёны" + "\n";
        }
        if(tomatoes != null){
            tempStr = tempStr + "\t" + "Томаты" + "\n";
        }
        if(cucumbers != null){
            tempStr = tempStr + "\t" + "Огурцы" + "\n";
        }
        if(peppers != null){
            tempStr = tempStr + "\t" + "Перец" + "\n";
        }
        if(olives != null){
            tempStr = tempStr + "\t" + "Оливки" + "\n";
        }
        return tempStr;
    }

    public String getNameOfPizza() {
        return nameOfPizza;
    }

    public String getSauce() {
        return sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public String getSausages() {
        return sausages;
    }

    public String isOlives() {
        return olives;
    }

    public void setOlives(String olives) {
        this.olives = olives;
    }

    public void setNameOfPizza(String nameOfPizza) {
        this.nameOfPizza = nameOfPizza;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setSausages(String sausages) {
        this.sausages = sausages;
    }

    public void setMushrooms(String mushrooms) {
        this.mushrooms = mushrooms;
    }

    public void setTomatoes(String tomatoes) {
        this.tomatoes = tomatoes;
    }

    public void setCucumbers(String cucumbers) {
        this.cucumbers = cucumbers;
    }

    public void setPeppers(String peppers) {
        this.peppers = peppers;
    }
}
