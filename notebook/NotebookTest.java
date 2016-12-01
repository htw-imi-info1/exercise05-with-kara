
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NotebookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NotebookTest
{
    private Notebook notebook1;

    /**
     * Default constructor for test class NotebookTest
     */
    public NotebookTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        notebook1 = new Notebook();
        notebook1.storeNote("a");
        notebook1.storeNote("b");
        notebook1.storeNote("b");
        notebook1.storeNote("c");
        notebook1.storeNote("d");
    }

    @Test
    public void testAddOneElement()
    {
        //given: empty notebook
        Notebook notebook1 = new Notebook();
        //when I add a note
        notebook1.storeNote("Eins");
        // then the size should be one
        assertEquals(1, notebook1.numberOfNotes());
    }

    @Test
    public void testSimpleRemoveReturnValue()
    {
        boolean returnValue = notebook1.remove("c");
        assertEquals(true, returnValue);

    }
     @Test
    public void testSimpleRemoveSize()
    {
        boolean returnValue = notebook1.remove("c");
       
        assertEquals(4,notebook1.numberOfNotes());
    }


    @Test
    public void testRemoveDoubleElementReturnValue()
    {
        boolean returnValue = notebook1.remove("b");
        assertEquals(true, returnValue);

    }

    @Test
    public void testRemoveDoubleElementSize()
    {
        boolean returnValue = notebook1.remove("b");
        assertEquals("size should be reduced by 2 as b should have been deleted twice",3,notebook1.numberOfNotes());

    }

}

