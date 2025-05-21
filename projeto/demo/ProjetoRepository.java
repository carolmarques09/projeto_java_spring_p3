package projeto.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pessoa.Pessoa;

@Repository
public interface ProjetoRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findAllByAtivoTrue(Pageable paginacao);
}
