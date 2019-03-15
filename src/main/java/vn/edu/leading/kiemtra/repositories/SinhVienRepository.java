package vn.edu.leading.kiemtra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.leading.kiemtra.models.SinhVienModel;

import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVienModel,Long> {
    List<SinhVienModel> findAllByTenContaining(String term);
}
