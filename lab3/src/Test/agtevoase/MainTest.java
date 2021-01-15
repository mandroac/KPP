package agtevoase;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @org.junit.jupiter.api.Test
    void isValidEmailAddress() {
        assertTrue(Utils.isValidEmailAddress("a@b.com"));
        assertTrue(Utils.isValidEmailAddress("a@i.ua"));
        assertFalse(Utils.isValidEmailAddress("..@b.com"));
        assertTrue(Utils.isValidEmailAddress("?!?@b.com"));
        assertTrue(Utils.isValidEmailAddress("зааза@b.com"));
        assertTrue(Utils.isValidEmailAddress("hi@localhost"));
        assertFalse(Utils.isValidEmailAddress("@"));
        assertTrue(Utils.isValidEmailAddress("holovatyi@example.com"));
    }


}