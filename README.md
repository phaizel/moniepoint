# Get Started
This is a Proof of Concept to illustrate how a pluggable component can be designed to abstract the implementation details for the database system used under the hood. It intentionally lacks a lot of the functionality, as the problem statement is broad and there are numerous alternatives that can be explored to get to a desired solution. Focus has been put on the design to hide the implementation details from the clients.

Below test illustrates how to use the `PluggableStorageEngine`. This is all that clients will need to be aware of, and it preserves the API as outlined in the assignment.
```java
@Test void aComplexRecordIsStoredAndFound() {
      MoniePluggableStorageEngine<Integer, Person> engine = new MoniePluggableStorageEngine<>(StorageEngine.InMemory);
      Person peter = new Person("Peter","Apple", 20);
      assertTrue(engine.put(1, peter));
      assertEquals(engine.read(1), peter, "record not found");
  }
```
To run all tests:
> ./gradlew test

### Notes
All interactions with the database system will be achieved via an instance of a `MoniePluggableStorageEngine`. Take note of the following:
1. The data type for the Key and the Value will be specified. In the above example Key is of type Integer and value would be a Persion record. Think of Key as Primary Key in database systems.
2. `StorageEngine` specifies the underlying database system that will be used to persist the data.
3. Each instance of `MoniePluggableStorageEngine` represents a collection / table. When program stops running then data is lost.
4. Emphasis is on the design, and how it can be used to abstract the implementation details. As result, there is room to iterate and implement the desired capabilities making informed trade-offs as this can immediately be put to use.

## Assumptions, Observations & Musings.
- This pluggable component is meant to act as a facade to the database management system.
- Existing database systems like PostgreSQL, MongoDB, Redis etc will still be used to store the data.
- The pluggable components are accessible as versioned libraries that are included in projects as dependencies.
- Each supported database system will need an implementation of `AbstractMonieStorageEngine` that encapsulates the logic to target that database.
  - If a database system is what's expected (opposed to the implemented facade), then an implementation can be implemented that implements `AbstractMonieStorageEngine` and uses it's own specific IO capabilities with appropriate tradeoffs taken into consideration. So far in my experience, existing solutions have been able to satisfy the needs for the problems I have encountered.
- This pluggable approach makes it easy to add cross-cutting concerns with minimal effort from all teams other than getting the relevant version that supports the feature you need, and enabling/configuring as expected. E.g of cross-cutting concerns that can be implemented via this approach are adding audit trail capabilities for each database operation, or adding observability capability, or masking sensitive data like PII...
- This implementation is simplistic, a mere proof of concept on how to possibly design the pluggable component.
- The concept of `StorageEngineConnection` is minimalistic, and not fully developed. It's a mere encapsulation of how to access the database system. Future improvements:
  - Split database writes from reads capabilities to allow scaling according to if database is read or write heavy. Explore adopting a CQRS approach.
  - Concurrency or parallelism needs to be implemented to enable better scaling and better throughput.
  - How to map each collection into a corresponding table. This version does not cover how to stipulate the name of collection/table being targeted.
  - If custom implementation is opted for, then replication would be a serious consideration.
  - For network awareness, an appropriate protocol would also need to be evaluated for.
  - Error handling is missing as well.
- Security concerns have been neglected. Beyond the scope of my capabilities.


This is a massive problem space. There already exist various database options that sufficiently solve many of the stated problems. Evaluating one of these options and adopting one meets the criteria would be a faster starting option.