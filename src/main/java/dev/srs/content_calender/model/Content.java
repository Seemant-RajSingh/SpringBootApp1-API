package dev.srs.content_calender.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

//@Table(value="tbl_content")
public record Content(
        @Id
        Integer id,
//      @Column("str_title")
        @NotBlank   //constraints from sb starter validation (mvn manages)
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {

}
