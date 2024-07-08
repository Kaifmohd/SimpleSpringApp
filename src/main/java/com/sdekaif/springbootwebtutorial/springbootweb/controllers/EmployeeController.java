package com.sdekaif.springbootwebtutorial.springbootweb.controllers;

import com.sdekaif.springbootwebtutorial.springbootweb.dto.EmployeeDTO;
import com.sdekaif.springbootwebtutorial.springbootweb.entities.EmployeeEntity;
import com.sdekaif.springbootwebtutorial.springbootweb.exceptions.ResourceNotFoundException;
import com.sdekaif.springbootwebtutorial.springbootweb.repositories.EmployeeRepository;
import com.sdekaif.springbootwebtutorial.springbootweb.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    @GetMapping(path="/getSecretMessage")
//    public String getMyMessage(){
//        return "Secret Message: 92191$$@Mmdwsa";
//    }
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }



    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable  Long employeeId){
        //return new EmployeeDTO(employeeId,"Mohammed Kaif","test@gmail.com",24, LocalDate.of(2024,1,2),true);
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeId);
//        if(employeeDTO==null)   return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeeDTO);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id: "+employeeId));
    }




    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age,
                                   @RequestParam(required = false) String sortBy){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
       EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeDTO));
    }
    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted)
            return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                 @PathVariable Long employeeId){

        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId,updates);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
