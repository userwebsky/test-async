package pl.robertprogramista.testasync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.robertprogramista.testasync.service.TestAsyncService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/test-async")
public class TestAsyncController {

    private TestAsyncService testAsyncService;

    public TestAsyncController(TestAsyncService testAsyncService) {
        this.testAsyncService = testAsyncService;
    }

    @GetMapping
    public CompletableFuture<String> theEnd() throws InterruptedException, ExecutionException {
        testAsyncService.tellLongStory().thenApplyAsync(result -> result);
        return testAsyncService.tellLongStory().thenApplyAsync(result -> result);
    }

    @GetMapping("/async-with-annotation")
    public String async() throws InterruptedException {
        testAsyncService.async();
        testAsyncService.async();
        return "THE END";
    }

    @GetMapping("/not-async")
    public String notAsync() throws InterruptedException {
        testAsyncService.notAsync();
        testAsyncService.notAsync();
        return "THE END";
    }
}
