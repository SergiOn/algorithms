package medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateBinarySearchTreeTest {

    private ValidateBinarySearchTree sut;

    @BeforeEach
    void setUp() {
        sut = new ValidateBinarySearchTree();
    }

/**    2
 *    / \
 *   1   3
 * Input: [2,1,3]
 * Output: true
 */
    @Test
    void test1() {
        final ValidateBinarySearchTree.TreeNode n1l = new ValidateBinarySearchTree.TreeNode(1);
        final ValidateBinarySearchTree.TreeNode n1r = new ValidateBinarySearchTree.TreeNode(3);
        final ValidateBinarySearchTree.TreeNode n1 = new ValidateBinarySearchTree.TreeNode(2, n1l, n1r);

        assertTrue(sut.isValidBST(n1));
    }

/**    5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
    @Test
    void test2() {
        final ValidateBinarySearchTree.TreeNode n1l = new ValidateBinarySearchTree.TreeNode(1);

        final ValidateBinarySearchTree.TreeNode n12l = new ValidateBinarySearchTree.TreeNode(3);
        final ValidateBinarySearchTree.TreeNode n12r = new ValidateBinarySearchTree.TreeNode(6);
        final ValidateBinarySearchTree.TreeNode n1r = new ValidateBinarySearchTree.TreeNode(4, n12l, n12r);

        final ValidateBinarySearchTree.TreeNode n1 = new ValidateBinarySearchTree.TreeNode(5, n1l, n1r);

        assertFalse(sut.isValidBST(n1));
    }

    @Test
    void test3() {
        assertTrue(sut.isValidBST(null));
    }

    @Test
    void test4() {
        final ValidateBinarySearchTree.TreeNode n1l = new ValidateBinarySearchTree.TreeNode(1);
        final ValidateBinarySearchTree.TreeNode n1 = new ValidateBinarySearchTree.TreeNode(1, n1l, null);

        assertFalse(sut.isValidBST(n1));
    }

/**
 *     10
 *    / \
 *   5   15
 *      / \
 *     6  20
 * Input: [10,5,15,null,null,6,20]
 * Output: false
 * Explanation: 5 > 10 | 15 < 10  ||  6 > 10, 6 < 15 | 20 > 15
 */
    @Test
    void test5() {
        final ValidateBinarySearchTree.TreeNode n1l = new ValidateBinarySearchTree.TreeNode(5);

        final ValidateBinarySearchTree.TreeNode n12l = new ValidateBinarySearchTree.TreeNode(6);
        final ValidateBinarySearchTree.TreeNode n12r = new ValidateBinarySearchTree.TreeNode(20);
        final ValidateBinarySearchTree.TreeNode n1r = new ValidateBinarySearchTree.TreeNode(15, n12l, n12r);

        final ValidateBinarySearchTree.TreeNode n1 = new ValidateBinarySearchTree.TreeNode(10, n1l, n1r);

        assertFalse(sut.isValidBST(n1));
    }

    @Test
    void test6() {
        final ValidateBinarySearchTree.TreeNode n1 = new ValidateBinarySearchTree.TreeNode(2147483647);
        assertTrue(sut.isValidBST(n1));
    }

}
