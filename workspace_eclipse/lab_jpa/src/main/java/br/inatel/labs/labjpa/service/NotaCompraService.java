package br.inatel.labs.labjpa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotaCompraService {
	
	@PersistenceContext
	private EntityManager em;
	
	// nota compra
	public NotaCompra salvarNotaCompra(NotaCompra nota) {
		return em.merge(nota);
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		return em.find(NotaCompra.class, id);
	}
	
	public List<NotaCompra> listarNotaCompra(){
		return em.createQuery("select n from NotaCompra n", NotaCompra.class)
				.getResultList();
	}
	
	public NotaCompra buscarNotaCompraItemPeloIdComListaItem(Long id) {
		NotaCompra notacompra = em.find(NotaCompra.class, id);
		notacompra.getListaNotaCompraItem().size();
		return notacompra;
	}
	
	// nota compra item
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
			return em.merge(item);
	}
	
	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		return em.find(NotaCompraItem.class, id);
	}
	
	public List<NotaCompraItem> listarNotaCompraItem(){
		return em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class)
				.getResultList();
	}
	
}
