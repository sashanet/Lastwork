package editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.library.service.GroupsService;
import ua.com.library.service.QuestionService;
import ua.com.library.service.TestService;

public class GroupsEditor extends PropertyEditorSupport{





	private final GroupsService groupsService;
	
	public GroupsEditor(GroupsService groupsService) {
		super();
		this.groupsService = groupsService;
		
	}


	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(groupsService.findOne(Integer.parseInt(text)));
	}
	
}

