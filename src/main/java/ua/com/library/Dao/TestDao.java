package ua.com.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Test;

public interface TestDao  extends JpaRepository<Test,Integer>{

}
