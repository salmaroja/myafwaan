package com.zawadig.myafwanii.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class PdfStorageService {

    private final Path storagePath;

    public PdfStorageService(@Value("${pdf.storage.path:./uploads/pdfs}") String storagePath) throws IOException {
        this.storagePath = Paths.get(storagePath).toAbsolutePath().normalize();
        Files.createDirectories(this.storagePath);
    }

    // Kuhifadhi PDF kwenye server
    public String storePdf(MultipartFile file, String controlNumber) throws IOException {
        // Tengeneza jina la file kwa kutumia controlNumber
        String filename = "application_" + controlNumber + ".pdf";
        Path targetPath = this.storagePath.resolve(filename);

        // Hifadhi file kwenye storage
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        return filename;
    }

    // Kupakua PDF kutoka kwenye server
    public Resource loadPdf(String filename) throws FileNotFoundException {
        try {
            Path filePath = this.storagePath.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("PDF haikutambuliwa: " + filename);
            }
        } catch (Exception e) {
            throw new FileNotFoundException("Haiwezekani kusoma file: " + filename);
        }
    }

    // Kufuta PDF (optional)
    public void deletePdf(String filename) throws IOException {
        Path filePath = this.storagePath.resolve(filename).normalize();
        Files.deleteIfExists(filePath);
    }
}