package de.ait.homework29;

import com.sun.source.tree.BreakTree;

public interface Uploadable {

    // Поддерживаемые типы файлов
    String FILE_TYPE_JPG = ".jpg";
    String FILE_TYPE_PNG = ".png";
    String FILE_TYPE_MP4 = ".mp4";
    String FILE_TYPE_MOV = ".mov";

    void uploadMedia(String filePath); // загружает указанный медиафайл

    default boolean checkFileType(String filePath) {//Проверяет, является ли тип файла поддерживаемым.
        if (filePath.endsWith(FILE_TYPE_JPG) || filePath.endsWith(FILE_TYPE_PNG)
                || filePath.endsWith(FILE_TYPE_MP4) || filePath.endsWith(FILE_TYPE_MOV)) {
            return true;
        } else {
            return false;
        }
    }
}