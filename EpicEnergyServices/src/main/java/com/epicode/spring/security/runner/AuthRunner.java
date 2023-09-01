package com.epicode.spring.security.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicode.spring.security.entity.Cliente;
import com.epicode.spring.security.entity.Comune;
import com.epicode.spring.security.entity.ERole;
import com.epicode.spring.security.entity.Indirizzo;
import com.epicode.spring.security.entity.Provincia;
import com.epicode.spring.security.entity.Role;
import com.epicode.spring.security.enums.TipoCliente;
import com.epicode.spring.security.enums.TipoIndirizzo;
import com.epicode.spring.security.payload.RegisterDto;
import com.epicode.spring.security.repository.RoleRepository;
import com.epicode.spring.security.repository.UserRepository;
import com.epicode.spring.security.service.AuthService;
import com.epicode.spring.security.service.ClienteService;
import com.epicode.spring.security.service.ComuneService;
import com.epicode.spring.security.service.ProvinciaService;
import com.github.javafaker.Faker;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.ZoneId;



@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	@Autowired ProvinciaService provService;
	@Autowired ComuneService comuneService;
	@Autowired ClienteService clienteService;
	
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
//		setRoleDefault();
//		
//		String comuni = "dati/comuni-italiani.csv";
//		String province = "dati/province-italiane.csv";
//		
//        try {
//            Resource provinceResource = new ClassPathResource(province);
//            Reader provinceReader = new InputStreamReader(provinceResource.getInputStream());
//            CSVParser provinceCsvParser = new CSVParser(provinceReader, CSVFormat.DEFAULT);
//            
//            Resource comuniResource = new ClassPathResource(comuni);
//            Reader comuniReader = new InputStreamReader(comuniResource.getInputStream());
//            CSVParser comuniCsvParser = new CSVParser(comuniReader, CSVFormat.DEFAULT);
//
//            for (CSVRecord csvRecord : provinceCsvParser) {
//                String column1 = csvRecord.get(0);
//                String[] prop=column1.split(";");
//                provService.crea(new Provincia(prop[0], prop[1], prop[2]));
//            }
//            
//            for (CSVRecord csvRecord : comuniCsvParser) {
//                String column1 = csvRecord.get(0);
//                String[] prop=column1.split(";");
//                comuneService.crea(new Comune(prop[2], provService.getByNome(prop[3])));
//            }
//
//            provinceCsvParser.close();
//            comuniCsvParser.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//		
//		Faker faker = new Faker();
//		
//		for(int i=0; i<100; i++) {
//			try {
//				Cliente yourEntity = new Cliente();
//				yourEntity.setRagioneSociale(faker.company().name());
//				yourEntity.setPartitaIva(faker.number().digits(11));
//				yourEntity.setDataInserimento(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//				yourEntity.setDataUltimoContatto(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//				yourEntity.setFatturatoAnnuale(faker.number().randomDouble(2, 10000, 1000000));
//				yourEntity.setTelefono(String.valueOf(faker.number().numberBetween(100000000, 999999999)));
//				yourEntity.setNomeContatto(faker.name().firstName());
//				yourEntity.setCognomeContatto(faker.name().lastName());
//				yourEntity.setTelefonoContatto(String.valueOf(faker.number().numberBetween(100000000, 999999999)));
//				yourEntity.setTipoCliente(TipoCliente.values()[faker.random().nextInt(TipoCliente.values().length)]);
//				
//				yourEntity.setEmail(faker.name().firstName().toLowerCase()+faker.name().lastName().toLowerCase()+"@gmail.com");
//				yourEntity.setEmailContatto(faker.name().firstName().toLowerCase()+faker.name().lastName().toLowerCase()+"@gmail.com");
//				yourEntity.setPec(faker.name().firstName().toLowerCase()+faker.name().lastName().toLowerCase()+"@gmail.com");
//
//				Indirizzo indirizzo = new Indirizzo();
//			    indirizzo.setVia(faker.address().streetAddress());
//			    indirizzo.setCap(String.valueOf(faker.number().numberBetween(10000, 99999)));
//			    indirizzo.setCivico(faker.number().numberBetween(1, 3000));
//			    indirizzo.setTipoIndirizzo(TipoIndirizzo.values()[faker.random().nextInt(TipoIndirizzo.values().length)]);
//			    indirizzo.setLocalita(faker.country().capital());
//			    indirizzo.setComune(comuneService.getById(faker.number().numberBetween(1, 2424)));
//			    Set<Indirizzo> indirizzi=new HashSet<Indirizzo>();
//			    indirizzi.add(indirizzo);
//			    yourEntity.setIndirizzoSedi(indirizzi);
//			    
//				clienteService.crea(yourEntity);
//			}
//			
//			catch(Exception e) {
//				
//			}
//		}
    }
	
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);
		
		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);
		
		moderatorRole = new HashSet<Role>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);
		
		userRole = new HashSet<Role>();
		userRole.add(user);
	}

}
