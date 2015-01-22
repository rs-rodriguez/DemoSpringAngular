package com.angular.spring.service;

import java.util.List;

import com.angular.spring.model.Registros;

/**
 * @Autor Samuel.Guardado
 * @FechaCreacion 20/01/2015
 */
public interface RegistroService {

	public static final String COLLECTION_NAME = "registros";

	public abstract void addRegistro(Registros registro);

	public abstract List<Registros> listRegistro();

	public abstract void deleteRegistro(Registros registro);

	public abstract void updateRegistro(Registros registro);

}