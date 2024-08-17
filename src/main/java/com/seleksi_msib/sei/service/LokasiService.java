package com.seleksi_msib.sei.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleksi_msib.sei.model.Lokasi;
import com.seleksi_msib.sei.repository.LokasiRepository;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    public Lokasi addLokasi(Lokasi lokasi) {
        lokasi.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return lokasiRepository.save(lokasi);
    }

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Lokasi updateLokasi(Long id, Lokasi lokasi) {
        try{
            Lokasi existingLokasi = lokasiRepository.findById(id).orElseThrow(() -> new RuntimeException("Lokasi tidak ditemukan!"));
            existingLokasi.setNamaLokasi(lokasi.getNamaLokasi());
            existingLokasi.setNegara(lokasi.getNegara());
            existingLokasi.setProvinsi(lokasi.getProvinsi());
            existingLokasi.setKota(lokasi.getKota());
            existingLokasi.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            return lokasiRepository.save(existingLokasi);
        } catch(Exception e){
            return null;
        }
    }

    public boolean deleteLokasi(Long id) {
        try{
            if (lokasiRepository.existsById(id)){
                lokasiRepository.deleteById(id);
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
}

