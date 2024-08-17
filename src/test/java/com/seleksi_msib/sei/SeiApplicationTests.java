package com.seleksi_msib.sei;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.seleksi_msib.sei.model.Lokasi;
import com.seleksi_msib.sei.service.LokasiService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SeleksiApplicationTests {

	@Autowired
	private LokasiService lokasiService;

	@Test
	void contextLoads() {
	}

	@Test
	void testAddAndGetLokasi() {
		// Membuat Lokasi baru
		Lokasi lokasi = new Lokasi();
		lokasi.setNamaLokasi("Jakarta");
		lokasi.setNegara("Indonesia");
		lokasi.setProvinsi("DKI Jakarta");
		lokasi.setKota("Jakarta Pusat");

		// Menyimpan lokasi
		Lokasi savedLokasi = lokasiService.addLokasi(lokasi);

		// Pastikan lokasi disimpan dengan ID yang tidak null
		assertNotNull(savedLokasi.getId());

		// Mengambil semua lokasi
		List<Lokasi> lokasiList = lokasiService.getAllLokasi();

		// Pastikan lokasiList tidak null dan mengandung setidaknya satu lokasi
		assertNotNull(lokasiList);
		assertTrue(lokasiList.size() > 0);

		// Mengecek apakah lokasi yang baru saja disimpan ada dalam daftar
		boolean exists = lokasiList.stream()
				.anyMatch(l -> l.getId().equals(savedLokasi.getId()));

		assertTrue(exists);
	}

	@Test
	void testUpdateLokasi() {
		// Membuat Lokasi baru
		Lokasi lokasi = new Lokasi();
		lokasi.setNamaLokasi("Bandung");
		lokasi.setNegara("Indonesia");
		lokasi.setProvinsi("Jawa Barat");
		lokasi.setKota("Bandung");

		// Menyimpan lokasi
		Lokasi savedLokasi = lokasiService.addLokasi(lokasi);

		// Update nama lokasi
		savedLokasi.setNamaLokasi("Bandung Barat");
		Lokasi updatedLokasi = lokasiService.updateLokasi(savedLokasi.getId(), savedLokasi);

		// Mengecek apakah namaLokasi telah ter-update
		assertEquals("Bandung Barat", updatedLokasi.getNamaLokasi());
	}

	@Test
	void testDeleteLokasi() {
		// Membuat Lokasi baru
		Lokasi lokasi = new Lokasi();
		lokasi.setNamaLokasi("Surabaya");
		lokasi.setNegara("Indonesia");
		lokasi.setProvinsi("Jawa Timur");
		lokasi.setKota("Surabaya");

		// Menyimpan lokasi
		Lokasi savedLokasi = lokasiService.addLokasi(lokasi);

		// Menghapus lokasi
		lokasiService.deleteLokasi(savedLokasi.getId());

		// Mengambil semua lokasi dan memastikan lokasi yang dihapus tidak ada lagi
		List<Lokasi> lokasiList = lokasiService.getAllLokasi();

		boolean exists = lokasiList.stream()
				.anyMatch(l -> l.getId().equals(savedLokasi.getId()));

		assertTrue(!exists);
	}
}
