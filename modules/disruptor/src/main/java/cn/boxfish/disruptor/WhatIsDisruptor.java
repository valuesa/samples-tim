package cn.boxfish.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.Executors;

/**
 * Created by LuoLiBing on 17/2/28.
 * disruptor是什么
 * 1 一种数据结构, 无竞争的工作流
 * 2 快速消息传递
 * 3 允许真正的平行
 *
 * Disruptor
 * 1 ring buffer需要大于12个节点
 * 2 各自的handlers在分离的线程当中
 *
 * 使用场景
 * 1 可以让我们专注于领域建模
 * 2 能够并行但是单线程
 * 3 简单
 * 4 可靠的排序
 * 5 快速
 */
public class WhatIsDisruptor {

    static class Event {
        private static long counter = 0;
        private long id = counter++;
        private String path;

        public Event() {
        }

        public Event(long id, String path) {
            this.id = id;
            this.path = path;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "id=" + id +
                    ", path='" + path + '\'' +
                    '}';
        }
    }

    @Test
    public void sample1() throws IOException {
        Disruptor<Event> disruptor = new Disruptor<>(Event::new, 1024, Executors.defaultThreadFactory());
        disruptor.handleEventsWith(new LoggerEventHandler(), new StoreEventHandler());
        disruptor.start();

        RingBuffer<Event> ringBuffer = disruptor.getRingBuffer();
        Files.walkFileTree(Paths.get("/share/json"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String fileName = file.getFileName().toString();
                if (fileName.endsWith(".json") || fileName.endsWith(".xls")) {
                    ringBuffer.publishEvent((event, seq) -> event.setPath(file.getFileName().toString()));
                }
                return FileVisitResult.CONTINUE;
            }
        });
        disruptor.shutdown();
    }

    class LoggerEventHandler implements EventHandler<Event> {

        @Override
        public void onEvent(Event event, long sequence, boolean endOfBatch) throws Exception {
            System.out.println(Thread.currentThread().getId() + ": logger info sequence " + sequence + ", event: " + event);
        }
    }

    class StoreEventHandler implements EventHandler<Event> {

        @Override
        public void onEvent(Event event, long sequence, boolean endOfBatch) throws Exception {
            System.out.println(Thread.currentThread().getId() + ": store database sequence " + sequence + ", event: " + event);
        }
    }
}
