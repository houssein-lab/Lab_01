import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person p;

    @BeforeEach
    void setUp() {
        p = new Person("Bilbo", "Baggins", "000001", "Mr.", 1960);
    }

    @Test
    void testFullName() {
        assertEquals("Bilbo Baggins", p.fullName());
    }

    @Test
    void testFormalName() {
        assertEquals("Mr. Bilbo Baggins", p.formalName());
    }

    @Test
    void testGetAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(String.valueOf(currentYear - 1960), p.getAge());
    }
    @Test
    void testGetAgeSpecific() {
        assertEquals("40", p.getAge(2000));
    }
    @Test
    void testToCSV() {
        assertEquals("000001,Bilbo,Baggins,Mr.,1960", p.toCSV());
    }

    @Test
    void testToJSON() {
        assertTrue(p.toJSON().contains("\"Bilbo\""));
    }

    @Test
    void testToXML() {
        assertTrue(p.toXML().contains("<Person>"));
    }
}
