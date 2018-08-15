package viewTest;
import org.junit.Before;
import org.junit.Test;
import com.fundation.search.view.PanelSearch;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class PanelSearchTest {
    private PanelSearch panelS;
    @Before
    public void ini() {
        panelS = new PanelSearch();
    }

    @Test
    public void testSetOnlyReadFalse(){
        panelS.setEnableOnlyRead(false);
        assertFalse(panelS.getOnlyRead());
    }
    @Test
    public void testSetKeysensitiveTrue(){
        panelS.setEnableKeySensitive(true);
        assertTrue(panelS.getKeySensitive());
    }
    @Test
    public void testSetKeysensitiveFalse(){
        panelS.setEnableKeySensitive(false);
        assertFalse(panelS.getKeySensitive());
    }


}
