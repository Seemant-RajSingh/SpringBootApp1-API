package dev.srs.content_calender.controller;

import dev.srs.content_calender.model.Content;
import dev.srs.content_calender.model.Status;
import dev.srs.content_calender.repository.ContentCollectionRepository;

import dev.srs.content_calender.repository.ContentJdbcTemplateRepository;
import dev.srs.content_calender.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin    // resolves CORS error when frontend communicates with port 8080
public class ContentController {

    // setting up repository config


//    private final ContentJdbcTemplateRepository repository;

    // ----------------------------------------
//    private final ContentCollectionRepository repository;
//
//    public ContentController(ContentCollectionRepository contentCollectionRepository) {
////        repository = new ContentCollectionRepository();
//          this.repository = contentCollectionRepository;
//    }

    // -----------------------

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
//        repository = new ContentCollectionRepository();
        this.repository = repository;
    }

    // ----------------------------------------

    // read
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")    // dynamic id
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found."));
    }

    // -----------------------------------------------
    // create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")    // post req at /api/content
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }


    //update on id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found.");
        }
        repository.save(content);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }
}
