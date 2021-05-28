package com.filereader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigParserDevelopmentTest {

    String nameOfFile = "config.txt.dev";
    ConfigParser config = new ConfigParser(nameOfFile);

    @BeforeEach
    void setUp() {
    }


    @Test
    void testForDevelopmentDbname() {
        assertEquals("sq04_db-development", config.get("dbname"));
    }

    @Test
    void testForDevelopmentHost() {
        assertEquals("127.0.0.1", config.get("host"));
    }

    @Test
    void testForDevelopmentApplicationName() {
        assertEquals("fintek-development", config.get("application.name"));
    }

    @Test
    void testForDevelopmentApplicationPort() {
        assertEquals("8082", config.get("application.port"));
    }

    @Test
    void testForDevelopmentApplicationContext_url() {
        assertEquals("/api/v1", config.get("application.context-url"));
    }

    @Test
    void testForDevelopmentMode() {
        assertEquals("development", config.get("mode"));
    }

    @Test
    void testForDevelopmentTheme() {
        assertEquals("yellow", config.get("theme"));
    }

    @Test
    void testForDevelopmentPipeline() {
        assertEquals("fast-development", config.get("pipeline"));
    }
}


