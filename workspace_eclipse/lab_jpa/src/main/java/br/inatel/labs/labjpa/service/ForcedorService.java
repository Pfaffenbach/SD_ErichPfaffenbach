package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ForcedorService {

	@PersistenceContext
	private EntityManager em;
	
	public Fornecedor salvar(Fornecedor f) {
		f = em.merge(f);
		return f;
	}
	
	public Fornecedor buscarPeloId(Long id) {
		Fornecedor f = em.find(Fornecedor.class, id);
		return f;
	}
	
	public List<Fornecedor> listar(){
		List<Fornecedor> listaFornecedor = em.createQuery("select f from Product f", Fornecedor.class)
				.getResultList();
		return listaFornecedor;
	}
	
	public void remover(Fornecedor f) {
		f = em.merge(f);//provoca a transição para o estado Managed
		em.remove(f);//uma vez em Managed, posso remover
	}
}
