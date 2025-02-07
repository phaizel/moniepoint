
package io.moniepoint.storage;

import java.util.Collection;
import java.util.Map;

import io.moniepoint.storage.instance.AbstractMonieStorageEngine;
import io.moniepoint.storage.instance.StorageEngine;
import io.moniepoint.storage.instance.StorageEngineFactory;

public final class MoniePluggableStorageEngine<K, V> implements PluggableStorageEngine<K, V> {

  private StorageEngineConnection conn;
  private AbstractMonieStorageEngine<K, V> storage;

  public MoniePluggableStorageEngine(StorageEngineConnection conn, StorageEngine engine) {
    this.storage = StorageEngineFactory.getInstance(engine, conn);
  }

  public MoniePluggableStorageEngine(StorageEngine engine) {
    this.storage = StorageEngineFactory.getInstance(engine, null);
  }

  @Override
  public boolean put(K key, V value) {
    return this.storage.put(key, value);
  }

  @Override
  public V read(K key) {
    return this.storage.read(key);
  }

  // @Override
  public Collection<V> readKeyRange(K startKey, K endKey) {
    return this.storage.readKeyRange(startKey, endKey);
  }

  @Override
  public boolean batchPut(Map<K, V> values) {
    return this.storage.batchPut(values);
  }

  @Override
  public boolean deleteKey(K key) {
    return this.storage.deleteKey(key);
  }

}