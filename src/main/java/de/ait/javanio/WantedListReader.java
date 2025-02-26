package de.ait.javanio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WantedListReader {
    public static void main(String[] args) {
        Path path = Path.of("wanted.txt");
        // Читаем список из файла и сохраняем его в список result
        List<String> result = readWantedList(path);
        for (String line : result) {
            log.info(line);
        }
    }

    public static List<String> readWantedList(Path path) {
        // StringBuilder для накопления данных, прочитанных из файла
        StringBuilder stringBuilder = new StringBuilder();
        // Список для хранения строк из файла
        List<String> wantedList = new ArrayList<>();

        // Открываем FileChannel для чтения файла
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)){
            ByteBuffer buffer = ByteBuffer.allocate(256);
           // Переменная для хранения количества прочитанных байт
            int bytesRead;
            // Читаем данные из файла в буфер
            while ((bytesRead = fileChannel.read(buffer)) != -1){
                // Переключаем буфер в режим чтения
                buffer.flip();
                // Читаем данные из буфера и добавляем их в StringBuilder
                while (buffer.hasRemaining()){
                    stringBuilder.append((char)buffer.get());
                }
                // Очищаем буфер для следующего чтения
                buffer.clear();
            }
        }
        catch (IOException exception){
            log.error("Error creating file: {}", exception.getMessage());
        }
        // Разделяем содержимое StringBuilder на строки по символу новой строки
        String[] lines = stringBuilder.toString().split("\n");
        // Добавляем каждую строку в список wantedList
        for (String line : lines) {
            wantedList.add(line);
        }

        return wantedList;
    }
}
