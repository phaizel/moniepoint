package io.moniepoint.storage.instance;

import io.moniepoint.storage.StorageEngineConnection;

public final class StorageEngineFactory {

  private StorageEngineFactory() { }

  public static <K, V> AbstractMonieStorageEngine<K, V> getInstance(StorageEngine engine, StorageEngineConnection conn) {
    switch (engine) {
      case StorageEngine.InMemory:
        return new InMemoryDatabase<K, V>();
      case StorageEngine.MySQL:
        return new MySqlDatabase<K,V>(conn);
     default:
        return new InMemoryDatabase<K, V>();
    }
  }
}
