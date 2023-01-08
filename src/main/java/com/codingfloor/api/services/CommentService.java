package com.codingfloor.api.services;

import java.util.List;

import com.codingfloor.api.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto comment);

	CommentDto updateComment(Integer commentId, CommentDto comment);

	CommentDto getCommentById(Integer commentId);

	List<CommentDto> getAllCommentFromACourse(Integer courseId);

	String deleteComment(Integer commentId);

}
