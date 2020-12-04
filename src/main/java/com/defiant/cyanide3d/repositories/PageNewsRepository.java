package com.defiant.cyanide3d.repositories;

import com.defiant.cyanide3d.models.News;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PageNewsRepository extends PagingAndSortingRepository<News, Integer> {
}
