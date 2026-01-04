package com.fullcycle.admin.catalogo.infrastructure;

import com.fullcycle.admin.catalogo.application.UseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testMain() {
        Assertions.assertNotNull(new UseCase());
        UseCase.main(new String[]{});
    }

}