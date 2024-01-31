package com.jerome.sivalabsbookmarkerapi.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarksWithMapper(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.Direction.ASC, "createdAt");
        Page<BookmarkDTO> bookmarkDTOPage=repository.findAll(pageable).map(bookmarkMapper::toDTO);
        return new BookmarksDTO(bookmarkDTOPage);
    }

    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarksWithDtoProjection(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.Direction.ASC, "createdAt");
        Page<BookmarkDTO> bookmarkDTOPage=repository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarkDTOPage);
    }

}
