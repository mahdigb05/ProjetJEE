package com.jee.Controlleurs;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin(origins = "*")
public class FileDownloadControlleur {
    @RequestMapping(path = "/download/{path}", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(@PathVariable String path) throws IOException {


        File fichier = new File(path);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(fichier));

        return ResponseEntity.ok()
                .contentLength(fichier.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
