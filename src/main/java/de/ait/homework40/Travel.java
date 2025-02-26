package de.ait.homework40;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Travel {
    public static void main(String[] args) {
        Path path = Path.of("travel_route.txt");
        List<String> result =  Files(path);

        System.out.println("Travel Route:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + ". " + result.get(i));
        }
    }
    public static List<String> Files (Path path) {
        List<String> travelList = new ArrayList<>();
        try {
            travelList = Files.readAllLines(path);
        } catch (IOException exception) {
            log.error("Error creating file: {}", exception.getMessage());
        }
        return travelList;
    }
}
