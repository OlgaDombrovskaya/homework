package de.ait.homework29;

public class MainMedia {
    public static void main(String[] args) {

        Uploadable videoUploader = new VideoUploader();
        String videoPath = "/Dokuments/private/video.mp4";
        boolean checkFileResult = videoUploader.checkFileType(videoPath); // проверяем "JPG" в checkFileType в videoUploader
        // вызов метода checkFileType (в Uploadable) объекта videoUploader который реализует абстрактный класс Uploadable,
        //Результат работы метода checkFileType присваивается переменной checkFileResult в виде true или false
        if (checkFileResult) {
            videoUploader.uploadMedia(videoPath);
        } else {
            System.out.println("Wrong video type");
        }

        System.out.println("---------------------------");

        // Uploading an image file
        // Загрузка изображения
        String imagePath = "/Dokuments/private/image.jpg";
        Uploadable imageUpload = new PhotoUploader();
        boolean checkImageResult = imageUpload.checkFileType(imagePath);
        if (checkImageResult) {
            imageUpload.uploadMedia(imagePath);
        } else {
            System.out.println("Wrong image type");
        }

        System.out.println("---------------------------");

        // Попытка загрузки неподдерживаемого файла
        String photoPath = "/Dokuments/private/image.png24";
        Uploadable photoUploader = new PhotoUploader();
        boolean checkPhotoResult = imageUpload.checkFileType(photoPath);
        if (checkPhotoResult) {
            photoUploader.uploadMedia(photoPath);
        } else {
            System.out.println("Wrong photo type");
        }
    }
}

