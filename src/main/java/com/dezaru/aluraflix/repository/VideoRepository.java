package com.dezaru.aluraflix.repository;

import com.dezaru.aluraflix.model.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Integer> {
}
