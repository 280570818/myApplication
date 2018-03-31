package swing.ywl.info.mapper;

import java.util.List;

import swing.ywl.info.model.Info;

public interface InfoMapper {

	Info getInfoById(Long id);
	
	void insertInfo(Info info);
	
	void updateInfoById(Info info);
	
	void deleteInfoById(Long id);
	
	List<Info> getAll();
}
