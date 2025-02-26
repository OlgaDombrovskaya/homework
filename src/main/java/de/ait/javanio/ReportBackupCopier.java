package de.ait.javanio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Slf4j
public class ReportBackupCopier {
    public static void main(String[] args) {
        Path source = Path.of("crimes_report.txt");
        Path destination = Path.of("backup_crimes_report.txt");
        // Вызываем метод для копирования отчета
        copyReport(source, destination);
    }

    public static void copyReport(Path source, Path destination) {
        try {
            if (!Files.exists(destination)) {
                Files.createFile(destination);

                try (FileChannel inFileChannel = FileChannel.open(source, StandardOpenOption.READ);
                     FileChannel outFileChannel = FileChannel.open(destination, StandardOpenOption.WRITE)) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // Переменная для хранения количества прочитанных байт
                    int bytesRead;
                    // Читаем данные из исходного файла в буфер и записываем их в целевой файл
                    while ((bytesRead = inFileChannel.read(buffer)) != -1) {
                        // Переключаем буфер в режим чтения
                        buffer.flip();
                        // Записываем данные из буфера в целевой файл
                        outFileChannel.write(buffer);
                        buffer.clear();
                    }
                }

            }
        } catch (IOException exception) {
            log.error("Error creating file: {}", exception.getMessage());
        }
    }
}