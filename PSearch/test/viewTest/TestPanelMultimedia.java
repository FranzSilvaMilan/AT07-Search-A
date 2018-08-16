package viewTest;

import com.fundation.search.view.PanelMultimedia;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestPanelMultimedia {
    private PanelMultimedia panelM;
    @Before
    public void ini() {
        panelM = new PanelMultimedia();
    }

    /**
     * test of selection on ratio Correctly of multimedia.
     */
    @Test
    public void testSetAspectRatioCorrectly() {
        String[] aspectR={"All","0:1","45:19","180:101"};
        panelM.setOptionAspecRadio(aspectR[0]);
        assertEquals(null,panelM.getAspectRadio());
        //final String a="0:1";
        panelM.setOptionAspecRadio(aspectR[1]);
        assertEquals(aspectR[1],panelM.getAspectRadio());
        panelM.setOptionAspecRadio(aspectR[2]);
        assertEquals(aspectR[2],panelM.getAspectRadio());
        panelM.setOptionAspecRadio(aspectR[3]);
        assertEquals(aspectR[3],panelM.getAspectRadio());

    }
    /**
     * test of selection on ratio Correctly of multimedia.
     */
    @Test
    public void testSetAspectRatioIncorrectly() {
        String[] aspectR={"-","0:1o","45:19d","1807:101"};
        panelM.setOptionAspecRadio(aspectR[0]);
        assertNotEquals(aspectR[0],panelM.getAspectRadio());
        //final String a="0:1";
        panelM.setOptionAspecRadio(aspectR[1]);
        assertNotEquals(aspectR[1],panelM.getAspectRadio());
        panelM.setOptionAspecRadio(aspectR[2]);
        assertNotEquals(aspectR[2],panelM.getAspectRadio());
        panelM.setOptionAspecRadio(aspectR[3]);
        assertNotEquals(aspectR[3],panelM.getAspectRadio());

    }

    /**
     * test of selection on Audio Codec of multimedia.
     */
    @Test
    public void testSetAudioCodecCorrectly(){
        String[] audio={"All","mp3","aac","amr_nb"};
        panelM.setOptionAspecRadio(audio[0]);
        assertEquals(null,panelM.getAspectRadio());

        panelM.setOptionAudioCodec(audio[1]);
        assertEquals(audio[1],panelM.getOptionAudioCodec());
        panelM.setOptionAudioCodec(audio[2]);
        assertEquals(audio[2],panelM.getOptionAudioCodec());
        panelM.setOptionAudioCodec(audio[3]);
        assertEquals(audio[3],panelM.getOptionAudioCodec());
    }
    /**
    @Test
    public void testSetVideoCodeCorrectly(){
        String[] audio={"All","H264","H263","MPG4","WNV1"};
        panelM.setOptionVideoCode(audio[0]);
        assertEquals(null,panelM.getOptionVideoCode());

        panelM.setOptionVideoCode(audio[1]);
        assertEquals(audio[1],panelM.getOptionVideoCode());
        panelM.setOptionVideoCode(audio[2]);
        assertEquals(audio[2],panelM.getOptionVideoCode());
        panelM.setOptionVideoCode(audio[3]);
        assertEquals(audio[3],panelM.getOptionVideoCode());
        panelM.setOptionVideoCode(audio[4]);
        assertEquals(audio[4],panelM.getOptionVideoCode());
    }*/



}
