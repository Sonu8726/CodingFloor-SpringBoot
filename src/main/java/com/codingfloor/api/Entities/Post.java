package com.codingfloor.api.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	private String postTitle;
	private String postMiniTitle;
	private String postDescription;
	private String postVideoLink;
	private String postMetaData;
	private String postTags;
	private String postCategoryId;
	private String postSubCategoryId;
	private String postLikes;

}
