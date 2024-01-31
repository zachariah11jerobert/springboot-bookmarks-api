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

    @GetMapping("/all")
    public List<Bookmark> getAllBookmarks() {
        return bookmarkService.getAllBookmarks();
    }



    @GetMapping("/paginated-with-DTO")
    public BookmarksDTO getPaginatedBookmarksDTO(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return bookmarkService.getPaginatedBookmarksDTO(page);
    }
}
