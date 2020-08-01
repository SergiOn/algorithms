package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class AddTwoNumbersTest {

    private AddTwoNumbers sut;

    @BeforeEach
    void setUp() {
        sut = new AddTwoNumbers();
    }

    @Test
    void test1() {
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(2, new AddTwoNumbers.ListNode(4, new AddTwoNumbers.ListNode(3)));
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(5, new AddTwoNumbers.ListNode(6, new AddTwoNumbers.ListNode(4)));

        AddTwoNumbers.ListNode actual = sut.addTwoNumbers(l1, l2);
        AddTwoNumbers.ListNode expected = new AddTwoNumbers.ListNode(7, new AddTwoNumbers.ListNode(0, new AddTwoNumbers.ListNode(8)));

        assertThat(actual, equalTo(expected));
    }

    @Test
    void test2() {
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(5);

        AddTwoNumbers.ListNode actual = sut.addTwoNumbers(l1, l2);
        AddTwoNumbers.ListNode expected = new AddTwoNumbers.ListNode(0, new AddTwoNumbers.ListNode(1));

        assertThat(actual, equalTo(expected));
    }

    @Test
    void test3() {
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(1, new AddTwoNumbers.ListNode(8));
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(0);

        AddTwoNumbers.ListNode actual = sut.addTwoNumbers(l1, l2);
        AddTwoNumbers.ListNode expected = new AddTwoNumbers.ListNode(1, new AddTwoNumbers.ListNode(8));

        assertThat(actual, equalTo(expected));
    }

    @Test
    void test4() {
        AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(0);
        AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(7, new AddTwoNumbers.ListNode(3));

        AddTwoNumbers.ListNode actual = sut.addTwoNumbers(l1, l2);
        AddTwoNumbers.ListNode expected = new AddTwoNumbers.ListNode(7, new AddTwoNumbers.ListNode(3));

        assertThat(actual, equalTo(expected));
    }

}