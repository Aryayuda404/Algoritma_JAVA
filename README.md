Flowchart Diagram :
=> ![BRILIam drawio](https://github.com/user-attachments/assets/5548633c-ed78-44af-ade4-8a58bb4414db)


Program yang saya buat adalah program Aplikasi Warehouse Management System dengan nama aplikasi yaitu BRILIam WMS (BRILIam), yang berfungsi sebagai aplikasi management barang di gudang.

Aplikasi BRILIam menyediakan fitur login dan registrasi, yang berfungsi sebagai akses masuk user sebelum memasuki program.
1. Login :
![Screenshot 2025-02-09 210801](https://github.com/user-attachments/assets/2d097183-36be-459b-a416-9545561ad20e)
2. registrasi :
![Screenshot 2025-02-09 210946](https://github.com/user-attachments/assets/9df3841e-2898-41db-b887-f49b0b49c45a)


Fitur - fitur di dalam Aplikasi BRILIam
![Screenshot 2025-02-09 211443](https://github.com/user-attachments/assets/cafdfc2d-64e2-4bb5-953e-fe1ce143ca65)


Didalam Aplikasi BRILIam terdapat beberapa menu antaranya lain menu Inbound, Outbound, Inbound List, Outbound List, Stock Report, Adjustment Stock, Search Product, dan Other Menu.

Menu Inbound :
Menu Inbound berfungsi sebagai pendataan product baru yang masuk, dengan kondisi tertentu.
1. Kondisi pertama dimana code product sudah tersedia maka hanya akan menambahkan qty nya saja.
   => ![Screenshot 2025-02-09 211730](https://github.com/user-attachments/assets/ff6dfb4f-7fcb-4432-9844-4d2adfb182fc)
3. Kondisi kedua dimana code product tidak tersedia (tidak ada), maka akan mengisi data baru, dengan data yang di isi antara lain, code product, nama product, qty product, dan harga product.
   => ![Screenshot 2025-02-09 211849](https://github.com/user-attachments/assets/83e1d183-92ba-4539-afc1-03f0a50e5bba)

Menu Outbound :
Menu Outbound berfungsi sebagai pengurangan qty product dengan memamasukan code yang telah terdaftar atau tersedia.
=> ![Screenshot 2025-02-09 212035](https://github.com/user-attachments/assets/93d10c8e-5c58-423b-af52-d5963271bf45)

Menu Inbound List :
Menu Inbound List berfungsi sebagai menampilkan data barang apa saja yang telah masuk (di input).
=> ![Screenshot 2025-02-09 212207](https://github.com/user-attachments/assets/e49791fd-5237-4341-9ba0-2bfaaff1a083)

Menu Outbound List :
Menu Outbound List berfungsi sebagai menampilkan data outbound dan qty yang di kurangi pada seluruh barang yang telah keluar.
=> ![Screenshot 2025-02-09 212252](https://github.com/user-attachments/assets/cad177df-f068-4a2d-a447-92470e9949ea)

Menu Stock Report :
Menu Stock Report berfungsi sebagai menampilkan data keseluruhan product yang tersedia dengan data yang telah sinkron terhadap inbound dan outbound.
=> ![Screenshot 2025-02-09 212331](https://github.com/user-attachments/assets/d592b38e-80a6-47e7-b961-79b487b8284a)

Menu Adjustment Stock (Menu Super User) :
Menu Adjustment Stock berfungsi sebagai fitur edit Available Stock (stok keseluruhan), dengan akses mengubah keseluruhan detail product (mengubah code, nama, qty, harga).
Tetapi data yang dirubah di adjustment, perubahannya tidak tersimpan (tidak ada rekap data).
=> ![Screenshot 2025-02-09 213021](https://github.com/user-attachments/assets/31dbf0fa-8b51-4385-974d-185cc84356dd)

Menu Search Product :
Menu Search Product berfungsi sebagai pencarian data barang yang tersedia berdasarkan code product.
=> ![Screenshot 2025-02-09 213400](https://github.com/user-attachments/assets/968aa063-34a4-49d4-ad4c-200579d88d6f)

Menu Other Menu :
Menu Other Menu terdapat 2 pilihan antaranya ;
1. Menu Sorting
   Di menu sorting terdapat 3 pilihan sorting yang user inginkan antarnya sorting by code, qty, price (harga).
   => By Code : ![Screenshot 2025-02-09 213935](https://github.com/user-attachments/assets/18c16ac8-0f39-4aa4-8ab8-e022f3a05152)
   => By Qty : ![Screenshot 2025-02-09 214028](https://github.com/user-attachments/assets/ea7dcdc2-23c2-4d55-87bf-0d9b56c30827)
   => By Price (harga) : ![Screenshot 2025-02-09 214112](https://github.com/user-attachments/assets/0057f2c2-9a00-46de-8896-36f3510c3e8c)
3. Menu Searching
   Di menu searching ini menggunakan metode binary search dengan syarat data harus terurut, maka sebelum melakukan searching data menggunakan metode binary serach
   sebelumnya data harus di sorting terlebih dahulu.
   => ![Screenshot 2025-02-09 214210](https://github.com/user-attachments/assets/162bfedf-b71c-4502-99f1-b01990e7606b)








   

