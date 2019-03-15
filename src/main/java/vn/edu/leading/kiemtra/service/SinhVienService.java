package vn.edu.leading.kiemtra.service;

import vn.edu.leading.kiemtra.models.SinhVienModel;

import java.util.List;

public interface SinhVienService  {
    List<SinhVienModel> findAll();

    List<SinhVienModel> search(String term);

    boolean update (SinhVienModel sinhVienModel);

    void save (SinhVienModel sinhVienModel);

    SinhVienModel findById(Long id);

    boolean delete (Long id);
}
