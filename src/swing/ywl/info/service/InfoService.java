package swing.ywl.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swing.ywl.info.mapper.InfoMapper;

@Service
public class InfoService {

	@Autowired
	private InfoMapper infoMapper;
	
	
	
}
