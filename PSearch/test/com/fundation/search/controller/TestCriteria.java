package com.fundation.search.controller;

import com.fundation.search.utils.Convert;
import com.fundation.search.utils.ValidatorData;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCriteria {
    private Criteria criteria;

    /**
     *
     */
    @Before
    public void setUp() {
        criteria = new Criteria();
    }

    /**
     *
     */
    @Test
    public void testSetPath() {
        final String path = "E:\\testFiles";
        assertTrue(new ValidatorData().isPathValid(path));
        criteria.setPath(path);
        assertEquals(path, criteria.getPath());
    }

    /**
     *
     */
    @Test
    public void testSetDirectory() {
        criteria.setDirectory(true);
        assertTrue(criteria.getDirectory());
        criteria.setDirectory(false);
        assertFalse(criteria.getDirectory());
    }

    /**
     *
     */
    @Test
    public void testSetReadOnly() {
        criteria.setReadOnly(true);
        assertTrue(criteria.getReadOnly());
        criteria.setReadOnly(false);
        assertFalse(criteria.getReadOnly());
    }

    /**
     *
     */
    @Test
    public void testSetKeySensitive() {
        criteria.setKeySensitive(true);
        assertTrue(criteria.isKeySensitive());
        criteria.setKeySensitive(false);
        assertFalse(criteria.isKeySensitive());
    }

    /**
     *
     */
    @Test
    public void testSetContent() {
        criteria.setContent("search");
        assertEquals("search", criteria.getContent());
    }

    /**
     *
     */
    @Test
    public void testSetOwner() {
        criteria.setOwner("Administratot-PC");
        assertEquals("Administratot-PC", criteria.getOwner());
    }

    @Test
    public void testSetListExtensions() {
        final ArrayList<String> extentions = new ArrayList<>();
        extentions.add("pdf");
        extentions.add("mp3");
        criteria.setListExtensions(extentions);
        assertEquals(extentions, criteria.getListExtensions());
    }

    @Test
    public void tsetSetOperator() {
        final String[] operators = {"<", ">", "="};
        criteria.setOperator(operators[0]);
        assertEquals(operators[0], criteria.getOperator());
        criteria.setOperator(operators[1]);
        assertEquals(operators[1], criteria.getOperator());
        criteria.setOperator(operators[2]);
        assertEquals(operators[2], criteria.getOperator());
    }

    @Test
    public void setSize() {
        final String[] unitForSize = {"bytes", "Kb", "Mb","Gb"};
        criteria.setSize(new Convert().convertTOLong(1,unitForSize[0]));
        assertEquals(1,criteria.getSize());
        criteria.setSize(new Convert().convertTOLong(1,unitForSize[1]));
        assertEquals(1024,criteria.getSize());
        criteria.setSize(new Convert().convertTOLong(1,unitForSize[2]));
        assertEquals(1024*1024,criteria.getSize());

    }

    @Test
    public void setFileName() {
    }

    @Test
    public void setIshidden() {
    }

    @Test
    public void setStartWith() {
    }

    @Test
    public void setEndWith() {
    }

    @Test
    public void setUnitForSize() {
    }

    @Test
    public void setEnableCreate() {
    }

    @Test
    public void setEnableModified() {
    }

    @Test
    public void setEnableLastAccess() {
    }

    @Test
    public void setMultimediaSelected() {
    }

    @Test
    public void setAspectRatio() {
    }

    @Test
    public void setFrameRate() {
    }

    @Test
    public void setVideoCode() {
    }

    @Test
    public void setAudioCode() {
    }

    @Test
    public void setResolution() {
    }

    @Test
    public void setExtensionVideo() {
    }

    @Test
    public void setDuration() {
    }

    @Test
    public void setOperatorDurationTime() {
    }

    @Test
    public void setUnitTime() {
    }

    /**
     *
     */
    @Test
    public void testSetDateModificateFrom() {
    }

    /**
     *
     */
    @Test
    public void setDateModificateTo() {
    }

    /**
     *
     */
    @Test
    public void setDateAccessFrom() {
    }

    @Test
    public void setDateAccessTo() {
    }
}