package com.finches.finchesservice.validators;

import com.finches.finchesservice.entities.Leader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdNotNullValidatorTest {
    private IdNotNullValidator idNotNullValidator = new IdNotNullValidator();

    @Test
    public void should_return_true() {
        Leader leader = new Leader("ID");
        Assertions.assertTrue(idNotNullValidator.isValid(leader, null));
    }

    @Test
    public void should_return_false() {
        Leader leader = new Leader();
        Assertions.assertFalse(idNotNullValidator.isValid(leader, null));
    }

    @Test
    public void should_log_exception_and_return_false__if_id_not_present_in_model_false() {
        Object object = new Object();
        Assertions.assertFalse(idNotNullValidator.isValid(object, null));
    }
}