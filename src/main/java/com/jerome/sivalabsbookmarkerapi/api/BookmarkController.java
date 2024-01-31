package com.jerome.sivalabsbookmarkerapi.api;

import com.jerome.sivalabsbookmarkerapi.domain.Bookmark;
import com.jerome.sivalabsbookmarkerapi.domain.BookmarkService;
import com.jerome.sivalabsbookmarkerapi.domain.BookmarksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("/mapper")
    public BookmarksDTO getPaginatedBookmarksDtoWithMapper(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return bookmarkService.getBookmarksWithMapper(page);
    }

    @GetMapping("/projection")
    public BookmarksDTO getPaginatedBookmarksDtoWithProjection(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return bookmarkService.getBookmarksWithDtoProjection(page);
    }
}
