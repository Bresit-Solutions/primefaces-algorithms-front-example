package com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.controller;

import com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.dto.HighestRepeatingWordResult;
import com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.service.HighestRepeatingWordService;
import com.bresit.primefaces.algorithms.front.example.algorithms.highest_repeating_word.service.HighestRepeatingWordServiceImpl;
import lombok.Data;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.*;
import java.util.UUID;

@Named
@ViewScoped
@Data
public class HighestRepeatingWordController implements Serializable {

    private HighestRepeatingWordResult result;
    private String fileContent;
    private HighestRepeatingWordService highestRepeatingWordService;

    @PostConstruct
    public void init() {
        highestRepeatingWordService = new HighestRepeatingWordServiceImpl();
    }

    private File saveFileToTmpDir(UploadedFile file) throws IOException {
        String tmpDir = System.getProperty("java.io.tmpdir");
        String newFileUrl = tmpDir + File.separator + UUID.randomUUID();
        File newFile = new File(newFileUrl);
        OutputStream outStream = new FileOutputStream(newFile);
        outStream.write(file.getContents());
        outStream.close();
        return newFile;
    }

    private void loadContent(File fileObj) throws IOException {
        //Read the file content
        BufferedReader br = new BufferedReader(new FileReader(fileObj));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = br.readLine()) != null)
            stringBuilder.append(line).append("\n");
        br.close();
        fileContent = stringBuilder.toString();
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        UploadedFile file = event.getFile();
        if (file != null) {
            File fileObj = saveFileToTmpDir(file);
            result = highestRepeatingWordService.findHighestRepeatingWord(fileObj);

            //Read content from file
            loadContent(fileObj);

            //Delete tmp file
            fileObj.delete();
        }
    }
}
