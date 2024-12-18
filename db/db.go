package db

import (
	"log"
	"time"

	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

var db *gorm.DB

func StartDB() {
	str := "host=localhost port=25432 user=admin dbname=guava sslmode=disable password=postgres"

	database, err := gorm.Open(postgres.Open(str), &gorm.Config{})
	if err != nil {
		log.Fatal("error: ", err)
	}

	db = database

	config, err := db.DB()
	if err != nil {
		log.Fatal("error: ", err)	
	}

	config.SetConnMaxIdleTime(10)
	config.SetMaxOpenConns(100)
	config.SetConnMaxLifetime(time.Hour)
}

func GetDatabase() *gorm.DB {
	return db
}