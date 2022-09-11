package br.infnet.gabrieljustino.acmelogs.tp.acmelogs.controllers;

import br.infnet.gabrieljustino.acmelogs.tp.acmelogs.services.AmazonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/buckets")
public class BucketsController {

    @Autowired
    AmazonService amazonService;

    @GetMapping
    public String listar(Model model) {

        try {

            var bkcs = amazonService.listOfBuckets();
            model.addAttribute("bucketsList", bkcs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "buckets/lista";
    }

    @PostMapping("/upload")
    public String MyUploadByMulti(@RequestPart(value = "bucketName") String bucketName,
                                  @RequestPart(value = "file") MultipartFile file) {
        var result = amazonService.uploadFile(bucketName, file);
        System.out.println(result);
        // return "redirect:/" + listar(model);
        return "redirect:/buckets";
    }

    @GetMapping("lista/arquivos/{bucketName}")
    public String listarArqv(@PathVariable String bucketName, Model model) {
        var result = amazonService.listObjects(bucketName);
        model.addAttribute("bucketFiles", result);

        System.out.println(result);
        return "buckets/listaArquivos";

    }

}
