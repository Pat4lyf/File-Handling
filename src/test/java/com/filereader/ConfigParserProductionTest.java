package com.filereader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigParserProductionTest {
    String nameOfFile = "config.txt";
    ConfigParser config = new ConfigParser(nameOfFile);

    @BeforeEach
    void setUp() {
    }


    @Test
    void testForProductionDbname() {
        assertEquals("sq04_db", config.get("dbname"));
    }

    @Test
    void testForProductionHost() {
        assertEquals("127.0.0.1", config.get("host"));
    }

    @Test
    void testForProductionApplicationName() {
        assertEquals("fintek", config.get("application.name"));
    }

    @Test
    void testForProductionApplicationPort() {
        assertEquals("8080", config.get("application.port"));
    }

    @Test
    void testForProductionApplicationContext_url() {
        assertEquals("/api/v1", config.get("application.context-url"));
    }

    @Test
    void testForProductionMode() {
        assertEquals("production", config.get("mode"));
    }

    @Test
    void testForProductionTheme() {
        assertEquals("green", config.get("theme"));
    }

    @Test
    void testForProductionPipeline() {
        assertEquals("fast", config.get("pipeline"));
    }
}

