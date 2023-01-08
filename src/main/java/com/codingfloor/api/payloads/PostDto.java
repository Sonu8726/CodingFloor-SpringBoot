package com.codingfloor.api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

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
