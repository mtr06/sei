# Lokasi API Spesification

## Create Lokasi

Endpoint: POST /lokasi

Request Body :

```json
{
  "namaLokasi": "Daerah Kawasan IKN",
  "negara": "Indonesia",
  "provinsi": "Kalimantan Timur",
  "kota": "IKN"
}
```

Response Body (Success):

```json
{
  "data": {
    "namaLokasi": "Daerah Kawasan IKN",
    "negara": "Indonesia",
    "provinsi": "Kalimantan Timur",
    "kota": "IKN"
  },
  "message": "Create lokasi successful"
}
```

Response Body (Failed):

```json
{
  "data": "Invalid",
  "message": "Create lokasi failed"
}
```

## Get Lokasi

Endpoint: Get /lokasi

Response Body :

```json
[
  {
    "id": 1,
    "namaLokasi": "Daerah Perumahan Villano",
    "negara": "Indonesia",
    "provinsi": "Jawa Barat",
    "kota": "Bandung",
    "createAt": "2024-08-17T02:15:22.953+07:00"
  },
  {
    "id": 2,
    "namaLokasi": "Daerah Kawasan IKN",
    "negara": "Indonesia",
    "provinsi": "Kalimantan Timur",
    "kota": "IKN",
    "createAt": "2024-08-17T02:21:19.953+07:00"
  }
]
```

## Put Lokasi

Endpoint: Put /lokasi/{id}

Request Body :

```json
{
  "namaLokasi": "Daerah Perumahan Villano Terbaru",
  "negara": "Indonesia",
  "provinsi": "Jawa Barat",
  "kota": "Depok"
}
```

Response Body (Success):

```json
{
  "data": {
    "namaLokasi": "Daerah Perumahan Villano Terbaru",
    "negara": "Indonesia",
    "provinsi": "Jawa Barat",
    "kota": "Depok"
  },
  "message": "Update lokasi successful"
}
```

Response Body (Failed):

```json
{
  "data": "Invalid",
  "message": "Update lokasi failed"
}
```

## Delete Lokasi

Endpoint : Delete /lokasi/{id}

Response Body (Success):

```json
{
  "data": "Valid",
  "message": "Delete lokasi successful"
}
```

Response Body (Failed):

```json
{
  "data": "Invalid",
  "message": "Delete lokasi failed"
}
```
