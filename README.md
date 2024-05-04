# API Testing Menggunakan Postman & Rest Assured Kelompok A8
## Description

Implementasi pengujian API menggunakan tools seperti Postman dan Rest Assured. API Testing merupakan komponen penting dalam siklus pengembangan perangkat lunak, memastikan fungsionalitas dari endpoint-endpoint yang disediakan oleh Program. Software under test yang digunakan adalah Program User Controller pada tautan https://dummyapi.io/docs/user untuk menguji API: Get User by id, Create User, Update User dan Delete User

## Member

- 211524004 | Berliana Elfada [@berlianalfd](https://github.com/berlianalfd)
- 211524005 | Cintia Ningsih [@cintianingsih](https://github.com/cintianingsih)
- 211524029 | Yane Pradita [@yanepradita](https://github.com/yanepradita)

## Prerequisites

Postman harus terinstall di komputer pengguna.

## Testing Tools

- IDE : visual studio code
- Alat build otomatis : Apache Maven
- Tools buat runing : Terminal
- Sistem operasi : Window
- Framework testing : JUnit
- Library automation testing : Rest Assured
- Bahasa pemrograman : Java

## Struktur File Program 
Berikut merupakan struktur file dari scripting test yang kami buat

## Test the program

Berikut merupakan perintah yang dapat di gunakan untuk melakukan automation testing pada terminal.
1. Perintah dibawah digunakan untuk menguji semua class sekaligus

   ```sh
   mvn test
   ```

2. Perintah dibawah digunakan untuk menguji semua method test yang terdapat pada satu class test secara sekaligus.

    - Perintah untuk menguji semua method test pada **class CreateUserTest**

     ```sh
     mvn -Dtest=CreateUserTest test
     ```
     
    - Perintah untuk menguji semua method test pada **class GetUserTest**

     ```sh
     mvn -Dtest=GetUserTest test
     ```

    - Perintah untuk menguji semua method test pada **class UpdateUserTest**

     ```sh
     mvn -Dtest=UpdateUserTest test
     ```

    - Perintah untuk menguji semua method test pada **class DeleteUserTest**

     ```sh
     mvn -Dtest=DeleteUserTest test
     ```

## Generate report by tools

Berikut merupakan generate report yang dilakukan dengan menggunakan **Plugin Surefire Report** dalam Maven. Dimana, plugin tersebut dapat digunakan untuk menghasilkan laporan hasil eksekusi tes unit Anda dalam format HTML 

1. Berikut merupakan perintah untuk generate report menggunakan maven

   ```sh
   mvn surefire-report:report 
   ```
2. Sehingga hasil dari generate report tersebut akan membuat folder site didalam folder target

3. Untuk melihat hasilnya buka file surefire-report.html pada browser

     

