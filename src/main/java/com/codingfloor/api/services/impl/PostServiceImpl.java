package com.codingfloor.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingfloor.api.Entities.Post;
import com.codingfloor.api.exceptions.ResourceNotFoundException;
import com.codingfloor.api.payloads.PostDto;
import com.codingfloor.api.repositories.PostRepository;
import com.codingfloor.api.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createAPost(PostDto postDto) {
		Post post = this.dtoToEntity(postDto);
		Post savedPost = this.postRepo.save(post);
		return entityToDto(savedPost);
	}

	@Override
	public PostDto updateAPost(Integer postId, PostDto postDto) {
		Post cs = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post ID", postId));

		cs.setPostTitle(postDto.getPostTitle());
		cs.setPostMiniTitle(postDto.getPostMiniTitle());
		cs.setPostDescription(postDto.getPostDescription());
		cs.setPostVideoLink(postDto.getPostVideoLink());
		cs.setPostMetaData(postDto.getPostMetaData());
		cs.setPostTags(postDto.getPostTags());
		cs.setPostCategoryId(postDto.getPostCategoryId());
		cs.setPostSubCategoryId(postDto.getPostSubCategoryId());
		cs.setPostLikes(postDto.getPostLikes());

		Post updatedPost = this.postRepo.save(cs);
		return entityToDto(updatedPost);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post ID", postId));
		return this.entityToDto(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> posts = this.postRepo.findAll();

		List<PostDto> postDtos = posts.stream().map(post -> this.entityToDto(post)).collect(Collectors.toList());

		return postDtos;
	}

	@Override
	public String deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post ID", postId));
		this.postRepo.delete(post);
		return "courseId: " + postId + " is deleted form the table.";
	}

	private Post dtoToEntity(PostDto postDto) {
		Post post = this.modelMapper.map(postDto, Post.class);
		return post;
	}

	private PostDto entityToDto(Post post) {
		PostDto postDto = this.modelMapper.map(post, PostDto.class);
		return postDto;
	}

}
