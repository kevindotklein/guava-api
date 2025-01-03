package models

import (
	"time"

	"github.com/google/uuid"
	"gorm.io/gorm"
)

type User struct {
	ID        uuid.UUID	      `json:"id" gorm:"type:uuid;primaryKey"`
	Name			string					`json:"name"`	
	Email			string					`json:"email"`
	Password  string					`json:"-"`
	CreatedAt time.Time	     `json:"created_at" `
	UpdatedAt time.Time      `json:"updated_at" `
	DeletedAt gorm.DeletedAt `json:"-" gorm:"index"`
}

func (u *User) BeforeCreate(db *gorm.DB) (err error) {
	if u.ID == uuid.Nil {
		u.ID = uuid.New()
	}
	return
}

func (User) TableName() string {
	return "users"
}