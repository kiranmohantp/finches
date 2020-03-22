package com.finches.finchesservice.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IpAddressValidatorTest {
    private IpAddressValidator addressValidator = new IpAddressValidator();

    @Test
    public void validator_should_return_true() {
        Assertions.assertTrue(addressValidator.isValid("123.112.123.123", null));
    }

    @Test
    public void validator_should_return_false() {
        Assertions.assertFalse(addressValidator.isValid("888.112.123.123", null));
    }
}