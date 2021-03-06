/*
 * @(#)Search.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.fundation.search.model;

import com.fundation.search.controller.Criteria;
import com.fundation.search.database.SearchQuery;
import com.fundation.search.utils.Convert;
import com.fundation.search.utils.LoggerSearch;
import com.fundation.search.utils.ValidatorData;
import com.google.gson.Gson;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.apache.commons.lang3.math.Fraction;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class Search for four critearias path, name, size  and hidden.
 *
 * @author Franz Silva - AT-[07].
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */
public class Search {
    /**

     **/
    private static final Logger LOGGER = LoggerSearch.getInstance().getLogger();

    Convert convert;
    private Criteria criteria;
    private ValidatorData validate;
    /**
     * fileList is a file list that save files according to criterias
     */
    private List<Asset> fileList;
    private BasicFileAttributes fileBasicAttributes;
    private FFprobe ffprobe;
    private FFmpegProbeResult probeResult;
    private FFmpegStream stream;
    private static final String SLASH = System.getProperty("file.separator");
    private static final String OS = System.getProperty("os.name").toLowerCase();
    private ArrayList<String> multime;


    /**
     * Search Class constructor.
     */
    public Search() {
        LOGGER.info("Constructor Search : into");
        fileList = new ArrayList<>();
        //ultime = {"",""};
        convert = new Convert();
        validate = new ValidatorData();
        LOGGER.info("Consturctor search : exit");
    }

    /**
     * @param path .
     * @return list all the files contained within the path.
     */
    //add the asset multimedia
    public void searchByPath(String path) {
        LOGGER.info("searchByPath: into");
        if (!criteria.getIsMultimediaSelected()) {
            try {
                File[] files = new File(path).listFiles();
                for (File file : files) {
                    Path path1 = Paths.get(file.getPath());
                    fileBasicAttributes = Files.readAttributes(path1, BasicFileAttributes.class);
                    String pathFile = file.getPath();
                    boolean hidden = file.isHidden();
                    long size = file.length();
                    String owner = Files.getOwner(path1).getName();
                    boolean directory = file.isDirectory();
                    Date lastAccess = new Date(fileBasicAttributes.lastAccessTime().toMillis());
                    Date lastCreate = new Date(fileBasicAttributes.creationTime().toMillis());
                    Date lastModified = new Date(file.lastModified());
                    boolean readOnly = !file.canWrite();
                    String nameExt = file.getName();
                    String fileName;
                    String extension;
                    if (file.isDirectory()) {
                        fileName=file.getName();
                        extension = "";
                        Asset assetFile = AssetFactory.getAsset(pathFile,hidden,size,owner,directory,lastAccess,lastCreate,lastModified,
                                readOnly,nameExt,fileName,extension);
                        fileList.add(assetFile);
                        searchByPath(file.getPath());

                    } else {
                        String[] fileN = file.getName().split("\\.");
                        StringJoiner name = new StringJoiner(".");
                        Arrays.stream(fileN, 0, fileN.length - 1).forEachOrdered(name::add);
                        fileName = name.toString();
                        extension = ".".concat(fileN[fileN.length - 1]);
                        Asset assetFile = AssetFactory.getAsset(pathFile,hidden,size,owner,directory,lastAccess,lastCreate,lastModified,
                                readOnly,nameExt,fileName,extension);
                        fileList.add(assetFile);
                    }


                }
            } catch (NullPointerException | IOException e) {
            }
        } else {
            addMultimediaAttributes(path);
        }
        LOGGER.info("searchByPath : exit");

    }

    /**
     * @param nameFile .
     */
    public void searchByName(String nameFile, boolean keysensitive) {
        LOGGER.info("searchByName: into" + nameFile + " " + keysensitive);
        List<Asset> listFilter = new ArrayList<>();
        fileList.forEach(file -> {
                    if(keysensitive) {
                        if(criteria.isStartWith()){
                            if(file.getFileName().startsWith(nameFile)) {
                                listFilter.add(file);
                            }
                        }
                        else if(criteria.isEndWith()){
                            if(file.getFileName().endsWith(nameFile)){
                                listFilter.add(file);
                            }
                        }
                        else{
                            if (!file.getFileName().contains(nameFile)) {
                                listFilter.add(file);
                            }
                        }
                    } else {
                        if(criteria.isStartWith()){
                            if(file.getFileName().toLowerCase().startsWith(nameFile.toLowerCase())){
                                listFilter.add(file);
                            }
                        }
                        else if(criteria.isEndWith()){
                            if(file.getFileName().toLowerCase().endsWith(nameFile.toLowerCase())){
                                listFilter.add(file);
                            }
                        }
                        else{
                            if (file.getFileName().toLowerCase().contains(nameFile.toLowerCase())) {
                                listFilter.add(file);
                            }
                        }
                    }
        });
        fileList.clear();
        fileList.addAll(listFilter);
        LOGGER.info("searchByName: exit");
    }

    /**
     * @param size     is the file size.
     * @param operator is "<" or ">" or "=".
     */
    public void searchBySize(double size, char operator) {
        LOGGER.info("seachBySize: into");
        List<Asset> listFilter = new ArrayList<>();
        for (Asset file : fileList) {
            if (operator == '=') {
                if (file.getSize() != size) {
                    listFilter.add(file);
                }
            }
            if (operator == '>') {
                if (file.getSize() < size) {
                    listFilter.add(file);
                }
            }
            if (operator == '<') {
                if (file.getSize() > size) {

                    listFilter.add(file);
                }
            }
        }
        fileList.removeAll(listFilter);
        LOGGER.info("searchBySize: exit");
    }

    /**
     * This method has the function to filter file by hidden
     *
     * @param isHidden has the value true or false to display the hidden files.
     */

    public void searchHiddenFiles(boolean isHidden) {
        LOGGER.info("seachHiddenfiles: into");
        List<Asset> listFilter = new ArrayList<>();
        if (isHidden) {
            for (Asset file : fileList) {
                if (!file.getIsIshidden()) {
                    listFilter.add(file);
                }
            }
            fileList.removeAll(listFilter);

        }
        LOGGER.info("searchHiddenFiles: exit");
    }

    /**
     * This method has the function to filter files by all setted parameters
     *
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    public void searchByCriteria(Criteria criteria) {
        LOGGER.info("searchByCriteria: into");
        fileList.clear();
        if (criteria.getPath() != null) {

            searchByPath(criteria.getPath());
            if (criteria.getFileName() != null) {
                searchByName(criteria.getFileName(), criteria.isKeySensitive());
            }
            if (criteria.getSize() > -1) {
                searchBySize(criteria.getSize(), criteria.getOperator().charAt(0));
            }
            if (criteria.getIsIshidden()) {
                searchHiddenFiles(criteria.getIsIshidden());
            }
            if (criteria.getReadOnly()) {
                searchByReadOnly(criteria.getReadOnly());
            }
            if (!criteria.getListExtensions().isEmpty()) {

                searchByExtension(criteria.getListExtensions());
            }
            if (criteria.getOwner() != null) {
                searchByOwner(criteria.getOwner());
            }
            if (criteria.getDirectory()) {
                searchByFolder(criteria.getDirectory());
            }
            if (criteria.getDateModificateFrom() != null && criteria.getDateModificateTo() != null) {
                searchByDateModified(criteria.getDateModificateFrom(), criteria.getDateModificateTo());
            }
            if (criteria.getDateCreateFrom() != null && criteria.getDateCreateTo() != null) {
                searchByDateCreate(criteria.getDateCreateFrom(), criteria.getDateCreateTo());
            }
            if (criteria.getDateAccessFrom() != null && criteria.getDateAccessTo() != null) {
                searchByLastDateAccess(criteria.getDateAccessFrom(), criteria.getDateAccessTo());
            }
            if (criteria.getContent() != null) {
                searchIntoFile(criteria.getContent());
            }
            if (criteria.getIsMultimediaSelected()) {
                if (criteria.getFrameRate() != null) {
                    searchByFrameRate(criteria.getFrameRate());
                }
                if (criteria.getVideoCode() != null) {
                    searchByVideoCodec(criteria.getVideoCode());
                }
                if (criteria.getResolution() != null) {
                    searchByResolution(criteria.getResolution());
                }
                if (criteria.getAudioCode() != null) {
                    searchByAudioCodec(criteria.getAudioCode());
                }
                if (!criteria.getExtensionVideo().isEmpty()) {
                    searchByExtension(criteria.getExtensionVideo());
                }
                if (criteria.getDuration() >= 0 && criteria.getOperatorDurationTime() != null) {
                    searchByDuration(criteria.getDuration(), criteria.getOperatorDurationTime());
                }
                if(criteria.getAspectRatio() != null){
                    searchByAspectRatio(criteria.getAspectRatio());
                }
            }
        }
        LOGGER.info("searchByPath: exit");
    }

    /**
     * This method is for search text inside of file.
     *
     * @param pharse The text for search into files.
     */
    public void searchIntoFile(String pharse) {
        LOGGER.info(" searchIntofile: enter");

        fileList.removeIf(file -> {
            Scanner scanner;
            if (file instanceof AssetFile) {
                if (((AssetFile) file).getFileNameExt().endsWith(".txt")) {
                    try {
                        scanner = new Scanner(new FileReader(new File(file.getPath())));
                        while (scanner.hasNextLine()) {
                            if (scanner.nextLine().toLowerCase().contains(pharse.toLowerCase())) {
                                return false;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (((AssetFile) file).getFileNameExt().endsWith(".docx")) {

                    try {
                        FileInputStream fis = new FileInputStream(file.getPath());
                        XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
                        XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                        if (extractor.getText().toLowerCase().contains(pharse.toLowerCase())) {
                            return false;
                        }
                    } catch (Exception ex) {
                        return true;
                    }
                }
            }
            return true;

        });
        LOGGER.info(" searchIntofile: exit");
    }

    /**
     * This Method has the function to filter by extension e.g. exe, pdf, txt.
     *
     * @param extensions content the extensions tha must be filter.
     */
    public void searchByExtension(List<String> extensions) {
        LOGGER.info("searchByExtension: into");
        List<Asset> listFilter = new ArrayList<>();

        for (Asset file : fileList) {
            for (String fileExt : extensions) {
                if (file.getExtensions().toLowerCase().endsWith(fileExt.toLowerCase())) {
                    listFilter.add(file);
                }
            }
        }
        fileList.clear();
        fileList.addAll(listFilter);
        LOGGER.info("searachByExtension: exit");
    }

    /**
     * This method has the function to filter by privilege
     *
     * @param readOnly has the value true o false to display the file with privilege read only.
     */

    public void searchByReadOnly(boolean readOnly) {
        LOGGER.info("searchByReadOnly: into");
        List<Asset> listFilter;
        if (readOnly) {
            listFilter = fileList.stream().filter(Asset::getReadOnly).collect(Collectors.toList());
            fileList.clear();
            fileList.addAll(listFilter);
        }
        LOGGER.info("searchByReadOnly: exit");
    }

    /**
     * This metho has the function to filter by owner.
     *
     * @param owner is the name of the owner of the file
     */
    public void searchByOwner(String owner) {
        LOGGER.info("searchByOwner: into");
        List<Asset> listFilter = fileList.stream().filter(file -> file.getOwner().equalsIgnoreCase(owner))
                .collect(Collectors.toList());
        fileList.clear();
        fileList.addAll(listFilter);
        LOGGER.info("searchByOwner: exit");
    }


    /**
     * This metho has the function to filter the folders
     *
     * @param isFolder has the value true or false if the folder is going to display.
     */
    public void searchByFolder(boolean isFolder) {
        LOGGER.info("searchByFolder: into");
        List<Asset> listFilter = fileList.stream().filter(file -> {
            AssetFile assetFile = (AssetFile) file;
            return assetFile.getDirectory();
        }).collect(Collectors.toList());
        fileList.clear();
        fileList.addAll(listFilter);
        LOGGER.info("searchByFoler: into");
    }

    /**
     * This method is for filter by Las Create Date.
     *
     * @param dateCreateIni Is the init date for lastAccessTime time on a file.
     * @param dateCreateFin Is the end date for lastAccessTime time on a file.
     */
    public void searchByDateCreate(Date dateCreateIni, Date dateCreateFin) {
        LOGGER.info("searchByDateCreate: into");
        Date dateIni = convert.convertDateToDateIni(dateCreateIni);
        Date dateFin = convert.convertDateToDateFin(dateCreateFin);
        List<Asset> listFilter = IntStream.range(0, fileList.size()).filter(i -> fileList.get(i).getDateCreate().after(dateIni) &&
                fileList.get(i).getDateCreate().before(dateFin))
                .mapToObj(i -> fileList.get(i)).collect(Collectors.toList());
        fileList.clear();
        fileList.addAll(listFilter);
        LOGGER.info("searchByDateCreate: exit");
    }

    /**
     * This method is for filter by Las Modify Date.
     *
     * @param dateModifyIni Is the init date for lastAccessTime time on a file.
     * @param dateModifyFin Is the end date for lastAccessTime time on a file.
     */
    private void searchByDateModified(Date dateModifyIni, Date dateModifyFin) {
        LOGGER.info("searchByModify: into");
        Date dateIni = convert.convertDateToDateIni(dateModifyIni);
        Date dateFin = convert.convertDateToDateFin(dateModifyFin);
        List<Asset> listFilter = IntStream.range(0, fileList.size()).filter(i -> fileList.get(i).getDateModificate().after(dateIni) &&
                fileList.get(i).getDateModificate().before(dateFin)).mapToObj(i -> fileList.get(i)).collect(Collectors.toList());
        fileList.clear();
        fileList.addAll(listFilter);
        LOGGER.info("searchByModify: exit");
    }

    /**
     * This method is for filter by Las Modify Date.
     *
     * @param dateAccessIni Is the init date for lastAccessTime time on a file.
     * @param dateAccessFin Is the end date for lastAccessTime time on a file.
     */
    public void searchByLastDateAccess(Date dateAccessIni, Date dateAccessFin) {
        LOGGER.info("searchByLastDateAccess: into");
        Date dateIni = convert.convertDateToDateIni(dateAccessIni);
        Date dateFin = convert.convertDateToDateFin(dateAccessFin);
        List<Asset> listFilter = IntStream.range(0, fileList.size()).filter(i -> fileList.get(i).getDateAccess().after(dateIni) &&
                fileList.get(i).getDateAccess().before(dateFin)).mapToObj(i -> fileList.get(i)).collect(Collectors.toList());
        fileList.clear();
        fileList.addAll(listFilter);
        LOGGER.info("searchByLastDateAccess: exit");
    }

    public void addMultimediaAttributes(String path) {
        LOGGER.info("addMultimediaAttributes: into");
        try {
            File[] files = new File(path).listFiles();
            for (File file : files) {
                Path path1 = Paths.get(file.getPath());
                fileBasicAttributes = Files.readAttributes(path1, BasicFileAttributes.class);
                if (!file.isDirectory()) {
                    try {
                        String pathFile = file.getPath();
                        boolean hidden = file.isHidden();
                        long size = file.length();
                        String owner = Files.getOwner(path1).getName();
                        Date lastAccess = new Date(fileBasicAttributes.lastAccessTime().toMillis());
                        Date lastCreate = new Date(fileBasicAttributes.creationTime().toMillis());
                        Date lastModified = new Date(file.lastModified());
                        boolean readOnly = !file.canWrite();

                        String[] fileN = file.getName().split("\\.");
                        StringJoiner name = new StringJoiner(".");
                        Arrays.stream(fileN, 0, fileN.length - 1).forEachOrdered(name::add);
                        String fileName = name.toString();
                        String extension = ".".concat(fileN[fileN.length - 1]);
                        String ffprobePath;
                        if (OS.contains("windows")) {
                            ffprobePath = new File(".").getCanonicalPath() + SLASH + "resources" + SLASH + "ffprobe.exe";
                        } else {
                            ffprobePath = new File(".").getCanonicalPath() + SLASH + "resources" + SLASH + "ffprobe";
                        }
                        if(validate.isMultimediaFile(extension)) {
                            System.out.println("es multimedia ++++++++++++");
                            //values multimedia
                            ffprobe = new FFprobe(ffprobePath);
                            probeResult = ffprobe.probe(pathFile);
                            stream = probeResult.getStreams().get(0);

                            // video information
                            String codecName = stream.codec_name;
                            String codecLongName = stream.codec_long_name;
                            //resolution
                            int width = stream.width;
                            int height = stream.height;
                            String displayAspect = stream.display_aspect_ratio;
                            //
                            Fraction rFrameRate = stream.r_frame_rate;
                            double startTime = stream.start_time;
                            double duration = stream.duration;
                            long bitRate = stream.bit_rate;
                            long nbFrames = stream.nb_frames;
                            System.out.println("-------------video----------------");
                            System.out.println("codecName: " + codecName);
                            System.out.println("codecLongName: " + codecLongName);
                            System.out.println("width: " + width);
                            System.out.println("height: " + height);
                            System.out.println("dispaly ascpect radio: " + displayAspect);
                            System.out.println("FrameRate: " + rFrameRate.toString());

                            System.out.println("start time: " + startTime);
                            System.out.println("duration: " + duration);
                            System.out.println("bitRate: " + bitRate);
                            System.out.println("nbFrames: " + nbFrames);

                            // audio information
                            stream = probeResult.getStreams().get(1);
                            String audioCodecName = stream.codec_name;
                            String audioCodecNameLong = stream.codec_long_name;
                            String audioCodecTag = stream.codec_tag;
                            int audioChannels = stream.channels;
                            String audioChannelsLayout = stream.channel_layout;
                            double audioStarTime = stream.start_time;
                            double audioDuration = stream.duration;
                            long audioBitRate = stream.bit_rate;
                            long audioMaxBitRate = stream.max_bit_rate;
                            long audioNbFrame = stream.nb_frames;
                            //data.setAudioCodecName(audioCodecName);
                            System.out.println("---------------audio------------------");
                            System.out.println("audioCodec: " + audioCodecName);
                            System.out.println("audicoCodecLong: " + audioCodecNameLong);
                            System.out.println("audioCodecTag: " + audioCodecTag);
                            System.out.println("audioChannels: " + audioChannels);
                            System.out.println("audioChannelsLayout: " + audioChannelsLayout);
                            System.out.println("audioStartTime: " + audioStarTime);
                            System.out.println("audioDuration: " + audioDuration);
                            System.out.println("audioBitRate: " + audioBitRate);
                            System.out.println("audioMaxBitRate: " + audioMaxBitRate);
                            System.out.println("audioNbFrame: " + audioNbFrame);
                            Asset asset = AssetFactory.getAsset(pathFile, hidden, size, owner, lastAccess, lastCreate, lastModified,
                                    readOnly, fileName, extension, codecName, width, height, displayAspect, rFrameRate, duration,
                                    audioCodecName);
                            fileList.add(asset);
                        }
                    } catch (IOException | NullPointerException exception) {

                    } catch (IndexOutOfBoundsException ex) {

                    }
                } else {
                    addMultimediaAttributes(file.getPath());
                }
            }
        } catch (NullPointerException | IOException e) {
        }
        LOGGER.info("addMultimediaAttributes: exit");
    }

    /**
     * This method is to search Multimedia by Frame Rate.
     *
     * @param frameRate Frame Rate Criteria.
     */
    public void searchByFrameRate(String frameRate) {
        LOGGER.info("searchByFrameRate: into");
        fileList.removeIf(file -> {
            AssetMultimedia multimediaResult = (AssetMultimedia) file;
            Double value = (Math.ceil(multimediaResult.getrFrameRate().doubleValue()));
            String valueForCompare = value.intValue() + " fps";
            return !frameRate.equalsIgnoreCase(valueForCompare);
        });
        LOGGER.info("seachByFrameRate: exit");
    }

    public void searchByDuration(Double time, String operator) {
        LOGGER.info("searchByDuration: into");
        if (operator.equalsIgnoreCase(">")) {
            fileList.removeIf(file -> !(((AssetMultimedia) file).getDuration() > time));
        }
        if (operator.equalsIgnoreCase("<")) {
            fileList.removeIf(file -> !(((AssetMultimedia) file).getDuration() < time));
        }
        if (operator.equalsIgnoreCase("=")) {
            fileList.removeIf(file -> !(((AssetMultimedia) file).getDuration() == time));
        }
        LOGGER.info("seachByDuration: exit");
    }

    /**
     * This method is to search Multimedia by video codec.
     *
     * @param videoCodec Multimedia video codec Criteria.
     */
    public void searchByVideoCodec(String videoCodec) {
        LOGGER.info("searchByVideoCodec: into");
        fileList.removeIf(file -> {
            AssetMultimedia multimediaResult = (AssetMultimedia) file;
            return !videoCodec.equalsIgnoreCase(multimediaResult.getCodecName());
        });
        LOGGER.info("searchByVideoCodec: exit");
    }

    /**
     * This method is to search Multimedia by video codec.
     *
     * @param audioCodec Multimedia video codec Criteria.
     */
    public void searchByAudioCodec(String audioCodec) {
        LOGGER.info("searchByAudioCodec: into");
        fileList.removeIf(file -> {
            AssetMultimedia multimediaResult = (AssetMultimedia) file;
            return !audioCodec.equalsIgnoreCase(multimediaResult.getAudioCodecName());
        });
        LOGGER.info("searchByAudioCodec: exit");
    }

    /**
     * This method is to search Multimedia by video resolution.
     *
     * @param multimediaResolution Multimedia Resolution Criteria.
     */
    public void searchByResolution(String multimediaResolution) {
        LOGGER.info("searchByResolution: into");
        fileList.removeIf(file -> {
            AssetMultimedia multimediaResult = (AssetMultimedia) file;
            String resolutionCompare = multimediaResult.getDisplayAspect() + " "
                    + multimediaResult.getWidth() + "x" + multimediaResult.getHeight();
            return !multimediaResolution.equalsIgnoreCase(resolutionCompare);
        });
        LOGGER.info("searchByResolution: exit");
    }

    /**
     * This method is to search Multimedia by video resolution.
     *
     * @param aspectRatio Multimedia Resolution Criteria.
     */
    public void searchByAspectRatio(String aspectRatio) {
        LOGGER.info("searchByAspectRatio: into");
        fileList.removeIf(file -> {
            AssetMultimedia multimediaResult = (AssetMultimedia) file;
            String resolutionCompare = multimediaResult.getDisplayAspect();
            return !aspectRatio.equalsIgnoreCase(resolutionCompare);
        });
        LOGGER.info("searchByAspectRatio: exit");
    }

    public void setCriteria(Criteria criteria) {
        LOGGER.info("setCriteria: into");
        this.criteria = criteria;
        LOGGER.info("setCiteria: exit");
    }


    /**
     * this method result of a search by criterias.
     *
     * @return File Result list with the files already searched
     */
    public List<Asset> getResult() {
        LOGGER.info("getResult: into");
        LOGGER.info("getResult: exit");
        return fileList;
    }

    /**
     * @param criteria
     */
    public void createJson(Criteria criteria, String nameCriteria) {
        Gson json = new Gson();
        String criteriaJSON = json.toJson(criteria);
        System.out.println(criteriaJSON);
        //Properties properties = json.fromJson(criteriaJSON, Properties.class);
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.insertCriteria(criteriaJSON, nameCriteria);
    }

    /**
     * @return
     * @throws SQLException
     */
    public Map<Integer, Criteria> getJSONCriteria() throws SQLException {
        ResultSet set = new SearchQuery().getAllCriteria();
        Map<Integer, Criteria> map = new HashMap<>();
        while (set.next()) {

            map.put(Integer.parseInt(set.getString("ID")), converToCriteria(set.getString("criteriaJSON")));
        }
        return map;
    }

    /**
     * @return
     * @throws SQLException
     */
    public Map<Integer, String> getJSONCriteriaUI() throws SQLException {
        ResultSet set = new SearchQuery().getAllCriteria();
        Map<Integer, String> map = new HashMap<>();
        while (set.next()) {

            map.put(Integer.parseInt(set.getString("ID")), set.getString("nameCriteria"));
        }
        return map;
    }

    /**
     * @param criteriaJSON
     * @return
     */
    public Criteria converToCriteria(String criteriaJSON) {
        final Gson json = new Gson();
        final Criteria criteria = json.fromJson(criteriaJSON, Criteria.class);
        return criteria;
    }
}
