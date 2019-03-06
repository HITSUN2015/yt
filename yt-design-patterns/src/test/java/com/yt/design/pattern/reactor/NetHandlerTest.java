package com.yt.design.pattern.reactor;

import com.google.common.base.Stopwatch;
import com.yt.design.pattern.reactor.old.OneConnectionOneThread;
import com.yt.design.pattern.reactor.old.OneThread;
import org.testng.annotations.Test;

import java.util.concurrent.*;

/**
 * Created by yantong on 2019/3/6.
 * <p>
 * 同一个机器上测试，施压端 会 影响 被测试服务
 */
@Test
public class NetHandlerTest {

    private int REQUEST_COUNT = 100;

    @Test
    public void test() {
        NetHandler oneThreadHandler = new OneThread();
        TestResult oneThreadResult = testOneThreadHandler(oneThreadHandler);
        NetHandler oneConnectionOneThreadHandler = new OneConnectionOneThread();
        TestResult oneConnectionOneThreadResult = testOneThreadHandler(oneConnectionOneThreadHandler);

        System.out.println(oneThreadResult.getResult());
        System.out.println(oneConnectionOneThreadResult.getResult());

    }

    private TestResult testOneThreadHandler(NetHandler netHandler) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 100000,
                10L, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>());

        TestResult testResult = new TestResult(netHandler.getClass(), REQUEST_COUNT, netHandler.getCalculateCounter());
        testManyRequest(netHandler, executor);
        waitAllWorkFinish(netHandler);
        executor.shutdownNow();
        testResult.getResult();
        return testResult;
    }

    private void waitAllWorkFinish(NetHandler netHandler) {
        if (netHandler instanceof MultiThread) {
            while (!((MultiThread) netHandler).isAllWorkDone()) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void testManyRequest(NetHandler netHandler, ThreadPoolExecutor executor) {
        for (int i = 0; i < REQUEST_COUNT; i++) {
            FutureTask ft = new FutureTask(() -> {
                return netHandler.handle();
            });
            executor.submit(ft);
            try {
                System.out.println(ft.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    private class TestResult {
        private Class testClass;
        private int requestCount;
        private int calculateCount;
        private long timeCost = 0;
        private Stopwatch stopwatch;

        public TestResult(Class testClass, int requestCount, int calculateCount) {
            this.testClass = testClass;
            this.requestCount = requestCount;
            this.calculateCount = calculateCount;
            stopwatch = Stopwatch.createStarted();
        }

        public TestResult buildTestClass(Class testClass) {
            this.testClass = testClass;
            return this;
        }

        public TestResult buildRequestCount(int requestCount) {
            this.requestCount = requestCount;
            return this;
        }

        public TestResult buildCalculateCount(int calculateCount) {
            this.calculateCount = calculateCount;
            return this;
        }

        public String getResult() {
            if (timeCost == 0) {
                long nanos = stopwatch.elapsed(TimeUnit.NANOSECONDS);
                this.timeCost = TimeUnit.NANOSECONDS.toSeconds(nanos);
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("测试类：").append(testClass)
                    .append("\n测试压力（循环请求数）：").append(requestCount).append("次")
                    .append("\n单个任务计算执行次数：").append(calculateCount).append("次")
                    .append("\n耗时：").append(timeCost).append(" 秒");
            return stringBuilder.toString();
        }
    }

}
