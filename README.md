# API Testing Menggunakan Postman & Rest Assured Kelompok A8
## Description

Implementasi pengujian API menggunakan tools seperti Postman dan Rest Assured. API Testing merupakan komponen penting dalam siklus pengembangan perangkat lunak, memastikan fungsionalitas dari endpoint-endpoint yang disediakan oleh Program. Software under test yang digunakan adalah Program User Controller pada tautan https://dummyapi.io/docs/user untuk menguji API: Get User by id, Create User, Update User dan Delete User

## Member

- 211524004 | Berliana Elfada [@berlianalfd](https://github.com/berlianalfd)
- 211524005 | Cintia Ningsih [@cintianingsih](https://github.com/cintianingsih)
- 211524029 | Yane Pradita [@yanepradita](https://github.com/yanepradita)

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

<img width="300" alt="contoh tampilan aplikasi" src="https://github.com/berlianalfd/APITesting/assets/97377702/ab51d889-7154-4882-a9bf-8665dcc83fc7">

1. **main**
   
   Folder main pada struktur program, biasanya digunakan untuk menyimpan semua file Java yang berisi sumber kode utama. Pada pengujian kali ini, folder main tidak diperlukan, namun foldernya akan tetap ada.
   
2. **test/java/API**

   Folder ini terdiri dari file test yang berisi script API testing dengan menggunakan library Rest Assured untuk request CREATE, UPDATE, DELETE, dan GET
   - **CreateUserTest.Java**

     Merupakan file yang berisi kelas Java yang digunakan untuk menguji fungsionalitas create data user pada dummyapi.io. Di dalamnya terdapat script pengujian untuk 
     menguji 5 test case.

   - **UpdateUserTest.Java**

     Merupakan file yang berisi kelas Java yang digunakan untuk menguji fungsionalitas update data user pada dummyapi.io. Di dalamnya terdapat script pengujian untuk 
     menguji 5 test case.
     
   - **GetUserTest.Java**

     Merupakan file yang berisi kelas Java yang digunakan untuk menguji fungsionalitas get data user pada dummyapi.io. Di dalamnya terdapat script pengujian untuk menguji 5 
     test case.
     
   - **DeleteUserTest.Java**

     Merupakan file yang berisi kelas Java yang digunakan untuk menguji fungsionalitas delete data user pada dummyapi.io. Di dalamnya terdapat script pengujian untuk 
     menguji 5 test case.

3. **target**

   Folder ini digunakan oleh sistem build Java untuk menyimpan file class yang dikompilasi dan artefak lain yang dihasilkan atau dibuat secara otomatis selama proses build.
   
4. **pom.xml**
   
    File ini adalah project object model (POM) untuk project Java Kami. Ini menentukan dependensi project pada library dan framework lain, serta pengaturan                 konfigurasi untuk proses build.
   
5. **README.md**
   
   File panduan ini berisi panduan singkat tentang program API Testing. File ini ditujukkan untuk memberikan informasi kepada pengguna atau kontributor potensial, tentang apa isi dari program APITesting, cara running test, dan bagaimana berkontribusi.

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
     
3. Perintah dibawah digunakan untuk menguji satu method test **spesifik** dari satu class test.
   
   - Berikut merupakan perintah untuk menguji method test spesifik yang terdapat pada class **CreateUserTest**

     ```sh
     mvn -Dtest=CreateUserTest#<Nama_Method_Test> test
     ```
     
     **Contohnya**
     
     Berikut merupakan perintah untuk menguji angka kurang dari range, yaitu **method testCreateUserMenggunakanEmailTerdaftar** 
     ```sh
     mvn -Dtest=CreateUserTest#testCreateUserMenggunakanEmailTerdaftar test
     ```

   - Berikut merupakan perintah untuk menguji method test spesifik yang terdapat pada class **DeleteUserTest**

     ```sh
     mvn -Dtest=DeleteUserTest#<Nama_Method_Test> test
     ```
     
     **Contohnya**
     
     Berikut merupakan perintah untuk menguji angka kurang dari range, yaitu **method tc3DeleteUserWithValidUserIdAndInvalidAppId** 
     ```sh
     mvn -Dtest=DeleteUserTest#tc3DeleteUserWithValidUserIdAndInvalidAppId test
     ```

   - Berikut merupakan perintah untuk menguji method test spesifik yang terdapat pada class **GetUserTest**

     ```sh
     mvn -Dtest=GetUserTest#<Nama_Method_Test> test
     ```
     
      **Contohnya**
     
     Berikut merupakan perintah untuk menguji angka kurang dari range, yaitu **method tc1GetUserDataWithoutAppIdAndValidUserId** 
     ```sh
     mvn -Dtest=GetUserTest#tc1GetUserDataWithoutAppIdAndValidUserId test
     ```
     
   - Berikut merupakan perintah untuk menguji method test spesifik yang terdapat pada class **UpdateUserTest**

     ```sh
     mvn -Dtest=UpdateUserTest#<Nama_Method_Test> test
     ```
     
      **Contohnya**
     
     Berikut merupakan perintah untuk menguji angka kurang dari range, yaitu **method UpdateSomeUserDataWithoutEmailDataWithRegisteredAppId** 
     ```sh
     mvn -Dtest=UpdateUserTest#UpdateSomeUserDataWithoutEmailDataWithRegisteredAppId test
     ```

## Generate report by tools

Berikut merupakan generate report yang dilakukan dengan menggunakan **Plugin Surefire Report** dalam Maven. Dimana, plugin tersebut dapat digunakan untuk menghasilkan laporan hasil eksekusi tes unit Anda dalam format HTML 

1. Berikut merupakan perintah untuk generate report menggunakan maven

   ```sh
   mvn surefire-report:report 
   ```
2. Sehingga hasil dari generate report tersebut akan membuat folder site didalam folder target
   
   <img width="275" alt="foldersite" src="https://github.com/berlianalfd/APITesting/assets/95121218/4c1b030b-a394-4fd5-9265-23ed19d8ad4d">


3. Untuk melihat hasilnya buka file surefire-report.html pada browser

   <img width="700" alt="contoh tampilan aplikasi" src="https://github.com/berlianalfd/APITesting/assets/97377702/fb2c9ce8-2a1c-4865-9168-324f23ef08fd">

   **Penjelasan**
   
   - **Summary** berisikan jumlah dari seluruh test, error, failure, skipped, success rate dan time
     
     <img width="700" alt="summary" src="https://github.com/berlianalfd/APITesting/assets/97377702/14cc0ba3-23e3-4ffb-bb3c-9152d821fd36)">
     
   - **Package List** berisikan list dari package serta list dari file test yang terdapat pada package tersebut. Kelompok kami membuat 4 file test pada package API yaitu CreateUserTest, UpdateUserTest, GetUserTest dan DeleteUserTest. Pada masing - masing file test terdapat jumlah dari seluruh test, error, failure, skipped, success rate dan time
     
     <img width="700" alt="packagelist" src="https://github.com/berlianalfd/APITesting/assets/97377702/f08256da-941c-47e9-ab69-728c08419d38">

        - File yang tidak memiliki kesalahan dari hasil test akan ditandai dengan icon  ![icon_success_sml](https://github.com/berlianalfd/JavaCalcApp/assets/143075674/35de3318-03aa-4f47-b138-c1878a6fbde6)
        
        - File yang memiliki kesalahan dari hasil test akan ditandai dengan icon  ![icon_warning_sml](https://github.com/berlianalfd/JavaCalcApp/assets/143075674/0c638baa-b3d8-4631-935a-016860d10987)
      
   - **Test Cases** berisikan list dari selurh test yang dilakukan pada setiap file test
     
     <img width="700" alt="testcases" src="https://github.com/berlianalfd/APITesting/assets/97377702/d92504a1-80b5-4a15-b9f9-e60fb0a54144">

       - Test dengan status **PASS** akan ditandai dengan icon  ![icon_success_sml](https://github.com/berlianalfd/JavaCalcApp/assets/143075674/35de3318-03aa-4f47-b138-c1878a6fbde6)
      
      - Test dengan status **FAIL** akan ditandai dengan icon  ![icon_error_sml](https://github.com/berlianalfd/JavaCalcApp/assets/143075674/74827540-a631-4957-8688-bba7b94b37df)
      
   - Test dengan status **FAIL** akan ditunjukkan dengan menampilkan kesalahan apa yang terjadi yaitu menampilkan expected nya bagaimana apa dan actual nya bagaimana.
  
     <img width="700" alt="tcfail" src="https://github.com/berlianalfd/APITesting/assets/97377702/d9e7baa6-f5ee-4df0-b324-b213d07448bc">
      
     Untuk mendapatkan infomasi lebih detail mengenai kesalahan yang sedang terjadi, dapat dilihat pada bagian **Failure Details**

     <img width="700" alt="detail error" src="https://github.com/berlianalfd/APITesting/assets/97377702/a4981196-6fb5-4339-8be5-61e9d5222ea9">



## Referensi      
https://maven.apache.org/surefire/maven-surefire-report-plugin/usage.html       
