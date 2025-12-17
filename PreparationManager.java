import greenfoot.*; // import every greenfoot function, object and more

/**
 * Manage the preparation of guests menus
 */
public class PreparationManager extends Manager 
{
    private static Stack<Ingredient> selectedIngredients = new Stack<Ingredient>();
    public static int ingredientStartX = 190; // where the ingredients start to list on map
    public static int ingredientNextX = 0; // x position of the next ingredient
    public static int ingredientSpacing = 45; // space between each ingredient on the map
    
    public static void addIngredient(String name) {
        Ingredient ingredient = new Ingredient(name);
        selectedIngredients.push(ingredient);
        
        int x = ingredientStartX + ingredientNextX;
        MapManager.add(ingredient, x, 209);
        ingredientNextX += (ingredient.getImage().getWidth() / 2) + ingredientSpacing;
    }
    
    public static void removeIngredient() {
        while (!selectedIngredients.isEmpty()) {
            Ingredient ingredient = (Ingredient) selectedIngredients.top();
            MapManager.remove(ingredient);
            selectedIngredients.pop();
            ingredientNextX = 0;
        }
        MapManager.removeByClass(Text.class);
    }
    
    public static void prepareMenu() {
        Guest guest = GuestManager.getFirstGuest();
        
        // fallback if the the first element in the guest queue is null
        if (guest == null) return;
        
        Menu guestMenu = guest.getMenu();
        List<Ingredient> needIngredients = new List<Ingredient>();
        
        // create the needIngredients list
        List<Recipe> recipes = guestMenu.getRecipesList();
        recipes.toFirst();
        while (recipes.hasAccess()) {
            Recipe recipe = (Recipe) recipes.getContent();
            List<Ingredient> ingredients = recipe.getIngredientsList();
            ingredients.toFirst();
            while (ingredients.hasAccess()) {
                Ingredient ingredient = (Ingredient) ingredients.getContent();
                needIngredients.append(ingredient);
                ingredients.next();
            }
            ingredients.toFirst();
            recipes.next();
        }
        recipes.toFirst();
        
        // check if selected ingredients are the same as in den guest menu
        boolean sameIngredients = sameIngredients(needIngredients);
        if (!sameIngredients) {
            new Text("Missing ingredients or selected wrong one", 23, "red", 385, 23);
            return;
        }
        
        // reset and delete the fist guest
        ingredientNextX = 0;
        MapManager.removeByClass(Text.class);
        MapManager.removeByClass(Ingredient.class);
        MapManager.removeByClass(PreparationMenu.class);
        GuestManager.removeFirstGuest();
        GuestManager.continueSpawning();
    }
    
    public static boolean sameIngredients(List<Ingredient> needIngredients) {
        Stack<Ingredient> temp = new Stack<>();
        boolean equal = true;
    
        // copy elements from the original stack to a temp stack
        while (!selectedIngredients.isEmpty()) {
            temp.push(selectedIngredients.top());
            selectedIngredients.pop();
        }
    
        // iterate through all elements of the list
        needIngredients.toFirst();
        while (needIngredients.hasAccess() && equal) {
            String name = needIngredients.getContent().getName();
            boolean found = false;
            
            // search for a matching ingredient (by name) in the temporary stack
            while (!temp.isEmpty()) {
                // if a matching ingredient is found remove it once to correctly handle duplicates
                if (temp.top().getName().equals(name)) {
                    found = true;
                    temp.pop();
                    break;
                }
                
                // move elements that do not match back to the original stack
                selectedIngredients.push(temp.top());
                temp.pop();
            }
    
            // move all remaining elements back into the temporary stack to restore its state for the next iteration
            while (!selectedIngredients.isEmpty()) {
                temp.push(selectedIngredients.top());
                selectedIngredients.pop();
            }
    
            // if the current list ingredient was not found in the stack, both data structures do not contain the same elements
            if (!found) {
                equal = false;
            }
    
            // move to the next element in the list
            needIngredients.next();
        }
        needIngredients.toFirst();
        
        // restore the original stack order so the method has no side effects
        while (!temp.isEmpty()) {
            selectedIngredients.push(temp.top());
            temp.pop();
        }
    
        return equal;
    }
}