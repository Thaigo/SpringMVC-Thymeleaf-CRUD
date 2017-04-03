package loja.produtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;

	public List<ProdutoEntity> index() {
		return produtoRepository.findAll();
	}
	
	public ProdutoEntity buscaPorId(Integer id) {
		return produtoRepository.findOne(id);
	}
	
	public ProdutoEntity create(ProdutoEntity produto) {
		return produtoRepository.saveAndFlush(produto);
	}
	
	public void destroy(Integer id) {
		produtoRepository.delete(id);
	}
}
