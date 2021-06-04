package sk.kosickaakademia.spivak.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testHashCode() {
        assertEquals(53,Main.hashCode("Spivak"));
        assertEquals(729,Main.hashCode("Pokhidniak"));
        assertEquals(726,Main.hashCode("Havrilenko"));
        assertEquals(130812,Main.hashCode("$%^  tgfir 564 oy"));
        assertEquals(1016,Main.hashCode("1234532oye"));
    }
}