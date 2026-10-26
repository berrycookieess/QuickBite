CREATE TABLE pelanggan (
    id_pelanggan VARCHAR(255) PRIMARY KEY,
    nama VARCHAR(255)
);

CREATE TABLE menu (
    id_menu VARCHAR(255) PRIMARY KEY,
    nama_menu VARCHAR(255),
    harga DOUBLE PRECISION NOT NULL,
    stok INTEGER NOT NULL
);

CREATE TABLE pesanan (
    id_pesanan VARCHAR(255) PRIMARY KEY,
    tanggal TIMESTAMP,
    total_biaya DOUBLE PRECISION NOT NULL,
    status VARCHAR(50) NOT NULL,
    id_pelanggan VARCHAR(255) NOT NULL,
    CONSTRAINT fk_pesanan_pelanggan
        FOREIGN KEY (id_pelanggan)
        REFERENCES pelanggan(id_pelanggan)
);

CREATE TABLE item_pesanan (
    id_item VARCHAR(255) PRIMARY KEY,
    jumlah INTEGER NOT NULL,
    subtotal DOUBLE PRECISION NOT NULL,
    id_pesanan VARCHAR(255) NOT NULL,
    id_menu VARCHAR(255) NOT NULL,
    CONSTRAINT fk_item_pesanan
        FOREIGN KEY (id_pesanan)
        REFERENCES pesanan(id_pesanan),
    CONSTRAINT fk_item_menu
        FOREIGN KEY (id_menu)
        REFERENCES menu(id_menu)
);

CREATE TABLE pembayaran (
    id_pembayaran VARCHAR(255) PRIMARY KEY,
    jumlah DOUBLE PRECISION NOT NULL,
    tanggal_pembayaran TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    id_pesanan VARCHAR(255) NOT NULL UNIQUE,
    CONSTRAINT fk_pembayaran_pesanan
        FOREIGN KEY (id_pesanan)
        REFERENCES pesanan(id_pesanan)
);
