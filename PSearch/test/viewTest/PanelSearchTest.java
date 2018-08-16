package viewTest;
import org.junit.Before;
import org.junit.Test;
import com.fundation.search.view.PanelSearch;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * class test of Panel Search.
 */

public class PanelSearchTest {
    private PanelSearch panelS;
    @Before
    public void ini() {
        panelS = new PanelSearch();
    }

    /**
     *test of the Only Read is boolean false.
     */
    @Test
    public void testSetOnlyReadFalse(){
        panelS.setEnableOnlyRead(false);
        assertFalse(panelS.getOnlyRead());
    }
    /**
     *test of the Only Read is boolean true.
     */
    @Test
    public void testSetOnlyReadTrue(){
        panelS.setEnableOnlyRead(true);
        assertTrue(panelS.getOnlyRead());
    }

    /**
     * test boolean true of Key sensitive.
     */
    @Test
    public void testSetKeysensitiveTrue(){
        panelS.setEnableKeySensitive(true);
        assertTrue(panelS.getKeySensitive());
    }
    /**
     *test boolean False of Key sensitive.
     */
    @Test
    public void testSetKeysensitiveFalse(){
        panelS.setEnableKeySensitive(false);
        assertFalse(panelS.getKeySensitive());
    }
    /**
     *test boolean true of StarWith.
     */
    @Test
    public void testSetStartWithTrue(){
        panelS.setStartWith(true);
        assertTrue(panelS.getStartWith());
    }
    /**
     *test boolean false of StarWith.
     */
    @Test
    public void testSetStartWithFalse(){
        panelS.setStartWith(false);
        assertFalse(panelS.getStartWith());
    }
    /**
     *test boolean true of EndWith.
     */
    @Test
    public void testSetEndWhithTrue(){
        panelS.setEndWith(true);
        assertTrue(panelS.getEndWith());
    }

    /**
     * test boolean false of EndWith.
     */
    @Test
    public void testSetEndWhitFalse(){
        panelS.setEndWith(false);
        assertFalse(panelS.getEndWith());
    }
    /**
     *test boolean true of folder.
     */
    @Test
    public void testSetFolderTrue(){
        panelS.setFolder(true);
        assertTrue(panelS.getSearchFolder());
    }
    /**
     *test boolean false of folder.
     */
    @Test
    public void testSetFolderFalse(){
        panelS.setFolder(false);
        assertFalse(panelS.getSearchFolder());
    }

    /**
     *test boolean true of hidden.
     */
    @Test
    public void testSetHiddenTrue(){
        panelS.setHiddenCheck(true);
        assertTrue(panelS.getHidden());
    }

    /**
     * test boolean false of Hidden.
     */
    @Test
    public void testSetHiddenFalse(){
        panelS.setHiddenCheck(false);
        assertFalse(panelS.getHidden());
    }

    /**
     * test is name file correctly.
     */
    @Test
    public void testSetTextFileCorrectly() {

        panelS.setTextFile("php");
        assertEquals("php", panelS.getTextFile());
    }

    /**
     *test is name file Incorrectly.
     */
    @Test
    public void testSetTextFileIncorrectly() {

        panelS.setTextFile("php");//.setContent("search");
        assertNotEquals("phP", panelS.getTextFile());//criteria.getContent());
    }

    /**
     * test is name Owner is correctly.
     */
    @Test
    public void testSetTextOwnerCorrectly(){
        panelS.setTextOwner("KettyCamacho");
        assertEquals("KettyCamacho",panelS.getOwner());
    }

    /**
     *test is name Owner is incorrectly.
     */
    @Test
    public void testSetTextOwnerIncorrectly(){
        panelS.setTextOwner("11111");
        assertNotEquals("KettyCamacho",panelS.getOwner());
    }

    /**
     *test Operator is Correctly.
     */
    @Test
    public void testSetOperatorCorrectly() {
        final String[] operators= {"<", ">", "="};
        panelS.setOperator(operators[0]);
        assertEquals(operators[0],panelS.getOperator());
        panelS.setOperator(operators[1]);
        assertEquals(operators[1], panelS.getOperator());
        panelS.setOperator(operators[2]);
        assertEquals(operators[2], panelS.getOperator());
    }

    /**
     * test operator is Incorrectly.
     */
    @Test
    public void testSetOperatorIncorrectly() {
        final String[] operators= {"-", "5", ". "};
        panelS.setOperator(operators[0]);
        assertNotEquals(operators[0],panelS.getOperator());
        panelS.setOperator(operators[1]);
        assertNotEquals(operators[1], panelS.getOperator());
        panelS.setOperator(operators[2]);
        assertNotEquals(operators[2], panelS.getOperator());
    }

    /**
     * test Correctly type size  of file.
     */
    @Test
    public void setSizeCorrectly() {
        final String[] typeSize = {"bytes", "Kb", "Mb","Gb"};
        panelS.setOptionUnitsSize(typeSize[0]);
        assertEquals( typeSize[0],panelS.getOptionUnitsSize());
       panelS.setOptionUnitsSize(typeSize[1]);
        assertEquals(typeSize[1],panelS.getOptionUnitsSize());

        panelS.setOptionUnitsSize(typeSize[2]);
        assertEquals(typeSize[2],panelS.getOptionUnitsSize());
        panelS.setOptionUnitsSize(typeSize[3]);
        assertEquals(typeSize[3],panelS.getOptionUnitsSize());
    }

    /**
     * test incorrectly size type of file.
     */
    @Test
    public void setSizeIncorrectly() {
        final String[] typeSize = {"bytes22", "K", "2b","Gb2"};
        panelS.setOptionUnitsSize(typeSize[0]);
        assertNotEquals( typeSize[0],panelS.getOptionUnitsSize());
        panelS.setOptionUnitsSize(typeSize[1]);
        assertNotEquals(typeSize[1],panelS.getOptionUnitsSize());

        panelS.setOptionUnitsSize(typeSize[2]);
        assertNotEquals(typeSize[2],panelS.getOptionUnitsSize());
        panelS.setOptionUnitsSize(typeSize[3]);
        assertNotEquals(typeSize[3],panelS.getOptionUnitsSize());
    }


}
