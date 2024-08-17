package com.seleksi_msib.sei.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleksi_msib.sei.model.Lokasi;
import com.seleksi_msib.sei.model.Proyek;
import com.seleksi_msib.sei.repository.LokasiRepository;
import com.seleksi_msib.sei.repository.ProyekRepository;

@Service
public class ProyekService {
    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    public Proyek addProyek(Proyek proyek, List<Long> lokasiIds) {
        proyek.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        List<Lokasi> lokasiList = lokasiRepository.findAllById(lokasiIds);
        proyek.setLokasiList(lokasiList);
        return proyekRepository.save(proyek);
    }

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Proyek updateProyek(Long id, Proyek proyek, List<Long> lokasiIds) {
        try{
            Proyek existingProyek = proyekRepository.findById(id).orElseThrow(() -> new RuntimeException("Proyek not found"));
            existingProyek.setNamaProyek(proyek.getNamaProyek());
            existingProyek.setClient(proyek.getClient());
            existingProyek.setTglMulai(proyek.getTglMulai());
            existingProyek.setTglSelesai(proyek.getTglSelesai());
            existingProyek.setPimpinanProyek(proyek.getPimpinanProyek());
            existingProyek.setKeterangan(proyek.getKeterangan());
            List<Lokasi> lokasiList = lokasiRepository.findAllById(lokasiIds);
            existingProyek.setLokasiList(lokasiList);
            existingProyek.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            return proyekRepository.save(existingProyek);
        } catch(Exception e){
            return null;
        }
    }

    public boolean deleteProyek(Long id) {
        try{
            if (proyekRepository.existsById(id)){
                proyekRepository.deleteById(id);
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
