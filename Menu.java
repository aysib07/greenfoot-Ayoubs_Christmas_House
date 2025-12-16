import greenfoot.*; // import every greenfoot function, object and more

public class Menu extends Actor
{
    private int id;
    private List<Recipe> recipes;
    private int recipesListLength;
    
    public Menu() {
        this.id = Greenfoot.getRandomNumber(12);
        this.recipes = new List<Recipe>();
        this.recipesListLength = 0;
        this.setRecipes();
    }
    
    private void setRecipes() {
        // based on the id set a random menu
        switch(this.id) {
            // a type of waffle + hot_chocolate
            case 0:
                this.recipes.append(new Recipe("waffle_nutella", "food"));
                this.recipes.append(new Recipe("hot_chocolate", "drink"));
                this.recipesListLength = 2;
                break;
            case 1:
                this.recipes.append(new Recipe("waffle_icing_sugar", "food"));
                this.recipes.append(new Recipe("hot_chocolate", "drink"));
                this.recipesListLength = 2;
                break;
            case 2:
                this.recipes.append(new Recipe("waffle_normal", "food"));
                this.recipes.append(new Recipe("hot_chocolate", "drink"));
                this.recipesListLength = 2;
                break;
            
            // a type of waffle + tea
            case 3:
                this.recipes.append(new Recipe("waffle_nutella", "food"));
                this.recipes.append(new Recipe("tea", "drink"));
                this.recipesListLength = 2;
                break;
            case 4:
                this.recipes.append(new Recipe("waffle_icing_sugar", "food"));
                this.recipes.append(new Recipe("tea", "drink"));
                this.recipesListLength = 2;
                break;
            case 5:
                this.recipes.append(new Recipe("waffle_normal", "food"));
                this.recipes.append(new Recipe("tea", "drink"));
                this.recipesListLength = 2;
                break;
                
            // only a type of waffle
            case 6:
                this.recipes.append(new Recipe("waffle_nutella", "food"));
                this.recipesListLength = 1;
                break;
            case 7:
                this.recipes.append(new Recipe("waffle_icing_sugar", "food"));
                this.recipesListLength = 1;
                break;
            case 8:
                this.recipes.append(new Recipe("waffle_normal", "food"));
                this.recipesListLength = 1;
                break;
                
            // only a drink
            case 9:
                this.recipes.append(new Recipe("hot_chocolate", "drink"));
                this.recipesListLength = 1;
                break;
            case 10:
                this.recipes.append(new Recipe("tea", "drink"));
                this.recipesListLength = 1;
                break;
                
            default:
                break;
        }
    }
    
    public List<Recipe> getRecipesList() {
        return this.recipes;
    }
    
    public int getRecipesListLength() {
        return this.recipesListLength;
    }
}