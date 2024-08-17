# Proyek API Spesification

## Create Proyek

Endpoint: POST /proyek

Request Body :

```json
{
  "namaProyek": "Proyek Pembangunan IKN",
  "client": "Jokowi Dodo",
  "tglMulai": "2022-8-17",
  "tglSelesai": "2025-8-17",
  "pimpinanProyek": "Mochamad Basuki Hadimuljono",
  "keterangan": "Proyek pemindahan ibu kota negara dari wilayah Jakarta ke Kalimantan Timur",
  "lokasi": {
    "id": 2,
    "namaLokasi": "Daerah Kawasan IKN",
    "negara": "Indonesia",
    "provinsi": "Kalimantan Timur",
    "kota": "IKN",
    "createAt": "2024-08-17T02:21:19.953+07:00"
  }
}
```

Response Body (Success):

```json
{
  "data": {
    "namaProyek": "Proyek Pembangunan IKN",
    "client": "Jokowi Dodo",
    "tglMulai": "2022-8-17",
    "tglSelesai": "2025-8-17",
    "pimpinanProyek": "Mochamad Basuki Hadimuljono",
    "keterangan": "Proyek pemindahan ibu kota negara dari wilayah Jakarta ke Kalimantan Timur",
    "lokasi": {
      "id": 2,
      "namaLokasi": "Daerah Kawasan IKN",
      "negara": "Indonesia",
      "provinsi": "Kalimantan Timur",
      "kota": "IKN",
      "createAt": "2024-08-17T02:21:19.953+07:00"
    }
  },
  "message": "Create proyek successful"
}
```

Response Body (Failed):

```json
{
  "data": "Invalid",
  "message": "Create proyek failed"
}
```

## Get Proyek

Endpoint: Get /proyek

Response Body :

```json
[
  {
    "namaProyek": "Proyek Pembangunan IKN",
    "client": "Jokowi Dodo",
    "tglMulai": "2022-8-17",
    "tglSelesai": "2025-8-17",
    "pimpinanProyek": "Mochamad Basuki Hadimuljono",
    "keterangan": "Proyek pemindahan ibu kota negara dari wilayah Jakarta ke Kalimantan Timur",
    "lokasi": {
      "id": 2,
      "namaLokasi": "Daerah Kawasan IKN",
      "negara": "Indonesia",
      "provinsi": "Kalimantan Timur",
      "kota": "IKN",
      "createAt": "2024-08-17T02:21:19.953+07:00"
    },
    "createAt": "2024-08-17T03:23:20.953+07:00"
  }
]
```

## Put Proyek

Endpoint: Put /proyek/{id}

Request Body :

```json
{
  "namaProyek": "Proyek Pembangunan IKN Fase 2",
  "client": "Jokowi Dodo",
  "tglMulai": "2022-8-17",
  "tglSelesai": "2028-8-17",
  "pimpinanProyek": "Mochamad Basuki Hadimuljono",
  "keterangan": "Proyek pemindahan ibu kota negara dari wilayah Jakarta ke Kalimantan Timur",
  "lokasi": {
    "id": 2,
    "namaLokasi": "Daerah Kawasan IKN",
    "negara": "Indonesia",
    "provinsi": "Kalimantan Timur",
    "kota": "IKN",
    "createAt": "2024-08-17T02:21:19.953+07:00"
  }
}
```

Response Body (Success):

```json
{
  "data": {
    "namaProyek": "Proyek Pembangunan IKN Fase 2",
    "client": "Jokowi Dodo",
    "tglMulai": "2022-8-17",
    "tglSelesai": "2028-8-17",
    "pimpinanProyek": "Mochamad Basuki Hadimuljono",
    "keterangan": "Proyek pemindahan ibu kota negara dari wilayah Jakarta ke Kalimantan Timur",
    "lokasi": {
      "id": 2,
      "namaLokasi": "Daerah Kawasan IKN",
      "negara": "Indonesia",
      "provinsi": "Kalimantan Timur",
      "kota": "IKN",
      "createAt": "2024-08-17T02:21:19.953+07:00"
    }
  },
  "message": "Update proyek successful"
}
```

Response Body (Failed):

```json
{
  "data": "Invalid",
  "message": "Update proyek failed"
}
```

## Delete Proyek

Endpoint : Delete /proyek/{id}

Response Body (Success):

```json
{
  "data": "Valid",
  "message": "Delete proyek successful"
}
```

Response Body (Failed):

```json
{
  "data": "Invalid",
  "message": "Delete proyek failed"
}
```
