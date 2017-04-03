package loja.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import loja.categorias.CategoriaEntity;


public class CategoriaConverter implements Converter<String, CategoriaEntity> {

	@Override
	public CategoriaEntity convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			CategoriaEntity categoria = new CategoriaEntity();
			categoria.setId(Integer.valueOf(id));
			return categoria;
		}
		
		return null;
	}

}
