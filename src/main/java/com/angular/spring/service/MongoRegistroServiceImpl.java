package com.angular.spring.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.angular.spring.model.Registros;


/**
 * @Autor Samuel.Guardado
 * @FechaCreacion 20/01/2015
 */
@Service
public class MongoRegistroServiceImpl implements RegistroService {
	
	private final Logger logger = LoggerFactory.getLogger(MongoRegistroServiceImpl.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	/* (non-Javadoc)
	 * @see com.angular.spring.service.RegistroService#addRegistro(com.angular.spring.model.Registros)
	 */
	@Override
	public void addRegistro(Registros registro) {
		
		logger.info("Aaddregistro");
		
		if (!mongoTemplate.collectionExists(Registros.class)) {
			mongoTemplate.createCollection(Registros.class);
		}		
		registro.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(registro, COLLECTION_NAME);
	}
	
	
	/* (non-Javadoc)
	 * @see com.angular.spring.service.RegistroService#listRegistro()
	 */
	@Override
	public List<Registros> listRegistro() {
		logger.info("listregistro");
		return mongoTemplate.findAll(Registros.class, COLLECTION_NAME);
	}
	
	
	/* (non-Javadoc)
	 * @see com.angular.spring.service.RegistroService#deleteRegistro(com.angular.spring.model.Registros)
	 */
	@Override
	public void deleteRegistro(Registros registro) {
		logger.info("deleteregistro");
		mongoTemplate.remove(registro, COLLECTION_NAME);
	}
	
	
	/* (non-Javadoc)
	 * @see com.angular.spring.service.RegistroService#updateRegistro(com.angular.spring.model.Registros)
	 */
	@Override
	public void updateRegistro(Registros registro) {
		logger.info("updateRegistro");
		mongoTemplate.insert(registro, COLLECTION_NAME);		
	}
}
