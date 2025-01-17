package de.ait.abstractclass;

public class SocialMediaManager {
    public static void main(String[] args) {

        // Создание экземпляра Facebook и выполнение действий
        SocialMedia facebook = new Facebook("facebookUser");
        facebook.postContent("I love my new job");
        facebook.likePost();

        System.out.println("---------------------------");

        // Создание экземпляра Instagram и выполнение действий
        SocialMedia instagram = new Instagram("instagramUser");
        instagram.postContent("I love my new cat");
        instagram.likePost();


    }
}

