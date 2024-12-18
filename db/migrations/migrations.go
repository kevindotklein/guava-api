package migrations

import (
	"github.com/kevindotklein/guava-api/models"
	"gorm.io/gorm"
)

func RunMigrations(db *gorm.DB) {
	db.AutoMigrate(&models.Post{})
}