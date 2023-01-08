package com.codingfloor.api.services;

import java.util.List;
import com.codingfloor.api.payloads.PostDto;

public interface PostService {

	PostDto createAPost(PostDto postDto);

	PostDto updateAPost(Integer postId, PostDto postDto);

	PostDto getPostById(Integer postId);

	List<PostDto> getAllPost();

	String deletePost(Integer postId);

}
