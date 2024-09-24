package Labs.Lab1.Exercise3.Q1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SuperImportantClassTest {
    @BeforeAll
    static void doBeforeAll() {
        System.out.println("This is called before all tests in class");
    }

    @AfterAll
    static void doAfterAll() {
        System.out.println("This is called after all tests in class");
    }

    @BeforeEach
    void setUp() {
        System.out.println("This is called before each test in this class");
    }

    @AfterEach
    void tearDown() {
        System.out.println("This is called after each test in this class");
    }

    @Test
    void succeedingTest() {
    } // A test that returns without explicit 'failure' is deemed to be successful.

    @Test
    void failingTest() {
        fail("We have caused this test to fail");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
    } // will not be included in the test suite.

    @Test
    void demonstrateAssertEquals() {
        assertEquals(1 + 1, 2);
    } // succeeds when the two arguments are equal

    @Test
    void demonstrateAssertTrue() {
        assertTrue(true);
    } // succeeds when the input argument evaluates to 'true'

    @Test
    void demonstrateAssertInstanceOf() {
        assertInstanceOf("".getClass(), "Hello");
    }
}
