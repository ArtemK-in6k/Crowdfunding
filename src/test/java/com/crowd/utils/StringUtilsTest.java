package com.crowd.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void shouldTrueIsBlankWhenStringIsEmpty(){
        boolean isBlank = StringUtils.isBlank("");
        Assert.assertEquals(true, isBlank);
    }

    @Test
    public void shouldTrueIsBlankWhenStringIsNull(){
        boolean isBlank = StringUtils.isBlank(null);
        Assert.assertEquals(true, isBlank);
    }

    @Test
    public void shouldTrueIsBlankWhenStringContainsOnlyFromSpaces(){
        boolean isBlank = StringUtils.isBlank("             ");
        Assert.assertEquals(true, isBlank);
    }

    @Test
    public void shouldBeFalseIsBlankWhenStringNotEmpty(){
        boolean isBlank = StringUtils.isBlank("Not empty stirng");
        Assert.assertEquals(false, isBlank);
    }

    @Test
    public void shouldBeFalseIsBlankWhenStringNotEmptyAndContainsSpaces(){
        boolean isBlank = StringUtils.isBlank("Not empty stirng     ");
        Assert.assertEquals(false, isBlank);
    }
}
