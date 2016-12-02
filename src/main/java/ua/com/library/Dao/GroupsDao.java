package ua.com.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.Groups;

public interface GroupsDao extends JpaRepository<Groups, Integer>{

}
