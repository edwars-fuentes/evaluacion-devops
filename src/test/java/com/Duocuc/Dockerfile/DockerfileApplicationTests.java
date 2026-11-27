package com.Duocuc.Dockerfile;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        // Prueba unitaria básica que verifica que el contexto de Spring levanta correctamente
    }

    @Test
    void forzarFalloIe6() {
        fail("Falla controlada para validar corte de pipeline IE6");
    }
}
