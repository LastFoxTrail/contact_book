CREATE DATABASE IF NOT EXISTS contacts_book;

USE contacts_book;

CREATE TABLE contacts (
    `id` BIGINT AUTO_INCREMENT,
    `name` VARCHAR(32) NOT NULL,
    `surname` VARCHAR(32),
    `adress` VARCHAR(255),
    `phone_number` VARCHAR(13) NOT NULL UNIQUE,
    PRIMARY KEY(`id`)
);