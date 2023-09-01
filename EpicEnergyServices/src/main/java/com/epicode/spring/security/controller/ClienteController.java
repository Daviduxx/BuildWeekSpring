package com.epicode.spring.security.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.security.entity.Cliente;
import com.epicode.spring.security.service.ClienteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/clienti")
public class ClienteController {
	@Autowired private ClienteService cs; 
	
	@PostMapping
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> crea(@RequestBody Cliente c) {
        return new ResponseEntity<Cliente>(cs.crea(c), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return new ResponseEntity<Cliente>(cs.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> modifica(@PathVariable long id, @RequestBody Cliente c) {
        return new ResponseEntity<Cliente>(cs.aggiorna(id, c), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> elimina(@PathVariable long id) {
        return new ResponseEntity<String>(cs.elimina(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete-multiple")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> eliminaMultiplo(@RequestBody Set<Long> ids) {
        for (long id : ids) cs.elimina(id);
        return new ResponseEntity<>("Clienti eliminati con successo", HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<Page<Cliente>> getAll(Pageable pageable) {
        // http://localhost:8080/clienti/?page=0&size=10&sort=age,ASC
        // ?page=0&size=10&sort=age,ASC -> sono i parametri che saranno contenuti nell'ogg di tipo Pageable
    	return new ResponseEntity<Page<Cliente>>(cs.getAllContactsPageable(pageable), HttpStatus.OK);
    }
}
