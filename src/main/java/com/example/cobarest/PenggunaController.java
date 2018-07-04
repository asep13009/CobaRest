package com.example.cobarest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Departemen;
import com.example.model.Karyawan;
import com.example.model.Pengguna;

@Controller
public class PenggunaController {
	@RequestMapping("/save")
	public ModelAndView registrasi(@ModelAttribute("Pengguna") Pengguna p) {
		return new ModelAndView("data","pengguna",p);
	}
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
//	=====================================================
public List <Departemen> ld = new  ArrayList<>();
    
    @RequestMapping("/departemen")
    public String masterDepartemen(ModelMap modelmap){
        modelmap.put("listDepartemen", ld);
        return "departemen";
    }
    
    @RequestMapping(value = "/insertdepartemen",method = RequestMethod.GET)
    public String formInsertDepartemen(){
        return "insertdepartemen";
    }
    
    @RequestMapping(value = "/insertdepartemen", method = RequestMethod.POST)
    public String prosesInsertDepartemen(@ModelAttribute("Departemen") Departemen d){
//        modelmap.put("departemen",d);
       
        ld.add(d);
       
        return "redirect:/departemen";
    }
    @RequestMapping(value = "/updatedepartemen",method = RequestMethod.GET)
    public ModelAndView formUpdateDepartemen(@RequestParam("id") long id){
        ModelAndView mav = new ModelAndView();
        int index = (int) (id-1);
        Departemen d = ld.get(index);
        mav.setViewName("updatedepartemen");
        mav.addObject("departemen",d);
        return mav;
    }
    
     @RequestMapping(value = "/updatedepartemen",method = RequestMethod.POST)
    public String prosesUpdateDepartemen(@ModelAttribute("Departemen") Departemen d){
        ld.get((int)d.getId()-1).setNamaDepartemen(d.getNamaDepartemen());
        return "redirect:/departemen";
    }
    
    @RequestMapping(value= "/hapusdepartemen")
    public String formDeleteDepartemen(@RequestParam("id") long id){
       ld.remove((int) id-1);
       return "redirect:/departemen";
    }
    
    
    
//    ===========================================
    public List <Karyawan> lk = new  ArrayList<>();
    
    @RequestMapping("/karyawan")
    public String masterKaryawan(ModelMap modelmap){
         modelmap.put("listKaryawan", lk);
         modelmap.put("listDepartemen", ld);
        return "karyawan";
    }
    
//    @RequestMapping(value = "/insertkaryawan", method = RequestMethod.GET)
//    public String formInsertKaryawan(ModelMap modelmap){
//        modelmap.put("listDepartemen", ld);
//        return "insertkaryawan";
//    }
    @RequestMapping(value = "/insertkaryawan", method = RequestMethod.GET)
    public ModelAndView formInsertKaryawan(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("insertkaryawan");
        mav.addObject("listdepartemen", ld);
        mav.addObject("karyawan", new Karyawan());
        return mav;
    }
    
    @RequestMapping(value = "/insertkaryawan2", method = RequestMethod.GET)
    public ModelAndView formInsertKaryawan2(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("insertkaryawan");
        mav.addObject("listdepartemen", ld);
        mav.addObject("karyawan", new Karyawan());
        return mav;
    }
 
    @RequestMapping(value = "/insertkaryawan", method = RequestMethod.POST)
    public String prosesInsertKaryawan(@ModelAttribute(value = "Karyawan") Karyawan k,@RequestParam("departemenid") long id){
        k.setDepartemen(ld.get((int) (id-1)));
        lk.add(k);
        return "redirect:/karyawan";
    }
     @RequestMapping(value = "/insertkaryawan2", method = RequestMethod.POST)
    public String prosesInsertKaryawan2(@ModelAttribute(value = "Karyawan") Karyawan k){
        lk.add(k);
        return "redirect:/karyawan";
    }
    
     @RequestMapping(value = "/updatekaryawan",method = RequestMethod.GET)
    public ModelAndView formUpdateKaryawan(@RequestParam("id") long id){
        ModelAndView mav = new ModelAndView();
        int index = (int) (id-1);
        Karyawan k = lk.get(index);
        mav.setViewName("updatekaryawan");
        mav.addObject("karyawan",k);
        mav.addObject("listdepartemen", ld);
        return mav;
    }
    @RequestMapping(value = "/updatekaryawan",method = RequestMethod.POST)
    public String prosesUpdateKaryawan(@ModelAttribute("Karyawan") Karyawan k,@RequestParam("departemenid") long id){
        k.setDepartemen(ld.get((int) (id-1)));
//        lk.get((int)k.getId()-1).setDepartemen(k.getDepartemen());
//        lk.get((int)k.getId()-1).setNamaKaryawan(k.getNamaKaryawan());
        Karyawan karyawan = lk.get((int) (k.getId()-1));
        karyawan.setDepartemen(k.getDepartemen());
        karyawan.setNamaKaryawan(k.getNamaKaryawan());
        
        return "redirect:/karyawan";
    }
    
    @RequestMapping(value= "/hapuskaryawan")
    public String formDeleteKaryawan(@RequestParam("id") long id){
       lk.remove((int) (id-1));
       return "redirect:/karyawan";
    }
}

