import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product prod;
    @BeforeEach
    void setUp() {
        prod = new Product("Laptop", "Gaming Laptop", "P001", 1200.50);
    }

    @Test
    void testName() {
        assertEquals("Laptop", prod.getName());
    }

    @Test
    void testDescription() {
        assertEquals("Gaming Laptop", prod.getDescription());
    }
    @Test
    void testCost() {
        assertEquals(1200.50, prod.getCost());
    }
    @Test
    void testToCSV() {
        assertEquals("P001,Laptop,Gaming Laptop,1200.5", prod.toCSV());
    }

    @Test
    void testToJSON() {
        assertTrue(prod.toJSON().contains("\"Laptop\""));
    }
    @Test
    void testToXML() {
        assertTrue(prod.toXML().contains("<Product>"));
    }
}
