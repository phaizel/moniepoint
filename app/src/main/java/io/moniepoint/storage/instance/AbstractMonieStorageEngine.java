package io.moniepoint.storage.instance;

import java.util.Collection;
import java.util.Map;

public interface AbstractMonieStorageEngine<Key, Value> {
  boolean put(Key key, Value value);
  Value read(Key key);
  Collection<Value> readKeyRange(Key startKey, Key endKey);
  boolean batchPut(Map<Key, Value> values);
  boolean deleteKey(Key key);
}