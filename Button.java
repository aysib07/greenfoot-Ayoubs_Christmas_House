import greenfoot.*; // import every greenfoot function, object and more

public class Button extends Actor
{
    private String customId;
    private String action; // which action should this button has
    private boolean invisible; // button does not have an image
    
    public Button(String _action, boolean _invisible)
    {
        this.action = _action;
        this.invisible = _invisible;
        this.customId = null;
        this.setImage(this.getButtonImage());
    }
    
    public void act()
    {
        this.executeButtonAction();
    }
    
    /**
     * Set a custom id for a button
     */
    public void setCustomId(String customId) {
        this.customId = customId;
    }
    
    /**
     * Execute the action of the given button
     */
    private void executeButtonAction() {
        if (!Greenfoot.mouseClicked(this)) return;
        
        switch (this.action) {
            case "start":
                GameManager.start(); // start game
                break;
            case "start_menu_preparation":
                MapManager.removeByClass(Text.class);
                PreparationMenu menu = new PreparationMenu();
                GuestManager.stopSpawner();
                break;
            case "ingredient_select":
                PreparationManager.addIngredient(this.customId);
                break;
            case "prepare_menu":
                PreparationManager.prepareMenu();
                break;
            case "clear_selected_ingredient":
                PreparationManager.removeIngredient();
                break;
            default:
                return;
        }
        
        if (this.action == "start") {
            GameManager.start(); // start game
            return;
        }
        
        if (this.action == "ingredient_select") {
            return;
        }
        
        if (this.action == "prepare_menu") {
            return;
        }
    }
    
    /**
     * Set the image of the button based on the action
     */
    private GreenfootImage getButtonImage() {
        GreenfootImage image = new GreenfootImage("./images/buttons/" + this.action + ".png");
        if (this.invisible) image.setTransparency(0); // make the button invisible
        return image;
    }
}