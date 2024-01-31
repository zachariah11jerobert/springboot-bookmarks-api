package com.jerome.sivalabsbookmarkerapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository repository;

    @Transactional(readOnly = true)
    public List<Bookmark> getAllBookmarks() {
        return repository.findAll();

    }
    @Transactional(readOnly = true)
    public List<Bookmark> getPaginatedBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        return repository.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    public BookmarksDTO getPaginatedBookmarksDTO(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.Direction.ASC, "createdAt");
        return new BookmarksDTO(repository.findAll(pageable));
    }

}
