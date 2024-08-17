package com.seleksi_msib.sei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seleksi_msib.sei.model.Proyek;
import com.seleksi_msib.sei.response.ApiResponse;
import com.seleksi_msib.sei.service.ProyekService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/proyek")
@Tag(name = "Proyek", description = "Operasi yang berkaitan dengan proyek")
public class ProyekController {
    @Autowired
    private ProyekService proyekService;

    @Operation(summary = "Menambahkan data proyek termasuk Lokasi proyek")
    @PostMapping
    public ResponseEntity<ApiResponse> createProyek(@RequestBody Proyek proyek, @RequestParam List<Long> lokasiIds) {
        try{
            Proyek newProyek = proyekService.addProyek(proyek, lokasiIds);
            ApiResponse response = new ApiResponse(newProyek, "Create proyek successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e){
            ApiResponse response = new ApiResponse("Invalid", "Create proyek successful");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @Operation(summary = "Menampilkan semua data proyek termasuk lokasinya")
    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek() {
        List<Proyek> proyekList = proyekService.getAllProyek();
        return ResponseEntity.ok(proyekList);
    }

    @Operation(summary = "Update atau edit data proyek")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProyek(@PathVariable Long id, @RequestBody Proyek proyek, @RequestParam List<Long> lokasiIds) {
        ApiResponse response = new ApiResponse("","");
        try{
            Proyek updatedProyek = proyekService.updateProyek(id, proyek, lokasiIds);
            if (updatedProyek != null) {
                response.setData(updatedProyek);
                response.setMessage("Update proyek successful");
                return ResponseEntity.ok(response);
            } else {
                response.setData("Invalid");
                response.setMessage("Update proyek failed");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e){
            response.setData("Invalid");
            response.setMessage("Update proyek failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @Operation(summary = "Menghapus data proyek")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProyek(@PathVariable Long id) {
        boolean isDeleted = proyekService.deleteProyek(id);
        if(isDeleted){
            ApiResponse response = new ApiResponse("Valid", "Delete proyek successful");
            return ResponseEntity.ok(response);
        }
        else{
            ApiResponse response = new ApiResponse("Invalid", "Delete proyek failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

