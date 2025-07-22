// Interface for all meal plans
interface MealPlan {
    String getDescription();
}

// Concrete Meal Plan Types
class VegetarianMeal implements MealPlan {
    public String getDescription() {
        return "Vegetarian Meal: Includes vegetables, grains, dairy, and eggs.";
    }
}

class VeganMeal implements MealPlan {
    public String getDescription() {
        return "Vegan Meal: Includes only plant-based foods.";
    }
}

class KetoMeal implements MealPlan {
    public String getDescription() {
        return "Keto Meal: High-fat, low-carb foods.";
    }
}

class HighProteinMeal implements MealPlan {
    public String getDescription() {
        return "High-Protein Meal: Focuses on protein-rich foods.";
    }
}

// Generic class to handle meal plans
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void showMealPlan() {
        System.out.println("Meal Plan Description:");
        System.out.println(mealPlan.getDescription());
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

// Meal Generator with validation
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        // Example validation (can be extended)
        System.out.println("Validating user preferences for: " + mealPlan.getClass().getSimpleName());
        
        if (mealPlan instanceof KetoMeal) {
            System.out.println("Note: Keto Meal is not recommended for people with certain medical conditions.");
        }

        return new Meal<>(mealPlan);
    }
}

// Demo class to show usage
public class PersonalizedMealPlanDemo {
    public static void main(String[] args) {
        // User selects Vegetarian Meal
        VegetarianMeal veg = new VegetarianMeal();
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(veg);
        vegMeal.showMealPlan();

        System.out.println("---------------------------");

        // User selects High Protein Meal
        HighProteinMeal hp = new HighProteinMeal();
        Meal<HighProteinMeal> hpMeal = MealPlanGenerator.generateMealPlan(hp);
        hpMeal.showMealPlan();
    }
}
