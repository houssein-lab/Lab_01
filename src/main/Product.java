import java.util.Objects;

/**
 * Represents a Product with identifying information and cost.
 */
public class Product {
    private String name;
    private String description;
    private final String ID;  // should never change
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        setCost(cost); // validate cost
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getID() { return ID; }

    public double getCost() { return cost; }
    public void setCost(double cost) {
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative");
        this.cost = cost;
    }

    /** CSV representation */
    public String toCSV() {
        return String.join(",", ID, name, description, String.valueOf(cost));
    }

    /** JSON representation */
    public String toJSON() {
        return String.format("{\"ID\":\"%s\",\"name\":\"%s\",\"description\":\"%s\",\"cost\":%.2f}",
                ID, name, description, cost);
    }

    /** XML representation */
    public String toXML() {
        return String.format("<Product><ID>%s</ID><Name>%s</Name><Description>%s</Description><Cost>%.2f</Cost></Product>",
                ID, name, description, cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 && Objects.equals(name, product.name)
                && Objects.equals(description, product.description) && Objects.equals(ID, product.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, ID, cost);
    }
}
