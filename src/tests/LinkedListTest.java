package tests;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Justin Deutsch (djustin8)

/**
 * The tests to ensure that the LinkedList operates
 * as intended in various scenarios
 *
 * @author Justin Deutsch (djustin8)
 * @version 2018.07.04
 *
 */
class LinkedListTest {

    /**
     * The LinkedList used throughout testing
     */
    private LinkedList<String> list;


    /**
     * Sets up the testing conditions prior to each
     * test set up.
     */
    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }


    /**
     * Tests the add method of LinkedList
     */
    @Test
    void testAdd() {

        Exception thrown = null;

        try {
            list.add(null);
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        list.add("second");
        list.add("first");
        Iterator<String> iter = list.iterator();
        assertEquals("first", iter.next());
        assertEquals("second", iter.next());
    }


    /**
     * Tests the addAfter method of LinkedList
     */
    @Test
    void testAddAfter() {
        list.add("first");
        list.addAfter("second", "first");
        list.addAfter("newFirst", "third");
        Iterator<String> iter = list.iterator();
        assertEquals(3, list.size());
        assertEquals("newFirst", iter.next());
        assertEquals("first", iter.next());
        assertEquals("second", iter.next());

        Exception thrown = null;

        try {
            list.addAfter(null, "first");
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        Exception thrown2 = null;
        try {
            list.addAfter("new", null);
        }
        catch (Exception e) {
            thrown2 = e;
        }

        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IllegalArgumentException);
    }


    /**
     * Tests the size method of LinkedList
     */
    @Test
    void testSize() {
        assertEquals(0, list.size());

        list.add("add");

        assertEquals(1, list.size());
    }


    /**
     * Tests the isEmpty method of LinkedList
     */
    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("string");
        assertFalse(list.isEmpty());
    }


    /**
     * Tests the remove method of LinkedList
     */
    @Test
    void testRemove() {
        list.add("third");
        list.add("second");
        list.add("first");

        assertEquals(3, list.size());

        assertTrue(list.remove("second"));

        Iterator<String> iter = list.iterator();
        assertEquals(2, list.size());
        assertEquals("first", iter.next());
        assertEquals("third", iter.next());

        assertFalse(list.remove("not here"));
    }


    /**
     * Tests the contains method of LinkedList
     */
    @Test
    void testContains() {
        assertFalse(list.contains("first"));
        list.add("first");
        list.add("second");
        assertTrue(list.contains("first"));
    }

    /**
     * Tests the toString method of LinkedList
     */
    @Test
    void testToString() {

        String expected = "[first, second, third]";

        list.add("third");
        list.add("second");
        list.add("first");

        assertEquals(expected, list.toString());

    }


    /**
     * Tests the equals method of LinkedList
     */
    @Test
    void testEquals() {

        // Testing when parameter is null
        LinkedList<String> otherList = null;
        assertFalse(list.equals(otherList));

        // Testing when not correct class
        assertFalse(list.equals("not list"));

        // Testing call on self
        assertTrue(list.equals(list));

        // Testing on two unequal lists
        list.add("third");
        list.add("second");
        list.add("first");

        otherList = new LinkedList<String>();
        otherList.add("third");
        otherList.add("second");

        assertFalse(list.equals(otherList));

        // Testing on two equal lists
        otherList.add("first");
        assertTrue(list.equals(otherList));

    }


    /**
     * Tests the next method of the iterator
     */
    @Test
    void testIterNext() {
        Iterator<String> iter = list.iterator();
        assertFalse(iter.hasNext());

        Exception thrown = null;

        try {
            iter.next();
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof NoSuchElementException);
    }


    /**
     * Tests the to array method for linked list
     */
    @Test
    void testToArray() {
        list.add("third");
        list.add("second");
        list.add("first");
        Object[] array = list.toArray();

        // Testing correct data output
        assertEquals(array[0], "first");
        assertEquals(array[1], "second");
        assertEquals(array[2], "third");

        // Tests the array output is only of length list.size
        assertEquals(3, array.length);
    }

    /**
     * Tests the remove method within LinkedList
     */
    @Test
    void testIterRemove() {

        Exception thrown = null;

        try {
            Iterator<String> iter = list.iterator();
            iter.remove();
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof UnsupportedOperationException);
    }

}