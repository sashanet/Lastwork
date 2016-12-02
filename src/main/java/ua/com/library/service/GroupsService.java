package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Groups;

public interface GroupsService {
	void save(Groups groups);

	List<Groups> getAll();

	Groups findOne(int id);

	void delete(int id);

}
