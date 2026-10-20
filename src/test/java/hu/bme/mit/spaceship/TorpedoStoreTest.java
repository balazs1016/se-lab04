package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test 
    void failuer_fire_Fail() {
        TorpedoStore store = new TorpedoStore(1, 1);

        boolean result = store.fire(1);

        assertEquals(false, result);
    }

    @Test 
    void failuer_fire_Success() {
        TorpedoStore store = new TorpedoStore(1, 0.0);

        boolean result = store.fire(1);

        assertEquals(true, result);
    }

    @Test 
    void store_decrease() {
        TorpedoStore store = new TorpedoStore(10, 0.0);
        store.fire(1);
        assertEquals(9, store.getTorpedoCount());
    }

    @Test 
    void fire_few() {
        TorpedoStore store = new TorpedoStore(10, 0.0);
        assertThrows( IllegalArgumentException.class, () -> store.fire(0));
    }

    @Test 
    void fire_Many() {
        TorpedoStore store = new TorpedoStore(1, 0.0);
        assertThrows( IllegalArgumentException.class, () -> store.fire(2));
    }
}
