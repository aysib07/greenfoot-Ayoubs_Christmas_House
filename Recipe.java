import greenfoot.*; // import every greenfoot function, object and more

public class Recipe extends Actor
{
    private String name;
    private String type;
    private List<Ingredient> ingredients;
    
    public Recipe(String _name, String _type) {
        this.name = _name;
        this.type = _type;
        this.ingredients = new List<Ingredient>();
        this.addIngredients();
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<Ingredient> getIngredientsList() {
        return this.ingredients;
    }
    
    private void addIngredients() {
        switch(this.name) {
            case "waffle_nutella":
                this.ingredients.append(new Ingredient("waffle_batter"));
                this.ingredients.append(new Ingredient("nutella"));
                break;
                
            case "waffle_icing_sugar":
                this.ingredients.append(new Ingredient("waffle_batter"));
                this.ingredients.append(new Ingredient("icing_sugar"));
                break;
                
            case "waffle_normal":
                this.ingredients.append(new Ingredient("waffle_batter"));
                break;
                
            case "hot_chocolate":
                this.ingredients.append(new Ingredient("cup"));
                this.ingredients.append(new Ingredient("chocolate"));
                this.ingredients.append(new Ingredient("milk"));
                break;
                
            case "tea":
                this.ingredients.append(new Ingredient("cup"));
                this.ingredients.append(new Ingredient("water"));
                this.ingredients.append(new Ingredient("tea_bag"));
                break;
                
            default:
                break;
        }
    }
    
    public String getRecipeNameAsdReadbleString() {
        switch(this.name) {
            case "waffle_nutella":
                return "Waffel mit Nutella";
                
            case "waffle_icing_sugar":
                return "Waffel mit Puderzucker";
                
            case "waffle_normal":
                return "Waffel normal";
                
            case "hot_chocolate":
                return "Heiße Schokolade";
                
            case "tea":
                return "Tasse Tea";
                
            default:
                return "";
        }
    }
}