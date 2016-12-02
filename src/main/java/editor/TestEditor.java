package editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;


import ua.com.library.service.GroupsService;
import ua.com.library.service.TestService;

public class TestEditor  extends PropertyEditorSupport{
	private final TestService testService;
	
	public TestEditor(TestService testService) {
		super();
		this.testService = testService;
	}

	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(testService.findOne(Integer.parseInt(text)));
	}
	

}
