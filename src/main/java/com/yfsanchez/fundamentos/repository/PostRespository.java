package com.yfsanchez.fundamentos.repository;

import com.yfsanchez.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository extends JpaRepository<Post, Long> {
}
