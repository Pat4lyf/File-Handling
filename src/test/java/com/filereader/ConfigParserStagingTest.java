package com.filereader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserStagingTest {
    String nameOfFile = "config.txt.staging";
    ConfigParser config = new ConfigParser(nameOfFile);

    @BeforeEach
    void setUp() {
    }


    @Test
    void testForStagingDbname() {
        assertEquals("sq04_db", config.get("dbname"));
    }

    @Test
    void testForStagingHost() {
        assertEquals("127.0.0.1", config.get("host"));
    }

    @Test
    void testForStagingApplicationName() {
        assertEquals("fintek-staging", config.get("application.name"));
    }

    @Test
    void testForStagingApplicationPort() {
        assertEquals("8081", config.get("application.port"));
    }

    @Test
    void testForStagingApplicationContext_url() {
        assertEquals("/api/v1", config.get("application.context-url"));
    }

    @Test
    void testForStagingMode() {
        assertEquals("staging", config.get("mode"));
    }

    @Test
    void testForStagingTheme() {
        assertEquals("blue", config.get("theme"));
    }

    @Test
    void testForStagingPipeline() {
        assertEquals("fast-staging", config.get("pipeline"));
    }
}