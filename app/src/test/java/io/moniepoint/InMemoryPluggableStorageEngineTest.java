package io.moniepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.moniepoint.storage.MoniePluggableStorageEngine;
import io.moniepoint.storage.instance.StorageEngine;

public class InMemoryPluggableStorageEngineTest {

  @Test void aSimpleRecordIsStoredAndFound() {
      MoniePluggableStorageEngine<String, String> engine = new MoniePluggableStorageEngine<>(StorageEngine.InMemory);
      assertTrue(engine.put("A", "Apple"));
      String apple = engine.read("A");
      assertEquals(apple, "Apple", "record not found");
  }

  @Test void aStoredRecordIsNotOverwritten() {
      MoniePluggableStorageEngine<String, String> engine = new MoniePluggableStorageEngine<>(StorageEngine.InMemory);
      assertTrue(engine.put("A", "Apple"));
      assertFalse(engine.put("A", "Ant"));
      String apple = engine.read("A");
      assertEquals(apple, "Apple", "record not found");
  }

  @Test void aComplexRecordIsStoredAndFound() {
      MoniePluggableStorageEngine<Integer, Person> engine = new MoniePluggableStorageEngine<>(StorageEngine.InMemory);
      Person peter = new Person("Peter","Apple", 20);
      assertTrue(engine.put(1, peter));
      assertEquals(engine.read(1), peter, "record not found");
  }
}
