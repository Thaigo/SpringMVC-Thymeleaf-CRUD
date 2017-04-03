package loja.produtos;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import loja.categorias.CategoriaRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private CategoriaRepository categorias;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produtos")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/produtos/index");
		mv.addObject("produtos", produtoService.index());
		
		return mv;
	}	
	

	@GetMapping("/produtos/new")
	public ModelAndView add(ProdutoEntity produto) {
		ModelAndView mv = new ModelAndView("/produtos/new");
		mv.addObject("produto", produto);	
		mv.addObject("categorias", categorias.findAll());
		return mv;
	}
	
	@PostMapping("/produtos/create")
	public ModelAndView create(@Valid ProdutoEntity produto, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(produto);
		}
		
		produtoService.create(produto);
		
		
		return index();
	}
	
	@GetMapping("/produtos/delete/{id}")
	public ModelAndView destroy(@PathVariable("id") Integer id) {
		
		produtoService.destroy(id);
		return index();
		
	}
	
	@GetMapping("/produtos/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {		
		return add(produtoService.buscaPorId(id));
	}
	
	

}
