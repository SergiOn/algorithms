package hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * "e" => false
 * "3. " => true
 * ".1." => false
 * " .9" => true
 * " ." => false
 * "4e+" => false
 * "+.8" => true
 * " -." => false
 * "46.e3" => true
 * ".e1" => false
 */

class ValidNumberTest {

    private ValidNumber sut;

    @BeforeEach
    void beforeEach() {
        sut = new ValidNumber();
    }

    @Test
    void isNumber1() {
        assertTrue(sut.isNumber("0"));
    }

    @Test
    void isNumber2() {
        assertTrue(sut.isNumber(" 0.1 "));
    }

    @Test
    void isNumber3() {
        assertFalse(sut.isNumber("abc"));
    }

    @Test
    void isNumber4() {
        assertFalse(sut.isNumber("1 a"));
    }

    @Test
    void isNumber5() {
        assertTrue(sut.isNumber("2e10"));
    }

    @Test
    void isNumber6() {
        assertTrue(sut.isNumber(" -90e3   "));
    }

    @Test
    void isNumber7() {
        assertFalse(sut.isNumber(" 1e"));
    }

    @Test
    void isNumber8() {
        assertFalse(sut.isNumber("e3"));
    }

    @Test
    void isNumber9() {
        assertTrue(sut.isNumber(" 6e-1"));
    }

    @Test
    void isNumber10() {
        assertFalse(sut.isNumber(" 99e2.5 "));
    }

    @Test
    void isNumber11() {
        assertTrue(sut.isNumber("53.5e93"));
    }

    @Test
    void isNumber12() {
        assertFalse(sut.isNumber(" --6 "));
    }

    @Test
    void isNumber13() {
        assertFalse(sut.isNumber("-+3"));
    }

    @Test
    void isNumber14() {
        assertFalse(sut.isNumber("95a54e53"));
    }

    @Test
    void isNumber15() {
        assertFalse(sut.isNumber("e"));
    }

    @Test
    void isNumber16() {
        assertTrue(sut.isNumber("3. "));
    }

    @Test
    void isNumber17() {
        assertFalse(sut.isNumber(".1."));
    }

    @Test
    void isNumber18() {
        assertTrue(sut.isNumber(" .9"));
    }

    @Test
    void isNumber19() {
        assertFalse(sut.isNumber(" ."));
    }

    @Test
    void isNumber20() {
        assertFalse(sut.isNumber("4e+"));
    }

    @Test
    void isNumber21() {
        assertTrue(sut.isNumber("+.8"));
    }

    @Test
    void isNumber22() {
        assertFalse(sut.isNumber(" -."));
    }

    @Test
    void isNumber23() {
        assertTrue(sut.isNumber("46.e3"));
    }

    @Test
    void isNumber24() {
        assertFalse(sut.isNumber(".e1"));
    }

    @Test
    void checkSpace() throws Exception {
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkSpace", ' '));
        assertFalse(Whitebox.<Boolean>invokeMethod(sut, "checkSpace", 'r'));
    }

    @Test
    void checkNumber() throws Exception {
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '1'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '2'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '3'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '4'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '5'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '6'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '7'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '8'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '9'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", '0'));
        assertFalse(Whitebox.<Boolean>invokeMethod(sut, "checkNumber", 'o'));
    }

    @Test
    void checkE() throws Exception {
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkE", 'e'));
        assertFalse(Whitebox.<Boolean>invokeMethod(sut, "checkE", ' '));
    }

    @Test
    void checkDecimalPoint() throws Exception {
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkDecimalPoint", '.'));
        assertFalse(Whitebox.<Boolean>invokeMethod(sut, "checkDecimalPoint", ','));
    }

    @Test
    void checkSign() throws Exception {
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkSign", '-'));
        assertTrue(Whitebox.<Boolean>invokeMethod(sut, "checkSign", '+'));
        assertFalse(Whitebox.<Boolean>invokeMethod(sut, "checkSign", '='));
    }

}