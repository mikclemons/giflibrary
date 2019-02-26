package com.detroitlabs.giflibrary.Controller;

import com.detroitlabs.giflibrary.data.GifRepository;
import com.detroitlabs.giflibrary.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String displayGifs(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("allGifs", allGifs);
        return "home";
    }

    @RequestMapping(value = "/" ,params = "q")
    public String displaySearchResults(@RequestParam("q") String searchTerm, ModelMap modelMap){
        List<Gif> searchResults = gifRepository.findBySearch(searchTerm);
        modelMap.put("searchresults", searchResults);
        return "searchresults";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }
   @RequestMapping("/favorites")
    public String displayFavorites(ModelMap modelMap){
        List<Gif> allFavorites = Arrays.asList(gifRepository.findFavorite(true));
        modelMap.put("favorites", allFavorites);
        return "favorites";
   }



}
