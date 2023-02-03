package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCondition {
    private Condition c;

    @BeforeEach
    public void setUp() {
        c = new Condition("Test");
    }

    @Test
    public void testConstructor() {
        assertEquals("Test", c.getName());
    }
}
