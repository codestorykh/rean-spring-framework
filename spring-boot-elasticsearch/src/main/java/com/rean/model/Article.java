package com.rean.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "blog")
@Getter @Setter
public class Article {
    @Id
    private Long id;

    @Field(type = FieldType.Text, name = "title")
    private String title;
}