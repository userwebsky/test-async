package pl.robertprogramista.testasync.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TestAsyncServiceTest {
    private TestAsyncService testAsyncService;

    @BeforeEach
    void beforeInit() {
        testAsyncService = new TestAsyncService();
    }

    @Test
    void tellLongStory() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = testAsyncService.tellLongStory();
        assertThat(stringCompletableFuture).isNotCompleted();
        Thread.sleep(11000);
        assertThat(stringCompletableFuture).isCompleted();
        assertThat(testAsyncService.tellLongStory().get()).isEqualTo("THE END");
    }

    @Test
    void async() throws InterruptedException {
        testAsyncService.async();
        assertTrue(true);
    }

    @Test
    void notAsync() throws InterruptedException {
        testAsyncService.notAsync();
        assertTrue(true);
    }
}