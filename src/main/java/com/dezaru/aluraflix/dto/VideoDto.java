package com.dezaru.aluraflix.dto;

import com.dezaru.aluraflix.model.Video;
import com.dezaru.aluraflix.repository.VideoRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class VideoDto {

    @NotNull
    private Integer id;

    @NotEmpty
    private String titulo;

    @NotEmpty
    private String descricao;

    @NotEmpty
    @URL
    private String url;

    public VideoDto(Integer id, String titulo, String descricao, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public static Iterable<VideoDto> allVideos(VideoRepository videoRepository) {
        Iterable<Video> videos = videoRepository.findAll();
        List<VideoDto> videoDtos = new ArrayList<>();

        for (Video video : videos) {
            VideoDto videoDto = new VideoDto(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
            videoDtos.add(videoDto);
        }

        return videoDtos;
    }

    public static VideoDto getVideo(VideoRepository videoRepository, Integer id) {
        Video video = videoRepository.findById(id).get();
        VideoDto videoDto = new VideoDto(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
        return videoDto;
    }

    public static VideoDto saveVideo(VideoRepository videoRepository, VideoDto videoDto) {
        Video videoSaved = videoRepository.save(new Video(videoDto.getTitulo(), videoDto.getDescricao(), videoDto.getUrl()));
        return new VideoDto(videoSaved.getId(), videoSaved.getTitulo(), videoSaved.getDescricao(), videoSaved.getUrl());
    }

    public static VideoDto updateVideo(VideoRepository videoRepository, Integer id, VideoDto videoDto) {
        if (videoRepository.existsById(id)) {
            Video updatedVideo = videoRepository.save(new Video(id, videoDto.getTitulo(), videoDto.getDescricao(), videoDto.getUrl()));
            return new VideoDto(updatedVideo.getId(), updatedVideo.getTitulo(), updatedVideo.getDescricao(), updatedVideo.getUrl());
        }
        return null;
    }

    public static ResponseEntity<?> deleteVideo(VideoRepository videoRepository, Integer id) {
        videoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
