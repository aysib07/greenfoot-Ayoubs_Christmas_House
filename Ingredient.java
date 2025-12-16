import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ingredient extends Actor
{
    private String name;
    
    public Ingredient(String _name) {
        this.name = _name;
        this.setImage(new GreenfootImage("./images/ingredients/" + this.name + ".png"));
    }
    
    public String getName() {
        return this.name;
    }
}