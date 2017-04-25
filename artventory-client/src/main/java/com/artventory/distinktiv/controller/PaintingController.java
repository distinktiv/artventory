package com.artventory.distinktiv.controller;

import com.artventory.distinktiv.domain.Painting;
import com.artventory.distinktiv.domain.User;
import com.artventory.distinktiv.service.InventoryService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by distinktiv on 2016-12-27.
 */

@Controller
@RequestMapping(value = "/painting")
public class PaintingController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String admin_painting_list(Model model,
                              HttpServletRequest request){

       /*
        List<Painting> allPainting = inventoryService.getPaintingFromArtist();
        //paintingService.getAllPainting().get();
        model.addAttribute("isPresent", paintingService.getAllPainting().isPresent());
        model.addAttribute("paintingsSize", paintingService.getAllPainting().get().size());
        model.addAttribute("paintings", allPainting);*/

        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Painting> allPainting = inventoryService.getPaintingFromArtist(user.getId().toString());
        model.addAttribute("userEmail",user.getEmail());
        model.addAttribute("paintings", allPainting);
        return "admin/painting.list";

    }

    @RequestMapping(method = RequestMethod.GET)
    public String admin_painting_add(HttpServletRequest request, Model model){

        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if(csrfToken != null){
            model.addAttribute("_csrf", csrfToken);
        }

        model.addAttribute("painting", new Painting() );

        return "admin/painting.add";
    }

    @RequestMapping(method = RequestMethod.POST)
        public String admin_painting_add_submit(@RequestParam(value = "error", required = false) String error,
                                                @RequestParam("file") MultipartFile file,
                                                @ModelAttribute Painting painting,
                                                Model model){
        if(!StringUtils.isEmpty(error)){
            model.addAttribute("error",error);
        }else{
            File convertedFile = new File(file.getOriginalFilename());
            try {
                file.transferTo(convertedFile);
                inventoryService.createPainting(convertedFile,painting);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return "redirect:/painting/list/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String admin_painting_edit(@PathVariable("id") Integer id, Model model){
        Painting painting = inventoryService.getPaintingById(id.toString());
        model.addAttribute("painting", painting);
        return "admin/painting.edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String admin_painting_edit_post(@RequestParam(value = "error", required = false) String error,
                                           @ModelAttribute Painting painting,
                                           Model model){
        System.out.println("SUBMIT IT!!!!!!!!!!!!!!!!");
        return "redirect:/painting/list/";
    }

    /*
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
*/


}
