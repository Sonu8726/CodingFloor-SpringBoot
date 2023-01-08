package com.codingfloor.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingfloor.api.payloads.CommentDto;
import com.codingfloor.api.repositories.CommentRepository;
import com.codingfloor.api.services.CommentService;
import com.codingfloor.api.Entities.Comment;
import com.codingfloor.api.exceptions.ResourceNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto) {
		Comment comment = this.dtoToEntity(commentDto);
		Comment savedComment = this.commentRepo.save(comment);
		return entityToDto(savedComment);
	}

	@Override
	public CommentDto updateComment(Integer commentId, CommentDto commentDto) {
		Comment cs = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment ID", commentId));

		cs.setComment(commentDto.getComment());
		cs.setCommentCourseId(commentDto.getCommentCourseId());
		cs.setCommentUserId(commentDto.getCommentUserId());
		cs.setCommentLike(commentDto.getCommentLike());
		cs.setCommentDislike(commentDto.getCommentDislike());

		Comment updatedComment = this.commentRepo.save(cs);
		return entityToDto(updatedComment);
	}

	@Override
	public CommentDto getCommentById(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment ID", commentId));
		return this.entityToDto(comment);
	}

	@Override
	public String deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment ID", commentId));
		this.commentRepo.delete(comment);
		return "Comment with Id: " + commentId + " is deleted form the table.";
	}

	private Comment dtoToEntity(CommentDto commentDto) {
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		return comment;
	}

	private CommentDto entityToDto(Comment comment) {
		CommentDto commentDto = this.modelMapper.map(comment, CommentDto.class);
		return commentDto;
	}

	@Override
	public List<CommentDto> getAllCommentFromACourse(Integer commentId) {
		List<Comment> comments = this.commentRepo.findAll();

		List<CommentDto> commentDtos = comments.stream().map(comment -> this.entityToDto(comment))
				.collect(Collectors.toList());

		return commentDtos;
	}

}
