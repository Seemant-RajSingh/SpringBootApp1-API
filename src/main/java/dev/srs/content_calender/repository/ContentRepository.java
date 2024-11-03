package dev.srs.content_calender.repository;

import dev.srs.content_calender.model.Content;
import dev.srs.content_calender.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {
//    List<Content> findAllByContentType(String type);
    List<Content> findAllByTitleContains(String keyword);

    @Query(""" 
        SELECT * FROM Content
        WHERE status = :status
    """)

    List<Content> listByStatus(@Param("status") Status status);
}
