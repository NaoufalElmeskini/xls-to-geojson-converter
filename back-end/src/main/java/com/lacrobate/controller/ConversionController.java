package com.lacrobate.controller;

import com.lacrobate.converter.ConverterUtils;
import com.lacrobate.model.output.GeoJsonResult;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ConversionController {

    @PostMapping("/conversion")
    public String processFileUpload(
            @RequestParam("file") MultipartFile fichierATraiter,
            RedirectAttributes redirectAttributes) {
        System.out.println("processFileUpload: starting...");

        redirectAttributes.addFlashAttribute("message", "fichier chargé avec succès !");

        System.out.println("processFileUpload: success");
        return "redirect:/";
    }

    @GetMapping("/conversion/download")
    @ResponseStatus(HttpStatus.OK)
    public Resource downloadFile(HttpServletResponse response) {
        String filePath = ConverterUtils.getAbsoluteTargetFilePath();
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        return fileSystemResource;
    }
}
