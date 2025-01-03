package db

import (
	"fmt"
	"log"
	"time"

	"github.com/kevindotklein/guava-api/config"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

var db *gorm.DB

func StartDB() {
	str := fmt.Sprintf(
				"host=%s port=%s user=%s dbname=%s sslmode=disable password=%s",
				config.GetEnv("DB_HOST", "localhost"),
				config.GetEnv("DB_PORT", "25432"),
				config.GetEnv("DB_USER", "admin"),
				config.GetEnv("DB_NAME", "guava"),
				config.GetEnv("DB_PASSWORD", "postgres"))

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