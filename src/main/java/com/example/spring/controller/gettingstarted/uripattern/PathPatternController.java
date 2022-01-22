package com.example.spring.controller.gettingstarted.uripattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.pattern.PathPatternParser;

import java.io.IOException;

@RestController
@Slf4j
public class PathPatternController
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    // -------------------- [Public Fields] --------------------

    // ============================== [Construction / Destruction] ==============================

    // -------------------- [Private Construction / Destruction] --------------------

    // -------------------- [Public Construction / Destruction] --------------------

    // ============================== [Spring Beans] ==============================

    // -------------------- [Public Spring Beans] --------------------

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

    /**
     * Requires the {@link org.springframework.web.util.pattern.PathPatternParser} to be specified in the web configuration
     * ({@link com.example.spring.controller.gettingstarted.config.WebConfig}).
     */
    @GetMapping(path = "path/pattern/all/{*path}")
    public ResponseEntity<String> get(@PathVariable String path) throws IOException
    {
        log.info("The custom path '{}' has been specified after the prefix path.", path);

        return ResponseEntity.ok(path);
    }
}
