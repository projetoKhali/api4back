package com.fatec.springapi4.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.springapi4.entity.user.ProfileType;
import com.fatec.springapi4.entity.user.Usr;
import com.fatec.springapi4.repository.UsrRepository;
import com.fatec.springapi4.service.IUsrService;


@RestController
@CrossOrigin
@RequestMapping(value = "/usr")
public class UsrController {

    @Autowired
    IUsrService iUsrService;

    @Autowired
    UsrRepository usrRepository;

    @GetMapping(value = "/list")
    public Page<Usr> listUsrs(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return usrRepository.findAll(PageRequest.of(page, size));
    }
    
    @GetMapping(value = "/find/{usr}")
    public Usr findById(@PathVariable("usr") Long id) {
        return iUsrService.findUsrById(id);
    }

    @GetMapping(value = "/filter")
    public Page<Usr> filterUsr(@RequestParam(value = "name", required = false)String name,
                                 @RequestParam(value = "login", required = false)String login,
                                 @RequestParam(value = "profileType", required = false) ProfileType profileType,
                                 Pageable pageable){
        if(name == null&&login == null&&profileType == null){
            return iUsrService.listUsrs(0, 10);
        }else {
            return iUsrService.filterUsr(name, login, profileType, pageable);
        }
    }

    @PostMapping
    public Usr saveAndUpdateUsr(@RequestBody Usr usr) {
        return iUsrService.saveAndUpdateUsr(usr);
    }

    @PatchMapping("/{id}")
    public Usr updateUsrField(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String fieldName = requestBody.get("fieldName");
        String value = requestBody.get("value");
        return iUsrService.updateUsrField(id, fieldName, value);
    }

    @DeleteMapping(value = "/{usrId}")
    public void delUsrById(@PathVariable("usrId") Long id) {
        iUsrService.delUsrById(id);
    }
    
}
