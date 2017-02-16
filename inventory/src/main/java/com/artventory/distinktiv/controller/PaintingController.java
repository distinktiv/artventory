package com.artventory.distinktiv.controller;

import com.artventory.distinktiv.domain.Painting;
import com.artventory.distinktiv.domain.form.PaintingCreatedForm;
import com.artventory.distinktiv.service.Exceptions.StorageFileNotFoundException;
import com.artventory.distinktiv.service.PaintingService;
import com.artventory.distinktiv.service.StorageService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by distinktiv on 2016-12-27.
 */

@RestController
@RequestMapping(value = "/paintings")
public class PaintingController {

    @Autowired
    private PaintingService paintingService;
    @Autowired
    private StorageService storageService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Painting> getAllPainting(){
        return paintingService.getAllPainting().orElse(Collections.EMPTY_LIST);
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String admin_painting_add(HttpServletRequest request, Model model){

        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if(csrfToken != null){
            model.addAttribute("_csrf", csrfToken);
        }

        model.addAttribute("painting", new Painting() );

        return "admin/painting.add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String admin_painting_add_submit(@RequestParam(value = "error", required = false) String error,
                                            @Valid @ModelAttribute PaintingCreatedForm paintingCreatedForm,
                                            Model model){
        if(!StringUtils.isEmpty(error)){
            model.addAttribute("error",error);
        }else{
                storageService.store(paintingCreatedForm.getFile());
                paintingService.createPainting(paintingCreatedForm);
        }


        return "redirect:/painting/add/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String admin_painting_edit(){
        return "admin/painting.edit";
    }

    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String admin_painting_delete(){
        return "admin/painting.delete";
    }


    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exec){
        return ResponseEntity.notFound().build();
    }
    //{id}



}
