package fr.formation.upload;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.formation.security.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Secured(SecurityConstants.ROLE_USER)
public class UploadController {

    @Autowired
    UploadService uploadService;



}