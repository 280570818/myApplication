package swing.ywl.info.mapper;

import java.util.List;

import swing.ywl.info.model.Description;

public interface DescriptionMapper {

	Description getDescriptionById(Long id);
	
	void insertDescription(Description description);
	
	void updateDescriptionById(Description description);
	
	void deleteDescriptionById(Long id);
	
	List<Description> getAllDescription();
}
