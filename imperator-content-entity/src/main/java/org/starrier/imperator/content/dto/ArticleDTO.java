package org.starrier.imperator.content.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Article DTO
 *
 * @author Starrier
 * @date 2019/4/28
 */
@Setter
@Getter
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

    private String author;

    private String title;

    private String category;
}
