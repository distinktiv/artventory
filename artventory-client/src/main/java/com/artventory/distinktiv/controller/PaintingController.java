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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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

       /* List<Painting> allPainting = paintingService.getAllPainting().get();
        model.addAttribute("isPresent", paintingService.getAllPainting().isPresent());
        model.addAttribute("paintingsSize", paintingService.getAllPainting().get().size());
        model.addAttribute("paintings", allPainting);*/
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userEmail",user.getEmail());
        return "admin/painting.list";

    }

   @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public String calendar(){
        return "admin/calendar";
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
                                            @Valid @ModelAttribute Painting painting,
                                            Model model){
        if(!StringUtils.isEmpty(error)){
            model.addAttribute("error",error);
        }else{
                inventoryService.createPainting(painting);
                //paintingService.createPainting(painting);
        }


        return "redirect:/painting/add/";
    }

/*    @RequestMapping(value = "/edit", method = RequestMethod.GET)
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
*/


}
