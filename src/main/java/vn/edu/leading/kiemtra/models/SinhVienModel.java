package vn.edu.leading.kiemtra.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table (name = "sinhvien")
public class SinhVienModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String ten;

    @NotEmpty
    private String tuoi;

    @Column (name = "que_quan")
    private String queQuan;

    public SinhVienModel() {
    }
}
