package com.dezaru.aluraflix.controller;

import com.dezaru.aluraflix.dto.VideoDto;
import com.dezaru.aluraflix.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/v1/videos")
    public ResponseEntity<Iterable<VideoDto>> getAllVideo() {
        Iterable<VideoDto> videos = VideoDto.allVideos(videoRepository);
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/v1/videos/{id}")
    public ResponseEntity<VideoDto> getVideo(@PathVariable Integer id) {
        VideoDto video = VideoDto.getVideo(videoRepository, id);
        return ResponseEntity.ok(video);
    }

    @PostMapping("/v1/videos")
    public ResponseEntity<VideoDto> saveVideo(@Valid @RequestBody VideoDto video, UriComponentsBuilder uriBuilder) {
        URI uri = uriBuilder.path("/v1/videos/{id}").buildAndExpand(video.getId()).toUri();
        VideoDto.saveVideo(videoRepository, video);
        return ResponseEntity.created(uri).body(video);
    }

    @PutMapping("/v1/videos/{id}")
    public ResponseEntity<VideoDto> updateVideo(@PathVariable Integer id, @Valid @RequestBody VideoDto video) {
        VideoDto videoDto = VideoDto.updateVideo(videoRepository, id, video);
        if (videoDto != null)
            return ResponseEntity.ok(new VideoDto(videoDto.getId(), videoDto.getTitulo(), videoDto.getDescricao(), videoDto.getUrl()));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/v1/videos/{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable Integer id) {
        return VideoDto.deleteVideo(videoRepository, id);
    }
}
