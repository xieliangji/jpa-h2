package xieliangji.springboot.jpah2.dto;

import lombok.Builder;
import lombok.Data;

public class AlbumRequest {

    @Data
    @Builder
    public static class AlbumCreate {

        private String title;

        private String artist;

        private Double price;
    }

    @Data
    @Builder
    public static class AlbumUpdate {

        private Integer id;

        private String title;

        private String artist;

        private Double price;
    }
}
