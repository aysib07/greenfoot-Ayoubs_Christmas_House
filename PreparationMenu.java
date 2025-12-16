import greenfoot.*; // import every greenfoot function, object and more

public class PreparationMenu extends Actor
{
    public PreparationMenu() {
        this.setImage(new GreenfootImage("./images/preparation_menu.png"));
        MapManager.add(this, 512, 341);
        this.addButtons();
        this.listNeedIngredients();
    }
    
    private void addButtons() {
        Button waffleBatterButton = new Button("ingredient_select", true);
        waffleBatterButton.setCustomId("waffle_batter");
        MapManager.add(waffleBatterButton, 202, 294);
        
        Button nutellaButton = new Button("ingredient_select", true);
        nutellaButton.setCustomId("nutella");
        MapManager.add(nutellaButton, 329, 294);
        
        Button icingSugarButton = new Button("ingredient_select", true);
        icingSugarButton.setCustomId("icing_sugar");
        MapManager.add(icingSugarButton, 452, 294);
        
        Button chocolateButton = new Button("ingredient_select", true);
        chocolateButton.setCustomId("chocolate");
        MapManager.add(chocolateButton, 576, 294);
        
        Button milkButton = new Button("ingredient_select", true);
        milkButton.setCustomId("milk");
        MapManager.add(milkButton, 204, 392);
        
        Button teaBagButton = new Button("ingredient_select", true);
        teaBagButton.setCustomId("tea_bag");
        MapManager.add(teaBagButton, 329, 392);
        
        Button waterButton = new Button("ingredient_select", true);
        waterButton.setCustomId("water");
        MapManager.add(waterButton, 452, 392);
        
        Button cupButton = new Button("ingredient_select", true);
        cupButton.setCustomId("cup");
        MapManager.add(cupButton, 576, 392);
        
        Button prepareMenuButton = new Button("prepare_menu", true);
        MapManager.add(prepareMenuButton, 368, 463);
        
        Button clearSelectedIngredientButton = new Button("clear_selected_ingredient", true);
        MapManager.add(clearSelectedIngredientButton, 508, 463);
    }
    
    private void listNeedIngredients() {
        Guest guest = GuestManager.getFirstGuest();
        
        // fallback if the the first element in the guest queue is null
        if (guest == null) return; 
        
        Menu guestMenu = guest.getMenu();
        
        int startX = PreparationManager.ingredientStartX; // where the ingredients start to list on map
        int nextX = PreparationManager.ingredientNextX; // x position of the next ingredient
        int spacing = PreparationManager.ingredientSpacing; // space between each ingredient on the map
        
        List<Recipe> recipes = guestMenu.getRecipesList();
        recipes.toFirst();
        while (recipes.hasAccess()) {
            Recipe recipe = (Recipe) recipes.getContent();
            
            List<Ingredient> ingredients = recipe.getIngredientsList();
            ingredients.toFirst();
            while (ingredients.hasAccess()) {
                Ingredient ingredient = (Ingredient) ingredients.getContent();
                
                int x = startX + nextX;
                MapManager.add(ingredient, x, 128);
                
                nextX += (ingredient.getImage().getWidth() / 2) + spacing;
                ingredients.next();
            }
            
            recipes.next();
        }
    }
}