package com.example.jpa;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
@EnableJpaAuditing
public class JpaOneToManyDemoApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyDemoApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		Post post1 = new Post("title1", "Description1", "Content1");

		Set<Comment> set1 = new HashSet<>();
		Comment post1_Comment1 = new Comment("Post1_Comment1");
		Comment post1_Comment2 = new Comment("Post2_Comment2");
		Comment post1_Comment3 = new Comment("Post3_Comment3");
		set1.add(post1_Comment1);
		set1.add(post1_Comment2);
		set1.add(post1_Comment3);
		post1.setComments(set1);
		this.postRepository.save(post1);

		Post post2 = new Post("title2", "Description2", "Content2");
		Set<Comment> set2 = new HashSet<>();
		Comment Post2_Comment1 = new Comment("Post1_Comment1");
		Comment Post2_Comment2 = new Comment("Post2_Comment2");
		Comment Post3_Comment3 = new Comment("Post3_Comment3");
		set2.add(Post2_Comment1);
		set2.add(Post2_Comment2);
		set2.add(Post3_Comment3);
		post2.setComments(set2);
		this.postRepository.save(post2);


		//Post post3 = new Post("title3","Description3","Content3");
		//Post post4 = new Post("title4","Description4","Content4");
		//Post post5 = new Post("title5","Description5","Content5");


	}


}

