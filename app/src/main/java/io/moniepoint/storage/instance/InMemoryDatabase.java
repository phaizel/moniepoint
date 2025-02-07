package io.moniepoint.storage.instance;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDatabase<Key, Value> implements AbstractMonieStorageEngine <Key, Value> {

  private Map<Key, Value> DB = new ConcurrentHashMap<>();

  @Override
  public boolean put(Key key, Value value) {
    return DB.putIfAbsent(key, value) == null;
  }

  @Override
  public Value read(Key key) {
    return DB.getOrDefault(key, null);
  }

  @Override
  public Collection<Value> readKeyRange(Key startKey, Key endKey) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'readKeyRange'");
  }

  @Override
  public boolean batchPut(Map<Key, Value> values) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'batchPut'");
  }

  @Override
  public boolean deleteKey(Key key) {
    return DB.remove(key) != null;
  }

}
