public class Dynamic {

    // Category marker interfaces
    interface BookCategory {}
    interface ClothingCategory {}
    interface GadgetCategory {}

    // Generic Product class with bounded type parameter
    static class Product<T> {
        private String name;
        private double price;
        private T category;

        public Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public T getCategory() {
            return category;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{name='" + name + "', price=" + price + ", category=" + category.getClass().getSimpleName() + "}";
        }
    }

    // Generic method to apply discount dynamically
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }

    // Example category classes
    static class FictionBook implements BookCategory {
        @Override
        public String toString() {
            return "FictionBook";
        }
    }

    static class CasualClothing implements ClothingCategory {
        @Override
        public String toString() {
            return "CasualClothing";
        }
    }

    static class Smartphone implements GadgetCategory {
        @Override
        public String toString() {
            return "Smartphone";
        }
    }

    public static void main(String[] args) {
        Product<FictionBook> book = new Product<>("The Great Gatsby", 20.0, new FictionBook());
        Product<CasualClothing> shirt = new Product<>("T-Shirt", 15.0, new CasualClothing());
        Product<Smartphone> phone = new Product<>("Android Phone", 300.0, new Smartphone());

        System.out.println("Before discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);

        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
        applyDiscount(phone, 5);

        System.out.println("\nAfter discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}
