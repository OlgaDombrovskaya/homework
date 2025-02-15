package de.ait.homework36;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class YouTubeAnalyzer {
    // Список видео для анализа / List of videos for analysis
    private static List<Video> videos = List.of(
            new Video("Как научиться программировать", "IT Channel", 1500000, 12000, 720, "Образование", true),
            new Video("Лучшие моменты матча", "Sports Channel", 500000, 8000, 600, "Спорт", false),
            new Video("Новый трек 2025", "Music Channel", 3000000, 25000, 240, "Музыка", true),
            new Video("Обзор новой игры", "Gaming Channel", 2000000, 15000, 900, "Игры", true),
            new Video("Как приготовить пиццу", "Cooking Channel", 800000, 10000, 1200, "Кулинария", false),
            new Video("Как приготовить кофе", "Cooking Channel", 100_000, 70000, 1400, "Кулинария", true)
    );

    public static void main(String[] args) {
        // Примеры использования методов / Examples of using methods
        //System.out.println(getVideosWithMoreThan1MViews());
        //System.out.println(getTitlesOfLongVideos());
        //System.out.println(getUniqueCategories());
        //System.out.println(getTitlesUpperCase());
        //System.out.println(getVideoLikes());
        //System.out.println(getMostLikedVideos());
        //System.out.println(getMostDurationVideos());
        //System.out.println(getAllVideosCount());
        //System.out.println(getMostLikedVideo());
        //System.out.println(getLessDurationVideo());
        //System.out.println(isVideo1M());
        System.out.println(allMusicVideosIsMonetized());
        System.out.println(groupVideosByCategory());
        System.out.println(getAverageViews());
        System.out.println(hasVideoLongerThan1Hour());
    }


    // 1.1 Видео с более чем 1 млн просмотров
    public static List<Video> getVideosWithMoreThan1MViews() {
        List<Video> videosWithMoreThan1MViews = videos.stream()
                .filter(video -> video.getViews() > 1_000_000)
                .collect(Collectors.toList());
        return videosWithMoreThan1MViews;
    }


    // 1.2 Названия видео длиннее 10 минут
    public static List<String> getTitlesOfLongVideos() {
        List<String> titlesOfLongVideos = videos.stream()
                .filter(video -> video.getDuration() > 600)
                .map(Video::getTitle)
                .collect(Collectors.toList());
        return titlesOfLongVideos;
    }

    // 1.3 Уникальные категории видео
    public static List<String> getUniqueCategories(){
        List<String> uniqueCategories = videos.stream()
                .map(Video::getCategory)
                .distinct()
                .collect(Collectors.toList());
        return uniqueCategories;
    }

    // 2.1 Названия видео в верхнем регистре
    public static List<String> getTitlesUpperCase(){
        List<String> titlesUpperCase = videos.stream()
                .map(Video::getTitle)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return titlesUpperCase;
    }

    // 2.2 Список объектов "Название - лайки"
    public static List<Map.Entry<String, Integer>> getVideoLikes(){
        List<Map.Entry<String, Integer>> videosLikes = videos.stream()
                .map(video -> Map.entry(video.getTitle(), video.getLikes()))
                .collect(Collectors.toList());
        return videosLikes;
    }


    // 3.1 Топ-5 видео по просмотрам (убывание)
    public static List<Video> getMostLikedVideos(){
        List<Video> mostLikedVideos = videos.stream()
                .sorted(Comparator.comparingInt(Video::getViews).reversed())
                .limit(5)
                .collect(Collectors.toList());
        return mostLikedVideos;
    }

    // 3.2 Топ-3 самых коротких видео
    public static List<Video> getMostDurationVideos(){
        List<Video> mostDurationVideos = videos.stream()
                .sorted(Comparator.comparingInt(Video::getDuration))
                .limit(3)
                .collect(Collectors.toList());
        return mostDurationVideos;
    }

    // 4.1 Метод для получения общего количества видео.
    public static long getAllVideosCount(){
        long allVideosCount = videos.stream()
                .count();
        return allVideosCount;
    }

    // 4.2 Видео с максимальным числом лайков
    public static Optional<Video> getMostLikedVideo(){
        Optional<Video> mostLikedVideo = videos.stream()
                .max(Comparator.comparingInt(Video::getLikes));
        return mostLikedVideo;
    }

    // 4.3 Видео с минимальной длительностью
    public static Optional<Video> getLessDurationVideo(){
        Optional<Video> lessDurationVideo = videos.stream()
                .min(Comparator.comparingInt(Video::getDuration));
        return lessDurationVideo;
    }

    // 5.1 Есть ли видео с >10 млн просмотров?
    public static boolean isVideo1M(){
        boolean result = videos.stream()
                .anyMatch(video -> video.getViews() > 10_000_000);
        return result;
    }

    // 5.2 Все ли видео в категории "Музыка" монетизированы?
    public static boolean allMusicVideosIsMonetized(){
        boolean result = videos.stream()
                .filter(video -> video.getCategory().equals("Музыка"))
                .allMatch(video -> video.isMonetized());
        return result;
    }

    // Доп.1 Группировка видео по категориям
    public static Map<String, List<Video>> groupVideosByCategory() {
        return videos.stream()
                .collect(Collectors.groupingBy(Video::getCategory));
    }

    // Доп.2 Среднее количество просмотров
    public static double getAverageViews() {
        return videos.stream()
                .collect(Collectors.averagingInt(Video::getViews));
    }

    // Доп.3 Есть ли видео длиннее 1 часа?
    public static boolean hasVideoLongerThan1Hour() {
        boolean result = videos.stream()
                .anyMatch(video -> video.getDuration() > 3600);
        return result;
    }
}
