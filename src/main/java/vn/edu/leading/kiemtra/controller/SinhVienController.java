package vn.edu.leading.kiemtra.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.kiemtra.models.SinhVienModel;
import vn.edu.leading.kiemtra.service.SinhVienService;

import javax.validation.Valid;

@Controller
public class SinhVienController {

    private final SinhVienService sinhVienService;

    public SinhVienController(SinhVienService sinhVienService) {
        this.sinhVienService = sinhVienService;
    }

    @GetMapping("/sinhvien")
    public String list(Model model) {
        model.addAttribute("sinhvien", sinhVienService.findAll());
        return "sinhvien/list";
    }

    @GetMapping("sinhvien/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/sinhvien";
        }
        model.addAttribute("sinhvien", sinhVienService.search(term));
        return "sinhvien/list";
    }

    @GetMapping("/sinhvien/add")
    public String add(Model model) {
        model.addAttribute("sinhvienModel", new SinhVienModel());
        return "sinhvien/form";
    }

    @GetMapping("/sinhvien/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("sinhvienModel", sinhVienService.findById(id));
        return "sinhvien/form";
    }

    @PostMapping("/sinhvien/save")
    public String save(@Valid SinhVienModel sinhvien, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "sinhvien/form";
        }
        sinhVienService.save(sinhvien);
        redirect.addFlashAttribute("successMessage", "Saved sinhvien successfully!");
        return "redirect:/sinhvien";
    }

    @GetMapping("/sinhvien/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (sinhVienService.delete(id)) {
            redirect.addFlashAttribute("successMessage", "Deleted sinhvien successfully!");
            return "redirect:/sinhvien";
        } else {
            redirect.addFlashAttribute("successMessage", "Not found!!!");
            return "redirect:/sinhvien";
        }
    }
}
