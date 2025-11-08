package tn.esprit.spring.tpcafe_maramboussalem.mapper;

import org.mapstruct.Mapper;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;

@Mapper(componentModel = "spring")
public interface ArticleMapper {

    Article toEntity(ArticleRequest dto);
    ArticleResponse toDto(Article article);

}
