package com.vanbarone.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanbarone.cursomc.domain.ItemPedido;
import com.vanbarone.cursomc.domain.ItemPedidoPk;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPk> {

}
