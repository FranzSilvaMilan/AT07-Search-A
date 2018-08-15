package com.fundation.search.model;

import com.fundation.search.controller.Criteria;
import com.fundation.search.controller.CriteriaBuilder;
import com.fundation.search.utils.Convert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * This class Search for four critearias path, name, size  and hidden.
 *
 * @author Franz Silva - AT-[07].
 * @version 1.0.
 */
public class SearchTest {
    private Search search;
    private static final String SLASH = System.getProperty("file.separator");
    private Convert convert;
    CriteriaBuilder criteriaBuild;
    Criteria criteria;

    /**
     * init component before each unit test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        search = new Search();
        convert = new Convert();
        criteriaBuild = new CriteriaBuilder();
    }

    /**
     * test search by path
     * @throws IOException
     */
    @Test
    public void searchByPath() throws IOException {

        String unitSize = "bytes";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", "bytes");
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(23, results.size());
    }

    @Test
    public void searchByName() throws IOException {

        String unitSize = "bytes";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "Inf", false, sizeValue, ">", "bytes");
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(1, results.size());
        assertEquals("Informe Final 3 V1", results.get(0).getFileName());
    }

    @Test
    public void searchBySizebytes() throws IOException {
        String unitSize = "bytes";
        Long size = 70L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", "bytes");
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(14, results.size());
        assertEquals("CARTA - INVITACION SEMINARIO PATENTES", results.get(0).getFileName());
    }

    @Test
    public void searchBySizeKb() throws IOException {
        String unitSize = "Kb";
        Long size = 100L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, "<", unitSize);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(18, results.size());
        assertEquals("folderHidden", results.get(1).getFileName());
    }

    @Test
    public void searchBySizeMb() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, "=", unitSize);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(8, results.size());
    }

    @Test
    public void searchHiddenFiles() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", true, sizeValue, ">", unitSize);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(6, results.size());
    }

    @Test
    public void searchIntoFile() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "team A", new ArrayList<>(), false, false,
                false, false, false, false);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals("Informe Final 3 V1", results.get(0).getFileName());
        assertEquals("metodologia corregir", results.get(1).getFileName());
    }

    @Test
    public void searchIntoFileTxt() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        ArrayList<String> extensions = new ArrayList<>();
        extensions.add("txt");
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "jalasoft", extensions, false, false,
                false, false, false, false);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals("testSameName", results.get(0).getFileName());
    }

    @Test
    public void searchByExtension() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        ArrayList<String> extensions = new ArrayList<>();
        extensions.add("docx");
        extensions.add("pdf");
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "", extensions, false, false,
                false, false, false, false);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(6, results.size());
    }

    @Test
    public void searchByReadOnly() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, true, null, null, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                false, false, false, false);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(4, results.size());
        assertEquals("testRar", results.get(0).getFileName());
        assertEquals("textHidden", results.get(1).getFileName());
        assertEquals("textHiddenReadOnly", results.get(2).getFileName());
        assertEquals("textReadOnly", results.get(3).getFileName());
    }

    @Test
    public void searchByOwner() throws IOException {

    }

    @Test
    public void searchByFolder() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        //C:\Users\Omen\Desktop\fundacion_jala\modulo 2\PROGRA 102\proyect_search\AT07-Search-A\PSearch\test\testDirectory
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(true, false, null, null, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                false, false, false, false);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(4, results.size());
    }

    @Test
    public void searchByDateCreate() throws IOException {

        Date lassCreateFrom = convert.convertStringToDate("14/08/2018");
        Date lassCreateTo = convert.convertStringToDate("14/08/2018");
        Date createIni = convert.convertDateToDateIni(lassCreateFrom);
        Date createFin = convert.convertDateToDateFin(lassCreateTo);
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, createIni, createFin,
                null, null, false, "", "", new ArrayList<>(), false, false,
                false, true, false, false);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(19, results.size());

    }

    @Test
    public void searchByLastDateModify() throws IOException {
        Date modifyFrom = convert.convertStringToDate("29/11/2017");
        Date modifyTo = convert.convertStringToDate("01/12/2017");
        Date modifyIni = convert.convertDateToDateIni(modifyFrom);
        Date modifyFin = convert.convertDateToDateFin(modifyTo);
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, modifyIni, modifyFin, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                false, false, false, false);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(1, results.size());
        assertEquals("CARTA - INVITACION SEMINARIO PATENTES", results.get(0).getFileName());
    }

    @Test
    public void searchByLastDateAAccess() throws IOException {
        Date accessFrom = convert.convertStringToDate("14/08/2018");
        Date accessTo = convert.convertStringToDate("14/08/2018");
        Date accessIni = convert.convertDateToDateIni(accessFrom);
        Date accessFin = convert.convertDateToDateFin(accessTo);
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                accessIni, accessFin, false, "", "", new ArrayList<>(), false, false,
                false, false, false, false);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(11, results.size());
    }

    @Test
    public void addMultimediaAttributes() {
    }

    @Test
    public void searchByFrameRate() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                true, false, false, false);
        String frameRare = "24 fps";
        String videoCode = "";
        String audioCode = "";
        String resolution = "";
        String unitTime = "second";//minutes hours
        double duration = convert.convertTimeDurationToDouble("0.0", unitTime);
        ;
        String operatorDurationTime = ">";
        ArrayList<String> extensionVideo = new ArrayList<>();
        String aspectRatio = ""; //16:9
        criteriaBuild.buildMultimedia(frameRare, videoCode, audioCode, resolution, duration, operatorDurationTime, unitTime, extensionVideo, aspectRatio);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(0, results.size());
    }

    @Test
    public void searchByDuration() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                true, false, false, false);
        String frameRare = null;
        String videoCode = null;
        String audioCode = null;
        String resolution = null;
        String unitTime = "minutes";//minutes hours
        double duration = convert.convertTimeDurationToDouble("2", unitTime);
        String operatorDurationTime = "<";
        ArrayList<String> extensionVideo = new ArrayList<>();
        String aspectRatio = null; //16:9
        criteriaBuild.buildMultimedia(frameRare, videoCode, audioCode, resolution, duration, operatorDurationTime, unitTime, extensionVideo, aspectRatio);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(1, results.size());
        assertEquals("The Simpson", results.get(0).getFileName());
    }

    @Test
    public void searchByVideoCodec() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                true, false, false, false);
        String frameRare = null;
        String videoCode = "mpeg4";
        String audioCode = null;
        String resolution = null;
        String unitTime = "minutes";//minutes hours
        double duration = convert.convertTimeDurationToDouble("0", unitTime);
        String operatorDurationTime = ">";
        ArrayList<String> extensionVideo = new ArrayList<>();
        String aspectRatio = null; //16:9
        criteriaBuild.buildMultimedia(frameRare, videoCode, audioCode, resolution, duration, operatorDurationTime, unitTime, extensionVideo, aspectRatio);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(1, results.size());
        assertEquals("videoplayback", results.get(0).getFileName());
    }

    @Test
    public void searchByAudioCodec() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                true, false, false, false);
        String frameRare = null;
        String videoCode = null;
        String audioCode = "aac";
        String resolution = null;
        String unitTime = "minutes";//minutes hours
        double duration = convert.convertTimeDurationToDouble("0", unitTime);
        String operatorDurationTime = ">";
        ArrayList<String> extensionVideo = new ArrayList<>();
        String aspectRatio = null; //16:9
        criteriaBuild.buildMultimedia(frameRare, videoCode, audioCode, resolution, duration, operatorDurationTime, unitTime, extensionVideo, aspectRatio);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(4, results.size());
    }

    @Test
    public void searchByResolution() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                true, false, false, false);
        String frameRare = null;
        String videoCode = null;
        String audioCode = null;
        String resolution = "16:9 1280x720";
        String unitTime = "minutes";//minutes hours
        double duration = convert.convertTimeDurationToDouble("0", unitTime);
        String operatorDurationTime = ">";
        ArrayList<String> extensionVideo = new ArrayList<>();
        String aspectRatio = null; //16:9
        criteriaBuild.buildMultimedia(frameRare, videoCode, audioCode, resolution, duration, operatorDurationTime, unitTime, extensionVideo, aspectRatio);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(1, results.size());
        assertEquals("Cute Love Story By Kjtoons", results.get(0).getFileName());
    }

    @Test
    public void searchByAspectRatio() throws IOException {
        String unitSize = "Mb";
        Long size = 0L;
        Long sizeValue = convert.convertTOLong(size, unitSize);
        String path = new File(".").getCanonicalPath() + SLASH + "test"
                + SLASH + "testDirectory";
        criteriaBuild.buildFile(path, "", false, sizeValue, ">", unitSize);
        criteriaBuild.buildFileAdvance(false, false, null, null, null, null,
                null, null, false, "", "", new ArrayList<>(), false, false,
                true, false, false, false);
        String frameRare = null;
        String videoCode = null;
        String audioCode = null;
        String resolution = null;
        String unitTime = "minutes";//minutes hours
        double duration = convert.convertTimeDurationToDouble("0", unitTime);
        String operatorDurationTime = ">";
        ArrayList<String> extensionVideo = new ArrayList<>();
        String aspectRatio = "16:9"; //16:9
        criteriaBuild.buildMultimedia(frameRare, videoCode, audioCode, resolution, duration, operatorDurationTime, unitTime, extensionVideo, aspectRatio);
        criteria = criteriaBuild.build();
        search.setCriteria(criteria);
        search.searchByCriteria(criteria);
        List<Asset> results = search.getResult();
        assertEquals(3, results.size());
    }

    @Test
    public void createJson() {
    }
}