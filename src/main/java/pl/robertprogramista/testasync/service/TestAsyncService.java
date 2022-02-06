package pl.robertprogramista.testasync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

@Service
public class TestAsyncService {
    private static final Logger logger = LoggerFactory.getLogger(TestAsyncService.class);
    private static final String THE_END = "THE END";

    public CompletableFuture<String> tellLongStory() throws InterruptedException, ExecutionException {
        final String uuid = String.valueOf(UUID.randomUUID());
        logger.info("Hello async... uuid: {}", uuid);
        CompletableFuture<String> async = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(10000);
            async.complete(THE_END);
            logger.info("Goodbye async...  uuid: {}", uuid);
            return THE_END;
        });

        return async;
    }

    @Async
    public void async() throws InterruptedException {
        final String uuid = String.valueOf(UUID.randomUUID());
        logger.info("Hello @Async... uuid: {}", uuid);
        Thread.sleep(10000);
        logger.info("Goodbye @Async...  uuid: {}", uuid);
    }

    public void notAsync() throws InterruptedException {
        final String uuid = String.valueOf(UUID.randomUUID());
        logger.info("Hello not async... uuid: {}", uuid);
        Thread.sleep(10000);
        logger.info("Goodbye not async...  uuid: {}", uuid);
    }
}
