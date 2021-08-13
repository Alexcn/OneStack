package net.geektop.common.sequence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Alex
 * @version V1.0
 * @Package net.geektop.common.sequence
 * @date 2020/11/23 16:30
 */
@SpringBootTest
class SnowflakeImplTest {

  private static final Logger logger = LoggerFactory.getLogger(SnowflakeImplTest.class);
  private static SnowflakeImpl snowflake;

  @BeforeAll
  public static void init() {
    long[] dataCenterIds = new long[]{0, 1, 2, 3};
    int rnd = new Random().nextInt(dataCenterIds.length);
    snowflake = new SnowflakeImpl(dataCenterIds[rnd]);
  }

  @Test
  void nextId() {
    final Long aLong = snowflake.nextId();
    logger.info("Get the next long id is: {}", aLong);
  }

  @Test
  void duplicateTest() throws InterruptedException {
    assertTrue(multiThreadDuplicateTest(snowflake));
  }

  @Test
  void duplicateClockTest() throws InterruptedException {
    final SnowflakeImpl newSnowVersion = new SnowflakeImpl(0, true, false);
    assertTrue(multiThreadDuplicateTest(newSnowVersion));
  }

  private boolean multiThreadDuplicateTest(SnowflakeImpl snowflake) throws InterruptedException {
    int generateCount = 10000;
    final Set<Long> idSet = ConcurrentHashMap.newKeySet();
    final Thread t1 = new Thread(() -> addIdToSet(idSet, snowflake, generateCount));
    final Thread t2 = new Thread(() -> addIdToSet(idSet, snowflake, generateCount));
    final Thread t3 = new Thread(() -> addIdToSet(idSet, snowflake, generateCount));
    final Thread t4 = new Thread(() -> addIdToSet(idSet, snowflake, generateCount));
    final long start = System.currentTimeMillis();
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t1.join();
    t2.join();
    t3.join();
    t4.join();
    final long end = System.currentTimeMillis();
    logger.info("consume time is: {}", end - start);
    return idSet.size() == generateCount*4;
  }

  private void addIdToSet(Set<Long> idSet, SnowflakeImpl snowflake, int generateCount) {
    logger.info("start the thread: {}", Thread.currentThread().getName());
    for (int i = 0; i < generateCount; i++) {
      final Long aLong = snowflake.nextId();
      idSet.add(aLong);
    }
  }

}
