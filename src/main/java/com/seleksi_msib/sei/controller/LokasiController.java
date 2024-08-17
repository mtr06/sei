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
import org.springframework.web.bind.annotation.RestController;

import com.seleksi_msib.sei.model.Lokasi;
import com.seleksi_msib.sei.response.ApiResponse;
import com.seleksi_msib.sei.service.LokasiService;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {
    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public ResponseEntity<ApiResponse> createLokasi(@RequestBody Lokasi lokasi) {
        try{
            Lokasi newLokasi = lokasiService.addLokasi(lokasi);
            ApiResponse response = new ApiResponse(newLokasi, "Create lokasi successful");
            return ResponseEntity.ok(response);
        } catch (Exception e){
            ApiResponse response = new ApiResponse("Invalid", "Create lokasi successful");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<List<Lokasi>> getAllLokasi() {
        List<Lokasi> lokasiList = lokasiService.getAllLokasi();
        return ResponseEntity.ok(lokasiList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasi) {
        ApiResponse response = new ApiResponse("","");
        try{
            Lokasi updatedLokasi = lokasiService.updateLokasi(id, lokasi);
            if (updatedLokasi != null) {
                response.setData(updatedLokasi);
                response.setMessage("Update lokasi successful");
                return ResponseEntity.ok(response);
            } else {
                response.setData("Invalid");
                response.setMessage("Update lokasi failed");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e){
            response.setData("Invalid");
            response.setMessage("Update lokasi failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteLokasi(@PathVariable Long id) {
        boolean isDeleted = lokasiService.deleteLokasi(id);
        if(isDeleted){
            ApiResponse response = new ApiResponse("Valid", "Delete lokasi successful");
            return ResponseEntity.ok(response);
        }
        else{
            ApiResponse response = new ApiResponse("Invalid", "Delete lokasi failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
