package models

import (
	"time"

	"github.com/google/uuid"
	"gorm.io/gorm"
)

type Post struct {
	ID uuid.UUID 				`json:"id" gorm:"type:uuid;primaryKey"`
	Title string 				`json:"title" `
	Content string 				`json:"content" `
	CoverURL string 			`json:"cover_url"`
	CreatedAt time.Time 		`json:"created_at" `
	UpdatedAt time.Time 		`json:"updated_at" `
	DeletedAt gorm.DeletedAt 	`json:"-" gorm:"index"`
}

func (p *Post) BeforeCreate(db *gorm.DB) (err error) {
	if p.ID == uuid.Nil {
		p.ID = uuid.New()
	}
	return
}

func (Post) TableName() string {
	return "posts"
}