package ua.com.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;


import ua.com.library.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

}
