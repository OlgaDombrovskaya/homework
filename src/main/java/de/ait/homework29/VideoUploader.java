package de.ait.homework29;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VideoUploader implements Uploadable {

    @Override
    public void uploadMedia(String filePath) {//filePath путь к файлу
        if (filePath == null || filePath.isEmpty()) {
            log.warn("File path is empty or null");
        } else {
            log.info("File {} uploaded", filePath);
        }
    }
}