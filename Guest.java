import greenfoot.*; // import every greenfoot function, object and more

public class Guest extends Actor
{
    private int id;
    private Menu menu;
    
    public Guest() {
        this.id = Greenfoot.getRandomNumber(5);
        this.menu = new Menu();
        this.setImage(new GreenfootImage("./images/guests/guest_" + this.id + ".png"));
    }
    
    public void act() {
        if (!Greenfoot.mouseClicked(this)) return;
        if (!GuestManager.isFirstGuest(this)) return;
        
        String order = "";
        List<Recipe> recipes = this.menu.getRecipesList();
        recipes.toFirst();
        
        int length = 0;
        while (recipes.hasAccess() && this.menu.getRecipesListLength() != length) {
            length++;
            Recipe recipe = (Recipe) recipes.getContent();
            order += recipe.getRecipeNameAsdReadbleString() + ((this.menu.getRecipesListLength() - length) >= 1 ? " & " : "");
            recipes.next();
        }
        
        new Text(order, 23, "white", 400, 580);
        
        Button startPreparationButton = new Button("start_menu_preparation", true);
        MapManager.add(startPreparationButton, 830, 490);
    }
    
    public Menu getMenu() {
        return this.menu;
    }
    
    /**
     * Get the right y cord for each type of guest based on id (cause: image size)
     */
    public int getYCord() {
        switch(this.id) {
            case 0:
                return 406;
                
            case 1:
                return 399;
                
            case 2:
                return 408;
                
            case 3:
                return 407;
                
            case 4:
                return 417;
                
            default:
                return 406;
        }
    }
    
    /**
     * Set new x cord position for the guest
     */
    public void moveTo(int x) {
        this.setLocation(x, getY());
    }
}