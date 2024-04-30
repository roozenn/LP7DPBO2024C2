# LP7DPBO2024C2

Desain Program:
1. **App Class (Main Class)**:
   - Merupakan kelas utama yang menangani tampilan aplikasi.
   - Meng-extends kelas `JFrame` untuk membuat jendela aplikasi.
   - Memiliki tiga komponen utama: `scoreLabel`, `startButton`, dan `exitButton`.
   - `scoreLabel`: JLabel untuk menampilkan skor permainan.
   - `startButton`: JButton untuk memulai permainan.
   - `exitButton`: JButton untuk keluar dari aplikasi.
   - Memiliki method `main()` sebagai entry point aplikasi.
   - Memiliki method `startApp()` untuk memulai permainan.
   - Memiliki method `setSkor(int skor)` untuk mengupdate label skor.
  
2. **FlappyBird Class**:
   - Merupakan kelas yang menggambarkan permainan Flappy Bird.
   - Meng-extends `JPanel` untuk menampilkan grafis permainan.
   - Menangani logika permainan seperti pergerakan burung dan rintangan.
   - Memiliki method `move()` untuk menggerakkan elemen permainan.
   - Memiliki method `RestartGame()` untuk mengulang permainan dari awal.
   - Memiliki method `placePipes()` untuk menempatkan rintangan di layar.
   - Menggunakan `Timer` untuk mengatur laju permainan dan kemunculan rintangan.
   - Menangani input dari pemain melalui implementasi `KeyListener`.
   
3. **Pipe Class**:
   - Merupakan kelas yang merepresentasikan rintangan dalam permainan.
   - Menyimpan informasi tentang posisi, ukuran, gambar, dan kecepatan rintangan.
   - Memiliki atribut boolean `passed` yang menandai apakah burung sudah melewati rintangan.
   
4. **Player Class**:
   - Merupakan kelas yang merepresentasikan pemain (burung) dalam permainan.
   - Menyimpan informasi tentang posisi, ukuran, dan gambar burung.
   - Memiliki atribut `velocityY` untuk menangani gravitasi dan kecepatan vertikal burung.
   
5. **App.form**:
   - File XML yang mengatur tata letak dan atribut komponen GUI (Graphical User Interface) menggunakan Java Swing.
   - Memuat informasi tentang penempatan, ukuran, dan atribut visual komponen GUI seperti `startButton` dan `exitButton`.
   
Alur Program:
1. Ketika aplikasi dimulai, `main()` method di kelas `App` akan dipanggil.
2. Sebuah instansiasi objek `App` akan dibuat, yang akan membuat jendela aplikasi.
3. Ketika tombol `startButton` ditekan, method `startApp()` di kelas `App` akan dipanggil.
4. Method `startApp()` akan membuat jendela permainan `FlappyBird` yang menampilkan skor dan panel permainan.
5. Panel permainan akan menangani logika permainan, termasuk pergerakan burung, penempatan rintangan, dan pembaruan skor.
6. Pemain dapat mengontrol pergerakan burung menggunakan tombol spasi dan dapat memulai ulang permainan dengan menekan tombol 'R'.
7. Ketika permainan berakhir (burung bertabrakan dengan rintangan atau batas layar), pesan "Game Over!" akan muncul dan permainan akan berhenti.
8. Pemain dapat menekan tombol keluar untuk keluar dari aplikasi.

![Screenshot (1728)](https://github.com/roozenn/LP7DPBO2024C2/assets/151520468/9aec28fd-26fe-4489-a231-cf8a1a0466e2)

