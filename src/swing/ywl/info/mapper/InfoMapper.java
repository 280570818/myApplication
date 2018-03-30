package swing.ywl.info.mapper;

import swing.ywl.info.model.Info;

public interface InfoMapper {

	Info getInfoById(Long id);
	
	void insertInfo(Info info);
	
	void updateInfoById(Info info);
	
	void deleteInfoById(Long id);
}
