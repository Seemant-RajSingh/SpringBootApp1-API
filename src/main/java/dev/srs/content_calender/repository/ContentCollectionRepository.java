package dev.srs.content_calender.repository;

import dev.srs.content_calender.model.Content;
import dev.srs.content_calender.model.Status;
import dev.srs.content_calender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    // expect CRED operations logic

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {

    }

    // return all content
    public List<Content> findAll() {
        return contentList;
    }

    // return single content matching id
    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    // creating new data at
    @PostConstruct
    private void init() {
        // this data gets added when app starts
        Content c = new Content(
                1,
                "First post",
                "First post on blog",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );


        contentList.add(c);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
