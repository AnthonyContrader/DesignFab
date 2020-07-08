package it.contrader.service;

import java.util.List;

import it.contrader.dto.MaterialsDTO;

/**
 * 
 * @author Vittorio
 *
 * @param <DTO> questo è un tipo generico!
 */
public interface Service<DTO> {
	/**
	 * Segue la firma dei metodi da implementare nella classe AbstractService
	 */
	public List<DTO> getAll();
	
	public DTO read(int id);
	
	public boolean insert(DTO dto);
	
	public boolean update(DTO dto);
	
	public boolean delete(int id);

	public boolean updateQuantity(DTO dto);

}
