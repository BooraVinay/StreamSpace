package com.akshathsaipittala.streamspace.services;

import com.akshathsaipittala.streamspace.indexer.LocalMediaIndexer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ForegroundServices {

    final LocalMediaIndexer localMediaIndexer;

    @Async
    @EventListener
    public void onApplicationReadyEvent(ApplicationReadyEvent readyEvent) throws IOException {
        log.info("Started LocalMediaIndexer");
        localMediaIndexer.indexMedia();
        log.info("Stopped Media Indexer");
    }

     /*@Async
    @Scheduled(fixedDelay = 3, timeUnit = TimeUnit.MINUTES)
    public void printHeapUsage() {
        log.info(Stats.printHeapMemoryUsage());
    }*/

    /*@Async
    @CacheEvict(allEntries = true, value = {"getMostWatchedMovies"})
    @Scheduled(fixedDelay = 45, timeUnit = TimeUnit.MINUTES)
    public void clearCache() {
        log.info("Cache cleared");
    }*/

}