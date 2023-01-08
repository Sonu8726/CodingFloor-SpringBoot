package com.codingfloor.api.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentDto {

	private int commentId;
	private String comment;
	private String commentLike;
	private String commentDislike;
	private String commentCourseId;
	private String commentUserId;
}
