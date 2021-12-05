package net.javaguides.datetime;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Example1 {
    public static void main(String[] args) {
        // Instant ： 时间戳(以 Unix 元年:1970年1月1日00:00:00到某个时间之间的毫秒值)
        Instant instant=Instant.now(); // 默认获取的是UTC 时区
        System.out.println(instant); // 2021-12-05T15:32:41.590Z

        OffsetDateTime offsetDateTime =instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2021-12-05T23:32:41.590+08:00

        // Converts this instant(时间戳) to the number of milliseconds(毫秒) from the epoch(纪元) of 1970-01-01T00:00:00Z.
        System.out.println(instant.toEpochMilli()); // 毫秒
    }
}
