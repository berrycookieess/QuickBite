
-- Menambahkan kolom yang dibutuhkan oleh entity Pelanggan
ALTER TABLE pelanggan
    ADD COLUMN email VARCHAR(255),
    ADD COLUMN nomor_telepon VARCHAR(255),
    ADD COLUMN alamat VARCHAR(255);

-- Menyesuaikan kolom yang dibutuhkan oleh entity Pembayaran
ALTER TABLE pembayaran
    RENAME COLUMN jumlah TO jumlah_bayar;

ALTER TABLE pembayaran
    RENAME COLUMN status TO status_bayar;

ALTER TABLE pembayaran
    ADD COLUMN metode VARCHAR(255),
    ADD COLUMN kode_referensi VARCHAR(255);

-- Menghapus kolom lama jika tidak digunakan oleh entity Java
ALTER TABLE pembayaran
    DROP COLUMN tanggal_pembayaran;