package de.ait.genericsLesson2;

import java.util.ArrayList;
import java.util.List;

public class ArtGallery  <T>{
        private List<T> paintings = new ArrayList<>();

        private void addPainting(T painting){
            paintings.add(painting);
        }

        public void printAllPaintings(){
            for(T painting: paintings){
                System.out.println(painting);
            }
        }
    }