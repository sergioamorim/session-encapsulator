/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.services.webservice;

import br.com.tpartner.persistence.model.Badge;
import br.com.tpartner.persistence.model.Student;
import br.com.tpartner.services.facade.BadgeFacade;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sergio
 */
@Controller
@RequestMapping("/badge")
public class BadgeWebService {
    @Autowired
    private BadgeFacade badgeFacade;
    public String serviceType = "Badge Service";
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Serializable> save(@RequestBody 
            Badge badge) {
        
        Badge a;
        a = this.badgeFacade.save(badge);
        
        return new ResponseEntity<Serializable>(a, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Serializable> update(@RequestBody
            Badge badge) {
        
        Badge a;
        a = this.badgeFacade.update(badge);
        
        return new ResponseEntity<Serializable>(a, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Serializable> delete(@RequestParam(
            value = "id", required = true) Integer id) {
        
        this.badgeFacade.delete(this.badgeFacade.
                findById(id));
        
        return new ResponseEntity<Serializable>(serviceType+
                ": Badge deleted",HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Serializable> findById(
            @RequestParam(value = "id", required = true) Integer id) {
        Badge a = this.badgeFacade.findById(id);
        return new ResponseEntity<Serializable>(a,HttpStatus.OK);
    }    
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Badge> findAll() {
        return this.badgeFacade.findAll();
    }
    
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public @ResponseBody List<Badge> findByStudent(
            @RequestBody Student student) {
        
        return this.badgeFacade.findByStudent(student);
        
    }
    
    @RequestMapping(value = "/badge_id", method = RequestMethod.GET)
    public @ResponseBody List<Badge> findByBadgeId(
            @RequestParam(value = "badge_id", required = true) String badgeId) {
        
        return this.badgeFacade.findByBadgeId(badgeId);
        
    }
}
