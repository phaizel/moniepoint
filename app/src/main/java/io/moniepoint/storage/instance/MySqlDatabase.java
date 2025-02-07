package io.moniepoint.storage.instance;

import java.security.Key;
import java.util.Collection;
import java.util.Map;

import io.moniepoint.storage.StorageEngineConnection;

// FIXME how to implement specific instances without relying on external drivers/dependencies?
public class MySqlDatabase<Key, Value> implements AbstractMonieStorageEngine <Key, Value> {

  private StorageEngineConnection conn;

  public MySqlDatabase(StorageEngineConnection conn) {
    this.conn = conn;
  }

  @Override
  public boolean put(Key key, Value value) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'put'");
  }

  @Override
  public Value read(Key key) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'read'");
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteKey'");
  }

}
